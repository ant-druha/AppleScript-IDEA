package com.intellij.plugin.applescript.lang.ide.sdef;

import com.google.common.io.Files;
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
import com.intellij.plugin.applescript.lang.parser.ParsableScriptHelper;
import com.intellij.plugin.applescript.lang.sdef.AppleScriptCommand;
import com.intellij.plugin.applescript.lang.sdef.ApplicationDictionary;
import com.intellij.plugin.applescript.lang.util.MyStopVisitingException;
import com.intellij.plugin.applescript.psi.sdef.impl.ApplicationDictionaryImpl;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.*;
import java.util.*;

public class AppleScriptSystemDictionaryRegistryService implements ParsableScriptHelper {

  private static final Logger LOG = Logger.getInstance("#" +
          AppleScriptSystemDictionaryRegistryService.class.getName());

  //persisted data
  private final Map<String, DictionaryInfo> dictionaryInfoMap = new HashMap<String, DictionaryInfo>();
  private final HashSet<String> notScriptableApplicationList = new HashSet<String>();
  //scripting additions, installed in the system
  private final HashSet<String> scriptingAdditions = new HashSet<String>();
  private final HashSet<String> notFoundApplicationList = new HashSet<String>();
  private final HashSet<String> discoveredApplicationNames = new HashSet<String>();

  private File xCodeApplicationFile;

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

  private void removeDictionaryInfo(@NotNull String applicationName) {
    dictionaryInfoMap.remove(applicationName);
    notScriptableApplicationList.add(applicationName);
  }

  private void addDictionaryInfo(@NotNull DictionaryInfo info) {
    dictionaryInfoMap.put(info.getApplicationName(), info);
    discoveredApplicationNames.add(info.getApplicationName());
    notScriptableApplicationList.remove(info.getApplicationName());
  }

  public Collection<DictionaryInfo> getDictionaryInfoList() {
    return dictionaryInfoMap.values();
  }

  public HashSet<String> getNotScriptableApplicationList() {
    return notScriptableApplicationList;
  }

  @NotNull
  public HashSet<String> getScriptingAdditions() {
    return scriptingAdditions;
  }

  public AppleScriptSystemDictionaryRegistryService(@NotNull AppleScriptSystemDictionaryRegistryComponent
                                                            systemDictionaryRegistry) {
    try {
      initDictionariesInfoFromCache(systemDictionaryRegistry);
      initStandardSuite();
//    initDictionariesFromCachedFiles();
      discoverInstalledApplicationNames();
    } catch (Exception e) {
      LOG.error("Error while initializing service: " + e.getCause());
    }
  }

  /**
   * Fill {@link #dictionaryInfoMap} from saved data
   *
   * @param systemDictionaryRegistry application component, which saves/loads the data
   */
  private void initDictionariesInfoFromCache(@NotNull AppleScriptSystemDictionaryRegistryComponent
                                                     systemDictionaryRegistry) {
    notScriptableApplicationList.addAll(systemDictionaryRegistry.getNotScriptableApplications());
    LocalFileSystem.getInstance().refresh(false);
    for (DictionaryInfo.State dInfoState : systemDictionaryRegistry.getDictionariesPersistedInfo()) {
      String appName = dInfoState.applicationName;
      String dictionaryUrl = dInfoState.dictionaryUrl;
      String applicationUrl = dInfoState.applicationUrl;
      if (!StringUtil.isEmptyOrSpaces(appName) && !StringUtil.isEmptyOrSpaces(dictionaryUrl)) {
        VirtualFile dictionaryFile = !StringUtil.isEmpty(dictionaryUrl) ?
                LocalFileSystem.getInstance().findFileByPath(dictionaryUrl) : null;
        File applicationFile = !StringUtil.isEmpty(applicationUrl) ?
                new File(applicationUrl) : null;
        if (dictionaryFile != null) {
          dictionaryFile.refresh(false, false);
          if (!dictionaryFile.exists()) continue;
          DictionaryInfo dInfo = new DictionaryInfo(appName, dictionaryFile, applicationFile);
          addDictionaryInfo(dInfo);
        }
      }
    }
  }

