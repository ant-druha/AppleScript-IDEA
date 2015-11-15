package com.idea.plugin.applescript.lang.ide.sdef;

import com.idea.plugin.applescript.lang.sdef.ApplicationDictionary;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.*;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.fileTypes.FileTypeManager;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.util.xmlb.annotations.MapAnnotation;
import com.intellij.util.xmlb.annotations.Tag;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * for storing plain structure info about application name and it's classes/properties/constants/commands
 */
@State(name = AppleScriptDictionarySystemRegistry.COMPONENT_NAME,
        storages = {@Storage(file = StoragePathMacros.APP_CONFIG + "/appleScriptCachedDictionariesInfo.xml")})
public class AppleScriptDictionarySystemRegistry implements ApplicationComponent,
        PersistentStateComponent<AppleScriptDictionarySystemRegistry.State> {

  private static final Logger LOG = Logger.getInstance("#" + AppleScriptDictionarySystemRegistry.class.getName());

  public static final String COMPONENT_NAME = "AppleScriptDictionarySystemRegistry";

  public static final String GENERATED_DICTIONARY_URLS_ELEMENT = "generatedDictionaryUrls";
  public static final String APPLICATION_NAME_ELEMENT = "applicationName";
  public static final String DICTIONARY_GENERATED_FILE_URL = "generatedFileUrl";

  private final Map<String, String> myApplicationNameToGeneratedDictionaryUrlMap = new HashMap<String, String>();
  private final Map<String, VirtualFile> myApplicationNameToGeneratedDictionaryFileMap = new HashMap<String,
          VirtualFile>();
  private final Map<String, List<String>> classNameToApplicationNameListMap = new HashMap<String, List<String>>();


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

  @NotNull
  @Override
  public State getState() {
    State state = new State();
    AppleScriptDictionarySystemRegistryService dictionaryRegistry = ServiceManager.getService
            (AppleScriptDictionarySystemRegistryService.class);
    state.cachedApplicationNameToGeneratedDictionaryUrlMap = dictionaryRegistry
            .getApplicationNameToGeneratedDictionaryPathMap();
    Map<String, String> result = new HashMap<String, String>();
    for (Map.Entry<String, List<String>> stringListPair : dictionaryRegistry.getClassNameToApplicationNameListMap()
            .entrySet()) {
      result.put(stringListPair.getKey(), serializeDictionaryNameList(stringListPair.getValue()));
    }
    state.cachedClassNameToDictionaryListMap = result;
    return state;
  }

  public Map<String, String> getApplicationNameToGeneratedDictionaryUrlMap() {
    return myApplicationNameToGeneratedDictionaryUrlMap;
  }

  public Map<String, VirtualFile> getApplicationNameToGeneratedDictionaryFileMap() {
    return myApplicationNameToGeneratedDictionaryFileMap;
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
    Map<String, String> classToDictionariesMap = state.cachedClassNameToDictionaryListMap;
    for (Map.Entry<String, String> stringEntry : uncheckedMap.entrySet()) {
      File file = new File(stringEntry.getValue());
      VirtualFile vFile = LocalFileSystem.getInstance().findFileByPath(stringEntry.getValue());
      if (file.exists()) {
        myApplicationNameToGeneratedDictionaryUrlMap.put(stringEntry.getKey(), stringEntry.getValue());
      }
      if (vFile != null && vFile.exists()) {
        myApplicationNameToGeneratedDictionaryFileMap.put(stringEntry.getKey(), vFile);
      }
    }
    for (Map.Entry<String, String> stringPair : classToDictionariesMap.entrySet()) {
      List<String> applicationNames = new ArrayList<String>();
      for (String applicationName : stringPair.getValue().split(",")) {
        if (!StringUtil.isEmpty(applicationName)
                && !ApplicationDictionary.STANDARD_ADDITIONS_LIBRARY.equals(applicationName)) {//if std class was
          // saved somehow, do not add it here - other map for std classes is used
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
    registerSdefExtension();
  }

  private void registerSdefExtension() {
    ApplicationManager.getApplication().runWriteAction(new Runnable() {
      public void run() {
        FileType ft = FileTypeManager.getInstance().getFileTypeByExtension("xml");
        FileTypeManager.getInstance().associateExtension(ft, "sdef");
      }
    });
  }

  @Override
  public void disposeComponent() {
    System.out.println("disposing component");
  }

  @NotNull
  @Override
  public String getComponentName() {
    return COMPONENT_NAME;
  }
}
