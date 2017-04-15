package com.intellij.plugin.applescript.lang.ide.sdef;

/**
 * Andrey 30/01/16.
 */
class DeveloperToolsNotInstalledException extends Throwable {
  DeveloperToolsNotInstalledException() {
    super("Xcode developer tools are not installed in the system");
  }
}
