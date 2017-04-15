package com.intellij.plugin.applescript.lang.sdef;

import com.intellij.psi.xml.XmlTag;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Andrey 03.07.2015
 */
public class CommandParameterImpl extends AbstractDictionaryComponent<AppleScriptCommand> implements CommandParameter {
  @NotNull
  private String typeSpecifier;
  private boolean optional;

  public CommandParameterImpl(@NotNull AppleScriptCommand myCommand, @NotNull String name, @NotNull String code,
                              boolean optional, @NotNull String typeSpecifier,
                              @Nullable String description, @NotNull XmlTag xmlTagParameter) {
    super(myCommand, name, code, xmlTagParameter, description);
    this.typeSpecifier = typeSpecifier;
    this.optional = optional;
  }

  public CommandParameterImpl(@NotNull AppleScriptCommand myCommand, @NotNull String name, @NotNull String code,
                              @NotNull String typeSpecifier, @NotNull XmlTag xmlTagParameter) {
    super(myCommand, name, code, xmlTagParameter);
    this.typeSpecifier = typeSpecifier;
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
