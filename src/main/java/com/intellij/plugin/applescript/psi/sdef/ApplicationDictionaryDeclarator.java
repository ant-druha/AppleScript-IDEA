package com.intellij.plugin.applescript.psi.sdef;

import com.intellij.plugin.applescript.psi.AppleScriptPsiElement;
import org.jetbrains.annotations.Nullable;

public interface ApplicationDictionaryDeclarator extends AppleScriptPsiElement {

  @Nullable
  String getApplicationName();
}
