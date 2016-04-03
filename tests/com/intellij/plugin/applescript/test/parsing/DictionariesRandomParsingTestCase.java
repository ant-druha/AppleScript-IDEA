package com.intellij.plugin.applescript.test.parsing;

import java.io.IOException;

public class DictionariesRandomParsingTestCase extends AbstractParsingFixtureTestCase {

  @Override
  protected String getMyTargetDirectoryPath() {
    return "dictionaries_random";
  }

//  public void testHugeScript() throws IOException {
//    doParseScriptInPackageTest("huge_script");
//  }

  public void testWrongDictionary() throws IOException {
    doParseScriptInPackageTest("wrong_dictionary");
  }

  public void testClsVsProperty() throws IOException {
    doParseScriptInPackageTest("cls_vs_property");
  }

  public void testClsVsDic() throws IOException {
    doParseScriptInPackageTest("cls_vs_dic");
  }

  public void testCoreServices() throws IOException {
    doParseScriptInPackageTest("CoreServices");
  }

  public void testDictionaryCommands() throws IOException {
    doParseScriptInPackageTest("dictionary_commands");
  }



//  public void testDictionariesRandomPackage() throws IOException {
//    doParseAllInPackageTest();
//  }

}
