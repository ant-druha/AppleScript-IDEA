package com.intellij.plugin.applescript.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.plugin.applescript.psi.AppleScriptComponent;
import com.intellij.plugin.applescript.psi.AppleScriptTargetReference;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementResolveResult;
import com.intellij.psi.ResolveResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Andrey 22.04.2015
 */
public class AppleScriptTargetReferenceImpl extends AppleScriptReferenceElementImpl implements
        AppleScriptTargetReference {

  @NotNull final private AppleScriptComponent myElement;

  public AppleScriptTargetReferenceImpl(@NotNull AppleScriptComponent targetComponent) {
    super(targetComponent.getNode());
    myElement = targetComponent;
  }

  @Override
  public TextRange getRangeInElement() {
    //todo but it won't highlight compjnent when caret is on keyword ... thant's fine
    final ASTNode nameElement = myElement.getNameIdentifier() != null ? myElement.getNameIdentifier().getNode() :
            getNode();
    final TextRange range = nameElement != null ? nameElement.getTextRange() : myElement.getNode().getTextRange();
    return range.shiftRight(-myElement.getNode().getStartOffset());
  }

  @Override
  public TextRange getTextRange() {
    return super.getTextRange();
  }

  @Override
  public int getTextOffset() {
    return myElement.getTextOffset();
  }

  @Nullable
  @Override
  public PsiElement resolve() {
    final ResolveResult[] resolveResults = multiResolve(true);
    return resolveResults.length == 0 || resolveResults.length > 0 &&
            !resolveResults[0].isValidResult() ? null : resolveResults[0].getElement();
  }

  @NotNull
  @Override
  public ResolveResult[] multiResolve(boolean incompleteCode) {
    final ResolveResult[] results = super.multiResolve(incompleteCode);//todo this could return multiply results (for
    // todo target variables )
    return results.length != 0 ? results : new ResolveResult[]{new PsiElementResolveResult(myElement)};
  }

  @Override
  public PsiElement getElement() {
    return myElement;
  }


}
