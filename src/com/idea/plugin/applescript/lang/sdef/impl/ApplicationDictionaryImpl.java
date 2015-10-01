package com.idea.plugin.applescript.lang.sdef.impl;

import com.idea.plugin.applescript.AppleScriptLanguage;
import com.idea.plugin.applescript.lang.AppleScriptComponentType;
import com.idea.plugin.applescript.lang.ide.AppleScriptDocHelper;
import com.idea.plugin.applescript.lang.parser.ScriptSuiteRegistryHelper;
import com.idea.plugin.applescript.lang.sdef.*;
import com.idea.plugin.applescript.lang.sdef.parser.SDEF_Parser;
import com.idea.plugin.applescript.psi.AppleScriptExpression;
import com.idea.plugin.applescript.psi.AppleScriptIdentifier;
import com.idea.plugin.applescript.psi.impl.AppleScriptElementPresentation;
import com.idea.plugin.applescript.psi.sdef.DictionaryIdentifier;
import com.idea.plugin.applescript.psi.sdef.impl.DictionaryIdentifierImpl;
import com.intellij.lang.Language;
import com.intellij.navigation.ItemPresentation;
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
import com.intellij.psi.xml.XmlAttribute;
import com.intellij.psi.xml.XmlAttributeValue;
import com.intellij.psi.xml.XmlFile;
import com.intellij.psi.xml.XmlTag;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by Andrey on 01.07.2015.
 */
