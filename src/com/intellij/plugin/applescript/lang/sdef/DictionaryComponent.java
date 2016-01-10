package com.intellij.plugin.applescript.lang.sdef;

import com.intellij.plugin.applescript.psi.AppleScriptComponent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Andrey 09.07.2015
 */
public interface DictionaryComponent extends AppleScriptComponent {

  @NotNull
  String getDocumentation();

  @Nullable
  String getCode();

  @Nullable
  String getCocoaClassName();

  @Override
  @NotNull
  String getName();

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
