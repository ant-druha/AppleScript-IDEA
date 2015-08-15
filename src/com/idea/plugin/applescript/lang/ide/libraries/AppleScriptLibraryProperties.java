package com.idea.plugin.applescript.lang.ide.libraries;

import com.intellij.openapi.roots.libraries.LibraryProperties;
import org.jetbrains.annotations.Nullable;

/**
 * Created by Andrey on 12.08.2015.
 */
public class AppleScriptLibraryProperties extends LibraryProperties<AppleScriptLibraryProperties.State> {


  public class State {
  }

  @Override
  public boolean equals(Object obj) {
    return false;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Nullable
  @Override
  public State getState() {
    return null;
  }

  @Override
  public void loadState(State state) {

  }


}
