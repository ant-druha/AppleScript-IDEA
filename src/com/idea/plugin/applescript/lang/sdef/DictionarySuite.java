package com.idea.plugin.applescript.lang.sdef;

import org.jetbrains.annotations.Nullable;

public interface DictionarySuite extends DictionaryComponent {
  boolean addCommand(AppleScriptCommand command);

  boolean addClass(AppleScriptClass appleScriptClass);

  @Nullable
  AppleScriptClass findClassByName(String name);

  @Nullable
  AppleScriptClass findClassByCode(String code);

  boolean addProperty(AppleScriptPropertyDefinition property);

  boolean addEnumeration(DictionaryEnumeration enumeration);

  void addRecord(DictionaryRecord record);
}
