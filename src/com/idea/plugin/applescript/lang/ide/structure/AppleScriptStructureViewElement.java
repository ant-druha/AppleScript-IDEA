package com.idea.plugin.applescript.lang.ide.structure;

import com.idea.plugin.applescript.AppleScriptFile;
import com.idea.plugin.applescript.lang.resolve.AppleScriptComponentScopeProcessor;
import com.idea.plugin.applescript.psi.*;
import com.idea.plugin.applescript.psi.impl.AppleScriptPsiElementImpl;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.structureView.impl.common.PsiTreeElementBase;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.NavigatablePsiElement;
import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import gnu.trove.THashSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

/**
 * Created by Andrey on 03.05.2015.
 */
public class AppleScriptStructureViewElement extends PsiTreeElementBase<NavigatablePsiElement>
        implements ItemPresentation, StructureViewTreeElement {

  private boolean isRoot = false;

  protected AppleScriptStructureViewElement(@NotNull final NavigatablePsiElement element) {
    super(element);
    isRoot = false;
  }

  public AppleScriptStructureViewElement(NavigatablePsiElement element, boolean isRootElement) {
    super(element);
    this.isRoot = isRootElement;
  }

  @NotNull
  @Override
  public Collection<StructureViewTreeElement> getChildrenBase() {
    final NavigatablePsiElement element = getElement();
    final List<StructureViewTreeElement> result = new ArrayList<StructureViewTreeElement>();
    if (element != null && element instanceof AppleScriptFile
            || element instanceof AppleScriptObject) {
      if (!isRoot) {
        result.add(new AppleScriptStructureViewElement(element, true));
        return result;
      }
      THashSet<AppleScriptComponent> myScriptComponents = new THashSet<AppleScriptComponent>();

      AppleScriptPsiElementImpl.processDeclarationsImpl(element, new AppleScriptComponentScopeProcessor
                      (myScriptComponents),
              ResolveState.initial(), null);
      for (AppleScriptComponent namedComponent : myScriptComponents) {
        if (namedComponent instanceof AppleScriptHandlerPositionalParametersDefinition) {
          result.add(new AppleScriptStructureViewElement(namedComponent));
        } else if (namedComponent instanceof AppleScriptPropertyDeclaration) {
          result.add(new AppleScriptStructureViewElement(namedComponent));
        } else if (namedComponent instanceof AppleScriptVarAccessDeclaration || namedComponent instanceof
                AppleScriptVarDeclarationListPart) {
          result.add(new AppleScriptStructureViewElement(namedComponent));
        } else if (namedComponent instanceof AppleScriptObject && namedComponent != element) {
          result.add(new AppleScriptStructureViewElement(namedComponent, true));
        } else if (namedComponent.getName() != null
                && !(namedComponent instanceof AppleScriptHandlerInterleavedParametersNameSuffixPart)
                && namedComponent != element) {
          result.add(new AppleScriptStructureViewElement(namedComponent));
        }
      }
    }
    Collections.sort(result, new Comparator<StructureViewTreeElement>() {
      @Override
      public int compare(StructureViewTreeElement o1, StructureViewTreeElement o2) {
        PsiElement element1, element2;
        if (o1 instanceof AppleScriptStructureViewElement
                && o2 instanceof AppleScriptStructureViewElement) {
          element1 = ((AppleScriptStructureViewElement) o1).getElement();
          element2 = ((AppleScriptStructureViewElement) o2).getElement();
          if (element1 != null && element2 != null) {
            return element1.getTextOffset() - element2.getTextOffset();
          }
        }
        return 0;
      }
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
