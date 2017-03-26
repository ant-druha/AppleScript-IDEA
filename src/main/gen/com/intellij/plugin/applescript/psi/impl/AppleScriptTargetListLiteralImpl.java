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

public class AppleScriptTargetListLiteralImpl extends AppleScriptPsiElementImpl implements AppleScriptTargetListLiteral {

  public AppleScriptTargetListLiteralImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AppleScriptVisitor visitor) {
    visitor.visitTargetListLiteral(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AppleScriptVisitor) accept((AppleScriptVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<AppleScriptExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptExpression.class);
  }

  @Override
  @NotNull
  public List<AppleScriptTargetListLiteral> getTargetListLiteralList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptTargetListLiteral.class);
  }

  @Override
  @NotNull
  public List<AppleScriptTargetRecordLiteral> getTargetRecordLiteralList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptTargetRecordLiteral.class);
  }

  @Override
  @NotNull
  public List<AppleScriptTargetVariable> getTargetVariableList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptTargetVariable.class);
  }

  @NotNull
  public List<AppleScriptTargetVariable> getTargets() {
    return AppleScriptPsiImplUtil.getTargets(this);
  }

}
