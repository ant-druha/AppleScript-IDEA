package com.intellij.plugin.applescript.psi;

import com.intellij.psi.PsiReference;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Created by Andrey on 07.06.2015.
 * todo need to extend expression
 */
public interface AppleScriptHandlerCall extends AppleScriptPsiElement {

  @NotNull
  String getHandlerSelector();

  @NotNull
  @Override
  PsiReference getReference();

  @NotNull
  List<AppleScriptHandlerArgument> getArguments();

}
