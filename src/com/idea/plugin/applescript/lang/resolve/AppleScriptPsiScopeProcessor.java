package com.idea.plugin.applescript.lang.resolve;

import com.idea.plugin.applescript.psi.AppleScriptComponent;
import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.PsiScopeProcessor;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Andrey on 15.04.2015.
 */
public abstract class AppleScriptPsiScopeProcessor implements PsiScopeProcessor {
  @Override
  public boolean execute(final @NotNull PsiElement element, final @NotNull ResolveState state) {
    return !(element instanceof AppleScriptComponent) || doExecute((AppleScriptComponent) element);

  }

  protected abstract boolean doExecute(@NotNull AppleScriptComponent element);
}
