package com.intellij.plugin.applescript.test.codeinsight;

import com.intellij.codeInsight.completion.CompletionType;
import com.intellij.codeInsight.generation.actions.CommentByLineCommentAction;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.plugin.applescript.AppleScriptFileType;
import com.intellij.plugin.applescript.lang.sdef.ApplicationDictionary;
import com.intellij.plugin.applescript.lang.sdef.DictionaryComponent;
import com.intellij.plugin.applescript.psi.AppleScriptTargetVariable;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.codeStyle.CodeStyleManager;
import com.intellij.testFramework.fixtures.LightCodeInsightFixtureTestCase;
import com.intellij.usageView.UsageInfo;

import java.util.Collection;
import java.util.List;

/**
 * Created by Andrey on 20/12/15.
 */
public class AppleScriptCodeInsightTest extends LightCodeInsightFixtureTestCase {

  private final String myTestDataDir = "/Users/andrey/Dropbox/IDEA_Projects/IdeaPluginDev/AppleScript/testData/";

  @Override
  protected String getTestDataPath() {
    return myTestDataDir;
  }

  public void testCompletion() {
    myFixture.configureByFile("complete/complete_std_lib_test.scpt");
    myFixture.complete(CompletionType.BASIC, 1);
    List<String> strings = myFixture.getLookupElementStrings();
    LookupElement[] arElements = myFixture.getLookupElements();
    assert strings != null;
    assert arElements != null;
    assertTrue(strings.size() == arElements.length);
    int stdAdditionsElementCount = 0;
    int cocoaStandardElementCount = 0;
    for (LookupElement le : arElements) {
      PsiElement el = le.getPsiElement();
      if (el != null) {
        if (el instanceof DictionaryComponent) {
          DictionaryComponent dc = (DictionaryComponent) el;
          String dictionaryName = dc.getDictionary().getName();
          if (ApplicationDictionary.SCRIPTING_ADDITIONS_LIBRARY.equals(dictionaryName))
            stdAdditionsElementCount++;
          else if (ApplicationDictionary.COCOA_STANDARD_LIBRARY.equals(dictionaryName))
            cocoaStandardElementCount++;
        }
      }
    }
    System.out.println("All elements=" + arElements.length);
    System.out.println("Std lib count=" + stdAdditionsElementCount);
    System.out.println("Cocoa lib count=" + cocoaStandardElementCount);
    assertEquals(394, strings.size());
    assertEquals(257, stdAdditionsElementCount);
    assertEquals(45, cocoaStandardElementCount);
  }

  public void testAnnotator() {
    myFixture.configureByFile("annotator/not_found_dic.scpt");
    long dur = myFixture.checkHighlighting(true, false, false);
    System.out.println(dur);
  }

  public void testFileType() {
    PsiFile file = myFixture.configureByFile("annotator/not_found_dic.scpt");
    assertTrue(file.getFileType() == AppleScriptFileType.INSTANCE);
  }

  public void testFormatter() {
    myFixture.configureByFiles("format/test_block_indent.scpt");
//    CodeStyleSettingsManager.getSettings(getProject()).SPACE_AROUND_ASSIGNMENT_OPERATORS = true;
    new WriteCommandAction.Simple(getProject()) {
      @Override
      protected void run() throws Throwable {
        CodeStyleManager.getInstance(getProject()).reformat(myFixture.getFile());
      }
    }.execute();
    myFixture.checkResultByFile("format/test_block_indent_result.scpt");
  }

  public void testRename(){
    myFixture.configureByFiles("codeinsight/set_var.scpt");
    myFixture.renameElementAtCaret("myVarNewName");
    myFixture.checkResultByFile("codeinsight/set_var_result.scpt");
  }

  public void testUsages(){
    Collection<UsageInfo> usageInfos = myFixture.testFindUsages("codeinsight/set_var.scpt");
    assertEquals(2, usageInfos.size());
  }
  public void testCommenter() {
    myFixture.configureByText(AppleScriptFileType.INSTANCE, "<caret>set myVar to 123");
    CommentByLineCommentAction commentAction = new CommentByLineCommentAction();
    commentAction.actionPerformedImpl(getProject(), myFixture.getEditor());
    myFixture.checkResult("--set myVar to 123");
    commentAction.actionPerformedImpl(getProject(), myFixture.getEditor());
    myFixture.checkResult("set myVar to 123");
  }
  public void testReference() {
    myFixture.configureByFile("codeinsight/set_var_ref.scpt");
    PsiElement element = myFixture.getFile().findElementAt(myFixture.getCaretOffset());
    PsiElement parent = element != null ? element.getParent() : null;
    PsiElement superParent = parent != null ? parent.getParent() : null;
    assert (superParent != null);
    AppleScriptTargetVariable resolveResult = (AppleScriptTargetVariable) superParent.getReferences()[0].resolve();
    assertNotNull(resolveResult);
    assertEquals("myVar", resolveResult.getText());
  }
}
