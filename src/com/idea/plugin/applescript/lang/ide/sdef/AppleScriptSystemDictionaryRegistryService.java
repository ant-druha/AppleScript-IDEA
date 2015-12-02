package com.idea.plugin.applescript.lang.ide.sdef;

import com.idea.plugin.applescript.lang.parser.ParsableScriptHelper;
import com.idea.plugin.applescript.lang.sdef.AppleScriptCommand;
import com.idea.plugin.applescript.lang.sdef.ApplicationDictionary;
import com.idea.plugin.applescript.lang.util.MyStopVisitingException;
import com.idea.plugin.applescript.psi.sdef.impl.ApplicationDictionaryImpl;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.application.PathManager;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.SystemInfo;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VfsUtilCore;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileVisitor;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

public class AppleScriptSystemDictionaryRegistryService implements ParsableScriptHelper {

  private static final Logger LOG = Logger.getInstance("#" + AppleScriptSystemDictionaryRegistryService.class.getName
          ());

  //persisted data
  private final Map<String, String> applicationNameToGeneratedDictionaryPathMap = new HashMap<String, String>();
  private final Map<String, VirtualFile> applicationNameToGeneratedDictionaryFileMap = new HashMap<String,
          VirtualFile>();

  private final List<String> notScriptableApplicationList = new ArrayList<String>();
  private final List<String> unknownApplicationList = new ArrayList<String>();

  private final List<String> allSystemApplicationNames = new ArrayList<String>();
  public static final String GENERATED_DICTIONARIES_SYSTEM_FOLDER = PathManager.getSystemPath() + "/sdef";
  private static final int APP_DEPTH_SEARCH = 3;

  private final Map<String, HashSet<String>> applicationNameToClassNameSetMap = new HashMap<String, HashSet<String>>();
  private final Map<String, HashSet<String>> applicationNameToClassNamePluralSetMap = new HashMap<String,
          HashSet<String>>();
  private final Map<String, HashSet<String>> applicationNameToCommandNameSetMap = new HashMap<String,
          HashSet<String>>();
  private final Map<String, HashSet<String>> applicationNameToRecordNameSetMap = new HashMap<String, HashSet<String>>();
  private final Map<String, HashSet<String>> applicationNameToPropertySetMap = new HashMap<String, HashSet<String>>();
  private final Map<String, HashSet<String>> applicationNameToEnumerationNameSetMap = new HashMap<String,
          HashSet<String>>();
  private final Map<String, HashSet<String>> applicationNameToEnumeratorConstantNameSetMap = new HashMap<String,
          HashSet<String>>();
  private final Map<String, HashSet<String>> stdClassNameToApplicationNameSetMap = new HashMap<String,
          HashSet<String>>();
  private final Map<String, HashSet<String>> stdClassNamePluralToApplicationNameSetMap = new HashMap<String,
          HashSet<String>>();
  private final Map<String, HashSet<String>> stdCommandNameToApplicationNameSetMap = new HashMap<String,
          HashSet<String>>();
  private final Map<String, HashSet<String>> stdRecordNameToApplicationNameSetMap = new HashMap<String,
          HashSet<String>>();
  private final Map<String, HashSet<String>> stdPropertyNameToDictionarySetMap = new HashMap<String, HashSet<String>>();
  private final Map<String, HashSet<String>> stdEnumerationNameToApplicationNameSetMap = new HashMap<String,
          HashSet<String>>();
  private final Map<String, HashSet<String>> stdEnumeratorConstantNameToApplicationNameListMap = new HashMap<String,
          HashSet<String>>();

  public AppleScriptSystemDictionaryRegistryService(@NotNull AppleScriptSystemDictionaryRegistryComponent
                                                            systemDictionaryRegistry) {
    initDictionaryPathsFromCache(systemDictionaryRegistry);
    initStandardSuite();
    initDictionariesFromCachedFiles();
    discoverInstalledApplicationNames();
  }

  private void initDictionaryPathsFromCache(@NotNull AppleScriptSystemDictionaryRegistryComponent
                                                    systemDictionaryRegistry) {
    applicationNameToGeneratedDictionaryPathMap
            .putAll(systemDictionaryRegistry.getApplicationNameToGeneratedDictionaryUrlMap());
    for (Map.Entry<String, String> stringEntry : applicationNameToGeneratedDictionaryPathMap.entrySet()) {
      VirtualFile vFile = LocalFileSystem.getInstance().findFileByPath(stringEntry.getValue());
      if (vFile != null && vFile.exists()) {
        applicationNameToGeneratedDictionaryFileMap.put(stringEntry.getKey(), vFile);
      }
    }
  }

  public Map<String, String> getApplicationNameToGeneratedDictionaryPathMap() {
    return applicationNameToGeneratedDictionaryPathMap;
  }

