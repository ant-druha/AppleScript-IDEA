// This is a generated file. Not intended for manual editing.
package com.idea.plugin.applescript.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AppleScriptRangeReference extends AppleScriptPsiElement {

  @Nullable
  AppleScriptBuiltInClassName getBuiltInClassName();

  @NotNull
  List<AppleScriptExpression> getExpressionList();

  @Nullable
  AppleScriptReferenceIdentifier getReferenceIdentifier();

}
