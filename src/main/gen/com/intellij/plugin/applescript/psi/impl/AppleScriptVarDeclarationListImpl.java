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

public class AppleScriptVarDeclarationListImpl extends AppleScriptPsiElementImpl implements AppleScriptVarDeclarationList {

  public AppleScriptVarDeclarationListImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AppleScriptVisitor visitor) {
    visitor.visitVarDeclarationList(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AppleScriptVisitor) accept((AppleScriptVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public AppleScriptVarAccessDeclaration getVarAccessDeclaration() {
    return findNotNullChildByClass(AppleScriptVarAccessDeclaration.class);
  }

  @Override
  @NotNull
  public List<AppleScriptVarDeclarationListPart> getVarDeclarationListPartList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptVarDeclarationListPart.class);
  }

}
