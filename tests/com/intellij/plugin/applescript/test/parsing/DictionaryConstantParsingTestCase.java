package com.intellij.plugin.applescript.test.parsing;

import java.io.IOException;

public class DictionaryConstantParsingTestCase extends AbstractParsingFixtureTestCase {

  @Override
  protected String getMyTargetDirectoryPath() {
    return "dictionary_constant";
  }

  public void testTellFinder() throws IOException {
    doParseScriptInPackageTest("tell_finder");
  }

}
