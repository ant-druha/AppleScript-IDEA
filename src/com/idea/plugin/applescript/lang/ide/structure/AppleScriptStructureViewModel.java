package com.idea.plugin.applescript.lang.ide.structure;

import com.idea.plugin.applescript.psi.AppleScriptHandlerLabeledParametersDefinition;
import com.idea.plugin.applescript.psi.AppleScriptIdentifier;
import com.intellij.ide.structureView.StructureViewModel;
import com.intellij.ide.structureView.StructureViewModelBase;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.Sorter;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Andrey 03.05.2015
 */
public class AppleScriptStructureViewModel extends StructureViewModelBase implements StructureViewModel
        .ElementInfoProvider {

  private static final Sorter[] SORTERS = new Sorter[]{Sorter.ALPHA_SORTER};

  public AppleScriptStructureViewModel(@NotNull PsiFile psiFile, @Nullable Editor editor) {
    super(psiFile, editor, new AppleScriptStructureViewElement(psiFile));
    withSorters(Sorter.ALPHA_SORTER);
//    withSuitableClasses(AppleScriptScriptObject.class, AppleScriptScriptScriptObjectDefinition.class);
  }


  @Override
  public boolean shouldEnterElement(Object element) {
    return element instanceof AppleScriptHandlerLabeledParametersDefinition;
  }

  @Override
  public boolean isAlwaysShowsPlus(StructureViewTreeElement element) {
    final Object value = element.getValue();
    return isAlwaysLeaf(element);
  }

  @Override
  public boolean isAlwaysLeaf(StructureViewTreeElement element) {
    final Object value = element.getValue();
    return value instanceof AppleScriptIdentifier;
  }
}
