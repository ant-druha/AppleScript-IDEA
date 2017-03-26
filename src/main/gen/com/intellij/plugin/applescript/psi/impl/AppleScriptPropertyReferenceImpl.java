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

public class AppleScriptPropertyReferenceImpl extends AppleScriptPsiElementImpl implements AppleScriptPropertyReference {

  public AppleScriptPropertyReferenceImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AppleScriptVisitor visitor) {
    visitor.visitPropertyReference(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AppleScriptVisitor) accept((AppleScriptVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AppleScriptAppleScriptProperty getAppleScriptProperty() {
    return findChildByClass(AppleScriptAppleScriptProperty.class);
  }

  @Override
  @Nullable
  public AppleScriptBuiltInClassIdentifier getBuiltInClassIdentifier() {
    return findChildByClass(AppleScriptBuiltInClassIdentifier.class);
  }

  @Override
  @Nullable
  public AppleScriptDictionaryConstant getDictionaryConstant() {
    return findChildByClass(AppleScriptDictionaryConstant.class);
  }

  @Override
  @Nullable
  public AppleScriptDictionaryPropertyName getDictionaryPropertyName() {
    return findChildByClass(AppleScriptDictionaryPropertyName.class);
  }

  @Override
  @Nullable
  public AppleScriptExpression getExpression() {
    return findChildByClass(AppleScriptExpression.class);
  }

  @Override
  @Nullable
  public PsiElement getBuiltInProperty() {
    return findChildByType(BUILT_IN_PROPERTY);
  }

  @Override
  @Nullable
  public PsiElement getQuotedForm() {
    return findChildByType(QUOTED_FORM);
  }

  @Override
  @Nullable
  public PsiElement getStringLiteral() {
    return findChildByType(STRING_LITERAL);
  }

}
