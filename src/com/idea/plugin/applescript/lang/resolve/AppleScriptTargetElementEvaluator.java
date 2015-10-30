package com.idea.plugin.applescript.lang.resolve;

import com.idea.plugin.applescript.psi.AppleScriptHandlerSelectorPart;
import com.idea.plugin.applescript.psi.AppleScriptReferenceElement;
import com.intellij.codeInsight.TargetElementEvaluatorEx2;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.util.ThreeState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by Andrey on 13.06.2015.
 */
public class AppleScriptTargetElementEvaluator extends TargetElementEvaluatorEx2 {

  //todo why does not this method work? - how to extend Ex2 ?
  @Nullable
  @Override
  public PsiElement getNamedElement(@NotNull PsiElement element) {
    final PsiElement parent = element.getParent();
    if (parent instanceof AppleScriptHandlerSelectorPart) {
      AppleScriptHandlerSelectorPart part = (AppleScriptHandlerSelectorPart) parent;
      if (element != part.findParameterNode()) {
        return part.getParent(); // AppleScriptHandler;
      }
    }
    return null;
  }

  @NotNull
  @Override
  public ThreeState isAcceptableReferencedElement(@Nullable PsiElement element, @Nullable PsiElement
          referenceOrReferencedElement) {
//    return ThreeState.YES;
    return element instanceof AppleScriptReferenceElement ? ThreeState.YES : ThreeState.NO;
  }

  @Override
  public boolean includeSelfInGotoImplementation(@NotNull PsiElement element) {
    return false;
  }

  @Nullable
  @Override
  public PsiElement getElementByReference(@NotNull PsiReference ref, int flags) {
//    final PsiElement elem = ref.getElement();
//    return ref.getElement();
    return null;
  }
}
