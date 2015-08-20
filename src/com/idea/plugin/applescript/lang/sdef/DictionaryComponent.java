package com.idea.plugin.applescript.lang.sdef;

import com.idea.plugin.applescript.lang.sdef.impl.ApplicationDictionary;
import com.idea.plugin.applescript.psi.AppleScriptPsiElement;
import com.intellij.psi.PsiNamedElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Created by Andrey on 09.07.2015.
 */
public interface DictionaryComponent extends AppleScriptPsiElement, PsiNamedElement {

  @Nullable
  String getCode();

  @Nullable
  String getCocoaClassName();

  @Override
  @NotNull
  String getName(); //in terms of psi in xml file - this is com.intellij.psi.impl.source.xml.XmlTokenImpl class (
  // for navigation..) is it better to use Dom then?

  /**
   * @return list of psi elements which are identifiers for components names consisted of several words
   */
  @NotNull
  List<String> getNameIdentifiers();

  @NotNull
  String getQualifiedPath();

  /**
   * Name, starting with suite code name and including component code.
   * Note: not necessarily unique (could be 2 commands with the same code in the suite)
   *
   * @return name string
   */
  @NotNull
  String getQualifiedName();

  @Nullable
  String getDescription();

  @Nullable
  Suite getSuite();

  @Nullable
  DictionaryComponent getDictionaryParentComponent();

  @NotNull
  String getType();

  void setDescription(String description);

  @NotNull
  ApplicationDictionary getDictionary();

}
