package com.idea.plugin.applescript.psi.impl;

import com.idea.plugin.applescript.lang.resolve.AppleScriptComponentScopeResolver;
import com.idea.plugin.applescript.lang.resolve.AppleScriptResolveUtil;
import com.idea.plugin.applescript.lang.resolve.AppleScriptResolver;
import com.idea.plugin.applescript.psi.AppleScriptIdentifier;
import com.idea.plugin.applescript.psi.AppleScriptPsiElementFactory;
import com.idea.plugin.applescript.psi.AppleScriptReferenceElement;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.openapi.util.UnfairTextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiPolyVariantReference;
import com.intellij.psi.PsiReference;
import com.intellij.psi.ResolveResult;
import com.intellij.psi.impl.source.resolve.ResolveCache;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Created by Andrey on 13.04.2015.
 */
public class AppleScriptReferenceElementImpl extends AppleScriptExpressionImpl implements
        AppleScriptReferenceElement, PsiPolyVariantReference {


  public AppleScriptReferenceElementImpl(ASTNode node) {
    super(node);
    //todo create private field - myElement and do not extent wrapper??
  }

  @NotNull
  @Override
  public ResolveResult[] multiResolve(boolean incompleteCode) {
    final List<? extends PsiElement> elements =
            ResolveCache.getInstance(getProject()).resolveWithCaching(this, AppleScriptResolver.INSTANCE,
                    true, incompleteCode);
    return AppleScriptResolveUtil.toCandidateInfoArray(elements);
  }

  @Override
  public PsiReference getReference() {
    return this;
  }

  @Override
  public PsiElement getElement() {
    return this;
  }

  @Override
  public TextRange getRangeInElement() {
    final TextRange textRange = getTextRange();

    AppleScriptReferenceElement[] appleScriptReferences = PsiTreeUtil.getChildrenOfType(this,
            AppleScriptReferenceElement.class);
    if (appleScriptReferences != null && appleScriptReferences.length > 0) {
      TextRange lastReferenceRange = appleScriptReferences[appleScriptReferences.length - 1].getTextRange();
      return new UnfairTextRange(
              lastReferenceRange.getStartOffset() - textRange.getStartOffset(),
              lastReferenceRange.getEndOffset() - textRange.getEndOffset()
      );
    }
    return new UnfairTextRange(0, textRange.getEndOffset() - textRange.getStartOffset());
  }

  @Nullable
  @Override
  public PsiElement resolve() {
    final ResolveResult[] resolveResults = multiResolve(true);

    return resolveResults.length == 0 ||
            resolveResults.length > 1 ||
            !resolveResults[0].isValidResult() ? null : resolveResults[0].getElement();
  }

  @NotNull
  @Override
  public String getCanonicalText() {
    return getText();
  }

  @Override
  public PsiElement handleElementRename(String newElementName) throws IncorrectOperationException {
    PsiElement element = this;
    final AppleScriptIdentifier identifier = PsiTreeUtil.getChildOfType(element, AppleScriptIdentifier.class);
    final AppleScriptIdentifier identifierNew = AppleScriptPsiElementFactory.createIdentifierFromText(getProject(),
            newElementName);
    if (identifierNew != null && identifier != null) {
      element.getNode().replaceChild(identifier.getNode(), identifierNew.getNode());
    }
    return this;
  }

  @Override
  public PsiElement bindToElement(@NotNull PsiElement element) throws IncorrectOperationException {
    return this;
  }

  @Override
  public boolean isReferenceTo(PsiElement element) {
    PsiElement target = resolve();
    return target == element;
  }

  @NotNull
  @Override
  public Object[] getVariants() {
    final List<? extends PsiElement> elements =
            ResolveCache.getInstance(getProject()).resolveWithCaching(this, AppleScriptComponentScopeResolver
                    .INSTANCE, true, true);
    return elements != null ? elements.toArray() : LookupElement.EMPTY_ARRAY;
  }

  @Override
  public boolean isSoft() {
    return false;
  }
}
