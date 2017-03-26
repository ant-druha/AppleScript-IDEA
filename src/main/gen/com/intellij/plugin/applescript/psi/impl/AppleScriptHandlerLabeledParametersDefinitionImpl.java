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

public class AppleScriptHandlerLabeledParametersDefinitionImpl extends AbstractAppleScriptComponent implements AppleScriptHandlerLabeledParametersDefinition {

  public AppleScriptHandlerLabeledParametersDefinitionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AppleScriptVisitor visitor) {
    visitor.visitHandlerLabeledParametersDefinition(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AppleScriptVisitor) accept((AppleScriptVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AppleScriptBlockBody getBlockBody() {
    return findChildByClass(AppleScriptBlockBody.class);
  }

  @Override
  @NotNull
  public AppleScriptIdentifier getIdentifier() {
    return findNotNullChildByClass(AppleScriptIdentifier.class);
  }

  @Override
  @NotNull
  public AppleScriptLabeledParameterDeclarationList getLabeledParameterDeclarationList() {
    return findNotNullChildByClass(AppleScriptLabeledParameterDeclarationList.class);
  }

  @Override
  @NotNull
  public List<AppleScriptObjectTargetPropertyDeclaration> getObjectTargetPropertyDeclarationList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptObjectTargetPropertyDeclaration.class);
  }

  @Override
  @Nullable
  public AppleScriptReferenceExpression getReferenceExpression() {
    return findChildByClass(AppleScriptReferenceExpression.class);
  }

  @Override
  @Nullable
  public AppleScriptVarDeclarationList getVarDeclarationList() {
    return findChildByClass(AppleScriptVarDeclarationList.class);
  }

  public List<AppleScriptComponent> getParameterComponentList() {
    return AppleScriptPsiImplUtil.getParameterComponentList(this);
  }

}
