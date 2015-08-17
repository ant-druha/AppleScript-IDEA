package com.idea.plugin.applescript.lang.parser;

import com.idea.plugin.applescript.AppleScriptFileType;
import com.idea.plugin.applescript.lang.ide.libraries.ScriptSuiteRegistry;
import com.idea.plugin.applescript.lang.ide.libraries.ScriptSuiteRegistryMappings;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.fileEditor.FileEditorManagerAdapter;
import com.intellij.openapi.fileEditor.FileEditorManagerEvent;
import com.intellij.openapi.fileEditor.FileEditorManagerListener;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiDocumentManager;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

/**
 * Created by Andrey on 09.08.2015.
 */
public class ApplicationScriptSuiteRegistryComponent implements ApplicationComponent {

  public static final String COMPONENT_NAME = "ApplicationScriptSuiteRegistryComponent";
  private ScriptSuiteRegistry currentScriptSuiteRegistry;

  public ApplicationScriptSuiteRegistryComponent() {
  }

  public ScriptSuiteRegistry getCurrentScriptSuiteRegistry() {
    return currentScriptSuiteRegistry;
  }

  public boolean update(@Nullable Project project, @Nullable VirtualFile file) {
    if (project == null || file == null) return false;
    ScriptSuiteRegistry savedForFile = getScriptSuiteRegistryForFile(project, file);
    if (savedForFile != null) {
      currentScriptSuiteRegistry = savedForFile;
      return true;
    }
    return false;
  }

  @Override
  public void initComponent() {
    // TODO: insert component initialization logic here
    ApplicationManager.getApplication().getMessageBus().connect()
            .subscribe(FileEditorManagerListener.FILE_EDITOR_MANAGER, new FileEditorManagerAdapter() {
              @Override
              public void fileOpened(@NotNull final FileEditorManager source, @NotNull final VirtualFile file) {
                if (file.getFileType() == AppleScriptFileType.INSTANCE) {

                  ScriptSuiteRegistryMappings registryMappingsService = ScriptSuiteRegistryMappings.
                          getInstance(source.getProject());
                  ScriptSuiteRegistry restoredLibraryForFile =
                          getScriptSuiteRegistryForFile(source.getProject(), file);
                  String oldName = currentScriptSuiteRegistry != null ? currentScriptSuiteRegistry.getName() : "null";
                  String newName = restoredLibraryForFile != null ? restoredLibraryForFile.getName() : "null";
                  if (!oldName.equals(newName)) {
                    System.out.println(" ---- Current Suite Registry changed. Was: "
                            + oldName + " Now: " + newName + " ----");
                  }

                  currentScriptSuiteRegistry = restoredLibraryForFile != null ? restoredLibraryForFile :
                          new ScriptSuiteRegistry(ScriptSuiteRegistry.STD_LIBRARY_NAME, source.getProject());
                  if (registryMappingsService != null && restoredLibraryForFile == null) {
                    registryMappingsService.associate(file, currentScriptSuiteRegistry);
                  }
                }
              }

              @Override
              public void selectionChanged(@NotNull FileEditorManagerEvent event) {
                // set currentScriptSuiteRegistry to the suite saved earlier for the newFile or
                // if no suite has been found create new suiteRegistry for the newFile
                Project project = event.getManager().getProject();
                VirtualFile newFile = event.getNewFile();
                VirtualFile oldFile = event.getOldFile();
                if (newFile == null) return;
                if (!newFile.equals(oldFile) && newFile.getFileType() == AppleScriptFileType.INSTANCE) {
                  ScriptSuiteRegistry restoredLibraryForFile =
                          getScriptSuiteRegistryForFile(project, newFile);

                  String oldName = currentScriptSuiteRegistry != null ? currentScriptSuiteRegistry.getName() : "null";
                  String newName = restoredLibraryForFile != null ? restoredLibraryForFile.getName() : "null";
                  if (!oldName.equals(newName)) {
                    System.out.println(" ---- Current Suite Registry changed. Was: "
                            + oldName + " Now: " + newName + " ----");
                  }

                  currentScriptSuiteRegistry = restoredLibraryForFile != null ? restoredLibraryForFile :
                          new ScriptSuiteRegistry(ScriptSuiteRegistry.STD_LIBRARY_NAME, project);
                  PsiDocumentManager.getInstance(project).reparseFiles(Arrays.asList(newFile), false);
                }

              }

              @Override
              public void fileClosed(@NotNull final FileEditorManager source, @NotNull final VirtualFile file) {

              }
            });
  }

  @Contract("_, null -> null")
  @Nullable
  private static ScriptSuiteRegistry getScriptSuiteRegistryForFile(@NotNull Project project, @Nullable VirtualFile
          theFile) {
    if (theFile != null && theFile.getFileType() == AppleScriptFileType.INSTANCE) {
      ScriptSuiteRegistryMappings registryMappingsService = ScriptSuiteRegistryMappings.getInstance(project);
      return registryMappingsService != null ? registryMappingsService.getMapping(theFile) : null;
    }
    return null;
  }

  @Override
  public void disposeComponent() {
    // TODO: insert component disposal logic here
  }

  @Override
  @NotNull
  public String getComponentName() {
    return "ApplicationScriptSuiteRegistryComponent";
  }
}