public class ApplicationDictionaryImpl extends FakePsiElement implements ApplicationDictionary,
        ScriptSuiteRegistryHelper {

  //todo add suites: several class unique only within a suite !
  @NotNull private final Project project;
  @NotNull private final VirtualFile applicationFile;
  @NotNull private String name;
  private XmlTag myRootTag;

  private final List<Suite> mySuites = new ArrayList<Suite>();
  private final List<AppleScriptCommand> dictionaryCommandList = new ArrayList<AppleScriptCommand>();
  private List<AppleScriptPropertyDefinition> dictionaryPropertyList = new ArrayList<AppleScriptPropertyDefinition>();
  private final Map<String, AppleScriptPropertyDefinition> dictionaryPropertyMap = new HashMap<String,
          AppleScriptPropertyDefinition>();
  private final List<DictionaryRecord> dictionaryRecordList = new ArrayList<DictionaryRecord>();
  private final List<DictionaryEnumeration> dictionaryEnumerationList = new ArrayList<DictionaryEnumeration>();
  private final Map<String, DictionaryEnumerator> dictionaryEnumeratorMap = new HashMap<String, DictionaryEnumerator>();
  private final Map<String, DictionaryEnumeration> dictionaryEnumerationMap = new HashMap<String,
          DictionaryEnumeration>();
  private final Map<String, AppleScriptCommand> dictionaryCommandMap = new HashMap<String, AppleScriptCommand>();
  private final List<AppleScriptClass> dictionaryClassList = new ArrayList<AppleScriptClass>();
  private final Map<String, AppleScriptClass> dictionaryClassMap = new HashMap<String, AppleScriptClass>();
  private final Map<String, AppleScriptClass> dictionaryClassToPluralNameMap = new HashMap<String, AppleScriptClass>();
  private final Map<String, AppleScriptClass> dictionaryClassByCodeMap = new HashMap<String, AppleScriptClass>();

  public ApplicationDictionaryImpl(@NotNull Project project, @NotNull VirtualFile applicationBundleFile) {
    this.project = project;
    this.applicationFile = applicationBundleFile;
    readDictionaryFromApplicationBundle();
    if (StringUtil.isEmpty(name))
      setName(applicationBundleFile.getPath());
    System.out.println("Dictionary ===" + name + "=== initialized. Commands: " + dictionaryCommandList.size() + ". " +
            "Classes: " +
            dictionaryClassList.size() + "\n");
  }

  private void readDictionaryFromApplicationBundle() {
    if (!extensionSupported(applicationFile.getExtension())) return;
    if ("xml".equalsIgnoreCase(applicationFile.getExtension())) {
      readDictionaryFromXmlFile(applicationFile);
    } else {
      readDictionaryFromApplicationBundle(applicationFile, project);
    }
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

  @Override
  public List<DictionaryEnumeration> getDictionaryEnumerationList() {
    return dictionaryEnumerationList;
  }

  @Override
  public List<DictionaryRecord> getDictionaryRecordList() {
    return dictionaryRecordList;
  }

  @Override
  public Map<String, AppleScriptCommand> getDictionaryCommandMap() {
    return dictionaryCommandMap;
  }

  @Override
  public List<AppleScriptCommand> getDictionaryCommandList() {
    return dictionaryCommandList;
  }

  @Override
  public List<AppleScriptClass> getDictionaryClassList() {
    return dictionaryClassList;
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
      long execStart = System.currentTimeMillis();
      int exitCode = Runtime.getRuntime().exec(shellCommand).waitFor();
      long execEnd = System.currentTimeMillis();
      System.out.println("Exit code = " + exitCode + " Execution time: " + (execEnd - execStart) + " ms.");
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

  @Nullable
  @Override
  public ApplicationDictionary findDictionaryByName(String name) {
    return this;
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
  public AppleScriptCommand findCommandWithName(String name) {
    return dictionaryCommandMap.get(name);
  }

  @Nullable
  @Override
  public AppleScriptPropertyDefinition findPropertyWithName(String name) {
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

  @NotNull
  @Override
  public List<AppleScriptCommand> findCommandsStartingWithName(String name) {
    final List<AppleScriptCommand> result = new ArrayList<AppleScriptCommand>();
    for (AppleScriptCommand command : dictionaryCommandMap.values()) {
      if (startsWithWord(command.getName(), name)) {
        result.add(command);
      }
    }
    return result;
  }

  @Override
  public List<AppleScriptClass> findClassesStartingWithName(String name) {
    List<AppleScriptClass> result = new ArrayList<AppleScriptClass>();
    for (AppleScriptClass clazz : dictionaryClassMap.values()) {
      if (startsWithWord(clazz.getName(), name)) {
        result.add(clazz);
      }
    }
    return result;
  }

  @Override
  public List<AppleScriptClass> findClassesStartingWithPluralName(String pluralForm) {
    final List<AppleScriptClass> result = new ArrayList<AppleScriptClass>();
    for (AppleScriptClass clazz : dictionaryClassMap.values()) {
      if (startsWithWord(clazz.getPluralClassName(), pluralForm)) {
        result.add(clazz);
      }
    }
    return result;
  }

  @Override
  public List<DictionaryEnumerator> findConstantsStartingWithWord(String name) {
    List<DictionaryEnumerator> result = new ArrayList<DictionaryEnumerator>();
    for (DictionaryEnumerator constantEnum : dictionaryEnumeratorMap.values()) {
      if (startsWithWord(constantEnum.getName(), name)) {
        result.add(constantEnum);
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
  public AppleScriptClass findClassWithName(String name) {
    return dictionaryClassMap.get(name);
  }

  @Nullable
  @Override
  public AppleScriptClass findClassByPluralName(String pluralForm) {
    return dictionaryClassToPluralNameMap.get(pluralForm);
  }

  @Nullable
  @Override
  public DictionaryEnumeration findEnumerationWithName(String name) {
    return dictionaryEnumerationMap.get(name);
  }

  @NotNull
  @Override
  public Collection<AppleScriptCommand> getAllCommandsFromDictionary(String dictionaryName) {
    return dictionaryCommandMap.values();
  }

  @Override
  public List<AppleScriptCommand> geAllCommandsForSuiteRegistry() {
    return null;
  }

  @Override
  public List<AppleScriptPropertyDefinition> findPropertiesStartingWithName(String name) {
    final List<AppleScriptPropertyDefinition> result = new ArrayList<AppleScriptPropertyDefinition>();
    for (AppleScriptPropertyDefinition prop : dictionaryPropertyMap.values()) {//todo some faster util method?
      if (startsWithWord(prop.getName(), name)) {
        result.add(prop);
      }
    }
    return result;
  }

  @Override
  public boolean addCommand(AppleScriptCommand command) {
    dictionaryCommandMap.put(command.getName(), command);
    dictionaryCommandList.add(command);
    return true;
  }

  @Override
  public boolean addClass(AppleScriptClass appleScriptClass) {
    dictionaryClassMap.put(appleScriptClass.getName(), appleScriptClass);
    dictionaryClassByCodeMap.put(appleScriptClass.getCode(), appleScriptClass);
    dictionaryClassToPluralNameMap.put(appleScriptClass.getPluralClassName(), appleScriptClass);
    for (AppleScriptPropertyDefinition property : appleScriptClass.getProperties()) {
      addProperty(property);
    }
    return dictionaryClassList.add(appleScriptClass);
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

  @Override
  @Nullable
  public AppleScriptClass findClassByName(String name) {
    return dictionaryClassMap.get(name);
  }

  @Nullable
  @Override
  public AppleScriptClass findClassByCode(String code) {
    return dictionaryClassByCodeMap.get(code);
  }

  @Override
  public boolean addProperty(AppleScriptPropertyDefinition property) {
    dictionaryPropertyMap.put(property.getName(), property);
    return dictionaryPropertyList.add(property);
  }

  @Override
  public boolean addEnumeration(DictionaryEnumeration enumeration) {
    dictionaryEnumerationMap.put(enumeration.getName(), enumeration);
    for (DictionaryEnumerator enumerator : enumeration.getEnumerators()) {
      dictionaryEnumeratorMap.put(enumerator.getName(), enumerator);
    }
    return dictionaryEnumerationList.add(enumeration);
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

  @NotNull
  public String getName() {
    return name;
  }

  @NotNull
  @Override
  public List<String> getNameIdentifiers() {
    return Arrays.asList(name.split(" "));
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

  public PsiElement setName(@NotNull String name) {
    if (name.contains("/")) {
//      String[] paths = name.split("/");
      int start = name.lastIndexOf("/") + 1;
      int end = name.lastIndexOf(".");
      end = end > 0 ? end : name.length();
      name = name.substring(start, end);//paths[paths.length > 0 ? paths.length - 1 : 0];

    }
    this.name = name;
    return this;
  }

  @Override
  public List<AppleScriptPropertyDefinition> getDictionaryPropertyList() {
    return dictionaryPropertyList;
  }

  @Override
  public void setDictionaryPropertyList(List<AppleScriptPropertyDefinition> dictionaryPropertyList) {
    this.dictionaryPropertyList = dictionaryPropertyList;
  }

  @Override
  public void addRecord(DictionaryRecord record) {
    dictionaryRecordList.add(record);
  }


  @Override
  public PsiElement getParent() {
    return PsiManager.getInstance(getProject()).findFile(applicationFile);
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
        System.out.println("dictionary loaded");
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

  @NotNull
  @Override
  public List<AppleScriptCommand> getAllCommands() {
    return dictionaryCommandList;
  }

  @Contract("_, null -> false")
  private static boolean startsWithWord(@NotNull String string, @Nullable String prefix) {
    return prefix != null && string.startsWith(prefix) && (prefix.length() == string.length() || " ".equals(string
            .substring(prefix.length(), prefix.length() + 1)));
  }
}
