package com.idea.plugin.applescript.lang.sdef;

import com.idea.plugin.applescript.lang.AppleScriptComponentType;
import com.intellij.psi.PsiElement;
import com.intellij.psi.impl.FakePsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by Andrey on 09.07.2015.
 */
public abstract class BaseDictionaryComponent extends FakePsiElement implements DictionaryComponent {

  @NotNull private final String code;
  @NotNull private final String name;
  @NotNull private final Suite suite;
  @Nullable private String description;

  protected BaseDictionaryComponent(@NotNull String code, @NotNull String name, @NotNull Suite suite, @Nullable
  String description) {
    this.code = code;
    this.name = name;
    this.suite = suite;
    this.description = description;
  }

  protected BaseDictionaryComponent(@NotNull String code, @NotNull String name, @NotNull Suite suite) {
    this.code = code;
    this.name = name;
    this.suite = suite;
  }

  @NotNull
  @Override
  public String getName() {
    return name;
  }

  @NotNull
  @Override
  public String getQualifiedName() {
    return getSuite().getQualifiedName() + "/" + getType().substring(11) + ":" + getCode();
  }

  @NotNull
  @Override
  public String getQualifiedPath() {
    return getSuite().getQualifiedPath() + "/" + getType().substring(11) + ":" + getCode();
  }

  @NotNull
  @Override
  public String getType() {
    AppleScriptComponentType componentType = AppleScriptComponentType.typeOf(this);
    return componentType != null ? componentType.toString().toLowerCase() : "dictionary reference";
  }

  @Override
  public PsiElement getParent() {
    return null;
  }

  @Nullable
  @Override
  public String getCocoaClassName() {
    return null;
  }

  @NotNull
  @Override
  public String getCode() {
    return code;
  }

  @Nullable
  public String getDescription() {
    return description;
  }

  @NotNull
  @Override
  public Suite getSuite() {
    return suite;
  }
}
