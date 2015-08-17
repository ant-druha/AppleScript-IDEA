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
import com.idea.plugin.applescript.psi.sdef.AppleScriptCommandName;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.intellij.psi.impl.source.resolve.reference.impl.PsiPolyVariantCachingReference;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrey on 16.08.2015.
 */
public class AbstractAppleScriptCommandHandlerCall extends AppleScriptPsiElementImpl implements
        AppleScriptCommandHandlerCall, AppleScriptExpression {

  private CommandHandlerReference myReference;

  public AbstractAppleScriptCommandHandlerCall(ASTNode node) {
    super(node);
    myReference = new CommandHandlerReference();
  }

  @Override
  public PsiReference getReference() {
    return myReference;
  }

  @NotNull
  @Override
  public AppleScriptCommandName getCommandNameElement() {
    return PsiTreeUtil.getChildOfType(this, AppleScriptCommandName.class);
  }

  @NotNull
  @Override
  public String getCommandName() {
    //todo change to iteration over identifiers
    return getCommandNameElement().getText();
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

  @Nullable
  @Override
  public AppleScriptExpression getExpression() {
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

  @NotNull
  @Override
  public List<AppleScriptHandlerPositionalParametersCall> getHandlerPositionalParametersCallList() {
    List<AppleScriptHandlerPositionalParametersCall> result = new
            ArrayList<AppleScriptHandlerPositionalParametersCall>();
    return result;
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

  private class CommandHandlerReference extends PsiPolyVariantCachingReference implements MultiRangeReference,
          PsiPolyVariantReference {

    @NotNull
    @Override
    public List<TextRange> getRanges() {
      // return ranges of command name + all command parameter -> parameter selector
      //should match getCanonicalText() call
      List<TextRange> result = new ArrayList<TextRange>();
      final int parentOffset = -getElement().getTextRange().getStartOffset();
      for (AppleScriptIdentifier id : getCommandNameElement().getIdentifiers()) {
        TextRange argumentRange = id.getTextRange();
        if (!argumentRange.isEmpty()) {
          result.add(argumentRange.shiftRight(parentOffset));
        }
      }
      return result;
    }

    @Override
    public boolean isReferenceTo(PsiElement element) {
      PsiElement target = resolve();
      if (element instanceof AppleScriptCommandHandlerCall && target != null) {
        AppleScriptCommandHandlerCall thatHandler = (AppleScriptCommandHandlerCall) element;
//        thatHandler.getCommandName().equals(getCommandName());
//        return getHandlerSelector().equals(thatHandler.getSelector());
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
      final List<AppleScriptCommand> allCommandsWithName = suiteRegistry != null ? suiteRegistry.
              getAllCommandsWithName(getCommandName()) :
              ParsableScriptSuiteRegistryHelper.getAllCommandsWithName(getCommandName());
      AppleScriptCommand result = null;
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
      return command != null;

    }

    @Override
    public PsiElement getElement() {
      return AbstractAppleScriptCommandHandlerCall.this;
    }

    @Override
    public TextRange getRangeInElement() {
      return ReferenceRange.getRange(this);
    }

    @NotNull
    @Override
    public String getCanonicalText() {
      return getCommandNameElement().getText();
    }

    @Override
    public PsiElement handleElementRename(String newElementName) throws IncorrectOperationException {
      return null;
    }

    @Override
    public PsiElement bindToElement(@NotNull PsiElement element) throws IncorrectOperationException {
      return null;
    }

    @NotNull
    @Override
    public Object[] getVariants() {
      return new Object[0];
    }
  }
}
