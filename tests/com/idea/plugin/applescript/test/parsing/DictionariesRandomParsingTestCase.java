package com.idea.plugin.applescript.test.parsing;

import java.io.IOException;

public class DictionariesRandomParsingTestCase extends AbstractParsingFixtureTestCase {

  @Override
  protected String getMyTargetDirectoryPath() {
    return "dictionaries_random";
  }

  public void testLiveSamplesPackage() throws IOException {
    doParseAllInPackageTest();
  }

}
