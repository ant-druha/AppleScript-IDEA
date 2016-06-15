package com.intellij.plugin.applescript.psi.sdef.impl;

import com.btr.proxy.util.PListParser;
import com.intellij.lang.Language;
import com.intellij.navigation.ItemPresentation;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.plugin.applescript.AppleScriptIcons;
import com.intellij.plugin.applescript.AppleScriptLanguage;
import com.intellij.plugin.applescript.lang.ide.AppleScriptDocHelper;
import com.intellij.plugin.applescript.lang.sdef.*;
import com.intellij.plugin.applescript.lang.sdef.parser.SDEF_Parser;
import com.intellij.plugin.applescript.psi.AppleScriptExpression;
import com.intellij.plugin.applescript.psi.AppleScriptIdentifier;
import com.intellij.plugin.applescript.psi.impl.AppleScriptElementPresentation;
import com.intellij.plugin.applescript.psi.sdef.DictionaryIdentifier;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.impl.FakePsiElement;
import com.intellij.psi.xml.*;
import com.intellij.util.IncorrectOperationException;
import com.intellij.util.ui.JBImageIcon;
import com.intellij.util.ui.JBUI;
import org.apache.sanselan.ImageReadException;
import org.apache.sanselan.formats.icns.IcnsImageParser;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

/**
 * Andrey 01.07.2015
 */
public class ApplicationDictionaryImpl extends FakePsiElement implements ApplicationDictionary {

  public static final Logger LOG = Logger.getInstance("#" + ApplicationDictionaryImpl.class.getName());

  @NotNull private final Project project;
  @NotNull private final VirtualFile dictionaryFile;
  @Nullable private File applicationBundleFile;
  @Nullable private Icon applicationIcon;
  @NotNull private final List<PsiFile> includedFiles = new ArrayList<PsiFile>();
  @NotNull private String applicationName;
  @NotNull private String dictionaryName;
  @Nullable private String documentation;

  private XmlTag myRootTag;
  private final List<Suite> mySuites = new ArrayList<Suite>();
  private final Map<String, AppleScriptPropertyDefinition> dictionaryPropertyMap = new HashMap<String,
          AppleScriptPropertyDefinition>();
  private final Map<String, DictionaryRecord> dictionaryRecordMap = new HashMap<String, DictionaryRecord>();
  private final Map<String, DictionaryEnumerator> dictionaryEnumeratorMap = new HashMap<String, DictionaryEnumerator>();
  private final Map<String, DictionaryEnumeration> dictionaryEnumerationMap = new HashMap<String,
          DictionaryEnumeration>();
  private final Map<String, AppleScriptCommand> dictionaryCommandMap = new HashMap<String, AppleScriptCommand>();
  private final Set<AppleScriptCommand> dictionaryCommands = new LinkedHashSet<AppleScriptCommand>();
  private final Map<String, AppleScriptClass> dictionaryClassMap = new HashMap<String, AppleScriptClass>();
  private final Map<String, AppleScriptClass> dictionaryClassToPluralNameMap = new HashMap<String, AppleScriptClass>();
  private final Map<String, AppleScriptClass> dictionaryClassByCodeMap = new HashMap<String, AppleScriptClass>();

  public ApplicationDictionaryImpl(@NotNull Project project, @NotNull XmlFile dictionaryXmlFile,
                                   @NotNull String applicationName, @Nullable File applicationBundleFile) {
    this.project = project;
    this.dictionaryFile = dictionaryXmlFile.getVirtualFile();
    readDictionaryFromXmlFile(dictionaryXmlFile);
    this.applicationName = applicationName;
    if (applicationBundleFile != null) {
      this.applicationBundleFile = applicationBundleFile;
      setIconFromBundle(applicationBundleFile);
    }
    if (StringUtil.isEmpty(dictionaryName))
      dictionaryName = this.applicationName;
    LOG.info("Dictionary [" + dictionaryName + "] for application [" + this.applicationName + "] " +
            "initialized In project[" + project.getName() + "] " + " Commands: " + dictionaryCommandMap.size() +
            ". " + "Classes: " + dictionaryClassMap.size());
  }

