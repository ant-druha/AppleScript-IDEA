package com.idea.plugin.applescript.lang.sdef;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DictionaryPropertyImpl extends BaseDictionaryComponent implements AppleScriptPropertyDefinition {

  @NotNull private String typeSpecifier;
  @Nullable private AccessType accessType = AccessType.RW;

  public DictionaryPropertyImpl(@NotNull String code, @NotNull String name, @NotNull String typeSpecifier,
                                @NotNull Suite suite, @Nullable String description) {
    super(code, name, suite, description);
    this.typeSpecifier = typeSpecifier;
  }

  protected DictionaryPropertyImpl(@NotNull String code, @NotNull String name, @NotNull String typeSpecifier,
                                   @NotNull Suite suite, @Nullable AccessType accessType) {
    super(code, name, suite);
    this.typeSpecifier = typeSpecifier;
    this.accessType = accessType;

  }

  @NotNull
  @Override
  public PsiType getPsiType() {
    //definition from dictionary by name? is it really needed?
    return null;
  }

}
