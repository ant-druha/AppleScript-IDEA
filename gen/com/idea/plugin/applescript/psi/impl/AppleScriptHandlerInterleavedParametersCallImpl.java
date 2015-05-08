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

public class AppleScriptHandlerInterleavedParametersCallImpl extends AppleScriptPsiElementImpl implements AppleScriptHandlerInterleavedParametersCall {

  public AppleScriptHandlerInterleavedParametersCallImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AppleScriptVisitor) ((AppleScriptVisitor)visitor).visitHandlerInterleavedParametersCall(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AppleScriptExpression getExpression() {
    return findChildByClass(AppleScriptExpression.class);
  }

  @Override
  @NotNull
  public List<AppleScriptHandlerNamePartReference> getHandlerNamePartReferenceList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptHandlerNamePartReference.class);
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

  @Override
  @Nullable
  public AppleScriptReferenceIdentifier getReferenceIdentifier() {
    return findChildByClass(AppleScriptReferenceIdentifier.class);
  }

  @Override
  @NotNull
  public List<AppleScriptUserParameterVal> getUserParameterValList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptUserParameterVal.class);
  }

}
