package com.idea.plugin.applescript.lang.sdef;

import com.intellij.psi.xml.XmlTag;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Andrey on 02.07.2015.
 */
public class AppleScriptCommandImpl extends AbstractDictionaryComponent<Suite> implements AppleScriptCommand {

  @NotNull private List<CommandParameter> parameters = new ArrayList<CommandParameter>();
  @NotNull private List<CommandParameter> mandatoryParameters = new ArrayList<CommandParameter>();
  @Nullable private CommandDirectParameter directParameter;
  @NotNull private List<String> parameterNames = new ArrayList<String>();
  @NotNull private Map<String, CommandParameter> parametersMap = new HashMap<String, CommandParameter>();
  @Nullable private CommandResult result;
  @Nullable String cocoaClassName; //todo reference to the real Psi CocoaClass could be implemented

  public AppleScriptCommandImpl(@NotNull Suite suite, @NotNull String name, @NotNull String code,
                                @Nullable List<CommandParameter> parameters,
                                @Nullable CommandDirectParameter directParameter, @Nullable CommandResult result,
                                @Nullable String description, @NotNull XmlTag xmlTagCommand) {
    super(suite, name, code, xmlTagCommand, description);
    this.directParameter = directParameter;
    this.result = result;
    if (parameters != null) {
      setParameters(parameters);
    }
  }

  public AppleScriptCommandImpl(@NotNull Suite suite, @NotNull String name, @NotNull String code,
                                @NotNull XmlTag xmlTagCommand) {
    super(suite, name, code, xmlTagCommand);
  }

  @Override
  @Nullable
  public CommandParameter getParameterByName(String name) {
    return parametersMap.get(name);
  }

  @Override
  @NotNull
  public List<String> getParameterNames() {
    return parameterNames;
  }


  @Override
  @NotNull
  public List<CommandParameter> getParameters() {
    return parameters;
  }

  @Override
  @Nullable
  public CommandDirectParameter getDirectParameter() {
    return directParameter;
  }


  @Nullable
  public CommandResult getResult() {
    return result;
  }

  @Override
  @NotNull
  public List<CommandParameter> getMandatoryParameters() {
    return mandatoryParameters;
  }

  @Override
  public void setParameters(@NotNull List<CommandParameter> parameters) {
    for (CommandParameter parameter : parameters) {
      this.parameterNames.add(parameter.getName());
      this.parameters.add(parameter);
      this.parametersMap.put(parameter.getName(), parameter);
      if (!parameter.isOptional()
              && !(parameter.getName().equals("in") || parameter.getName().equals("of"))//workaround for such
        // parameters not being detected as parameters but as object references
              ) {
        mandatoryParameters.add(parameter);
      }
    }
  }

  @Override
  public void setDirectParameter(@Nullable CommandDirectParameter directParameter) {
    this.directParameter = directParameter;
  }

  @Override
  @Nullable
  public String getCocoaClassName() {
    return cocoaClassName;
  }

  @NotNull
  @Override
  public Suite getSuite() {
    return myParent;
  }
}
