package com.idea.plugin.applescript.psi.sdef.impl;

import com.idea.plugin.applescript.psi.AppleScriptDirectParameterVal;
import com.idea.plugin.applescript.psi.impl.AppleScriptExpressionImpl;
import com.idea.plugin.applescript.psi.sdef.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Created by Andrey on 16.08.2015.
 */
public class AbstractAppleScriptCommandHandlerCall extends AppleScriptExpressionImpl//AppleScriptPsiElementImpl
        implements AppleScriptCommandHandlerCall {

  public AbstractAppleScriptCommandHandlerCall(ASTNode node) {
    super(node);
  }

  @NotNull
  @Override
  public DictionaryReference getReference() {
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
  //not implement expression ??


  private class CommandHandlerReference extends AbstractDictionaryReferenceElement implements DictionaryReference {

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
    protected DictionaryCompositeElement getMyElement() {
      return AbstractAppleScriptCommandHandlerCall.this;
    }
  }
}
