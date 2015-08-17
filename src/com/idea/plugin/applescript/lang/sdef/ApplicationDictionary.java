package com.idea.plugin.applescript.lang.sdef;

import com.idea.plugin.applescript.lang.sdef.parser.SDEF_Parser;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.SystemInfo;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.impl.FakePsiElement;
import com.intellij.psi.xml.XmlFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by Andrey on 01.07.2015.
 */
public class ApplicationDictionary extends FakePsiElement {

  //todo add suites: several class unique only within a suite !
  @NotNull private Project project;
  @NotNull private VirtualFile applicationFile;
  @NotNull private String name;
  //todo add sdef file types as xml
  public static final List<String> SUPPORTED_EXTENSIONS = Arrays.asList("xml", "app", "osax");

  final private List<Suite> mySuites = new ArrayList<Suite>();
  private List<AppleScriptCommand> dictionaryCommandList = new ArrayList<AppleScriptCommand>();
  private List<AppleScriptPropertyDefinition> dictionaryPropertyList = new ArrayList<AppleScriptPropertyDefinition>();
  private List<DictionaryRecord> dictionaryRecordList = new ArrayList<DictionaryRecord>();
  private List<DictionaryEnumeration> dictionaryEnumerationList = new ArrayList<DictionaryEnumeration>();
  private Map<String, AppleScriptCommand> dictionaryCommandMap = new HashMap<String, AppleScriptCommand>();
  private List<AppleScriptClass> dictionaryClassList = new ArrayList<AppleScriptClass>();
  private Map<String, AppleScriptClass> dictionaryClassMap = new HashMap<String, AppleScriptClass>();

  @NotNull
  @Override
  public Project getProject() {
    return project;
  }

  public boolean addSuite(Suite suite) {
    return suite != null && mySuites.add(suite);
  }

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

  public ApplicationDictionary(@NotNull Project project, @NotNull VirtualFile applicationBundleFile) {
    this.project = project;
    this.applicationFile = applicationBundleFile;
    name = applicationBundleFile.getPath();
    readApplicationDictionary();
    System.out.println("Dictionary ===" + name + "=== initialized. Commands: " + dictionaryCommandList.size() + "\n");
  }

  private void readApplicationDictionary() {
    String extension = applicationFile.getExtension();
    if (!extensionSupported(applicationFile.getExtension())) return;
    if ("xml".equalsIgnoreCase(extension)) {
      readDictionaryFromXmlFile(applicationFile, project);
    } else {
      readDictionaryFromApplicationBundle(applicationFile, project);
    }
  }

  private void readDictionaryFromApplicationBundle(@NotNull VirtualFile applicationFile, @NotNull Project project) {
    if (!SystemInfo.isMac) return;
    final String pathPrefix = FileUtil.getTempDirectory() + "/";
    final String fileName = applicationFile.getNameWithoutExtension().replace(" ", "_");
    final String finalFilePath = pathPrefix + fileName + "_generated.xml";
    final String appFileFinalPath = "\"" + applicationFile.getPath() + "\"";
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
      readDictionaryFromXmlFile(virtualXmlFile, project);
      finalXmlFile.delete();
//      finalXmlFile.deleteOnExit();
    } catch (IOException e1) {
      e1.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
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

//  @Override
//  public PsiFile getContainingFile() {
//    return PsiManager.getInstance(getProject()).findFile(applicationFile);
////    return super.getContainingFile();
//  }

  @Override
  public PsiElement getParent() {
    return PsiManager.getInstance(getProject()).findFile(applicationFile);
  }

  private void readDictionaryFromXmlFile(VirtualFile virtualFile, Project project) {
    if (project != null && virtualFile != null) {
      PsiFile psiFile = PsiManager.getInstance(project).findFile(virtualFile);
      XmlFile xmlFile = (XmlFile) psiFile;
      if (xmlFile != null && xmlFile.isValid()) {
        SDEF_Parser.parse(xmlFile, this);
        System.out.println("dictionary loaded");
      }
    }
  }


  public static boolean extensionSupported(String extension) {
    if (extension == null) return false;
    extension = extension.toLowerCase();
    return SUPPORTED_EXTENSIONS.contains(extension);
  }
}
