package com.idea.plugin.applescript.psi.sdef.impl;

import com.idea.plugin.applescript.AppleScriptLanguage;
import com.idea.plugin.applescript.lang.AppleScriptComponentType;
import com.idea.plugin.applescript.lang.ide.AppleScriptDocHelper;
import com.idea.plugin.applescript.lang.sdef.*;
import com.idea.plugin.applescript.lang.sdef.parser.SDEF_Parser;
import com.idea.plugin.applescript.psi.AppleScriptExpression;
import com.idea.plugin.applescript.psi.AppleScriptIdentifier;
import com.idea.plugin.applescript.psi.impl.AppleScriptElementPresentation;
import com.idea.plugin.applescript.psi.sdef.DictionaryIdentifier;
import com.intellij.lang.Language;
import com.intellij.navigation.ItemPresentation;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.SystemInfo;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.impl.FakePsiElement;
import com.intellij.psi.xml.*;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by Andrey on 01.07.2015.
 */
public class ApplicationDictionaryImpl extends FakePsiElement implements ApplicationDictionary {

  public static final Logger LOG = Logger.getInstance("#" + ApplicationDictionaryImpl.class.getName());

  //todo add suites: several class unique only within a suite !
  @NotNull private final Project project;
  @NotNull private final VirtualFile applicationFile;
  //cachedLibraryXmlFile is needed for navigation from PSI (getParent()) if dictionary was created from .app bundle
  @NotNull private VirtualFile cachedLibraryXmlFile;
  @NotNull private final List<PsiFile> includedFiles = new ArrayList<PsiFile>();
  @NotNull private String applicationName;
  @NotNull private String displayName;
  private XmlTag myRootTag;

  private final List<Suite> mySuites = new ArrayList<Suite>();
  private final Map<String, AppleScriptPropertyDefinition> dictionaryPropertyMap = new HashMap<String,
          AppleScriptPropertyDefinition>();
  private final Map<String, DictionaryRecord> dictionaryRecordMap = new HashMap<String, DictionaryRecord>();
  private final Map<String, DictionaryEnumerator> dictionaryEnumeratorMap = new HashMap<String, DictionaryEnumerator>();
  private final Map<String, DictionaryEnumeration> dictionaryEnumerationMap = new HashMap<String,
          DictionaryEnumeration>();
  private final Map<String, AppleScriptCommand> dictionaryCommandMap = new HashMap<String, AppleScriptCommand>();
  private final Map<String, AppleScriptClass> dictionaryClassMap = new HashMap<String, AppleScriptClass>();
  private final Map<String, AppleScriptClass> dictionaryClassToPluralNameMap = new HashMap<String, AppleScriptClass>();
  private final Map<String, AppleScriptClass> dictionaryClassByCodeMap = new HashMap<String, AppleScriptClass>();

  public ApplicationDictionaryImpl(@NotNull Project project, @NotNull VirtualFile applicationBundleFile,
                                   @NotNull String applicationName) {
    this.project = project;
    this.applicationFile = applicationBundleFile;
    this.applicationName = applicationName;
    readDictionaryFromApplicationBundle();
    if (StringUtil.isEmpty(displayName))
      displayName = this.applicationName;
    System.out.println("=== Dictionary [" + displayName + "] for application [" + this.applicationName + "] " +
            "initialized " +
            "In project[" + project.getName() + "] " + "====" +
            " Commands: " + dictionaryCommandMap.size() + ". " + "Classes: " + dictionaryClassMap.size() + "\n");
    LOG.info("=== Dictionary [" + displayName + "] for application [" + this.applicationName + "] " +
            "initialized " +
            "In project[" + project.getName() + "] " + "====" +
            " Commands: " + dictionaryCommandMap.size() + ". " + "Classes: " + dictionaryClassMap.size() + "\n");
  }

  private void readDictionaryFromApplicationBundle() {
    if (!extensionSupported(applicationFile.getExtension())) return;
    if ("xml".equalsIgnoreCase(applicationFile.getExtension())
            || "sdef".equalsIgnoreCase(applicationFile.getExtension())) {
      readDictionaryFromXmlFile(applicationFile);
    } else {
      readDictionaryFromApplicationBundle(applicationFile, project);
    }
  }

  public PsiFile processInclude(@NotNull VirtualFile fileInclude) {
    PsiFile psiFile = PsiManager.getInstance(project).findFile(fileInclude);
    XmlFile xmlFile = (XmlFile) psiFile;
    if (xmlFile != null && xmlFile.isValid()) {
      final XmlDocument document = xmlFile.getDocument();
      if (document != null) {
        final XmlTag rootTag = document.getRootTag();
        if (rootTag != null) {
          SDEF_Parser.parseRootTag(this, rootTag);
        }
      }
      includedFiles.add(xmlFile);
      System.out.println("Processed included file: " + psiFile);
      LOG.info("Processed included file:: " + psiFile);
    }
    return psiFile;
  }

