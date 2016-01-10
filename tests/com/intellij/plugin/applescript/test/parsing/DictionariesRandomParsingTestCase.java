package com.intellij.plugin.applescript.test.parsing;

import java.io.IOException;

public class DictionariesRandomParsingTestCase extends AbstractParsingFixtureTestCase {

  @Override
  protected String getMyTargetDirectoryPath() {
    return "dictionaries_random";
  }

  public void testHugeScript() throws IOException {
    doParseScriptInPackageTest("huge_script");
  }

  public void testWrongDictionary() throws IOException {
    doParseScriptInPackageTest("wrong_dictionary");
  }

  public void testDictionariesRandomPackage() throws IOException {
    doParseAllInPackageTest();
  }

}