  public Map<String, VirtualFile> getApplicationNameToGeneratedDictionaryFileMap() {
    return applicationNameToGeneratedDictionaryFileMap;
  }

  public Map<String, HashSet<String>> getApplicationNameToClassNameSetMap() {
    return applicationNameToClassNameSetMap;
  }

  private void discoverInstalledApplicationNames() {
    for (String applicationsDirectory : ApplicationDictionary.APP_BUNDLE_DIRECTORIES) {
      VirtualFile appsDirVFile = LocalFileSystem.getInstance().findFileByPath(applicationsDirectory);
      if (appsDirVFile != null && appsDirVFile.exists()) {
        processApplicationsDirectory(appsDirVFile);
      }
    }
    System.out.println("System.out: List of installed applications initialized. Count: " + allSystemApplicationNames
            .size());
    LOG.info("List of installed applications initialized. Count: " + allSystemApplicationNames.size());
  }

  private void processApplicationsDirectory(@NotNull VirtualFile appsDirVFile) {
    VfsUtilCore.visitChildrenRecursively(appsDirVFile, new VirtualFileVisitor(VirtualFileVisitor.limit
            (APP_DEPTH_SEARCH)) {
      @Override
      public boolean visitFile(@NotNull VirtualFile file) {
        if (ApplicationDictionaryImpl.extensionSupported(file.getExtension())) {
          if (!"xml".equals(file.getExtension())) {
            allSystemApplicationNames.add(file.getNameWithoutExtension());
          }
          return false;
        }
        return file.isDirectory();
      }
    });
  }

  @Override
  public boolean isStdLibClass(@NotNull String name) {
    return stdClassNameToApplicationNameSetMap.containsKey(name);
  }

  @Override
  public boolean isApplicationClass(@NotNull String applicationName, @NotNull String className) {
    HashSet<String> classNameSet = applicationNameToClassNameSetMap.get(applicationName);
    return classNameSet != null && classNameSet.contains(className);
  }

  @Override
  public boolean isStdLibClassPluralName(@NotNull String pluralName) {
    return stdClassNamePluralToApplicationNameSetMap.containsKey(pluralName);
  }

  @Override
  public boolean isApplicationClassPluralName(@NotNull String applicationName, @NotNull String pluralClassName) {
    HashSet<String> pluralClassNameSet = applicationNameToClassNamePluralSetMap.get(applicationName);
    return pluralClassNameSet != null && pluralClassNameSet.contains(pluralClassName);
  }

  @Override
  public boolean isStdClassWithPrefixExist(@NotNull String classNamePrefix) {
    return isNameWithPrefixExist(classNamePrefix, stdClassNameToApplicationNameSetMap.keySet());
  }

  @Override
  public boolean isClassWithPrefixExist(@NotNull String applicationName, @NotNull String classNamePrefix) {
    return isNameWithPrefixExist(classNamePrefix, applicationNameToClassNameSetMap.get(applicationName));
  }

  @Override
  public boolean isStdClassPluralWithPrefixExist(@NotNull String namePrefix) {
    return isNameWithPrefixExist(namePrefix, stdClassNamePluralToApplicationNameSetMap.keySet());
  }

  @Override
  public boolean isClassPluralWithPrefixExist(@NotNull String applicationName, @NotNull String pluralClassNamePrefix) {
    return isNameWithPrefixExist(pluralClassNamePrefix, applicationNameToClassNamePluralSetMap.get(applicationName));
  }

  private boolean isNameWithPrefixExist(@NotNull String namePrefix,
                                        Set<String> nameSet) {
    if (nameSet == null) return false;
    for (String objectName : nameSet) {
      if (startsWithWord(objectName, namePrefix)) return true;
    }
    return false;
  }

  //todo: think about performance enhancement - where better to call this method in parser?
  public boolean ensureDictionaryInitialized(@NotNull String applicationName) {
    boolean result = applicationNameToGeneratedDictionaryPathMap.containsKey(applicationName)
            || !StringUtil.isEmptyOrSpaces(applicationName)
            && !isNotScriptable(applicationName)
            && initializeDictionaryForApplication(applicationName) != null;
    if (!result)
      LOG.warn("Application dictionary was not initialized for application: " + applicationName);
    return result;
  }

  @Override
  public boolean isStdCommand(@NotNull String name) {
    return stdCommandNameToApplicationNameSetMap.containsKey(name);
  }

  @Override
  public boolean isApplicationCommand(@NotNull String applicationName, @NotNull String commandName) {
    HashSet<String> appCommands = applicationNameToCommandNameSetMap.get(applicationName);
    return appCommands != null && appCommands.contains(commandName);
  }

  @Override
  public boolean isCommandWithPrefixExist(@NotNull String applicationName, @NotNull String commandNamePrefix) {
    return isNameWithPrefixExist(commandNamePrefix, applicationNameToCommandNameSetMap.get(applicationName));
  }