  /**
   * Set icon for dictionary as application icon
   *
   * @param applicationBundleFile {@link File} of the application bundle
   */
  private void setIconFromBundle(@NotNull File applicationBundleFile) {
    try {
      final String appUrl = applicationBundleFile.getPath();
      File file = new File(appUrl + "/Contents/Info.plist");
      if (!file.exists() || file.isDirectory()) return;
      PListParser.Dict dict = null;
      try {
        dict = PListParser.load(file);
      } catch (PListParser.XmlParseException e) {
        LOG.warn("Can not parse Info.plist for " + applicationName + ": " + e.getMessage());
      } catch (IOException e) {
        LOG.warn("Can not parse Info.plist for " + applicationName + ": " + e.getMessage());
      }
      Object imgFilename = null;
      if (dict != null) {
        imgFilename = dict.get("CFBundleIconFile");
      }
      if (imgFilename == null) {
        imgFilename = applicationName; //trying to guess
      }
      String fileName = imgFilename.toString();
      fileName = fileName.endsWith(".icns") ? fileName : fileName + ".icns";

      File icnsFile = new File(appUrl + "/Contents/Resources/" + fileName);

      if (!icnsFile.exists() || icnsFile.isDirectory()) return;

      IcnsImageParser parser = new IcnsImageParser();

      // TODO: 25/12/15 check for proper memory usage management
      @SuppressWarnings("unchecked")
      List<BufferedImage> list = parser.getAllBufferedImages(icnsFile);
      if (list == null || list.size() == 0) return;
//      boolean isHiDpi = JBUI.isHiDPI();
//      boolean retina = UIUtil.isRetina();
//      UIUtil.drawImage();
      int index = list.size() > 1 ? list.size() - 1 : 0;
      int size = JBUI.scale(13);
      Image img = list.get(index).getScaledInstance(size, size, Image.SCALE_SMOOTH);
      applicationIcon = new JBImageIcon(img);
    } catch (ImageReadException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public PsiFile processInclude(@NotNull XmlFile xmlFile) {
    if (xmlFile.isValid()) {
      final XmlDocument document = xmlFile.getDocument();
      if (document != null) {
        final XmlTag rootTag = document.getRootTag();
        if (rootTag != null) {
          SDEF_Parser.parseRootTag(this, rootTag);
        }
      }
      includedFiles.add(xmlFile);
      System.out.println("Processed included file: " + xmlFile);
      LOG.debug("Processed included file:: " + xmlFile);
    }
    return xmlFile;
  }

  @NotNull
  @Override
  public Project getProject() {
    return project;
  }

  @Override
  public boolean addSuite(Suite suite) {
    return suite != null && mySuites.add(suite);
  }

  @NotNull
  public VirtualFile getDictionaryFile() {
    return dictionaryFile;
  }

  @NotNull
  @Override
  public Map<String, DictionaryEnumeration> getDictionaryEnumerationMap() {
    return dictionaryEnumerationMap;
  }

  @NotNull
  @Override
  public Map<String, DictionaryEnumerator> getDictionaryEnumeratorMap() {
    return dictionaryEnumeratorMap;
  }

  @NotNull
  public Map<String, DictionaryRecord> getDictionaryRecordMap() {
    return dictionaryRecordMap;
  }

  @NotNull
  @Override
  public Map<String, AppleScriptCommand> getDictionaryCommandMap() {
    return dictionaryCommandMap;
  }

  @NotNull
  @Override
  public Map<String, AppleScriptClass> getDictionaryClassMap() {
    return dictionaryClassMap;
  }

  @Nullable
  @Override
  public AppleScriptClass findClass(@Nullable String name) {
    return dictionaryClassMap.get(name);
  }

  @Override
  public List<String> getParameterNamesForCommand(String name) {
    AppleScriptCommand command = dictionaryCommandMap.get(name);
    return command != null ? command.getParameterNames() : null;
  }

  @Nullable
  @Override
  public CommandDirectParameter findDirectParameterForCommand(String commandName) {
    AppleScriptCommand command = dictionaryCommandMap.get(commandName);
    return command != null ? command.getDirectParameter() : null;
  }

  @Nullable
  @Override
  public AppleScriptPropertyDefinition findProperty(String name) {
    return dictionaryPropertyMap.get(name);
  }

  // TODO: 06/12/15 redefine equals and hash code for AppleScriptCommand and store HashSet, not the Map
  @NotNull
  @Override
  public List<AppleScriptCommand> findAllCommandsWithName(String name) {
    List<AppleScriptCommand> result = new ArrayList<AppleScriptCommand>(1);
    AppleScriptCommand command = dictionaryCommandMap.get(name);
    if (command != null) result.add(dictionaryCommandMap.get(name));
//    dictionaryCommands
//    for (AppleScriptCommand command : dictionaryCommandMap.values()) {
//      if (command.getName().equals(name)) {
//        result.add(command);
//      }
//    }
    return result;
  }


  @Nullable
  @Override
  public DictionaryEnumerator findEnumerator(String name) {
    return dictionaryEnumeratorMap.get(name);
  }


  @Nullable
  @Override
  public AppleScriptClass findClassByPluralName(String pluralForm) {
    return dictionaryClassToPluralNameMap.get(pluralForm);
  }

  @Nullable
  @Override
  public DictionaryEnumeration findEnumeration(String name) {
    return dictionaryEnumerationMap.get(name);
  }

  @Override
  public boolean addCommand(AppleScriptCommand command) {
    return dictionaryCommandMap.put(command.getName(), command) == null;
  }

  @Override
  public boolean addClass(AppleScriptClass appleScriptClass) {
    Object val = dictionaryClassMap.put(appleScriptClass.getName(), appleScriptClass);
    dictionaryClassByCodeMap.put(appleScriptClass.getCode(), appleScriptClass);
    dictionaryClassToPluralNameMap.put(appleScriptClass.getPluralClassName(), appleScriptClass);
    for (AppleScriptPropertyDefinition property : appleScriptClass.getProperties()) {
      addProperty(property);
    }
    return val == null;
  }

  @Nullable
  @Override
  public Icon getIcon(boolean open) {
    return applicationIcon != null ? applicationIcon : AppleScriptIcons.OPEN_DICTIONARY;
  }

  @Override
  public ItemPresentation getPresentation() {
    return new AppleScriptElementPresentation(this);
  }

  @Nullable
  @Override
  public AppleScriptClass findClassByCode(String code) {
    return dictionaryClassByCodeMap.get(code);
  }

  @Override
  public boolean addProperty(AppleScriptPropertyDefinition property) {
    return dictionaryPropertyMap.put(property.getName(), property) == null;
  }

  @Override
  public boolean addEnumeration(DictionaryEnumeration enumeration) {
    Object val = dictionaryEnumerationMap.put(enumeration.getName(), enumeration);
    for (DictionaryEnumerator enumerator : enumeration.getEnumerators()) {
      dictionaryEnumeratorMap.put(enumerator.getName(), enumerator);
    }
    return val == null;
  }

  @NotNull
  @Override
  public String getDocumentation() {
    StringBuilder sb = new StringBuilder();
    sb.append(getType()).append(" <b>").append(getName()).append("</b>");
    sb.append("<p>");
    for (Suite suite : mySuites) {
      sb.append("<br>    <b>");
      AppleScriptDocHelper.appendElementLink(sb, suite, suite.getName());
      sb.append("</b><br>");
    }
    sb.append("</p>");
    return sb.toString();
  }

  @Nullable
  @Override
  public String getCode() {
    return null;
  }

  @Nullable
  @Override
  public String getCocoaClassName() {
    return null;
  }

  @Override
  public boolean isScriptProperty() {
    return false;
  }

  @Override
  public boolean isHandler() {
    return false;
  }

  @Nullable
  @Override
  public PsiElement getOriginalDeclaration() {
    return null;
  }

  @Override
  public boolean isObjectProperty() {
    return false;
  }

  @Override
  public boolean isVariable() {
    return false;
  }

  @Nullable
  @Override
  public AppleScriptExpression findAssignedValue() {
    return null;
  }

  @Override
  @NotNull
  public String getName() {
    return dictionaryName;
  }

  @Override
  @NotNull
  public String getApplicationName() {
    return applicationName;
  }

  @Override
  public PsiElement setName(@NonNls @NotNull String name) throws IncorrectOperationException {
    dictionaryName = name;
    return this;
  }

  @NotNull
  @Override
  public List<String> getNameIdentifiers() {
    return Arrays.asList(applicationName.split("\\s+"));
  }

  @NotNull
  @Override
  public String getQualifiedPath() {
    return "dictionary:" + getName() + "/" + getQualifiedName();
  }

  @NotNull
  @Override
  public String getQualifiedName() {
    return getType() + ":" + getCode();
  }

  @Nullable
  @Override
  public String getDescription() {
    return null;
  }

  @NotNull
  @Override
  public Language getLanguage() {
    return AppleScriptLanguage.INSTANCE;
  }

  @NotNull
  @Override
  public Map<String, AppleScriptPropertyDefinition> getDictionaryPropertyMap() {
    return dictionaryPropertyMap;
  }

  @Override
  public void addRecord(DictionaryRecord record) {
    dictionaryRecordMap.put(record.getName(), record);
    for (AppleScriptPropertyDefinition prop : record.getProperties()) {
      dictionaryPropertyMap.put(prop.getName(), prop);
    }
  }


  @Override
  public PsiElement getParent() {
    return PsiManager.getInstance(getProject()).findFile(getDictionaryFile());
  }

  @Nullable
  @Override
  public Suite getSuite() {
    return null;
  }

  @Nullable
  @Override
  public DictionaryComponent getDictionaryParentComponent() {
    return null;
  }

  @NotNull
  @Override
  public String getType() {
    return "dictionary";
  }

  @Override
  public void setDescription(String description) {

  }

  @Override
  public void setDictionaryDoc(@Nullable String documentation) {
    this.documentation = documentation;
  }

  @NotNull
  @Override
  public ApplicationDictionary getDictionary() {
    return this;
  }

  private void readDictionaryFromXmlFile(@NotNull XmlFile xmlFile1) {
    if (xmlFile1.isValid()) {
      setRootTag(xmlFile1.getRootTag());
      SDEF_Parser.parse(xmlFile1, this);
      LOG.debug("Dictionary loaded. Virtual file: " + xmlFile1);
    }
  }


  public static boolean extensionSupported(String extension) {
    return extension != null && SUPPORTED_DICTIONARY_EXTENSIONS.contains(extension.toLowerCase());
  }

  @NotNull
  @Override
  public AppleScriptIdentifier getIdentifier() {
    DictionaryIdentifier myIdentifier = null;
    XmlAttribute titleAttr = myRootTag.getAttribute("title");
    if (titleAttr != null) {
      XmlAttributeValue attrValue = titleAttr.getValueElement();
      if (attrValue != null) {
        myIdentifier = new DictionaryIdentifierImpl(this, getName(), attrValue);
      }
    }
    return myIdentifier != null ? myIdentifier : new DictionaryIdentifierImpl(this, getName(), myRootTag);
  }

  @Nullable
  @Override
  public PsiElement getNameIdentifier() {
    return getIdentifier();
  }

  public ApplicationDictionary setRootTag(XmlTag myRootTag) {
    this.myRootTag = myRootTag;
    return this;
  }

  @Override
  public XmlTag getRootTag() {
    return myRootTag;
  }

  @Nullable
  @Override
  public Suite findSuiteByName(String suiteName) {
    if (suiteName == null) return null;
    for (Suite suite : mySuites) {
      if (suiteName.equals(suite.getName())) {
        return suite;
      }
    }
    return null;
  }

  @Nullable
  @Override
  public Suite findSuiteByCode(String suiteCode) {
    if (suiteCode == null) return null;
    for (Suite suite : mySuites) {
      if (suiteCode.equals(suite.getCode())) {
        return suite;
      }
    }
    return null;
  }

  @Nullable
  @Override
  public AppleScriptCommand findCommand(String name) {
    return dictionaryCommandMap.get(name);
  }

  @NotNull
  @Override
  public Collection<AppleScriptCommand> getAllCommands() {
    return dictionaryCommandMap.values();
  }

  @Nullable
  public File getApplicationBundle() {
    return applicationBundleFile;
  }
}
