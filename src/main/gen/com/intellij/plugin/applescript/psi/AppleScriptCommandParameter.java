// This is a generated file. Not intended for manual editing.
package com.intellij.plugin.applescript.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.plugin.applescript.psi.sdef.AppleScriptCommandHandlerParameter;

public interface AppleScriptCommandParameter extends AppleScriptCommandHandlerParameter {

  @NotNull
  AppleScriptCommandParameterSelector getCommandParameterSelector();

  @NotNull
  AppleScriptExpression getExpression();

}
