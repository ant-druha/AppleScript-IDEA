package com.idea.plugin.applescript.psi.impl;

import com.idea.plugin.applescript.psi.*;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.Pair;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.SmartList;
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
    final List<AppleScriptTargetVariable> components = new ArrayList<AppleScriptTargetVariable>();
    for (AppleScriptTargetVariable targetComponent : targetList.getTargetVariableList()) {
      components.add(targetComponent);
    }
    return components;
  }

  @NotNull
  public static List<AppleScriptComponent> getTargetVariableComponentListRecursive(@NotNull
                                                                                   AppleScriptFormalParameterList
                                                                                           parameterList) {
    final List<AppleScriptComponent> components = new ArrayList<AppleScriptComponent>();
    List<AppleScriptTargetVariable> targetVariables = parameterList.getTargetVariableList();
    List<AppleScriptTargetListLiteral> targetLists = parameterList.getTargetListLiteralList();
    List<AppleScriptTargetRecordLiteral> targetRecords = parameterList.getTargetRecordLiteralList();

    for (AppleScriptTargetVariable targetVariable : targetVariables) {
      components.add(targetVariable);
    }

    for (AppleScriptTargetListLiteral targetList : targetLists) {
      for (AppleScriptTargetVariable targetVar : targetList.getTargetVariableListRecursive()) {
        components.add(targetVar);
      }
    }
    for (AppleScriptTargetRecordLiteral targetRecord : targetRecords) {
      for (AppleScriptTargetVariable targetVar : targetRecord.getTargetVariableListRecursive()) {
        components.add(targetVar);
      }
    }
    return components;
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

  public static List<AppleScriptComponent> getParameterComponentList(@NotNull
                                                                     AppleScriptHandlerLabeledParametersDefinition
                                                                             handler) {
    List<AppleScriptComponent> result = new ArrayList<AppleScriptComponent>();
    AppleScriptLabeledParameterDeclarationList parameterList = handler.getLabeledParameterDeclarationList();
    List<AppleScriptObjectPropertyTargetDeclaration> givenProperties = handler.getObjectPropertyTargetDeclarationList();
    AppleScriptDirectParameterDeclaration directParameter = parameterList.getDirectParameterDeclaration();
    List<AppleScriptLabeledParameterDeclarationPart> labeledParameters = parameterList
            .getLabeledParameterDeclarationPartList();
    if (directParameter != null) {
      result.add(directParameter);
    }
    for (AppleScriptLabeledParameterDeclarationPart labeledParameter : labeledParameters) {
      result.add(labeledParameter);
    }
    for (AppleScriptObjectPropertyTargetDeclaration property : givenProperties) {
      result.add(property);
    }
    return result;
  }

  public static List<AppleScriptComponent> getComponentList(@NotNull
                                                            AppleScriptLabeledParameterDeclarationList
                                                                    parametersDeclaration) {
    List<AppleScriptComponent> result = new ArrayList<AppleScriptComponent>();
    AppleScriptDirectParameterDeclaration directParameter = parametersDeclaration.getDirectParameterDeclaration();
    List<AppleScriptLabeledParameterDeclarationPart> labeledParameters = parametersDeclaration
            .getLabeledParameterDeclarationPartList();
    if (directParameter != null) {
      result.add(directParameter);
    }
    for (AppleScriptLabeledParameterDeclarationPart labeledParameter : labeledParameters) {
      result.add(labeledParameter);
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
  public static AppleScriptPsiElement getAssignmentTarget(@NotNull AppleScriptAssignmentStatement assignmentStatement) {
    AppleScriptTargetVariable targetVariable = assignmentStatement.getTargetVariable();
    AppleScriptTargetListLiteral targetListLiteral = assignmentStatement.getTargetListLiteral();
    AppleScriptTargetRecordLiteral recordLiteral = assignmentStatement.getTargetRecordLiteral();
    return targetVariable != null ? targetVariable : targetListLiteral != null ? targetListLiteral : recordLiteral !=
            null ? recordLiteral
            : null;
  }

  @NotNull
  public static List<Pair<AppleScriptPsiElement, AppleScriptExpression>> getTargetsToValuesMapping(@NotNull
                                                                                                   AppleScriptAssignmentStatement assignmentStatement) {
    List<Pair<AppleScriptPsiElement, AppleScriptExpression>> result = new SmartList<Pair<AppleScriptPsiElement,
            AppleScriptExpression>>();

    return result;
  }

  @NotNull
  public static List<AppleScriptComponent> getTargetVariableListRecursive(@NotNull AppleScriptAssignmentStatement
                                                                                  assignmentStatement) {
    List<AppleScriptComponent> result = new ArrayList<AppleScriptComponent>();
    AppleScriptTargetVariable targetComponent = assignmentStatement.getTargetVariable();
    if (targetComponent != null) {
      result.add(targetComponent);
      return result;
    }
    AppleScriptTargetListLiteral targetListLiteral = assignmentStatement.getTargetListLiteral();
    if (targetListLiteral != null) {
      for (AppleScriptTargetVariable targetVariable : targetListLiteral.getTargetVariableListRecursive()) {
        result.add(targetVariable);
      }
      return result;
    }
    AppleScriptTargetRecordLiteral targetRecordLiteral = assignmentStatement.getTargetRecordLiteral();
    if (targetRecordLiteral != null) {
      for (AppleScriptTargetVariable targetVariable : targetRecordLiteral.getTargetVariableListRecursive()) {
        result.add(targetVariable);
      }
      return result;
    }
    return result;
  }

  public static AppleScriptIdentifier getSelectorIdentifier(AppleScriptArgumentSelector argumentSelector) {
    return PsiTreeUtil.findChildOfType(argumentSelector, AppleScriptIdentifier.class);
  }

  public static String getSelectorName(AppleScriptArgumentSelector argumentSelector) {
    StringBuilder result = new StringBuilder();
    ASTNode child = argumentSelector.getNode().getFirstChildNode();
    while (child != null) {
      final IElementType tt = child.getElementType();
      if (tt == AppleScriptTypes.IDENTIFIER || tt == AppleScriptTypes.COLON) {
        result.append(child.getText());
      }
      child = child.getTreeNext();
    }
    return result.toString();
  }

  public static boolean isWhiteSpaceOrNls(ASTNode node) {
    return node != null && AppleScriptTokenTypesSets.WHITE_SPACES_SET.contains(node.getElementType());
  }
}
