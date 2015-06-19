package com.idea.plugin.applescript.psi;

import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNameIdentifierOwner;
import com.intellij.psi.PsiReference;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by andrey on 28/05/15.
 */
public interface AppleScriptHandlerSelectorPart extends AppleScriptNamedElement, PsiNameIdentifierOwner {

  @Nullable
  @Override
  PsiReference getReference();

  @Nullable
  String getParameterName();

  @Nullable
  ASTNode findParameterNode();

  @Nullable
  PsiElement getParameter();

  @Nullable
  @Override
  PsiElement getNameIdentifier();

  @NotNull
  @Override
  AppleScriptIdentifier getIdentifier();

  @NotNull
  String getSelectorPart();

  @Nullable
  @Override
  ItemPresentation getPresentation();

  @Override
  PsiElement setName(@NotNull String name) throws IncorrectOperationException;

  @NotNull
  AppleScriptIdentifier getSelectorNameIdentifier();

}
