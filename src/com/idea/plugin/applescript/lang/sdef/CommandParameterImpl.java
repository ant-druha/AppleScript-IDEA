package com.idea.plugin.applescript.lang.sdef;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by Andrey on 03.07.2015.
 */
public class CommandParameterImpl extends AbstractDictionaryComponent<AppleScriptCommand> implements CommandParameter {
  @NotNull private String typeSpecifier;
  private boolean optional;

  public CommandParameterImpl(@NotNull AppleScriptCommand myCommand, @NotNull String name, @NotNull String code,
                              boolean optional, @NotNull String typeSpecifier,

                              @Nullable String description) {
    super(myCommand, name, code, description);
    this.typeSpecifier = typeSpecifier;
    this.optional = optional;
  }

  public CommandParameterImpl(@NotNull AppleScriptCommand myCommand, @NotNull String name, @NotNull String code,
                              @NotNull String typeSpecifier) {
    this(myCommand, name, code, false, typeSpecifier, null);
  }


  @NotNull
  public String getTypeSpecifier() {
    return typeSpecifier;
  }

  @NotNull
  @Override
  public AppleScriptCommand getMyCommand() {
    return myParent;
  }

  public boolean isOptional() {
    return optional;
  }


  @NotNull
  @Override
  public Suite getSuite() {
    return getMyCommand().getSuite();
  }
}
