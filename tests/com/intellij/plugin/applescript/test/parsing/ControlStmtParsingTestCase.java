package com.intellij.plugin.applescript.test.parsing;

import java.io.IOException;

public class ControlStmtParsingTestCase extends AbstractParsingFixtureTestCase {

  @Override
  protected String getMyTargetDirectoryPath() {
    return "handlers";
  }

  public void testTryStatement() throws IOException {
    doParseScriptInPackageTest("try_statement");
  }

//  public void testAllInPackage() throws IOException {
//    doParseAllInPackageTest();
//  }

}
