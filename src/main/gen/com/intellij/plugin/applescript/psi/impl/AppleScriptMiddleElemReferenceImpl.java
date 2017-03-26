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

public class AppleScriptMiddleElemReferenceImpl extends AppleScriptPsiElementImpl implements AppleScriptMiddleElemReference {

  public AppleScriptMiddleElemReferenceImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AppleScriptVisitor visitor) {
    visitor.visitMiddleElemReference(this);
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
  public AppleScriptBuiltInClassIdentifierPlural getBuiltInClassIdentifierPlural() {
    return findChildByClass(AppleScriptBuiltInClassIdentifierPlural.class);
  }

  @Override
  @Nullable
  public AppleScriptDictionaryClassIdentifierPlural getDictionaryClassIdentifierPlural() {
    return findChildByClass(AppleScriptDictionaryClassIdentifierPlural.class);
  }

  @Override
  @Nullable
  public AppleScriptDictionaryClassName getDictionaryClassName() {
    return findChildByClass(AppleScriptDictionaryClassName.class);
  }

  @Override
  @Nullable
  public AppleScriptRawClassExpression getRawClassExpression() {
    return findChildByClass(AppleScriptRawClassExpression.class);
  }

}
