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

public class AppleScriptBuiltInConstantLiteralExpressionImpl extends AppleScriptExpressionImpl implements AppleScriptBuiltInConstantLiteralExpression {

  public AppleScriptBuiltInConstantLiteralExpressionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AppleScriptVisitor visitor) {
    visitor.visitBuiltInConstantLiteralExpression(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AppleScriptVisitor) accept((AppleScriptVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getCurrentApp() {
    return findChildByType(CURRENT_APP);
  }

  @Override
  @Nullable
  public PsiElement getCurrentApplication() {
    return findChildByType(CURRENT_APPLICATION);
  }

  @Override
  @Nullable
  public PsiElement getMissingValue() {
    return findChildByType(MISSING_VALUE);
  }

}
