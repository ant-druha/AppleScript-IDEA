package com.idea.plugin.applescript.psi.impl;

import com.idea.plugin.applescript.AppleScriptFile;
import com.idea.plugin.applescript.psi.AppleScriptComponent;
import com.idea.plugin.applescript.psi.AppleScriptTargetReference;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementResolveResult;
import com.intellij.psi.ResolveResult;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Andrey on 22.04.2015.
 */
public class AppleScriptTargetReferenceImpl extends AppleScriptReferenceElementImpl implements
        AppleScriptTargetReference {

  @NotNull final private AppleScriptComponent myElement;
  @NotNull final private String myName;

  public AppleScriptTargetReferenceImpl(@NotNull AppleScriptComponent targetComponent, @NotNull String nameTarget) {
    super(targetComponent.getNode());
    myElement = targetComponent;
    myName = nameTarget;
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

  @NotNull
  @Override
  public ResolveResult[] multiResolve(boolean incompleteCode) {
    AppleScriptFile psiFile = (AppleScriptFile) getContainingFile();//todo need a check, ugly
    Set<AppleScriptComponent> allComponents = new HashSet<AppleScriptComponent>();
    psiFile.processTopDeclarationsImpl(allComponents);
    final ResolveResult[] results = super.multiResolve(incompleteCode);//todo this could return multiply results (for
    // todo target variables )

    if (!allComponents.isEmpty()) {
      int offset = Integer.MAX_VALUE;
      PsiElement firstDeclaration = null;
      for (AppleScriptComponent component : allComponents) {
        if (myName.equals(component.getName()) && component.getTextOffset() < offset) {
          firstDeclaration = component;
          offset = component.getTextOffset();
        }
      }
      return firstDeclaration != null ? new ResolveResult[]{new PsiElementResolveResult(firstDeclaration)} : results;
    }
    return new ResolveResult[]{new PsiElementResolveResult(myElement)};
  }

  @Override
  public PsiElement getElement() {
    return myElement;
  }


}
