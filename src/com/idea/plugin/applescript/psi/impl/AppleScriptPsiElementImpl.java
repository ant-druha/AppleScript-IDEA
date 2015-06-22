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
 * <p/>
 */
public class AppleScriptPsiElementImpl extends ASTWrapperPsiElement implements AppleScriptPsiElement {
  public AppleScriptPsiElementImpl(ASTNode node) {
    super(node);
  }

  public static boolean processDeclarationsImpl(@Nullable PsiElement context, PsiScopeProcessor processor,
                                                ResolveState state, @Nullable
                                                PsiElement lastParent, @Nullable final PsiElement referencingElement) {
    if (context == null) {
      return true;
    }
    final PsiElement[] children = context.getChildren();
    final Set<AppleScriptComponent> result = new THashSet<AppleScriptComponent>();
    for (PsiElement child : children) {
      if (child == lastParent && child instanceof AppleScriptBlockBody)//todo extract condition=>"stop at last parent"
        continue;

      //not components first
      if (child instanceof AppleScriptVarDeclarationList) {
        AppleScriptVarDeclarationList varList = (AppleScriptVarDeclarationList) child;
        result.add(varList.getVarAccessDeclaration());
        result.addAll(varList.getVarDeclarationListPartList());
      } else if (child instanceof AppleScriptFormalParameterList) {
        AppleScriptFormalParameterList parameterList = (AppleScriptFormalParameterList) child;
        List<AppleScriptComponent> cmList = parameterList.getTargetVariableComponentListRecursive();
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
//          addFromAssignmentStatementWithFilter(result, assignmentStmt, referencingElement);
      } else if (child instanceof AppleScriptComponent) {
        result.add((AppleScriptComponent) child);
      }
    }

    for (AppleScriptComponent component : result) {
      if (referencingElement != null && isCanBeReferenced(referencingElement, component)) {//do not process
        // declarations below
        if (!processor.execute(component, state)) {
          return false;
        }
      } else if (referencingElement == null) {
        if (!processor.execute(component, state)) {
          return false;
        }
      }
    }
    return true;
  }

  private static boolean isCanBeReferenced(@NotNull PsiElement referencingElement,
                                           @NotNull AppleScriptComponent component) {
    //todo handle other declarations besides simple reference elements (inside object references etc)
    return referencingElement instanceof AppleScriptObjectPropertyDeclaration
            || AppleScriptPsiImplUtil.isBefore(component, referencingElement, true);
  }

  private static void addFromAssignmentStatementWithFilter(Set<AppleScriptComponent> result,
                                                           AppleScriptAssignmentStatement
                                                                   creationStatement, PsiElement referencingElement) {
    List<AppleScriptTargetVariable> assignmentTargets = creationStatement.getTargets();
    if (!assignmentTargets.isEmpty()) {
      addCheckingDuplicates(result, assignmentTargets, referencingElement);
//      addTheMostRecentDefinition(result, assignmentTargets, referencingElement);
    }
  }

  private static void addCheckingDuplicates(Set<AppleScriptComponent> result, List<AppleScriptTargetVariable>
          currentTargetComponentList, PsiElement referencingElement) {
    for (AppleScriptTargetVariable targetVariable : currentTargetComponentList) {
      boolean duplicatedDeclaration = false;
      boolean duplicatedDeclarationRemoved = false;
      for (Iterator<AppleScriptComponent> it = result.iterator(); it.hasNext(); ) {
        AppleScriptComponent ourAddedComponent = it.next();
        if (ourAddedComponent.getContainingFile() == targetVariable.getContainingFile()//only for local file
                && ourAddedComponent.getName() != null
                && ourAddedComponent.getName().equals(targetVariable.getName())) {
          duplicatedDeclaration = true;
          if (ourAddedComponent.getTextOffset() > targetVariable.getTextOffset()) {
            it.remove(); //not called
            duplicatedDeclarationRemoved = true;
          } //remove if targetVariable declared earlier, will add it later
        }
      }
      if (!duplicatedDeclaration || duplicatedDeclarationRemoved) {
        result.add(targetVariable);
      }
    }
  }

  private static void addTheMostRecentDefinition(Set<AppleScriptComponent> result, List<AppleScriptTargetVariable>
          currentTargetComponentList, @Nullable PsiElement referencingElement) {
    for (AppleScriptTargetVariable targetVariable : currentTargetComponentList) {
      boolean duplicatedDeclaration = false;
      boolean duplicatedDeclarationRemoved = false;
      for (Iterator<AppleScriptComponent> it = result.iterator(); it.hasNext(); ) {
        AppleScriptComponent ourAddedComponent = it.next();
        if (ourAddedComponent.getContainingFile() == targetVariable.getContainingFile()//only for local file
                && ourAddedComponent.getName() != null
                && ourAddedComponent.getName().equals(targetVariable.getName())) {
          duplicatedDeclaration = true;
          if (referencingElement != null && referencingElement.getTextOffset() - ourAddedComponent.getTextOffset() >
                  referencingElement.getTextOffset() - targetVariable.getTextOffset()) {
            it.remove(); //not called
            duplicatedDeclarationRemoved = true;//remove if added component defined higher from referencing element
          }
        }
      }
      if (!duplicatedDeclaration || duplicatedDeclarationRemoved) {
        result.add(targetVariable);
      }
    }
  }

  @Override
  public boolean processDeclarations(@NotNull PsiScopeProcessor processor, @NotNull ResolveState state, PsiElement
          lastParent, @NotNull PsiElement place) {

    return processDeclarationsImpl(this, processor, state, lastParent, place) && super.processDeclarations(processor,
            state,
            lastParent, place);
  }

  @Override
  public void delete() throws IncorrectOperationException {
    super.delete();
  }
}
