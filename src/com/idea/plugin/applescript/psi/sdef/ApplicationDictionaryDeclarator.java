package com.idea.plugin.applescript.psi.sdef;

import com.idea.plugin.applescript.psi.AppleScriptPsiElement;
import org.jetbrains.annotations.Nullable;

public interface ApplicationDictionaryDeclarator extends AppleScriptPsiElement {

  @Nullable
  String getApplicationName();
}
