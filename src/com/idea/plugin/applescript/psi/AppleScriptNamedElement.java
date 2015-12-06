package com.idea.plugin.applescript.psi;

import com.intellij.navigation.NavigationItem;
import com.intellij.psi.PsiNamedElement;
import org.jetbrains.annotations.NotNull;

/**
 * Andrey 08.04.2015
 */
public interface AppleScriptNamedElement extends AppleScriptPsiElement, PsiNamedElement, NavigationItem {

//  @Nullable
//  @Override
//  PsiElement getNameIdentifier();

  @NotNull
  AppleScriptIdentifier getIdentifier();
}
