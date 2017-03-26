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

public class AppleScriptApplicationHandlerDefinitionImpl extends AppleScriptPsiElementImpl implements AppleScriptApplicationHandlerDefinition {

  public AppleScriptApplicationHandlerDefinitionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AppleScriptVisitor visitor) {
    visitor.visitApplicationHandlerDefinition(this);
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
  public List<AppleScriptObjectTargetPropertyDeclaration> getObjectTargetPropertyDeclarationList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptObjectTargetPropertyDeclaration.class);
  }

  @Override
  @Nullable
  public AppleScriptVarDeclarationList getVarDeclarationList() {
    return findChildByClass(AppleScriptVarDeclarationList.class);
  }

}
