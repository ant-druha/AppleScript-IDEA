package com.intellij.plugin.applescript.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.plugin.applescript.lang.resolve.AppleScriptResolveProcessor;
import com.intellij.plugin.applescript.lang.resolve.AppleScriptResolveUtil;
import com.intellij.plugin.applescript.psi.*;
import com.intellij.psi.*;
import com.intellij.psi.impl.source.resolve.reference.impl.PsiPolyVariantCachingReference;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Andrey 07.06.2015
 */
public abstract class AbstractAppleScriptHandlerCall extends AppleScriptPsiElementImpl implements
        AppleScriptHandlerCall {

  private SelectorReference mySelectorReference;

  AbstractAppleScriptHandlerCall(ASTNode node) {
    super(node);
    mySelectorReference = new SelectorReference();
  }

  @NotNull
  @Override
  public String getHandlerSelector() {
    final StringBuilder result = new StringBuilder();
    for (AppleScriptHandlerArgument argument : getArguments()) {
      result.append(argument.getArgumentSelector().getSelectorName());
    }
    return result.toString();
  }

  @NotNull
  @Override
  public PsiReference getReference() {
    return mySelectorReference;
  }

  @NotNull
  @Override
  public List<AppleScriptHandlerArgument> getArguments() {
    return findChildrenByType(AppleScriptTypes.HANDLER_ARGUMENT);
  }

  private class SelectorReference extends PsiPolyVariantCachingReference implements MultiRangeReference,
          PsiPolyVariantReference {
    @NotNull
    @Override
    public List<TextRange> getRanges() {
      List<TextRange> result = new ArrayList<>();
      final int parentOffset = -getElement().getTextRange().getStartOffset();
      List<AppleScriptHandlerArgument> arguments = getArguments();
      for (AppleScriptHandlerArgument argument : arguments) {
        PsiElement id = argument.getArgumentSelector().getSelectorIdentifier();
        if (id != null) {
          TextRange argumentRange = id.getTextRange();
          if (!argumentRange.isEmpty()) {
            result.add(argumentRange.shiftRight(parentOffset));
          }
        }
      }
      return result;
    }

    @NotNull
    @Override
    protected ResolveResult[] resolveInner(boolean incompleteCode, @NotNull PsiFile containingFile) {
      final AppleScriptResolveProcessor resolveProcessor = new AppleScriptResolveProcessor(getHandlerSelector());
      PsiTreeUtil.treeWalkUp(resolveProcessor, AbstractAppleScriptHandlerCall.this, null, ResolveState.initial());
      final List<PsiElement> results = new ArrayList<>();
      results.add(resolveProcessor.getResult());
      return AppleScriptResolveUtil.toCandidateInfoArray(results);
    }

    @Override
    public boolean isReferenceTo(PsiElement element) {
      PsiElement target = resolve();
      if (element instanceof AppleScriptHandler && target != null) {
        AppleScriptHandler thatHandler = (AppleScriptHandler) element;
//        return getHandlerSelector().equals(thatHandler.getSelector());
        return target == thatHandler;
      }
      return super.isReferenceTo(element);
    }

    @Override
    public PsiElement getElement() {
      return AbstractAppleScriptHandlerCall.this;
    }

    @Override
    public TextRange getRangeInElement() {
      return ReferenceRange.getRange(this);
    }

    @NotNull
    @Override
    public String getCanonicalText() {
      return getHandlerSelector();
    }

    @Override
    public PsiElement handleElementRename(String newElementName) throws IncorrectOperationException {
      //todo implement this via rename refactor: RenamePsiElementProcessor & RenameHandler for each distinct selector
      final int mySelectorParts = getArguments().size();
      final String[] newSelectorParts = newElementName.split(":");
      if (newSelectorParts.length == mySelectorParts) {
        for (int index = 0; index < mySelectorParts; index++) {
          final AppleScriptIdentifier myId = getArguments().get(index).getArgumentSelector().getSelectorIdentifier();
          final AppleScriptIdentifier newId = AppleScriptPsiElementFactory.createIdentifierFromText(getProject(),
                  newSelectorParts[index]);
          if (newId != null && myId != null) {
            myId.replace(newId);
          }
        }
      } else {
        final AppleScriptIdentifier myIdentifier = getArguments().get(0).getArgumentSelector().getSelectorIdentifier();
        final AppleScriptIdentifier identifierNew = AppleScriptPsiElementFactory.createIdentifierFromText(getProject(),
                newElementName);
        if (identifierNew != null && myIdentifier != null) {
          myIdentifier.replace(identifierNew);
        }
      }
      return AbstractAppleScriptHandlerCall.this;
    }

    @Override
    public PsiElement bindToElement(@NotNull PsiElement element) throws IncorrectOperationException {
      //todo
      return null;
    }

    @NotNull
    @Override
    public Object[] getVariants() {
      return new Object[0];
    }
  }
}