  @Override
  public boolean isStdCommandWithPrefixExist(@NotNull String namePrefix) {
    return isNameWithPrefixExist(namePrefix, stdCommandNameToApplicationNameSetMap.keySet());
  }

  @NotNull
  @Override
  public Collection<AppleScriptCommand> findStdCommands(@NotNull Project project, @NotNull String commandName) {
    HashSet<String> appNameList = stdCommandNameToApplicationNameSetMap.get(commandName);
    if (appNameList == null) return new HashSet<AppleScriptCommand>(0);

    HashSet<AppleScriptCommand> result = new HashSet<AppleScriptCommand>();
    for (String applicationName : appNameList) {
      result.addAll(findApplicationCommands(project, applicationName, commandName));
    }
    return result;
  }

  @NotNull
  @Override
  public List<AppleScriptCommand> findApplicationCommands(@NotNull Project project, @NotNull String applicationName,
                                                          @NotNull String commandName) {
//    ensureApplicationInitialized(applicationName);
    AppleScriptProjectDictionaryService projectDictionaryRegistry =
            ServiceManager.getService(project, AppleScriptProjectDictionaryService.class);
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
    return new ArrayList<AppleScriptCommand>(0);// TODO: 29/11/15 use predefined empty list here
  }

  @Override
  public boolean isStdProperty(@NotNull String name) {
    return stdPropertyNameToDictionarySetMap.containsKey(name);
  }

  @Override
  public boolean isStdPropertyWithPrefixExist(@NotNull String namePrefix) {
    return isNameWithPrefixExist(namePrefix, stdPropertyNameToDictionarySetMap.keySet());
  }

  @Override
  public boolean isApplicationProperty(@NotNull String applicationName, @NotNull String propertyName) {
    HashSet<String> propertySet = applicationNameToPropertySetMap.get(applicationName);
    return propertySet != null && propertySet.contains(propertyName);
  }

  @Override
  public boolean isPropertyWithPrefixExist(@NotNull String applicationName, @NotNull String propertyNamePrefix) {
    return isNameWithPrefixExist(propertyNamePrefix, applicationNameToPropertySetMap.get(applicationName));
  }

  @Override
  public boolean isStdConstant(@NotNull String name) {
    return stdEnumeratorConstantNameToApplicationNameListMap.containsKey(name);
  }

  @Override
  public boolean isApplicationConstant(@NotNull String applicationName, @NotNull String constantName) {
    HashSet<String> applicationConstantSet = applicationNameToEnumeratorConstantNameSetMap.get(applicationName);
    return applicationConstantSet != null && applicationConstantSet.contains(constantName);
  }

  @Override
  public boolean isStdConstantWithPrefixExist(@NotNull String namePrefix) {
    return isNameWithPrefixExist(namePrefix, stdEnumeratorConstantNameToApplicationNameListMap.keySet());
  }

  @Override
  public boolean isConstantWithPrefixExist(@NotNull String applicationName, @NotNull String namePrefix) {
    return isNameWithPrefixExist(namePrefix, applicationNameToEnumeratorConstantNameSetMap.get(applicationName));
  }

  private void initDictionariesFromCachedFiles() {
    Collection<String> myCachedApplications = applicationNameToGeneratedDictionaryPathMap.keySet();
    Collection<String> myCachedApplicationNames = applicationNameToGeneratedDictionaryFileMap.keySet();
    //init from previously generated files
    for (Map.Entry<String, String> appNameToFile : applicationNameToGeneratedDictionaryPathMap.entrySet()) {
      VirtualFile dictionaryVFile = LocalFileSystem.getInstance().findFileByPath(appNameToFile.getValue());
      if (dictionaryVFile != null && dictionaryVFile.exists()) {
        if (!initializeFromGeneratedFile(appNameToFile.getKey(), appNameToFile.getValue())) {
          System.out.println("WARNING: failed to initialize dictionary for application: " + appNameToFile.getKey() +
                  " from generated file " + appNameToFile.getValue());
          LOG.warn("Failed to initialize dictionary for application: " + appNameToFile.getKey() +
                  " from generated file " + appNameToFile.getValue());
        }
      } else {
        System.out.println("WARNING: failed to initialize dictionary for application: " + appNameToFile.getKey() +
                "Dictionary file " + appNameToFile.getValue() + " is not valid");
        LOG.warn("Failed to initialize dictionary for application: " + appNameToFile.getKey() +
                "Dictionary file " + appNameToFile.getValue() + " is not valid");
      }
    }
//    List<String> myDefaultApplicationList = Arrays.asList("Mail", "BBEdit", "Satimage", "Finder", "System Events",
//            "TextEdit", "Smile");
//    for (String defaultApp : myDefaultApplicationList) {
//      if (!myCachedApplications.contains(defaultApp)) {
//        if (initializeDictionaryForApplication(defaultApp) == null) {
//          System.out.println("WARNING: failed to initialize dictionary for application: " + defaultApp);
//          LOG.warn("Failed to initialize dictionary for application: " + defaultApp);
//        }
//      }
//    }
  }

