package com.idea.plugin.applescript.lang.ide.sdef;

import com.idea.plugin.applescript.lang.sdef.ApplicationDictionary;
import com.idea.plugin.applescript.psi.sdef.impl.ApplicationDictionaryImpl;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class AppleScriptProjectDictionaryService {

  private static final Logger LOG = Logger.getInstance("#" + AppleScriptProjectDictionaryService.class
          .getName());


  @NotNull private final Project project;
  @NotNull private final AppleScriptSystemDictionaryRegistryService dictionaryRegistryService;
  private final Map<String, ApplicationDictionary> dictionaryMap = new HashMap<String, ApplicationDictionary>();

  public AppleScriptProjectDictionaryService(@NotNull Project project,
                                             @NotNull AppleScriptSystemDictionaryRegistryService
                                                     dictionaryRegistryService) {
    this.project = project;
    this.dictionaryRegistryService = dictionaryRegistryService;
  }

  /**
   * @return returns available by default terminology (Standard Additions)
   */
  @Nullable
  public ApplicationDictionary getStandardAdditionsTerminology() {
    String stdDictionaryName = ApplicationDictionary.STANDARD_ADDITIONS_LIBRARY;
    ApplicationDictionary stdDic = getDictionary(stdDictionaryName);
    if (stdDic == null) {
      stdDic = createDictionary(stdDictionaryName);
    }
    return stdDic;
  }

  /**
   * @return returns terminology available by default in the scripting application (Cocoa Standard)
   */
  @Nullable
  public ApplicationDictionary getDefaultCocoaTerminology() {
    String stdDictionaryName = ApplicationDictionary.STANDARD_COCOA_LIBRARY;
    ApplicationDictionary stdDic = getDictionary(stdDictionaryName);
    if (stdDic == null) {
      stdDic = createDictionary(stdDictionaryName);
    }
    return stdDic;
  }

  /**
   * Creates Dictionary psi class for specified application for Project. Previously cached dictionary files and Standard
   * <br> application paths are checked
   *
   * @param applicationName Name of the application
   * @return Dictionary psi class for application, given or null if creation failed
   */
  @Nullable
  public ApplicationDictionary createDictionary(@NotNull String applicationName) {
    return createDictionary(applicationName, null);
  }

  /**
   * Creates Dictionary psi class for specified application for Project. If dictionary was not initialized previously
   * IDE <br> caches generated dictionary file and initializes it's structure for later use by
   * {@link ApplicationDictionary} psi class.
   *
   * @param applicationName Name of the application
   * @param applicationFile VirtualFile of the application
   * @return Dictionary psi class for application, given or null if creation failed
   */
  @Nullable
  public synchronized ApplicationDictionary createDictionary(@NotNull String applicationName,
                                                             @Nullable VirtualFile applicationFile) {
    if (isInIgnoreList(applicationName, applicationFile)) return null;

    final String cachedDictionaryFilePath = getDictionaryFilePath(applicationName, applicationFile);
    if (cachedDictionaryFilePath != null) {
      return createDictionaryFromGeneratedFile(applicationName, cachedDictionaryFilePath);
    }
    LOG.warn("Failed to create dictionary for application: " + applicationName + ". Reason: file is null");
    return null;
  }

  @Nullable
  private ApplicationDictionary createDictionaryFromGeneratedFile(@NotNull String applicationName,
                                                                  @NotNull String cachedDictionaryFilePath) {
    ApplicationDictionary newDictionary = getDictionary(applicationName);
    //todo initialize map to virtualFile?
    final File cachedXmlFileForApplication = new File(cachedDictionaryFilePath);
    final VirtualFile applicationCachedVFile = LocalFileSystem.getInstance()
            .findFileByIoFile(cachedXmlFileForApplication);
    if (applicationCachedVFile != null) {
      if (newDictionary != null && newDictionary.getCachedLibraryXmlFile().equals(applicationCachedVFile))
        return newDictionary;//do not create dictionary for the same previously already added application

      newDictionary = new ApplicationDictionaryImpl(project, applicationCachedVFile, applicationName);
    }
    if (newDictionary != null) {
      dictionaryMap.put(applicationName, newDictionary);
    }
    return newDictionary;
  }

  /**
   * Returns file path to the dictionary for the application. Either previously saved or generates one
   *
   * @param applicationName name of the application
   * @param applicationFile VirtualFile of the application or dictionary xml file or null
   * @return returns file path to generated dictionary xml file
   */
  @Nullable
  private String getDictionaryFilePath(@NotNull String applicationName, @Nullable VirtualFile applicationFile) {
    String savedDictionaryFilePath = dictionaryRegistryService.getSavedDictionaryFilePath(applicationName);
    if (savedDictionaryFilePath != null) return savedDictionaryFilePath;

    System.out.println("WARNING: no pre-initialized dictionary found for application: [" + applicationName + "] " +
            "Caching it now...");
    LOG.warn("No pre-initialized dictionary found for application: [" + applicationName + "] " +
            "Caching it now...");
    if (applicationFile != null) {
      savedDictionaryFilePath = dictionaryRegistryService
              .initializeDictionaryFromApplicationFile(applicationFile, applicationName);
    } else { //if file is null, searching in standard paths
      savedDictionaryFilePath = dictionaryRegistryService.initializeDictionaryForApplication(applicationName);
    }
    return savedDictionaryFilePath;
  }

  /**
   * @param applicationName name of the application
   * @param applicationFile application bundle file
   * @return tue if application is either not scriptable or was not found in the system, false otherwise
   */
  private boolean isInIgnoreList(@NotNull String applicationName, @Nullable VirtualFile applicationFile) {
    // TODO: 15/11/15 create exception for not scriptable application and throw it from
    // AppleScriptSystemDictionaryRegistryService
    if (dictionaryRegistryService.isNotScriptable(applicationName)) {
      LOG.info("Application " + applicationName + " is not scriptable. Can not create dictionary for it.");
      return true;
    }
    //do not proceed if application location was previously not found
    if (applicationFile == null && dictionaryRegistryService.isInUnknownList(applicationName)) {
      LOG.warn("Application " + applicationName + " was added to unknown list. Can not create dictionary for it.");
      return true;
    }
    return false;
  }

  @Nullable
  public ApplicationDictionary getDictionary(@NotNull String applicationName) {
    return dictionaryMap.get(applicationName);
  }
}
