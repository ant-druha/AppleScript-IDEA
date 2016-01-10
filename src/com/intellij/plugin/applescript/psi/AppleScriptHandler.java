package com.intellij.plugin.applescript.psi;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * andrey 29/05/15
 */
public interface AppleScriptHandler extends AppleScriptComponent {

  @Override
  boolean isHandler();

  @Nullable
  @Override
  String getName();

  @Nullable
  @Override
  PsiElement getNameIdentifier();

  @Nullable
  @Override
  PsiReference getReference();

  @NotNull
  String getSelector();

  @NotNull
  List<AppleScriptIdentifier> getSelectors();

  @NotNull
  List<AppleScriptHandlerSelectorPart> getParameters();

}
