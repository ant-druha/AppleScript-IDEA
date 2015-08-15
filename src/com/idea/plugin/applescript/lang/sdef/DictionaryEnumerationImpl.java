package com.idea.plugin.applescript.lang.sdef;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DictionaryEnumerationImpl extends BaseDictionaryComponent implements DictionaryEnumeration {

  List<DictionaryEnumeratorImpl> enumerators = new ArrayList<DictionaryEnumeratorImpl>();

  public DictionaryEnumerationImpl(@NotNull String code, @NotNull String name, @NotNull Suite suite,
                                   @Nullable String description, List<DictionaryEnumeratorImpl> enumerators) {
    super(code, name, suite, description);
    this.enumerators = enumerators;
  }

  public DictionaryEnumerationImpl(@NotNull String code, @NotNull String name, @NotNull Suite suite,
                                   List<DictionaryEnumeratorImpl> enumerators) {
    this(code, name, suite, null, enumerators);
  }

  @Override
  public List<DictionaryEnumeratorImpl> getEnumerators() {
    return enumerators;
  }
}
