package com.intellij.plugin.applescript.lang.ide.sdef;

/**
 * Created by Andrey on 30/01/16.
 */
public class DeveloperToolsNotInstalledException extends Throwable {
  public DeveloperToolsNotInstalledException() {
    super("Xcode developer tools are not installed in the system");
  }
}
