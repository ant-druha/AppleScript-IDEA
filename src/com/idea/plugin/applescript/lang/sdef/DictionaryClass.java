package com.idea.plugin.applescript.lang.sdef;

import com.intellij.psi.xml.XmlTag;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class DictionaryClass extends AbstractDictionaryComponent<Suite> implements AppleScriptClass {

  private List<AppleScriptPropertyDefinition> properties = new ArrayList<AppleScriptPropertyDefinition>();
  //Application classes have attributes, to-one relationships, and to-many relationships. AppleScript classes
  // in the object model have properties and elements—properties are synonymous with attributes and to-one
  // relationships, while elements are synonymous with to-many relationships. For more information on these and
  // related terms, see the Glossary.
  private List<DictionaryClass> elements = new ArrayList<DictionaryClass>();

  private String suiteName;
  private String dictionaryName;

  //<!-- CLASSES -->
  //<!ENTITY % class-contents "(contents | element | property | responds-to | synonym | documentation | xref)">
  //<!ELEMENT class ((%implementation;)?, access-group*, type*, (%class-contents;)*)>

  public DictionaryClass(@NotNull Suite suite, @NotNull String name, @NotNull String code,
                         @NotNull XmlTag xmlTagClass) {
    super(suite, name, code, xmlTagClass, null);
  }

  public DictionaryClass(@NotNull Suite suite, @NotNull String name, @NotNull String code,
                         List<AppleScriptPropertyDefinition> properties,
                         @NotNull XmlTag xmlTagClass, String description) {
    super(suite, name, code, xmlTagClass, description);
    this.properties = properties;
  }

  @NotNull
  @Override
  public List<AppleScriptClass> getContents() {
    return null;
  }

  @NotNull
  @Override
  public List<AppleScriptPropertyDefinition> getProperties() {
    return properties;
  }

  public void setProperties(List<AppleScriptPropertyDefinition> properties) {
    this.properties = properties;
  }

  @NotNull
  @Override
  public Suite getSuite() {
    return myParent;
  }
}
