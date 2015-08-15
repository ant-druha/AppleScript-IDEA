package com.idea.plugin.applescript.lang.sdef;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nullable;

/**
 * Created by Andrey on 02.07.2015.
 */
public class AppleScriptClassType extends PsiType {

  public AppleScriptClassType() {
    super("class");
  }

  @Nullable
  PsiElement resolve() {
    return null;
  }

}
