package com.idea.plugin.applescript.lang.ide.sdef;

import com.idea.plugin.applescript.lang.sdef.ApplicationDictionary;
import com.idea.plugin.applescript.psi.sdef.impl.ApplicationDictionaryImpl;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.xml.XmlFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public class AppleScriptProjectDictionaryService {

  private static final Logger LOG = Logger.getInstance("#" +
          AppleScriptProjectDictionaryService.class.getName());


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
  public synchronized ApplicationDictionary createDictionary(@NotNull String applicationName) {
    if (isInIgnoreList(applicationName, null)) return null;
    ApplicationDictionary result = getDictionary(applicationName);
    if (result != null) return result;
    DictionaryInfo dictionaryInfo = dictionaryRegistryService.getInitializedInfo(applicationName);
    if (dictionaryInfo != null) {
      return createDictionaryFromInfo(dictionaryInfo);
    }
    LOG.warn("Failed to get initialized dictionary info for " + applicationName);
    return null;
  }

  @Nullable
  private ApplicationDictionary createDictionaryFromInfo(final @NotNull DictionaryInfo dInfo) {
    String applicationName = dInfo.getApplicationName();
    PsiFile psiFile = PsiManager.getInstance(project).findFile(dInfo.getDictionaryFile());
    XmlFile xmlFile = (XmlFile) psiFile;
    if (xmlFile != null) {
      ApplicationDictionary dictionary = new ApplicationDictionaryImpl(project, xmlFile, applicationName,
              dInfo.getApplicationFile());
      dictionaryMap.put(applicationName, dictionary);
      return dictionary;
    }
    LOG.warn("Failed to create dictionary from info for application: " + applicationName + ". Reason: file is null");
    return null;
  }

  /**
   * Generates dictionary file for application, initializes it's terms for parser and creates
   * {@link ApplicationDictionary} psi class for the Project.
   *
   * @param applicationName Name of the application
   * @param applicationFile VirtualFile of the application bundle
   * @return Dictionary psi class for the application or null if creation failed
   */
  @Nullable
  public synchronized ApplicationDictionary createDictionaryFromFile(@NotNull String applicationName,
                                                                     @NotNull VirtualFile applicationFile) {
    if (isInIgnoreList(applicationName, applicationFile)) return null;

    final DictionaryInfo dictionaryInfo = dictionaryRegistryService.createAndInitializeInfo(applicationFile,
            applicationName);
    if (dictionaryInfo != null) {
      return createDictionaryFromInfo(dictionaryInfo);
    }
    LOG.warn("Failed to get initialized dictionary info for " + applicationName + " from " + applicationFile);
    return null;
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
