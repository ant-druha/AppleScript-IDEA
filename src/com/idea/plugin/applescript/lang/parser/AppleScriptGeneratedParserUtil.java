package com.idea.plugin.applescript.lang.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.parser.GeneratedParserUtilBase;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.omg.CORBA.StringHolder;

import static com.idea.plugin.applescript.AppleScriptNames.SCRIPTING_ADDITION_COMMAND_NAMES;
import static com.idea.plugin.applescript.psi.AppleScriptTypes.*;

/**
 * Created by Andrey on 13.04.2015.
 */
public class AppleScriptGeneratedParserUtil extends GeneratedParserUtilBase {

  public static boolean parseDictionaryCommandName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parseDictionaryCommandName")) return false;
    boolean r;
    //todo how not to make it check twice?
    PsiBuilder.Marker m = enter_section_(b, l, _AND_, "<Parse Dictionary Command Name>");
    r = parseDictionaryCommandNameInner(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    if (r) {
      r = parseDictionaryCommandNameInner(b, l + 1);
      return r;
    }
    return false;

//    final String[] stdCommands = SCRIPTING_ADDITION_COMMAND_NAMES;
//    for (String name : stdCommands) {
//      if (tryToParseDictionaryName(b, l, name)) {
//        return true;
//      }
//    }
//    return false;
  }

  private static boolean tryToParseDictionaryName(PsiBuilder b, int l, String name) {
    if (!recursion_guard_(b, l, "tryToParseDictionaryName")) return false;
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

  /**
   * Matches to the shortest parsed name
   *
   * @return true if name matches
   */
  //todo add not only identifiers parsing
  private static boolean parseDictionaryCommandNameInner(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parseDictionaryCommandNameInner")) return false;

    boolean advance;
    StringHolder currentTokenText = new StringHolder();
    currentTokenText.value = "";

    if (b.getTokenType() == VAR_IDENTIFIER) {
      currentTokenText.value = b.getTokenText() == null ? "" : b.getTokenText();
      if (isScriptingAdditionCommandName(currentTokenText.value)) {
        advance = identifier(b, l + 1);
        return true;
      }
    }
    advance = consumeIdentifierAndAppendText(b, l + 1, currentTokenText);
    while (advance) {
      if (isScriptingAdditionCommandName(currentTokenText.value)) {
        advance = identifier(b, l + 1);
        return true;
      }
      advance = consumeIdentifierAndAppendText(b, l + 1, currentTokenText);
    }
    return false;
  }

  private static boolean lookAheadToIdentifierAndAppendText(PsiBuilder b, int l, StringHolder result) {
    boolean r;
    PsiBuilder.Marker m = enter_section_(b, l, _AND_, "<look Ahead To Identifier And Get Text>");
    r = consumeIdentifierAndAppendText(b, l + 1, result);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  private static boolean consumeIdentifierAndAppendText(PsiBuilder b, int l, @NotNull StringHolder result) {
    if (!recursion_guard_(b, l, "consumeIdentifierAndAppendText")) return false;
    boolean r;
    r = identifier(b, l + 1);
    if (r) {
      result.value = StringUtil.isEmpty(result.value) ? result.value = b.getTokenText() :
              result.value + " " + b.getTokenText();
    }
    return r;
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

  private static boolean isScriptingAdditionCommandName(String name) {
    if (!StringUtil.isEmpty(name)) {
      for (String stdName : SCRIPTING_ADDITION_COMMAND_NAMES) {
        if (stdName.equals(name)) {
          return true;
        }
      }
    }
    return false;
  }

}
