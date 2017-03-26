// This is a generated file. Not intended for manual editing.
package com.intellij.plugin.applescript.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AppleScriptListFormalParameter extends AppleScriptPsiElement {

  @NotNull
  List<AppleScriptExpression> getExpressionList();

  @NotNull
  List<AppleScriptListFormalParameter> getListFormalParameterList();

  @NotNull
  List<AppleScriptRecordFormalParameter> getRecordFormalParameterList();

  @NotNull
  List<AppleScriptSimpleFormalParameter> getSimpleFormalParameterList();

  @NotNull
  List<AppleScriptSimpleFormalParameter> getParameters();

}
