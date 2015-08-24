package com.idea.plugin.applescript.lang.sdef;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface AppleScriptPropertyDefinition extends DictionaryComponent {

  @NotNull
  PsiType getPsiType();

  //could be either class or record property
  boolean isClassProperty();

  boolean isRecordProperty();

  @Nullable
  AppleScriptClass getMyClass();

  @Nullable
  DictionaryRecord getMyRecord();

  void setAccessType(AccessType accessType);

  @Nullable
  AccessType getAccessType();

  @NotNull
  String getTypeSpecifier();

}
