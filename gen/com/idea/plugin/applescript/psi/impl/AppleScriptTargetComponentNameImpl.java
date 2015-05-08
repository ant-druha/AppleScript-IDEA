// This is a generated file. Not intended for manual editing.
package com.idea.plugin.applescript.psi.impl;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.idea.plugin.applescript.psi.*;

public class AppleScriptTargetComponentNameImpl extends AbstractAppleScriptTargetComponent implements AppleScriptTargetComponentName {

  public AppleScriptTargetComponentNameImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AppleScriptVisitor) ((AppleScriptVisitor)visitor).visitTargetComponentName(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public AppleScriptComponentName getComponentName() {
    return findNotNullChildByClass(AppleScriptComponentName.class);
  }

}
