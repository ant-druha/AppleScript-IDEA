package com.idea.plugin.applescript.lang.ide.refactoring;

import com.idea.plugin.applescript.psi.AppleScriptHandler;
import com.intellij.lang.refactoring.RefactoringSupportProvider;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

/**
 * Andrey 18.06.2015
 */
public class AppleScriptRefactoringSupportProvider extends RefactoringSupportProvider {
  @Override
  public boolean isMemberInplaceRenameAvailable(@NotNull PsiElement element, PsiElement context) {
    return !(element instanceof AppleScriptHandler);
  }

//  public boolean isInplaceRenameAvailable(@NotNull PsiElement element, PsiElement context) {
//    return element instanceof AppleScriptPsiElement;
//  }
//
//
//  @Override
//  public boolean isSafeDeleteAvailable(@NotNull PsiElement element) {
//    return element instanceof AppleScriptPsiElement;
//  }
}
