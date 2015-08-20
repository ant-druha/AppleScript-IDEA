package com.idea.plugin.applescript.lang.sdef;

import com.intellij.psi.xml.XmlTag;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class DictionaryRecordDefinition extends AbstractDictionaryComponent<Suite> implements DictionaryRecord {

  private List<AppleScriptPropertyDefinition> properties;// = new ArrayList<AppleScriptPropertyDefinition>();

  public DictionaryRecordDefinition(@NotNull Suite suite, @NotNull String name, @NotNull String code,
                                    List<AppleScriptPropertyDefinition> properties, String description,
                                    @NotNull XmlTag xmlTagRecord) {
    super(suite, name, code, xmlTagRecord, description);
    this.properties = properties;
  }

  public DictionaryRecordDefinition(@NotNull Suite suite, @NotNull String name, @NotNull String code,
                                    String description, @NotNull XmlTag xmlTagRecord) {
    super(suite, name, code, xmlTagRecord, description);
  }

  @NotNull
  public List<AppleScriptPropertyDefinition> getProperties() {
    return properties;
  }

  public void setProperties(List<AppleScriptPropertyDefinition> properties) {
    this.properties = properties;
  }

  @NotNull
  @Override
  public Suite getSuite() {
    return getDictionaryParentComponent();
  }
}
