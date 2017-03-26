// This is a generated file. Not intended for manual editing.
package com.intellij.plugin.applescript.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AppleScriptRelativeReference extends AppleScriptPsiElement {

  @Nullable
  AppleScriptApplicationReference getApplicationReference();

  @Nullable
  AppleScriptArbitraryReference getArbitraryReference();

  @Nullable
  AppleScriptBuiltInClassIdentifier getBuiltInClassIdentifier();

  @Nullable
  AppleScriptBuiltInClassIdentifierPlural getBuiltInClassIdentifierPlural();

  @Nullable
  AppleScriptDictionaryClassIdentifierPlural getDictionaryClassIdentifierPlural();

  @Nullable
  AppleScriptDictionaryClassName getDictionaryClassName();

  @Nullable
  AppleScriptEveryElemReference getEveryElemReference();

  @Nullable
  AppleScriptEveryRangeReference getEveryRangeReference();

  @Nullable
  AppleScriptExpression getExpression();

  @Nullable
  AppleScriptHandlerInterleavedParametersCall getHandlerInterleavedParametersCall();

  @Nullable
  AppleScriptIdReference getIdReference();

  @Nullable
  AppleScriptIndexReference getIndexReference();

  @Nullable
  AppleScriptIndexReferenceClassForm getIndexReferenceClassForm();

  @Nullable
  AppleScriptMiddleElemReference getMiddleElemReference();

  @Nullable
  AppleScriptNameReference getNameReference();

  @Nullable
  AppleScriptPropertyReference getPropertyReference();

  @Nullable
  AppleScriptRangeFromReference getRangeFromReference();

  @Nullable
  AppleScriptRangeIndexReference getRangeIndexReference();

  @Nullable
  AppleScriptRelativeReference getRelativeReference();

}
