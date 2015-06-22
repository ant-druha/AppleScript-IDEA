package com.idea.plugin.applescript.psi.impl;

import com.idea.plugin.applescript.lang.AppleScriptComponentType;
import com.idea.plugin.applescript.psi.*;
import com.intellij.icons.AllIcons;
import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.openapi.editor.colors.CodeInsightColors;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.List;

/**
 * Created by Andrey on 21.04.2015.
 */
public abstract class BaseAppleScriptComponent extends AppleScriptPsiElementImpl implements AppleScriptComponent {

  public BaseAppleScriptComponent(@NotNull ASTNode node) {
    super(node);
  }

  public String toString() {
    return getNode().getElementType().toString();
  }

  @Override
  public boolean isGlobal() {
    return isScriptProperty() || findChildByType(AppleScriptTypes.GLOBAL) != null;
  }


  @Override
  public boolean isResolveTarget() {
    return !isObjectProperty(); //!!! should be enough !!!
  }

  @Override
  public boolean isComposite() {
    return PsiTreeUtil.getChildOfType(this, AppleScriptComponent.class) != null;
  }

  @Override
  public boolean isObjectProperty() {
    return getContext() instanceof AppleScriptRecordLiteralExpression || getContext() instanceof
            AppleScriptTargetRecordLiteral;
  }

  @Nullable
  @Override
  public PsiElement getOriginalDeclaration() {
    //todo (re)move this to targetReference
    PsiReference myReference = getReference();
    if (myReference != null) {
      PsiElement myTarget = myReference.resolve();
      return myTarget != null ? myTarget : null;
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
    return findChildByType(AppleScriptTypes.PROP) != null || findChildByType(AppleScriptTypes.PROPERTY) != null ||
            getOriginalDeclaration() instanceof AppleScriptPropertyDeclaration;
  }

  @Override
  public boolean isVariable() {
    return (findChildByType(AppleScriptTypes.LOCAL) != null || findChildByType(AppleScriptTypes.GLOBAL) != null) ||
            (this instanceof AppleScriptTargetVariable && getFirstChild() instanceof AppleScriptIdentifier) ||
            this instanceof AppleScriptVarDeclarationListPart ||
            getContext() instanceof AppleScriptLabeledParameterDeclarationList;
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
    final AppleScriptIdentifier identifier = getIdentifier();
    final AppleScriptIdentifier identifierNew = AppleScriptPsiElementFactory.createIdentifierFromText(getProject(),
            newElementName);
    if (identifierNew != null && identifier != null) {
      getNode().replaceChild(identifier.getNode(), identifierNew.getNode());
    }
    return this;
  }

  @Override
  public PsiReference getReference() {
    final String targetName = getName() != null ? getName() : getNode().getText();
    if (this instanceof AppleScriptTargetVariable) {
      return new AppleScriptTargetReferenceImpl(this, targetName);
    }
    return null;
    //todo to think how to better simplify
//    if (this instanceof AppleScriptHandlerPositionalParametersDefinition || this instanceof AppleScriptHandler
//            || this instanceof AppleScriptVarDeclarationListPart || this instanceof AppleScriptVarAccessDeclaration
//            || findChildByType(AppleScriptTypes.PROP) != null || findChildByType(AppleScriptTypes.PROPERTY) != null
//            ) {
//      return null;
//    }
//    return new AppleScriptTargetReferenceImpl(this, targetName);
  }

  @NotNull
  @Override
  public PsiReference[] getReferences() {
    return super.getReferences();
  }


  @Override
  public String getName() {
    PsiElement nameIdentifier = getNameIdentifier();
    if (nameIdentifier != null) {
      return nameIdentifier.getText();
    }
    return getNode().getText();
  }

  @Override
  public int getTextOffset() {
    return getNameIdentifier() != null ? getNameIdentifier().getTextOffset() : super.getTextOffset();
  }

  @Nullable
  @Override
  public PsiElement getNameIdentifier() {
    return getIdentifier();
  }

  @NotNull //todo check all identifiers
  @Override
  public abstract AppleScriptIdentifier getIdentifier();

  @Nullable
  @Override
  public Icon getIcon(int flags) {
    AppleScriptComponentType componentType = AppleScriptComponentType.typeOf(this);
    return componentType != null ? componentType.getIcon() : AllIcons.General.Ellipsis;
  }

  @Override
  public ItemPresentation getPresentation() {

    return new AppleScriptElementPresentation(BaseAppleScriptComponent.this) {
      @Nullable
      @Override
      public String getPresentableText() {
        final StringBuilder result = new StringBuilder();
        final AppleScriptComponent thisComponent = (AppleScriptComponent) getElement();

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
              List<AppleScriptComponent> myParameters = parameterList.getFormalParameters();
              result.append("(");
              String prefix = "";
              for (AppleScriptComponent paramName : myParameters) {
                result.append(prefix);
                prefix = ",";
                result.append(paramName.getName());
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
              PsiElement prevElement = directParameter.getPrevSibling();
              while (prevElement != null &&
                      AppleScriptTokenTypesSets.WHITE_SPACES_SET.contains(prevElement.getNode().getElementType())) {
                prevElement = prevElement.getPrevSibling();
              }
              if (prevElement != null &&
                      (AppleScriptTypes.ON.equals(prevElement.getNode().getElementType())
                              || prevElement.getNode().getElementType().equals(AppleScriptTypes.OF))) {
                result.append(' ').append(prevElement.getText());
              }
              result.append(' ').append(directParameter.getName());
            }
            if (!labeledParams.isEmpty()) {
              for (AppleScriptLabeledParameterDeclarationPart labeledParam : labeledParams) {
                result.append(' ').append(labeledParam.getHandlerParameterLabel().getText()).append(' ');
                result.append(labeledParam.getName());
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
  }
}
