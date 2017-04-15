package com.intellij.plugin.applescript.lang.ide.findUsages;

import com.intellij.codeInsight.highlighting.ReadWriteAccessDetector;
import com.intellij.plugin.applescript.psi.AppleScriptReferenceElement;
import com.intellij.plugin.applescript.psi.AppleScriptTargetVariable;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import org.jetbrains.annotations.NotNull;

/**
 * Andrey 20.06.2015
 */
public class AppleScriptReadWriteAccessDetector extends ReadWriteAccessDetector {
  @Override
  public boolean isReadWriteAccessible(@NotNull PsiElement element) {
    return element instanceof AppleScriptTargetVariable || element instanceof AppleScriptReferenceElement;
  }

  @Override
  public boolean isDeclarationWriteAccess(@NotNull PsiElement element) {
    return element instanceof AppleScriptTargetVariable;
  }

  @NotNull
  @Override
  public Access getReferenceAccess(@NotNull PsiElement referencedElement, @NotNull PsiReference reference) {
    return getExpressionAccess(reference.getElement());
  }

  @NotNull
  @Override
  public Access getExpressionAccess(@NotNull PsiElement expression) {
    if (isDeclarationWriteAccess(expression)) {
      return Access.Write;
    }
    if (expression instanceof AppleScriptReferenceElement) {
      return Access.Read;
    }
    return Access.Read;
  }
}
