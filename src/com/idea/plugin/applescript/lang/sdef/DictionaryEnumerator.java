package com.idea.plugin.applescript.lang.sdef;

import org.jetbrains.annotations.NotNull;

/**
 * Andrey 17.08.2015
 */
public interface DictionaryEnumerator extends DictionaryComponent {

  @NotNull
  DictionaryEnumeration getMyEnumeration();
}
