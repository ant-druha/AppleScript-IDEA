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

public class AppleScriptRecordLiteralExpressionImpl extends AppleScriptExpressionImpl implements AppleScriptRecordLiteralExpression {

  public AppleScriptRecordLiteralExpressionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AppleScriptVisitor) ((AppleScriptVisitor)visitor).visitRecordLiteralExpression(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<AppleScriptBuiltInClassName> getBuiltInClassNameList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptBuiltInClassName.class);
  }

  @Override
  @NotNull
  public List<AppleScriptComponentName> getComponentNameList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptComponentName.class);
  }

  @Override
  @NotNull
  public List<AppleScriptExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptExpression.class);
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

}
