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
  public AppleScriptTargetComponentName getTargetComponentName() {
    return findChildByClass(AppleScriptTargetComponentName.class);
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

  @Nullable
  public AppleScriptPsiElement getTargetComponent() {
    return AppleScriptPsiImplUtil.getTargetComponent(this);
  }

  @NotNull
  public List<AppleScriptComponentName> getComponentNameList() {
    return AppleScriptPsiImplUtil.getComponentNameList(this);
  }

}
