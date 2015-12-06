package com.idea.plugin.applescript.psi.sdef.impl;

import com.idea.plugin.applescript.lang.resolve.AppleScriptDictionaryResolveProcessor;
import com.idea.plugin.applescript.lang.resolve.AppleScriptResolveUtil;
import com.idea.plugin.applescript.lang.sdef.DictionaryComponent;
import com.idea.plugin.applescript.psi.sdef.DictionaryCompositeElement;
import com.idea.plugin.applescript.psi.sdef.DictionaryReference;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.intellij.psi.impl.source.resolve.reference.impl.PsiPolyVariantCachingReference;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Andrey.Dernov 8/21/2015
 */
public abstract class AbstractDictionaryReferenceElement extends PsiPolyVariantCachingReference
        implements DictionaryReference {

  @NotNull
  @Override
  public List<TextRange> getRanges() {
    List<TextRange> result = new ArrayList<TextRange>();
    final int parentOffset = -getElement().getTextRange().getStartOffset();
    for (PsiElement id : getElement().getCompositeNameElement().getIdentifiers()) {
      TextRange argumentRange = id.getTextRange();
      if (!argumentRange.isEmpty()) {
        result.add(argumentRange.shiftRight(parentOffset));
      }
    }
    return result;
  }

  @NotNull
  @Override
  protected ResolveResult[] resolveInner(boolean incompleteCode, @NotNull PsiFile containingFile) {
    final AppleScriptDictionaryResolveProcessor resolveProcessor =
            new AppleScriptDictionaryResolveProcessor(getElement(), getCanonicalText());
    List<PsiElement> maxScope = AppleScriptResolveUtil.getTellStatementResolveScope(getElement());
    PsiElement maxTellScope = null;
    final List<PsiElement> res = new ArrayList<PsiElement>();
    DictionaryComponent resolveResult;
    if (!maxScope.isEmpty()) {
      for (PsiElement el : maxScope) {
//      maxTellScope = maxTellScope==null ? el : el.getTextOffset() > maxTellScope.getTextOffset() ? maxTellScope : el;
        PsiTreeUtil.treeWalkUp(resolveProcessor, getElement(), el, ResolveState.initial());
        resolveResult = resolveProcessor.getMyResult();
        if (resolveResult != null) {
          res.add(resolveResult);
          break;
        }
      }
    }
    if (res.isEmpty()) {//if search with
      PsiTreeUtil.treeWalkUp(resolveProcessor, getElement(), null, ResolveState.initial());
      resolveResult = resolveProcessor.getMyResult();
      if (resolveResult != null) {
        res.add(resolveResult);
      }
    }
    return AppleScriptResolveUtil.toCandidateInfoArray(res);
  }

  @Override
  public boolean isReferenceTo(PsiElement element) {
    if (element instanceof DictionaryComponent) {//todo not correct: element should be DictionaryComponent type!
      DictionaryComponent thatElement = (DictionaryComponent) element;
      if (thatElement.getName().equals(getElement().getCompositeNameElement().getCompositeName())) {
        return resolve() == thatElement;
      }
    }
    return super.isReferenceTo(element);
  }

  @Override
  public DictionaryCompositeElement getElement() {
    return getMyElement();
  }

  @NotNull
  protected abstract DictionaryCompositeElement getMyElement();

  @Override
  public TextRange getRangeInElement() {
    return ReferenceRange.getRange(this);
  }

  @NotNull
  @Override
  public String getCanonicalText() {
    return getElement().getCompositeNameElement().getCompositeName();
  }

  @Override
  public PsiElement handleElementRename(String newElementName) throws IncorrectOperationException {
    return getElement();
  }

  @Override
  public PsiElement bindToElement(@NotNull PsiElement element) throws IncorrectOperationException {
    return null;
  }

  @NotNull
  @Override
  public Object[] getVariants() {
    return new Object[0];
  }
}
