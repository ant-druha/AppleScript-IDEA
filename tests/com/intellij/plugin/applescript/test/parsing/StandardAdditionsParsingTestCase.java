package com.intellij.plugin.applescript.test.parsing;

import java.io.IOException;

public class StandardAdditionsParsingTestCase extends AbstractParsingFixtureTestCase {

  @Override
  protected String getMyTargetDirectoryPath() {
    return "standard_additions";
  }

  @Override
  protected String getMyTestDataDir() {
    return "D:/Dropbox/IDEA_Projects/IdeaPluginDev/AppleScript/testData/parse";
  }

  public void testScriptingAdditions() throws IOException {
    doParseScriptInPackageTest("scripting_additions");
  }

  public void testStandardAdditionsPackage() throws IOException {
    doParseAllInPackageTest();
  }

}
