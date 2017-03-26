// This is a generated file. Not intended for manual editing.
package com.intellij.plugin.applescript.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AppleScriptIndexReference extends AppleScriptPsiElement {

  @Nullable
  AppleScriptBuiltInClassIdentifier getBuiltInClassIdentifier();

  @Nullable
  AppleScriptBuiltInClassIdentifierPlural getBuiltInClassIdentifierPlural();

  @Nullable
  AppleScriptDictionaryClassIdentifierPlural getDictionaryClassIdentifierPlural();

  @Nullable
  AppleScriptDictionaryClassName getDictionaryClassName();

  @NotNull
  List<AppleScriptExpression> getExpressionList();

  @Nullable
  AppleScriptUserClassName getUserClassName();

}
