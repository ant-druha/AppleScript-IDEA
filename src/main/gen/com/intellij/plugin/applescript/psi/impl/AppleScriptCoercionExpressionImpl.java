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

public class AppleScriptCoercionExpressionImpl extends AppleScriptExpressionImpl implements AppleScriptCoercionExpression {

  public AppleScriptCoercionExpressionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AppleScriptVisitor visitor) {
    visitor.visitCoercionExpression(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AppleScriptVisitor) accept((AppleScriptVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<AppleScriptApplicationReference> getApplicationReferenceList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptApplicationReference.class);
  }

  @Override
  @NotNull
  public List<AppleScriptArbitraryReference> getArbitraryReferenceList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptArbitraryReference.class);
  }

  @Override
  @NotNull
  public List<AppleScriptBuiltInClassIdentifier> getBuiltInClassIdentifierList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptBuiltInClassIdentifier.class);
  }

  @Override
  @NotNull
  public List<AppleScriptBuiltInClassIdentifierPlural> getBuiltInClassIdentifierPluralList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptBuiltInClassIdentifierPlural.class);
  }

  @Override
  @NotNull
  public List<AppleScriptDictionaryClassIdentifierPlural> getDictionaryClassIdentifierPluralList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptDictionaryClassIdentifierPlural.class);
  }

  @Override
  @NotNull
  public List<AppleScriptDictionaryClassName> getDictionaryClassNameList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptDictionaryClassName.class);
  }

  @Override
  @NotNull
  public List<AppleScriptDictionaryConstant> getDictionaryConstantList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptDictionaryConstant.class);
  }

  @Override
  @NotNull
  public List<AppleScriptEveryElemReference> getEveryElemReferenceList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptEveryElemReference.class);
  }

  @Override
  @NotNull
  public List<AppleScriptEveryRangeReference> getEveryRangeReferenceList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptEveryRangeReference.class);
  }

  @Override
  @NotNull
  public List<AppleScriptFilterReference> getFilterReferenceList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptFilterReference.class);
  }

  @Override
  @NotNull
  public List<AppleScriptHandlerInterleavedParametersCall> getHandlerInterleavedParametersCallList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptHandlerInterleavedParametersCall.class);
  }

  @Override
  @NotNull
  public List<AppleScriptIdReference> getIdReferenceList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptIdReference.class);
  }

  @Override
  @NotNull
  public List<AppleScriptIndexReference> getIndexReferenceList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptIndexReference.class);
  }

  @Override
  @NotNull
  public List<AppleScriptIndexReferenceClassForm> getIndexReferenceClassFormList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptIndexReferenceClassForm.class);
  }

  @Override
  @NotNull
  public List<AppleScriptMiddleElemReference> getMiddleElemReferenceList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptMiddleElemReference.class);
  }

  @Override
  @NotNull
  public List<AppleScriptNameReference> getNameReferenceList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptNameReference.class);
  }

  @Override
  @NotNull
  public List<AppleScriptPropertyReference> getPropertyReferenceList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptPropertyReference.class);
  }

  @Override
  @NotNull
  public List<AppleScriptRangeFromReference> getRangeFromReferenceList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptRangeFromReference.class);
  }

  @Override
  @NotNull
  public List<AppleScriptRangeIndexReference> getRangeIndexReferenceList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptRangeIndexReference.class);
  }

  @Override
  @NotNull
  public List<AppleScriptRelativeReference> getRelativeReferenceList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptRelativeReference.class);
  }

}
