package com.idea.plugin.applescript.lang.ide.libraries;

import com.idea.plugin.applescript.lang.parser.ScriptSuiteRegistryHelper;
import com.idea.plugin.applescript.lang.sdef.*;
import com.idea.plugin.applescript.lang.sdef.impl.ApplicationDictionaryImpl;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

/**
 * Created by Andrey on 08.08.2015.
 */
public class ScriptSuiteRegistry implements ScriptSuiteRegistryHelper {

  private static final String[] STANDARD_DEFINITION_FILES = {"sdef/CocoaStandard.xml", "sdef/StandardAdditions.xml"};
  //todo need to add predefined default library!
  public static final String STD_LIBRARY_NAME = "Standard Additions";

  public static final ScriptSuiteRegistry STD_LIBRARY =
          new ScriptSuiteRegistry(STD_LIBRARY_NAME, ProjectManager.getInstance().getDefaultProject());

  //mush be unique - this is a library name in IDEA UI
  @NotNull private String suiteRegistryName;
  @NotNull private Project project;
  //or only store set of VirtualFiles ? and load Suites
  private Set<ApplicationDictionary> applicationDictionaries = new HashSet<ApplicationDictionary>();
  private Map<String, ApplicationDictionary> applicationDictionariesMap = new HashMap<String, ApplicationDictionary>();
  private List<AppleScriptClass> dictionaryClassList = new ArrayList<AppleScriptClass>();
  private List<AppleScriptCommand> dictionaryCommandList = new ArrayList<AppleScriptCommand>();
  private Map<String, DictionaryRecord> dictionaryRecordMap = new HashMap<String, DictionaryRecord>();
  private Map<String, AppleScriptClass> dictionaryClassMap = new HashMap<String, AppleScriptClass>();
  private Map<String, AppleScriptClass> dictionaryClassToPluralNameMap = new HashMap<String, AppleScriptClass>();
  private Map<String, AppleScriptCommand> dictionaryCommandMap = new HashMap<String, AppleScriptCommand>();

  private Map<String, DictionaryEnumerator> dictionaryEnumeratorMap =
          new HashMap<String, DictionaryEnumerator>();

  private Map<String, DictionaryEnumeration> dictionaryEnumerationMap =
          new HashMap<String, DictionaryEnumeration>();

  private Map<String, AppleScriptPropertyDefinition> dictionaryPropertyMap =
          new HashMap<String, AppleScriptPropertyDefinition>();

  public ScriptSuiteRegistry(@NotNull String suiteRegistryName, @NotNull Project project, List<VirtualFile>
          applicationBundleList) {
    this.suiteRegistryName = suiteRegistryName;
    this.project = project;
    for (VirtualFile applicationBundle : applicationBundleList) {
      ApplicationDictionary dictionary = new ApplicationDictionaryImpl(project, applicationBundle);
      addApplicationDictionary(dictionary);
    }
    addStandardSuite();
  }


  public ScriptSuiteRegistry(@NotNull String suiteRegistryName, @NotNull Project project, Set<ApplicationDictionary>
          applicationDictionaries) {
    this.suiteRegistryName = suiteRegistryName;
    this.project = project;
//    this.applicationDictionaries = applicationDictionaries;
    for (ApplicationDictionary dictionary : applicationDictionaries) {
      addApplicationDictionary(dictionary);
    }
    addStandardSuite();
  }

  public ScriptSuiteRegistry(@NotNull String libraryName, @NotNull Project project) {
    suiteRegistryName = libraryName;
    this.project = project;
    addStandardSuite();
  }

  public String getName() {
    return suiteRegistryName;
  }

  private void addStandardSuite() {
    try {
      for (String fName : STANDARD_DEFINITION_FILES) {
        URL url = getClass().getClassLoader().getResource(fName);
        if (url == null) continue;
        File file = new File(url.toURI());
        VirtualFile virtualFile = LocalFileSystem.getInstance().findFileByIoFile(file);
        if (virtualFile != null) {
          ApplicationDictionary standardDefinitions = new ApplicationDictionaryImpl(project, virtualFile);
          addApplicationDictionary(standardDefinitions);
        }
      }
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }
  }

