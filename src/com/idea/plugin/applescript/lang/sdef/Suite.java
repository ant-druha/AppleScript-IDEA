package com.idea.plugin.applescript.lang.sdef;

import com.intellij.psi.PsiElement;
import com.intellij.psi.impl.FakePsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Suite extends FakePsiElement implements DictionaryComponent {

  @NotNull ApplicationDictionary dictionary;
  @NotNull private final String code;
  @NotNull private final String name;
  @Nullable private String description;
  private boolean hidden;
  private List<AppleScriptCommand> commandDefinitions = new ArrayList<AppleScriptCommand>();
  private List<DictionaryClass> classDefinitions = new ArrayList<DictionaryClass>();
  //(class | class-extension | command | enumeration | event | record-type | value-type | documentation)+

  public Suite(@NotNull String code, @NotNull String name, @NotNull ApplicationDictionary dictionary) {
    this.code = code;
    this.name = name;
    this.dictionary = dictionary;
  }

  public Suite(@NotNull String code, @NotNull String name, boolean hidden, @Nullable String description, @NotNull
  ApplicationDictionary dictionary) {
    this.code = code;
    this.name = name;
    this.description = description;
    this.hidden = hidden;
    this.dictionary = dictionary;
  }

  public boolean isHidden() {
    return hidden;
  }

  @NotNull
  @Override
  public String getCode() {
    return code;
  }

  @Nullable
  @Override
  public String getCocoaClassName() {
    return null;
  }

  @Nullable
  @Override
  public String getDescription() {
    return description;
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

  @Override
  public PsiElement getParent() {
    return dictionary;
  }

  @NotNull
  public ApplicationDictionary getDictionary() {
    return (ApplicationDictionary) getParent();
  }

  @NotNull
  @Override
  public String getName() {
    return name;
  }

  @NotNull
  @Override
  public String getQualifiedPath() {
    return "dictionary:" + getDictionary().getName() + "/" + getQualifiedName();
  }

  @NotNull
  @Override
  public String getQualifiedName() {
    return getType().substring(11) + ":" + getCode();
  }
}
