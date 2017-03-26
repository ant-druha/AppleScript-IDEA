package com.intellij.plugin.applescript.test.parsing;

import java.io.IOException;

public class TellParsingTestCase extends AbstractParsingFixtureTestCase {

  @Override
  protected String getMyTargetDirectoryPath() {
    return "tell";
  }

  public void testLiveSamplesPackage() throws IOException {
    doParseAllInPackageTest();
  }

}
