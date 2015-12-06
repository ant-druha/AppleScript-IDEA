package com.idea.plugin.applescript.psi;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Andrey 16.05.2015
 */
public interface AppleScriptScriptObject extends AppleScriptComponent {

  @Nullable
  AppleScriptScriptObject getParentScriptObject();

  @Nullable
  List<AppleScriptComponent> getProperties();

  @Nullable
  List<AppleScriptComponent> getHandlers();

  @NotNull
  AppleScriptBlockBody getScriptBody();
}
