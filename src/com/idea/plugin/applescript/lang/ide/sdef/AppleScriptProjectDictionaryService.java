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
   * @param applicationFile VirtualFile of the application bundle
   * @return Dictionary psi class for application, given or null if creation failed
   */
  @Nullable
  public synchronized ApplicationDictionary createDictionary(@NotNull String applicationName,
                                                             @Nullable VirtualFile applicationFile) {
    if (isInIgnoreList(applicationName, applicationFile)) return null;

    final File cachedDictionaryFile = getDictionaryFile(applicationName, applicationFile);
    if (cachedDictionaryFile != null) {
      return createDictionaryFromGeneratedFile(applicationName, cachedDictionaryFile);
    }
    LOG.warn("Failed to create dictionary for application: " + applicationName + ". Reason: file is null");
    return null;
  }

  /**
   * @param applicationName         Name of the application
   * @param generatedDictionaryFile File of generated dictionary for the application
   * @return {@link ApplicationDictionary} psi class for generated dictionary file
   */
  @Nullable
  private ApplicationDictionary createDictionaryFromGeneratedFile(@NotNull final String applicationName,
                                                                  @NotNull final File generatedDictionaryFile) {
    ApplicationDictionary newDictionary = getDictionary(applicationName);
    final VirtualFile generatedDictionaryVFile = LocalFileSystem.getInstance().findFileByIoFile
            (generatedDictionaryFile);
    if (generatedDictionaryVFile != null) {
      if (newDictionary != null && newDictionary.getCachedLibraryXmlFile().equals(generatedDictionaryVFile))
        return newDictionary;//do not create dictionary for the same previously already added application

      newDictionary = new ApplicationDictionaryImpl(project, generatedDictionaryVFile, applicationName);
    }
    if (newDictionary != null) {
      dictionaryMap.put(applicationName, newDictionary);
    }
    return newDictionary;
  }

  /**
   * Returns the file of the generated dictionary for the application. Either previously saved or generates one and
   * initializes dictionary terms from it
   *
   * @param applicationName name of the application
   * @param applicationFile VirtualFile of the application or dictionary xml file or null
   * @return returns file of generated dictionary xml file
   */
  @Nullable
  private File getDictionaryFile(@NotNull String applicationName, @Nullable VirtualFile applicationFile) {
    String savedDictionaryFilePath = dictionaryRegistryService.getSavedDictionaryFilePath(applicationName);
    File savedDictionaryFile = savedDictionaryFilePath != null ? new File(savedDictionaryFilePath) : null;
    if (savedDictionaryFile != null && savedDictionaryFile.exists()) return savedDictionaryFile;

    LOG.warn("No pre-initialized dictionary found for application: [" + applicationName + "] " +
            "Caching it now...");
    if (applicationFile != null) {
      savedDictionaryFile = dictionaryRegistryService
              .initializeDictionaryFromApplicationFile(applicationFile, applicationName);
    } else { //if file is null, searching in standard paths
      savedDictionaryFile = dictionaryRegistryService.initializeDictionaryForApplication(applicationName);
    }
    return savedDictionaryFile != null && savedDictionaryFile.exists() ? savedDictionaryFile : null;
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
