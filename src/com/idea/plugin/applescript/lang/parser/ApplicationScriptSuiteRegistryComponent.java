package com.idea.plugin.applescript.lang.parser;

import com.intellij.openapi.components.ApplicationComponent;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Andrey on 09.08.2015.
 */
public class ApplicationScriptSuiteRegistryComponent implements ApplicationComponent {

  public static final String COMPONENT_NAME = "ApplicationScriptSuiteRegistryComponent";
//  private ScriptSuiteRegistry currentScriptSuiteRegistry;

  public ApplicationScriptSuiteRegistryComponent() {
  }

//  public ScriptSuiteRegistry getCurrentScriptSuiteRegistry() {
//    return currentScriptSuiteRegistry;
//  }

  @Override
  public void initComponent() {
//    // TODO: insert component initialization logic here
//    ApplicationManager.getApplication().getMessageBus().connect()
//            .subscribe(FileEditorManagerListener.FILE_EDITOR_MANAGER, new FileEditorManagerAdapter() {
//              @Override
//              public void fileOpened(@NotNull final FileEditorManager source, @NotNull final VirtualFile file) {
//              }
//
//
//              @Override
//              public void selectionChanged(@NotNull FileEditorManagerEvent event) {
//                // set currentScriptSuiteRegistry to the suite saved earlier for the newFile or
//                // if no suite has been found create new suiteRegistry for the newFile
//                Project project = event.getManager().getProject();
//                VirtualFile newFile = event.getNewFile();
//                VirtualFile oldFile = event.getOldFile();
//                if (newFile == null) return;
//                if (!newFile.equals(oldFile) && newFile.getFileType() == AppleScriptFileType.INSTANCE) {
//                  ScriptSuiteRegistry restoredLibraryForFile =
//                          getScriptSuiteRegistryForFile(project, newFile);
//
//                  String oldName = currentScriptSuiteRegistry != null ? currentScriptSuiteRegistry.getName() : "null";
//                  String newName = restoredLibraryForFile != null ? restoredLibraryForFile.getName() : "null";
//                  if (!oldName.equals(newName)) {
//                    System.out.println(" ---- Current Suite Registry changed. Was: "
//                            + oldName + " Now: " + newName + " ----");
//                  }
//
//                  currentScriptSuiteRegistry = restoredLibraryForFile != null ? restoredLibraryForFile :
//                          new ScriptSuiteRegistry(newFile, project);
////                          new ScriptSuiteRegistry(ScriptSuiteRegistry.STD_LIBRARY_NAME, project);
////                  PsiDocumentManager.getInstance(project).reparseFiles(Arrays.asList(newFile), false);
//                }
////                FileEditorManager.getInstance(project).getSelectedTextEditor();
//
//              }
//
//              @Override
//              public void fileClosed(@NotNull final FileEditorManager source, @NotNull final VirtualFile file) {
//
//              }
//            });
//
//    ApplicationManager.getApplication().getMessageBus().connect()
//            .subscribe(FileEditorManagerListener.Before.FILE_EDITOR_MANAGER, new FileEditorManagerListener.Before
//                    .Adapter() {
//
//              @Override
//              public void beforeFileOpened(@NotNull FileEditorManager source, @NotNull VirtualFile file) {
//                if (file.getFileType() == AppleScriptFileType.INSTANCE) {
//
//                  ScriptSuiteRegistryMappings registryMappingsService = ScriptSuiteRegistryMappings.
//                          getInstance(source.getProject());
//                  ScriptSuiteRegistry restoredLibraryForFile =
//                          getScriptSuiteRegistryForFile(source.getProject(), file);
//                  String oldName = currentScriptSuiteRegistry != null ? currentScriptSuiteRegistry.getName() : "null";
//                  String newName = restoredLibraryForFile != null ? restoredLibraryForFile.getName() : "null";
//                  if (!oldName.equals(newName)) {
//                    System.out.println(" ---- Current Suite Registry changed. Was: "
//                            + oldName + " Now: " + newName + " ----");
//                  }
//
//                  currentScriptSuiteRegistry = restoredLibraryForFile != null ? restoredLibraryForFile :
//                          new ScriptSuiteRegistry(file, source.getProject());
//                  if (registryMappingsService != null && restoredLibraryForFile == null) {
//                    registryMappingsService.associate(file, currentScriptSuiteRegistry);
//                  }
//                }
//              }
//            });
//    //todo initialize it in project component on project loading and get from there via another message bus
//    String oldName = currentScriptSuiteRegistry != null ? currentScriptSuiteRegistry.getName() : "null";
//    currentScriptSuiteRegistry = currentScriptSuiteRegistry == null ?
//            new ScriptSuiteRegistry(ApplicationDictionary.STD_LIBRARY_NAME,
//                    ProjectManager.getInstance().getDefaultProject()) :
//            currentScriptSuiteRegistry;
//    String newName = currentScriptSuiteRegistry.getName();
//    if (!oldName.equals(newName)) {
//      System.out.println(" ---- Current Suite Registry changed initialized. Name: " + newName + " ----");
//      System.out.println(" ---- Current Suite Registry changed. Was: "
//              + oldName + " Now: " + newName + " ----");
//    }
  }

//  @Contract("_, null -> null")
//  @Nullable
//  private static ScriptSuiteRegistry getScriptSuiteRegistryForFile(@NotNull Project project, @Nullable VirtualFile
//          theFile) {
//    if (theFile != null && theFile.getFileType() == AppleScriptFileType.INSTANCE) {
//      ScriptSuiteRegistryMappings registryMappingsService = ScriptSuiteRegistryMappings.getInstance(project);
//      return registryMappingsService != null ? registryMappingsService.getMapping(theFile) : null;
//    }
//    return null;
//  }

  @Override
  public void disposeComponent() {
    // TODO: insert component disposal logic here
  }

  @Override
  @NotNull
  public String getComponentName() {
    return COMPONENT_NAME;
  }
}
