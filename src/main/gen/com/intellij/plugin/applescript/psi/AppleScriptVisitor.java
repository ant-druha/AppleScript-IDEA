// This is a generated file. Not intended for manual editing.
package com.intellij.plugin.applescript.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.plugin.applescript.psi.sdef.DictionaryCompositeElement;
import com.intellij.plugin.applescript.psi.sdef.ApplicationDictionaryDeclarator;
import com.intellij.plugin.applescript.psi.sdef.AppleScriptCommandHandlerParameter;
import com.intellij.plugin.applescript.psi.sdef.DictionaryCompositeName;
import com.intellij.plugin.applescript.psi.sdef.AppleScriptCommandHandlerCall;

public class AppleScriptVisitor extends PsiElementVisitor {

  public void visitAReferenceToLiteralExpression(@NotNull AppleScriptAReferenceToLiteralExpression o) {
    visitExpression(o);
  }

  public void visitActivateCommandExpression(@NotNull AppleScriptActivateCommandExpression o) {
    visitExpression(o);
  }

  public void visitAdditiveExpression(@NotNull AppleScriptAdditiveExpression o) {
    visitExpression(o);
  }

  public void visitAppleScriptProperty(@NotNull AppleScriptAppleScriptProperty o) {
    visitPsiElement(o);
  }

  public void visitApplicationHandlerDefinition(@NotNull AppleScriptApplicationHandlerDefinition o) {
    visitPsiElement(o);
  }

  public void visitApplicationReference(@NotNull AppleScriptApplicationReference o) {
    visitPsiElement(o);
  }

  public void visitArbitraryReference(@NotNull AppleScriptArbitraryReference o) {
    visitPsiElement(o);
  }

  public void visitArgumentSelector(@NotNull AppleScriptArgumentSelector o) {
    visitPsiElement(o);
  }

  public void visitAssignmentStatement(@NotNull AppleScriptAssignmentStatement o) {
    visitPsiElement(o);
  }

  public void visitBlockBody(@NotNull AppleScriptBlockBody o) {
    visitPsiElement(o);
  }

  public void visitBuiltInClassIdentifier(@NotNull AppleScriptBuiltInClassIdentifier o) {
    visitPsiElement(o);
  }

  public void visitBuiltInClassIdentifierPlural(@NotNull AppleScriptBuiltInClassIdentifierPlural o) {
    visitPsiElement(o);
  }

  public void visitBuiltInConstantLiteralExpression(@NotNull AppleScriptBuiltInConstantLiteralExpression o) {
    visitExpression(o);
  }

  public void visitCoercionExpression(@NotNull AppleScriptCoercionExpression o) {
    visitExpression(o);
  }

  public void visitCommandParameter(@NotNull AppleScriptCommandParameter o) {
    visitCommandHandlerParameter(o);
  }

  public void visitCommandParameterSelector(@NotNull AppleScriptCommandParameterSelector o) {
    visitPsiElement(o);
  }

  public void visitCompareExpression(@NotNull AppleScriptCompareExpression o) {
    visitExpression(o);
  }

  public void visitConcatenationExpression(@NotNull AppleScriptConcatenationExpression o) {
    visitExpression(o);
  }

  public void visitConsideringStatement(@NotNull AppleScriptConsideringStatement o) {
    visitPsiElement(o);
  }

  public void visitContinueStatement(@NotNull AppleScriptContinueStatement o) {
    visitPsiElement(o);
  }

  public void visitCountCommandExpression(@NotNull AppleScriptCountCommandExpression o) {
    visitExpression(o);
  }

  public void visitDateLiteralExpression(@NotNull AppleScriptDateLiteralExpression o) {
    visitExpression(o);
  }

  public void visitDictionaryClassIdentifierPlural(@NotNull AppleScriptDictionaryClassIdentifierPlural o) {
    visitDictionaryCompositeElement(o);
  }

  public void visitDictionaryClassName(@NotNull AppleScriptDictionaryClassName o) {
    visitDictionaryCompositeElement(o);
  }

  public void visitDictionaryCommandHandlerCallExpression(@NotNull AppleScriptDictionaryCommandHandlerCallExpression o) {
    visitExpression(o);
    // visitCommandHandlerCall(o);
  }

  public void visitDictionaryCommandName(@NotNull AppleScriptDictionaryCommandName o) {
    visitDictionaryCompositeName(o);
  }

  public void visitDictionaryConstant(@NotNull AppleScriptDictionaryConstant o) {
    visitDictionaryCompositeElement(o);
  }

  public void visitDictionaryPropertyName(@NotNull AppleScriptDictionaryPropertyName o) {
    visitDictionaryCompositeElement(o);
  }

  public void visitDirectParameterDeclaration(@NotNull AppleScriptDirectParameterDeclaration o) {
    visitComponent(o);
  }

