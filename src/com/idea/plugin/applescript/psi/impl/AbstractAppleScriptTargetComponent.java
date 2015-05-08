package com.idea.plugin.applescript.psi.impl;

import com.idea.plugin.applescript.psi.*;
import com.intellij.icons.AllIcons;
import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.util.IncorrectOperationException;
import com.intellij.util.PlatformIcons;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrey on 21.04.2015.
 */
public abstract class AbstractAppleScriptTargetComponent extends
        AppleScriptPsiElementImpl
//        AppleScriptNamedElementImpl
        implements AppleScriptTargetComponent {

    public AbstractAppleScriptTargetComponent(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public boolean isGlobal() {
        return isProperty() || getText().toLowerCase().contains("global");//or "local".equals(getFirstChild().getText())
    }

//    @Override
//    public boolean isParentProperty() {
//        return false;
//    }

    @Override
    public boolean isProperty() {
        return this instanceof AppleScriptPropertyDeclarationStatement;
    }

    @Override
    public boolean isVariable() {
        return this instanceof AppleScriptVariableDeclarationStatement
                || (this instanceof AppleScriptTargetComponentName
                && getFirstChild() instanceof AppleScriptComponentName);
//                && getFirstChild() instanceof AppleScriptComponentName; /*!isProperty() && !(getComponentNameList().size()>1);*/
    }

//    @Override
//    public boolean isVariableList() {
//        return this instanceof AppleScriptTargetCompositeComponent
//                && getFirstChild() instanceof AppleScriptTargetListLiteral;/*getComponentNameList().size()>1;*/
//    }
//
//    @Override
//    public boolean isVariableRecord() {
//        return this instanceof AppleScriptTargetCompositeComponent
//                && getFirstChild() instanceof AppleScriptTargetRecordLiteral;/*getComponentNameList().size()>1;*/
//    }

    @Nullable
    @Override
    public AppleScriptExpression getValueExpression() {
        if (isProperty()) {
            AppleScriptPropertyDeclarationStatement myProperty = (AppleScriptPropertyDeclarationStatement) this;
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
//        return super.setName(newElementName);
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

    @Override
    public String getName() {
        AppleScriptComponentName componentName = getComponentName();
        if (componentName != null) {
            return componentName.getName();
        }

//        if (isProperty() || isVariable()) {
//            return getComponentNameList().isEmpty() || getComponentNameList().get(0) == null
//                    ? super.getName() : getComponentNameList().get(0).getName();
//        }
        return super.getName();
    }


    @Nullable
    @Override
    public PsiElement getNameIdentifier() {
        //returning this in case of property statement makes IDEA to highlight the whole statement
        return getComponentName();
//        return this;
//        return super.getNameIdentifier() ==null ? this : super.getNameIdentifier();
    }

//    @NotNull
//    @Override
//    public List<AppleScriptComponentName> getComponentNameList() {
//        final List<AppleScriptComponentName> result = new ArrayList<AppleScriptComponentName>();
//        //final PsiElement firstChild = this.getFirstChild(); //bad hierarchy
//        if (isProperty()) {
//            // todo if parent - will not contain componentName!!
//            // todo also if it is a built in class
//            AppleScriptComponentName componentName = this.getComponentName();
//            if (componentName != null)
//                result.add(componentName);
//        } else if (isVariable()) {
//            //todo enhance this logic
//            if (this instanceof AppleScriptVariableDeclarationStatement) {
//                AppleScriptComponentName componentName = this.getComponentName();
//                if (componentName != null)
//                    result.add(componentName);
//            } else if (this instanceof AppleScriptTargetCompositeComponent
//                    && getFirstChild() instanceof AppleScriptComponentName) {//creation statement with single value
//                result.add((AppleScriptComponentName) getFirstChild());
//
//            }
//        }
////        else if (isVariableList()) {
////            AppleScriptTargetListLiteral targetList = (AppleScriptTargetListLiteral) getFirstChild();
////            List<AppleScriptTargetCompositeComponent> compositeList =
////                    targetList.getTargetCompositeComponentList();
////            for (AppleScriptTargetCompositeComponent compositeComponent : compositeList) {
////                result.addAll(compositeComponent.getComponentNameList());
////            }
////        } else if (isVariableRecord()) {
////            AppleScriptTargetRecordLiteral targetRecord = (AppleScriptTargetRecordLiteral) getFirstChild();
////            List<AppleScriptTargetCompositeComponent> compositeList =
////                    targetRecord.getTargetCompositeComponentList();
////            for (AppleScriptTargetCompositeComponent compositeComponent : compositeList) {
////                result.addAll(compositeComponent.getComponentNameList());
////            }
////        }
//
//        return result;
//    }

//    @Nullable
//    @Override
//    public AppleScriptComponentName getComponentName() {
//        return null;
//    }

    @Nullable
    @Override
    public Icon getIcon(int flags) {
        if (isProperty()) {
            return PlatformIcons.PROPERTY_ICON;
        } else if (isVariable()) { // only if single local/global variable or single variable in creation statement
            return PlatformIcons.VARIABLE_ICON;
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
                AppleScriptTargetComponent thisComponent = (AppleScriptTargetComponent) getElement();

                if (isProperty()) {
                    String valueText = getValueExpression() != null ? getValueExpression().getText() : null;
                    result.append(getName()).append(" : ").append(valueText);
                } else if (isVariable()) {
                    result.append(getName());
                }
//                if (getElement() instanceof AppleScriptPropertyImpl) {
//                    AppleScriptPropertyImpl propertyDefinition = (AppleScriptPropertyImpl)getElement();
//
//
//
//                    String name = propertyDefinition.getComponentName() != null ? propertyDefinition.getComponentName().getName() : "";
////                    String value = propertyDefinition.getExpression() != null ? propertyDefinition.getExpression().getText() : "";
////                    result.append(name).append(" : ").append(value);
//                }
                return result.toString();
            }
        };

        return presentation;
    }


}
