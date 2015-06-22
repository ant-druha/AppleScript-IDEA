package com.idea.plugin.applescript.psi.impl;

import com.idea.plugin.applescript.psi.*;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.Pair;
import com.intellij.psi.PsiElement;
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
  public static List<AppleScriptTargetVariable> getTargets(@NotNull AppleScriptTargetListLiteral
                                                                   targetList) {
    final List<AppleScriptTargetVariable> components = new ArrayList<AppleScriptTargetVariable>();
    for (AppleScriptTargetVariable targetComponent : targetList.getTargetVariableList()) {
      components.add(targetComponent);
    }
    return components;
  }

  @NotNull
  public static List<AppleScriptSimpleFormalParameter> getParameters(@NotNull AppleScriptListFormalParameter
                                                                             listFormalParameter) {
    final List<AppleScriptSimpleFormalParameter> params = new ArrayList<AppleScriptSimpleFormalParameter>();
    for (AppleScriptSimpleFormalParameter param : listFormalParameter.getSimpleFormalParameterList()) {
      params.add(param);
    }
    return params;
  }

  //todo refactor to use one generic methods for list and record
  @NotNull
  public static List<AppleScriptComponent> getFormalParameters(@NotNull
                                                               AppleScriptFormalParameterList
                                                                       parameterList) {
    final List<AppleScriptComponent> parameters = new ArrayList<AppleScriptComponent>();
    List<AppleScriptSimpleFormalParameter> singleParams = parameterList.getSimpleFormalParameterList();
    List<AppleScriptListFormalParameter> listsOfParams = parameterList.getListFormalParameterList();
    List<AppleScriptRecordFormalParameter> recordsOfParams = parameterList.getRecordFormalParameterList();

    for (AppleScriptSimpleFormalParameter simpleParam : singleParams) {
      parameters.add(simpleParam);
    }

    for (AppleScriptListFormalParameter listOfParams : listsOfParams) {
      for (AppleScriptSimpleFormalParameter simpleParam : listOfParams.getParameters()) {
        parameters.add(simpleParam);
      }
    }
    for (AppleScriptRecordFormalParameter recordOfParams : recordsOfParams) {
      for (AppleScriptSimpleFormalParameter simpleParam : recordOfParams.getParameters()) {
        parameters.add(simpleParam);
      }
    }
    return parameters;
  }

  private static void addRecordTargetVariablesRecursive(@NotNull AppleScriptTargetRecordLiteral targetRecord, @NotNull
  List<AppleScriptTargetVariable> targetVariables) {

    for (AppleScriptObjectTargetPropertyDeclaration property : targetRecord.getObjectTargetPropertyDeclarationList()) {
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

  private static void addRecordFormalParameterRecursive(@NotNull AppleScriptRecordFormalParameter recordParameter,
                                                        @NotNull List<AppleScriptSimpleFormalParameter> parameters) {
    for (AppleScriptObjectNamedPropertyDeclaration property : recordParameter.getObjectNamedPropertyDeclarationList()) {
      AppleScriptSimpleFormalParameter innerVariable = property.getSimpleFormalParameter();
      AppleScriptListFormalParameter innerList = property.getListFormalParameter();
      AppleScriptRecordFormalParameter innerRecord = property.getRecordFormalParameter();
      if (innerVariable != null) {
        parameters.add(innerVariable);
      }
      if (innerList != null) {
        for (AppleScriptSimpleFormalParameter listVar : innerList.getSimpleFormalParameterList()) {
          parameters.add(listVar);
        }
      }
      if (innerRecord != null) {
        addRecordFormalParameterRecursive(innerRecord, parameters);
      }
    }
  }

  public static List<AppleScriptComponent> getParameterComponentList(@NotNull
                                                                     AppleScriptHandlerLabeledParametersDefinition
                                                                             handler) {
    List<AppleScriptComponent> result = new ArrayList<AppleScriptComponent>();
    AppleScriptLabeledParameterDeclarationList parameterList = handler.getLabeledParameterDeclarationList();
    List<AppleScriptObjectTargetPropertyDeclaration> givenProperties = handler.getObjectTargetPropertyDeclarationList();
    AppleScriptDirectParameterDeclaration directParameter = parameterList.getDirectParameterDeclaration();
    List<AppleScriptLabeledParameterDeclarationPart> labeledParameters = parameterList
            .getLabeledParameterDeclarationPartList();
    if (directParameter != null) {
      result.add(directParameter);
    }
    for (AppleScriptLabeledParameterDeclarationPart labeledParameter : labeledParameters) {
      result.add(labeledParameter);
    }
    for (AppleScriptObjectTargetPropertyDeclaration property : givenProperties) {
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
  public static List<AppleScriptTargetVariable> getTargets(@NotNull
                                                           AppleScriptTargetRecordLiteral
                                                                   targetRecord) {
    final List<AppleScriptTargetVariable> targetVariables = new ArrayList<AppleScriptTargetVariable>();
    addRecordTargetVariablesRecursive(targetRecord, targetVariables);
    return targetVariables;
  }

  @NotNull
  public static List<AppleScriptSimpleFormalParameter> getParameters(@NotNull
                                                                     AppleScriptRecordFormalParameter
                                                                             recordParameter) {
    final List<AppleScriptSimpleFormalParameter> parameters = new ArrayList<AppleScriptSimpleFormalParameter>();
    addRecordFormalParameterRecursive(recordParameter, parameters);
    return parameters;
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
  public static List<AppleScriptTargetVariable> getTargets(@NotNull AppleScriptAssignmentStatement
                                                                   assignmentStatement) {
    List<AppleScriptTargetVariable> result = new ArrayList<AppleScriptTargetVariable>();
    AppleScriptTargetVariable targetComponent = assignmentStatement.getTargetVariable();
    if (targetComponent != null) {
      result.add(targetComponent);
      return result;
    }
    AppleScriptTargetListLiteral targetListLiteral = assignmentStatement.getTargetListLiteral();
    if (targetListLiteral != null) {
      for (AppleScriptTargetVariable targetVariable : targetListLiteral.getTargets()) {
        result.add(targetVariable);
      }
      return result;
    }
    AppleScriptTargetRecordLiteral targetRecordLiteral = assignmentStatement.getTargetRecordLiteral();
    if (targetRecordLiteral != null) {
      for (AppleScriptTargetVariable targetVariable : targetRecordLiteral.getTargets()) {
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

  public static boolean isBefore(@NotNull final PsiElement e1, @NotNull final PsiElement e2, boolean strict) {
    return strict ? e1.getTextOffset() < e2.getTextOffset() : e1.getTextOffset() <= e2.getTextOffset();
  }

}
