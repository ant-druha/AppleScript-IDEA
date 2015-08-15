package com.idea.plugin.applescript.lang.sdef;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by Andrey on 03.07.2015.
 */
public class CommandParameterImpl extends BaseDictionaryComponent implements CommandParameter {
  @NotNull private String typeSpecifier;
  private boolean optional;

  public CommandParameterImpl(@NotNull String name, @NotNull String typeSpecifier, @NotNull String code,
                              @NotNull Suite suite, @Nullable String description, boolean optional) {
    super(code, name, suite, description);
    this.typeSpecifier = typeSpecifier;
    this.optional = optional;
  }

  public CommandParameterImpl(@NotNull String name, @NotNull String typeSpecifier, @NotNull String code,
                              @NotNull Suite suite) {
    this(name, typeSpecifier, code, suite, null, false);
  }


  @NotNull
  public String getTypeSpecifier() {
    return typeSpecifier;
  }

  public boolean isOptional() {
    return optional;
  }


}
