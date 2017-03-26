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

public class AppleScriptEveryRangeReferenceImpl extends AppleScriptPsiElementImpl implements AppleScriptEveryRangeReference {

  public AppleScriptEveryRangeReferenceImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AppleScriptVisitor visitor) {
    visitor.visitEveryRangeReference(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AppleScriptVisitor) accept((AppleScriptVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AppleScriptBuiltInClassIdentifier getBuiltInClassIdentifier() {
    return findChildByClass(AppleScriptBuiltInClassIdentifier.class);
  }

  @Override
  @Nullable
  public AppleScriptDictionaryClassName getDictionaryClassName() {
    return findChildByClass(AppleScriptDictionaryClassName.class);
  }

  @Override
  @NotNull
  public List<AppleScriptExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptExpression.class);
  }

  @Override
  @Nullable
  public AppleScriptUserClassName getUserClassName() {
    return findChildByClass(AppleScriptUserClassName.class);
  }

}
