// This is a generated file. Not intended for manual editing.
package com.idea.plugin.applescript.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import com.idea.plugin.applescript.psi.*;

public class AppleScriptTargetListLiteralImpl extends AppleScriptPsiElementImpl implements AppleScriptTargetListLiteral {

  public AppleScriptTargetListLiteralImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AppleScriptVisitor) ((AppleScriptVisitor)visitor).visitTargetListLiteral(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<AppleScriptTargetListLiteral> getTargetListLiteralList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptTargetListLiteral.class);
  }

  @Override
  @NotNull
  public List<AppleScriptTargetRecordLiteral> getTargetRecordLiteralList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptTargetRecordLiteral.class);
  }

  @Override
  @NotNull
  public List<AppleScriptTargetVariable> getTargetVariableList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptTargetVariable.class);
  }

  @NotNull
  public List<AppleScriptTargetVariable> getTargetVariableListRecursive() {
    return AppleScriptPsiImplUtil.getTargetVariableListRecursive(this);
  }

}
