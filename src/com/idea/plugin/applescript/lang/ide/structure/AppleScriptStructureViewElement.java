package com.idea.plugin.applescript.lang.ide.structure;

import com.idea.plugin.applescript.AppleScriptFile;
import com.idea.plugin.applescript.lang.resolve.AppleScriptComponentNameScopeProcessor;
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Andrey on 03.05.2015.
 */
public class AppleScriptStructureViewElement extends PsiTreeElementBase<NavigatablePsiElement>
        implements ItemPresentation, StructureViewTreeElement {

    private boolean isRoot = false;

    protected AppleScriptStructureViewElement(@NotNull final NavigatablePsiElement element) {
        super(element);
    }

    public AppleScriptStructureViewElement(NavigatablePsiElement element, boolean isRoot) {
        super(element);
        this.isRoot = isRoot;
    }

    @NotNull
    @Override
    public Collection<StructureViewTreeElement> getChildrenBase() {
        final NavigatablePsiElement element = getElement();
        final List<StructureViewTreeElement> result = new ArrayList<StructureViewTreeElement>();
//        if (element instanceof AppleScriptFile && !(getValue() instanceof AppleScriptFile)) {
//            result.add(new AppleScriptStructureViewElement(element));
//            return result;
//        }
//        if (element !=null && element.getParent() instanceof AppleScriptFile) {
        if (element != null && element instanceof AppleScriptFile) {
            if (!isRoot) {
                result.add(new AppleScriptStructureViewElement(element,true));
                return result;
            }
            THashSet<AppleScriptComponentName> componentNames = new THashSet<AppleScriptComponentName>();

            //todo parent property will not be found here as it does not contain componentName
            AppleScriptPsiElementImpl
                    .processDeclarationsImpl(element, new AppleScriptComponentNameScopeProcessor(componentNames), ResolveState.initial(), null);

            for (AppleScriptComponentName componentName : componentNames) {
                PsiElement parent = componentName.getParent();//todo may be getContext() ?
                if (parent instanceof AppleScriptHandlerPositionalParametersDefinition) {
                    result.add(new AppleScriptStructureViewElement((AppleScriptHandlerPositionalParametersDefinition) parent));
                } else if (parent instanceof AppleScriptPropertyDeclarationStatement) {
                    result.add(new AppleScriptStructureViewElement((AppleScriptPropertyDeclarationStatement) parent));
                } else if (parent instanceof AppleScriptVariableDeclarationStatement) {
                    result.add(new AppleScriptStructureViewElement((AppleScriptVariableDeclarationStatement) parent));
                } else if (parent instanceof AppleScriptTargetComponent) {
                    result.add(new AppleScriptStructureViewElement((AppleScriptTargetComponent) parent));
                }
            }
        } else if (element instanceof AppleScriptHandlerLabeledParametersCall) {
            //todo handle handler declaration
        }
//        else if (element instanceof AppleScriptPropertyDeclarationStatement
//                && element.getText() != null && element.getText().toLowerCase().contains("parent")) {
//            //todo: to think about parent
//            result.add(new AppleScriptStructureViewElement(element));
//        }
//        else if (element instanceof AppleScriptPropertyDeclarationStatement) {
//            result.add(new AppleScriptStructureViewElement(element));
//        } else if (element instanceof AppleScriptTargetComponent){
//            result.add(new AppleScriptStructureViewElement(element));
//        }
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
