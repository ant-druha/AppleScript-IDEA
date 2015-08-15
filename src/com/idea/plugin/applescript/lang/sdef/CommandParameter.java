package com.idea.plugin.applescript.lang.sdef;

import org.jetbrains.annotations.NotNull;

/**
 * Created by Andrey on 09.07.2015.
 */
public interface CommandParameter extends DictionaryComponent {

  boolean isOptional();

  @NotNull
  String getTypeSpecifier();
}
