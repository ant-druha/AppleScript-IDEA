package com.idea.plugin.applescript.lang.ide.sdef;

import com.idea.plugin.applescript.lang.parser.ParsableScriptHelper;
import com.idea.plugin.applescript.lang.sdef.AppleScriptCommand;
import com.idea.plugin.applescript.lang.sdef.ApplicationDictionary;
import com.idea.plugin.applescript.psi.sdef.impl.ApplicationDictionaryImpl;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.application.PathManager;
import com.intellij.openapi.components.*;
import com.intellij.openapi.diagnostic.Logger;
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

  private static final Logger LOG = Logger.getInstance("#" + AppleScriptSystemDictionaryRegistry.class.getName());


  public static final String COMPONENT_NAME = "AppleScriptSystemDictionaryRegistry";

  public static final String GENERATED_DICTIONARY_URLS_ELEMENT = "generatedDictionaryUrls";
  public static final String APPLICATION_NAME_ELEMENT = "applicationName";
  public static final String DICTIONARY_GENERATED_FILE_URL = "generatedFileUrl";

  private final Map<String, String> applicationNameToGeneratedDictionaryPathMap = new HashMap<String, String>();

  private final List<String> allSystemApplicationNames = new ArrayList<String>();

  public static final String GENERATED_DICTIONARIES_SYSTEM_FOLDER = PathManager.getSystemPath() + "/sdef";


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

  private final Map<String, List<String>> stdClassNameToApplicationNameListMap =
          new HashMap<String, List<String>>();
  private final Map<String, List<String>> stdClassNamePluralToApplicationNameListMap =
          new HashMap<String, List<String>>();
  private final Map<String, List<String>> stdCommandNameToApplicationNameListMap =
          new HashMap<String, List<String>>();
  private final Map<String, List<String>> stdRecordNameToApplicationNameListMap =
          new HashMap<String, List<String>>();
  private final Map<String, List<String>> stdPropertyNameToApplicationNameListMap =
          new HashMap<String, List<String>>();
  private final Map<String, List<String>> stdEnumerationNameToApplicationNameListMap =
          new HashMap<String, List<String>>();
  private final Map<String, List<String>> stdEnumeratorConstantNameToApplicationNameListMap =
          new HashMap<String, List<String>>();

  public static class State {

    @Tag(GENERATED_DICTIONARY_URLS_ELEMENT)
    @MapAnnotation(surroundWithTag = false, keyAttributeName = APPLICATION_NAME_ELEMENT,
            valueAttributeName = DICTIONARY_GENERATED_FILE_URL)
    public Map<String, String> cachedApplicationNameToGeneratedDictionaryUrlMap = new HashMap<String, String>();

    @Tag("cachedClassNameToApplicationsMap")
    @MapAnnotation(surroundWithTag = false, keyAttributeName = "className",
            valueAttributeName = "applications")
    public Map<String, String> cachedClassNameToDictionaryListMap = new HashMap<String, String>();

  }

  @Nullable
  @Override
  public State getState() {
    State state = new State();
    state.cachedApplicationNameToGeneratedDictionaryUrlMap = applicationNameToGeneratedDictionaryPathMap;
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
    Map<String, String> uncheckedMap = state.cachedApplicationNameToGeneratedDictionaryUrlMap;
    for (Map.Entry<String, String> stringEntry : uncheckedMap.entrySet()) {
      File file = new File(stringEntry.getValue());
      if (file.exists()) {
        applicationNameToGeneratedDictionaryPathMap.put(stringEntry.getKey(), stringEntry.getValue());
      }
    }
    Map<String, String> classToDictionariesMap = state.cachedClassNameToDictionaryListMap;
    for (Map.Entry<String, String> stringPair : classToDictionariesMap.entrySet()) {
      List<String> applicationNames = new ArrayList<String>();
      for (String applicationName : stringPair.getValue().split(",")) {
        if (!StringUtil.isEmpty(applicationName)
                && !ApplicationDictionary.STD_LIBRARY_NAMES.contains(applicationName)) {//if std class was saved somehow
          //do not add it here - other map for std classes is used
          applicationNames.add(applicationName);
        }
      }
      if (!applicationNames.isEmpty()) {
        classNameToApplicationNameListMap.put(stringPair.getKey(), applicationNames);
      }
    }
  }


  @Override
  public void initComponent() {
    initStandardSuite();
    initOSXApplicationsDictionary();
    initSystemApplicationNames();
  }

  private void initSystemApplicationNames() {

    for (String applicationsDirectory : ApplicationDictionary.APP_BUNDLE_DIRECTORIES) {
      VirtualFile appsDirVFile = LocalFileSystem.getInstance().findFileByPath(applicationsDirectory);
      if (appsDirVFile != null && appsDirVFile.exists()) {
        for (VirtualFile appVFile : appsDirVFile.getChildren()) {
          if (ApplicationDictionaryImpl.extensionSupported(appVFile.getExtension())) {
            allSystemApplicationNames.add(appVFile.getNameWithoutExtension());
          }
        }
      }
    }
    System.out.println("System.out: List of installed applications initialized. Count: " + allSystemApplicationNames
            .size());
    LOG.info("List of installed applications initialized. Count: " + allSystemApplicationNames.size());
  }

  // === parsing helper interface ===

  @Override
  public boolean isStdLibClass(@NotNull String name) {
    return stdClassNameToApplicationNameListMap.containsKey(name);
  }

  @Override
  public boolean isApplicationClass(@NotNull String applicationName, @NotNull String className) {
    List<String> applicationNames = classNameToApplicationNameListMap.get(className);
    return applicationNames != null && applicationNames.contains(applicationName);
  }

  @Override
  public boolean isStdLibClassPluralName(@NotNull String pluralName) {
    return stdClassNamePluralToApplicationNameListMap.containsKey(pluralName);
  }

  @Override
  public boolean isApplicationClassPluralName(@NotNull String applicationName, @NotNull String pluralClassName) {
    List<String> applicationNames = classNamePluralToApplicationNameListMap.get(pluralClassName);
    return applicationNames != null && applicationNames.contains(applicationName);
  }

  @Override
  public int countStdClassesStartingWithName(@NotNull String namePrefix) {
    int result = 0;
    for (String className : stdClassNameToApplicationNameListMap.keySet()) {
      if (startsWithWord(className, namePrefix)) {
        result++;
      }
    }
    return result;
  }

  @Override
  public int countApplicationClassesStartingWithName(@NotNull String applicationName, @NotNull String classNamePrefix) {
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
  public int countStdClassesStartingWithPluralName(@NotNull String namePrefix) {
    int result = 0;
    for (String className : stdClassNamePluralToApplicationNameListMap.keySet()) {
      if (startsWithWord(className, namePrefix)) {
        result++;
      }
    }
    return result;
  }

  @Override
  public int countApplicationClassesStartingWithPluralName(@NotNull String applicationName,
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
  public boolean isStdCommand(@NotNull String name) {
    return stdCommandNameToApplicationNameListMap.containsKey(name);
  }

  @Override
  public boolean isApplicationCommand(@NotNull String applicationName, @NotNull String commandName) {
    List<String> applications = commandNameToApplicationNameListMap.get(commandName);
    return applications != null && applications.contains(applicationName);
  }

  @Override
  public int countStdCommandsStartingWithName(@NotNull String namePrefix) {
    int result = 0;
    for (String commandName : stdCommandNameToApplicationNameListMap.keySet()) {
      if (startsWithWord(commandName, namePrefix)) {
        result++;
      }
    }
    return result;
  }

  @Override
  public int countApplicationCommandsStartingWithName(@NotNull String applicationName, @NotNull String
          commandNamePrefix) {
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
  public List<AppleScriptCommand> findStdCommands(@NotNull Project project, @NotNull String commandName) {
    List<String> appNameList = stdCommandNameToApplicationNameListMap.get(commandName);
    if (appNameList == null) return new ArrayList<AppleScriptCommand>(0);

    List<AppleScriptCommand> result = new ArrayList<AppleScriptCommand>();
    for (String applicationName : appNameList) {
      result.addAll(findApplicationCommands(project, applicationName, commandName));
    }
    return result;
  }

  @NotNull
  @Override
  public List<AppleScriptCommand> findApplicationCommands(@NotNull Project project, @NotNull String applicationName,
                                                          @NotNull String commandName) {
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
      return dictionary.findAllCommandsWithName(commandName);
    }
    return new ArrayList<AppleScriptCommand>(0);
  }

  @Override
  public boolean isStdProperty(@NotNull String name) {
    return stdPropertyNameToApplicationNameListMap.containsKey(name);
  }

  @Override
  public boolean isApplicationProperty(@NotNull String applicationName, @NotNull String propertyName) {
    List<String> applications = propertyNameToApplicationNameListMap.get(propertyName);
    return applications != null && applications.contains(applicationName);
  }

  @Override
  public int countStdPropertiesStartingWithName(@NotNull String namePrefix) {
    int result = 0;
    for (String propertyName : stdPropertyNameToApplicationNameListMap.keySet()) {
      if (startsWithWord(propertyName, namePrefix)) {
        result++;
      }
    }
    return result;
  }

  @Override
  public int countApplicationPropertiesStartingWithName(@NotNull String applicationName,
                                                        @NotNull String propertyNamePrefix) {
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
  public boolean isStdConstant(@NotNull String name) {
    return stdEnumeratorConstantNameToApplicationNameListMap.containsKey(name);
  }

  @Override
  public boolean isApplicationConstant(@NotNull String applicationName, @NotNull String constantName) {
    List<String> applications = enumeratorConstantNameToApplicationNameListMap.get(constantName);
    return applications != null && applications.contains(applicationName);
  }

  @Override
  public int countStdConstantStartingWithName(@NotNull String namePrefix) {
    int result = 0;
    for (String constantName : stdEnumeratorConstantNameToApplicationNameListMap.keySet()) {
      if (startsWithWord(constantName, namePrefix)) {
        result++;
      }
    }
    return result;
  }

  @Override
  public int countApplicationConstantStartingWithName(@NotNull String applicationName, @NotNull String
          constantNamePrefix) {
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
    Collection<String> myCachedApplications = applicationNameToGeneratedDictionaryPathMap.keySet();
    //init from previously generated files
    for (Map.Entry<String, String> appNameToFile : applicationNameToGeneratedDictionaryPathMap.entrySet()) {
      VirtualFile dictionaryVFile = LocalFileSystem.getInstance().findFileByPath(appNameToFile.getValue());
      if (dictionaryVFile != null && dictionaryVFile.exists()) {
        if (initializeDictionaryFromApplicationFile(dictionaryVFile, appNameToFile.getKey()) == null) {
          System.out.println("WARNING: failed to initialize dictionary for application: " + appNameToFile.getKey());
          LOG.warn("Failed to initialize dictionary for application: " + appNameToFile.getKey());
        }
      } else {
        System.out.println("WARNING: failed to initialize dictionary for application: " + appNameToFile.getKey() +
                "Dictionary file " + appNameToFile.getValue() + " is not valid");
        LOG.warn("Failed to initialize dictionary for application: " + appNameToFile.getKey() +
                "Dictionary file " + appNameToFile.getValue() + " is not valid");

      }
    }
    List<String> myDefaultApplicationList = Arrays.asList("Mail", "BBEdit", "Satimage", "Finder", "System Events",
            "TextEdit", "Smile");
    List<String> allApplications = new ArrayList<String>(myCachedApplications.size());
    allApplications.addAll(myCachedApplications);
    for (String defaultApp : myDefaultApplicationList) {
      if (!allApplications.contains(defaultApp)) {
        if (initializeDictionaryForApplication(defaultApp) == null) {
          System.out.println("WARNING: failed to initialize dictionary for application: " + defaultApp);
          LOG.warn("Failed to initialize dictionary for application: " + defaultApp);
        }
      }
    }
  }

  /**
   * Initializes dictionary information for given application and caches generated dictionary file for later use <br>
   * by {@link com.idea.plugin.applescript.lang.sdef.ApplicationDictionary} psi class. Standard application paths are
   * checked
   *
   * @param applicationName Name of the Mac OS application
   * @return File path of generated and cached dictionary for application
   */
  public String initializeDictionaryForApplication(@NotNull String applicationName) {
    File applicationFile = getApplicationBundleFile(applicationName);
    if (applicationFile != null && applicationFile.exists()) {
      final VirtualFile vAppFile = LocalFileSystem.getInstance().findFileByIoFile(applicationFile);
      if (vAppFile != null) {
        return initializeDictionaryFromApplicationFile(vAppFile, applicationName);
      }
    }
    return null;
  }

  @Nullable
  private File getApplicationBundleFile(@NotNull String applicationName) {
    for (String applicationsDirectory : ApplicationDictionary.APP_BUNDLE_DIRECTORIES) {
      for (String ext : ApplicationDictionary.SUPPORTED_EXTENSIONS) {
        String appBundleFilePath = applicationsDirectory + "/" + applicationName + "." + ext;
        File applicationFile = new File(appBundleFilePath);
        if (applicationFile.exists()) return applicationFile;
      }
    }
    return null;
  }

  /**
   * Initializes dictionary information for given application and caches generated dictionary file for later use <br>
   * by {@link com.idea.plugin.applescript.lang.sdef.ApplicationDictionary} psi class
   *
   * @param applicationVFile Path to the application bundle file (.app, .xml, osax extensions are supported)
   * @param applicationName  Name of the Mac OS X application
   * @return File path String of generated and initialized dictionary for application
   */
  public synchronized String initializeDictionaryFromApplicationFile(@NotNull VirtualFile applicationVFile,
                                                                     @NotNull String applicationName) {
    if (!ApplicationDictionaryImpl.extensionSupported(applicationVFile.getExtension()))
      return null;

    String generatedDictionaryFilePath = getGeneratedDictionaryFilePath(applicationName);
    if (generatedDictionaryFilePath == null) {
      generatedDictionaryFilePath = generateDictionaryFileForApplication(applicationName, applicationVFile);
    }
    if (generatedDictionaryFilePath != null) {
      File generatedXmlFile = new File(generatedDictionaryFilePath);
      if (parseDictionaryFromGeneratedFile(generatedXmlFile, applicationName)) {
        return generatedDictionaryFilePath;
      } else {
        //if parsing failed for some reason, remove that generated dictionary file from cached files
        System.out.println("WARNING: initialization failed for application [" + applicationName + "].");
        applicationNameToGeneratedDictionaryPathMap.remove(applicationName);
      }
    }
    return null;
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
          initializeDictionaryFromApplicationFile(virtualFile, applicationName);
        }
      }
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }
  }

  @Nullable
  private String generateDictionaryFileForApplication(@NotNull final String applicationName,
                                                      @NotNull final VirtualFile virtualApplicationFile) {
    if (!SystemInfo.isMac && !"xml".equals(virtualApplicationFile.getExtension()))
      return null;

    System.out.println("=== Caching Dictionary for application [" + applicationName + "] ===");
    LOG.info("=== Caching Dictionary for application [" + applicationName + "] ===");
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
      if (!SystemInfo.isMac && "xml".equals(virtualApplicationFile.getExtension())) {

        final VirtualFile vAppFileDir = LocalFileSystem.getInstance().findFileByIoFile(targetFile.getParentFile());
        if (vAppFileDir != null && (vAppFileDir.findChild(targetFile.getName()) == null)) {
          final VirtualFile[] movedFile = new VirtualFile[1];
          ApplicationManager.getApplication().runWriteAction(new Runnable() {
            @Override
            public void run() {
              try {
                movedFile[0] = virtualApplicationFile.copy(this, vAppFileDir, targetFile.getName());
              } catch (IOException e) {
                e.printStackTrace();
                System.out.println("WARNING: Failed to move file " + virtualApplicationFile + " to caching directory: "
                        + targetFile);
                LOG.error("Failed to move file " + virtualApplicationFile + " to caching directory: "
                        + targetFile);
                if (targetFile.delete()) {
                  System.out.println("File deleted.");
                  LOG.info("File deleted.");
                }
              }
            }
          });
          if (movedFile[0] != null && movedFile[0].exists()) {
            System.out.println("Application file moved to " + vAppFileDir + "directory");
            LOG.info("Application file moved to " + vAppFileDir + "directory");
            applicationNameToGeneratedDictionaryPathMap.put(applicationName, cachedDictionaryPath);
            return cachedDictionaryPath;
          }
        }

      } else {
        final String[] shellCommand = new String[]{"/bin/bash", "-c", " " + cmdName + " \"" + appFileFinalPath + "\" " +
                "> " +

                cachedDictionaryPath};
        System.out.println("executing command: " + Arrays.toString(shellCommand));
        LOG.info("executing command: " + Arrays.toString(shellCommand));
        long execStart = System.currentTimeMillis();
        int exitCode = 0;
        try {
          exitCode = Runtime.getRuntime().exec(shellCommand).waitFor();
          long execEnd = System.currentTimeMillis();
          System.out.println("Exit code = " + exitCode + " Execution time: " + (execEnd - execStart) + " ms.");
          LOG.info("Exit code = " + exitCode + " Execution time: " + (execEnd - execStart) + " ms.");
          if (exitCode == 0) {
            applicationNameToGeneratedDictionaryPathMap.put(applicationName, cachedDictionaryPath);
            return cachedDictionaryPath;
          }
        } catch (InterruptedException e) {
          e.printStackTrace();
        } catch (IOException e) {
          e.printStackTrace();
        }
        System.out.println("WARNING: Command failed: exit code!=0. Dictionary was not generated");
        LOG.warn("Command failed: exit code!=0. Dictionary was not generated");
        if (targetFile.delete()) {
          System.out.println("Generated file was deleted");
          LOG.info("Generated file was deleted");
        }
      }
    }
    return null;
  }

  private String serializeDictionaryPathForApplication(@NotNull String applicationName) {
    char sep = File.separatorChar;
    String unescaped = GENERATED_DICTIONARIES_SYSTEM_FOLDER + "/" + applicationName + "_generated.xml";
    return unescaped.replaceAll(" ", "_");
  }

  @Nullable
  public String getGeneratedDictionaryFilePath(@Nullable String applicationName) {
    return applicationNameToGeneratedDictionaryPathMap.get(applicationName);
  }

  @NotNull
  public Collection<String> getCachedApplicationNames() {
    return applicationNameToGeneratedDictionaryPathMap.keySet();
  }

  @NotNull
  public List<String> getAllSystemApplicationNames() {
    return allSystemApplicationNames;
  }

  public boolean isApplicationKnown(String applicationName) {
    return allSystemApplicationNames.contains(applicationName)
            || applicationNameToGeneratedDictionaryPathMap.containsKey(applicationName);
  }

  @Override
  public void disposeComponent() {

  }

  @NotNull
  @Override
  public String getComponentName() {
    return COMPONENT_NAME;
  }

  private boolean parseDictionaryFromGeneratedFile(@NotNull File xmlFile, @NotNull String applicationName) {
    SAXBuilder builder = new SAXBuilder();
    Document document;
    try {
      document = builder.build(xmlFile);
      Element rootNode = document.getRootElement();
      List<Element> suiteElements = rootNode.getChildren();

      for (Element suiteElem : suiteElements) {
        parseSuiteElement(suiteElem, applicationName);
      }
      return true;
    } catch (JDOMException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return false;
  }

  private void parseSuiteElement(Element suiteElem, String applicationName) {
    List<Element> suiteClasses = suiteElem.getChildren("class");
    List<Element> suiteClassExtensions = suiteElem.getChildren("class-extension");
    List<Element> suiteCommands = suiteElem.getChildren("command");
    List<Element> recordTypeTags = suiteElem.getChildren("record-type");
    List<Element> enumerationTags = suiteElem.getChildren("enumeration");

    // initialization of different maps for standard library and other applications
    Map<String, List<String>> commandNameToApplicationNameListMap;
    Map<String, List<String>> recordNameToApplicationNameListMap;
    Map<String, List<String>> propertyNameToApplicationNameListMap;
    Map<String, List<String>> enumerationNameToApplicationNameListMap;
    Map<String, List<String>> enumeratorConstantNameToApplicationNameListMap;

    if (!ApplicationDictionary.STD_LIBRARY_NAMES.contains(applicationName)) {
      commandNameToApplicationNameListMap = this.commandNameToApplicationNameListMap;
      recordNameToApplicationNameListMap = this.recordNameToApplicationNameListMap;
      propertyNameToApplicationNameListMap = this.propertyNameToApplicationNameListMap;
      enumerationNameToApplicationNameListMap = this.enumerationNameToApplicationNameListMap;
      enumeratorConstantNameToApplicationNameListMap = this.enumeratorConstantNameToApplicationNameListMap;
    } else {
      commandNameToApplicationNameListMap = stdCommandNameToApplicationNameListMap;
      recordNameToApplicationNameListMap = stdRecordNameToApplicationNameListMap;
      propertyNameToApplicationNameListMap = stdPropertyNameToApplicationNameListMap;
      enumerationNameToApplicationNameListMap = stdEnumerationNameToApplicationNameListMap;
      enumeratorConstantNameToApplicationNameListMap = stdEnumeratorConstantNameToApplicationNameListMap;
    }

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

    if (!ApplicationDictionary.STD_LIBRARY_NAMES.contains(applicationName)) {
      updateApplicationNameListFor(className, applicationName, classNameToApplicationNameListMap);
      updateApplicationNameListFor(pluralClassName, applicationName, classNamePluralToApplicationNameListMap);
    } else {
      updateApplicationNameListFor(className, applicationName, stdClassNameToApplicationNameListMap);
      updateApplicationNameListFor(pluralClassName, applicationName, stdClassNamePluralToApplicationNameListMap);
    }
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
