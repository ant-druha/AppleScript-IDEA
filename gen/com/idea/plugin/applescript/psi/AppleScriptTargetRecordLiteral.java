// This is a generated file. Not intended for manual editing.
package com.idea.plugin.applescript.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AppleScriptTargetRecordLiteral extends AppleScriptPsiElement {

  @NotNull
  List<AppleScriptBuiltInClassName> getBuiltInClassNameList();

  @NotNull
  List<AppleScriptComponentName> getComponentNameList();

  @NotNull
  List<AppleScriptTargetComponentName> getTargetComponentNameList();

  @NotNull
  List<AppleScriptTargetListLiteral> getTargetListLiteralList();

  @NotNull
  List<AppleScriptTargetRecordLiteral> getTargetRecordLiteralList();

}
