package com.idea.plugin.applescript.lang.ide.sdef;

import com.idea.plugin.applescript.lang.parser.ParsableScriptHelper;
import com.idea.plugin.applescript.lang.sdef.AppleScriptCommand;
import com.idea.plugin.applescript.lang.sdef.ApplicationDictionary;
import com.idea.plugin.applescript.psi.sdef.impl.ApplicationDictionaryImpl;
import com.intellij.openapi.application.PathManager;
import com.intellij.openapi.components.*;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.SystemInfo;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.util.xmlb.annotations.MapAnnotation;
import com.intellij.util.xmlb.annotations.Tag;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

/**
 * for storing plain structure info about application name and it's classes/properties/constants/commands
 */
@State(name = AppleScriptSystemDictionaryRegistry.COMPONENT_NAME,
        storages = {@Storage(file = StoragePathMacros.APP_CONFIG + "/appleScriptCachedDictionariesInfo.xml")})
public class AppleScriptSystemDictionaryRegistry implements ApplicationComponent,
        PersistentStateComponent<AppleScriptSystemDictionaryRegistry.State>, ParsableScriptHelper {

  public static final String COMPONENT_NAME = "AppleScriptSystemDictionaryRegistry";

  public static final String CACHED_DICTIONARY_URLS_ELEMENT = "cachedDictionaryUrls";
  public static final String APPLICATION_NAME_ELEMENT = "applicationName";
  public static final String DICTIONARY_CACHED_FILE_URL = "cachedFileUrl";

  private Map<String, String> myApplicationNameToCachedDictionaryFileUrlMap = new HashMap<String, String>();

  public static final String CACHED_DICTIONARIES_SYSTEM_FOLDER = PathManager.getSystemPath() + "/sdef";


  private final Map<String, List<String>> classNameToApplicationNameListMap =
          new HashMap<String, List<String>>();
  private final Map<String, List<String>> classNamePluralToApplicationNameListMap =
          new HashMap<String, List<String>>();
  private final Map<String, List<String>> commandNameToApplicationNameListMap =
          new HashMap<String, List<String>>();
  private final Map<String, List<String>> recordNameToApplicationNameListMap =
          new HashMap<String, List<String>>();
  private final Map<String, List<String>> propertyNameToApplicationNameListMap =
          new HashMap<String, List<String>>();
  private final Map<String, List<String>> enumerationNameToApplicationNameListMap =
          new HashMap<String, List<String>>();
  private final Map<String, List<String>> enumeratorConstantNameToApplicationNameListMap =
          new HashMap<String, List<String>>();


  public static class State {

    @Tag(CACHED_DICTIONARY_URLS_ELEMENT)
    @MapAnnotation(surroundWithTag = false, keyAttributeName = APPLICATION_NAME_ELEMENT,
            valueAttributeName = DICTIONARY_CACHED_FILE_URL)
    public Map<String, String> cachedApplicationNameToDictionaryUrlMap = new HashMap<String, String>();

    @Tag("cachedClassNameToApplicationsMap")
    @MapAnnotation(surroundWithTag = false, keyAttributeName = "className",
            valueAttributeName = "applications")
    public Map<String, String> cachedClassNameToDictionaryListMap = new HashMap<String, String>();

  }

  @Nullable
  @Override
  public State getState() {
    State state = new State();
    state.cachedApplicationNameToDictionaryUrlMap = myApplicationNameToCachedDictionaryFileUrlMap;
    Map<String, String> result = new HashMap<String, String>();
    for (Map.Entry<String, List<String>> stringListPair : classNameToApplicationNameListMap.entrySet()) {
      result.put(stringListPair.getKey(), serializeDictionaryNameList(stringListPair.getValue()));
    }
    state.cachedClassNameToDictionaryListMap = result;
    return state;
  }

  private static String serializeDictionaryNameList(List<String> dictionaryNameList) {
    String result = "";
    String sep = "";
    for (String dictionaryName : dictionaryNameList) {
      result = result + sep + dictionaryName;
      sep = ",";
    }
    return result;
  }

  @Override
  public void loadState(State state) {
    Map<String, String> uncheckedMap = state.cachedApplicationNameToDictionaryUrlMap;
    for (Map.Entry<String, String> stringEntry : uncheckedMap.entrySet()) {
      File file = new File(stringEntry.getValue());
      if (file.exists()) {
        myApplicationNameToCachedDictionaryFileUrlMap.put(stringEntry.getKey(), stringEntry.getValue());
      }
    }
    Map<String, String> classToDictionariesMap = state.cachedClassNameToDictionaryListMap;
    for (Map.Entry<String, String> stringPair : classToDictionariesMap.entrySet()) {
      List<String> applicationNames = new ArrayList<String>();
      for (String applicationName : stringPair.getValue().split(",")) {
        if (!StringUtil.isEmpty(applicationName)) {
          applicationNames.add(applicationName);
        }
      }
      classNameToApplicationNameListMap.put(stringPair.getKey(), applicationNames);
    }
  }


  @Override
  public void initComponent() {
    initStandardSuite();
    initOSXApplicationsDictionary();
  }

  // === parsing helper interface ===

  @Override
  public boolean isClassExist(@NotNull String name) {
    return classNameToApplicationNameListMap.containsKey(name);
  }

  @Override
  public boolean isClassExist(@NotNull String applicationName, @NotNull String className) {
    List<String> applicationNames = classNameToApplicationNameListMap.get(className);
    return applicationNames != null && applicationNames.contains(applicationName);
  }

  @Override
  public boolean isClassWithPluralNameExist(@NotNull String pluralName) {
    return classNamePluralToApplicationNameListMap.containsKey(pluralName);
  }

  @Override
  public boolean isClassWithPluralNameExist(@NotNull String applicationName, @NotNull String pluralClassName) {
    List<String> applicationNames = classNamePluralToApplicationNameListMap.get(pluralClassName);
    return applicationNames != null && applicationNames.contains(applicationName);
  }

  @Override
  public int countClassesStartingWithName(@NotNull String namePrefix) {
    int result = 0;
    for (String className : classNameToApplicationNameListMap.keySet()) {
      if (startsWithWord(className, namePrefix)) {
        result++;
      }
    }
    return result;
  }

  @Override
  public int countClassesStartingWithName(@NotNull String applicationName, @NotNull String classNamePrefix) {
    int result = 0;
    //todo performance is bad (can't narrow down search by applicationName)
    for (Map.Entry<String, List<String>> stringListEntry : classNameToApplicationNameListMap.entrySet()) {
      if (startsWithWord(stringListEntry.getKey(), classNamePrefix)
              && stringListEntry.getValue().contains(applicationName)) {
        result++;
      }
    }
    return result;
  }

  @Override
  public int countClassesStartingWithPluralName(@NotNull String namePrefix) {
    int result = 0;
    for (String className : classNamePluralToApplicationNameListMap.keySet()) {
      if (startsWithWord(className, namePrefix)) {
        result++;
      }
    }
    return result;
  }

  @Override
  public int countClassesStartingWithPluralName(@NotNull String applicationName,
                                                @NotNull String pluralClassNamePrefix) {
    int result = 0;
    //todo performance is bad (can't narrow down search by applicationName)
    for (Map.Entry<String, List<String>> stringListEntry : classNamePluralToApplicationNameListMap.entrySet()) {
      if (startsWithWord(stringListEntry.getKey(), pluralClassNamePrefix)
              && stringListEntry.getValue().contains(applicationName)) {
        result++;
      }
    }
    return result;
  }

  @Override
  public boolean isCommandExist(@NotNull String name) {
    return commandNameToApplicationNameListMap.containsKey(name);
  }

  @Override
  public boolean isCommandExist(@NotNull String applicationName, @NotNull String commandName) {
    List<String> applications = commandNameToApplicationNameListMap.get(commandName);
    return applications != null && applications.contains(applicationName);
  }

  @Override
  public int countCommandsStartingWithName(@NotNull String namePrefix) {
    int result = 0;
    for (String commandName : commandNameToApplicationNameListMap.keySet()) {
      if (startsWithWord(commandName, namePrefix)) {
        result++;
      }
    }
    return result;
  }

  @Override
  public int countCommandsStartingWithName(@NotNull String applicationName, @NotNull String commandNamePrefix) {
    int result = 0;
    for (Map.Entry<String, List<String>> stringListEntry : commandNameToApplicationNameListMap.entrySet()) {
      if (startsWithWord(stringListEntry.getKey(), commandNamePrefix)
              && stringListEntry.getValue().contains(applicationName)) {
        result++;
      }
    }
    return result;
  }

  @NotNull
  @Override
  public List<AppleScriptCommand> findCommands(@NotNull Project project, @NotNull String commandName) {
    List<String> appNameList = commandNameToApplicationNameListMap.get(commandName);
    List<AppleScriptCommand> result = new ArrayList<AppleScriptCommand>();
    for (String applicationName : appNameList) {
      result.addAll(findCommands(project, applicationName, commandName));
    }
    return result;
  }

  @NotNull
  @Override
  public List<AppleScriptCommand> findCommands(@NotNull Project project, @NotNull String applicationName,
                                               @NotNull String commandName) {
    List<AppleScriptCommand> result = new ArrayList<AppleScriptCommand>();
    AppleScriptProjectDictionaryRegistry projectDictionaryRegistry = (AppleScriptProjectDictionaryRegistry)
            project.getComponent(AppleScriptProjectDictionaryRegistry.COMPONENT_NAME);
    ApplicationDictionary dictionary = projectDictionaryRegistry.getDictionary(applicationName);
    //among dictionaries there should always be Standard Additions dictionaries checked BUT
    //if there was no command in that dictionaries found, we should initialize new dictionary here for the project
    //and do it only once!
    if (dictionary == null) {
      dictionary = projectDictionaryRegistry.createDictionary(applicationName);
    }
    if (dictionary != null) {
      result.addAll(dictionary.findAllCommandsWithName(commandName));
    }
    return result;
  }

  @Override
  public boolean isPropertyExist(@NotNull String name) {
    return propertyNameToApplicationNameListMap.containsKey(name);
  }

  @Override
  public boolean isPropertyExist(@NotNull String applicationName, @NotNull String propertyName) {
    List<String> applications = propertyNameToApplicationNameListMap.get(propertyName);
    return applications != null && applications.contains(applicationName);
  }

  @Override
  public int countPropertiesStartingWithName(@NotNull String namePrefix) {
    int result = 0;
    for (String propertyName : propertyNameToApplicationNameListMap.keySet()) {
      if (startsWithWord(propertyName, namePrefix)) {
        result++;
      }
    }
    return result;
  }

  @Override
  public int countPropertiesStartingWithName(@NotNull String applicationName, @NotNull String propertyNamePrefix) {
    int result = 0;
    for (Map.Entry<String, List<String>> stringListEntry : propertyNameToApplicationNameListMap.entrySet()) {
      if (startsWithWord(stringListEntry.getKey(), propertyNamePrefix)
              && stringListEntry.getValue().contains(applicationName)) {
        result++;
      }
    }
    return result;
  }

  @Override
  public boolean isConstantExist(@NotNull String name) {
    return enumeratorConstantNameToApplicationNameListMap.containsKey(name);
  }

  @Override
  public boolean isConstantExist(@NotNull String applicationName, @NotNull String constantName) {
    List<String> applications = enumeratorConstantNameToApplicationNameListMap.get(constantName);
    return applications != null && applications.contains(applicationName);
  }

  @Override
  public int countConstantStartingWithName(@NotNull String namePrefix) {
    int result = 0;
    for (String constantName : enumeratorConstantNameToApplicationNameListMap.keySet()) {
      if (startsWithWord(constantName, namePrefix)) {
        result++;
      }
    }
    return result;
  }

  @Override
  public int countConstantStartingWithName(@NotNull String applicationName, @NotNull String constantNamePrefix) {
    int result = 0;
    for (Map.Entry<String, List<String>> stringListEntry : enumeratorConstantNameToApplicationNameListMap.entrySet()) {
      if (startsWithWord(stringListEntry.getKey(), constantNamePrefix)
              && stringListEntry.getValue().contains(applicationName)) {
        result++;
      }
    }
    return result;
  }


  private void initOSXApplicationsDictionary() {
    List<String> myApplications = Arrays.asList("Mail", "BBEdit", "Satimage", "Finder", "System Events", "TextEdit",
            "Smile");
    for (String specifiedAppName : myApplications) {
      initDictionaryForApplication(specifiedAppName);
    }

  }

  private void initDictionaryForApplication(@NotNull String applicationName) {
    File applicationFile = getApplicationBundleFile(applicationName);
    if (applicationFile != null && applicationFile.exists()) {
      final VirtualFile vAppFile = LocalFileSystem.getInstance().findFileByIoFile(applicationFile);
      if (vAppFile != null) {
        parseDictionaryFileForApplication(vAppFile, applicationName);
      }
    }
  }

  @Nullable
  private File getApplicationBundleFile(@NotNull String applicationName) {
    for (String applicationsDirectory : ApplicationDictionary.APP_BUNDLE_DIRECTORIES) {
      for (String ext : ApplicationDictionary.SUPPORTED_EXTENSIONS) {
        String appBundleFilePath = applicationsDirectory + File.separator + applicationName + "." + ext;
        File applicationFile = new File(appBundleFilePath);
        if (applicationFile.exists()) return applicationFile;
      }
    }
    return null;
  }

  private void parseDictionaryFileForApplication(@NotNull VirtualFile applicationVFile,
                                                 @NotNull String applicationName) {
    if (!ApplicationDictionaryImpl.extensionSupported(applicationVFile.getExtension()))
      return;

    String cachedDictionaryUrl = getCachedDictionaryFileUrl(applicationName);
    if (cachedDictionaryUrl == null) {
      cachedDictionaryUrl = cacheApplicationDictionary(applicationName, applicationVFile);
      if (cachedDictionaryUrl != null) {
        myApplicationNameToCachedDictionaryFileUrlMap.put(applicationName, cachedDictionaryUrl);
      }
    }
    if (cachedDictionaryUrl != null) {
      File cachedXmlFile = new File(cachedDictionaryUrl);
      parseDictionaryFile(cachedXmlFile, applicationName);
    }
  }

  private void initStandardSuite() {
    try {
      for (String fName : ApplicationDictionary.STANDARD_DEFINITION_FILES) {
        URL url = getClass().getClassLoader().getResource(fName);
        if (url == null) continue;
        File file = new File(url.toURI());
        VirtualFile virtualFile = LocalFileSystem.getInstance().findFileByIoFile(file);
        if (virtualFile != null) {
          final String applicationName = virtualFile.getNameWithoutExtension();
          parseDictionaryFileForApplication(virtualFile, applicationName);
        }
      }
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }
  }

  @Nullable
  private String cacheApplicationDictionary(@NotNull String applicationName,
                                            @NotNull VirtualFile virtualApplicationFile) {
    if (!SystemInfo.isMac) return null;

    System.out.println("=== Caching Dictionary for application [" + applicationName + "] ===");
    final String cachedDictionaryPath = serializeDictionaryPathForApplication(applicationName);
    String cmdName;
    if ("xml".equals(virtualApplicationFile.getExtension())) {
      cmdName = "cat";
    } else {
      cmdName = "sdef";
    }

    final String appFileFinalPath = virtualApplicationFile.getPath();
    final File targetFile = new File(cachedDictionaryPath);
    if (!targetFile.getParentFile().exists()) {// if directory does not exist, create one
      targetFile.getParentFile().mkdirs();
    }
    if (targetFile.getParentFile().exists()) {
      final String[] shellCommand = new String[]{"/bin/bash", "-c", " " + cmdName + " \"" + appFileFinalPath + "\" > " +
              cachedDictionaryPath};
      System.out.println("executing command: " + Arrays.toString(shellCommand));
      long execStart = System.currentTimeMillis();
      int exitCode = 0;
      try {
        exitCode = Runtime.getRuntime().exec(shellCommand).waitFor();
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }
      long execEnd = System.currentTimeMillis();
      System.out.println("Exit code = " + exitCode + " Execution time: " + (execEnd - execStart) + " ms.");
      return cachedDictionaryPath;
    }
    return null;
  }

  private String serializeDictionaryPathForApplication(@NotNull String applicationName) {
    char sep = File.separatorChar;
    String unescaped = CACHED_DICTIONARIES_SYSTEM_FOLDER + sep + applicationName + "_generated.xml";
    return unescaped.replaceAll(" ", "_");
  }

  @Nullable
  public String getCachedDictionaryFileUrl(@Nullable String applicationName) {
    return myApplicationNameToCachedDictionaryFileUrlMap.get(applicationName);
  }

  @Override
  public void disposeComponent() {

  }

  @NotNull
  @Override
  public String getComponentName() {
    return COMPONENT_NAME;
  }

  private void parseDictionaryFile(@NotNull File xmlFile, @NotNull String applicationName) {
    SAXBuilder builder = new SAXBuilder();
    Document document;
    try {
      document = builder.build(xmlFile);
      Element rootNode = document.getRootElement();
      List<Element> suiteElements = rootNode.getChildren();

      for (Element suiteElem : suiteElements) {
        parseSuiteElement(suiteElem, applicationName);
      }
    } catch (JDOMException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void parseSuiteElement(Element suiteElem, String applicationName) {
    List<Element> suiteClasses = suiteElem.getChildren("class");
    List<Element> suiteClassExtensions = suiteElem.getChildren("class-extension");
    List<Element> suiteCommands = suiteElem.getChildren("command");
    List<Element> recordTypeTags = suiteElem.getChildren("record-type");
    List<Element> enumerationTags = suiteElem.getChildren("enumeration");

    for (Element classTag : suiteClasses) {
      parseClassElement(applicationName, classTag, false);
      List<Element> propertyElements = classTag.getChildren("property");
      parseElementsForApplication(propertyElements, applicationName, propertyNameToApplicationNameListMap);
    }

    for (Element classTag : suiteClassExtensions) {
      parseClassElement(applicationName, classTag, false);
      List<Element> propertyElements = classTag.getChildren("property");
      parseElementsForApplication(propertyElements, applicationName, propertyNameToApplicationNameListMap);
    }

    parseElementsForApplication(suiteCommands, applicationName, commandNameToApplicationNameListMap);
    parseElementsForApplication(recordTypeTags, applicationName, recordNameToApplicationNameListMap);

    for (Element recordTag : recordTypeTags) {
      List<Element> propertyElements = recordTag.getChildren("property");
      parseElementsForApplication(propertyElements, applicationName, propertyNameToApplicationNameListMap);
    }

    parseElementsForApplication(enumerationTags, applicationName, enumerationNameToApplicationNameListMap);

    for (Element enumerationTag : enumerationTags) {
      List<Element> enumeratorTags = enumerationTag.getChildren("enumerator");
      parseElementsForApplication(enumeratorTags, applicationName, enumeratorConstantNameToApplicationNameListMap);
    }

  }

  private static void parseElementsForApplication(List<Element> xmlElements, @NotNull String applicationName,
                                                  @NotNull Map<String, List<String>>
                                                          objectTagNameToApplicationNameListMap) {
    for (Element applicationObjectTag : xmlElements) {
      parseSimpleElementForObject(applicationObjectTag, applicationName, objectTagNameToApplicationNameListMap);
    }
  }

  private static void parseSimpleElementForObject(@NotNull Element suiteObjectElement, @NotNull String applicationName,
                                                  Map<String, List<String>> objectNameToApplicationNameListMap) {
    final String objectName = suiteObjectElement.getAttributeValue("name");
    final String code = suiteObjectElement.getAttributeValue("code");
    if (objectName == null || code == null) return;

    updateApplicationNameListFor(objectName, applicationName, objectNameToApplicationNameListMap);
  }

  private void parseClassElement(@NotNull String applicationName, @NotNull Element classElement, boolean isExtends) {
//    if isExtends -> name is always == "application"
    String className = isExtends ? classElement.getAttributeValue("extends") : classElement.getAttributeValue("name");
    String code = classElement.getAttributeValue("code");
    String pluralClassName = classElement.getAttributeValue("plural");
    if (className == null || code == null) return;
    pluralClassName = !StringUtil.isEmpty(pluralClassName) ? pluralClassName : className + "s";

    updateApplicationNameListFor(className, applicationName, classNameToApplicationNameListMap);
    updateApplicationNameListFor(pluralClassName, applicationName, classNamePluralToApplicationNameListMap);
  }

  private static void updateApplicationNameListFor(@NotNull String applicationObjectName,
                                                   @NotNull String applicationName,
                                                   Map<String, List<String>> applicationNameListMap) {
    List<String> appNameListForObject = applicationNameListMap.get(applicationObjectName);
    if (appNameListForObject == null) {
      appNameListForObject = new ArrayList<String>();
      appNameListForObject.add(applicationName);
      if (!StringUtil.isEmpty(applicationName)) {
        applicationNameListMap.put(applicationObjectName, appNameListForObject);
      }
    } else if (!appNameListForObject.contains(applicationName)) {
      appNameListForObject.add(applicationName);
    }
  }

  @Contract("_, null -> false")
  private static boolean startsWithWord(@NotNull String string, @Nullable String prefix) {
    return prefix != null && string.startsWith(prefix) && (prefix.length() == string.length() || " ".equals(string
            .substring(prefix.length(), prefix.length() + 1)));
  }
}
