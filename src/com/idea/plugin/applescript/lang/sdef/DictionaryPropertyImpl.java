package com.idea.plugin.applescript.lang.sdef;

import com.intellij.psi.xml.XmlTag;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DictionaryPropertyImpl extends AbstractDictionaryComponent<DictionaryComponent> implements
        AppleScriptPropertyDefinition {

  @NotNull private String typeSpecifier;
  @Nullable private AccessType accessType = AccessType.RW;

  public DictionaryPropertyImpl(@NotNull DictionaryComponent classOrRecord, @NotNull String name,
                                @NotNull String code, @NotNull String typeSpecifier,
                                @Nullable String description, @NotNull XmlTag XmlTagProperty) {
    super(classOrRecord, name, code, XmlTagProperty, description);
    this.typeSpecifier = typeSpecifier;
    assert (myParent instanceof AppleScriptClass || myParent instanceof DictionaryRecord);
  }

  protected DictionaryPropertyImpl(@NotNull DictionaryComponent classOrRecord, @NotNull String name,
                                   @NotNull String code, @NotNull String typeSpecifier,
                                   @Nullable AccessType accessType, @NotNull XmlTag XmlTagProperty) {
    super(classOrRecord, name, code, XmlTagProperty);
    this.typeSpecifier = typeSpecifier;
    this.accessType = accessType;
    assert (myParent instanceof AppleScriptClass || myParent instanceof DictionaryRecord);
  }

  @NotNull
  @Override
  public PsiType getPsiType() {
    //definition from dictionary by name? is it really needed?
    return null;
  }

  @Override
  public boolean isClassProperty() {
    return myParent instanceof AppleScriptClass;
  }

  @Override
  public boolean isRecordProperty() {
    return myParent instanceof DictionaryRecord;
  }

  @Nullable
  @Override
  public AppleScriptClass getMyClass() {
    return isClassProperty() ? (AppleScriptClass) myParent : null;
  }

  @Nullable
  @Override
  public DictionaryRecord getMyRecord() {
    return isRecordProperty() ? (DictionaryRecord) myParent : null;
  }

  @NotNull
  @Override
  public Suite getSuite() {
    return isClassProperty()? getDictionaryParentComponent().getSuite() :
            getDictionaryParentComponent().getSuite();//not safe cast...
  }
}
