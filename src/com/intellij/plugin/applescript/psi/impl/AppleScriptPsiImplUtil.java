package com.intellij.plugin.applescript.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.Pair;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.plugin.applescript.lang.resolve.AppleScriptResolveUtil;
import com.intellij.plugin.applescript.lang.sdef.ApplicationDictionary;
import com.intellij.plugin.applescript.psi.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.SmartList;
import com.intellij.util.containers.SortedList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Andrey 13.04.2015
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
    final List<AppleScriptComponent> result = new ArrayList<AppleScriptComponent>();
    AppleScriptLabeledParameterDeclarationList parameterList = handler.getLabeledParameterDeclarationList();
    List<AppleScriptObjectTargetPropertyDeclaration> givenProperties = handler.getObjectTargetPropertyDeclarationList();
    AppleScriptDirectParameterDeclaration directParameter = parameterList.getDirectParameterDeclaration();
    AppleScriptTargetListLiteral targetList = parameterList.getTargetListLiteral();
    AppleScriptTargetVariable targetVariable = parameterList.getTargetVariable();
    AppleScriptTargetRecordLiteral targetRecord = parameterList.getTargetRecordLiteral();
    List<AppleScriptLabeledParameterDeclarationPart> labeledParameters = parameterList
            .getLabeledParameterDeclarationPartList();
    if (directParameter != null) {
      result.add(directParameter);
    }
    if (targetList != null) {
      result.addAll(targetList.getTargets());
    }
    if (targetVariable != null) {
      result.add(targetVariable);
    }
    if (targetRecord != null) {
      result.addAll(targetRecord.getTargets());
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
    final List<AppleScriptComponent> result = new ArrayList<AppleScriptComponent>();
    AppleScriptDirectParameterDeclaration directParameter = parametersDeclaration.getDirectParameterDeclaration();
    List<AppleScriptLabeledParameterDeclarationPart> labeledParameters = parametersDeclaration
            .getLabeledParameterDeclarationPartList();
    AppleScriptTargetListLiteral targetList = parametersDeclaration.getTargetListLiteral();
    AppleScriptTargetVariable targetVariable = parametersDeclaration.getTargetVariable();
    AppleScriptTargetRecordLiteral targetRecord = parametersDeclaration.getTargetRecordLiteral();
    if (directParameter != null) {
      result.add(directParameter);
    }
    if (targetList != null) {
      result.addAll(targetList.getTargets());
    }
    if (targetVariable != null) {
      result.add(targetVariable);
    }
    if (targetRecord != null) {
      result.addAll(targetRecord.getTargets());
    }
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
    final List<Pair<AppleScriptPsiElement, AppleScriptExpression>> result = new SmartList<Pair<AppleScriptPsiElement,
            AppleScriptExpression>>();

    return result;
  }

  @NotNull
  public static List<AppleScriptTargetVariable> getTargets(@NotNull AppleScriptAssignmentStatement
                                                                   assignmentStatement) {
    final List<AppleScriptTargetVariable> result = new ArrayList<AppleScriptTargetVariable>();
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
    final StringBuilder result = new StringBuilder();
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

  public static List<String> getApplicationNameForElementInsideTellStatement(PsiElement element) {
    SortedList<PsiElement> resolveScope = AppleScriptResolveUtil.getTellStatementResolveScope(element);
    List<String> result = new ArrayList<String>();
    for (PsiElement tellStatement : resolveScope) {
      String appRef = findApplicationNameFromTellStatement(tellStatement);
      if (!StringUtil.isEmpty(appRef)) {
        result.add(appRef);
      }
    }
    return result;
  }

  public static String findApplicationNameFromTellStatement(PsiElement tellStatement) {
    //todo: could be not only application but any class of the application (process "Mail", etc)
    AppleScriptApplicationReference appRef = PsiTreeUtil.findChildOfType(tellStatement,
            AppleScriptApplicationReference.class);
    return getNameFromApplicationReference(appRef);
  }

  private static String getNameFromApplicationReference(@Nullable AppleScriptApplicationReference appRef) {
    if (appRef == null) return null;
    String text = appRef.getText();
    int from = text.indexOf('"') + 1;
    int to = text.indexOf('"', from);
    if (from >= 0 && from <= text.length() && to >= 0 && to <= text.length()) {
      return text.substring(from, to);
    }
    return null;
  }

  @Nullable
  public static String getApplicationName(AppleScriptUseStatement useStatement) {
    if (useStatement.getText().contains("application")) {
      AppleScriptApplicationReference appRef = PsiTreeUtil.findChildOfType(useStatement,
              AppleScriptApplicationReference.class);
      if (appRef == null) return null;
      ASTNode appNameNode = appRef.getNode().findChildByType(AppleScriptTypes.STRING_LITERAL);
      return appNameNode != null ? appNameNode.getText().replace("\"", "") : null;
    } else if (useStatement.getNode().findChildByType(AppleScriptTypes.SCRIPTING_ADDITIONS) != null) {
      return ApplicationDictionary.SCRIPTING_ADDITIONS_LIBRARY;
    }
    return null;
  }


  public static boolean useStandardAdditions(AppleScriptUseStatement useStatement) {
    ASTNode node = useStatement.getNode();
    return node.findChildByType(AppleScriptTypes.SCRIPTING_ADDITIONS) != null;
  }

  public static boolean withImporting(AppleScriptUseStatement useStatement) {
    ASTNode node = useStatement.getNode();
    return !(node.getText().contains("without") || node.getText().contains("false"));
  }


  @Nullable
  public static String getApplicationName(AppleScriptUsingTermsFromStatement usingTermsStatement) {
    AppleScriptApplicationReference appRef = usingTermsStatement.getApplicationReference();
    return appRef != null ? appRef.getApplicationName() : usingTermsStatement.withImportingStdLibrary() ?
            ApplicationDictionary.SCRIPTING_ADDITIONS_LIBRARY : null;
  }

  public static boolean withImportingStdLibrary(AppleScriptUsingTermsFromStatement usingTermsStatement) {
    ASTNode node = usingTermsStatement.getNode();
    return node.findChildByType(AppleScriptTypes.SCRIPTING_ADDITIONS) != null;
  }

  @Nullable
  public static String getApplicationName(@NotNull AppleScriptApplicationReference applicationReference) {
    return getNameFromApplicationReference(applicationReference);
  }

  public static boolean isInsideTellStatement(@NotNull PsiElement element) {
    PsiElement parent = element;
    while (parent != null) {
      parent = parent.getParent();
      if (parent instanceof AppleScriptTellSimpleStatement
              || parent instanceof AppleScriptTellCompoundStatement) {
        return true;
      }
    }
    return false;
  }

  @Nullable
  public static AppleScriptApplicationReference getApplicationReference(
          @NotNull AppleScriptTellCompoundStatement tellCompoundStatement) {
    return PsiTreeUtil.getChildOfType(tellCompoundStatement, AppleScriptApplicationReference.class);
  }

  @Nullable
  public static String getApplicationName(@NotNull AppleScriptTellCompoundStatement tellCompound) {
    AppleScriptApplicationReference appRef = tellCompound.getApplicationReference();
    return appRef != null ? appRef.getApplicationName() : null;
  }

  @Nullable
  public static AppleScriptApplicationReference getApplicationReference(
          @NotNull AppleScriptTellSimpleStatement tellCompoundStatement) {
    return PsiTreeUtil.getChildOfType(tellCompoundStatement, AppleScriptApplicationReference.class);
  }

  @Nullable
  public static String getApplicationName(@NotNull AppleScriptTellSimpleStatement tellSimple) {
    AppleScriptApplicationReference appRef = PsiTreeUtil
            .findChildOfType(tellSimple, AppleScriptApplicationReference.class);
//    AppleScriptApplicationReference appRef = tellSimple.getApplicationReference();
    return appRef != null ? appRef.getApplicationName() : null;
  }

}
