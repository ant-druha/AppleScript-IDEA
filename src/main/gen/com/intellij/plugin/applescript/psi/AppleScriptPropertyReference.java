// This is a generated file. Not intended for manual editing.
package com.intellij.plugin.applescript.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AppleScriptPropertyReference extends AppleScriptPsiElement {

  @Nullable
  AppleScriptAppleScriptProperty getAppleScriptProperty();

  @Nullable
  AppleScriptBuiltInClassIdentifier getBuiltInClassIdentifier();

  @Nullable
  AppleScriptDictionaryConstant getDictionaryConstant();

  @Nullable
  AppleScriptDictionaryPropertyName getDictionaryPropertyName();

  @Nullable
  AppleScriptExpression getExpression();

  @Nullable
  PsiElement getBuiltInProperty();

  @Nullable
  PsiElement getQuotedForm();

  @Nullable
  PsiElement getStringLiteral();

}
