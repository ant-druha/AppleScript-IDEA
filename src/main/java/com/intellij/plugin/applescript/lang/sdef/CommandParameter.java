package com.intellij.plugin.applescript.lang.sdef;

import org.jetbrains.annotations.NotNull;

/**
 * Andrey 09.07.2015
 */
public interface CommandParameter extends DictionaryComponent {

  boolean isOptional();

  @NotNull
  String getTypeSpecifier();

  @NotNull
  AppleScriptCommand getMyCommand();
}
