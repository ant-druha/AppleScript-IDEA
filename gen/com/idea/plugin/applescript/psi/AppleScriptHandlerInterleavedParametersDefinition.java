// This is a generated file. Not intended for manual editing.
package com.idea.plugin.applescript.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AppleScriptHandlerInterleavedParametersDefinition extends AppleScriptPsiElement {

  @Nullable
  AppleScriptBlockBody getBlockBody();

  @NotNull
  List<AppleScriptComponentName> getComponentNameList();

  @NotNull
  List<AppleScriptHandlerNamePartDefinition> getHandlerNamePartDefinitionList();

}
