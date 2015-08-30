package com.idea.plugin.applescript.lang.parser;

import com.idea.plugin.applescript.lang.ide.libraries.ScriptSuiteRegistry;
import com.idea.plugin.applescript.lang.parcer.AppleScriptParser;
import com.idea.plugin.applescript.lang.sdef.*;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.parser.GeneratedParserUtilBase;
import com.intellij.openapi.util.Key;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;
import org.omg.CORBA.StringHolder;

import java.util.List;

import static com.idea.plugin.applescript.AppleScriptNames.PARSED_COMMAND_PARAMETER_NAMES;
import static com.idea.plugin.applescript.psi.AppleScriptTypes.*;

/**
 * Created by Andrey on 13.04.2015.
 */
public class AppleScriptGeneratedParserUtil extends GeneratedParserUtilBase {

  private static final Key<Boolean> IS_PARSING_COMMAND_HANDLER_CALL_PARAMETERS =
          Key.create("applescript.parsing.command.handler.parameters");
  private static final Key<Boolean> IS_PARSING_COMMAND_ASSIGNMENT_STATEMENT =
          Key.create("applescript.parsing.assignment.statement");
  private static final Key<Boolean> IS_PARSING_COMMAND_HANDLER_BOOLEAN_PARAMETER =
          Key.create("applescript.parsing.command.handler.boolean.parameter");
  private static final Key<List<ApplicationDictionary>> SCRIPT_DICTIONARIES =
          Key.create("applescript.parsing.current.dictionary.stack");


  enum DeclaredType {
    SDEF_COMMAND_NAME,
    PROPERTY_LABEL_NAME,
    SDEF_COMMAND_PARAMETER_SELECTOR,
    SDEF_CLASS_NAME,
    SDEF_CONSTANT

  }

  public static boolean parseDictionaryCommandNameInner(PsiBuilder b, int l, StringHolder parsedName) {
    if (!recursion_guard_(b, l, "parseDictionaryCommandNameInner")) return false;
    boolean r;
    PsiBuilder.Marker m = enter_section_(b, l, _COLLAPSE_, "<parse ApplicationDictionary Command Name>");
//    PsiBuilder.Marker m = enter_section_(b, l, _AND_, "<parse ApplicationDictionary Command Name>");
    r = parseCommandName(b, l + 1, parsedName);
    exit_section_(b, l, m, DICTIONARY_COMMAND_NAME, r, false, null);
//    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  private static boolean parseDeclaredNameInner(PsiBuilder b, int l, DeclaredType dictionaryDeclaredType, IElementType
          tokenType, StringHolder parsedName) {
    if (!recursion_guard_(b, l, "parseDictionaryCommandNameInner")) return false;
    boolean r;
    r = tryToParseDeclaredName(b, l + 1, dictionaryDeclaredType, parsedName);
    return r;
  }


  public static boolean parseDictionaryCommandName(PsiBuilder b, int l) {
    return parseDeclaredNameInner(b, l, DeclaredType.SDEF_COMMAND_NAME);
  }

  /**
   * <<< COMMAND_HANDLER_CALL_EXPRESSION >>>
   */
  // commandName commandParameters?
  public static boolean parseCommandHandlerCallExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parseCommandHandlerCallExpression")) return false;
    boolean r;
    StringHolder parsedCommandName = new StringHolder();
    r = parseDictionaryCommandNameInner(b, l + 1, parsedCommandName);
    //very un-efficient to call service here
//    ServiceManager.getService()
    // usual component then ?
    b.getProject().getComponent(ScriptSuiteRegistry.class);// is it too heavy??


    final AppleScriptCommand dictionaryCommand = ParsableScriptSuiteRegistryHelper.
            findCommandWithName(parsedCommandName.value);
    final List<AppleScriptCommand> allCommandsWithName = ParsableScriptSuiteRegistryHelper.
            getAllCommandsWithName(parsedCommandName.value);
    for (AppleScriptCommand command : allCommandsWithName) {
      PsiBuilder.Marker m = enter_section_(b, l, _AND_, "<parse command handler call Expression>");
      r = parseParametersForCommand(b, l + 1, command);
      //todo NLS does not work in the cases when command is written in parenthesis
      r = r && (b.getTokenType() == NLS || b.getTokenType() == COMMENT || b.eof() /*b.getTokenType() == null*/
              || b.getTokenType() == RPAREN);//todo could not be correct condition in some cases???
      exit_section_(b, l, m, null, r, false, null);
      if (r) {
        r = parseParametersForCommand(b, l + 1, command);
        break;
      }
    }
//    r = r && dictionaryCommand != null;
    if (dictionaryCommand != null) {
      String qName = dictionaryCommand.getQualifiedPath();
      qName.toLowerCase();
    }

//    r = r && dictionaryCommand != null && parseParametersForCommand(b, l + 1, dictionaryCommand); //not

