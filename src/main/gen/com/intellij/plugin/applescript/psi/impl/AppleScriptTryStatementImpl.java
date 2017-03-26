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

public class AppleScriptTryStatementImpl extends AppleScriptPsiElementImpl implements AppleScriptTryStatement {

  public AppleScriptTryStatementImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AppleScriptVisitor visitor) {
    visitor.visitTryStatement(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AppleScriptVisitor) accept((AppleScriptVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<AppleScriptBlockBody> getBlockBodyList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptBlockBody.class);
  }

  @Override
  @NotNull
  public List<AppleScriptDirectParameterDeclaration> getDirectParameterDeclarationList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptDirectParameterDeclaration.class);
  }

  @Override
  @NotNull
  public List<AppleScriptExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptExpression.class);
  }

  @Override
  @Nullable
  public AppleScriptVarDeclarationList getVarDeclarationList() {
    return findChildByClass(AppleScriptVarDeclarationList.class);
  }

}
