package com.idea.plugin.applescript.lang.sdef;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface DictionaryRecord extends DictionaryComponent {

  @NotNull
  List<AppleScriptPropertyDefinition> getProperties();

}
