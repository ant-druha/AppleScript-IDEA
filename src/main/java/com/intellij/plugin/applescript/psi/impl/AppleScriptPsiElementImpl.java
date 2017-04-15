package com.intellij.plugin.applescript.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.plugin.applescript.psi.*;
import com.intellij.plugin.applescript.psi.sdef.ApplicationDictionaryDeclarator;
import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.PsiScopeProcessor;
import com.intellij.util.IncorrectOperationException;
import gnu.trove.THashSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Set;

/**
 * Created by Andrey on 14.04.2015.
 * <p/>
 */
public class AppleScriptPsiElementImpl extends ASTWrapperPsiElement implements AppleScriptPsiElement {
  public AppleScriptPsiElementImpl(ASTNode node) {
    super(node);
  }

  public static boolean processDeclarationsImpl(@Nullable PsiElement context, PsiScopeProcessor processor,
                                                ResolveState state, @Nullable PsiElement lastParent,
                                                @Nullable final PsiElement referencingElement) {
    if (context == null) {
      return true;
    }
    final PsiElement[] children = context.getChildren();
    final Set<AppleScriptPsiElement> result = new THashSet<>();
    for (PsiElement child : children) {
      if (child == lastParent && child instanceof AppleScriptBlockBody)//todo extract condition=>"stop at last parent"
        continue;

      //not components first
      if (child instanceof AppleScriptVarDeclarationList) {
        final AppleScriptVarDeclarationList varList = (AppleScriptVarDeclarationList) child;
        result.add(varList.getVarAccessDeclaration());
        result.addAll(varList.getVarDeclarationListPartList());
      } else if (child instanceof AppleScriptFormalParameterList) {
        AppleScriptFormalParameterList parameterList = (AppleScriptFormalParameterList) child;
        List<AppleScriptComponent> cmList = parameterList.getFormalParameters();
        if (!cmList.isEmpty()) {
          result.addAll(cmList);
        }
      } else if (child instanceof AppleScriptHandlerSelectorPart) {//todo to think if it make sense to make at as
        // todo component...
        AppleScriptHandlerSelectorPart parameterSelector = (AppleScriptHandlerSelectorPart) child;
        result.addAll(parameterSelector.findParameters());
      } else if (child instanceof AppleScriptLabeledParameterDeclarationList) {
        AppleScriptLabeledParameterDeclarationList params = (AppleScriptLabeledParameterDeclarationList) child;
        result.addAll(params.getComponentList());
      } else if (child instanceof AppleScriptObjectTargetPropertyDeclaration
          && (child.getContext() instanceof AppleScriptHandlerLabeledParametersDefinition//+ why not in handlers??
          || child.getContext() instanceof AppleScriptHandler)) {
        //this is in target list/record literals
        AppleScriptObjectTargetPropertyDeclaration prop = (AppleScriptObjectTargetPropertyDeclaration) child;
        AppleScriptTargetVariable var = prop.getTargetVariable();
        if (var != null) {
          result.add(var);
        }
      } else if (child instanceof AppleScriptAssignmentStatement) {
        AppleScriptAssignmentStatement assignmentStmt = (AppleScriptAssignmentStatement) child;
        result.addAll(assignmentStmt.getTargets());
      } else if (child instanceof AppleScriptComponent) {
        result.add((AppleScriptComponent) child);
      }
      //dictionary components
      else if (child instanceof AppleScriptUseStatement) { //is before is also checked lower
        AppleScriptUseStatement useStatement = (AppleScriptUseStatement) child;
        result.add(useStatement);
      }
    }
    //because of a scope of tell statements
    if (referencingElement != null) {
      if (context instanceof ApplicationDictionaryDeclarator && !(context instanceof AppleScriptUseStatement)) {
        result.add((ApplicationDictionaryDeclarator) context);
      }
    }

    for (AppleScriptPsiElement component : result) {
      if (referencingElement == null || canBeReferenced(referencingElement, component)) {//do not process
        if (!processor.execute(component, state)) {
          return false;
        }
      }
    }
    return true;
  }

  private static boolean canBeReferenced(@NotNull PsiElement referencingElement,
                                         @NotNull AppleScriptPsiElement component) {
    //todo handle other declarations besides simple reference elements (inside object references etc)

    boolean dictionaryElementMatches = component instanceof ApplicationDictionaryDeclarator
        && referencingElement instanceof AppleScriptPsiElement
        && AppleScriptPsiImplUtil.isBefore(component, referencingElement, true);//for getVariants()

    return referencingElement instanceof AppleScriptObjectPropertyDeclaration
        || referencingElement instanceof AppleScriptHandlerCall
        || referencingElement.getParent() instanceof AppleScriptHandlerPositionalParametersCallExpression
        || AppleScriptPsiImplUtil.isBefore(component, referencingElement, true)
        || dictionaryElementMatches;
  }

  @Override
  public boolean processDeclarations(@NotNull PsiScopeProcessor processor, @NotNull ResolveState state, PsiElement
      lastParent, @NotNull PsiElement place) {

    return processDeclarationsImpl(this, processor, state, lastParent, place)
        && super.processDeclarations(processor, state, lastParent, place);
  }

  @Override
  public void delete() throws IncorrectOperationException {
    super.delete();
  }
}
