package com.intellij.plugin.applescript.lang.ide.structure;

import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.structureView.impl.common.PsiTreeElementBase;
import com.intellij.navigation.ItemPresentation;
import com.intellij.plugin.applescript.AppleScriptFile;
import com.intellij.plugin.applescript.lang.resolve.AppleScriptComponentScopeProcessor;
import com.intellij.plugin.applescript.lang.resolve.AppleScriptResolveUtil;
import com.intellij.plugin.applescript.psi.*;
import com.intellij.plugin.applescript.psi.impl.AppleScriptPsiElementImpl;
import com.intellij.psi.NavigatablePsiElement;
import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import gnu.trove.THashSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Andrey 03.05.2015
 */
public class AppleScriptStructureViewElement extends PsiTreeElementBase<NavigatablePsiElement> implements ItemPresentation,
    StructureViewTreeElement {

  private boolean isRoot = false;

  AppleScriptStructureViewElement(@NotNull final NavigatablePsiElement element) {
    super(element);
    isRoot = false;
  }

  private AppleScriptStructureViewElement(NavigatablePsiElement element, boolean isRootElement) {
    super(element);
    this.isRoot = isRootElement;
  }

  @NotNull
  @Override
  public Collection<StructureViewTreeElement> getChildrenBase() {
    final NavigatablePsiElement element = getElement();
    final List<StructureViewTreeElement> result = new ArrayList<>();
    THashSet<AppleScriptComponent> myComponents = new THashSet<>();
    if (element != null && element instanceof AppleScriptFile) {
      if (!isRoot) {
        result.add(new AppleScriptStructureViewElement(element, true));
      }
      AppleScriptPsiElementImpl
          .processDeclarationsImpl(element, new AppleScriptComponentScopeProcessor(myComponents), ResolveState.initial(), null, null);
    } else if (element instanceof AppleScriptScriptObject) {
      List<AppleScriptComponent> myScriptComponents = AppleScriptResolveUtil.getNamedSubComponentsFor((AppleScriptScriptObject) element);
      myComponents.addAll(myScriptComponents);
    }

    for (AppleScriptComponent component : myComponents) {
      if (component instanceof AppleScriptHandlerPositionalParametersDefinition) {
        result.add(new AppleScriptStructureViewElement(component));
      } else if (component instanceof AppleScriptScriptPropertyDeclaration) {
        result.add(new AppleScriptStructureViewElement(component));
      } else if (component instanceof AppleScriptVarAccessDeclaration || component instanceof AppleScriptVarDeclarationListPart) {
        result.add(new AppleScriptStructureViewElement(component));
      } else if (component instanceof AppleScriptScriptObject && component != element) {
        result.add(new AppleScriptStructureViewElement(component, true));
      } else if (component instanceof AppleScriptHandler) {
        result.add(new AppleScriptStructureViewElement(component));
      } else if (component.getName() != null
          && !(component instanceof AppleScriptHandlerInterleavedParametersSelectorPart)//todo remove
          && component != element) {
        result.add(new AppleScriptStructureViewElement(component));
      }
    }

    result.sort((o1, o2) -> {
      PsiElement element1, element2;
      if (o1 instanceof AppleScriptStructureViewElement && o2 instanceof AppleScriptStructureViewElement) {
        element1 = ((AppleScriptStructureViewElement) o1).getElement();
        element2 = ((AppleScriptStructureViewElement) o2).getElement();
        if (element1 != null && element2 != null) {
          return element1.getTextOffset() - element2.getTextOffset();
        }
      }
      return 0;
    });

    return result;
  }

  @Nullable
  @Override
  public String getPresentableText() {
    final NavigatablePsiElement element = getElement();
    final ItemPresentation presentation = element == null ? null : element.getPresentation();
    return presentation == null ? null : presentation.getPresentableText();
  }
}
