package com.idea.plugin.applescript.lang.parser;

import com.idea.plugin.applescript.AppleScriptNames;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.parser.GeneratedParserUtilBase;
import com.intellij.psi.tree.IElementType;

import static com.idea.plugin.applescript.psi.AppleScriptTypes.*;

/**
 * Created by Andrey on 13.04.2015.
 */
public class AppleScriptGeneratedParserUtil extends GeneratedParserUtilBase {

  public static boolean parseDictionaryCommandName(PsiBuilder b, int l) {
    final String[] stdCommands = AppleScriptNames.SCRIPTING_ADDITION_COMMAND_NAMES;

    for (String name : stdCommands) {
      if (tryToParseDictionaryName(b, l, name)) {
        return true;
      }
    }

    return false;
  }

  private static boolean tryToParseDictionaryName(PsiBuilder b, int l, String name) {
    if (!recursion_guard_(b, l, "parseDictionaryCommandName")) return false;
    boolean r;
    PsiBuilder.Marker m = enter_section_(b, l, _AND_, "<try to parse dictionary name>");
    r = isNameAccepted(b, l, name);
    exit_section_(b, l, m, null, r, false, null);
    if (r) {
      r = isNameAccepted(b, l, name);
      return r;
    }
    return false;
  }

  //todo add not only identifiers parsing
  private static boolean isNameAccepted(PsiBuilder b, int l, String name) {
    boolean proceed;
    String currentText = "";
    String sep = "";
    IElementType[] allowedTypes = {VAR_IDENTIFIER, SCRIPT};
    if (b.getTokenType() == VAR_IDENTIFIER) {
      currentText = b.getTokenText() == null ? "" : b.getTokenText();
      if (name.equals(currentText)) {
        proceed = identifier(b, l + 1);
        return true;
      }
      sep = currentText != null ? " " : "";
    }
    //todo: check consumeTokenFast with String text //name.equals("do shell") && b.getTokenText().equals("do")
    //todo not only identifiers to consume - as there are command names like 'do shell SCRIPT', path TO, info FOR, etc
    proceed = identifier(b, l + 1);
    while (proceed) {
      currentText = currentText + sep + (b.getTokenText() == null ? "" : b.getTokenText());
      sep = " ";
      if (name.equals(currentText)) {
        proceed = identifier(b, l + 1);
        return true;
      } else {
        proceed = identifier(b, l + 1);
      }
    }
    return false;
  }

  /* ********************************************************** */
  // var_identifier|appleScriptProperty
  public static boolean identifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier")) return false;
    boolean r;
    PsiBuilder.Marker m = enter_section_(b, l, _NONE_, "<identifier>");
    r = consumeToken(b, VAR_IDENTIFIER);
//    if (!r) r = appleScriptProperty(b, l + 1);
    exit_section_(b, l, m, IDENTIFIER, r, false, null);
    return r;
  }

}
