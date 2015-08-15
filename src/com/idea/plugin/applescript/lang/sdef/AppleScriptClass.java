package com.idea.plugin.applescript.lang.sdef;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface AppleScriptClass extends DictionaryComponent {
  //<!-- CLASSES -->
  //<!ENTITY % class-contents "(contents | element | property | responds-to | synonym | documentation | xref)">
  //<!ELEMENT class ((%implementation;)?, access-group*, type*, (%class-contents;)*)>
  @NotNull
  List<AppleScriptClass> getContents();

  @NotNull
  List<AppleScriptPropertyDefinition> getProperties();
}
