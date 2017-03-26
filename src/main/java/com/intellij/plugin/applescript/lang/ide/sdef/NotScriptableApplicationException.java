package com.intellij.plugin.applescript.lang.ide.sdef;

import org.jetbrains.annotations.NotNull;

public class NotScriptableApplicationException extends Throwable {
  @NotNull private String applicationName;

  public NotScriptableApplicationException(@NotNull String applicationName) {
    this.applicationName = applicationName;
  }

  public NotScriptableApplicationException(@NotNull String applicationName, @NotNull String message) {
    super(message);
    this.applicationName = applicationName;
  }

  @NotNull
  public String getApplicationName() {
    return applicationName;
  }
}
