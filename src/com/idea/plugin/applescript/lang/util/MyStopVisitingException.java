package com.idea.plugin.applescript.lang.util;

import com.intellij.openapi.vfs.VirtualFile;
import com.sun.istack.internal.NotNull;

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
