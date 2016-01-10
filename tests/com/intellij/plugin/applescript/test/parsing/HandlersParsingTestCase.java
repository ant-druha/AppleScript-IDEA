package com.intellij.plugin.applescript.test.parsing;

import java.io.IOException;

public class HandlersParsingTestCase extends AbstractParsingFixtureTestCase {

  @Override
  protected String getMyTargetDirectoryPath() {
    return "handlers";
  }

  public void testSimpleHandler() throws IOException {
    doParseScriptInPackageTest("simple_handler");
  }

  public void testHandlerDef() throws IOException {
    doParseScriptInPackageTest("handler_def");
  }

  public void testIfSamples() throws IOException {
    doParseScriptInPackageTest("if_samples");
  }

  public void testAllInPackage() throws IOException {
    doParseAllInPackageTest();
  }

}
