package com.idea.plugin.applescript.psi.sdef;

import com.idea.plugin.applescript.psi.AppleScriptPsiElement;
import com.intellij.psi.PsiReference;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Andrey on 16.08.2015.
 */
public interface DictionaryCompositeElement extends AppleScriptPsiElement {

  @NotNull
  @Override
  PsiReference getReference();

  @NotNull
  DictionaryCompositeName getCompositeNameElement();
}
