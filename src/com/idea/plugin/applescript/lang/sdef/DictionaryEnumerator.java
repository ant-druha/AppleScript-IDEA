package com.idea.plugin.applescript.lang.sdef;

import org.jetbrains.annotations.NotNull;

/**
 * Created by Andrey on 17.08.2015.
 */
public interface DictionaryEnumerator extends DictionaryComponent {

  @NotNull
  DictionaryEnumeration getMyEnumeration();
}
