package com.intellij.plugin.applescript.psi.sdef;

import com.intellij.plugin.applescript.psi.AppleScriptPsiElement;
import com.intellij.psi.PsiElement;

import java.util.List;

/**
 * Andrey 22.08.2015
 */
public interface DictionaryCompositeName extends AppleScriptPsiElement {

  List<PsiElement> getIdentifiers();

  String getCompositeName();

}
