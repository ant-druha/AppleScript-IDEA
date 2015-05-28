package com.idea.plugin.applescript.lang.ide.structure;

import com.idea.plugin.applescript.AppleScriptFile;
import com.idea.plugin.applescript.psi.*;
import com.intellij.ide.structureView.StructureViewModel;
import com.intellij.ide.structureView.StructureViewModelBase;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.Sorter;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by Andrey on 03.05.2015.
 */
public class AppleScriptStructureViewModel extends StructureViewModelBase implements StructureViewModel
        .ElementInfoProvider {

  private static final Sorter[] SORTERS = new Sorter[]{Sorter.ALPHA_SORTER};

  public AppleScriptStructureViewModel(@NotNull PsiFile psiFile, @Nullable Editor editor) {
    super(psiFile, editor, new AppleScriptStructureViewElement(psiFile));
    withSorters(Sorter.ALPHA_SORTER);
//    withSuitableClasses(/*AppleScriptPropertyDeclaration.class, AppleScriptHandlerLabeledParametersDefinition.class,
//            AppleScriptHandlerInterleavedParametersDefinition.class, AppleScriptHandlerPositionalParametersDefinition
//                    .class, AppleScriptComponent.class,*/ AppleScriptObject.class); //todo to check this
  }


  @Override
  public boolean shouldEnterElement(Object element) {
    return element instanceof AppleScriptHandlerLabeledParametersDefinition;
  }

  @Override
  public boolean isAlwaysShowsPlus(StructureViewTreeElement element) {
    final Object value = element.getValue();
    return value instanceof AppleScriptFile;
  }

  @Override
  public boolean isAlwaysLeaf(StructureViewTreeElement element) {
    final Object value = element.getValue();
    return value instanceof AppleScriptComponentName;
//        return value instanceof AppleScriptComponent;
  }
}
