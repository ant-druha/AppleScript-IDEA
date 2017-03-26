// This is a generated file. Not intended for manual editing.
package com.intellij.plugin.applescript.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.intellij.plugin.applescript.psi.AppleScriptTypes.*;
import com.intellij.plugin.applescript.psi.*;

public class AppleScriptFilterReferenceImpl extends AppleScriptPsiElementImpl implements AppleScriptFilterReference {

  public AppleScriptFilterReferenceImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AppleScriptVisitor visitor) {
    visitor.visitFilterReference(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AppleScriptVisitor) accept((AppleScriptVisitor)visitor);
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
  public AppleScriptBuiltInClassIdentifier getBuiltInClassIdentifier() {
    return findChildByClass(AppleScriptBuiltInClassIdentifier.class);
  }

  @Override
  @Nullable
  public AppleScriptBuiltInClassIdentifierPlural getBuiltInClassIdentifierPlural() {
    return findChildByClass(AppleScriptBuiltInClassIdentifierPlural.class);
  }

  @Override
  @Nullable
  public AppleScriptDictionaryClassIdentifierPlural getDictionaryClassIdentifierPlural() {
    return findChildByClass(AppleScriptDictionaryClassIdentifierPlural.class);
  }

  @Override
  @Nullable
  public AppleScriptDictionaryClassName getDictionaryClassName() {
    return findChildByClass(AppleScriptDictionaryClassName.class);
  }

  @Override
  @Nullable
  public AppleScriptDictionaryConstant getDictionaryConstant() {
    return findChildByClass(AppleScriptDictionaryConstant.class);
  }

  @Override
  @Nullable
  public AppleScriptEveryElemReference getEveryElemReference() {
    return findChildByClass(AppleScriptEveryElemReference.class);
  }

  @Override
  @Nullable
  public AppleScriptEveryRangeReference getEveryRangeReference() {
    return findChildByClass(AppleScriptEveryRangeReference.class);
  }

  @Override
  @NotNull
  public List<AppleScriptExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptExpression.class);
  }

  @Override
  @Nullable
  public AppleScriptFilterReference getFilterReference() {
    return findChildByClass(AppleScriptFilterReference.class);
  }

  @Override
  @Nullable
  public AppleScriptHandlerInterleavedParametersCall getHandlerInterleavedParametersCall() {
    return findChildByClass(AppleScriptHandlerInterleavedParametersCall.class);
  }

  @Override
  @Nullable
  public AppleScriptIdReference getIdReference() {
    return findChildByClass(AppleScriptIdReference.class);
  }

  @Override
  @Nullable
  public AppleScriptIndexReference getIndexReference() {
    return findChildByClass(AppleScriptIndexReference.class);
  }

  @Override
  @Nullable
  public AppleScriptIndexReferenceClassForm getIndexReferenceClassForm() {
    return findChildByClass(AppleScriptIndexReferenceClassForm.class);
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
  public AppleScriptRangeFromReference getRangeFromReference() {
    return findChildByClass(AppleScriptRangeFromReference.class);
  }

  @Override
  @Nullable
  public AppleScriptRangeIndexReference getRangeIndexReference() {
    return findChildByClass(AppleScriptRangeIndexReference.class);
  }

  @Override
  @Nullable
  public AppleScriptRelativeReference getRelativeReference() {
    return findChildByClass(AppleScriptRelativeReference.class);
  }

}
