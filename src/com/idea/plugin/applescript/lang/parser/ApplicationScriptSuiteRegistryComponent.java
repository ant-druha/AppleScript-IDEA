package com.idea.plugin.applescript.lang.parser;

import com.idea.plugin.applescript.AppleScriptFileType;
import com.idea.plugin.applescript.lang.ide.libraries.AppleScriptLibraryKind;
import com.idea.plugin.applescript.lang.ide.libraries.ScriptSuiteRegistry;
import com.idea.plugin.applescript.lang.ide.libraries.ScriptSuiteRegistryMappings;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.fileEditor.FileEditorManagerAdapter;
import com.intellij.openapi.fileEditor.FileEditorManagerEvent;
import com.intellij.openapi.fileEditor.FileEditorManagerListener;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.OrderRootType;
import com.intellij.openapi.roots.impl.libraries.LibraryEx;
import com.intellij.openapi.roots.libraries.Library;
import com.intellij.openapi.roots.libraries.LibraryTable;
import com.intellij.openapi.roots.libraries.LibraryTablesRegistrar;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

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

  @Override
  public void initComponent() {
    // TODO: insert component initialization logic here
    ApplicationManager.getApplication().getMessageBus().connect()
            .subscribe(FileEditorManagerListener.FILE_EDITOR_MANAGER, new FileEditorManagerAdapter() {
              @Override
              public void fileOpened(@NotNull final FileEditorManager source, @NotNull final VirtualFile file) {
                if (file.getFileType() == AppleScriptFileType.INSTANCE) {
                  //here we should search for earlier loaded library suites for this
                  // file and load that suite for the file

                  ScriptSuiteRegistryMappings registryMappingsService = ScriptSuiteRegistryMappings.
                          getInstance(source.getProject());
                  ScriptSuiteRegistry restoredLibraryForFile =
                          loadScriptSuiteRegistryForFile(source.getProject(), file);
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
                          loadScriptSuiteRegistryForFile(project, newFile);
                  currentScriptSuiteRegistry = restoredLibraryForFile != null ? restoredLibraryForFile :
                          new ScriptSuiteRegistry(ScriptSuiteRegistry.STD_LIBRARY_NAME, project);
                }

                LibraryTable projectLibraryTable = LibraryTablesRegistrar.getInstance().getLibraryTable(project);
                Collection<VirtualFile> collectedFiles = new ArrayList<VirtualFile>();
                for (Library lib : projectLibraryTable.getLibraries()) {
                  if (lib instanceof LibraryEx) {
                    LibraryEx libEx = (LibraryEx) lib;
                    if (libEx.getKind() == AppleScriptLibraryKind.INSTANCE) {
                      collectedFiles.addAll(Arrays.asList(libEx.getFiles(OrderRootType.CLASSES)));
                    }
                  }

                }
              }

              @Override
              public void fileClosed(@NotNull final FileEditorManager source, @NotNull final VirtualFile file) {

              }
            });
  }

  @Contract("_, null -> null")
  @Nullable
  private static ScriptSuiteRegistry loadScriptSuiteRegistryForFile(@NotNull Project project, @Nullable VirtualFile
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
