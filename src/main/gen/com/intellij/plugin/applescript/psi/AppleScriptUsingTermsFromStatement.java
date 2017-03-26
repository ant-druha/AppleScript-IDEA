// This is a generated file. Not intended for manual editing.
package com.intellij.plugin.applescript.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.plugin.applescript.psi.sdef.ApplicationDictionaryDeclarator;

public interface AppleScriptUsingTermsFromStatement extends ApplicationDictionaryDeclarator {

  @Nullable
  AppleScriptApplicationReference getApplicationReference();

  @Nullable
  AppleScriptExpression getExpression();

  @Nullable
  AppleScriptTopBlockBody getTopBlockBody();

  @Nullable
  String getApplicationName();

  boolean withImportingStdLibrary();

}
