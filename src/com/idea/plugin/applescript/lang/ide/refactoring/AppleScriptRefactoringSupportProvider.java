package com.idea.plugin.applescript.lang.ide.refactoring;

import com.idea.plugin.applescript.psi.AppleScriptHandler;
import com.intellij.lang.refactoring.RefactoringSupportProvider;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Andrey on 18.06.2015.
 */
public class AppleScriptRefactoringSupportProvider extends RefactoringSupportProvider {
  @Override
  public boolean isMemberInplaceRenameAvailable(@NotNull PsiElement element, PsiElement context) {
    return !(element instanceof AppleScriptHandler);
  }
}
