package com.intellij.plugin.applescript.lang.sdef;

import com.intellij.psi.xml.XmlTag;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DictionaryEnumerationImpl extends AbstractDictionaryComponent<Suite> implements DictionaryEnumeration {

  List<DictionaryEnumerator> enumerators = new ArrayList<>();

  public DictionaryEnumerationImpl(@NotNull Suite suite, @NotNull String name, @NotNull String code,
                                   List<DictionaryEnumerator> enumerators, @Nullable String description,
                                   @NotNull XmlTag XmlTagEnumeration) {
    super(suite, name, code, XmlTagEnumeration, description);
    this.enumerators = enumerators;
  }

  public DictionaryEnumerationImpl(@NotNull Suite suite, @NotNull String name, @NotNull String code,
                                   @Nullable String description, @NotNull XmlTag XmlTagEnumeration) {
    super(suite, name, code, XmlTagEnumeration, description);
  }

  public DictionaryEnumerationImpl(@NotNull Suite suite, @NotNull String name, @NotNull String code,
                                   List<DictionaryEnumerator> enumerators, @NotNull XmlTag XmlTagEnumeration) {
    this(suite, name, code, enumerators, null, XmlTagEnumeration);
  }

  @Override
  public List<DictionaryEnumerator> getEnumerators() {
    return enumerators;
  }

  public void setEnumerators(List<DictionaryEnumerator> enumerators) {
    this.enumerators = enumerators;
  }

  @NotNull
  @Override
  public Suite getSuite() {
    return myParent;
  }
}
