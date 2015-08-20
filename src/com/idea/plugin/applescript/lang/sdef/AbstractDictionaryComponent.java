package com.idea.plugin.applescript.lang.sdef;

import com.idea.plugin.applescript.lang.AppleScriptComponentType;
import com.idea.plugin.applescript.lang.sdef.impl.ApplicationDictionary;
import com.idea.plugin.applescript.psi.sdef.impl.DictionaryPsiElementBase;
import com.intellij.psi.xml.XmlTag;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Andrey on 09.07.2015.
 */
public abstract class AbstractDictionaryComponent<P extends DictionaryComponent>
        extends DictionaryPsiElementBase<P, XmlTag> implements DictionaryComponent {

  @NotNull private final String code;
  @NotNull private final String name;
  @Nullable private String description;

  protected AbstractDictionaryComponent(@NotNull P parent, @NotNull String name, @NotNull String code,
                                        @NotNull XmlTag myXmlTag, @Nullable String description) {
    super(myXmlTag, parent);
    this.code = code;
    this.name = name;
    this.description = description;
  }

  protected AbstractDictionaryComponent(@NotNull P parent, @NotNull String name,
                                        @NotNull String code, @NotNull XmlTag myXmlTag) {
    super(myXmlTag, parent);
    this.code = code;
    this.name = name;
  }

  @NotNull
  @Override
  public String getName() {
    return name;
  }

  @NotNull
  @Override
  public List<String> getNameIdentifiers() {
    return Arrays.asList(name.split(" "));
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
    //prefixed with "dictionary " to distinguish from native AppleScript types..
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

  @Nullable
  @Override
  public String getLocationString() {
    return getQualifiedPath();
  }
}
