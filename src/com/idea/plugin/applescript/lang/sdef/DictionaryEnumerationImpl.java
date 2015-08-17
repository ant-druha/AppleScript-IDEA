package com.idea.plugin.applescript.lang.sdef;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DictionaryEnumerationImpl extends AbstractDictionaryComponent<Suite> implements DictionaryEnumeration {

  List<DictionaryEnumerator> enumerators = new ArrayList<DictionaryEnumerator>();

  public DictionaryEnumerationImpl(@NotNull Suite suite, @NotNull String name, @NotNull String code,
                                   List<DictionaryEnumerator> enumerators, @Nullable String description) {
    super(suite, name, code, description);
    this.enumerators = enumerators;
  }

  public DictionaryEnumerationImpl(@NotNull Suite suite, @NotNull String name, @NotNull String code,
                                   @Nullable String description) {
    super(suite, name, code, description);
  }

  public DictionaryEnumerationImpl(@NotNull Suite suite, @NotNull String name, @NotNull String code,
                                   List<DictionaryEnumerator> enumerators) {
    this(suite, name, code, enumerators, null);
  }

  @Override
  public List<DictionaryEnumerator> getEnumerators() {
    return enumerators;
  }

  public void setEnumerators(List<DictionaryEnumerator> enumerators) {
    this.enumerators = enumerators;
  }

  @NotNull
  @Override
  public Suite getSuite() {
    return myParent;
  }
}
