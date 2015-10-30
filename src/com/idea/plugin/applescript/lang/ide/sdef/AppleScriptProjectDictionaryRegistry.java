package com.idea.plugin.applescript.lang.ide.sdef;

import com.idea.plugin.applescript.lang.sdef.ApplicationDictionary;
import com.idea.plugin.applescript.psi.sdef.impl.ApplicationDictionaryImpl;
import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class AppleScriptProjectDictionaryRegistry implements ProjectComponent {

  public static final String COMPONENT_NAME = "AppleScriptProjectDictionaryRegistry";

  private static final Logger LOG = Logger.getInstance("#" + AppleScriptProjectDictionaryRegistry.class.getName());


  @NotNull private final Project project;
  @NotNull private final AppleScriptSystemDictionaryRegistry systemDictionaryRegistry;
  private final Map<String, ApplicationDictionary> dictionaryMap = new HashMap<String, ApplicationDictionary>();

  public AppleScriptProjectDictionaryRegistry(@NotNull Project project,
                                              @NotNull AppleScriptSystemDictionaryRegistry systemDictionaryRegistry) {
    this.project = project;
    this.systemDictionaryRegistry = systemDictionaryRegistry;
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
   * {@link com.idea.plugin.applescript.lang.sdef.ApplicationDictionary} psi class.
   *
   * @param applicationName Name of the application
   * @param applicationFile VirtualFile of the application
   * @return Dictionary psi class for application, given or null if creation failed
   */
  @Nullable
  public synchronized ApplicationDictionary createDictionary(@NotNull String applicationName,
                                                             @Nullable VirtualFile applicationFile) {
    ApplicationDictionary newDictionary = dictionaryMap.get(applicationName);
    String cachedDictionaryFile = systemDictionaryRegistry.getGeneratedDictionaryFilePath(applicationName);

    if (cachedDictionaryFile == null) {
      System.out.println("WARNING: no pre-initialized dictionary found for application: [" + applicationName + "] " +
              "Caching it now...");
      LOG.warn("No pre-initialized dictionary found for application: [" + applicationName + "] " +
              "Caching it now...");
      if (applicationFile != null) {
        cachedDictionaryFile = systemDictionaryRegistry
                .initializeDictionaryFromApplicationFile(applicationFile, applicationName);
      } else { //if file is null, searching in standard paths
        cachedDictionaryFile = systemDictionaryRegistry.initializeDictionaryForApplication(applicationName);
      }
    }

    if (cachedDictionaryFile != null) {
      //todo initialize map to virtualFile?
      final File cachedXmlFileForApplication = new File(cachedDictionaryFile);
      final VirtualFile applicationCachedVFile = LocalFileSystem.getInstance()
              .findFileByIoFile(cachedXmlFileForApplication);
      if (applicationCachedVFile != null) {
        if (newDictionary != null && newDictionary.getCachedLibraryXmlFile().equals(applicationCachedVFile))
          return newDictionary;//do not create dictionary for the same previously already added application

        newDictionary = new ApplicationDictionaryImpl(project, applicationCachedVFile, applicationName);
      }
    }
    if (newDictionary != null) {
      dictionaryMap.put(applicationName, newDictionary);
    }
    return newDictionary;
  }

  @Override
  public void initComponent() {
  }

  @Override
  public void disposeComponent() {
    // TODO: insert component disposal logic here
  }

  @Override
  @NotNull
  public String getComponentName() {
    return COMPONENT_NAME;
  }

  @Override
  public void projectOpened() {
    // init standard addition dictionary (for all applications) ?
//    if (project.isInitialized()) {
//      for (String stdDictionaryName : ApplicationDictionary.STD_LIBRARY_NAMES) {
//        createDictionary(stdDictionaryName);
//      }
//    }
  }

  @Override
  public void projectClosed() {
    // called when project is being closed
  }

  @Nullable
  public ApplicationDictionary getDictionary(@NotNull String applicationName) {
    return dictionaryMap.get(applicationName);
  }
}
