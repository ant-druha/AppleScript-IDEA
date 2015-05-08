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

public class AppleScriptFilterReferenceImpl extends AppleScriptPsiElementImpl implements AppleScriptFilterReference {

  public AppleScriptFilterReferenceImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AppleScriptVisitor) ((AppleScriptVisitor)visitor).visitFilterReference(this);
    else super.accept(visitor);
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
  public AppleScriptHandlerParameterLabel getHandlerParameterLabel() {
    return findChildByClass(AppleScriptHandlerParameterLabel.class);
  }

  @Override
  @Nullable
  public AppleScriptNumericConstant getNumericConstant() {
    return findChildByClass(AppleScriptNumericConstant.class);
  }

}
