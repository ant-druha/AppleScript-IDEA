// This is a generated file. Not intended for manual editing.
package com.idea.plugin.applescript.psi.impl;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.idea.plugin.applescript.psi.*;

public class AppleScriptVariableDeclarationStatementImpl extends AbstractAppleScriptTargetComponent implements AppleScriptVariableDeclarationStatement {

  public AppleScriptVariableDeclarationStatementImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AppleScriptVisitor) ((AppleScriptVisitor)visitor).visitVariableDeclarationStatement(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AppleScriptBuiltInClassName getBuiltInClassName() {
    return findChildByClass(AppleScriptBuiltInClassName.class);
  }

  @Override
  @Nullable
  public AppleScriptComponentName getComponentName() {
    return findChildByClass(AppleScriptComponentName.class);
  }

}
