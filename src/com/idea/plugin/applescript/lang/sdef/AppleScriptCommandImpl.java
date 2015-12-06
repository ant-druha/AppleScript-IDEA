package com.idea.plugin.applescript.lang.sdef;

import com.intellij.openapi.util.text.StringUtil;
import com.intellij.psi.xml.XmlTag;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Andrey 02.07.2015
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

  @Nullable
  public CommandResult setResult(@Nullable CommandResult result) {
    this.result = result;
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
  public String getDocumentation() {
    StringBuilder sb = new StringBuilder();
    final String indent = "&nbsp;&nbsp;&nbsp;&nbsp;";
    sb.append(super.getDocumentation());

    CommandDirectParameter p = getDirectParameter();
    List<CommandParameter> parameters = getParameters();
    if (p != null || !parameters.isEmpty()) {
      sb.append("<p><b>Parameters:</b></p>");
    }
    if (p != null)
      sb.append(indent).append(indent).append(p.getTypeSpecifier()).append(" : ").append(StringUtil.notNullize(p
              .getDescription())).
              append("<br>");

    for (CommandParameter par : parameters) {
      String op = "";
      String cl = "";
      if (par.isOptional()) {
        op = "[";
        cl = "]";
      }
      String pType = StringUtil.notNullize(par.getTypeSpecifier());
      sb.append(indent).append(indent).append(op).append("<b>").append(par.getName()).append("</b> ").append(pType)
              .append(cl).append(" : ").
              append(par.getDescription()).append("<br>");
    }
    CommandResult res = getResult();
    if (res != null) {
      sb.append("<p>").append("<b>Returns:</b></p>").append(indent).append(indent).
              append(res.getType()).append(" : ").append(StringUtil.notNullize(res.getDescription()));
    }
    return sb.toString();
  }

  @NotNull
  @Override
  public Suite getSuite() {
    return myParent;
  }
}
