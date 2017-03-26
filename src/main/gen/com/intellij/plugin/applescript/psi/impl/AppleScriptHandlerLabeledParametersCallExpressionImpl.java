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

public class AppleScriptHandlerLabeledParametersCallExpressionImpl extends AppleScriptExpressionImpl implements AppleScriptHandlerLabeledParametersCallExpression {

  public AppleScriptHandlerLabeledParametersCallExpressionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AppleScriptVisitor visitor) {
    visitor.visitHandlerLabeledParametersCallExpression(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AppleScriptVisitor) accept((AppleScriptVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AppleScriptDirectParameterVal getDirectParameterVal() {
    return findChildByClass(AppleScriptDirectParameterVal.class);
  }

  @Override
  @NotNull
  public List<AppleScriptHandlerParameterLabel> getHandlerParameterLabelList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptHandlerParameterLabel.class);
  }

  @Override
  @NotNull
  public List<AppleScriptParameterVal> getParameterValList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptParameterVal.class);
  }

}
