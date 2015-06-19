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

import java.util.ArrayList;
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

  public static void processTopDeclarations(@NotNull PsiElement context, final Set<AppleScriptComponent> result,
                                            boolean recursively) {
    final PsiElement[] children = context.getChildren();

    for (PsiElement child : children) {
      if (child instanceof AppleScriptVarDeclarationList) {
        AppleScriptVarDeclarationList varList = (AppleScriptVarDeclarationList) child;
        result.add(varList.getVarAccessDeclaration());
        for (AppleScriptVarDeclarationListPart listPart : varList.getVarDeclarationListPartList()) {
          result.add(listPart);
        }
      } else if (child instanceof AppleScriptLabeledParameterDeclarationList) {
        AppleScriptLabeledParameterDeclarationList params = (AppleScriptLabeledParameterDeclarationList) child;
        result.addAll(params.getComponentList());
      } else if (child instanceof AppleScriptObjectPropertyTargetDeclaration
              && (child.getContext() instanceof AppleScriptHandlerLabeledParametersDefinition
              || child.getContext() instanceof AppleScriptHandler)) {
        AppleScriptObjectPropertyTargetDeclaration prop = (AppleScriptObjectPropertyTargetDeclaration) child;
        result.add(prop.getTargetVariable());
      } else if (child instanceof AppleScriptAssignmentStatement) {
        addFromAssignmentStatement(result, (AppleScriptAssignmentStatement) child);
      } else if (recursively && child instanceof AppleScriptBlockBody && !(context instanceof
              AppleScriptIfCompoundStatement)) { // do not scan other inner blocks of if statement
        processTopDeclarations(child, result, true);
      } else if (child instanceof AppleScriptObject) {
        result.add(((AppleScriptObject) child));
        if (recursively) {
          processTopDeclarations(child, result, true);
        }
      } else if (child instanceof AppleScriptComponent) {
        result.add((AppleScriptComponent) child);
      }
    }
  }

  public static boolean processDeclarationsImpl(@Nullable PsiElement context, PsiScopeProcessor processor,
                                                ResolveState state, @Nullable
                                                PsiElement lastParent) {
    if (context == null) {
      return true;
    }
    final PsiElement[] children = context.getChildren();
    final Set<AppleScriptComponent> result = new THashSet<AppleScriptComponent>();
    for (PsiElement child : children) {
      // todo simplify: if element is a component -> add it (just check is it is not a handlerSelectorIdentifier)
      // todo simplify: and handle other elements which are not components but which contain components (assignment
      // statement etc)
      if (child != lastParent) {
        //not components first
        if (child instanceof AppleScriptVarDeclarationList) { //+
          AppleScriptVarDeclarationList varList = (AppleScriptVarDeclarationList) child;
          result.add(varList.getVarAccessDeclaration());
          result.addAll(varList.getVarDeclarationListPartList());
        }else if (child instanceof AppleScriptFormalParameterList) {//+
          AppleScriptFormalParameterList parameterList = (AppleScriptFormalParameterList) child;
          List<AppleScriptComponent> cmList = parameterList.getTargetVariableComponentListRecursive();
          if (!cmList.isEmpty()) {
            result.addAll(cmList);
          }
        } else if (child instanceof AppleScriptLabeledParameterDeclarationList) {//+
          AppleScriptLabeledParameterDeclarationList params = (AppleScriptLabeledParameterDeclarationList) child;
          result.addAll(params.getComponentList());
        } else if (child instanceof AppleScriptObjectPropertyTargetDeclaration
                && (child.getContext() instanceof AppleScriptHandlerLabeledParametersDefinition//+ but why only
                // labeled params??
                || child.getContext() instanceof AppleScriptHandler)) {
          //this is in target list/record literals
          AppleScriptObjectPropertyTargetDeclaration prop = (AppleScriptObjectPropertyTargetDeclaration) child;
          AppleScriptTargetVariable var = prop.getTargetVariable();
          if (var != null) {
            result.add(var);
          }
        } else if (child instanceof AppleScriptAssignmentStatement) {//+
          addFromAssignmentStatement(result, (AppleScriptAssignmentStatement) child);
        } else if (child instanceof AppleScriptBlockBody && !(context instanceof AppleScriptIfCompoundStatement)) //???
        // do not scan other inner blocks of if statement
        {
          processTopDeclarations(child, result, false);//we do not need a recursion
        } else if (child instanceof AppleScriptComponent) {//+
          result.add((AppleScriptComponent) child);
        }

      }
    }
    for (AppleScriptComponent component : result) {
      if (!processor.execute(component, state)) {
        return false;
      }
    }
    return true;
  }

  private static void addFromAssignmentStatement(Set<AppleScriptComponent> result, AppleScriptAssignmentStatement
          creationStatement) {
    AppleScriptPsiElement assignmentTargetClass = creationStatement.getAssignmentTarget();
    if (assignmentTargetClass instanceof AppleScriptTargetVariable) {
      AppleScriptComponent currentComponent = ((AppleScriptTargetVariable) assignmentTargetClass);
      boolean duplicatedDeclaration = false;
      boolean duplicatedDeclarationRemoved = false;
      for (Iterator<AppleScriptComponent> it = result.iterator(); it.hasNext(); ) {
        AppleScriptComponent ourAddedComponent = it.next();
        if (ourAddedComponent.getName() != null && ourAddedComponent.getName().equals(currentComponent.getName
                ())) {
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
      List<AppleScriptComponent> currentTargetComponentList = new ArrayList<AppleScriptComponent>();
      if (assignmentTargetClass instanceof AppleScriptTargetListLiteral) {
        AppleScriptTargetListLiteral targetList = (AppleScriptTargetListLiteral) assignmentTargetClass;
        for (AppleScriptTargetVariable targetVariable : targetList.getTargetVariableListRecursive()) {
          currentTargetComponentList.add(targetVariable);
        }
      } else if (assignmentTargetClass instanceof AppleScriptTargetRecordLiteral) {
        AppleScriptTargetRecordLiteral targetRecord = (AppleScriptTargetRecordLiteral) assignmentTargetClass;
        for (AppleScriptTargetVariable targetVariable : targetRecord.getTargetVariableListRecursive()) {
          currentTargetComponentList.add(targetVariable);
        }
      }
      if (!currentTargetComponentList.isEmpty()) {
        //check for duplicates
        for (AppleScriptComponent currentComponent : currentTargetComponentList) {
          boolean duplicatedDeclaration = false;
          boolean duplicatedDeclarationRemoved = false;
          for (Iterator<AppleScriptComponent> it = result.iterator(); it.hasNext(); ) {
            AppleScriptComponent ourAddedComponent = it.next();
            if (ourAddedComponent.getName() != null && ourAddedComponent.getName().equals(currentComponent
                    .getName())) {
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
  }

  @Override
  public boolean processDeclarations(@NotNull PsiScopeProcessor processor, @NotNull ResolveState state, PsiElement
          lastParent, @NotNull PsiElement place) {

    return processDeclarationsImpl(this, processor, state, lastParent) && super.processDeclarations(processor, state,
            lastParent, place);
  }

  @Override
  public void delete() throws IncorrectOperationException {
    super.delete();
  }
}
