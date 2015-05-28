package com.idea.plugin.applescript.psi.impl;

import com.idea.plugin.applescript.psi.*;
import com.intellij.icons.AllIcons;
import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.openapi.editor.colors.CodeInsightColors;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.IncorrectOperationException;
import com.intellij.util.PlatformIcons;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.List;

/**
 * Created by Andrey on 21.04.2015.
 */
public abstract class AbstractAppleScriptComponent extends AppleScriptPsiElementImpl implements AppleScriptComponent {

  public AbstractAppleScriptComponent(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public boolean isGlobal() {
    return isScriptProperty() || findChildByType(AppleScriptTypes.GLOBAL) != null;
  }


  @Override
  public boolean isResolveTarget() {
    return !isObjectProperty(); //!!! should should be enough !!!
  }

  @Override
  public boolean isComposite() {
    return PsiTreeUtil.getChildOfType(this, AppleScriptComponent.class) != null;
  }

  @Override
  public boolean isObjectProperty() {
    return getContext() instanceof AppleScriptRecordLiteralExpression || getContext() instanceof
            AppleScriptTargetRecordLiteral;
//        return false;
  }

  @Nullable
  @Override
  public PsiElement getOriginalDeclaration() {
    PsiReference myReference = getReference();
    if (myReference != null) {
      PsiElement myTarget = myReference.resolve();
      return myTarget != null ? myTarget.getContext() : null;
    }
    return null;
  }

  @Override
  public boolean isHandler() {
    return this instanceof AppleScriptHandlerPositionalParametersDefinition
            || this instanceof AppleScriptHandlerLabeledParametersDefinition
            || this instanceof AppleScriptHandlerInterleavedParametersDefinition;
  }

  @Override
  public boolean isScriptProperty() {
    if (findChildByType(AppleScriptTypes.PROP) != null || findChildByType(AppleScriptTypes.PROPERTY) != null) {
      return true;
    }
    return getOriginalDeclaration() instanceof AppleScriptPropertyDeclaration;
  }

  @Override
  public boolean isVariable() {
    return (findChildByType(AppleScriptTypes.LOCAL) != null || findChildByType(AppleScriptTypes.GLOBAL) != null) ||
            (this instanceof AppleScriptTargetVariable && getFirstChild() instanceof AppleScriptComponentName) ||
            this instanceof AppleScriptVarDeclarationListPart ||
            getContext() instanceof AppleScriptLabeledParameterDeclarationList;// 'on' is also a label!!
//        else if (getContext() instanceof AppleScriptComponent) {//if this is a component in component->variable init
//            return true;
//        }
  }

  @Nullable
  @Override
  public AppleScriptExpression findAssignedValue() {
    if (isScriptProperty()) {
      AppleScriptPropertyDeclaration myProperty = (AppleScriptPropertyDeclaration) this;
      return myProperty.getExpression();
    }
    return null;
  }


  @Override
  public PsiElement setName(@NonNls @NotNull String newElementName) throws IncorrectOperationException {
    // we need to find all occurrences of this element (as it could be more than one, not as
    // usual componentName like handlerName)
    // todo: check usages cope
    final AppleScriptComponentName componentName = getComponentName();
    if (componentName != null) {
      componentName.setName(newElementName);
    }
    return this;
  }

  @Override
  public PsiReference getReference() {
    return new AppleScriptTargetReferenceImpl(this);
//        return super.getReference();
  }

  @NotNull
  @Override
  public PsiReference[] getReferences() {
    return super.getReferences();
  }

  @Nullable
  @Override
  public abstract AppleScriptComponentName getComponentName();

  @Override
  public String getName() {
    AppleScriptComponentName componentName = getComponentName();
    if (componentName != null) {
      return componentName.getName();
    }
    return super.getName();
  }

  @Nullable
  @Override
  public PsiElement getNameIdentifier() {
    //returning this in case of property statement makes IDEA to highlight the whole statement
    return getComponentName();
  }

  @Nullable
  @Override
  public Icon getIcon(int flags) {
    if (isScriptProperty()) {
      return PlatformIcons.PROPERTY_ICON;
    } else if (isVariable()) { // only if single local/global variable or single variable in creation statement
      return PlatformIcons.VARIABLE_ICON;
    } else if (isHandler()) {
      return PlatformIcons.FUNCTION_ICON;
    }
    // or list/record target component
    return AllIcons.General.Ellipsis;
  }

  @Override
  public ItemPresentation getPresentation() {

    ItemPresentation presentation = new AppleScriptElementPresentation(this) {
      @Nullable
      @Override
      public String getPresentableText() {
        StringBuilder result = new StringBuilder();
        AppleScriptComponent thisComponent = (AppleScriptComponent) getElement();

        if (isScriptProperty()) {
          AppleScriptExpression myValExpression = findAssignedValue();
          String valueText = myValExpression != null ? myValExpression.getText() : null;
          result.append(getName()).append(" : ").append(valueText);
        } else if (isVariable()) {
          result.append(getName());
        } else if (isHandler()) {
          result.append(getName());
          if (thisComponent instanceof AppleScriptHandlerPositionalParametersDefinition) {
            AppleScriptHandlerPositionalParametersDefinition handler =
                    (AppleScriptHandlerPositionalParametersDefinition) thisComponent;
            AppleScriptFormalParameterList parameterList = handler.getFormalParameterList();
            if (parameterList != null) {
              List<AppleScriptComponentName> myParameters = parameterList.getTargetVariableComponentNameListRecursive();
              result.append("(");
              String prefix = "";
              for (AppleScriptComponentName parmName : myParameters) {
                result.append(prefix);
                prefix = ",";
                result.append(parmName.getName());
              }
              result.append(")");
            }
          } else if (thisComponent instanceof AppleScriptHandlerLabeledParametersDefinition) {
            //todo getTextAttribute (bold for label names, underlined for param.names etc)
            AppleScriptHandlerLabeledParametersDefinition handler = (AppleScriptHandlerLabeledParametersDefinition)
                    thisComponent;
            AppleScriptLabeledParameterDeclarationList parameters = handler.getLabeledParameterDeclarationList();
            AppleScriptDirectParameterDeclaration directParameter = parameters.getDirectParameterDeclaration();
            List<AppleScriptLabeledParameterDeclarationPart> labeledParams = parameters
                    .getLabeledParameterDeclarationPartList();
            String sep = " : ";
            result.append(sep);
            if (directParameter != null) {
//              sep = " : ";
//              result.append(sep);
              PsiElement prevElement = directParameter.getPrevSibling();
              while (AppleScriptTokenTypesSets.WHITE_SPACES_SET.contains(prevElement.getNode().getElementType())) {
                prevElement = prevElement.getPrevSibling();
              }
              if (prevElement.getNode().getElementType().equals(AppleScriptTypes.ON)
                      || prevElement.getNode().getElementType().equals(AppleScriptTypes.OF)) {
                result.append(' ').append(prevElement.getText());
              }
              result.append(' ').append(directParameter.getComponentName().getName());
            }
            if (!labeledParams.isEmpty()) {
//              if (!" : ".equals(sep)) {
//                sep = " : ";
//                result.append(sep); //todo this is just for test!
//              }
              for (AppleScriptLabeledParameterDeclarationPart labeledParam : labeledParams) {
                result.append(' ').append(labeledParam.getHandlerParameterLabel().getText()).append(' ')
                        .append(labeledParam.getComponentName().getName());
              }
            }
            setTextAttributesKey(CodeInsightColors.NOT_USED_ELEMENT_ATTRIBUTES);
          }
        } else {
          if (getName() != null) {
            result.append(getName());
          }
        }
        return result.toString();
      }
    };

    return presentation;
  }


}
