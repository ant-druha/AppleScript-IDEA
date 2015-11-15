package com.idea.plugin.applescript.test.parsing;

import java.io.IOException;

public class LiveSamplesParsingTestCase extends AbstractParsingFixtureTestCase {

  @Override
  protected String getMyTargetDirectoryPath() {
    return "live_samples";
  }

//  public void testMail() throws IOException {
//    doParseScriptInPackageTest("mail");
//  }
//
//  public void testQuickTime() throws IOException {
//    doParseScriptInPackageTest("QuickTime");
//  }
//
//  public void testAuthenticateDialog() throws IOException {
//    doParseScriptInPackageTest("authenticate_dialog");
//  }
//
//  public void testNewEvent() throws IOException {
//    doParseScriptInPackageTest("new_event");
//  }

  public void testLiveSamplesPackage() throws IOException {
    doParseAllInPackageTest();
  }

}
