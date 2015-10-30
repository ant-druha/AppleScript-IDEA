package com.idea.plugin.applescript.lang.sdef;

import com.idea.plugin.applescript.lang.ide.AppleScriptDocHelper;
import com.intellij.openapi.util.text.StringUtil;
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
  @NotNull private List<String> elementNames = new ArrayList<String>();
  private boolean initialized;

  //<!-- CLASSES -->
  //<!ENTITY % class-contents "(contents | element | property | responds-to | synonym | documentation | xref)">
  //<!ELEMENT class ((%implementation;)?, access-group*, type*, (%class-contents;)*)>

  public DictionaryClass(@NotNull Suite suite, @NotNull String name, @NotNull String code,
                         @NotNull XmlTag xmlTagClass, @Nullable String parentClassName, @Nullable List<String>
                                 elementNames,
                         String pluralClassName) {
    super(suite, name, code, xmlTagClass, null);
    this.parentClassName = parentClassName;
    this.pluralClassName = StringUtil.isEmpty(pluralClassName) ? name + "s" : pluralClassName;
    if (elementNames != null) {
      this.elementNames = elementNames;
    }
  }

  public DictionaryClass(@NotNull Suite suite, @NotNull String name, @NotNull String code,
                         List<AppleScriptPropertyDefinition> properties, @NotNull XmlTag xmlTagClass,
                         String description, @Nullable String parentClassName) {
    super(suite, name, code, xmlTagClass, description);
    this.properties = properties;
    this.parentClassName = parentClassName;
  }

  @NotNull
  @Override
  public String getDocumentation() {
    StringBuilder sb = new StringBuilder();
    sb.append("<HTML>");
    final String indent = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    //todo repeating super =(
    sb.append(super.getDocumentation());
    AppleScriptDocHelper.appendClassAttributes(sb, this);
    AppleScriptClass parentClass = getParentClass();
    if (parentClass != null) {
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
    if (!initialized && !elementNames.isEmpty()) {
      for (String className : elementNames) {
        AppleScriptClass cls = getDictionary().findClass(className);
        if (cls != null) {
          elements.add(cls);
        }
      }
      initialized = true;
    }
    return elements;
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
