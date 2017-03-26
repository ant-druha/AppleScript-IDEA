package com.intellij.plugin.applescript.lang.sdef;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface DictionaryEnumeration extends DictionaryComponent {

  List<DictionaryEnumerator> getEnumerators();

  void setEnumerators(List<DictionaryEnumerator> enumerators);

  @NotNull
  @Override
  Suite getSuite();
}