  public void visitDirectParameterVal(@NotNull AppleScriptDirectParameterVal o) {
    visitPsiElement(o);
  }

  public void visitErrorCommandExpression(@NotNull AppleScriptErrorCommandExpression o) {
    visitExpression(o);
  }

  public void visitEveryElemReference(@NotNull AppleScriptEveryElemReference o) {
    visitPsiElement(o);
  }

  public void visitEveryRangeReference(@NotNull AppleScriptEveryRangeReference o) {
    visitPsiElement(o);
  }

  public void visitExitStatement(@NotNull AppleScriptExitStatement o) {
    visitPsiElement(o);
  }

  public void visitExpression(@NotNull AppleScriptExpression o) {
    visitPsiElement(o);
  }

  public void visitFilterReference(@NotNull AppleScriptFilterReference o) {
    visitPsiElement(o);
  }

  public void visitFormalParameterList(@NotNull AppleScriptFormalParameterList o) {
    visitPsiElement(o);
  }

  public void visitGetCommandExpression(@NotNull AppleScriptGetCommandExpression o) {
    visitExpression(o);
  }

  public void visitGivenRawParameterExpression(@NotNull AppleScriptGivenRawParameterExpression o) {
    visitExpression(o);
  }

  public void visitHandlerArgument(@NotNull AppleScriptHandlerArgument o) {
    visitPsiElement(o);
  }

  public void visitHandlerInterleavedParametersCall(@NotNull AppleScriptHandlerInterleavedParametersCall o) {
    visitHandlerCall(o);
  }

  public void visitHandlerInterleavedParametersDefinition(@NotNull AppleScriptHandlerInterleavedParametersDefinition o) {
    visitHandler(o);
  }

  public void visitHandlerInterleavedParametersSelectorPart(@NotNull AppleScriptHandlerInterleavedParametersSelectorPart o) {
    visitHandlerSelectorPart(o);
  }

  public void visitHandlerLabeledParametersCallExpression(@NotNull AppleScriptHandlerLabeledParametersCallExpression o) {
    visitExpression(o);
  }

  public void visitHandlerLabeledParametersDefinition(@NotNull AppleScriptHandlerLabeledParametersDefinition o) {
    visitComponent(o);
  }

  public void visitHandlerParameterLabel(@NotNull AppleScriptHandlerParameterLabel o) {
    visitPsiElement(o);
  }

  public void visitHandlerPositionalParametersCallExpression(@NotNull AppleScriptHandlerPositionalParametersCallExpression o) {
    visitExpression(o);
  }

  public void visitHandlerPositionalParametersDefinition(@NotNull AppleScriptHandlerPositionalParametersDefinition o) {
    visitComponent(o);
  }

  public void visitIdReference(@NotNull AppleScriptIdReference o) {
    visitPsiElement(o);
  }

  public void visitIdentifier(@NotNull AppleScriptIdentifier o) {
    visitPsiElement(o);
  }

  public void visitIfCompoundStatement(@NotNull AppleScriptIfCompoundStatement o) {
    visitPsiElement(o);
  }

  public void visitIfSimpleStatement(@NotNull AppleScriptIfSimpleStatement o) {
    visitPsiElement(o);
  }

  public void visitIgnoringStatement(@NotNull AppleScriptIgnoringStatement o) {
    visitPsiElement(o);
  }

  public void visitIncompleteCommandHandlerCall(@NotNull AppleScriptIncompleteCommandHandlerCall o) {
    visitDictionaryCompositeName(o);
  }

  public void visitIncompleteExpression(@NotNull AppleScriptIncompleteExpression o) {
    visitExpression(o);
  }

  public void visitIndexReference(@NotNull AppleScriptIndexReference o) {
    visitPsiElement(o);
  }

  public void visitIndexReferenceClassForm(@NotNull AppleScriptIndexReferenceClassForm o) {
    visitPsiElement(o);
  }

  public void visitIntegerLiteralExpression(@NotNull AppleScriptIntegerLiteralExpression o) {
    visitExpression(o);
  }

  public void visitLabeledParameterDeclarationList(@NotNull AppleScriptLabeledParameterDeclarationList o) {
    visitPsiElement(o);
  }

  public void visitLabeledParameterDeclarationPart(@NotNull AppleScriptLabeledParameterDeclarationPart o) {
    visitComponent(o);
  }

  public void visitLaunchCommandExpression(@NotNull AppleScriptLaunchCommandExpression o) {
    visitExpression(o);
  }

  public void visitListFormalParameter(@NotNull AppleScriptListFormalParameter o) {
    visitPsiElement(o);
  }

  public void visitListLiteralExpression(@NotNull AppleScriptListLiteralExpression o) {
    visitExpression(o);
  }

