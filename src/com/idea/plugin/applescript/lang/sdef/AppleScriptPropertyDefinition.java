package com.idea.plugin.applescript.lang.sdef;

import org.jetbrains.annotations.NotNull;

public interface AppleScriptPropertyDefinition extends DictionaryComponent {

  @NotNull
  PsiType getPsiType();


}