  /**
   * Initializes dictionary information for given application. Caches (if was not previously) generated dictionary
   * file for later use <br> by {@link ApplicationDictionary} psi class. Standard application paths are
   * checked when searching the application
   *
   * @param applicationName Name of the Mac OS application
   * @return File path of generated and cached dictionary for the application
   */
  @Nullable
  public String initializeDictionaryForApplication(@NotNull String applicationName) {
    if (StringUtil.isEmptyOrSpaces(applicationName) || isNotScriptable(applicationName)
            || isInUnknownList(applicationName))
      return null;
    final String savedDictionaryFilePath = getSavedDictionaryFilePath(applicationName);
    if (savedDictionaryFilePath != null) {
      if (initializeFromGeneratedFile(applicationName, savedDictionaryFilePath)) {
        return savedDictionaryFilePath;
      }
    }
    final VirtualFile vAppFile = findApplicationBundleFile(applicationName);
    if (vAppFile != null) {
      return initializeDictionaryFromApplicationFile(vAppFile, applicationName);
    }
    return null;
  }

  @Nullable
  private VirtualFile findApplicationBundleFile(@NotNull String applicationName) {
    if (!SystemInfo.isMac) return null;
    //speed search first
    for (String applicationsDirectory : ApplicationDictionary.APP_BUNDLE_DIRECTORIES) {
      for (String ext : ApplicationDictionary.SUPPORTED_APPLICATION_EXTENSIONS) {
        final String appBundleFilePath = applicationsDirectory + "/" + applicationName + "." + ext;
        final VirtualFile appsDirVFile = LocalFileSystem.getInstance().findFileByPath(appBundleFilePath);
        if (appsDirVFile != null && appsDirVFile.exists()) return appsDirVFile;
      }
    }
    for (String applicationsDirectory : ApplicationDictionary.APP_BUNDLE_DIRECTORIES) {
      final VirtualFile appsDirVFile = LocalFileSystem.getInstance().findFileByPath(applicationsDirectory);
      if (appsDirVFile != null && appsDirVFile.exists()) {
        VirtualFile appBundleFile = findApplicationFileRecursively(appsDirVFile, applicationName);
        if (appBundleFile != null && appBundleFile.exists()) return appBundleFile;
      }
    }
    LOG.warn("No file was found for application: " + applicationName + " in roots: " +
            Arrays.toString(ApplicationDictionary.APP_BUNDLE_DIRECTORIES) + " Adding application to " +
            "unknown applications list.");
    unknownApplicationList.add(applicationName);
    return null;
  }

  private VirtualFile findApplicationFileRecursively(@NotNull VirtualFile appsDirVFile,
                                                     @NotNull final String applicationName) {
    final VirtualFileVisitor<VirtualFile> fileVisitor = new VirtualFileVisitor<VirtualFile>(VirtualFileVisitor
            .limit(APP_DEPTH_SEARCH), VirtualFileVisitor.SKIP_ROOT, VirtualFileVisitor.NO_FOLLOW_SYMLINKS) {
      @Override
      public boolean visitFile(@NotNull VirtualFile file) {
        if (ApplicationDictionary.SUPPORTED_APPLICATION_EXTENSIONS.contains(file.getExtension())) {
          if (applicationName.equals(file.getNameWithoutExtension())) {
            throw new MyStopVisitingException(file);
          }
          return false; //do not search inside application bundles
        }
        return true;
      }
    };
    try {
      VfsUtilCore.visitChildrenRecursively(appsDirVFile, fileVisitor, MyStopVisitingException.class);
    } catch (MyStopVisitingException e) {
      LOG.info("Application file found for application " + applicationName + " : " + e.geResult());
      return e.geResult();
    }
//    LOG.warn("No file was found in root:" + appsDirVFile + " for application: " + applicationName);
    return null;
  }

  // TODO: 29/11/15 throw and catch exceptions with different failed reasons

  /**
   * Initializes dictionary information for given application from application file and caches generated
   * dictionary file for later use by {@link ApplicationDictionary} PSI class
   *
   * @param applicationVFile Path to the application bundle or dictionary file (.app, .xml, .sdef, osax extensions
   *                         are supported)
   * @param applicationName  Name of the Mac OS X application
   * @return File path String of generated and initialized dictionary for application
   */
  public synchronized String initializeDictionaryFromApplicationFile(@NotNull VirtualFile applicationVFile,
                                                                     @NotNull String applicationName) {
    if (isNotScriptable(applicationName)) return null;
    if (!ApplicationDictionaryImpl.extensionSupported(applicationVFile.getExtension())) return null;
    if (getGeneratedDictionaryFile(applicationName) != null) {
      LOG.warn("Dictionary for application " + applicationName + " was already initialized. Generating new " +
              "dictionary file any way.");
      System.out.println("Dictionary for application " + applicationName + " was already initialized. Generating new " +
              "dictionary file any way.");
    }
    final String generatedDictionaryFilePath = generateDictionaryFileForApplication(applicationName, applicationVFile);
    if (generatedDictionaryFilePath != null) {
      if (initializeFromGeneratedFile(applicationName, generatedDictionaryFilePath))
        return generatedDictionaryFilePath;
    }
    return null;
  }