  private void discoverInstalledApplicationNames() {
    for (String applicationsDirectory : ApplicationDictionary.APP_BUNDLE_DIRECTORIES) {
      VirtualFile appsDirVFile = LocalFileSystem.getInstance().findFileByPath(applicationsDirectory);
      if (appsDirVFile != null && appsDirVFile.exists()) {
        discoverApplicationsInDirectory(appsDirVFile);
      }
    }
    LOG.info("List of installed applications initialized. Count: " + discoveredApplicationNames.size());
  }

  private void discoverApplicationsInDirectory(@NotNull VirtualFile appsDirVFile) {
    VfsUtilCore.visitChildrenRecursively(appsDirVFile, new VirtualFileVisitor(VirtualFileVisitor.limit
            (APP_DEPTH_SEARCH)) {
      @Override
      public boolean visitFile(@NotNull VirtualFile file) {
        if (ApplicationDictionaryImpl.extensionSupported(file.getExtension())) {
          if (!"xml".equals(file.getExtension())) {
            discoveredApplicationNames.add(file.getNameWithoutExtension());
          }
          return false;
        }
        return file.isDirectory();
      }
    });
  }

  /**
   * Is called from Annotator to make sure the application's dictionary is initialized
   *
   * @param anyApplicationName name of the application
   * @return true if dictionary was initialized
   */
  public boolean ensureDictionaryInitialized(@NotNull String anyApplicationName) {
    return ensureKnownApplicationDictionaryInitialized(anyApplicationName)
            || !StringUtil.isEmptyOrSpaces(anyApplicationName) && !isNotScriptable(anyApplicationName)
            && !isInUnknownList(anyApplicationName) && getInitializedInfo(anyApplicationName) != null;
  }

  @Override
  public boolean ensureKnownApplicationDictionaryInitialized(@NotNull String knownApplicationName) {
    if (discoveredApplicationNames.contains(knownApplicationName)) {
      DictionaryInfo dInfo = dictionaryInfoMap.get(knownApplicationName);
      return dInfo != null && (dInfo.isInitialized() || initializeDictionaryFromInfo(dInfo))
              || getInitializedInfo(knownApplicationName) != null;
    }
    return false;
  }

  // ParsableScriptHelper methods

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

  /**
   * Init from saved, previously generated files. If not use it, need to make sure terms were initialized before parsing
   */
  @SuppressWarnings("unused")
  private void initDictionariesFromCachedFiles() {
    for (DictionaryInfo dictionaryInfo : dictionaryInfoMap.values()) {
      if (!initializeDictionaryFromInfo(dictionaryInfo)) {
        LOG.warn("Failed to initialize dictionary for application: " + dictionaryInfo.getApplicationName() +
                " from generated file " + dictionaryInfo.getDictionaryFile());
      } else {
        LOG.warn("Failed to initialize dictionary for application: " + dictionaryInfo.getApplicationName() +
                "Dictionary file " + dictionaryInfo.getDictionaryFile() + " is not valid");
      }
    }
  }

  /**
   * Initializes dictionary information for given application either from previously generated and saved dictionary
   * file or creates new dictionary file for this application and saves it for later use <br> by
   * {@link ApplicationDictionary} psi class. Standard folders are checked when searching for application's location
   *
   * @param applicationName Name of the Mac OS application
   * @return {@link DictionaryInfo} of the generated and cached dictionary for the application
   */
  @Nullable
  public DictionaryInfo getInitializedInfo(@NotNull final String applicationName) {
    if (StringUtil.isEmptyOrSpaces(applicationName) || isNotScriptable(applicationName)
            || isInUnknownList(applicationName))
      return null;
    final DictionaryInfo savedDictionaryInfo = getDictionaryInfo(applicationName);
    if (savedDictionaryInfo != null) {
      if (savedDictionaryInfo.isInitialized() || initializeDictionaryFromInfo(savedDictionaryInfo)) {
        return savedDictionaryInfo;
      }
    }
    final File appFile = findApplicationBundleFile(applicationName);
    if (appFile != null) {
      return createAndInitializeInfo(appFile, applicationName);
    }
    return null;
  }

