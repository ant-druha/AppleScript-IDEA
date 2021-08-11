package com.intellij.plugin.applescript.test.parsing;

import com.intellij.openapi.diagnostic.Logger;
import com.intellij.psi.PsiFile;
import com.intellij.testFramework.ParsingTestCase;
import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixtureTestCase;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractParsingFixtureTestCase extends LightPlatformCodeInsightFixtureTestCase {

  private static final Logger LOG = Logger.getInstance("#" + AbstractParsingFixtureTestCase.class.getName());

  String myTargetTestDataDir = getMyTestDataDir() + "/" + getMyTargetDirectoryPath();
  private List<PsiFile> myPsiFiles = new ArrayList<>();

  protected abstract String getMyTargetDirectoryPath();

  protected String getMyTestDataDir() {
    return "src/test/resources/testData/parse";
  }

  @Override
  protected String getTestDataPath() {
    return new File(getMyTestDataDir()).getAbsolutePath();
  }

  @Override
  protected void setUp() throws Exception {
    super.setUp();
    File myTargetDir = new File(myTargetTestDataDir);
    if (!myTargetDir.isDirectory()) throw new Exception(myTargetDir + " is not a directory");

    File[] myFiles = myTargetDir.listFiles(pathname -> pathname.getName().endsWith("scpt"));
    for (File file : myFiles) {
      myPsiFiles.add(myFixture.configureByFile(file.getCanonicalPath()));
    }
  }

  protected void doParseAllInPackageTest() {
    LOG.info("Parsing files in the package: " + getMyTargetDirectoryPath());
    System.out.println("Parsing files in the package: " + getMyTargetDirectoryPath());
    for (PsiFile psiFile : myPsiFiles) {
      LOG.info("File: " + psiFile.getName());
      System.out.print("File: " + psiFile.getName());
      ParsingTestCase.doCheckResult(myTargetTestDataDir, psiFile, checkAllPsiRoots(),
              psiFile.getVirtualFile().getNameWithoutExtension(), skipSpaces(), printRanges());
      System.out.println(": Ok");
    }
  }

  protected void doParseScriptInPackageTest(String fileNameWithoutExtension) {
    for (PsiFile psiFile : myPsiFiles) {
      String dataName = psiFile.getVirtualFile().getNameWithoutExtension();
      if (dataName.equals(fileNameWithoutExtension)) {
        ParsingTestCase.doCheckResult(myTargetTestDataDir, psiFile, checkAllPsiRoots(), dataName, skipSpaces(),
                printRanges());
      }
    }
  }

  private boolean skipSpaces() {
    return false;
  }

  private boolean printRanges() {
    return true;
  }

  protected boolean checkAllPsiRoots() {
    return true;
  }
}
