// This is a generated file. Not intended for manual editing.
package com.idea.plugin.applescript.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AppleScriptFormalParameterList extends AppleScriptPsiElement {

  @NotNull
  List<AppleScriptTargetListLiteral> getTargetListLiteralList();

  @NotNull
  List<AppleScriptTargetRecordLiteral> getTargetRecordLiteralList();

  @NotNull
  List<AppleScriptTargetVariable> getTargetVariableList();

  @NotNull
  List<AppleScriptComponentName> getTargetVariableListRecursive();

}
