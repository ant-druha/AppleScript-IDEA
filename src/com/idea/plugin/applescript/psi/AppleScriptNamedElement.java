package com.idea.plugin.applescript.psi;

import com.intellij.navigation.NavigationItem;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNameIdentifierOwner;
import com.intellij.psi.PsiNamedElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by Andrey on 08.04.2015.
 */
public interface AppleScriptNamedElement extends AppleScriptPsiElement, PsiNamedElement, NavigationItem,
        PsiNameIdentifierOwner {

  @Nullable
  @Override
  PsiElement getNameIdentifier();

  @NotNull
  AppleScriptIdentifier getIdentifier();
}
