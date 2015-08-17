package com.idea.plugin.applescript.psi.sdef;

import com.idea.plugin.applescript.psi.AppleScriptIdentifier;
import com.idea.plugin.applescript.psi.AppleScriptPsiElement;

import java.util.List;

/**
 * Created by Andrey on 16.08.2015.
 */
public interface AppleScriptCommandName extends AppleScriptPsiElement {

  List<AppleScriptIdentifier> getIdentifiers();
}
