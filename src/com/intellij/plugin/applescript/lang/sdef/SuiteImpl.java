package com.intellij.plugin.applescript.lang.sdef;

import com.intellij.psi.xml.XmlTag;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SuiteImpl extends AbstractDictionaryComponent<ApplicationDictionary> implements Suite {

  private boolean hidden;
  private List<AppleScriptCommand> commandDefinitions = new ArrayList<AppleScriptCommand>();
  private List<AppleScriptClass> classDefinitions = new ArrayList<AppleScriptClass>();
  private Map<String, AppleScriptClass> classDefinitionsMap = new HashMap<String, AppleScriptClass>();
  private Map<String, AppleScriptClass> classDefinitionToCodeMap = new HashMap<String, AppleScriptClass>();
  private List<AppleScriptPropertyDefinition> propertyDefinitions = new ArrayList<AppleScriptPropertyDefinition>();

  private List<DictionaryRecord> dictionaryRecordList = new ArrayList<DictionaryRecord>();
  private List<DictionaryEnumeration> dictionaryEnumerationList = new ArrayList<DictionaryEnumeration>();
  private Map<String, AppleScriptCommand> dictionaryCommandMap = new HashMap<String, AppleScriptCommand>();
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
  public String getDocumentation() {
    StringBuilder sb = new StringBuilder();
    sb.append("<html>");
    sb.append(super.getDocumentation());

    String sep = "  ===================  ";
    sb.append("<p>").append("COMMANDS").append("<br>");
    for (AppleScriptCommand command : commandDefinitions) {
      sb.append("<br>").append("<b>").append(sep).append("</b>")/*.append("<br>")*/;
      String commandDoc = command.getDocumentation();
      sb.append("<p>").append(commandDoc.substring(commandDoc.indexOf("Command"))).append("</p>");
    }
    sb.append("</p>");

    sb.append("<p>").append("CLASSES").append("<br>");
    for (AppleScriptClass aClass : classDefinitions) {
      sb.append("<br>").append("<b>").append(sep).append("</b>")/*.append("<br>")*/;
      String classDoc = aClass.getDocumentation();
      sb.append("<p>").append(classDoc.substring(classDoc.indexOf("Class"))).append("</p>");
    }
    sb.append("</p>");
    sb.append("</html>");

    return sb.toString();
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
  public boolean addClass(AppleScriptClass appleScriptClass) {
    if (appleScriptClass == null) return false;

    classDefinitions.add(appleScriptClass);
    classDefinitionsMap.put(appleScriptClass.getName(), appleScriptClass);
    classDefinitionToCodeMap.put(appleScriptClass.getCode(), appleScriptClass);
    return true;
  }

  @Nullable
  @Override
  public AppleScriptClass getClassByName(String name) {
    return classDefinitionsMap.get(name);
  }

  @Nullable
  @Override
  public AppleScriptClass findClassByCode(String code) {
    return classDefinitionToCodeMap.get(code);
  }

  @Override
  public boolean addProperty(AppleScriptPropertyDefinition property) {
    return propertyDefinitions.add(property);
  }

  @Override
  public boolean addEnumeration(DictionaryEnumeration enumeration) {
    return dictionaryEnumerationList.add(enumeration);
  }

  @Override
  public void addRecord(DictionaryRecord record) {
    dictionaryRecordList.add(record);
  }

  @Override
  public boolean addCommand(AppleScriptCommand command) {
    return command != null && commandDefinitions.add(command) &&
            dictionaryCommandMap.put(command.getName(), command) != null;
  }
}
