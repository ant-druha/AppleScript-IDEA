// This is a generated file. Not intended for manual editing.
package com.idea.plugin.applescript.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.idea.plugin.applescript.psi.AppleScriptTypes.*;
import com.idea.plugin.applescript.psi.*;

public class AppleScriptReferenceExpressionImpl extends AppleScriptExpressionImpl implements AppleScriptReferenceExpression {

  public AppleScriptReferenceExpressionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AppleScriptVisitor) ((AppleScriptVisitor)visitor).visitReferenceExpression(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AppleScriptApplicationReference getApplicationReference() {
    return findChildByClass(AppleScriptApplicationReference.class);
  }

  @Override
  @Nullable
  public AppleScriptArbitraryReference getArbitraryReference() {
    return findChildByClass(AppleScriptArbitraryReference.class);
  }

  @Override
  @Nullable
  public AppleScriptEveryElemReference getEveryElemReference() {
    return findChildByClass(AppleScriptEveryElemReference.class);
  }

  @Override
  @Nullable
  public AppleScriptFileReference getFileReference() {
    return findChildByClass(AppleScriptFileReference.class);
  }

  @Override
  @Nullable
  public AppleScriptHandlerInterleavedParametersCall getHandlerInterleavedParametersCall() {
    return findChildByClass(AppleScriptHandlerInterleavedParametersCall.class);
  }

  @Override
  @Nullable
  public AppleScriptHandlerLabeledParametersCall getHandlerLabeledParametersCall() {
    return findChildByClass(AppleScriptHandlerLabeledParametersCall.class);
  }

  @Override
  @Nullable
  public AppleScriptHandlerPositionalParametersCall getHandlerPositionalParametersCall() {
    return findChildByClass(AppleScriptHandlerPositionalParametersCall.class);
  }

  @Override
  @Nullable
  public AppleScriptIndexReference getIndexReference() {
    return findChildByClass(AppleScriptIndexReference.class);
  }

  @Override
  @Nullable
  public AppleScriptMiddleElemReference getMiddleElemReference() {
    return findChildByClass(AppleScriptMiddleElemReference.class);
  }

  @Override
  @Nullable
  public AppleScriptNameReference getNameReference() {
    return findChildByClass(AppleScriptNameReference.class);
  }

  @Override
  @Nullable
  public AppleScriptPropertyReference getPropertyReference() {
    return findChildByClass(AppleScriptPropertyReference.class);
  }

  @Override
  @Nullable
  public AppleScriptRangeReference getRangeReference() {
    return findChildByClass(AppleScriptRangeReference.class);
  }

  @Override
  @Nullable
  public AppleScriptReferenceIdentifier getReferenceIdentifier() {
    return findChildByClass(AppleScriptReferenceIdentifier.class);
  }

  @Override
  @Nullable
  public AppleScriptRelativeReference getRelativeReference() {
    return findChildByClass(AppleScriptRelativeReference.class);
  }

}
