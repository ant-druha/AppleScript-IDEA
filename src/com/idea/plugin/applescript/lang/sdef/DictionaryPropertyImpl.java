package com.idea.plugin.applescript.lang.sdef;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DictionaryPropertyImpl extends AbstractDictionaryComponent<DictionaryComponent> implements
        AppleScriptPropertyDefinition {

  @NotNull private String typeSpecifier;
  @Nullable private AccessType accessType = AccessType.RW;

  public DictionaryPropertyImpl(@NotNull DictionaryComponent classOrRecord, @NotNull String name, @NotNull String
          code, @NotNull String typeSpecifier,

                                @Nullable String description) {
    super(classOrRecord, name, code, description);
    this.typeSpecifier = typeSpecifier;
  }

  protected DictionaryPropertyImpl(@NotNull DictionaryComponent classOrRecord, @NotNull String name,
                                   @NotNull String code, @NotNull String typeSpecifier,
                                   @Nullable AccessType accessType) {
    super(classOrRecord, name, code);
    this.typeSpecifier = typeSpecifier;
    this.accessType = accessType;

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
    return getDictionaryParentComponent().getSuite();
  }
}
