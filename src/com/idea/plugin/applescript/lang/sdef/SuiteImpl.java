package com.idea.plugin.applescript.lang.sdef;

import com.idea.plugin.applescript.lang.sdef.impl.ApplicationDictionary;
import com.intellij.psi.xml.XmlTag;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SuiteImpl extends AbstractDictionaryComponent<ApplicationDictionary> implements Suite {

  private boolean hidden;
  private List<AppleScriptCommand> commandDefinitions = new ArrayList<AppleScriptCommand>();
  private List<DictionaryClass> classDefinitions = new ArrayList<DictionaryClass>();
  //(class | class-extension | command | enumeration | event | record-type | value-type | documentation)+

  public SuiteImpl(@NotNull String code, @NotNull String name, @NotNull ApplicationDictionary dictionary,
                   @NotNull XmlTag xmlTagSuite) {
    super(dictionary, name, code, xmlTagSuite);
  }

  public SuiteImpl(@NotNull ApplicationDictionary dictionary, @NotNull String code, @NotNull String name,
                   boolean hidden, @Nullable String description, @NotNull XmlTag xmlTagSuite) {
    super(dictionary, name, code, xmlTagSuite, description);
    this.hidden = hidden;
  }

  public boolean isHidden() {
    return hidden;
  }

  @NotNull
  @Override
  public Suite getSuite() {
    return this;
  }

  @NotNull
  @Override
  public String getType() {
    return "dictionary suite";
  }

  @NotNull
  public ApplicationDictionary getDictionary() {
    return myParent;
  }

  @NotNull
  @Override
  public String getQualifiedPath() {
    return getDictionary().getQualifiedPath() + "/" + getQualifiedName();
  }

  @NotNull
  @Override
  public String getQualifiedName() {
    return getType().substring(11) + ":" + getCode();
  }

  @Override
  public boolean addCommand(AppleScriptCommand command) {
    return command != null && commandDefinitions.add(command);
  }
}
