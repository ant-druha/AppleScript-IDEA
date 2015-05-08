// This is a generated file. Not intended for manual editing.
package com.idea.plugin.applescript.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AppleScriptTryStatement extends AppleScriptPsiElement {

  @NotNull
  List<AppleScriptBlockBody> getBlockBodyList();

  @NotNull
  List<AppleScriptComponentName> getComponentNameList();

  @NotNull
  List<AppleScriptReferenceIdentifier> getReferenceIdentifierList();

}
