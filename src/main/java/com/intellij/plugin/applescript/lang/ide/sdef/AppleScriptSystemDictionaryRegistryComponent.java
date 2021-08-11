package com.intellij.plugin.applescript.lang.ide.sdef;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.*;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.fileTypes.FileTypeManager;
import com.intellij.util.SmartList;
import com.intellij.util.xmlb.annotations.AbstractCollection;
import com.intellij.util.xmlb.annotations.CollectionBean;
import com.intellij.util.xmlb.annotations.Tag;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

/**
 * This {@link ApplicationComponent} stores information about generated dictionary files for applications
 */
@State(name = AppleScriptSystemDictionaryRegistryComponent.COMPONENT_NAME,
    storages = {@Storage(value = "appleScriptCachedDictionariesInfo.xml", roamingType = RoamingType.PER_OS)})
public class AppleScriptSystemDictionaryRegistryComponent implements ApplicationComponent, PersistentStateComponent<AppleScriptSystemDictionaryRegistryComponent.State> {

  private static final Logger LOG = Logger.getInstance("#" + AppleScriptSystemDictionaryRegistryComponent.class.getName());
  static final String COMPONENT_NAME = "AppleScriptSystemDictionaryRegistryComponent";
  // information about dictionaries for the application which is saved in settings
  private final List<DictionaryInfo.State> dictionariesPersistedInfo = new ArrayList<>();
  // application names which do not support AppleScript commands
  private final SmartList<String> notScriptableApplications = new SmartList<>();
  @Nullable
  private AppleScriptSystemDictionaryRegistryService dictionaryService;


  static class State {
    @Tag("applicationsInfo")
    @AbstractCollection(surroundWithTag = false)
    DictionaryInfo.State[] dictionariesInfo = new DictionaryInfo.State[0];
    @CollectionBean
    final List<String> notScriptableApplications = new SmartList<>();
  }

  void setDictionaryService(@NotNull AppleScriptSystemDictionaryRegistryService dictionaryService) {
    this.dictionaryService = dictionaryService;
  }

  /**
   * @return {@link State} class, which stores current information about all {@link DictionaryInfo}
   */
  @Override
  public State getState() {
    State state = new State();
    if (dictionaryService == null) return null;
    Collection<DictionaryInfo> dictionaryInfos = dictionaryService.getDictionaryInfoList();
    state.dictionariesInfo = new DictionaryInfo.State[dictionaryInfos.size()];
    Iterator<DictionaryInfo> it = dictionaryInfos.iterator();
    for (int i = 0; i < dictionaryInfos.size(); i++) {
      state.dictionariesInfo[i] = it.next().getState();
    }
    state.notScriptableApplications.addAll(dictionaryService.getNotScriptableApplicationList());
    return state;
  }

  @NotNull
  List<DictionaryInfo.State> getDictionariesPersistedInfo() {
    return dictionariesPersistedInfo;
  }

  @NotNull
  List<String> getNotScriptableApplications() {
    return notScriptableApplications;
  }

  @Override
  public void loadState(State state) {
    // TODO: 05/12/15 validate here ridden values
    DictionaryInfo.State[] dictionaryInfos = state.dictionariesInfo;
    if (dictionaryInfos != null) {
      Collections.addAll(dictionariesPersistedInfo, dictionaryInfos);
    }
    notScriptableApplications.addAll(state.notScriptableApplications);
  }

  @Override
  public void initComponent() {
    registerSdefExtension();//registering "sdef" dictionary file extension for xml file type
  }

  private void registerSdefExtension() {
    ApplicationManager.getApplication().runWriteAction(() -> {
      FileType ft = FileTypeManager.getInstance().getFileTypeByExtension("xml");
      FileTypeManager.getInstance().associateExtension(ft, "sdef");
    });
  }

  @Override
  public void disposeComponent() {
    LOG.info("disposing component " + COMPONENT_NAME);
  }

  @NotNull
  @Override
  public String getComponentName() {
    return COMPONENT_NAME;
  }
}
