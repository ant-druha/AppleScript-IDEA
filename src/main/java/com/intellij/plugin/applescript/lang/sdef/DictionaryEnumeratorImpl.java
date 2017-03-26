package com.intellij.plugin.applescript.lang.sdef;

import com.intellij.psi.xml.XmlTag;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DictionaryEnumeratorImpl extends AbstractDictionaryComponent<DictionaryEnumeration> implements
        DictionaryEnumerator {
  public DictionaryEnumeratorImpl(@NotNull DictionaryEnumeration myEnumeration, @NotNull String name,
                                  @NotNull String code, @Nullable String description, @NotNull XmlTag
                                          XmlTagEnumerator) {
    super(myEnumeration, name, code, XmlTagEnumerator, description);
  }

  public DictionaryEnumeratorImpl(@NotNull DictionaryEnumeration myEnumeration, @NotNull String name,
                                  @NotNull String code, @NotNull XmlTag XmlTagEnumerator) {
    super(myEnumeration, name, code, XmlTagEnumerator);
  }

  @NotNull
  @Override
  public Suite getSuite() {
    return getMyEnumeration().getSuite();
  }

  @NotNull
  @Override
  public DictionaryEnumeration getMyEnumeration() {
    return myParent;
  }
}
