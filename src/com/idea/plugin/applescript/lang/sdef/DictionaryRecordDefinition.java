package com.idea.plugin.applescript.lang.sdef;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class DictionaryRecordDefinition extends BaseDictionaryComponent implements DictionaryRecord {

  private List<AppleScriptPropertyDefinition> properties;// = new ArrayList<AppleScriptPropertyDefinition>();

  public DictionaryRecordDefinition(@NotNull String code, @NotNull String name, String description,
                                    @NotNull Suite suite, List<AppleScriptPropertyDefinition> properties) {
    super(code, name, suite, description);
    this.properties = properties;
  }

  @NotNull
  public List<AppleScriptPropertyDefinition> getProperties() {
    return properties;
  }
}
