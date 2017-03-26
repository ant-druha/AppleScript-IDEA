// This is a generated file. Not intended for manual editing.
package com.intellij.plugin.applescript.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.plugin.applescript.psi.sdef.ApplicationDictionaryDeclarator;

public interface AppleScriptUseStatement extends ApplicationDictionaryDeclarator {

  @Nullable
  AppleScriptDirectParameterDeclaration getDirectParameterDeclaration();

  @NotNull
  List<AppleScriptExpression> getExpressionList();

  @Nullable
  String getApplicationName();

  boolean useStandardAdditions();

  boolean withImporting();

}
