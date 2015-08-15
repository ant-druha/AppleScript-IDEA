package com.idea.plugin.applescript.lang.sdef;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by Andrey on 03.07.2015.
 */
public class CommandDirectParameter {
  @NotNull
  private String typeSpecifier;
  @Nullable
  private String description;
  private boolean optional;

  public CommandDirectParameter(@NotNull String typeSpecifier, @Nullable String description, boolean optional) {
    this.typeSpecifier = typeSpecifier;
    this.description = description;
    this.optional = optional;
  }

  public CommandDirectParameter(@NotNull String typeSpecifier, @Nullable String description) {
    this(typeSpecifier, description, false);
  }

  @NotNull
  public String getTypeSpecifier() {
    return typeSpecifier;
  }

  public boolean isOptional() {
    return optional;
  }
}
