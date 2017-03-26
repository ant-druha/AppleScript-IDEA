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

public class AppleScriptAppleScriptPropertyImpl extends AppleScriptPsiElementImpl implements AppleScriptAppleScriptProperty {

  public AppleScriptAppleScriptPropertyImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AppleScriptVisitor visitor) {
    visitor.visitAppleScriptProperty(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AppleScriptVisitor) accept((AppleScriptVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AppleScriptTextItemDelimitersProperty getTextItemDelimitersProperty() {
    return findChildByClass(AppleScriptTextItemDelimitersProperty.class);
  }

  @Override
  @Nullable
  public PsiElement getBuiltInProperty() {
    return findChildByType(BUILT_IN_PROPERTY);
  }

}
