package com.idea.plugin.applescript.lang.sdef;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DictionaryEnumeratorImpl extends AbstractDictionaryComponent<DictionaryEnumeration> implements
        DictionaryEnumerator {
  public DictionaryEnumeratorImpl(@NotNull DictionaryEnumeration myEnumeration, @NotNull String name,
                                  @NotNull String code, @Nullable String description) {
    super(myEnumeration, name, code, description);
  }

  public DictionaryEnumeratorImpl(@NotNull DictionaryEnumeration myEnumeration, @NotNull String name,
                                  @NotNull String code) {
    super(myEnumeration, name, code);
  }

  @NotNull
  @Override
  public Suite getSuite() {
    return getMyEnumeration().getSuite();
  }

  @NotNull
  @Override
  public DictionaryEnumeration getMyEnumeration() {
    return myParent;
  }
}
