package com.idea.plugin.applescript.lang.sdef;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class DictionaryClass extends BaseDictionaryComponent implements AppleScriptClass {

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

  public DictionaryClass(@NotNull String code, @NotNull String name, @NotNull Suite suite) {
    super(code, name, suite, null);
  }

  public DictionaryClass(@NotNull String code, @NotNull String name, String description, @NotNull Suite suite,
                         List<AppleScriptPropertyDefinition> properties) {
    super(code, name, suite, description);
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
}