  @NotNull
  @Override
  public VirtualFile getCachedLibraryXmlFile() {
    return cachedLibraryXmlFile;
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

  @Override
  @NotNull
  public VirtualFile getApplicationFile() {
    return applicationFile;
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

  private void readDictionaryFromApplicationBundle(@NotNull VirtualFile applicationFile, @NotNull Project project) {
    if (!SystemInfo.isMac) return;
    final String pathPrefix = FileUtil.getTempDirectory() + '/';
    final String fileName = applicationFile.getNameWithoutExtension().replace(" ", "_");
    final String finalFilePath = pathPrefix + fileName + "_generated.xml";
    final String appFileFinalPath = '"' + applicationFile.getPath() + '"';
//    todo add detection of .sdef files as xml file types
    String[] shellCommand = new String[]{"/bin/bash", "-c", " sdef " + appFileFinalPath + " > " +
            finalFilePath};
    try {
      System.out.println("executing command: " + Arrays.toString(shellCommand));
      LOG.info("executing command: " + Arrays.toString(shellCommand));

      long execStart = System.currentTimeMillis();
      int exitCode = Runtime.getRuntime().exec(shellCommand).waitFor();
      long execEnd = System.currentTimeMillis();

      System.out.println("Exit code = " + exitCode + " Execution time: " + (execEnd - execStart) + " ms.");
      LOG.info("Exit code = " + exitCode + " Execution time: " + (execEnd - execStart) + " ms.");

      File finalXmlFile = new File(finalFilePath);
      VirtualFile virtualXmlFile = LocalFileSystem.getInstance().findFileByIoFile(finalXmlFile);
      readDictionaryFromXmlFile(virtualXmlFile);
      finalXmlFile.deleteOnExit();
    } catch (IOException e1) {
      e1.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
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

  @NotNull
  @Override
  public List<AppleScriptCommand> findAllCommandsWithName(String name) {
    List<AppleScriptCommand> result = new ArrayList<AppleScriptCommand>();
    for (AppleScriptCommand command : dictionaryCommandMap.values()) {
      if (command.getName().equals(name)) {
        result.add(command);
      }
    }
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
    AppleScriptComponentType componentType = AppleScriptComponentType.typeOf(this);
    return componentType != null ? componentType.getIcon() : null;
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
    sb.append(getType()).append(" <b>").append(getDisplayName()).append("</b>");
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
  public boolean isGlobal() {
    return false;
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
  public boolean isComposite() {
    return false;
  }

  @Override
  public boolean isResolveTarget() {
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
    return getDisplayName();
  }

  @Override
  @NotNull
  public String getApplicationName() {
    return applicationName;
  }

  @Override
  public void setDisplayName(@NotNull String displayName) {
    this.displayName = displayName;
  }

  @Override
  @NotNull
  public String getDisplayName() {
    return displayName;
  }

  @Override
  public PsiElement setName(@NonNls @NotNull String name) throws IncorrectOperationException {
    displayName = name;
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
    return PsiManager.getInstance(getProject()).findFile(cachedLibraryXmlFile);
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

  @NotNull
  @Override
  public ApplicationDictionary getDictionary() {
    return this;
  }

  private void readDictionaryFromXmlFile(VirtualFile virtualFile) {
    if (virtualFile != null) {
      PsiFile psiFile = PsiManager.getInstance(project).findFile(virtualFile);
      XmlFile xmlFile = (XmlFile) psiFile;
      if (xmlFile != null && xmlFile.isValid()) {
        setRootTag(xmlFile.getRootTag());
        SDEF_Parser.parse(xmlFile, this);
        cachedLibraryXmlFile = virtualFile;

        System.out.println("dictionary loaded. Virtual file: " + virtualFile);
        LOG.info("Dictionary loaded. Virtual file: " + virtualFile);
      }
    }
  }


  public static boolean extensionSupported(String extension) {
    return extension != null && SUPPORTED_EXTENSIONS.contains(extension.toLowerCase());
  }

  @NotNull
  @Override
  public AppleScriptIdentifier getIdentifier() {
    DictionaryIdentifier myIdentifier = null;
    XmlAttribute titleAttr = myRootTag.getAttribute("title");
    if (titleAttr != null) {
      XmlAttributeValue attrValue = titleAttr.getValueElement();
      if (attrValue != null) {
        myIdentifier = new DictionaryIdentifierImpl(this, getDisplayName(), attrValue);
      }
    }
    return myIdentifier != null ? myIdentifier : new DictionaryIdentifierImpl(this, getDisplayName(), myRootTag);
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
}