  @Nullable
  private File findApplicationBundleFile(@NotNull final String applicationName) {
    if (!SystemInfo.isMac) {
      notFoundApplicationList.add(applicationName);
      return null;
    }
    //speed search first
    for (String applicationsDirectory : ApplicationDictionary.APP_BUNDLE_DIRECTORIES) {
      for (String ext : ApplicationDictionary.SUPPORTED_APPLICATION_EXTENSIONS) {
        final String appBundleFilePath = applicationsDirectory + "/" + applicationName + "." + ext;
        final File appFile = new File(appBundleFilePath);
        if (appFile.exists() && appFile.isFile()) return appFile;
      }
    }
    //search recursively in general application directories
    for (String applicationsDirectory : ApplicationDictionary.APP_BUNDLE_DIRECTORIES) {
      final File appDirectory = new File(applicationsDirectory);
      if (appDirectory.exists() && appDirectory.isDirectory()) {
        VirtualFile appVDirectory = LocalFileSystem.getInstance().findFileByIoFile(appDirectory);
        if (appVDirectory == null) continue;
        File appBundleFile = findApplicationFileRecursively(appVDirectory, applicationName);
        if (appBundleFile != null && appBundleFile.exists()) return appBundleFile;
      }
    }
    LOG.warn("No file was found for application: " + applicationName + " in roots: " +
            Arrays.toString(ApplicationDictionary.APP_BUNDLE_DIRECTORIES) + " Adding application to " +
            "unknown applications list.");
    notFoundApplicationList.add(applicationName);
    return null;
  }

