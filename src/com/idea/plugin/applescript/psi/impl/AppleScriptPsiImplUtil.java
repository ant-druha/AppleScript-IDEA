package com.idea.plugin.applescript.psi.impl;

import com.idea.plugin.applescript.psi.*;
import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrey on 13.04.2015.
 */
public class AppleScriptPsiImplUtil {


  @NotNull
  public static List<AppleScriptTargetVariable> getTargetVariableListRecursive(@NotNull AppleScriptTargetListLiteral
                                                                                         targetList) {
    final List<AppleScriptTargetVariable> componentNames = new ArrayList<AppleScriptTargetVariable>();
    for (AppleScriptTargetVariable targetComponentName : targetList.getTargetVariableList()) {
      componentNames.add(targetComponentName);
    }
    return componentNames;
  }

  @NotNull
  public static List<AppleScriptComponentName> getTargetVariableComponentNameListRecursive(@NotNull
                                                                                             AppleScriptFormalParameterList
                                                                                                   parameterList) {
    final List<AppleScriptComponentName> componentNames = new ArrayList<AppleScriptComponentName>();
    List<AppleScriptTargetVariable> targetVariables = parameterList.getTargetVariableList();
    List<AppleScriptTargetListLiteral> targetLists = parameterList.getTargetListLiteralList();
    List<AppleScriptTargetRecordLiteral> targetRecords = parameterList.getTargetRecordLiteralList();

    for (AppleScriptTargetVariable targetVariable : targetVariables) {
      componentNames.add(targetVariable.getComponentName());
    }

    for (AppleScriptTargetListLiteral targetList : targetLists) {
      for (AppleScriptTargetVariable targetVar : targetList.getTargetVariableListRecursive()) {
        componentNames.add(targetVar.getComponentName());
      }
    }
    for (AppleScriptTargetRecordLiteral targetRecord : targetRecords) {
      for (AppleScriptTargetVariable targetVar : targetRecord.getTargetVariableListRecursive()) {
        componentNames.add(targetVar.getComponentName());
      }
    }
    return componentNames;
  }

  private static void addRecordTargetVariablesRecursive(@NotNull AppleScriptTargetRecordLiteral targetRecord, @NotNull
  List<AppleScriptTargetVariable> targetVariables) {

    for (AppleScriptObjectPropertyTargetDeclaration property : targetRecord.getObjectPropertyTargetDeclarationList()) {
      AppleScriptTargetVariable innerVariable = property.getTargetVariable();
      AppleScriptTargetListLiteral innerList = property.getTargetListLiteral();
      AppleScriptTargetRecordLiteral innerRecord = property.getTargetRecordLiteral();
      if (innerVariable != null) {
        targetVariables.add(innerVariable);
      }
      if (innerList != null) {
        for (AppleScriptTargetVariable listVar : innerList.getTargetVariableList()) {
          targetVariables.add(listVar);
        }
      }
      if (innerRecord != null) {
        addRecordTargetVariablesRecursive(innerRecord, targetVariables);
      }
    }
  }

  public static List<AppleScriptComponentName> getParameterComponentNameList(@NotNull
                                                                             AppleScriptHandlerLabeledParametersDefinition handler) {
    List<AppleScriptComponentName> result = new ArrayList<AppleScriptComponentName>();
    AppleScriptLabeledParameterDeclarationList parameterList = handler.getLabeledParameterDeclarationList();
    List<AppleScriptObjectPropertyTargetDeclaration> givenProperties = handler.getObjectPropertyTargetDeclarationList();
    AppleScriptDirectParameterDeclaration directParameter = parameterList.getDirectParameterDeclaration();
    List<AppleScriptLabeledParameterDeclarationPart> labeledParameters = parameterList
            .getLabeledParameterDeclarationPartList();
    if (directParameter != null) {
      result.add(directParameter.getComponentName());
    }
    for (AppleScriptLabeledParameterDeclarationPart labeledParameter : labeledParameters) {
      result.add(labeledParameter.getComponentName());
    }
    for (AppleScriptObjectPropertyTargetDeclaration property : givenProperties) {
      result.add(property.getComponentName());
    }
    return result;
  }

  public static List<AppleScriptComponentName> getComponentNameList(@NotNull
                                                                    AppleScriptLabeledParameterDeclarationList
                                                                            parametersDeclaration) {
    List<AppleScriptComponentName> result = new ArrayList<AppleScriptComponentName>();
    AppleScriptDirectParameterDeclaration directParameter = parametersDeclaration.getDirectParameterDeclaration();
    List<AppleScriptLabeledParameterDeclarationPart> labeledParameters = parametersDeclaration
            .getLabeledParameterDeclarationPartList();
    if (directParameter != null) {
      result.add(directParameter.getComponentName());
    }
    for (AppleScriptLabeledParameterDeclarationPart labeledParameter : labeledParameters) {
      result.add(labeledParameter.getComponentName());
    }
    return result;
  }

  @NotNull
  public static List<AppleScriptTargetVariable> getTargetVariableListRecursive(@NotNull
                                                                                 AppleScriptTargetRecordLiteral
                                                                                         targetRecord) {
    final List<AppleScriptTargetVariable> targetVariables = new ArrayList<AppleScriptTargetVariable>();
    addRecordTargetVariablesRecursive(targetRecord, targetVariables);
    return targetVariables;
  }

  @Nullable
  public static AppleScriptPsiElement getAssignmentTarget(@NotNull AppleScriptAssignmentStatement creationStatement) {
    AppleScriptTargetVariable targetVariable = creationStatement.getTargetVariable();
    AppleScriptTargetListLiteral targetListLiteral = creationStatement.getTargetListLiteral();
    AppleScriptTargetRecordLiteral recordLiteral = creationStatement.getTargetRecordLiteral();
    return targetVariable != null ? targetVariable : targetListLiteral != null ? targetListLiteral : recordLiteral !=
            null ? recordLiteral
            : null;
  }

  @NotNull
  public static List<AppleScriptComponentName> getTargetVariableListRecursive(@NotNull AppleScriptAssignmentStatement
                                                                                        creationStatement) {
    List<AppleScriptComponentName> result = new ArrayList<AppleScriptComponentName>();
    AppleScriptTargetVariable targetComponentName = creationStatement.getTargetVariable();
    if (targetComponentName != null) {
      result.add(targetComponentName.getComponentName());
      return result;
    }
    AppleScriptTargetListLiteral targetListLiteral = creationStatement.getTargetListLiteral();
    if (targetListLiteral != null) {
      for (AppleScriptTargetVariable targetVariable : targetListLiteral.getTargetVariableListRecursive()) {
        AppleScriptComponentName componentName = targetVariable.getComponentName();
        if (componentName != null) {//todo to check
          result.add(componentName);
        }
      }
      return result;
    }
    AppleScriptTargetRecordLiteral targetRecordLiteral = creationStatement.getTargetRecordLiteral();
    if (targetRecordLiteral != null) {
      for (AppleScriptTargetVariable targetVariable : targetRecordLiteral.getTargetVariableListRecursive()) {
        AppleScriptComponentName componentName = targetVariable.getComponentName();
        if (componentName != null) {//todo to check
          result.add(componentName);
        }
      }
      return result;
//            result.addAll(targetRecordLiteral.getComponentNameList());
//            return result;
    }
    return result;
  }

  public static boolean isWhiteSpaceOrNls(ASTNode node) {
    return node != null && AppleScriptTokenTypesSets.WHITE_SPACES_SET.contains(node.getElementType());
  }
}
