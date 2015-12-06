package com.idea.plugin.applescript.psi.sdef;

import com.idea.plugin.applescript.psi.AppleScriptPsiElement;
import org.jetbrains.annotations.NotNull;

/**
 * Andrey 16.08.2015
 */
public interface DictionaryCompositeElement extends AppleScriptPsiElement {

  @NotNull
  @Override
  DictionaryReference getReference();

  @NotNull
  DictionaryCompositeName getCompositeNameElement();
}
