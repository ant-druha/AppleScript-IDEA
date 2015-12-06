package com.idea.plugin.applescript.lang.sdef;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Andrey 03.07.2015
 */
public class CommandDirectParameter {
  @NotNull
  private String typeSpecifier;
  @Nullable
  private String description;
  private boolean optional;
  @NotNull AppleScriptCommand myCommand;

  public CommandDirectParameter(@NotNull AppleScriptCommand myCommand, @NotNull String typeSpecifier,
                                @Nullable String description, boolean optional) {
    this.myCommand = myCommand;
    this.typeSpecifier = typeSpecifier;
    this.description = description;
    this.optional = optional;
  }

  public CommandDirectParameter(@NotNull AppleScriptCommand myCommand, @NotNull String typeSpecifier,
                                @Nullable String description) {
    this(myCommand, typeSpecifier, description, false);
  }

  @NotNull
  public String getTypeSpecifier() {
    return typeSpecifier;
  }

  public boolean isOptional() {
    return optional;
  }

  @Nullable
  public String getDescription() {
    return description;
  }

  @NotNull
  public AppleScriptCommand getCommand() {
    return myCommand;
  }


}
