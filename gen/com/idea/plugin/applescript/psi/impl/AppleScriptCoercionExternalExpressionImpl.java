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

public class AppleScriptCoercionExternalExpressionImpl extends AppleScriptExpressionImpl implements AppleScriptCoercionExternalExpression {

  public AppleScriptCoercionExternalExpressionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AppleScriptVisitor) ((AppleScriptVisitor)visitor).visitCoercionExternalExpression(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AppleScriptExpression getExpression() {
    return findChildByClass(AppleScriptExpression.class);
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
  @NotNull
  public AppleScriptReferenceIdentifier getReferenceIdentifier() {
    return findNotNullChildByClass(AppleScriptReferenceIdentifier.class);
  }

}
