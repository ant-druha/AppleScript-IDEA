package com.idea.plugin.applescript.lang.sdef;

/**
 * Created by Andrey on 16.08.2015.
 */
public interface Suite extends DictionaryComponent {

  boolean addCommand(AppleScriptCommand command);

  boolean isHidden();
}