  public void visitLogCommandExpression(@NotNull AppleScriptLogCommandExpression o) {
    visitExpression(o);
  }

  public void visitLogicalAndExpression(@NotNull AppleScriptLogicalAndExpression o) {
    visitExpression(o);
  }

  public void visitLogicalOrExpression(@NotNull AppleScriptLogicalOrExpression o) {
    visitExpression(o);
  }

  public void visitMiddleElemReference(@NotNull AppleScriptMiddleElemReference o) {
    visitPsiElement(o);
  }

  public void visitMultiplicativeExpression(@NotNull AppleScriptMultiplicativeExpression o) {
    visitExpression(o);
  }

  public void visitNameReference(@NotNull AppleScriptNameReference o) {
    visitPsiElement(o);
  }

  public void visitNegationExpression(@NotNull AppleScriptNegationExpression o) {
    visitExpression(o);
  }

  public void visitNumberLiteralExpression(@NotNull AppleScriptNumberLiteralExpression o) {
    visitExpression(o);
  }

  public void visitNumericConstant(@NotNull AppleScriptNumericConstant o) {
    visitPsiElement(o);
  }

  public void visitObjectNamedPropertyDeclaration(@NotNull AppleScriptObjectNamedPropertyDeclaration o) {
    visitComponent(o);
  }

  public void visitObjectPropertyDeclaration(@NotNull AppleScriptObjectPropertyDeclaration o) {
    visitPsiElement(o);
  }

  public void visitObjectReferenceExpression(@NotNull AppleScriptObjectReferenceExpression o) {
    visitExpression(o);
  }

  public void visitObjectTargetPropertyDeclaration(@NotNull AppleScriptObjectTargetPropertyDeclaration o) {
    visitComponent(o);
  }

  public void visitParameterVal(@NotNull AppleScriptParameterVal o) {
    visitPsiElement(o);
  }

  public void visitParenthesizedExpression(@NotNull AppleScriptParenthesizedExpression o) {
    visitExpression(o);
  }

  public void visitPowerExpression(@NotNull AppleScriptPowerExpression o) {
    visitExpression(o);
  }

  public void visitPropertyReference(@NotNull AppleScriptPropertyReference o) {
    visitPsiElement(o);
  }

  public void visitRangeFromReference(@NotNull AppleScriptRangeFromReference o) {
    visitPsiElement(o);
  }

  public void visitRangeIndexReference(@NotNull AppleScriptRangeIndexReference o) {
    visitPsiElement(o);
  }

  public void visitRawClassExpression(@NotNull AppleScriptRawClassExpression o) {
    visitExpression(o);
  }

  public void visitRawDataExpression(@NotNull AppleScriptRawDataExpression o) {
    visitExpression(o);
  }

  public void visitRawDictionaryCommandHandlerCallExpression(@NotNull AppleScriptRawDictionaryCommandHandlerCallExpression o) {
    visitExpression(o);
  }

  public void visitRawParameterExpression(@NotNull AppleScriptRawParameterExpression o) {
    visitExpression(o);
  }

  public void visitRawParameterSelector(@NotNull AppleScriptRawParameterSelector o) {
    visitPsiElement(o);
  }

  public void visitRealLiteralExpression(@NotNull AppleScriptRealLiteralExpression o) {
    visitExpression(o);
  }

  public void visitRecordFormalParameter(@NotNull AppleScriptRecordFormalParameter o) {
    visitPsiElement(o);
  }

  public void visitRecordLiteralExpression(@NotNull AppleScriptRecordLiteralExpression o) {
    visitExpression(o);
  }

  public void visitReferenceExpression(@NotNull AppleScriptReferenceExpression o) {
    visitExpression(o);
    // visitReferenceElement(o);
  }

  public void visitRelativeReference(@NotNull AppleScriptRelativeReference o) {
    visitPsiElement(o);
  }

  public void visitRepeatForeverStatement(@NotNull AppleScriptRepeatForeverStatement o) {
    visitPsiElement(o);
  }

  public void visitRepeatNumTimesStatement(@NotNull AppleScriptRepeatNumTimesStatement o) {
    visitPsiElement(o);
  }

  public void visitRepeatUntilStatement(@NotNull AppleScriptRepeatUntilStatement o) {
    visitPsiElement(o);
  }

  public void visitRepeatWhileStatement(@NotNull AppleScriptRepeatWhileStatement o) {
    visitPsiElement(o);
  }

  public void visitRepeatWithListStatement(@NotNull AppleScriptRepeatWithListStatement o) {
    visitPsiElement(o);
  }

  public void visitRepeatWithRangeStatement(@NotNull AppleScriptRepeatWithRangeStatement o) {
    visitPsiElement(o);
  }

