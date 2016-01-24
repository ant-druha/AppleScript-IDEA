package com.intellij.plugin.applescript.psi;

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

  @Nullable
  AppleScriptScriptBody getScriptBody();
}
