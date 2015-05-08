// This is a generated file. Not intended for manual editing.
package com.idea.plugin.applescript.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AppleScriptIndexReference extends AppleScriptPsiElement {

  @Nullable
  AppleScriptBuiltInClassName getBuiltInClassName();

  @Nullable
  AppleScriptExpression getExpression();

  @NotNull
  List<AppleScriptReferenceIdentifier> getReferenceIdentifierList();

}
