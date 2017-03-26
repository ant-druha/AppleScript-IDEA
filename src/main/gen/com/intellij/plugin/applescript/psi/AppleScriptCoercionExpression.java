// This is a generated file. Not intended for manual editing.
package com.intellij.plugin.applescript.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AppleScriptCoercionExpression extends AppleScriptExpression {

  @NotNull
  List<AppleScriptApplicationReference> getApplicationReferenceList();

  @NotNull
  List<AppleScriptArbitraryReference> getArbitraryReferenceList();

  @NotNull
  List<AppleScriptBuiltInClassIdentifier> getBuiltInClassIdentifierList();

  @NotNull
  List<AppleScriptBuiltInClassIdentifierPlural> getBuiltInClassIdentifierPluralList();

  @NotNull
  List<AppleScriptDictionaryClassIdentifierPlural> getDictionaryClassIdentifierPluralList();

  @NotNull
  List<AppleScriptDictionaryClassName> getDictionaryClassNameList();

  @NotNull
  List<AppleScriptDictionaryConstant> getDictionaryConstantList();

  @NotNull
  List<AppleScriptEveryElemReference> getEveryElemReferenceList();

  @NotNull
  List<AppleScriptEveryRangeReference> getEveryRangeReferenceList();

  @NotNull
  List<AppleScriptFilterReference> getFilterReferenceList();

  @NotNull
  List<AppleScriptHandlerInterleavedParametersCall> getHandlerInterleavedParametersCallList();

  @NotNull
  List<AppleScriptIdReference> getIdReferenceList();

  @NotNull
  List<AppleScriptIndexReference> getIndexReferenceList();

  @NotNull
  List<AppleScriptIndexReferenceClassForm> getIndexReferenceClassFormList();

  @NotNull
  List<AppleScriptMiddleElemReference> getMiddleElemReferenceList();

  @NotNull
  List<AppleScriptNameReference> getNameReferenceList();

  @NotNull
  List<AppleScriptPropertyReference> getPropertyReferenceList();

  @NotNull
  List<AppleScriptRangeFromReference> getRangeFromReferenceList();

  @NotNull
  List<AppleScriptRangeIndexReference> getRangeIndexReferenceList();

  @NotNull
  List<AppleScriptRelativeReference> getRelativeReferenceList();

}