  @Nullable
  private File findApplicationFileRecursively(@NotNull final VirtualFile appDirectory,
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
      VfsUtilCore.visitChildrenRecursively(appDirectory, fileVisitor, MyStopVisitingException.class);
    } catch (MyStopVisitingException e) {
      LOG.info("Application file found for application " + applicationName + " : " + e.getResult());
      return new File(e.getResult().getPath());
    }
    return null;
  }

  // TODO: 29/11/15 throw and catch exceptions with different failed reasons

  /**
   * Initializes dictionary information for given application from application bundle file (or xml/sdef dictionary file)
   * and saves generated dictionary file for later use by {@link ApplicationDictionary} PSI class
   *
   * @param applicationIoFile File of the application bundle or dictionary file (.app, .osax, .xml, .sdef extensions
   *                          are supported)
   * @param applicationName   Name of the Mac OS X application
   * @return {@link DictionaryInfo} of the generated, saved and initialized dictionary for the application
   */
  @Nullable
  public synchronized DictionaryInfo createAndInitializeInfo(@NotNull File applicationIoFile,
                                                             @NotNull String applicationName) {
//    if (isNotScriptable(applicationName)) return null;
    String appExtension = Files.getFileExtension(applicationIoFile.getPath());
    if (!ApplicationDictionaryImpl.extensionSupported(appExtension)) return null;
    if (!applicationIoFile.exists()) return null;
    if (getDictionaryInfo(applicationName) != null) {
      LOG.warn("Dictionary for application " + applicationName + " was already initialized. Generating new " +
              "dictionary file any way.");
    }
    final DictionaryInfo createdDictionaryInfo = createDictionaryInfoForApplication(applicationName, applicationIoFile);
    if (createdDictionaryInfo != null) {
      if (initializeDictionaryFromInfo(createdDictionaryInfo))
        return createdDictionaryInfo;
    }
    return null;
  }

  /**
   * @param dictionaryInfo Created for the application {@link DictionaryInfo} information
   * @return true if dictionary terms were successfully initialized
   */
  private boolean initializeDictionaryFromInfo(@NotNull final DictionaryInfo dictionaryInfo) {
    final File file = new File(dictionaryInfo.getDictionaryFile().getPath());
    final String applicationName = dictionaryInfo.getApplicationName();
    if (file.exists() && parseDictionaryFile(file, applicationName)) {
      return dictionaryInfo.setInitialized(true);
    }
    //if parsing failed for some reason, remove that generated dictionary file from cached files
    LOG.warn("Initialization failed for application [" + applicationName + "].");
    removeDictionaryInfo(applicationName);
    return false;
  }

  /**
   * initialization of Standard Terminology and installed Scripting Addition libraries
   */
  private void initStandardSuite() {
    try {
      if (SystemInfo.isMac) {
        //init scripting additions
        DictionaryInfo di = getDictionaryInfo(ApplicationDictionary.SCRIPTING_ADDITIONS_LIBRARY);
        if (di == null) {
          initializeScriptingAdditions();
          mergeScriptingAdditions();
        } else {
          initializeDictionaryFromInfo(di);
        }
        //init Standard Cocoa terminology
        final String applicationName = ApplicationDictionary.COCOA_STANDARD_LIBRARY;
        DictionaryInfo dInfo = getInitializedInfo(applicationName);
        if (dInfo != null) {
          initializeDictionaryFromInfo(dInfo);
        } else {
          //search in standard OS X location
          File stdLibFile = new File(ApplicationDictionary.COCOA_STANDARD_LIBRARY_PATH);
          //if not found, get from jar
          if (!stdLibFile.exists() || !stdLibFile.isFile()) {
            InputStream is = getClass().getResourceAsStream(ApplicationDictionary.COCOA_STANDARD_FILE);
            stdLibFile = stream2file(is, applicationName.replaceAll(" ", "_"), ".sdef");
          }
          if (stdLibFile.exists() && stdLibFile.isFile())
            createAndInitializeInfo(stdLibFile, applicationName);
          else
            LOG.warn("Can not find standard suite dictionary in the classpath");
        }
      } else {
        //init scripting additions
        initStdTerms(ApplicationDictionary.SCRIPTING_ADDITIONS_LIBRARY);
        // init cocoa standard
        initStdTerms(ApplicationDictionary.COCOA_STANDARD_LIBRARY);
      }
    } catch (IOException e) {
      LOG.error("Failed to initialize dictionary for standard terms " + e.getMessage());
      e.printStackTrace();
    }
  }

  private void initializeScriptingAdditions() {
    for (String stdLibFolder : ApplicationDictionary.SCRIPTING_ADDITIONS_FOLDERS) {
      final File dir = new File(stdLibFolder);
      if (!dir.isDirectory()) continue;
      final File[] stdLibs = dir.listFiles();
      if (stdLibs == null || stdLibs.length == 0) continue;
      for (File stdLib : stdLibs) {
        String libraryName = stdLib.getName();
        int last = libraryName.lastIndexOf(".");
        libraryName = libraryName.substring(0, last > 0 ? last : libraryName.length() - 1);
        if (StringUtil.isEmpty(libraryName)) continue;
        DictionaryInfo dInfo = getDictionaryInfo(libraryName);
        if (dInfo != null) {
          initializeDictionaryFromInfo(dInfo);
        } else {
          if (stdLib.exists())
            dInfo = createAndInitializeInfo(stdLib, libraryName);
        }
        if (dInfo != null)
          scriptingAdditions.add(dInfo.getApplicationName());
        else
          LOG.warn("Can not initialize scripting addition library from file: " + stdLib);
      }
    }
  }

  private void initStdTerms(@NotNull String stdLibName) throws IOException {
    DictionaryInfo stdDInfo = dictionaryInfoMap.get(stdLibName);
    if (stdDInfo != null) {
      initializeDictionaryFromInfo(stdDInfo);
    } else {
      String libPathResource = stdLibName.equals(ApplicationDictionary.COCOA_STANDARD_LIBRARY) ?
              ApplicationDictionary.COCOA_STANDARD_FILE :
              stdLibName.equals(ApplicationDictionary.SCRIPTING_ADDITIONS_LIBRARY) ?
                      ApplicationDictionary.STANDARD_ADDITIONS_FILE : null;
      if (libPathResource == null) return;

      InputStream isStd = getClass().getResourceAsStream(libPathResource);
      final File tmpFile = stream2file(isStd, stdLibName.replaceAll(" ", "_"), ".sdef");
      if (tmpFile.exists() && tmpFile.isFile())
        createAndInitializeInfo(tmpFile, stdLibName);
      else
        LOG.warn("Can not find standard suite dictionary in the classpath");
    }
  }

  /**
   * Create single Dictionary from all scripting additions installed in OS X
   */
  @Nullable
  private DictionaryInfo mergeScriptingAdditions() {
    try {
      List<File> dictionaryFiles = new ArrayList<File>();
      final String libName = ApplicationDictionary.SCRIPTING_ADDITIONS_LIBRARY;
      final File mergedFile = File.createTempFile(libName, ".sdef");
      for (String scriptingAddition : scriptingAdditions) {
        DictionaryInfo di = getDictionaryInfo(scriptingAddition);
        if (di == null) continue;
        dictionaryFiles.add(new File(di.getDictionaryFile().getPath()));
      }
      Iterator<File> iterator = dictionaryFiles.iterator();
      if (!iterator.hasNext()) return null;
      final File first = iterator.next();
      SAXBuilder builder = new SAXBuilder();
      final Document firstDocument = builder.build(first);
      final Element firstRoot = firstDocument.getRootElement();
      while (iterator.hasNext()) {
        File second = iterator.next();
        if (second != null) {
          Document secondDocument = builder.build(second);
          Element secondRoot = secondDocument.getRootElement();
          List<Element> suiteElements = secondRoot.getChildren("suite");
          for (Element suite : suiteElements) {
            suite = suite.clone();
            suite.detach();
            firstRoot.addContent(suite);
          }
        }
      }
      XMLOutputter outputter = new XMLOutputter();
      FileOutputStream out = new FileOutputStream(mergedFile);
      outputter.output(firstDocument, out);
      out.flush();
      out.close();
      return createAndInitializeInfo(mergedFile, libName);
    } catch (JDOMException e) {
      LOG.warn("Can not parse scripting additions file: " + e.getMessage());
      e.printStackTrace();
    } catch (IOException e) {
      LOG.warn("Can not merge scripting additions: " + e.getMessage());
      e.printStackTrace();
    } catch (Exception e) {
      LOG.warn("Can not merge scripting additions: " + e.getMessage());
      e.printStackTrace();
    }
    return null;
  }

  private static File stream2file(InputStream in, String prefix, String suffix) throws IOException {
    final File tempFile = File.createTempFile(prefix, suffix);
    tempFile.deleteOnExit();
    FileOutputStream out = new FileOutputStream(tempFile);
    int c;
    while ((c = in.read()) != -1) {
      out.write(c);
    }
    in.close();
    out.close();
    tempFile.deleteOnExit();
    return tempFile;
  }

  /**
   * Generates dictionary file and creates {@link DictionaryInfo} structure for the application
   *
   * @param applicationName   name of the application
   * @param applicationIoFile application file of dictionary file
   * @return {@link DictionaryInfo} for this application
   */
  @Nullable
  private DictionaryInfo createDictionaryInfoForApplication(@NotNull final String applicationName,
                                                            @NotNull final File applicationIoFile) {
    String appExtension = Files.getFileExtension(applicationIoFile.getPath());
    if (!SystemInfo.isMac && !("xml".equals(appExtension) || "sdef".equals(appExtension))) return null;
    DictionaryInfo dInfo;
    LOG.info("=== Caching Dictionary for application [" + applicationName + "] ===");
    final String serializePath = serializeDictionaryPathForApplication(applicationName);
    boolean fileGenerated = false;
    final File targetFile = new File(serializePath);
    if (!targetFile.getParentFile().exists() && !targetFile.getParentFile().mkdirs()) return null;
    try {
      if (!SystemInfo.isMac && ("xml".equals(appExtension)
              || "sdef".equals(appExtension))) {
        fileGenerated = copyDictionaryFileToCacheDir(applicationName, applicationIoFile, targetFile, true);
      } else if (SystemInfo.isMac) {
        String cmdName;
        if ("xml".equals(appExtension) || "sdef".equals(appExtension)) {
          cmdName = "cat";
        } else {
          cmdName = "sdef";
        }
        fileGenerated = doGenerateDictionaryFile(applicationName, serializePath, cmdName, applicationIoFile.getPath());
      }
    } catch (NotScriptableApplicationException e) {
      LOG.warn("Generation failed: " + e.getMessage() + ". Adding to ignore list");
      notScriptableApplicationList.add(e.getApplicationName());
    } catch (DeveloperToolsNotInstalledException e) {
      LOG.warn("Generation failed: " + e.getMessage() + " Will try to find application scripting definition file...");
      File sdefFile = findSdefForApplication(applicationIoFile);
      if (sdefFile != null && sdefFile.exists()) {
        fileGenerated = copyDictionaryFileToCacheDir(applicationName, sdefFile, targetFile, true);
      } else {
        LOG.warn("Scripting definition was not found for application " + applicationIoFile.getAbsolutePath());
        notScriptableApplicationList.add(applicationName);
      }
    } finally {
      if (!fileGenerated) {
        LOG.warn("Error occurred while generating file.");
        if (targetFile.delete()) LOG.warn("Created file was deleted");
      } else if (notFoundApplicationList.remove(applicationName)) {
        LOG.info("Application was removed from ignored list");
      }
    }
    if (fileGenerated && targetFile.exists()) {
      final VirtualFile generatedFile = LocalFileSystem.getInstance().findFileByIoFile(targetFile);
      if (generatedFile != null) {
        File applicationBundle = ApplicationDictionary.SUPPORTED_APPLICATION_EXTENSIONS
                .contains(appExtension) ? applicationIoFile : null;
        dInfo = new DictionaryInfo(applicationName, generatedFile, applicationBundle);
        addDictionaryInfo(dInfo);
        LOG.info("Dictionary file generated for application [" + applicationName + "]" + generatedFile);
        return dInfo;
      }
    }
    return null;
  }

  @Nullable
  private File findSdefForApplication(@NotNull File applicationIoFile) {
    File appResources = new File(applicationIoFile, "/Contents/Resources");
    File[] files = appResources.listFiles(new FilenameFilter() {
      @Override
      public boolean accept(File file, String s) {
        return s.endsWith("sdef");
      }
    });
    if (files != null && files.length > 0) {
      return files[0];
    }
    return null;
  }

  public boolean isXcodeInstalled() {
    if (!SystemInfo.isMac) return false;
    if (xCodeApplicationFile != null && xCodeApplicationFile.exists()) return true;
    //"null" name means that Xcode was not found previously
    if (xCodeApplicationFile != null && "null".equals(xCodeApplicationFile.getName())) return false;

    File xCodeApp = new File("/Applications/Xcode.app");
    if (xCodeApp.exists()) {
      xCodeApplicationFile = xCodeApp;
      return true;
    }
    try {
      ScriptEngineManager engineManager = new ScriptEngineManager();
      ScriptEngine engine = engineManager.getEngineByName("AppleScriptEngine");
      if (engine != null) {
        final String script = "try\n" +
                "tell application \"Finder\" to return POSIX path of (get application file id \"com.apple.dt.Xcode\" " +
                "as alias)\n" + "on error\n" + "  return \"null\"\n" + "end try";
        final Object scriptResult = engine.eval(script);
        if (scriptResult != null) {
          xCodeApplicationFile = new File(scriptResult.toString());
          return xCodeApplicationFile.exists();
        }
      }
    } catch (ScriptException e) {
      LOG.error("Error evaluating applescript: " + e.getMessage());
    }
    xCodeApplicationFile = new File("null");
    return false;
  }

  /**
   * @param applicationName name of the application for which dictionary will be generated
   * @param serializePath   file path of the generated dictionary
   * @param cmdName         command name to use for dictionary file generation (cat or sdef)
   * @param appFilePath     path of the application bundle (or dictionary file if generating from already existing
   *                        dictionary file)
   * @return true if file was generated successfully
   * @throws NotScriptableApplicationException   if application does not support AppleScript scripting
   * @throws DeveloperToolsNotInstalledException if Xcode is not installed
   */
  private boolean doGenerateDictionaryFile(@NotNull final String applicationName,
                                           @NotNull final String serializePath,
                                           @NotNull final String cmdName,
                                           @NotNull final String appFilePath)
          throws NotScriptableApplicationException, DeveloperToolsNotInstalledException {
    try {
      final String[] shellCommand = new String[]{"/bin/bash", "-c", " " + cmdName + " \"" + appFilePath + "\" " +
              "> " + serializePath};
      LOG.info("executing command: " + Arrays.toString(shellCommand));
      Integer exitCode;
      long execStart = System.currentTimeMillis();
      exitCode = Runtime.getRuntime().exec(shellCommand).waitFor();
      long execEnd = System.currentTimeMillis();
      if (exitCode != 0) {
        if (isXcodeInstalled()) {
          throw new NotScriptableApplicationException(applicationName,
                  "Command " + Arrays.toString(shellCommand) + " failed with code=" + exitCode + ". Seems that " +
                          "application \"" + applicationName + "\" is not scriptable.");
        } else throw new DeveloperToolsNotInstalledException();
      }

      LOG.info("Exit code = " + exitCode + " Execution time: " + (execEnd - execStart) + " ms.");
      return true;
    } catch (InterruptedException e) {
      LOG.error("Failed to create dictionary file for application [" + applicationName + "] Command:" + cmdName +
              " target path: " + appFilePath + " Reason: " + e.getCause());
      e.printStackTrace();
    } catch (IOException e) {
      LOG.error("Failed to create dictionary file for application [" + applicationName + "] Command:" + cmdName +
              " target path: " + appFilePath + " Reason: " + e.getCause());
      e.printStackTrace();
    }
    return false;
  }

  /**
   * @param applicationName           name of the application
   * @param applicationDictionaryFile application file
   * @param targetFile                file to be created
   * @param rewrite                   rewrite if same dictionary file exists
   * @return true if file was copied successfully
   */
  private boolean copyDictionaryFileToCacheDir(@NotNull final String applicationName,
                                               @NotNull final File applicationDictionaryFile,
                                               @NotNull final File targetFile,
                                               final boolean rewrite) {
    if (!targetFile.getParentFile().exists()) return false;
    if (!targetFile.exists() || rewrite) {
      ApplicationManager.getApplication().runWriteAction(new Runnable() {
        @Override
        public void run() {
          try {
            if (targetFile.exists() && targetFile.delete()) {
              LOG.debug("Existing target file deleted: " + targetFile);
            }
            Files.copy(applicationDictionaryFile, targetFile);
          } catch (IOException e) {
            LOG.error("Failed to move file " + applicationDictionaryFile + " to cache directory: " + targetFile);
            e.printStackTrace();
          }
        }
      });
    } else {
      LOG.info("Generated file already exists for application " + applicationName);
    }
    if (targetFile.exists()) {
      LOG.info("Dictionary file moved to " + targetFile.getParent() + " directory");
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
    return notFoundApplicationList.contains(applicationName);
  }

  private String serializeDictionaryPathForApplication(@NotNull String applicationName) {
    String unescaped = GENERATED_DICTIONARIES_SYSTEM_FOLDER + "/" + applicationName + "_generated.sdef";
    return unescaped.replaceAll(" ", "_");
  }

  @Nullable
  private DictionaryInfo getDictionaryInfo(@Nullable String applicationName) {
    return dictionaryInfoMap.get(applicationName);
  }

  @Nullable
  public VirtualFile getDictionaryFile(@Nullable String applicationName) {
    DictionaryInfo dInfo = dictionaryInfoMap.get(applicationName);
    return dInfo != null ? dInfo.getDictionaryFile() : null;
  }

  @Nullable
  public DictionaryInfo getDictionaryInfoByApplicationPath(@NotNull String applicationPath) {
    for (DictionaryInfo dInfo : dictionaryInfoMap.values()) {
      File appFile = dInfo.getApplicationFile();
      if (appFile != null && appFile.getPath().equals(applicationPath))
        return dInfo;
    }
    // standard libraries do not have application path
    if (applicationPath.endsWith("CocoaStandard.sdef")) {
      return dictionaryInfoMap.get(ApplicationDictionary.COCOA_STANDARD_LIBRARY);
    }
    return null;
  }

  @NotNull
  public Collection<String> getCachedApplicationNames() {
    return dictionaryInfoMap.keySet();
  }

  @NotNull
  public HashSet<String> getDiscoveredApplicationNames() {
    return discoveredApplicationNames;
  }

  public boolean isDictionaryInitialized(@NotNull String applicationName) {
    DictionaryInfo dInfo = dictionaryInfoMap.get(applicationName);
    return dInfo != null && dInfo.isInitialized();
  }

  /**
   * Fills structures with terms from application dictionaries
   *
   * @param xmlFile         dictionary file
   * @param applicationName name of the application
   * @return true if file was parsed successfully
   */
  private boolean parseDictionaryFile(@NotNull final File xmlFile, @NotNull final String applicationName) {
    SAXBuilder builder = new SAXBuilder();
    builder.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
    Document document;
    try {
      document = builder.build(xmlFile);
      Element rootNode = document.getRootElement();
      List<Element> suiteElements = rootNode.getChildren();

      if (ApplicationDictionary.SCRIPTING_ADDITIONS_LIBRARY.equals(applicationName)) {
        for (Element suiteElem : suiteElements) {
          parseSuiteElementForApplication(suiteElem, applicationName);// TODO: 26/12/15 remove?
          parseSuiteElementForScriptingAdditions(suiteElem, applicationName);
        }
      } else {
        for (Element suiteElem : suiteElements) {
          parseSuiteElementForApplication(suiteElem, applicationName);
        }
      }
      return true;
    } catch (JDOMException e) {
      LOG.warn("Exception occurred while parsing dictionary file: " + e.getMessage());
      e.printStackTrace();
    } catch (IOException e) {
      LOG.warn("Exception occurred while parsing dictionary file: " + e.getMessage());
    }
    return false;
  }

  private void parseSuiteElementForScriptingAdditions(@NotNull Element suiteElem, @NotNull String applicationName) {
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

    for (Element include : xiIncludes) {
      String hrefIncl = include.getAttributeValue("href");
      hrefIncl = hrefIncl.replace("localhost", "");
      File inclFile = new File(hrefIncl);
      if (inclFile.exists()) {
        parseDictionaryFile(inclFile, applicationName);
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
    if (ApplicationDictionary.SCRIPTING_ADDITIONS_LIBRARY.equals(applicationName)) {
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

  private static boolean startsWithWord(@NotNull String string, @NotNull String prefix) {
    return string.startsWith(prefix) && (prefix.length() == string.length() || ' ' == string.charAt(prefix.length()));
  }
}