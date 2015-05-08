package com.idea.plugin.applescript.psi.impl;

import com.idea.plugin.applescript.psi.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.PsiScopeProcessor;
import com.intellij.util.IncorrectOperationException;
import gnu.trove.THashSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by Andrey on 14.04.2015.
 */
public class AppleScriptPsiElementImpl extends ASTWrapperPsiElement implements AppleScriptPsiElement {
    public AppleScriptPsiElementImpl(ASTNode node) {
        super(node);
    }

    public static void processTopDeclarations(@NotNull PsiElement context, final Set<AppleScriptComponentName> result, boolean recursively) {
        final PsiElement[] children = context.getChildren();

        for (PsiElement child : children) {
            if (child instanceof AppleScriptPropertyDeclarationStatement) {
                AppleScriptPropertyDeclarationStatement propertyDeclaration = (AppleScriptPropertyDeclarationStatement) child;

                AppleScriptComponentName componentName = propertyDeclaration.getComponentName();
                if (componentName != null) {
                    result.add(componentName);
                }
            } else if (child instanceof AppleScriptVariableDeclarationStatement) {
                AppleScriptVariableDeclarationStatement variableDeclaration = (AppleScriptVariableDeclarationStatement) child;

                AppleScriptComponentName componentName = variableDeclaration.getComponentName();
                if (componentName != null) {
                    result.add(componentName);
                }
            } else if (child instanceof AppleScriptHandlerPositionalParametersDefinition) {
                AppleScriptHandlerPositionalParametersDefinition handlerDeclaration =
                        (AppleScriptHandlerPositionalParametersDefinition) child;
                result.addAll(handlerDeclaration.getComponentNameList());
            } else if (child instanceof AppleScriptHandlerLabeledParametersDefinition) {
                AppleScriptHandlerLabeledParametersDefinition handlerDeclaration =
                        (AppleScriptHandlerLabeledParametersDefinition) child;
                result.addAll(handlerDeclaration.getComponentNameList());
            } else if (child instanceof AppleScriptCreationStatement) {
                AppleScriptCreationStatement creationStatement = (AppleScriptCreationStatement) child;
                AppleScriptPsiElement targetComponentClass = creationStatement.getTargetComponent();
                if (targetComponentClass instanceof AppleScriptTargetComponentName) {
                    AppleScriptComponentName currentComponent =
                            ((AppleScriptTargetComponentName) targetComponentClass).getComponentName();
                    boolean duplicatedDeclaration = false;
                    boolean duplicatedDeclarationReplaced = false;
                    for (Iterator<AppleScriptComponentName> it = result.iterator(); it.hasNext(); ) {
                        AppleScriptComponentName ourAddedComponent = it.next();
                        if (ourAddedComponent.getName() != null && ourAddedComponent.getName().equals(currentComponent.getName())) {
                            duplicatedDeclaration = true;
                            if (ourAddedComponent.getTextOffset() > currentComponent.getTextOffset()) {
                                it.remove();
                                duplicatedDeclarationReplaced = true;
                            } //remove if currentComponent declared earlier, will add it later
                        }
                    }
                    if (!duplicatedDeclaration || duplicatedDeclarationReplaced) {
                        result.add(currentComponent);
                    }
                } else {
                    List<AppleScriptComponentName> currentComponentNameList = null;
                    if (targetComponentClass instanceof AppleScriptTargetListLiteral) {
                        AppleScriptTargetListLiteral targetList = (AppleScriptTargetListLiteral) targetComponentClass;
                        currentComponentNameList = targetList.getComponentNameList();
                    } else if (targetComponentClass instanceof AppleScriptTargetRecordLiteral) {
                        AppleScriptTargetRecordLiteral targetRecord = (AppleScriptTargetRecordLiteral) targetComponentClass;
                        currentComponentNameList = targetRecord.getComponentNameList();
                    }
                    if (currentComponentNameList != null && !currentComponentNameList.isEmpty()) {
                        for (AppleScriptComponentName currentComponent : currentComponentNameList) {
                            boolean duplicatedDeclaration = false;
                            boolean duplicatedDeclarationRemoved = false;
                            for (Iterator<AppleScriptComponentName> it = result.iterator(); it.hasNext(); ) {
                                AppleScriptComponentName ourAddedComponent = it.next();
                                if (ourAddedComponent.getName() != null && ourAddedComponent.getName().equals(currentComponent.getName())) {
                                    duplicatedDeclaration = true;
                                    if (ourAddedComponent.getTextOffset() > currentComponent.getTextOffset()) {
                                        it.remove(); //not called
                                        duplicatedDeclarationRemoved = true;
                                    } //remove if currentComponent declared earlier, will add it later
                                }
                            }
                            if (!duplicatedDeclaration || duplicatedDeclarationRemoved) {
                                result.add(currentComponent);
                            }
                        }
                    }
                }
//                }
            } else if (recursively && child instanceof AppleScriptBlockBody
                    && !(context instanceof AppleScriptIfCompoundStatement)) { // do not scan other inner blocks of if statement
                processTopDeclarations(child, result, true);
            }

            if (child instanceof AppleScriptComponentName) {
                result.add((AppleScriptComponentName) child);
            }
        }

    }

