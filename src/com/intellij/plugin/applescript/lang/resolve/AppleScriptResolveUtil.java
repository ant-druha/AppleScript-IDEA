package com.intellij.plugin.applescript.lang.resolve;

import com.intellij.openapi.util.Condition;
import com.intellij.plugin.applescript.psi.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementResolveResult;
import com.intellij.psi.ResolveResult;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.containers.ContainerUtil;
import com.intellij.util.containers.SortedList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Andrey 15.04.2015
 */
public class AppleScriptResolveUtil {

  @NotNull
  public static ResolveResult[] toCandidateInfoArray(@Nullable List<? extends PsiElement> elements) {
    if (elements == null) {
      return ResolveResult.EMPTY_ARRAY;
    }
    elements = ContainerUtil.filter(elements, new Condition<PsiElement>() {
      @Override
      public boolean value(PsiElement element) {
        return element != null;
      }
    });
    final ResolveResult[] result = new ResolveResult[elements.size()];
    for (int i = 0, size = elements.size(); i < size; i++) {
      result[i] = new PsiElementResolveResult(elements.get(i));
    }
    return result;
  }

  //todo move to ScriptObject and simplify variables extraction
  @NotNull
  public static List<AppleScriptComponent> getNamedSubComponentsFor(@NotNull AppleScriptScriptObject script) {
    List<AppleScriptComponent> result = new ArrayList<AppleScriptComponent>();
    AppleScriptScriptBody scriptBody = script.getScriptBody();
    AppleScriptComponent[] namedComponents = PsiTreeUtil.getChildrenOfType(scriptBody, AppleScriptComponent.class);
    AppleScriptAssignmentStatement[] varsCreations = PsiTreeUtil.getChildrenOfType(scriptBody,
            AppleScriptAssignmentStatement.class);
    AppleScriptVarDeclarationList[] varsDeclarations = PsiTreeUtil.getChildrenOfType(scriptBody,
            AppleScriptVarDeclarationList.class);

    if (namedComponents != null) {
      result.addAll(Arrays.asList(namedComponents));
    }
    if (varsCreations != null) {
      for (AppleScriptAssignmentStatement variable : varsCreations) {
        result.addAll(variable.getTargets());
      }
    }
    if (varsDeclarations != null) {
      for (AppleScriptVarDeclarationList declarationList : varsDeclarations) {
        AppleScriptComponent[] vars = PsiTreeUtil.getChildrenOfType(declarationList, AppleScriptComponent.class);
        if (vars != null) {
          result.addAll(Arrays.asList(vars));
        }
      }
    }
    return result;
  }

  @NotNull
  public static SortedList<PsiElement> getTellStatementResolveScope(PsiElement myElement) {
    SortedList<PsiElement> resultList = new SortedList<PsiElement>(new Comparator<PsiElement>() {
      @Override
      public int compare(PsiElement e1, PsiElement e2) {
        return e2.getTextOffset() - e1.getTextOffset();
      }
    });
    PsiElement tellStatement = myElement;
    while (tellStatement != null) {
      tellStatement = tellStatement.getParent();
      if (tellStatement instanceof AppleScriptTellSimpleStatement
              || tellStatement instanceof AppleScriptTellCompoundStatement) {
        resultList.add(tellStatement);
      }
    }
    return resultList;
  }

  @Nullable
  public static PsiElement getTellStatementScope(PsiElement myElement) {
    PsiElement tellStatement = myElement;
    while (tellStatement != null) {
      tellStatement = tellStatement.getParent();
      if (tellStatement instanceof AppleScriptTellSimpleStatement
              || tellStatement instanceof AppleScriptTellCompoundStatement) {
        return tellStatement;
      }
    }
    return null;
  }
}
