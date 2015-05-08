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

public class AppleScriptHandlerLabeledParametersCallImpl extends AppleScriptPsiElementImpl implements AppleScriptHandlerLabeledParametersCall {

  public AppleScriptHandlerLabeledParametersCallImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AppleScriptVisitor) ((AppleScriptVisitor)visitor).visitHandlerLabeledParametersCall(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AppleScriptDirectParameterVal getDirectParameterVal() {
    return findChildByClass(AppleScriptDirectParameterVal.class);
  }

  @Override
  @NotNull
  public List<AppleScriptHandlerParameterLabel> getHandlerParameterLabelList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptHandlerParameterLabel.class);
  }

  @Override
  @NotNull
  public List<AppleScriptParameterVal> getParameterValList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptParameterVal.class);
  }

  @Override
  @Nullable
  public AppleScriptPropertyReference getPropertyReference() {
    return findChildByClass(AppleScriptPropertyReference.class);
  }

  @Override
  @NotNull
  public List<AppleScriptReferenceIdentifier> getReferenceIdentifierList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptReferenceIdentifier.class);
  }

  @Override
  @NotNull
  public List<AppleScriptUserParameterVal> getUserParameterValList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptUserParameterVal.class);
  }

}
