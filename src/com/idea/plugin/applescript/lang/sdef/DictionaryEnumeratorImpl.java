package com.idea.plugin.applescript.lang.sdef;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DictionaryEnumeratorImpl extends BaseDictionaryComponent implements DictionaryComponent {
  public DictionaryEnumeratorImpl(@NotNull String code, @NotNull String name, @NotNull Suite suite,
                                  @Nullable String description) {
    super(code, name, suite, description);
  }

  public DictionaryEnumeratorImpl(@NotNull String code, @NotNull String name, @NotNull Suite suite) {
    super(code, name, suite);
  }
}