  public void visitReturnStatement(@NotNull AppleScriptReturnStatement o) {
    visitPsiElement(o);
  }

  public void visitRunCommandExpression(@NotNull AppleScriptRunCommandExpression o) {
    visitExpression(o);
  }

  public void visitScriptBody(@NotNull AppleScriptScriptBody o) {
    visitPsiElement(o);
  }

  public void visitScriptObjectDefinition(@NotNull AppleScriptScriptObjectDefinition o) {
    visitScriptObject(o);
  }

  public void visitScriptObjectUnnamedDefinition(@NotNull AppleScriptScriptObjectUnnamedDefinition o) {
    visitPsiElement(o);
  }

  public void visitScriptPropertyDeclaration(@NotNull AppleScriptScriptPropertyDeclaration o) {
    visitComponent(o);
  }

  public void visitSelectorId(@NotNull AppleScriptSelectorId o) {
    visitPsiElement(o);
  }

  public void visitSimpleFormalParameter(@NotNull AppleScriptSimpleFormalParameter o) {
    visitComponent(o);
  }

  public void visitStringLiteralExpression(@NotNull AppleScriptStringLiteralExpression o) {
    visitExpression(o);
  }

  public void visitTargetListLiteral(@NotNull AppleScriptTargetListLiteral o) {
    visitPsiElement(o);
  }

  public void visitTargetRecordLiteral(@NotNull AppleScriptTargetRecordLiteral o) {
    visitPsiElement(o);
  }

  public void visitTargetVariable(@NotNull AppleScriptTargetVariable o) {
    visitComponent(o);
  }

  public void visitTellCompoundStatement(@NotNull AppleScriptTellCompoundStatement o) {
    visitApplicationDictionaryDeclarator(o);
  }

  public void visitTellSimpleStatement(@NotNull AppleScriptTellSimpleStatement o) {
    visitApplicationDictionaryDeclarator(o);
  }

  public void visitTextItemDelimitersProperty(@NotNull AppleScriptTextItemDelimitersProperty o) {
    visitPsiElement(o);
  }

  public void visitTopBlockBody(@NotNull AppleScriptTopBlockBody o) {
    visitPsiElement(o);
  }

  public void visitTryStatement(@NotNull AppleScriptTryStatement o) {
    visitPsiElement(o);
  }

  public void visitUseStatement(@NotNull AppleScriptUseStatement o) {
    visitApplicationDictionaryDeclarator(o);
  }

  public void visitUserClassName(@NotNull AppleScriptUserClassName o) {
    visitReferenceElement(o);
  }

  public void visitUsingTermsFromStatement(@NotNull AppleScriptUsingTermsFromStatement o) {
    visitApplicationDictionaryDeclarator(o);
  }

  public void visitVarAccessDeclaration(@NotNull AppleScriptVarAccessDeclaration o) {
    visitComponent(o);
  }

  public void visitVarDeclarationList(@NotNull AppleScriptVarDeclarationList o) {
    visitPsiElement(o);
  }

  public void visitVarDeclarationListPart(@NotNull AppleScriptVarDeclarationListPart o) {
    visitComponent(o);
  }

  public void visitWithTimeoutStatement(@NotNull AppleScriptWithTimeoutStatement o) {
    visitPsiElement(o);
  }

  public void visitWithTransactionStatement(@NotNull AppleScriptWithTransactionStatement o) {
    visitPsiElement(o);
  }

  public void visitCommandHandlerParameter(@NotNull AppleScriptCommandHandlerParameter o) {
    visitPsiElement(o);
  }

  public void visitComponent(@NotNull AppleScriptComponent o) {
    visitPsiElement(o);
  }

  public void visitHandler(@NotNull AppleScriptHandler o) {
    visitPsiElement(o);
  }

  public void visitHandlerCall(@NotNull AppleScriptHandlerCall o) {
    visitPsiElement(o);
  }

  public void visitHandlerSelectorPart(@NotNull AppleScriptHandlerSelectorPart o) {
    visitPsiElement(o);
  }

  public void visitReferenceElement(@NotNull AppleScriptReferenceElement o) {
    visitPsiElement(o);
  }

  public void visitScriptObject(@NotNull AppleScriptScriptObject o) {
    visitPsiElement(o);
  }

  public void visitApplicationDictionaryDeclarator(@NotNull ApplicationDictionaryDeclarator o) {
    visitElement(o);
  }

  public void visitDictionaryCompositeElement(@NotNull DictionaryCompositeElement o) {
    visitElement(o);
  }

  public void visitDictionaryCompositeName(@NotNull DictionaryCompositeName o) {
    visitElement(o);
  }

  public void visitPsiElement(@NotNull AppleScriptPsiElement o) {
    visitElement(o);
  }

}
