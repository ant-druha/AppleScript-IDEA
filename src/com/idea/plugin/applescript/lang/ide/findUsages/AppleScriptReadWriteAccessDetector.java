package com.idea.plugin.applescript.lang.ide.findUsages;

import com.idea.plugin.applescript.psi.AppleScriptReferenceElement;
import com.idea.plugin.applescript.psi.AppleScriptTargetVariable;
import com.intellij.codeInsight.highlighting.ReadWriteAccessDetector;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;

/**
 * Andrey 20.06.2015
 */
public class AppleScriptReadWriteAccessDetector extends ReadWriteAccessDetector {
  @Override
  public boolean isReadWriteAccessible(PsiElement element) {
    return element instanceof AppleScriptTargetVariable || element instanceof AppleScriptReferenceElement;
  }

  @Override
  public boolean isDeclarationWriteAccess(PsiElement element) {
    return element instanceof AppleScriptTargetVariable;
  }

  @Override
  public Access getReferenceAccess(PsiElement referencedElement, PsiReference reference) {
    return getExpressionAccess(reference.getElement());
  }

  @Override
  public Access getExpressionAccess(PsiElement expression) {
    if (isDeclarationWriteAccess(expression)) {
      return Access.Write;
    }
    if (expression instanceof AppleScriptReferenceElement) {
      return Access.Read;
    }
    return null;
  }
}
