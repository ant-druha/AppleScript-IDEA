package com.intellij.plugin.applescript.lang.resolve;

import com.intellij.plugin.applescript.psi.AppleScriptPsiElement;
import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.PsiScopeProcessor;
import org.jetbrains.annotations.NotNull;

/**
 * Andrey 15.04.2015
 */
public abstract class AppleScriptPsiScopeProcessor implements PsiScopeProcessor {
  @Override
  public boolean execute(final @NotNull PsiElement element, final @NotNull ResolveState state) {
    return !(element instanceof AppleScriptPsiElement) || doExecute((AppleScriptPsiElement) element, state);

  }

  protected abstract boolean doExecute(@NotNull AppleScriptPsiElement element, final @NotNull ResolveState state);
}
