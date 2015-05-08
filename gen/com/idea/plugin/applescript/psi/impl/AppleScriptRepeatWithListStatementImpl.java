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

public class AppleScriptRepeatWithListStatementImpl extends AppleScriptPsiElementImpl implements AppleScriptRepeatWithListStatement {

  public AppleScriptRepeatWithListStatementImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AppleScriptVisitor) ((AppleScriptVisitor)visitor).visitRepeatWithListStatement(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AppleScriptApplicationObjectReference getApplicationObjectReference() {
    return findChildByClass(AppleScriptApplicationObjectReference.class);
  }

  @Override
  @Nullable
  public AppleScriptBlockBody getBlockBody() {
    return findChildByClass(AppleScriptBlockBody.class);
  }

  @Override
  @NotNull
  public AppleScriptComponentName getComponentName() {
    return findNotNullChildByClass(AppleScriptComponentName.class);
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

}
