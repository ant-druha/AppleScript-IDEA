package com.idea.plugin.applescript.lang.ide.sdef;

import com.idea.plugin.applescript.lang.sdef.ApplicationDictionary;
import com.idea.plugin.applescript.psi.sdef.impl.ApplicationDictionaryImpl;
import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppleScriptProjectDictionaryRegistry implements ProjectComponent {

  public static final String COMPONENT_NAME = "AppleScriptProjectDictionaryRegistry";

  @NotNull private final Project project;
  @NotNull private final AppleScriptSystemDictionaryRegistry systemDictionaryRegistry;
  private final Map<String, ApplicationDictionary> dictionaryMap = new HashMap<String, ApplicationDictionary>();

  public AppleScriptProjectDictionaryRegistry(@NotNull Project project,
                                              @NotNull AppleScriptSystemDictionaryRegistry systemDictionaryRegistry) {
    this.project = project;
    this.systemDictionaryRegistry = systemDictionaryRegistry;
  }

  @NotNull
  public List<ApplicationDictionary> getStandardDictionaries() {
    List<ApplicationDictionary> result = new ArrayList<ApplicationDictionary>();
    for (String stdDictionaryName : ApplicationDictionary.STD_LIBRARY_NAMES) {
      ApplicationDictionary stdDic = getDictionary(stdDictionaryName);
      if (stdDic == null) {
        stdDic = createDictionary(stdDictionaryName);
      }
      if (stdDic != null) {
        result.add(stdDic);
      }
    }
    return result;
  }

  @Nullable
  public synchronized ApplicationDictionary createDictionary(@NotNull String applicationName) {
    ApplicationDictionary newDictionary = dictionaryMap.get(applicationName);
    String cachedDictionaryFile = systemDictionaryRegistry.getCachedDictionaryFileUrl(applicationName);

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