    public static boolean processDeclarationsImpl(@Nullable PsiElement context,
                                                  PsiScopeProcessor processor,
                                                  ResolveState state,
                                                  @Nullable PsiElement lastParent) {
        if (context == null) {
            return true;
        }
        final PsiElement[] children = context.getChildren();
        final Set<AppleScriptComponentName> result = new THashSet<AppleScriptComponentName>();
        for (PsiElement child : children) {
            if (child != lastParent) {

                if (child instanceof AppleScriptPropertyDeclarationStatement) {
                    AppleScriptPropertyDeclarationStatement propertyDeclaration = (AppleScriptPropertyDeclarationStatement) child;
                    AppleScriptComponentName componentName = propertyDeclaration.getComponentName();
                    if (componentName != null) {
                        result.add(componentName);
                    }
                } else if (child instanceof AppleScriptVariableDeclarationStatement) {
                    AppleScriptVariableDeclarationStatement variableDeclaration = (AppleScriptVariableDeclarationStatement) child;

                    AppleScriptComponentName componentName = variableDeclaration.getComponentName();
                    if (componentName != null) {
                        result.add(componentName);
                    }
                } else if (child instanceof AppleScriptHandlerPositionalParametersDefinition) {
                    AppleScriptHandlerPositionalParametersDefinition handlerDeclaration =
                            (AppleScriptHandlerPositionalParametersDefinition) child;
                    result.addAll(handlerDeclaration.getComponentNameList());
                } else if (child instanceof AppleScriptHandlerLabeledParametersDefinition) {
                    AppleScriptHandlerLabeledParametersDefinition handlerDeclaration =
                            (AppleScriptHandlerLabeledParametersDefinition) child;
                    result.addAll(handlerDeclaration.getComponentNameList());
                } else if (child instanceof AppleScriptFormalParameterList) {
                    AppleScriptFormalParameterList parameterList = (AppleScriptFormalParameterList) child;
                    List<AppleScriptComponentName> cmList = parameterList.getComponentNameList();
                    if (!cmList.isEmpty()) {
                        result.addAll(cmList);
                    }
                } else if (child instanceof AppleScriptCreationStatement) {
                    AppleScriptCreationStatement creationStatement = (AppleScriptCreationStatement) child;
                    AppleScriptPsiElement targetComponentClass = creationStatement.getTargetComponent();
                    if (targetComponentClass instanceof AppleScriptTargetComponentName) {
                        AppleScriptComponentName currentComponent =
                                ((AppleScriptTargetComponentName) targetComponentClass).getComponentName();
                        boolean duplicatedDeclaration = false;
                        boolean duplicatedDeclarationRemoved = false;
                        for (Iterator<AppleScriptComponentName> it = result.iterator(); it.hasNext(); ) {
                            AppleScriptComponentName ourAddedComponent = it.next();
                            if (ourAddedComponent.getName() != null && ourAddedComponent.getName().equals(currentComponent.getName())) {
                                duplicatedDeclaration = true;
                                if (ourAddedComponent.getTextOffset() > currentComponent.getTextOffset()) {
                                    it.remove(); //not called
                                    duplicatedDeclarationRemoved = true;
                                } //remove if currentComponent declared earlier, will add it later
                            }
                        }
                        if (!duplicatedDeclaration || duplicatedDeclarationRemoved) {
                            result.add(currentComponent);
                        }
                    } else {
                        List<AppleScriptComponentName> currentComponentNameList = null;
                        if (targetComponentClass instanceof AppleScriptTargetListLiteral) {
                            AppleScriptTargetListLiteral targetList = (AppleScriptTargetListLiteral) targetComponentClass;
                            currentComponentNameList = targetList.getComponentNameList();
                        } else if (targetComponentClass instanceof AppleScriptTargetRecordLiteral) {
                            AppleScriptTargetRecordLiteral targetRecord = (AppleScriptTargetRecordLiteral) targetComponentClass;
                            currentComponentNameList = targetRecord.getComponentNameList();
                        }
                        if (currentComponentNameList != null && !currentComponentNameList.isEmpty()) {
                            for (AppleScriptComponentName currentComponent : currentComponentNameList) {
                                boolean duplicatedDeclaration = false;
                                boolean duplicatedDeclarationRemoved = false;
                                for (Iterator<AppleScriptComponentName> it = result.iterator(); it.hasNext(); ) {
                                    AppleScriptComponentName ourAddedComponent = it.next();
                                    if (ourAddedComponent.getName() != null && ourAddedComponent.getName().equals(currentComponent.getName())) {
                                        duplicatedDeclaration = true;
                                        if (ourAddedComponent.getTextOffset() > currentComponent.getTextOffset()) {
                                            it.remove(); //not called
                                            duplicatedDeclarationRemoved = true;
                                        } //remove if currentComponent declared earlier, will add it later
                                    }
                                }
                                if (!duplicatedDeclaration || duplicatedDeclarationRemoved) {
                                    result.add(currentComponent);
                                }
                            }
                        }
                    }
                } else if (child instanceof AppleScriptBlockBody
                        && !(context instanceof AppleScriptIfCompoundStatement)) // do not scan other inner blocks of if statement
                {
                    processTopDeclarations(child, result, false);//we do not need a recursion
                } else if (child instanceof AppleScriptComponentName) {
                    result.add((AppleScriptComponentName) child);
                }
            }
        }
        for (AppleScriptComponentName componentName : result) {
            if (!processor.execute(componentName, state)) {
                return false;//todo may be return true?
            }
        }
        return true;
    }

    @Override
    public boolean processDeclarations(@NotNull PsiScopeProcessor processor,
                                       @NotNull ResolveState state,
                                       PsiElement lastParent,
                                       @NotNull PsiElement place) {

        return processDeclarationsImpl(this, processor, state, lastParent)
                && super.processDeclarations(processor, state, lastParent, place);
    }

    @Override
    public void delete() throws IncorrectOperationException {
        super.delete();
    }
}
