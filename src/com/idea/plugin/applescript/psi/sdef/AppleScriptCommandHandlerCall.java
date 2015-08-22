package com.idea.plugin.applescript.psi.sdef;

import com.idea.plugin.applescript.psi.AppleScriptPsiElement;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Created by Andrey on 16.08.2015.
 */
public interface AppleScriptCommandHandlerCall extends AppleScriptPsiElement, DictionaryCompositeElement {

  @NotNull
  String getCommandName();

  @Nullable
  PsiElement getDirectParameter();

  @Nullable
  List<AppleScriptCommandHandlerParameter> getCommandParameters();
}
