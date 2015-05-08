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

public class AppleScriptDateLiteralExpressionImpl extends AppleScriptExpressionImpl implements AppleScriptDateLiteralExpression {

  public AppleScriptDateLiteralExpressionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AppleScriptVisitor) ((AppleScriptVisitor)visitor).visitDateLiteralExpression(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AppleScriptStringLiteralExpression getStringLiteralExpression() {
    return findChildByClass(AppleScriptStringLiteralExpression.class);
  }

}
