package com.idea.plugin.applescript.lang.sdef;

import com.idea.plugin.applescript.lang.AppleScriptComponentType;
import com.idea.plugin.applescript.lang.sdef.impl.ApplicationDictionary;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiManager;
import com.intellij.psi.impl.FakePsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by Andrey on 09.07.2015.
 */
public abstract class AbstractDictionaryComponent<P extends DictionaryComponent> extends FakePsiElement implements
        DictionaryComponent {

  @NotNull private final String code;
  @NotNull private final String name;
  @NotNull protected final P myParent;
  @Nullable private String description;

  protected AbstractDictionaryComponent(@NotNull P parent, @NotNull String name, @NotNull String code,
                                        @Nullable String description) {
    this.code = code;
    this.name = name;
    this.myParent = parent;
    this.description = description;
  }

  protected AbstractDictionaryComponent(@NotNull P parent, @NotNull String name, @NotNull String code) {
    this.code = code;
    this.name = name;
    this.myParent = parent;
  }

  @NotNull
  @Override
  public String getName() {
    return name;
  }

  @NotNull
  @Override
  public String getQualifiedName() {
    return getDictionaryParentComponent().getQualifiedName() + "/" + getShortQname();
  }

  @NotNull
  private String getShortQname() {
    return getType().substring(11) + ":" + getCode();
  }

  @NotNull
  @Override
  public String getQualifiedPath() {
    return getDictionaryParentComponent().getQualifiedPath() + "/" + getShortQname();
  }

  @NotNull
  @Override
  public String getType() {
    //prefixed with "dictionary " to distinguish from native AppleScript typres..
    AppleScriptComponentType componentType = AppleScriptComponentType.typeOf(this);
    return componentType != null ? componentType.toString().toLowerCase() : "dictionary reference";
  }

  @Override
  public void setDescription(@Nullable String description) {
    this.description = description;
  }

  @NotNull
  @Override
  public ApplicationDictionary getDictionary() {
    return getSuite().getDictionary();
  }

  @NotNull
  @Override
  public Project getProject() {
    return getDictionaryParentComponent().getProject();
  }

  @Override
  public PsiElement getParent() {
    return getDictionaryParentComponent();
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
  public abstract Suite getSuite();

  @NotNull
  @Override
  public P getDictionaryParentComponent() {
    return myParent;
  }

  @Override
  public PsiManager getManager() {
    return super.getManager();
//    return PsiManager.getInstance(getProject());
  }
}
