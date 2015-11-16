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

public class AppleScriptDictionaryProjectService {

  private static final Logger LOG = Logger.getInstance("#" + AppleScriptDictionaryProjectService.class
          .getName());


  @NotNull private final Project project;
  @NotNull private final AppleScriptDictionarySystemRegistryService dictionaryRegistryService;
  private final Map<String, ApplicationDictionary> dictionaryMap = new HashMap<String, ApplicationDictionary>();

  public AppleScriptDictionaryProjectService(@NotNull Project project,
                                             @NotNull AppleScriptDictionarySystemRegistryService
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
    // TODO: 15/11/15 create exception for not scriptable application and throw it from
    // AppleScriptDictionarySystemRegistryService
    if (!dictionaryRegistryService.isApplicationScriptable(applicationName)) {
      LOG.info("Application " + applicationName + " is not scriptable. Can not create dictionary for it.");
      return null;
    }
    //do not proceed if application location was previously not found
    if (applicationFile == null && !dictionaryRegistryService.isApplicationKnown(applicationName)) {
      LOG.warn("Application " + applicationName + " was added to unknown list. Can not create dictionary for it.");
      return null;
    }
    ApplicationDictionary newDictionary = dictionaryMap.get(applicationName);
    String cachedDictionaryFilePath = dictionaryRegistryService.getSavedDictionaryFilePath(applicationName);

    if (cachedDictionaryFilePath == null) {
      System.out.println("WARNING: no pre-initialized dictionary found for application: [" + applicationName + "] " +
              "Caching it now...");
      LOG.warn("No pre-initialized dictionary found for application: [" + applicationName + "] " +
              "Caching it now...");
      if (applicationFile != null) {
        cachedDictionaryFilePath = dictionaryRegistryService
                .initializeDictionaryFromApplicationFile(applicationFile, applicationName);
      } else { //if file is null, searching in standard paths
        cachedDictionaryFilePath = dictionaryRegistryService.initializeDictionaryForApplication(applicationName);
      }
    }

    if (cachedDictionaryFilePath != null) {
      //todo initialize map to virtualFile?
      final File cachedXmlFileForApplication = new File(cachedDictionaryFilePath);
      final VirtualFile applicationCachedVFile = LocalFileSystem.getInstance()
              .findFileByIoFile(cachedXmlFileForApplication);
      if (applicationCachedVFile != null) {
        if (newDictionary != null && newDictionary.getCachedLibraryXmlFile().equals(applicationCachedVFile))
          return newDictionary;//do not create dictionary for the same previously already added application

        newDictionary = new ApplicationDictionaryImpl(project, applicationCachedVFile, applicationName);
      }
    } else {
      LOG.warn("Failed to create dictionary for application: " + applicationName);
    }
    if (newDictionary != null) {
      dictionaryMap.put(applicationName, newDictionary);
    }
    return newDictionary;
  }

  @Nullable
  public ApplicationDictionary getDictionary(@NotNull String applicationName) {
    return dictionaryMap.get(applicationName);
  }
}
