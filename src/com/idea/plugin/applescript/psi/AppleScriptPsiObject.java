package com.idea.plugin.applescript.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Created by Andrey on 21.06.2015.
 */
public interface AppleScriptPsiObject extends AppleScriptComponent {

  /**
   * @return list of object properties (@see AppleScriptObjectPropertyDeclaration class)
   */
  @NotNull
  List<PsiElement> getProperties();

  @Nullable
  PsiElement getProperty(@NotNull String name);
}
