// This is a generated file. Not intended for manual editing.
package com.idea.plugin.applescript.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import com.idea.plugin.applescript.psi.*;

public class AppleScriptCreationStatementImpl extends AppleScriptPsiElementImpl implements AppleScriptCreationStatement {

  public AppleScriptCreationStatementImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AppleScriptVisitor) ((AppleScriptVisitor)visitor).visitCreationStatement(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<AppleScriptExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptExpression.class);
  }

  @Override
  @Nullable
  public AppleScriptReferenceIdentifier getReferenceIdentifier() {
    return findChildByClass(AppleScriptReferenceIdentifier.class);
  }

  @Override
  @Nullable
  public AppleScriptTargetListLiteral getTargetListLiteral() {
    return findChildByClass(AppleScriptTargetListLiteral.class);
  }

  @Override
  @Nullable
  public AppleScriptTargetRecordLiteral getTargetRecordLiteral() {
    return findChildByClass(AppleScriptTargetRecordLiteral.class);
  }

  @Override
  @Nullable
  public AppleScriptTargetVariable getTargetVariable() {
    return findChildByClass(AppleScriptTargetVariable.class);
  }

  @Nullable
  public AppleScriptPsiElement getAssignmentTarget() {
    return AppleScriptPsiImplUtil.getAssignmentTarget(this);
  }

  @NotNull
  public List<AppleScriptComponentName> getTargetVariableList() {
    return AppleScriptPsiImplUtil.getTargetVariableListRecursive(this);
  }

}
