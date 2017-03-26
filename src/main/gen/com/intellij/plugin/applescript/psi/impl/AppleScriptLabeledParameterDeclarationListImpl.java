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

public class AppleScriptLabeledParameterDeclarationListImpl extends AppleScriptPsiElementImpl implements AppleScriptLabeledParameterDeclarationList {

  public AppleScriptLabeledParameterDeclarationListImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AppleScriptVisitor visitor) {
    visitor.visitLabeledParameterDeclarationList(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AppleScriptVisitor) accept((AppleScriptVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AppleScriptDirectParameterDeclaration getDirectParameterDeclaration() {
    return findChildByClass(AppleScriptDirectParameterDeclaration.class);
  }

  @Override
  @NotNull
  public List<AppleScriptLabeledParameterDeclarationPart> getLabeledParameterDeclarationPartList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptLabeledParameterDeclarationPart.class);
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

  public List<AppleScriptComponent> getComponentList() {
    return AppleScriptPsiImplUtil.getComponentList(this);
  }

}