    return r;
  }

  // of? directParameterValue? commandParameters?
  public static boolean parseParametersForCommand(PsiBuilder b, int l, final AppleScriptCommand
          parsedCommandDefinition) {
    if (!recursion_guard_(b, l, "parseParametersForCommand")) return false;
    boolean r = true;
    PsiBuilder.Marker m = enter_section_(b, l, _NONE_, "<parse command handler call parameters>");
//    PsiBuilder.Marker m = enter_section_(b, l, _AND_, "<parse command handler call parameters>");
    b.putUserData(IS_PARSING_COMMAND_HANDLER_CALL_PARAMETERS, true);
    if (parsedCommandDefinition.getDirectParameter() != null) {
      consumeToken(b, OF); //not mandatory
      r = parseCommandDirectParameterValue(b, l + 1, parsedCommandDefinition.getDirectParameter());
    }
    if (!parsedCommandDefinition.getParameters().isEmpty()) {
      r = r && parseCommandParameters(b, l + 1, parsedCommandDefinition);
    }
    exit_section_(b, l, m, null, r, false, null);
    b.putUserData(IS_PARSING_COMMAND_HANDLER_CALL_PARAMETERS, false);
    return r;
  }

  public static boolean isParsingCommandHandlerCallParameters(PsiBuilder b, int l) {
    return b.getUserData(IS_PARSING_COMMAND_HANDLER_CALL_PARAMETERS) == Boolean.TRUE;
  }

  public static boolean isTreePrevSimpleReference(PsiBuilder b, int l) {
    boolean treePrevSimpleRef = b.getLatestDoneMarker() != null
            && b.getLatestDoneMarker().getTokenType() == REFERENCE_IDENTIFIER
            && b.getUserData(IS_PARSING_COMMAND_HANDLER_CALL_PARAMETERS) != Boolean.TRUE;
    boolean treePrevNotLValAssignment =
            b.getUserData(IS_PARSING_COMMAND_ASSIGNMENT_STATEMENT) != Boolean.TRUE;

    return treePrevSimpleRef && treePrevNotLValAssignment;
    //return b.getUserData(IS_PARSING_COMMAND_HANDLER_CALL_PARAMETERS) == Boolean.TRUE;
  }

  public static boolean parseAssignmentStatementInner(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignmentStatement")) return false;
    boolean r;
    b.putUserData(IS_PARSING_COMMAND_ASSIGNMENT_STATEMENT, true);
    r = AppleScriptParser.assignmentStatement(b, l + 1);
    b.putUserData(IS_PARSING_COMMAND_ASSIGNMENT_STATEMENT, false);
    return r;
  }

  public static boolean parseDictionaryClassIdentifierPluralInner(PsiBuilder b, int l) {
    return recursion_guard_(b, l, "parseBuiltInClassIdentifierPluralInner") &&
            parseDictionaryClassNameInner(b, l, true);
  }

  // ( commandParameter)*
  private static boolean parseCommandParameters(PsiBuilder b, int l, AppleScriptCommand commandDefinition) {
    if (!recursion_guard_(b, l, "parseCommandParameters")) return false;
    boolean r = true;
    StringHolder parsedParameterSelector = new StringHolder();
    parsedParameterSelector.value = "";//todo check if it is needed
    PsiBuilder.Marker m = enter_section_(b, l, _NONE_, "<parse Command Parameters>");
    /**
     * Command handler definitions need not include all of the possible parameters of the commands they respond to.
     * If a commandDefinition handler receives more parameters than are specified in the commandDefinition handler
     * definition, it ignores the extra parameters.
     * ...and it looks like order can be arbitrary
     */
    //todo implement part with ignoring parameters which are not in command definition
    //just remove i < ...size() condition ?
    final List<CommandParameter> mandatoryParams = commandDefinition.getMandatoryParameters();
    if (!mandatoryParams.isEmpty()) {
      for (int i = 0; i < commandDefinition.getParameters().size() && !nextTokenIs(b, "", COMMENT, NLS) && r; i++) {
        r = parseParameterForCommand(b, l + 1, commandDefinition, parsedParameterSelector);
        mandatoryParams.remove(commandDefinition.getParameterByName(parsedParameterSelector.value));
        parsedParameterSelector.value = "";
      }
    } else {
      for (int i = 0; i < commandDefinition.getParameters().size() && !nextTokenIs(b, "", COMMENT, NLS) && r; i++) {
        r = parseParameterForCommand(b, l + 1, commandDefinition, parsedParameterSelector);
        parsedParameterSelector.value = "";
      }
    }
    r = mandatoryParams.isEmpty();//we only need to ensure that all mandatory params were specified
    exit_section_(b, l, m, null, r, false, null);

    return r;
  }

  // (given? commandParameterSelector parameterValue)
  // | ( (with|without) commandParameterSelector )
  private static boolean parseParameterForCommand(PsiBuilder b, int l, AppleScriptCommand command, StringHolder
          parsedParameterSelector) {
    if (!recursion_guard_(b, l, "parseParameterForCommand")) return false;
    boolean r;
    PsiBuilder.Marker m = enter_section_(b, l, _NONE_, "<parse Parameter For Command>");//todo check here if it works
    //todo here mark as _AND_ ??
    r = parseGivenParameter(b, l + 1, command, parsedParameterSelector);
    //todo and here exit and enter once again if it is true??
    if (!r) r = parseBooleanParameter(b, l + 1, command, parsedParameterSelector);

    exit_section_(b, l, m, COMMAND_PARAMETER, r, false, null);
    return r;
  }

  //(with|without) parameterSelector
  private static boolean parseBooleanParameter(PsiBuilder b, int l, AppleScriptCommand command, StringHolder
          parsedParameterSelector) {
    if (!recursion_guard_(b, l, "parseBooleanParameter")) return false;
    boolean r = false;
    //need to rollback with/without if there is no match
    PsiBuilder.Marker m = enter_section_(b, l, _NONE_, "<parse Boolean Parameter>");
    b.putUserData(IS_PARSING_COMMAND_HANDLER_BOOLEAN_PARAMETER, true);
    r = consumeToken(b, WITH);
    if (!r) r = consumeToken(b, WITHOUT);
    if (!r) r = consumeToken(b, LAND); //for cases like: '...with regexp and all occurrences without case sensitive'
    r = r && parseCommandParameterSelector(b, l + 1, command, parsedParameterSelector);
    exit_section_(b, l, m, null, r, false, null);
    b.putUserData(IS_PARSING_COMMAND_HANDLER_BOOLEAN_PARAMETER, false);
    return r;
  }

  //given? commandParameterSelector parameterValue
  private static boolean parseGivenParameter(PsiBuilder b, int l, AppleScriptCommand command, StringHolder
          parsedParameterSelector) {
    if (!recursion_guard_(b, l, "parseGivenParameter")) return false;
    PsiBuilder.Marker m = enter_section_(b, l, _NONE_, "<parse Given Parameter>");
    consumeToken(b, GIVEN);//optional
    boolean r;
    r = parseCommandParameterSelector(b, l + 1, command, parsedParameterSelector);
    final CommandParameter parameterDefinition = command.getParameterByName(parsedParameterSelector.value);
    r = r && parseCommandParameterValue(b, l + 1, parameterDefinition);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  private static boolean parseCommandParameterValue(PsiBuilder b, int l, CommandParameter parameterDefinition) {
    if (!recursion_guard_(b, l, "parseCommandParameterValue")) return false;
    boolean r = false;
    PsiBuilder.Marker m = enter_section_(b, l, _NONE_, "<parse Command Parameter Value>");

    String parameterTypeSpecifier = parameterDefinition.getTypeSpecifier();
    if ("type".equals(parameterTypeSpecifier)) {
      r = typeSpecifierD(b, l + 1);
    }
    if (!r) r = AppleScriptParser.expression(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  //we need to parse tokens here and get text of the parameter selector and compare with one of possible parameter
  // names
  private static boolean parseCommandParameterSelector(PsiBuilder b, int l, AppleScriptCommand command, StringHolder
          parsedParameterSelector) {
    if (!recursion_guard_(b, l, "parseCommandParameterSelector")) return false;
    boolean r = false;
    PsiBuilder.Marker m = enter_section_(b, l, _NONE_, "<parse Command Parameter Selector>");//todo check this _AND_
    parsedParameterSelector.value = "";
    //todo replace with just b.advanceLexer();
    while (consumeTokenForParameterSelectorAndAppendSelectorText(b, l + 1, parsedParameterSelector)) {
      if (command.getParameterByName(parsedParameterSelector.value) != null) {
        r = true;
        break;
      }
    }
    exit_section_(b, l, m, COMMAND_PARAMETER_SELECTOR, r, false, null);
    return r;

  }

  //we need to parse tokens here and get text of the parameter selector and compare with one of possible parameter
  // names
  private static boolean parseCommandName(PsiBuilder b, int l, StringHolder parsedName) {
    if (!recursion_guard_(b, l, "parseCommandName")) return false;
    boolean r = false;
    PsiBuilder.Marker m = enter_section_(b, l, _NONE_, "<parse Command Name>");
    while (consumeTokenForCommandNameAndAppendNameText(b, l + 1, parsedName)) {
      boolean foundMatch = ParsableScriptSuiteRegistryHelper.findCommandWithName(parsedName.value) != null;
//      boolean foundMatch = ServiceManager.getService(b.getProject(), ParsableScriptSuiteRegistryHelper.class)
//              .findCommandWithName(parsedName.value) != null;
      String tryLookAheadName = "";
      if (foundMatch) {
        //todo check if the text of next tokens matches other dictionary command which starts with parsed name
        r = true;
        tryLookAheadName = parsedName.value + " " + b.getTokenText();
        if (ParsableScriptSuiteRegistryHelper.findCommandsStartingWithName(tryLookAheadName).size() > 0) {
//          r = false;
          continue;
        }
        break;
      }
    }
    exit_section_(b, l, m, null, r, false, null);
    return r;

  }

  private static boolean parseCommandDirectParameterValue(PsiBuilder b, int l, @NotNull CommandDirectParameter
          parameter) {
    if (!recursion_guard_(b, l, "parseCommandDirectParameterValue")) return false;
    boolean r = false;
    PsiBuilder.Marker m = enter_section_(b, l, _NONE_, "<parse Command Direct Parameter Value >");
    String parameterTypeSpecifier = parameter.getTypeSpecifier();
//    if ("type".equals(parameterTypeSpecifier)) {
//      r = typeSpecifierD(b, l + 1);
//    }
    if (!r) r = com.idea.plugin.applescript.lang.parcer.AppleScriptParser.expression(b, l + 1);
    exit_section_(b, l, m, DIRECT_PARAMETER_VAL, r, false, null);
    return r || parameter.isOptional();
  }

  /* ********************************************************** */
  // singularClassName|pluralClassName
  static boolean typeSpecifierD(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeSpecifierD")) return false;
    boolean r;
    PsiBuilder.Marker m = enter_section_(b);
    r = singularClassName(b, l + 1);
//    if (!r) r = pluralClassName(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (builtInClassIdentifierPlural|dictionaryClassIdentifierPlural) ITEM?
  static boolean pluralClassName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pluralClassName")) return false;
    boolean r;
    PsiBuilder.Marker m = enter_section_(b);
    r = pluralClassName_0(b, l + 1);
    r = r && pluralClassName_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // builtInClassIdentifierPlural|dictionaryClassIdentifierPlural
  private static boolean pluralClassName_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pluralClassName_0")) return false;
    boolean r;
    PsiBuilder.Marker m = enter_section_(b);
    r = builtInClassIdentifierPlural(b, l + 1);
    if (!r) r = dictionaryClassIdentifierPlural(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ITEM?
  private static boolean pluralClassName_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pluralClassName_1")) return false;
    consumeToken(b, ITEM);
    return true;
  }

  /* ********************************************************** */
  // <<parseDictionaryClassIdentifierPluralInner>>
  public static boolean dictionaryClassIdentifierPlural(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictionaryClassIdentifierPlural")) return false;
    boolean r;
    PsiBuilder.Marker m = enter_section_(b, l, _NONE_, "<dictionary class identifier plural>");
    r = parseDictionaryClassIdentifierPluralInner(b, l + 1);
    exit_section_(b, l, m, DICTIONARY_CLASS_IDENTIFIER_PLURAL, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // dictionaryClassName|builtInClassIdentifier ITEM?
  static boolean singularClassName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "singularClassName")) return false;
    boolean r;
    PsiBuilder.Marker m = enter_section_(b);
    r = dictionaryClassName(b, l + 1);
    if (!r) r = singularClassName_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // builtInClassIdentifier ITEM?
  private static boolean singularClassName_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "singularClassName_1")) return false;
    boolean r;
    PsiBuilder.Marker m = enter_section_(b);
    r = builtInClassIdentifier(b, l + 1);
    r = r && singularClassName_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ITEM?
  private static boolean singularClassName_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "singularClassName_1_1")) return false;
    consumeToken(b, ITEM);
    return true;
  }

  /* ********************************************************** */
  // <<parseDictionaryClassName>>
  public static boolean dictionaryClassName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictionaryClassName")) return false;
    boolean r;
    PsiBuilder.Marker m = enter_section_(b, l, _NONE_, "<dictionary class name>");
    r = parseDictionaryClassName(b, l + 1);
    exit_section_(b, l, m, DICTIONARY_CLASS_NAME, r, false, null);
    return r;
  }

  public static boolean parseCommandParameterSelector(PsiBuilder b, int l) {
    return false;
//    return parseDeclaredNameInner(b, l, DeclaredType.SDEF_COMMAND_PARAMETER_SELECTOR);
  }

  public static boolean parseDictionaryCommandNameInner(PsiBuilder b, int l) {
    return false;
  }

  private static boolean parseDeclaredNameInner(PsiBuilder b, int l, DeclaredType declaredNameType) {
    if (!recursion_guard_(b, l, "parseDeclaredNameInner")) return false;
    boolean r;
    //todo how not to make it check twice?
    PsiBuilder.Marker m = enter_section_(b, l, _AND_, "<parse Declared Name Inner>");
    r = tryToParseDeclaredName(b, l + 1, declaredNameType);
    exit_section_(b, l, m, null, r, false, null);
    if (r) {
      r = tryToParseDeclaredName(b, l + 1, declaredNameType);
      return r;
    }
    return false;
  }

  public static boolean parseDictionaryPropertyName(PsiBuilder b, int l) {
//    return parseDeclaredNameInner(b, l, DeclaredType.PROPERTY_LABEL_NAME);
    return parseDictionaryPropertyInner(b, l);
  }

  private static boolean parseDictionaryPropertyInner(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parseDictionaryPropertyInner")) return false;
    boolean r;
    //todo how not to make it check twice?
    PsiBuilder.Marker m = enter_section_(b, l, _AND_, "<parse Dictionary Property Inner>");
    r = tryToParseDictionaryProperty(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    if (r) {
      r = tryToParseDictionaryProperty(b, l + 1);
      return r;
    }

    return false;
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

  public static boolean parseDictionaryClassName(PsiBuilder b, int l) {
//    return parseDeclaredNameInner(b, l, DeclaredType.SDEF_CLASS_NAME);
    return parseDictionaryClassNameInner(b, l, false);
  }

  private static boolean parseDictionaryClassNameInner(PsiBuilder b, int l, final boolean isPluralForm) {
    if (!recursion_guard_(b, l, "parseDeclaredNameInner")) return false;
    boolean r;
    //todo how not to make it check twice?
    PsiBuilder.Marker m = enter_section_(b, l, _AND_, "<parse Declared Name Inner>");
    r = tryToParseDictionaryClass(b, l + 1, isPluralForm);
    exit_section_(b, l, m, null, r, false, null);
    if (r) {
//      m = enter_section_(b, l, _COLLAPSE_, "<parse Declared Name Inner>");
      r = tryToParseDictionaryClass(b, l + 1, isPluralForm);
//      exit_section_(b, l, m, null, r, false, null);
      return r;
    }

    return false;
  }

  /* ********************************************************** */
  // builtInClassIdCommon|builtInClassIdNative|script
  public static boolean builtInClassIdentifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "builtInClassIdentifier")) return false;
    boolean r;
    PsiBuilder.Marker m = enter_section_(b, l, _NONE_, "<built in class identifier>");
    r = builtInClassIdCommon(b, l + 1);
    if (!r) r = builtInClassIdNative(b, l + 1);
    if (!r) r = consumeToken(b, SCRIPT);
    exit_section_(b, l, m, BUILT_IN_CLASS_IDENTIFIER, r, false, null);
    return r;
  }

  private static boolean tryToParseDictionaryClass(PsiBuilder b, int l, final boolean isPluralForm) {
    if (!recursion_guard_(b, l, "tryToParseDictionaryClass")) return false;
    StringHolder currentTokenText = new StringHolder();
    currentTokenText.value = b.getTokenText() == null ? "" : b.getTokenText();
//    int candidatesCount = ParsableScriptSuiteRegistryHelper.findClassesStartingWithName(currentTokenText.value)
// .size();
//    int candidatesCount = isPluralForm ?
//            ParsableScriptSuiteRegistryHelper.findClassesStartingWithPluralName(currentTokenText.value).size() :
//            ParsableScriptSuiteRegistryHelper.findClassesStartingWithName(currentTokenText.value).size();
    return findClassNameExactMatch(b, l + 1, currentTokenText, isPluralForm);
  }

  private static boolean tryToParseDictionaryProperty(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryToParseDictionaryProperty")) return false;
    boolean r;

    StringHolder currentTokenText = new StringHolder();
    currentTokenText.value = b.getTokenText() == null ? "" : b.getTokenText();
    int candidatesCount = ParsableScriptSuiteRegistryHelper.findPropertiesStartingWithName(currentTokenText.value)
            .size();
    //find the longest lexeme
    while (b.getTokenText() != null && candidatesCount > 0) {
      if (candidatesCount == 1) {
        if (ParsableScriptSuiteRegistryHelper.getPropertyWithName(currentTokenText.value) != null) {
          r = identifier(b, l + 1);
          if (!r) r = builtInClassIdentifier(b, l + 1);
          if (!r) b.advanceLexer(); //advance lexer in any case

          return true;
        }
        r = identifier(b, l + 1);
        if (!r) r = builtInClassIdentifier(b, l + 1);
        if (!r) b.advanceLexer(); //advance lexer in any case

        currentTokenText.value = currentTokenText.value + " " + b.getTokenText();
        candidatesCount = ParsableScriptSuiteRegistryHelper.findPropertiesStartingWithName(currentTokenText.value)
                .size();

      } else {
        boolean foundExactMatch = ParsableScriptSuiteRegistryHelper.getPropertyWithName(currentTokenText.value) != null;
        r = identifier(b, l + 1);
        if (!r) r = builtInClassIdentifier(b, l + 1);
        if (!r) b.advanceLexer(); //advance lexer in any case

        currentTokenText.value = currentTokenText.value + " " + b.getTokenText();
        candidatesCount = ParsableScriptSuiteRegistryHelper.findPropertiesStartingWithName(currentTokenText.value)
                .size();
        if (candidatesCount == 0) {
          return foundExactMatch;
        }
      }
    }
    return false;
  }

  private static boolean findClassNameExactMatch(PsiBuilder b, int l, StringHolder currentTokenText,
                                                 final boolean isPluralForm) {
    if (isPluralForm) {
      int candidatesCount = ParsableScriptSuiteRegistryHelper.findClassesStartingWithPluralName(
              currentTokenText.value).size();
      while (b.getTokenText() != null && candidatesCount > 0) {
        if (candidatesCount == 1) {
          if (ParsableScriptSuiteRegistryHelper.findClassByPluralName(currentTokenText.value) != null) {
            boolean r = identifier(b, l + 1);
            if (!r) r = builtInClassIdentifier(b, l + 1);
            if (!r) b.advanceLexer(); //advance lexer in any case

            return true;
          }
          boolean r = identifier(b, l + 1);
          if (!r) r = builtInClassIdentifier(b, l + 1);
          if (!r) b.advanceLexer(); //advance lexer in any case

          currentTokenText.value = currentTokenText.value + " " + b.getTokenText();
          candidatesCount = ParsableScriptSuiteRegistryHelper.findClassesStartingWithPluralName(
                  currentTokenText.value).size();

        } else {
          boolean foundExactMatch = ParsableScriptSuiteRegistryHelper.findClassByPluralName(currentTokenText.value)
                  != null;
          boolean r = identifier(b, l + 1);
          if (!r) r = builtInClassIdentifier(b, l + 1);
          if (!r) b.advanceLexer(); //advance lexer in any case

          currentTokenText.value = currentTokenText.value + " " + b.getTokenText();
          candidatesCount = ParsableScriptSuiteRegistryHelper.findClassesStartingWithPluralName(
                  currentTokenText.value).size();
          if (candidatesCount == 0) {
            return foundExactMatch;
          }
        }
      }
      return false;
    } else {
      int candidatesCount = ParsableScriptSuiteRegistryHelper.findClassesStartingWithName(currentTokenText.value)
              .size();
      while (b.getTokenText() != null && candidatesCount > 0) {
        if (candidatesCount == 1) {
          if (ParsableScriptSuiteRegistryHelper.findClassWithName(currentTokenText.value) != null) {
            boolean r = identifier(b, l + 1);
            if (!r) r = builtInClassIdentifier(b, l + 1);
            if (!r) b.advanceLexer(); //advance lexer in any case

            return true;
          }
          boolean r = identifier(b, l + 1);
          if (!r) r = builtInClassIdentifier(b, l + 1);
          if (!r) b.advanceLexer(); //advance lexer in any case

          currentTokenText.value = currentTokenText.value + " " + b.getTokenText();
          candidatesCount = ParsableScriptSuiteRegistryHelper.findClassesStartingWithName(currentTokenText.value)
                  .size();

        } else {
          boolean foundExactMatch = ParsableScriptSuiteRegistryHelper.findClassWithName(currentTokenText.value) != null;
          boolean r = identifier(b, l + 1);
          if (!r) r = builtInClassIdentifier(b, l + 1);
          if (!r) b.advanceLexer(); //advance lexer in any case

          currentTokenText.value = currentTokenText.value + " " + b.getTokenText();
          candidatesCount = ParsableScriptSuiteRegistryHelper.findClassesStartingWithName(currentTokenText.value)
                  .size();
          if (candidatesCount == 0) {
            return foundExactMatch;
          }
        }
      }
      return false;
    }
  }

  public static boolean parseDictionaryConstant(PsiBuilder b, int l) {
//    return parseDeclaredNameInner(b, l, DeclaredType.SDEF_CONSTANT);
    return parseDictionaryConstantInner(b, l);
  }

  private static boolean parseDictionaryConstantInner(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parseDeclaredNameInner")) return false;
    boolean r;
    //todo how not to make it check twice?
    PsiBuilder.Marker m = enter_section_(b, l, _AND_, "<parse Declared Name Inner>");
    r = tryToParseDictionaryConstant(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    if (r) {
      r = tryToParseDictionaryConstant(b, l + 1);
      return r;
    }

    return false;
  }

  private static boolean tryToParseDictionaryConstant(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryToParseDictionaryClass")) return false;
    StringHolder currentTokenText = new StringHolder();
    currentTokenText.value = "";
    currentTokenText.value = b.getTokenText() == null ? "" : b.getTokenText();
    int candidatesCount = ParsableScriptSuiteRegistryHelper.findConstantsStartingWithWord(currentTokenText.value)
            .size();
    while (b.getTokenText() != null && candidatesCount > 0) {
      if (candidatesCount == 1) {
        if (ParsableScriptSuiteRegistryHelper.getEnumerator(currentTokenText.value) != null) {
          b.advanceLexer();
          return true;
        }
        b.advanceLexer();
        currentTokenText.value = currentTokenText.value + " " + b.getTokenText();
        candidatesCount = ParsableScriptSuiteRegistryHelper.findConstantsStartingWithWord(currentTokenText.value)
                .size();
      } else {
        boolean foundExactMatch = ParsableScriptSuiteRegistryHelper.getEnumerator(currentTokenText.value) != null;
        b.advanceLexer();
        currentTokenText.value = currentTokenText.value + " " + b.getTokenText();
        candidatesCount = ParsableScriptSuiteRegistryHelper.findConstantsStartingWithWord(currentTokenText.value)
                .size();
        if (candidatesCount == 0) {
          return foundExactMatch;
        }
      }

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
  //todo candidates count like with dictionary classes to match the biggest input
  private static boolean tryToParseDeclaredName(PsiBuilder b, int l, DeclaredType declaredNameType) {
    if (!recursion_guard_(b, l, "tryToParseDeclaredName")) return false;

    boolean advance;
    StringHolder currentTokenText = new StringHolder();
    currentTokenText.value = b.getTokenText() == null ? "" : b.getTokenText();
    String currTokenTextVal = currentTokenText.value;
    if (isThisNameDeclared(currTokenTextVal, declaredNameType)) {
      b.advanceLexer();
      return true;
    }
    advance = consumeSimpleIdentifierAndAppendText(b, l + 1, currentTokenText, declaredNameType);
    while (advance) {
      boolean foundDictionaryMatch = isThisNameDeclared(currentTokenText.value, declaredNameType);
      if (foundDictionaryMatch) {
        b.advanceLexer();
        return true;
      }
      advance = consumeSimpleIdentifierAndAppendText(b, l + 1, currentTokenText, declaredNameType);
    }
    return false;
  }

  private static List<DictionaryComponent> findDictionaryTypeWithName(String currTokenTextVal, DeclaredType
          declaredNameType) {
    return null;
  }

  private static boolean tryToParseDeclaredName(PsiBuilder b, int l, DeclaredType dictionaryDeclaredType,
                                                StringHolder parsedName) {
    if (!recursion_guard_(b, l, "tryToParseDeclaredName")) return false;

    boolean advance;
    StringHolder currentTokenText = new StringHolder();
    currentTokenText.value = "";
//    TokenSet tokensToConsume;
//
//    if (dictionaryDeclaredType == DeclaredType.SDEF_COMMAND_NAME) {//DICTIONARY_COMMAND_NAME IElementType
//      tokensToConsume = TokenSet.create(VAR_IDENTIFIER, BY, FROM, INSTEAD_OF, INTO, ON, OUT_OF, THRU,
//              THROUGH, TO, BUILT_IN_CLASS_ID);
//    } else if (dictionaryDeclaredType == DeclaredType.SDEF_COMMAND_PARAMETER_SELECTOR) {
//      //todo where to check for with/without?
//    }
    currentTokenText.value = b.getTokenText() == null ? "" : b.getTokenText();
    if (isThisNameDeclared(currentTokenText.value, dictionaryDeclaredType)) {
      b.advanceLexer();
      return true;
    }
    advance = consumeSimpleIdentifierAndAppendText(b, l + 1, currentTokenText, dictionaryDeclaredType);
    while (advance) {
      if (isThisNameDeclared(currentTokenText.value, dictionaryDeclaredType)) {
        b.advanceLexer();
        return true;
      }
      advance = consumeSimpleIdentifierAndAppendText(b, l + 1, currentTokenText, dictionaryDeclaredType);
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

  //propertyOrClassSimpleIdentifier
  private static boolean consumeSimpleIdentifierAndAppendText(PsiBuilder b, int l, @NotNull StringHolder result,
                                                              DeclaredType declaredNameType) {
    if (!recursion_guard_(b, l, "consumeIdentifierAndAppendText")) return false;
    boolean r;
    r = propertyOrClassSimpleIdentifier(b, l);
    if (r) {
      result.value = StringUtil.isEmpty(result.value) ? result.value = b.getTokenText() :
              result.value + " " + b.getTokenText();
    }
    return r;
  }


  private static boolean consumeTokenForParameterSelectorAndAppendSelectorText(PsiBuilder b, int l, @NotNull
  StringHolder result) {
    if (!recursion_guard_(b, l, "consumeIdentifierAndAppendText")) return false;
    boolean r;
    String textToAccept = b.getTokenText() != null ? b.getTokenText() : "";
    r = dictionaryCommandParameterSelectorTokens(b, l + 1);//todo to check is it is ok not to mark them
    if (r) {
      result.value = StringUtil.isEmpty(result.value) ? result.value = textToAccept :
              result.value + " " + textToAccept;
    }
    return r;
  }

  //todo replace with just b.advanceLexer();
  private static boolean dictionaryCommandParameterSelectorTokens(PsiBuilder b, int l) {
    boolean r;
    PsiBuilder.Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    if (!r) r = builtInClassIdentifier(b, l + 1);
    if (!r) r = builtInClassIdentifierPlural(b, l + 1);
    if (!r) r = handlerParameterLabel(b, l + 1);
    if (!r) r = consumeToken(b, IN);
    if (!r) r = consumeToken(b, COPY); //without one copy
    if (!r) r = consumeToken(b, AFTER);
    if (!r) r = consumeToken(b, BEFORE);
    if (!r) r = consumeToken(b, BEGINNING);
    if (!r) r = consumeToken(b, FRONT);
    if (!r) r = consumeToken(b, BACK);
    if (!r) r = consumeToken(b, END);
    if (!r) r = consumeToken(b, AS);

    if (!r && b.getUserData(IS_PARSING_COMMAND_HANDLER_BOOLEAN_PARAMETER) != Boolean.TRUE) {
      r = consumeToken(b, WITH);
      if (!r) r = consumeToken(b, WITHOUT);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  private static boolean consumeTokenForCommandNameAndAppendNameText(PsiBuilder b, int l,
                                                                     @NotNull StringHolder result) {
    if (!recursion_guard_(b, l, "consumeIdentifierAndAppendText")) return false;
    boolean r;
    String textToAccept = b.getTokenText() != null ? b.getTokenText() : "";
    r = dictionaryCommandNameTokens(b, l + 1);//todo to check is it is ok not to mark them
    if (r) {
      result.value = StringUtil.isEmpty(result.value) ? result.value = textToAccept :
              result.value + " " + textToAccept;
      //b.advanceLexer();
    }
    return r;
  }


  /*
   * Tokens, used for parsing command name
   */
  /* ********************************************************** */
  // identifier|builtInClassName|builtInClassNamePlural|handlerParameterLabel|run|count|script
  static boolean dictionaryCommandNameTokens(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictionaryCommandNameTokens")) return false;
    boolean r;
    PsiBuilder.Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    if (!r) r = builtInClassIdentifier(b, l + 1);
    if (!r) r = builtInClassIdentifierPlural(b, l + 1);
    if (!r) r = handlerParameterLabel(b, l + 1);
    if (!r) r = consumeToken(b, RUN);
    if (!r) r = consumeToken(b, COUNT);
    if (!r) r = consumeToken(b, SCRIPT);
    if (!r) r = consumeToken(b, WITH);//todo check this
    if (!r) r = consumeToken(b, WITHOUT);
    exit_section_(b, m, null, r);
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


  static boolean propertyOrClassSimpleIdentifier(PsiBuilder b, int l) {
    return recursion_guard_(b, l, "builtInClassIdentifier")
            && consumeCommandNameOrParameterName(b, l);
  }

  /* ********************************************************** */
  // builtInClassIdentifier"s"|scripts
  public static boolean builtInClassIdentifierPlural(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "builtInClassIdentifierPlural")) return false;
    boolean r;
//    PsiBuilder.Marker m = enter_section_(b, l, _NONE_, "<built in class identifier plural>");
    r = builtInClassIdentifierPlural_0(b, l + 1);
    if (!r) r = consumeToken(b, SCRIPTS);
//    exit_section_(b, l, m, BUILT_IN_CLASS_IDENTIFIER_PLURAL, r, false, null);
    return r;
  }

  // builtInClassIdentifier"s"
  private static boolean builtInClassIdentifierPlural_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "builtInClassIdentifierPlural_0")) return false;
    boolean r;
    PsiBuilder.Marker m = enter_section_(b);
    r = builtInClassIdentifier(b, l + 1);
    r = r && consumeToken(b, "s");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // STRING|CLASS|CONSTANT|LIST|DATA|REFERENCE|STYLED_TEXT|TEXT_ITEM|ITEM|FILE_SPECIFICATION|
  // INTERNATIONAL_TEXT|RGB_COLOR|STYLED_CLIPBOARD_TEXT|unitTypeValueClasses
  static boolean builtInClassIdCommon(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "builtInClassIdCommon")) return false;
    boolean r;
    PsiBuilder.Marker m = enter_section_(b);
    r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, CLASS);
    if (!r) r = consumeToken(b, CONSTANT);
    if (!r) r = consumeToken(b, LIST);
    if (!r) r = consumeToken(b, DATA);
    if (!r) r = consumeToken(b, REFERENCE);
    if (!r) r = consumeToken(b, STYLED_TEXT);
    if (!r) r = consumeToken(b, TEXT_ITEM);
    if (!r) r = consumeToken(b, ITEM);
    if (!r) r = consumeToken(b, FILE_SPECIFICATION);
    if (!r) r = consumeToken(b, INTERNATIONAL_TEXT);
    if (!r) r = consumeToken(b, RGB_COLOR);
    if (!r) r = consumeToken(b, STYLED_CLIPBOARD_TEXT);
    if (!r) r = unitTypeValueClasses(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Length|SQUARE_AREA|CUBIC_VOL|LiquidVolume|Weight|TEMPERATURE
  static boolean unitTypeValueClasses(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unitTypeValueClasses")) return false;
    boolean r;
    PsiBuilder.Marker m = enter_section_(b);
    r = Length(b, l + 1);
    if (!r) r = consumeToken(b, SQUARE_AREA);
    if (!r) r = consumeToken(b, CUBIC_VOL);
    if (!r) r = LiquidVolume(b, l + 1);
    if (!r) r = Weight(b, l + 1);
    if (!r) r = consumeToken(b, TEMPERATURE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // CENTIMETRES|CENTIMETERS|FEET|INCHES|KILOMETRES|KILOMETERS|METRES|METERS|MILES|YARDS
  static boolean Length(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Length")) return false;
    boolean r;
    PsiBuilder.Marker m = enter_section_(b);
    r = consumeToken(b, CENTIMETRES);
    if (!r) r = consumeToken(b, CENTIMETERS);
    if (!r) r = consumeToken(b, FEET);
    if (!r) r = consumeToken(b, INCHES);
    if (!r) r = consumeToken(b, KILOMETRES);
    if (!r) r = consumeToken(b, KILOMETERS);
    if (!r) r = consumeToken(b, METRES);
    if (!r) r = consumeToken(b, METERS);
    if (!r) r = consumeToken(b, MILES);
    if (!r) r = consumeToken(b, YARDS);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // GALLONS|LITRES|LITERS|QUARTS
  static boolean LiquidVolume(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LiquidVolume")) return false;
    boolean r;
    PsiBuilder.Marker m = enter_section_(b);
    r = consumeToken(b, GALLONS);
    if (!r) r = consumeToken(b, LITRES);
    if (!r) r = consumeToken(b, LITERS);
    if (!r) r = consumeToken(b, QUARTS);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // GRAMS|KILOGRAMS|OUNCES|POUNDS
  static boolean Weight(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Weight")) return false;
    boolean r;
    PsiBuilder.Marker m = enter_section_(b);
    r = consumeToken(b, GRAMS);
    if (!r) r = consumeToken(b, KILOGRAMS);
    if (!r) r = consumeToken(b, OUNCES);
    if (!r) r = consumeToken(b, POUNDS);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ANY|BOOLEAN|DATE|FILE|INTEGER|LOCATION_SPECIFIER|NUMBER|POINT|REAL|RECORD|RECTANGLE|
  // SPECIFIER|TEXT|TYPE
  static boolean builtInClassIdNative(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "builtInClassIdNative")) return false;
    boolean r;
    PsiBuilder.Marker m = enter_section_(b);
    r = consumeToken(b, ANY);
    if (!r) r = consumeToken(b, BOOLEAN);
    if (!r) r = consumeToken(b, DATE);
    if (!r) r = consumeToken(b, FILE);
    if (!r) r = consumeToken(b, INTEGER);
    if (!r) r = consumeToken(b, LOCATION_SPECIFIER);
    if (!r) r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, POINT);
    if (!r) r = consumeToken(b, REAL);
    if (!r) r = consumeToken(b, RECORD);
    if (!r) r = consumeToken(b, RECTANGLE);
    if (!r) r = consumeToken(b, SPECIFIER);
    if (!r) r = consumeToken(b, TEXT);
    if (!r) r = consumeToken(b, TYPE);
    if (!r) r = consumeToken(b, ALIAS);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // builtInClassName|builtInClassNamePlural|identifier
  //todo but how to mark Element out element type..
  static boolean consumeTokenFromSet(PsiBuilder b, int l, TokenSet tokenSet) {
    if (!recursion_guard_(b, l, "consumeTokenFromSet")) return false;
    boolean r = false;
    PsiBuilder.Marker m = enter_section_(b);
    if (tokenSet.contains(b.getTokenType())) {
      b.advanceLexer();
      r = true;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  private static boolean consumeCommandNameOrParameterName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "consumeCommandNameOrParameterName")) return false;
    boolean r;
    PsiBuilder.Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    if (!r) r = builtInClassIdentifier(b, l + 1);
    if (!r) r = builtInClassIdentifierPlural(b, l + 1);
    if (!r) r = handlerParameterLabel(b, l + 1);
    if (!r) r = consumeToken(b, RUN);
    if (!r) r = consumeToken(b, COUNT);
    if (!r) r = consumeToken(b, SCRIPT);
    if (!r)
      r = consumeToken(b, WITH);//could be 'with properties' as a name but with/without 'altering line endings' like
    // value
//    if (!r) r = consumeToken(b, WITHOUT);
//    if (!r) r = consumeToken(b, GIVEN);

    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // about|above|against|'apart from'|around|'aside from'|at|below|beneath|beside|between   // spaces ??
  //                      |by|for|from|'instead of'|into|on|onto|'out of'|over|since|thru|through|under
  // |to
  public static boolean handlerParameterLabel(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerParameterLabel")) return false;
    boolean r;
    PsiBuilder.Marker m = enter_section_(b, l, _NONE_, "<handler parameter label>");
    r = consumeToken(b, ABOUT);
    if (!r) r = consumeToken(b, ABOVE);
    if (!r) r = consumeToken(b, AGAINST);
    if (!r) r = consumeToken(b, APART_FROM);
    if (!r) r = consumeToken(b, AROUND);
    if (!r) r = consumeToken(b, ASIDE_FROM);
    if (!r) r = consumeToken(b, AT);
    if (!r) r = consumeToken(b, BELOW);
    if (!r) r = consumeToken(b, BENEATH);
    if (!r) r = consumeToken(b, BESIDE);
    if (!r) r = consumeToken(b, BETWEEN);
    if (!r) r = consumeToken(b, BY);
    if (!r) r = consumeToken(b, FOR);
    if (!r) r = consumeToken(b, FROM);
    if (!r) r = consumeToken(b, INSTEAD_OF);
    if (!r) r = consumeToken(b, INTO);
    if (!r) r = consumeToken(b, ON);
    if (!r) r = consumeToken(b, ONTO);
    if (!r) r = consumeToken(b, OUT_OF);
    if (!r) r = consumeToken(b, OVER);
    if (!r) r = consumeToken(b, SINCE);
    if (!r) r = consumeToken(b, THRU);
    if (!r) r = consumeToken(b, THROUGH);
    if (!r) r = consumeToken(b, UNDER);
    if (!r) r = consumeToken(b, TO);
//    exit_section_(b, l, m, HANDLER_PARAMETER_LABEL, r, false, null);//todo do we need this?
    exit_section_(b, l, m, null, r, false, null);//todo do we need this?
    return r;
  }


  private static boolean isThisNameDeclared(String name, DeclaredType declaredNameType) {
    if (!StringUtil.isEmpty(name)) {
      boolean r;
      switch (declaredNameType) {
        case SDEF_COMMAND_NAME:
          if (ParsableScriptSuiteRegistryHelper.findCommandWithName(name) != null)
            return true;

//          for (String stdName : SCRIPTING_ADDITION_COMMAND_NAMES) {
//            if (stdName.equals(name))
//              return true;
//          }
          break;
        case PROPERTY_LABEL_NAME:
          if (ParsableScriptSuiteRegistryHelper.getPropertyWithName(name) != null)
            return true;

//          for (String stdName : PARSED_SCRIPT_OBJECTS_PROPERTIES) {
//            if (stdName.equals(name))
//              return true;
//          }
          break;
        case SDEF_COMMAND_PARAMETER_SELECTOR:
          for (String stdName : PARSED_COMMAND_PARAMETER_NAMES) {
            if (stdName.equals(name))
              return true;
          }
          break;
        case SDEF_CLASS_NAME:
          if (ParsableScriptSuiteRegistryHelper.findClassWithName(name) != null)
            return true;

//          for (String stdName : PARSED_CLASS_NAMES) {
//            if (stdName.equals(name))
//              return true;
//          }
          break;
        case SDEF_CONSTANT:
          if (ParsableScriptSuiteRegistryHelper.getEnumerator(name) != null)
            return true;
          break;

        default:
          return false;
      }
    }
    return false;
  }
}
