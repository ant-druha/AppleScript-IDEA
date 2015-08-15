package com.idea.plugin.applescript.lang.ide.libraries;

import com.idea.plugin.applescript.AppleScriptIcons;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.libraries.LibraryType;
import com.intellij.openapi.roots.libraries.LibraryTypeService;
import com.intellij.openapi.roots.libraries.NewLibraryConfiguration;
import com.intellij.openapi.roots.libraries.ui.LibraryEditorComponent;
import com.intellij.openapi.roots.libraries.ui.LibraryPropertiesEditor;
import com.intellij.openapi.roots.libraries.ui.LibraryRootsComponentDescriptor;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Created by Andrey on 12.08.2015.
 */
public class AppleScriptLibraryType extends LibraryType<AppleScriptLibraryProperties> {

  protected AppleScriptLibraryType() {
    super(AppleScriptLibraryKind.INSTANCE);
  }

  @Nullable
  @Override
  public String getCreateActionName() {
    return "AppleScript dictionary";
  }

  @Nullable
  @Override
  public NewLibraryConfiguration createNewLibrary(@NotNull JComponent parentComponent, @Nullable VirtualFile
          contextDirectory, @NotNull Project project) {
    return LibraryTypeService.getInstance()
            .createLibraryFromFiles(createLibraryRootsComponentDescriptor(), parentComponent, contextDirectory, this,
                    project);
  }

  @NotNull
  @Override
  public LibraryRootsComponentDescriptor createLibraryRootsComponentDescriptor() {
    return new AppleScriptLibraryRootsComponentDescriptor();
  }

  @Nullable
  @Override
  public LibraryPropertiesEditor createPropertiesEditor(@NotNull LibraryEditorComponent<AppleScriptLibraryProperties>
                                                                editorComponent) {
    return null;
  }

  @Nullable
  @Override
  public Icon getIcon() {
    return AppleScriptIcons.DICTIONARY;
  }
}
