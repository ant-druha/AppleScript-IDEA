package com.idea.plugin.applescript.test.codeinsight;

import com.idea.plugin.applescript.AppleScriptFileType;
import com.idea.plugin.applescript.lang.sdef.ApplicationDictionary;
import com.idea.plugin.applescript.lang.sdef.DictionaryComponent;
import com.intellij.codeInsight.completion.CompletionType;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.codeStyle.CodeStyleManager;
import com.intellij.testFramework.fixtures.LightCodeInsightFixtureTestCase;

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
    assertEquals(392, strings.size());
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
}
