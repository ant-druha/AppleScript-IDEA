package com.idea.plugin.applescript.psi.sdef.impl;

import com.idea.plugin.applescript.lang.ide.sdef.AppleScriptProjectDictionaryRegistry;
import com.idea.plugin.applescript.lang.resolve.AppleScriptResolveUtil;
import com.idea.plugin.applescript.lang.sdef.AppleScriptCommand;
import com.idea.plugin.applescript.lang.sdef.ApplicationDictionary;
import com.idea.plugin.applescript.psi.*;
import com.idea.plugin.applescript.psi.impl.AppleScriptPsiElementImpl;
import com.idea.plugin.applescript.psi.impl.AppleScriptPsiImplUtil;
import com.idea.plugin.applescript.psi.sdef.AppleScriptCommandHandlerCall;
import com.idea.plugin.applescript.psi.sdef.AppleScriptCommandHandlerParameter;
import com.idea.plugin.applescript.psi.sdef.DictionaryCompositeElement;
import com.idea.plugin.applescript.psi.sdef.DictionaryCompositeName;
import com.intellij.lang.ASTNode;
import com.intellij.psi.*;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrey on 16.08.2015.
 */
public class AbstractAppleScriptCommandHandlerCall extends AppleScriptPsiElementImpl//AppleScriptPsiElementImpl
        implements AppleScriptCommandHandlerCall {

  public AbstractAppleScriptCommandHandlerCall(ASTNode node) {
    super(node);
  }

  @NotNull
  @Override
  public PsiReference getReference() {
    return new CommandHandlerReference();
  }

  @NotNull
  @Override
  public DictionaryCompositeName getCompositeNameElement() {
    return PsiTreeUtil.getRequiredChildOfType(this, DictionaryCompositeName.class);
  }


  @NotNull
  @Override
  public String getCommandName() {
    return getCompositeNameElement().getCompositeName();
  }

  @Nullable
  @Override
  public PsiElement getDirectParameter() {
    return PsiTreeUtil.getChildOfType(this, AppleScriptDirectParameterVal.class);
  }

  @Nullable
  @Override
  public List<AppleScriptCommandHandlerParameter> getCommandParameters() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptCommandHandlerParameter.class);
  }

  @Nullable
//  @Override
  public AppleScriptApplicationReference getApplicationReference() {
    return null;
  }

  @Nullable
  @Override
  public AppleScriptArbitraryReference getArbitraryReference() {
    return null;
  }

  @Nullable
  @Override
  public AppleScriptBuiltInClassIdentifier getBuiltInClassIdentifier() {
    return null;
  }

  @Nullable
  @Override
  public AppleScriptBuiltInClassIdentifierPlural getBuiltInClassIdentifierPlural() {
    return null;
  }

  @Nullable
  @Override
  public AppleScriptDictionaryClassIdentifierPlural getDictionaryClassIdentifierPlural() {
    return null;
  }

  @Nullable
  @Override
  public AppleScriptDictionaryClassName getDictionaryClassName() {
    return null;
  }


  @Nullable
  @Override
  public AppleScriptDictionaryConstant getDictionaryConstant() {
    return null;
  }

  @Nullable
  @Override
  public AppleScriptEveryElemReference getEveryElemReference() {
    return null;
  }

  @Nullable
  @Override
  public AppleScriptEveryRangeReference getEveryRangeReference() {
    return null;
  }

  @Nullable
  @Override
  public AppleScriptExpression getExpression() {
    return null;
  }

