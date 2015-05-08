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

public class AppleScriptHandlerNamePartReferenceImpl extends AppleScriptPsiElementImpl implements AppleScriptHandlerNamePartReference {

  public AppleScriptHandlerNamePartReferenceImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AppleScriptVisitor) ((AppleScriptVisitor)visitor).visitHandlerNamePartReference(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public AppleScriptReferenceIdentifier getReferenceIdentifier() {
    return findNotNullChildByClass(AppleScriptReferenceIdentifier.class);
  }

}
