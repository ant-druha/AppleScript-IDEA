// This is a generated file. Not intended for manual editing.
package com.intellij.plugin.applescript.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.openapi.util.Pair;

public interface AppleScriptAssignmentStatement extends AppleScriptPsiElement {

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
  AppleScriptDictionaryConstant getDictionaryConstant();

  @Nullable
  AppleScriptEveryElemReference getEveryElemReference();

  @Nullable
  AppleScriptEveryRangeReference getEveryRangeReference();

  @NotNull
  List<AppleScriptExpression> getExpressionList();

  @Nullable
  AppleScriptFilterReference getFilterReference();

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

  @Nullable
  AppleScriptTargetListLiteral getTargetListLiteral();

  @Nullable
  AppleScriptTargetRecordLiteral getTargetRecordLiteral();

  @Nullable
  AppleScriptTargetVariable getTargetVariable();

  @Nullable
  PsiElement getStringLiteral();

  @Nullable
  AppleScriptPsiElement getAssignmentTarget();

  @NotNull
  List<AppleScriptTargetVariable> getTargets();

  @NotNull
  List<Pair<AppleScriptPsiElement, AppleScriptExpression>> getTargetsToValuesMapping();

}
