package com.idea.plugin.applescript.lang.sdef;

import com.idea.plugin.applescript.lang.sdef.parser.SDEF_Parser;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.impl.FakePsiElement;
import com.intellij.psi.xml.XmlFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Andrey on 01.07.2015.
 */
public class ApplicationDictionary extends FakePsiElement {

  //todo add suites: several class unique only within a suite !
  @NotNull private Project project;
  @NotNull private VirtualFile applicationFile;
  @NotNull private String name;
  private List<AppleScriptCommand> dictionaryCommandList = new ArrayList<AppleScriptCommand>();
  private List<AppleScriptPropertyDefinition> dictionaryPropertyList = new ArrayList<AppleScriptPropertyDefinition>();
  private List<DictionaryRecord> dictionaryRecordList = new ArrayList<DictionaryRecord>();
  private List<DictionaryEnumeration> dictionaryEnumerationList = new ArrayList<DictionaryEnumeration>();
  private Map<String, AppleScriptCommand> dictionaryCommandMap = new HashMap<String, AppleScriptCommand>();

  @NotNull
  public VirtualFile getApplicationFile() {
    return applicationFile;
  }

  public List<DictionaryEnumeration> getDictionaryEnumerationList() {
    return dictionaryEnumerationList;
  }

  public List<DictionaryRecord> getDictionaryRecordList() {
    return dictionaryRecordList;
  }

  public Map<String, AppleScriptCommand> getDictionaryCommandMap() {
    return dictionaryCommandMap;
  }

  public List<AppleScriptCommand> getDictionaryCommandList() {
    return dictionaryCommandList;
  }

  public List<AppleScriptClass> getDictionaryClassList() {
    return dictionaryClassList;
  }

  private List<AppleScriptClass> dictionaryClassList = new ArrayList<AppleScriptClass>();
  private Map<String, AppleScriptClass> dictionaryClassMap = new HashMap<String, AppleScriptClass>();

  public ApplicationDictionary(@NotNull Project project, @NotNull VirtualFile applicationBundleFile) {
    this.project = project;
    this.applicationFile = applicationBundleFile;
    name = applicationBundleFile.getPath();
    loadApplicationDictionary();
  }

  private void loadApplicationDictionary() {
    //only xml so far
    if ("xml".equals(applicationFile.getExtension())) {
      loadDictionaryFromXmlFile(applicationFile, project);
    }
  }

  public List<String> getParameterNamesForCommand(String name) {
    AppleScriptCommand command = dictionaryCommandMap.get(name);
    return command != null ? command.getParameterNames() : null;
  }

  public boolean addCommand(AppleScriptCommand command) {
    dictionaryCommandMap.put(command.getName(), command);
    dictionaryCommandList.add(command);
    return true;
  }

  public boolean addClass(AppleScriptClass appleScriptClass) {
    dictionaryClassMap.put(appleScriptClass.getName(), appleScriptClass);
    return dictionaryClassList.add(appleScriptClass);
  }

  @Nullable
  public AppleScriptClass getClassByName(String name) {
    return dictionaryClassMap.get(name);
  }

  public boolean addProperty(AppleScriptPropertyDefinition property) {
    return dictionaryPropertyList.add(property);
  }

  public boolean addEnumeration(DictionaryEnumeration enumeration) {
    return dictionaryEnumerationList.add(enumeration);
  }

  @NotNull
  public String getName() {
    return name;
  }

  public PsiElement setName(@NotNull String name) {
    this.name = name;
    return this;
  }

  public List<AppleScriptPropertyDefinition> getDictionaryPropertyList() {
    return dictionaryPropertyList;
  }

  public void setDictionaryPropertyList(List<AppleScriptPropertyDefinition> dictionaryPropertyList) {
    this.dictionaryPropertyList = dictionaryPropertyList;
  }

  public void addRecord(DictionaryRecord record) {
    dictionaryRecordList.add(record);
  }

  @Override
  public PsiElement getParent() {
    return null;
  }

  private void loadDictionaryFromXmlFile(VirtualFile virtualFile, Project project) {
    if (project != null && virtualFile != null) {
      PsiFile psiFile = PsiManager.getInstance(project).findFile(virtualFile);
      XmlFile xmlFile = (XmlFile) psiFile;
      if (xmlFile != null) {
        SDEF_Parser.parse(xmlFile, this);
      }
    }
  }


}
