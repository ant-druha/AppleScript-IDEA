package com.idea.plugin.applescript.lang.sdef;

import java.util.List;

public interface DictionaryEnumeration extends DictionaryComponent {

  List<DictionaryEnumerator> getEnumerators();

  void setEnumerators(List<DictionaryEnumerator> enumerators);

}
