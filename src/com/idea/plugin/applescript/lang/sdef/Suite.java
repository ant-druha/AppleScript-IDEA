package com.idea.plugin.applescript.lang.sdef;

import org.jetbrains.annotations.Nullable;

/**
 * Andrey 16.08.2015
 */
public interface Suite extends DictionaryComponent {

  boolean addClass(AppleScriptClass appleScriptClass);

  @Nullable
  AppleScriptClass getClassByName(String name);

  @Nullable
  AppleScriptClass findClassByCode(String code);

  boolean addProperty(AppleScriptPropertyDefinition property);

  boolean addEnumeration(DictionaryEnumeration enumeration);

  void addRecord(DictionaryRecord record);

  boolean addCommand(AppleScriptCommand command);

  boolean isHidden();
}
