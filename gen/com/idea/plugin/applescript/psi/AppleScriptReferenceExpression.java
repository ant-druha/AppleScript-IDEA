// This is a generated file. Not intended for manual editing.
package com.idea.plugin.applescript.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AppleScriptReferenceExpression extends AppleScriptExpression {

  @Nullable
  AppleScriptApplicationReference getApplicationReference();

  @Nullable
  AppleScriptArbitraryReference getArbitraryReference();

  @Nullable
  AppleScriptEveryElemReference getEveryElemReference();

  @Nullable
  AppleScriptFileReference getFileReference();

  @Nullable
  AppleScriptHandlerInterleavedParametersCall getHandlerInterleavedParametersCall();

  @Nullable
  AppleScriptHandlerLabeledParametersCall getHandlerLabeledParametersCall();

  @Nullable
  AppleScriptHandlerPositionalParametersCall getHandlerPositionalParametersCall();

  @Nullable
  AppleScriptIndexReference getIndexReference();

  @Nullable
  AppleScriptMiddleElemReference getMiddleElemReference();

  @Nullable
  AppleScriptNameReference getNameReference();

  @Nullable
  AppleScriptPropertyReference getPropertyReference();

  @Nullable
  AppleScriptRangeReference getRangeReference();

  @Nullable
  AppleScriptReferenceIdentifier getReferenceIdentifier();

  @Nullable
  AppleScriptRelativeReference getRelativeReference();

}