  public Set<ApplicationDictionary> getApplicationDictionaries() {
    return applicationDictionaries;
  }

  public CommandDirectParameter findDirectParameterForCommand(String commandName) {
    AppleScriptCommand command = dictionaryCommandMap.get(commandName);
    if (command != null && command.getDirectParameter() != null) {
      return command.getDirectParameter();
    }
    return null;
  }

  @Override
  @Nullable
  public AppleScriptCommand findCommandWithName(String name) {
    return dictionaryCommandMap.get(name);
  }

  public AppleScriptPropertyDefinition findPropertyWithName(String name) {
    return dictionaryPropertyMap.get(name);
  }

  @NotNull
  public List<AppleScriptCommand> findAllCommandsWithName(String name) {
    List<AppleScriptCommand> result = new ArrayList<AppleScriptCommand>();
    for (AppleScriptCommand command : dictionaryCommandList) {
      if (command.getName().equals(name)) {
        result.add(command);
      }
    }
    return result;
  }

  @NotNull
  public List<AppleScriptCommand> findCommandsStartingWithName(String name) {
    List<AppleScriptCommand> result = new ArrayList<AppleScriptCommand>();
    for (AppleScriptCommand command : dictionaryCommandList) {
      if (startsWithWord(command.getName(), name)) {
        result.add(command);
      }
    }
    return result;
  }

  @Override
  public List<AppleScriptClass> findClassesStartingWithPluralName(String pluralForm) {
    List<AppleScriptClass> result = new ArrayList<AppleScriptClass>();
    for (AppleScriptClass clazz : dictionaryClassList) {
      if (startsWithWord(clazz.getPluralClassName(), pluralForm)) {
        result.add(clazz);
      }
    }
    return result;
  }

  public List<AppleScriptClass> findClassesStartingWithName(String name) {
    List<AppleScriptClass> result = new ArrayList<AppleScriptClass>();
    for (AppleScriptClass clazz : dictionaryClassList) {
      if (startsWithWord(clazz.getName(), name)) {
        result.add(clazz);
      }
    }
    return result;
  }


  public List<DictionaryEnumerator> findConstantsStartingWithWord(String name) {
    List<DictionaryEnumerator> result = new ArrayList<DictionaryEnumerator>();
    for (DictionaryEnumerator constantEnum : dictionaryEnumeratorMap.values()) {
      if (startsWithWord(constantEnum.getName(), name)) {
        result.add(constantEnum);
      }
    }
    return result;
  }

  public DictionaryEnumerator findEnumerator(String name) {
    return dictionaryEnumeratorMap.get(name);
  }

  @Nullable
  @Override
  public AppleScriptClass findClassWithName(String dictionaryName, String className) {
    if (dictionaryName == null || className == null) return null;
    ApplicationDictionary dictionary = applicationDictionariesMap.get(dictionaryName);
    return dictionary != null ? dictionary.findClassByName(className) : null;
  }

  @Nullable
  public AppleScriptClass findClassWithName(String name) {
    return dictionaryClassMap.get(name);
  }

  @Nullable
  @Override
  public AppleScriptClass findClassByPluralName(String pluralForm) {
    if (StringUtil.isEmpty(pluralForm)) return null;

    return dictionaryClassToPluralNameMap.get(pluralForm);
//    for (AppleScriptClass aClass: dictionaryClassList) {
//      if (aClass.getPluralClassName().equals(pluralForm)) {
//        return aClass;
//      }
//    }
  }

  public DictionaryEnumeration findEnumerationWithName(String name) {
    return dictionaryEnumerationMap.get(name);
  }

  @Override
  public List<AppleScriptCommand> getAllCommandsFromDictionary(String dictionaryName) {
    ApplicationDictionary dictionary = applicationDictionariesMap.get(dictionaryName);
    return dictionary != null ? dictionary.getAllCommands() : null;
  }

