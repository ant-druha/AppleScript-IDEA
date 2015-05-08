package com.idea.plugin.applescript.lang.ide.structure;

import com.idea.plugin.applescript.psi.AppleScriptPsiElement;
import com.intellij.ide.structureView.StructureViewExtension;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiElement;
import com.intellij.psi.xml.XmlTag;
import org.jetbrains.annotations.Nullable;

/**
 * Created by Andrey on 03.05.2015.
 */
public class AppleScriptStructureViewExtension implements StructureViewExtension {
    @Override
    public Class<? extends PsiElement> getType() {
        return XmlTag.class;
    }

    @Override
    public StructureViewTreeElement[] getChildren(PsiElement parent) {
        if (parent instanceof AppleScriptPsiElement) {
            new AppleScriptStructureViewElement((AppleScriptPsiElement)parent).getChildren();
        }
        return new StructureViewTreeElement[0];
    }

    @Nullable
    @Override
    public Object getCurrentEditorElement(Editor editor, PsiElement parent) {
         if (parent instanceof AppleScriptPsiElement) {
            return new AppleScriptStructureViewModel(parent.getContainingFile(),editor).getCurrentEditorElement();
        }
        return null;
    }
}
