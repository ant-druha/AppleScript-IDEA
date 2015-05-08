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

public class AppleScriptErrorCommandExpressionImpl extends AppleScriptExpressionImpl implements AppleScriptErrorCommandExpression {

  public AppleScriptErrorCommandExpressionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AppleScriptVisitor) ((AppleScriptVisitor)visitor).visitErrorCommandExpression(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AppleScriptApplicationObjectReference getApplicationObjectReference() {
    return findChildByClass(AppleScriptApplicationObjectReference.class);
  }

  @Override
  @NotNull
  public List<AppleScriptBuiltInClassName> getBuiltInClassNameList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptBuiltInClassName.class);
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
  @NotNull
  public List<AppleScriptHandlerParameterLabel> getHandlerParameterLabelList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptHandlerParameterLabel.class);
  }

  @Override
  @NotNull
  public List<AppleScriptNumericConstant> getNumericConstantList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptNumericConstant.class);
  }

  @Override
  @Nullable
  public AppleScriptObjectRef getObjectRef() {
    return findChildByClass(AppleScriptObjectRef.class);
  }

  @Override
  @NotNull
  public List<AppleScriptReferenceIdentifier> getReferenceIdentifierList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptReferenceIdentifier.class);
  }

}
