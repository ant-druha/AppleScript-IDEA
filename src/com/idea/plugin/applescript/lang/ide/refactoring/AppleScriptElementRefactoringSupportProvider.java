package com.idea.plugin.applescript.lang.ide.refactoring;

import com.idea.plugin.applescript.psi.AppleScriptPsiElement;
import com.intellij.lang.refactoring.RefactoringSupportProvider;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

/**
 * Andrey 03.05.2015
 */
public class AppleScriptElementRefactoringSupportProvider extends RefactoringSupportProvider {
  @Override
  public boolean isSafeDeleteAvailable(@NotNull PsiElement element) {
        return element instanceof AppleScriptPsiElement;
    }
}
