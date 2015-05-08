// This is a generated file. Not intended for manual editing.
package com.idea.plugin.applescript.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AppleScriptPropertyReference extends AppleScriptPsiElement {

  @Nullable
  AppleScriptBuiltInClassName getBuiltInClassName();

  @Nullable
  AppleScriptExpression getExpression();

  @Nullable
  AppleScriptNumericConstant getNumericConstant();

  @Nullable
  AppleScriptReferenceIdentifier getReferenceIdentifier();

  @Nullable
  PsiElement getStringLiteral();

}
