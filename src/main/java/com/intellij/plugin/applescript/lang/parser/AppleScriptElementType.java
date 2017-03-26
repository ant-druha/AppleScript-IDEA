package com.intellij.plugin.applescript.lang.parser;

import com.intellij.plugin.applescript.AppleScriptLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

/**
 * Andrey.Dernov 2/5/2015
 */
public class AppleScriptElementType extends IElementType {
  public AppleScriptElementType(@NotNull @NonNls String debugName) {
    super(debugName, AppleScriptLanguage.INSTANCE);
  }
}