//  @NotNull
//  @Override
//  public List<AppleScriptExpression> getExpressionList() {
//    return null;
//  }


  @Nullable
  @Override
  public AppleScriptFileReference getFileReference() {
    return null;
  }

  @Nullable
  @Override
  public AppleScriptFilterReference getFilterReference() {
    return null;
  }

  @Nullable
  @Override
  public AppleScriptHandlerInterleavedParametersCall getHandlerInterleavedParametersCall() {
    return null;
  }

  @Nullable
  @Override
  public AppleScriptHandlerLabeledParametersCall getHandlerLabeledParametersCall() {
    return null;
  }

  @Nullable
  @Override
  public AppleScriptIndexReference getIndexReference() {
    return null;
  }

  @Nullable
  @Override
  public AppleScriptIndexReferenceClassForm getIndexReferenceClassForm() {
    return null;
  }

  @Nullable
  @Override
  public AppleScriptMiddleElemReference getMiddleElemReference() {
    return null;
  }

  @Nullable
  @Override
  public AppleScriptNameReference getNameReference() {
    return null;
  }

  @Nullable
  @Override
  public AppleScriptPropertyReference getPropertyReference() {
    return null;
  }

  @Nullable
  @Override
  public AppleScriptRangeFromReference getRangeFromReference() {
    return null;
  }

  @Nullable
  @Override
  public AppleScriptRangeIndexReference getRangeIndexReference() {
    return null;
  }

  @Nullable
  @Override
  public AppleScriptReferenceIdentifier getReferenceIdentifier() {
    return null;
  }

  @Nullable
  @Override
  public AppleScriptRelativeReference getRelativeReference() {
    return null;
  }

  @Nullable
  @Override
  public PsiElement getStringLiteral() {
    return null;
  }

  //not implement expression ??


  private class CommandHandlerReference extends AbstractDictionaryReferenceElement implements MultiRangeReference,
          PsiPolyVariantReference {

    @Override
    public boolean isReferenceTo(PsiElement element) {
      PsiElement target = resolve();
      if (element instanceof AppleScriptCommandHandlerCall && target != null) {
        AppleScriptCommandHandlerCall thatHandler = (AppleScriptCommandHandlerCall) element;
        return target == thatHandler;
      }
      return super.isReferenceTo(element);
    }

    @NotNull
    @Override
    protected ResolveResult[] resolveInner(boolean incompleteCode, @NotNull PsiFile containingFile) {
      String commandName = getCommandName();
      List<AppleScriptCommand> allCommandsWithName = null;
      List<String> applicationNames = AppleScriptPsiImplUtil
              .getApplicationNameForElementInsideTellStatement(getMyElement());
      AppleScriptProjectDictionaryRegistry projectDictionaryRegistry = getProject()
              .getComponent(AppleScriptProjectDictionaryRegistry.class);
      ApplicationDictionary appDictionary = null;
      for (String appName : applicationNames) {

        if (appName != null) {
          if (projectDictionaryRegistry != null) {
            appDictionary = projectDictionaryRegistry.getDictionary(appName);
            if (appDictionary == null) {
              appDictionary = projectDictionaryRegistry.createDictionary(appName);
            }
          }
          if (appDictionary != null) {
            if (allCommandsWithName == null)
              allCommandsWithName = appDictionary.findAllCommandsWithName(commandName);
            else
              allCommandsWithName.addAll(appDictionary.findAllCommandsWithName(commandName));
          }
        }
      }
      if (allCommandsWithName == null || allCommandsWithName.isEmpty()) {
        allCommandsWithName = new ArrayList<AppleScriptCommand>();
        if (projectDictionaryRegistry != null) {
          for (ApplicationDictionary stdDictionary : projectDictionaryRegistry.getStandardDictionaries()) {
            List<AppleScriptCommand> commandList = stdDictionary.findAllCommandsWithName(commandName);
            allCommandsWithName.addAll(commandList);
          }
        }
      }
      if (allCommandsWithName.isEmpty()) return ResolveResult.EMPTY_ARRAY;

      final List<PsiElement> results = new ArrayList<PsiElement>();
      for (AppleScriptCommand command : allCommandsWithName) {
        if (resolveCommandInner(command)) {
          results.add(command);
          break;
        }
      }
      return AppleScriptResolveUtil.toCandidateInfoArray(results);
    }

    private boolean resolveCommandInner(AppleScriptCommand command) {
      //todo add checks for parameters
      return command != null;

    }

    @NotNull
    @Override
    protected DictionaryCompositeElement getMyElement() {
      return AbstractAppleScriptCommandHandlerCall.this;
    }
  }
}
