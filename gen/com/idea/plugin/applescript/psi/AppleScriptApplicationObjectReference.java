// This is a generated file. Not intended for manual editing.
package com.idea.plugin.applescript.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AppleScriptApplicationObjectReference extends AppleScriptPsiElement {

  @Nullable
  AppleScriptApplicationObjectReference getApplicationObjectReference();

  @NotNull
  AppleScriptApplicationReference getApplicationReference();

  @Nullable
  AppleScriptExpression getExpression();

  @Nullable
  AppleScriptFilterReference getFilterReference();

  @Nullable
  AppleScriptHandlerInterleavedParametersCall getHandlerInterleavedParametersCall();

  @Nullable
  AppleScriptHandlerParameterLabel getHandlerParameterLabel();

  @Nullable
  AppleScriptNumericConstant getNumericConstant();

}
