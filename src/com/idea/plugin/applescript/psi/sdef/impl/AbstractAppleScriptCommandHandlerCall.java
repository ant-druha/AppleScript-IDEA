package com.idea.plugin.applescript.psi.sdef.impl;

import com.idea.plugin.applescript.lang.ide.libraries.ScriptSuiteRegistry;
import com.idea.plugin.applescript.lang.ide.libraries.ScriptSuiteRegistryMappings;
import com.idea.plugin.applescript.lang.parser.ParsableScriptSuiteRegistryHelper;
import com.idea.plugin.applescript.lang.resolve.AppleScriptResolveUtil;
import com.idea.plugin.applescript.lang.sdef.AppleScriptCommand;
import com.idea.plugin.applescript.psi.*;
import com.idea.plugin.applescript.psi.impl.AppleScriptPsiElementImpl;
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
        implements AppleScriptCommandHandlerCall, AppleScriptExpression {

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

  //todo do not implement this? - do not define as expression?
  @Nullable
  @Override
  public AppleScriptApplicationObjectReference getApplicationObjectReference() {
    return null;
  }

  @Nullable
  @Override
  public AppleScriptApplicationReference getApplicationReference() {
    return null;
  }

  @Nullable
  @Override
  public AppleScriptArbitraryReferenceD getArbitraryReferenceD() {
    return null;
  }

  @Nullable
  @Override
  public AppleScriptEveryElemReferenceD getEveryElemReferenceD() {
    return null;
  }

  @NotNull
  @Override
  public List<AppleScriptExpression> getExpressionList() {
    return null;
  }

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
  public AppleScriptIndexReferenceD getIndexReferenceD() {
    return null;
  }

  @Nullable
  @Override
  public AppleScriptMiddleElemReferenceD getMiddleElemReferenceD() {
    return null;
  }

  @Nullable
  @Override
  public AppleScriptNameReferenceD getNameReferenceD() {
    return null;
  }

  @Nullable
  @Override
  public AppleScriptObjectRef getObjectRef() {
    return null;
  }

  @Nullable
  @Override
  public AppleScriptPropertyReferenceD getPropertyReferenceD() {
    return null;
  }

  @Nullable
  @Override
  public AppleScriptRangeReferenceD getRangeReferenceD() {
    return null;
  }

  @Nullable
  @Override
  public AppleScriptReferenceIdentifier getReferenceIdentifier() {
    return null;
  }

  @Nullable
  @Override
  public AppleScriptRelativeReferenceD getRelativeReferenceD() {
    return null;
  }

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
      ScriptSuiteRegistryMappings registryMappings = ScriptSuiteRegistryMappings.getInstance(containingFile
              .getProject());
      ScriptSuiteRegistry suiteRegistry = registryMappings.getMapping(containingFile.getVirtualFile());
      String commandName = getCommandName();
      final List<AppleScriptCommand> allCommandsWithName = suiteRegistry != null ? suiteRegistry.
              findAllCommandsWithName(commandName) :
              ParsableScriptSuiteRegistryHelper.getAllCommandsWithName(commandName);
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