  /**
   * Parses given file and initializes this dictionary's terms
   *
   * @param applicationName             name of the application
   * @param generatedDictionaryFilePath path to dictionary file
   * @return true if file parsed successfully, false otherwise
   */
  private boolean initializeFromGeneratedFile(@NotNull String applicationName,
                                              @NotNull String generatedDictionaryFilePath) {
    File generatedXmlFile = new File(generatedDictionaryFilePath);
    if (parseDictionaryFromGeneratedFile(generatedXmlFile, applicationName)) {
      return true;
    }
    //if parsing failed for some reason, remove that generated dictionary file from cached files
    System.out.println("WARNING: initialization failed for application [" + applicationName + "].");
    LOG.warn("Initialization failed for application [" + applicationName + "].");
    applicationNameToGeneratedDictionaryPathMap.remove(applicationName);
    applicationNameToGeneratedDictionaryFileMap.remove(applicationName);
    return false;
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
          if (applicationNameToGeneratedDictionaryPathMap.containsKey(applicationName)) continue; //will cache later

          initializeDictionaryFromApplicationFile(virtualFile, applicationName);
        } else {
          LOG.warn("Can not find standard suite dictionary in the classpath");
        }
      }
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }
  }

  @Nullable
  private String generateDictionaryFileForApplication(@NotNull final String applicationName,
                                                      @NotNull final VirtualFile virtualApplicationFile) {
    if (!SystemInfo.isMac && !"xml".equals(virtualApplicationFile.getExtension())) return null;

    System.out.println("=== Caching Dictionary for application [" + applicationName + "] ===");
    LOG.info("=== Caching Dictionary for application [" + applicationName + "] ===");
    final String serializePath = serializeDictionaryPathForApplication(applicationName);
    boolean fileGenerated = false;
    final File targetFile = new File(serializePath);
    if (!targetFile.getParentFile().exists() && !targetFile.getParentFile().mkdirs()) return null;
    try {
      if (!SystemInfo.isMac && "xml".equals(virtualApplicationFile.getExtension())) {
        // TODO: 02/12/15 refactor method to return Virtual file
        fileGenerated = copyDictionaryFileToCacheDir(applicationName, virtualApplicationFile, serializePath, true);
      } else if (SystemInfo.isMac) {
        String cmdName;
        if ("xml".equals(virtualApplicationFile.getExtension())) {
          cmdName = "cat";
        } else {
          cmdName = "sdef";
        }
        // TODO: 02/12/15 refactor method to return Virtual file
        fileGenerated = doGenerateDictionaryFile(applicationName, serializePath, cmdName,
                virtualApplicationFile.getPath());
      }
    } catch (NotScriptableApplicationException e) {
      System.out.println("WARNING: Generation failed: " + e.getMessage() + ". Adding to ignore list");
      LOG.warn("Generation failed: " + e.getMessage() + ". Adding to ignore list");
      notScriptableApplicationList.add(e.getApplicationName());
    } finally {
      if (!fileGenerated && targetFile.delete()) {
        System.out.println("Error occurred while generating file. Created file was deleted");
        LOG.warn("Error occurred while generating file. Created file was deleted");
      } else if (fileGenerated) {
        applicationNameToGeneratedDictionaryPathMap.put(applicationName, serializePath);
        final VirtualFile cachedFile = LocalFileSystem.getInstance().findFileByPath(serializePath);
        if (cachedFile != null) {
          applicationNameToGeneratedDictionaryFileMap.put(applicationName, cachedFile);
        }
        unknownApplicationList.remove(applicationName);
      }
    }
    return fileGenerated ? serializePath : null;
  }

  private boolean doGenerateDictionaryFile(@NotNull final String applicationName,
                                           @NotNull final String serializePath,
                                           @NotNull final String cmdName,
                                           @NotNull final String appFilePath) throws NotScriptableApplicationException {
    final String[] shellCommand = new String[]{"/bin/bash", "-c", " " + cmdName + " \"" + appFilePath + "\" " +
            "> " + serializePath};
    System.out.println("executing command: " + Arrays.toString(shellCommand));
    LOG.info("executing command: " + Arrays.toString(shellCommand));
    Integer exitCode;
    try {
      long execStart = System.currentTimeMillis();
      exitCode = Runtime.getRuntime().exec(shellCommand).waitFor();
      long execEnd = System.currentTimeMillis();
      if (exitCode != 0) throw new NotScriptableApplicationException(applicationName, "Command " +
              Arrays.toString(shellCommand) + "failed with code=" + exitCode + ". Looks like application \""
              + applicationName + "\" is not scriptable.");

      System.out.println("Exit code = " + exitCode + " Execution time: " + (execEnd - execStart) + " ms.");
      LOG.info("Exit code = " + exitCode + " Execution time: " + (execEnd - execStart) + " ms.");

//      applicationNameToGeneratedDictionaryPathMap.put(applicationName, serializePath);
//      final VirtualFile cachedFile = LocalFileSystem.getInstance().findFileByPath(serializePath);
//      if (cachedFile != null) {
//        applicationNameToGeneratedDictionaryFileMap.put(applicationName, cachedFile);
//      }
      return true;
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return false;
  }

  private boolean copyDictionaryFileToCacheDir(@NotNull final String applicationName,
                                               @NotNull final VirtualFile virtualApplicationFile,
                                               @NotNull final String serializePath,
                                               final boolean rewrite) {
    // TODO: 12/1/2015 refactor: extract all needed parameters
    final File targetFile = new File(serializePath);
    final String fileName = targetFile.getName();
    final VirtualFile vAppFileDir = LocalFileSystem.getInstance().findFileByIoFile(targetFile.getParentFile());
    if (vAppFileDir == null) return false;
    final VirtualFile targetVFile = vAppFileDir.findChild(fileName);

    final VirtualFile[] movedFile = new VirtualFile[1];
    if (targetVFile == null || rewrite) {
      ApplicationManager.getApplication().runWriteAction(new Runnable() {
        @Override
        public void run() {
          try {
            if (targetVFile != null && targetVFile.exists()) {
              targetVFile.delete(this);
            }
            movedFile[0] = virtualApplicationFile.copy(this, vAppFileDir, fileName);
          } catch (IOException e) {
            e.printStackTrace();
            System.out.println("WARNING: Failed to move file " + virtualApplicationFile + " to cache directory: "
                    + targetFile);
            LOG.error("Failed to move file " + virtualApplicationFile + " to cache directory: "
                    + targetFile);
          }
        }
      });
    } else if (vAppFileDir.findChild(targetFile.getName()) != null) {
      movedFile[0] = vAppFileDir.findChild(targetFile.getName());
      LOG.info("Generated file already exists for application " + applicationName);
      System.out.println("Generated file already exists for application " + applicationName);
    }
    if (movedFile[0] != null && movedFile[0].exists()) {
      System.out.println("Dictionary file moved to " + vAppFileDir + " directory");
      LOG.info("Dictionary file moved to " + vAppFileDir + " directory");
      return true;
    }
    return false;
  }

  /**
   * @param applicationName name of the application
   * @return true if '/usr/bin/sdef' command to generate dictionary for this application previously failed
   */
  public boolean isNotScriptable(@NotNull String applicationName) {
    return notScriptableApplicationList.contains(applicationName);
  }

  /**
   * @param applicationName name of the application
   * @return true if application file was not found previously in {@link #findApplicationBundleFile(java.lang.String)}
   */
  public boolean isInUnknownList(@NotNull String applicationName) {
    return unknownApplicationList.contains(applicationName);
  }

  private String serializeDictionaryPathForApplication(@NotNull String applicationName) {
    String unescaped = GENERATED_DICTIONARIES_SYSTEM_FOLDER + "/" + applicationName + "_generated.xml";
    return unescaped.replaceAll(" ", "_");
  }

  @Nullable
  public String getSavedDictionaryFilePath(@Nullable String applicationName) {
    return applicationNameToGeneratedDictionaryPathMap.get(applicationName);
  }

  @Nullable
  public VirtualFile getGeneratedDictionaryFile(@Nullable String applicationName) {
    return applicationNameToGeneratedDictionaryFileMap.get(applicationName);
  }

  @NotNull
  public Collection<String> getCachedApplicationNames() {
    return applicationNameToGeneratedDictionaryPathMap.keySet();
  }

  @NotNull
  public List<String> getAllSystemApplicationNames() {
    return allSystemApplicationNames;
  }

  public boolean wasDictionaryGenerated(@NotNull String applicationName) {
    return applicationNameToGeneratedDictionaryPathMap.containsKey(applicationName);
  }

  private boolean parseDictionaryFromGeneratedFile(@NotNull File xmlFile, @NotNull String applicationName) {
    SAXBuilder builder = new SAXBuilder();
    Document document;
    try {
      // TODO: 12/1/2015 handle <!DOCTYPE dictionary SYSTEM "file://localhost/System/Library/DTDs/sdef.dtd"> in Windows
      document = builder.build(xmlFile);
      Element rootNode = document.getRootElement();
      List<Element> suiteElements = rootNode.getChildren();

      if (ApplicationDictionary.STANDARD_ADDITIONS_LIBRARY.equals(applicationName)) {
        for (Element suiteElem : suiteElements) {
          parseSuiteElementForApplication(suiteElem, applicationName);
          parseSuiteElementForStandardAdditions(suiteElem);
        }
      } else {
        for (Element suiteElem : suiteElements) {
          parseSuiteElementForApplication(suiteElem, applicationName);
        }
      }
      return true;
    } catch (JDOMException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return false;
  }

  private void parseSuiteElementForStandardAdditions(@NotNull Element suiteElem) {
    String applicationName = ApplicationDictionary.STANDARD_ADDITIONS_LIBRARY;
    List<Element> suiteClasses = suiteElem.getChildren("class");
    List<Element> suiteValueTypes = suiteElem.getChildren("value-type");
    List<Element> suiteClassExtensions = suiteElem.getChildren("class-extension");
    List<Element> suiteCommands = suiteElem.getChildren("command");
    List<Element> recordTypeTags = suiteElem.getChildren("record-type");
    List<Element> enumerationTags = suiteElem.getChildren("enumeration");

    for (Element valType : suiteValueTypes) {
      parseClassElement(applicationName, valType, false);
    }

    for (Element classTag : suiteClasses) {
      parseClassElement(applicationName, classTag, false);
      List<Element> propertyElements = classTag.getChildren("property");
      parseElementsForApplication(propertyElements, applicationName, stdPropertyNameToDictionarySetMap);
    }

    for (Element classTag : suiteClassExtensions) {
      parseClassElement(applicationName, classTag, false);
      List<Element> propertyElements = classTag.getChildren("property");
      parseElementsForApplication(propertyElements, applicationName, stdPropertyNameToDictionarySetMap);
    }

    parseElementsForApplication(suiteCommands, applicationName, stdCommandNameToApplicationNameSetMap);
    parseElementsForApplication(recordTypeTags, applicationName, stdRecordNameToApplicationNameSetMap);

    for (Element recordTag : recordTypeTags) {
      List<Element> propertyElements = recordTag.getChildren("property");
      parseElementsForApplication(propertyElements, applicationName, stdPropertyNameToDictionarySetMap);
    }

    parseElementsForApplication(enumerationTags, applicationName, stdEnumerationNameToApplicationNameSetMap);

    for (Element enumerationTag : enumerationTags) {
      List<Element> enumeratorTags = enumerationTag.getChildren("enumerator");
      parseElementsForApplication(enumeratorTags, applicationName, stdEnumeratorConstantNameToApplicationNameListMap);
    }
  }

  private void parseSuiteElementForApplication(@NotNull Element suiteElem, @NotNull String applicationName) {
    Namespace n1 = Namespace.getNamespace("http://www.w3.org/2003/XInclude");
    List<Element> xiIncludes = suiteElem.getChildren("include", n1);
    List<Element> suiteClasses = suiteElem.getChildren("class");
    List<Element> suiteValueTypes = suiteElem.getChildren("value-type");
    List<Element> suiteClassExtensions = suiteElem.getChildren("class-extension");
    List<Element> suiteCommands = suiteElem.getChildren("command");
    List<Element> recordTypeTags = suiteElem.getChildren("record-type");
    List<Element> enumerationTags = suiteElem.getChildren("enumeration");

    // todo: need to move this to a single generated xml file for a dictionary (psi file is just one). Or
    // handle it (linking included file) transparently
    for (Element include : xiIncludes) {
      String hrefIncl = include.getAttributeValue("href");
      hrefIncl = hrefIncl.replace("localhost", "");
      File inclFile = new File(hrefIncl);
      if (inclFile.exists()) {
        parseDictionaryFromGeneratedFile(inclFile, applicationName);
      }
    }

    for (Element valType : suiteValueTypes) {
      parseClassElement(applicationName, valType, false);
    }

    for (Element classTag : suiteClasses) {
      parseClassElement(applicationName, classTag, false);
      List<Element> propertyElements = classTag.getChildren("property");
      parseHashElementsForApplication(propertyElements, applicationName, applicationNameToPropertySetMap);
    }

    for (Element classTag : suiteClassExtensions) {
      parseClassElement(applicationName, classTag, false);
      List<Element> propertyElements = classTag.getChildren("property");
      parseHashElementsForApplication(propertyElements, applicationName, applicationNameToPropertySetMap);
    }

    parseHashElementsForApplication(suiteCommands, applicationName, applicationNameToCommandNameSetMap);
    parseHashElementsForApplication(recordTypeTags, applicationName, applicationNameToRecordNameSetMap);

    for (Element recordTag : recordTypeTags) {
      List<Element> propertyElements = recordTag.getChildren("property");
      parseHashElementsForApplication(propertyElements, applicationName, applicationNameToPropertySetMap);
    }

    parseHashElementsForApplication(enumerationTags, applicationName, applicationNameToEnumerationNameSetMap);

    for (Element enumerationTag : enumerationTags) {
      List<Element> enumeratorTags = enumerationTag.getChildren("enumerator");
      parseHashElementsForApplication(enumeratorTags, applicationName, applicationNameToEnumeratorConstantNameSetMap);
    }


  }

  private static void parseElementsForApplication(List<Element> xmlElements, @NotNull String applicationName,
                                                  @NotNull Map<String, HashSet<String>>
                                                          objectTagNameToApplicationNameListMap) {
    for (Element applicationObjectTag : xmlElements) {
      parseSimpleElementForObject(applicationObjectTag, applicationName, objectTagNameToApplicationNameListMap);
    }
  }

  private static void parseHashElementsForApplication(List<Element> xmlElements, @NotNull String applicationName,
                                                      @NotNull Map<String, HashSet<String>>
                                                              objectTagNameToApplicationNameListMap) {
    for (Element applicationObjectTag : xmlElements) {
      hashSimpleElementForObject(applicationObjectTag, applicationName, objectTagNameToApplicationNameListMap);
    }
  }

  private static void parseSimpleElementForObject(@NotNull Element suiteObjectElement, @NotNull String applicationName,
                                                  Map<String, HashSet<String>> objectNameToApplicationNameSetMap) {
    final String objectName = suiteObjectElement.getAttributeValue("name");
    final String code = suiteObjectElement.getAttributeValue("code");
    if (objectName == null || code == null) return;

    updateApplicationNameSetFor(objectName, applicationName, objectNameToApplicationNameSetMap);
  }

  private static void hashSimpleElementForObject(@NotNull Element suiteObjectElement, @NotNull String applicationName,
                                                 Map<String, HashSet<String>> objectNameToApplicationNameListMap) {
    final String objectName = suiteObjectElement.getAttributeValue("name");
    final String code = suiteObjectElement.getAttributeValue("code");
    if (objectName == null || code == null) return;

    updateObjectNameSetForApplication(objectName, applicationName, objectNameToApplicationNameListMap);
  }

  private void parseClassElement(@NotNull String applicationName, @NotNull Element classElement, boolean isExtends) {
//    if isExtends -> name is always == "application"
    String className = isExtends ? classElement.getAttributeValue("extends") : classElement.getAttributeValue("name");
    String code = classElement.getAttributeValue("code");
    String pluralClassName = classElement.getAttributeValue("plural");
    if (className == null || code == null) return;
    pluralClassName = !StringUtil.isEmpty(pluralClassName) ? pluralClassName : className + "s";

    updateObjectNameSetForApplication(className, applicationName, applicationNameToClassNameSetMap);
    updateObjectNameSetForApplication(pluralClassName, applicationName, applicationNameToClassNamePluralSetMap);
    if (ApplicationDictionary.STANDARD_ADDITIONS_LIBRARY.equals(applicationName)) {
      updateApplicationNameSetFor(className, applicationName, stdClassNameToApplicationNameSetMap);
      updateApplicationNameSetFor(pluralClassName, applicationName, stdClassNamePluralToApplicationNameSetMap);
    }
  }

  private static void updateApplicationNameSetFor(@NotNull String applicationObjectName,
                                                  @NotNull String applicationName,
                                                  Map<String, HashSet<String>> applicationNameSetMap) {
    HashSet<String> appNameSetForObject = applicationNameSetMap.get(applicationObjectName);
    updateSetForMappedObjectName(applicationObjectName, applicationName, applicationNameSetMap, appNameSetForObject);
  }

  private static void updateSetForMappedObjectName(@NotNull String objectName,
                                                   @NotNull String nameToAdd,
                                                   @NotNull Map<String, HashSet<String>> objectNameToNameSetMap,
                                                   @Nullable HashSet<String> nameSetForObject) {
    if (nameSetForObject == null) {
      nameSetForObject = new HashSet<String>();
      if (!StringUtil.isEmpty(objectName)) {
        objectNameToNameSetMap.put(objectName, nameSetForObject);
      }
    }
    if (!nameSetForObject.contains(nameToAdd)) {
      nameSetForObject.add(nameToAdd);
    }
  }

  private static void updateObjectNameSetForApplication(@NotNull String applicationObjectName,
                                                        @NotNull String applicationName,
                                                        Map<String, HashSet<String>> applicationNameSetMap) {
    HashSet<String> objectNameSetForApplication = applicationNameSetMap.get(applicationName);
    updateSetForMappedObjectName(applicationName, applicationObjectName, applicationNameSetMap,
            objectNameSetForApplication);
  }

  @Contract("_, null -> false")
  private static boolean startsWithWord(@NotNull String string, @Nullable String prefix) {
    return prefix != null && string.startsWith(prefix) && (prefix.length() == string.length() || " ".equals(string
            .substring(prefix.length(), prefix.length() + 1)));
  }

}