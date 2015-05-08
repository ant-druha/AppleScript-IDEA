package com.idea.plugin.applescript.lang.formatter;

import com.idea.plugin.applescript.AppleScriptFile;
import com.idea.plugin.applescript.AppleScriptLanguage;
import com.idea.plugin.applescript.psi.impl.PsiImplUtil;
import com.intellij.formatting.Block;
import com.intellij.formatting.FormattingModel;
import com.intellij.formatting.FormattingModelBuilder;
import com.intellij.formatting.Indent;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.TokenType;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CommonCodeStyleSettings;
import com.intellij.psi.formatter.DocumentBasedFormattingModel;
import com.intellij.psi.formatter.FormatterUtil;
import com.intellij.psi.formatter.FormattingDocumentModelImpl;
import com.intellij.psi.formatter.PsiBasedFormattingModel;
import com.intellij.psi.impl.source.tree.TreeUtil;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by Andrey on 08.04.2015.
 */
public class AppleScriptFormattingModelBuilder implements FormattingModelBuilder {
    @NotNull
    @Override
    public FormattingModel createModel(PsiElement element, CodeStyleSettings settings) {
        PsiFile containingFile = element.getContainingFile().getViewProvider().getPsi(AppleScriptLanguage.INSTANCE);
        assert containingFile != null : element.getContainingFile();
        ASTNode astNode = containingFile.getNode();
        assert astNode != null;
        CommonCodeStyleSettings appleScriptSettings = settings.getCommonSettings(AppleScriptLanguage.INSTANCE);
        final AppleScriptBlock rootBlock = new AppleScriptBlock(astNode, null, null, settings);
        return new AppleScriptFormattingModel(containingFile, rootBlock, FormattingDocumentModelImpl.createOn(containingFile));
//        return new DocumentBasedFormattingModel(rootBlock, element.getProject(), settings, psiFile.getFileType(), psiFile);
    }

    @Nullable
    @Override
    public TextRange getRangeAffectingIndent(PsiFile file, int offset, ASTNode elementAtOffset) {
        return null;
    }

    private static class AppleScriptFormattingModel extends PsiBasedFormattingModel {

        AppleScriptFormattingModel(PsiFile file, @NotNull Block rootBlock, FormattingDocumentModelImpl documentModel) {
            super(file, rootBlock, documentModel);
        }

        @Override
        protected String replaceWithPsiInLeaf(TextRange textRange, String whiteSpace, ASTNode leafElement) {
            if (!myCanModifyAllWhiteSpaces) {
                if (PsiImplUtil.isWhiteSpaceOrNls(leafElement)) return null;
            }

            IElementType elementTypeToUse = TokenType.WHITE_SPACE;
            ASTNode prevNode = TreeUtil.prevLeaf(leafElement);
            if (prevNode != null && PsiImplUtil.isWhiteSpaceOrNls(prevNode)) {
                elementTypeToUse = prevNode.getElementType();
            }
            FormatterUtil.replaceWhiteSpace(whiteSpace, leafElement, elementTypeToUse, textRange);
            return whiteSpace;
        }
    }
}
