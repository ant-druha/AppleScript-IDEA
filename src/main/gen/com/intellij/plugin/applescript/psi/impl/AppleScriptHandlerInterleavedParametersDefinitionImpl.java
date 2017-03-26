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

public class AppleScriptHandlerInterleavedParametersDefinitionImpl extends AppleScriptHandlerInterleavedParameters implements AppleScriptHandlerInterleavedParametersDefinition {

  public AppleScriptHandlerInterleavedParametersDefinitionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AppleScriptVisitor visitor) {
    visitor.visitHandlerInterleavedParametersDefinition(this);
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
  public List<AppleScriptHandlerInterleavedParametersSelectorPart> getHandlerInterleavedParametersSelectorPartList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptHandlerInterleavedParametersSelectorPart.class);
  }

  @Override
  @NotNull
  public List<AppleScriptReferenceExpression> getReferenceExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptReferenceExpression.class);
  }

}
