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

public class AppleScriptHandlerPositionalParametersCallImpl extends AppleScriptPsiElementImpl implements AppleScriptHandlerPositionalParametersCall {

  public AppleScriptHandlerPositionalParametersCallImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AppleScriptVisitor) ((AppleScriptVisitor)visitor).visitHandlerPositionalParametersCall(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<AppleScriptExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptExpression.class);
  }

  @Override
  @Nullable
  public AppleScriptPropertyReference getPropertyReference() {
    return findChildByClass(AppleScriptPropertyReference.class);
  }

  @Override
  @Nullable
  public AppleScriptReferenceIdentifier getReferenceIdentifier() {
    return findChildByClass(AppleScriptReferenceIdentifier.class);
  }

}
