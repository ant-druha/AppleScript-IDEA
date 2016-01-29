package com.intellij.plugin.applescript.lang.sdef;

import com.intellij.openapi.util.text.StringUtil;
import com.intellij.plugin.applescript.lang.ide.AppleScriptDocHelper;
import com.intellij.psi.xml.XmlTag;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DictionaryClass extends AbstractDictionaryComponent<Suite> implements AppleScriptClass {

  private List<AppleScriptPropertyDefinition> properties = new ArrayList<AppleScriptPropertyDefinition>();
  @Nullable private String parentClassName;
  @NotNull private String pluralClassName;
  //Application classes have attributes, to-one relationships, and to-many relationships. AppleScript classes
  // in the object model have properties and elements—properties are synonymous with attributes and to-one
  // relationships, while elements are synonymous with to-many relationships. For more information on these and
  // related terms, see the Glossary.
  @NotNull private List<AppleScriptClass> elements = new ArrayList<AppleScriptClass>();
  @NotNull private List<AppleScriptCommand> respondingCommands = new ArrayList<AppleScriptCommand>();
  @NotNull private List<String> elementNames;
  @NotNull private List<String> respondingCommandNames;
  private boolean initialized;

  //<!-- CLASSES -->
  //<!ENTITY % class-contents "(contents | element | property | responds-to | synonym | documentation | xref)">
  //<!ELEMENT class ((%implementation;)?, access-group*, type*, (%class-contents;)*)>

  public DictionaryClass(@NotNull Suite suite, @NotNull String name, @NotNull String code,
                         @NotNull XmlTag xmlTagClass, @Nullable String parentClassName,
                         @Nullable List<String> elementNames, @Nullable List<String> respondingCommandNames,
                         @Nullable String pluralClassName) {
    super(suite, name, code, xmlTagClass, null);
    this.parentClassName = parentClassName;
    this.pluralClassName = StringUtil.isEmpty(pluralClassName) ? name + "s" : pluralClassName;
    if (elementNames != null) {
      this.elementNames = elementNames;
    } else {
      this.elementNames = new ArrayList<String>();
    }
    if (respondingCommandNames != null) {
      this.respondingCommandNames = respondingCommandNames;
    } else {
      this.respondingCommandNames = new ArrayList<String>();
    }
  }

  public DictionaryClass(@NotNull Suite suite, @NotNull String name, @NotNull String code,
                         List<AppleScriptPropertyDefinition> properties, @NotNull XmlTag xmlTagClass,
                         String description, @Nullable String parentClassName) {
    super(suite, name, code, xmlTagClass, description);
    this.properties = properties;
    this.parentClassName = parentClassName;
    this.elementNames = new ArrayList<String>();
    this.respondingCommandNames = new ArrayList<String>();
  }

  @Override
  protected String getDocFooter() {
    StringBuilder sb = new StringBuilder();
    AppleScriptDocHelper.appendClassAttributes(sb, this);
    AppleScriptClass parentClass = getParentClass();
    if (parentClass != null) {
      final String indent = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
      sb.append("<p>").append(indent).append("INHERITED FROM ").append(parentClass.getName().toUpperCase()).
              append("</p>");
      AppleScriptDocHelper.appendClassAttributes(sb, parentClass);
    }
    sb.append("</HTML>");
    return sb.toString();
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

  @Nullable
  public String getParentClassName() {
    return parentClassName;
  }

  public AppleScriptClass getParentClass() {
    return getDictionary().findClass(getParentClassName());
  }

  @NotNull
  public List<String> getElementNames() {
    return elementNames;
  }

  @NotNull
  public List<AppleScriptClass> getElements() {
    if (!initialized) {
      initializeElements();
    }
    return elements;
  }

  @NotNull
  public List<AppleScriptCommand> getRespondingCommands() {
    if (!initialized) {
      initializeElements();
    }
    return respondingCommands;
  }

  private void initializeElements() {
      for (String className : elementNames) {
        AppleScriptClass cls = getDictionary().findClass(className);
        if (cls != null) {
          elements.add(cls);
        }
      }
    for (String commandName : respondingCommandNames) {
      AppleScriptCommand cmd = getDictionary().findCommand(commandName);
      if (cmd != null) {
        respondingCommands.add(cmd);
      }
    }
    initialized = true;
  }

  @NotNull
  public String getPluralClassName() {
    return pluralClassName;
  }

  public DictionaryClass setPluralClassName(@NotNull String pluralClassName) {
    if (!StringUtil.isEmpty(pluralClassName)) {
      this.pluralClassName = pluralClassName;
    }
    return this;
  }
}