  @Override
  public List<AppleScriptPropertyDefinition> findPropertiesStartingWithName(String name) {
    List<AppleScriptPropertyDefinition> result = new ArrayList<AppleScriptPropertyDefinition>();
    for (AppleScriptPropertyDefinition prop : dictionaryPropertyMap.values()) {//todo some faster util method?
      if (startsWithWord(prop.getName(), name)) {
        result.add(prop);
      }
    }
    return result;
  }

  @Override
  public List<AppleScriptCommand> geAllCommandsForSuiteRegistry() {
    return dictionaryCommandList;
  }

  public void addApplicationDictionary(ApplicationDictionary dictionary) {
    if (!alreadyContains(dictionary)) {
      applicationDictionaries.add(dictionary);
      applicationDictionariesMap.put(dictionary.getName(), dictionary);
      for (AppleScriptCommand command : dictionary.getDictionaryCommandList()) {
        addCommand(command);
      }
      for (AppleScriptClass aClass : dictionary.getDictionaryClassList()) {
        addClass(aClass);
      }
      for (DictionaryRecord record : dictionary.getDictionaryRecordList()) {
        addRecord(record);
      }
      for (DictionaryEnumeration enumeration : dictionary.getDictionaryEnumerationList()) {
        addEnumeration(enumeration);
      }
    }

  }

  private boolean alreadyContains(ApplicationDictionary dictionary) {
    if (applicationDictionaries.contains(dictionary)) {
      return true;
    }
    for (ApplicationDictionary myDictionary : applicationDictionaries) {
//      if (myDictionary.getName().equals(dictionary.getName())) {
      if (myDictionary.getApplicationFile().getPath().equals(dictionary.getApplicationFile().getPath())) {
        return true;
      }
      if (myDictionary.getApplicationFile().equals(dictionary.getApplicationFile())) {
        return true;
      }
    }
    return false;
  }

  //todo there could be several commands with the same name! (will not be inserted)
  public void addCommand(AppleScriptCommand command) {
    dictionaryCommandMap.put(command.getName(), command);
    dictionaryCommandList.add(command);
  }

  public void addClass(AppleScriptClass aClass) {
    dictionaryClassList.add(aClass);
    dictionaryClassMap.put(aClass.getName(), aClass);
    dictionaryClassToPluralNameMap.put(aClass.getPluralClassName(), aClass);
    for (AppleScriptPropertyDefinition property : aClass.getProperties()) {
      addProperty(property);
    }
  }

  public void addProperty(AppleScriptPropertyDefinition property) {
    dictionaryPropertyMap.put(property.getName(), property);
  }

  public void addRecord(DictionaryRecord record) {
    dictionaryRecordMap.put(record.getName(), record);
    for (AppleScriptPropertyDefinition property : record.getProperties()) {
      addProperty(property);
    }
  }

  public void addEnumeration(DictionaryEnumeration enumeration) {
    dictionaryEnumerationMap.put(enumeration.getName(), enumeration);
    for (DictionaryEnumerator enumerator : enumeration.getEnumerators()) {
      dictionaryEnumeratorMap.put(enumerator.getName(), enumerator);
    }
  }

  @Nullable
  @Override
  public ApplicationDictionary findDictionaryByName(String name) {
    if (name == null) return null;
    return applicationDictionariesMap.get(name);
  }

  @Nullable
  @Override
  public List<String> getParameterNamesForCommand(String name) {
    AppleScriptCommand command = dictionaryCommandMap.get(name);
    return command != null ? command.getParameterNames() : null;
  }

  @Contract("_, null -> false")
  private static boolean startsWithWord(@NotNull String string, @Nullable String prefix) {
    return prefix != null && string.startsWith(prefix) && (prefix.length() == string.length() || " ".equals(string
            .substring(prefix.length(), prefix.length() + 1)));
  }

}
