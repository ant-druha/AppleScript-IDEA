package com.idea.plugin.applescript.lang.ide.libraries;

import com.intellij.openapi.roots.libraries.LibraryProperties;
import com.intellij.openapi.util.Comparing;
import com.intellij.util.xmlb.annotations.AbstractCollection;
import com.intellij.util.xmlb.annotations.Tag;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Andrey on 12.08.2015.
 */
public class AppleScriptLibraryProperties extends LibraryProperties<AppleScriptLibraryProperties.State> {

  public static final String CACHED_DICTIONARY_URLS_ELEMENT = "cachedDictionaryUrls";
  public static final String URL_ITEM_ELEMENT = "item";
  public static final String URL_ITEM_ATTR = "url";

  public static class State {

    @Tag(CACHED_DICTIONARY_URLS_ELEMENT)
    @AbstractCollection(surroundWithTag = false, elementTag = URL_ITEM_ELEMENT, elementValueAttribute = URL_ITEM_ATTR)
    public Collection<String> cachedDictionaryUrls = new ArrayList<String>();
  }

  private Collection<String> myCachedDictionaryUrls = new ArrayList<String>();

  public AppleScriptLibraryProperties() {
  }

  public AppleScriptLibraryProperties(Collection<String> myCachedDictionaryUrls) {
    this.myCachedDictionaryUrls = myCachedDictionaryUrls;
  }

  public Collection<String> getCachedDictionaryUrls() {
    return myCachedDictionaryUrls;
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof AppleScriptLibraryProperties &&
            Comparing.haveEqualElements(myCachedDictionaryUrls,
                    ((AppleScriptLibraryProperties) obj).myCachedDictionaryUrls);
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Nullable
  @Override
  public State getState() {
    State state = new State();
    state.cachedDictionaryUrls = myCachedDictionaryUrls != null ? myCachedDictionaryUrls : null;
    return state;
  }

  @Override
  public void loadState(State state) {
    myCachedDictionaryUrls = state.cachedDictionaryUrls;
  }


}
