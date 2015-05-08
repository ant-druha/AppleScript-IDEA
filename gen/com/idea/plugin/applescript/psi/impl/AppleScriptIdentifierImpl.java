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

public class AppleScriptIdentifierImpl extends AppleScriptPsiElementImpl implements AppleScriptIdentifier {

  public AppleScriptIdentifierImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AppleScriptVisitor) ((AppleScriptVisitor)visitor).visitIdentifier(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AppleScriptAppleScriptProperty getAppleScriptProperty() {
    return findChildByClass(AppleScriptAppleScriptProperty.class);
  }

  @Override
  @Nullable
  public PsiElement getVarIdentifier() {
    return findChildByType(VAR_IDENTIFIER);
  }

}
