package com.intellij.plugin.applescript.lang.lexer;

import com.intellij.plugin.applescript.AppleScriptLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

/**
 * Andrey.Dernov 2/5/2015
 */
public class AppleScriptTokenType extends IElementType {
  public AppleScriptTokenType(@NotNull @NonNls String debugName) {
    super(debugName, AppleScriptLanguage.INSTANCE);
  }

  @Override
  public String toString() {
    return super.toString();
//    return super.toString().toLowerCase().replaceAll("_", " ");
  }

  public String getMyDebugName() {
    return "AppleScriptTokenType." + super.toString();
  }
}