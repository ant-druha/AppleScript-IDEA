package com.idea.plugin.applescript.psi;

import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Created by Andrey on 16.05.2015.
 */
public interface AppleScriptObject extends AppleScriptComponent {

  @Nullable
  AppleScriptObject getParentScriptObject();

  @Nullable
  List<AppleScriptComponent> getProperties();

  @Nullable
  List<AppleScriptComponent> getHandlers();
}
