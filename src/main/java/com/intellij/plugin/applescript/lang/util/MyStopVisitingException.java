package com.intellij.plugin.applescript.lang.util;

import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

public class MyStopVisitingException extends RuntimeException {
  @NotNull private VirtualFile myResult;

  public MyStopVisitingException(@NotNull String message, @NotNull VirtualFile myResult) {
    super(new Throwable(message));
    this.myResult = myResult;
  }

  public MyStopVisitingException(@NotNull VirtualFile myResult) {
    super(new Throwable("File found" + myResult));
    this.myResult = myResult;
  }

  @NotNull
  public VirtualFile getResult() {
    return myResult;
  }
}
