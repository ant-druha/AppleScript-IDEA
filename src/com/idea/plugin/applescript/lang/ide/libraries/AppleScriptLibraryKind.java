package com.idea.plugin.applescript.lang.ide.libraries;

import com.intellij.openapi.roots.libraries.LibraryPresentationProvider;
import com.intellij.openapi.roots.libraries.LibraryType;
import com.intellij.openapi.roots.libraries.PersistentLibraryKind;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Andrey on 12.08.2015.
 */
public class AppleScriptLibraryKind extends PersistentLibraryKind<AppleScriptLibraryProperties> {

  public static final PersistentLibraryKind<AppleScriptLibraryProperties> INSTANCE = new AppleScriptLibraryKind();

  /**
   * must be unique among all {@link LibraryType} and {@link LibraryPresentationProvider} implementations.
   */
  public AppleScriptLibraryKind() {
    super("AppleScript");
  }

  @NotNull
  @Override
  public AppleScriptLibraryProperties createDefaultProperties() {
    return new AppleScriptLibraryProperties();
  }
}
