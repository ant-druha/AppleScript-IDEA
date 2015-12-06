package com.idea.plugin.applescript.lang.parser;

import com.idea.plugin.applescript.AppleScriptNames;
import com.idea.plugin.applescript.lang.parcer.AppleScriptParser;
import com.idea.plugin.applescript.lang.sdef.AppleScriptCommand;
import com.idea.plugin.applescript.lang.sdef.ApplicationDictionary;
import com.idea.plugin.applescript.lang.sdef.CommandDirectParameter;
import com.idea.plugin.applescript.lang.sdef.CommandParameter;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.parser.GeneratedParserUtilBase;
import com.intellij.openapi.util.Key;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.omg.CORBA.StringHolder;

import java.util.*;

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

  public static final Key<Stack<ApplicationDictionary>> SCRIPT_DICTIONARY_STACK =
          Key.create("applescript.parsing.current.dictionary.stack");
  // for storing application names inside <tell...end tell> statements
  public static final Key<Stack<String>> TOLD_APPLICATION_NAME_STACK =
          Key.create("applescript.parsing.current.dictionary.name.stack");
  // for storing application id reference inside <tell...end tell> statements
  public static final Key<Stack<String>> TOLD_APPLICATION_ID_STACK =
          Key.create("applescript.parsing.current.dictionary.id.stack");

  private static final Key<Boolean> IS_PARSING_POSSESSIVE_FORM =
          Key.create("applescript.parsing.possessive.form");
  private static final Key<Boolean> IS_TREE_PREV_CLASS_NAME =
          Key.create("applescript.tree.prev.class.name");
  private static final Key<Boolean> IS_PARSING_TELL_SIMPLE_STATEMENT =
          Key.create("applescript.parsing.tell.simple.statement");
  private static final Key<Boolean> IS_PARSING_TELL_COMPOUND_STATEMENT =
          Key.create("applescript.parsing.tell.simple.statement");
  private static final Key<Boolean> APPLICATION_NAME_PUSHED =
          Key.create("applescript.parsing.tell.statement.application.name.pushed");

  //Set for storing application names specified in <use> statement for later use in parsing
  private static final Key<Set<String>> USED_APPLICATION_NAMES =
          Key.create("applescript.parsing.use.statement.application.name.set");

  //boolean flag: if this script uses <use> statement. If true: standard definitions dictionary should be explicitly
  // specified
  private static final Key<Boolean> WAS_USE_STATEMENT_USED =
          Key.create("applescript.parsing.is.use.statement.used");

  //for <using terms of ... end using terms of> compound statement and pushing application/std library
  // to dictionary stack
  private static final Key<Boolean> IS_PARSING_USING_TERMS_FROM_STATEMENT =
          Key.create("applescript.parsing.is.use.statement.used");

  public static boolean parseDictionaryCommandNameInner(PsiBuilder b, int l, @NotNull StringHolder parsedName,
                                                        @NotNull String toldApplicationName,
                                                        boolean areThereUseStatements,
                                                        @Nullable Set<String> applicationsToImportFrom) {
    if (!recursion_guard_(b, l, "parseDictionaryCommandNameInner")) return false;
    boolean r;
    parsedName.value = "";
    // TODO: 12/1/2015 could be command with name which does not exist in this target app but in stanradr additions or
    // CocoaStandard dictionary or in use application dictionary. write all code here?? to find the longest
    // dictionary term
    boolean checkStdLib = !areThereUseStatements;
    ParsableScriptSuiteRegistryHelper.ensureKnownApplicationInitialized(toldApplicationName);
    r = parseCommandNameForApplication(b, l + 1, parsedName, toldApplicationName, checkStdLib);
    if (r) return true;
    if (areThereUseStatements) {
      if (applicationsToImportFrom != null && !applicationsToImportFrom.isEmpty()) {
        for (String appName : applicationsToImportFrom) {
          //in case of SCRIPTING_ADDITIONS 'StandardAdditions' app name is added to app names import list
          ParsableScriptSuiteRegistryHelper.ensureKnownApplicationInitialized(appName);
          r = parseCommandNameForApplication(b, l + 1, parsedName, appName, false);
          if (r) return true;
        }
      }
    }
    if (checkStdLib) {
      r = parseStdLibCommandName(b, l + 1, parsedName);
      if (r) return true;
    }
    // Could be command from Cocoa Standard library which was not yet checked, because
    // applicationName == ScriptingAdditions.
    // The could happen when parsing <using terms from scripting additions> stms
    r = parseCommandNameForApplication(b, l + 1, parsedName, ApplicationDictionary.STANDARD_COCOA_LIBRARY, checkStdLib);
    return r;
  }

  /**
   * <<< COMMAND_HANDLER_CALL >>>
   */
  // commandName commandParameters?
  public static boolean parseCommandHandlerCallExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parseCommandHandlerCallExpression")) return false;
    boolean r;
    if (nextTokenIs(b, NLS)) {
      return false;
    }
    StringHolder parsedCommandName = new StringHolder();
    String toldApplicationName = getTargetApplicationName(b);
    boolean areThereUseStatements = b.getUserData(WAS_USE_STATEMENT_USED) == Boolean.TRUE;
    Set<String> applicationsToImport = null;
    if (areThereUseStatements) {
      applicationsToImport = b.getUserData(USED_APPLICATION_NAMES);
    }
    PsiBuilder.Marker m2 = enter_section_(b, l, _COLLAPSE_, "<parse Command Handler Call Expression>");
    r = parseDictionaryCommandNameInner(b, l + 1, parsedCommandName, toldApplicationName, areThereUseStatements,
            applicationsToImport);
    exit_section_(b, l, m2, DICTIONARY_COMMAND_NAME, r, false, null);

    if (!r) return false;
    // TODO: 06/12/15 may be try to avoid creating PSI here!..
    List<AppleScriptCommand> allCommandsWithName = getAllCommandsWithName(b, parsedCommandName.value,
            toldApplicationName, areThereUseStatements, applicationsToImport);

    for (AppleScriptCommand command : allCommandsWithName) {
      r = parseParametersForCommand(b, l + 1, command);
      if (r) {
        break;
      }
    }
    boolean incompleteHandlerCall = !r && allCommandsWithName.size() > 0 && (b.getTokenType() == NLS || b.eof());
    return r || incompleteHandlerCall;
  }

  @NotNull
  private static List<AppleScriptCommand> getAllCommandsWithName(PsiBuilder b, final String parsedCommandName,
                                                                 final String toldApplicationName,
                                                                 boolean areThereUseStatements,
                                                                 Set<String> applicationsToImport) {
    List<AppleScriptCommand> allCommandsWithName = new ArrayList<AppleScriptCommand>();
    allCommandsWithName.addAll(ParsableScriptSuiteRegistryHelper
            .findApplicationCommands(b.getProject(), toldApplicationName, parsedCommandName));
    // StandardAdditions fake application does not contain CocoaStandard terms. Adding them here
    if (ApplicationDictionary.STANDARD_ADDITIONS_LIBRARY.equals(toldApplicationName)) {
      allCommandsWithName.addAll(ParsableScriptSuiteRegistryHelper.findApplicationCommands(b.getProject(),
              ApplicationDictionary.STANDARD_COCOA_LIBRARY, parsedCommandName));
    }
    if (areThereUseStatements) {
      if (applicationsToImport != null) {
        for (String appName : applicationsToImport) {
          allCommandsWithName.addAll(ParsableScriptSuiteRegistryHelper
                  .findApplicationCommands(b.getProject(), appName, parsedCommandName));
        }
      }
    } else {
      allCommandsWithName.addAll(ParsableScriptSuiteRegistryHelper.findStdCommands(b.getProject(), parsedCommandName));
    }
    // well, even application could not contain CocoaStandard terms sometimes (need to implement <include> directive)
    // todo remove this workaround when implement include in dictionaries
    if (allCommandsWithName.isEmpty()) {
      allCommandsWithName.addAll(ParsableScriptSuiteRegistryHelper.findApplicationCommands(b.getProject(),
              ApplicationDictionary.STANDARD_COCOA_LIBRARY, parsedCommandName));
    }
    return allCommandsWithName;
  }

  /**
   * @param b PsiBuilder
   * @return Returns application name inside targeted to application blocks of
   * code: "tell"/"using terms from" statements. <br> If nothing found - returns available to all scripting
   * application CocoaStandard library name
   */
  @NotNull
  public static String getTargetApplicationName(PsiBuilder b) {
    String toldApplicationName = peekTargetApplicationName(b);
    // CocoaStandard library is always available for the scriptable application
    return toldApplicationName != null ? toldApplicationName : ApplicationDictionary.STANDARD_COCOA_LIBRARY;
  }

  @Nullable
  public static String peekTargetApplicationName(PsiBuilder b) {
    Stack<String> applicationNameStack = b.getUserData(TOLD_APPLICATION_NAME_STACK);
    String toldApplicationName = null;
    if (applicationNameStack != null && !applicationNameStack.isEmpty()) {
      toldApplicationName = applicationNameStack.peek();
    }
    return toldApplicationName;
  }

  private static boolean parseCommandNameForApplication(PsiBuilder b, int l, StringHolder parsedName,
                                                        @NotNull String applicationName, boolean checkStdLib) {
    if (!recursion_guard_(b, l, "parseCommandNameForApplication")) return false;
    boolean r = false;
    parsedName.value = "";
    PsiBuilder.Marker m = enter_section_(b);
    parsedName.value = b.getTokenText() == null ? "" : b.getTokenText();

    boolean commandWithPrefixExists = ParsableScriptSuiteRegistryHelper.isCommandWithPrefixExist(applicationName,
            parsedName.value);
    String nextTokenText = parsedName.value;
    while (b.getTokenText() != null && commandWithPrefixExists) {
      b.advanceLexer(); //advance lexer in any case
      nextTokenText += " " + b.getTokenText();
      commandWithPrefixExists = ParsableScriptSuiteRegistryHelper
              .isCommandWithPrefixExist(applicationName, nextTokenText);
      if (commandWithPrefixExists) {
        parsedName.value = nextTokenText;
      } else if (ParsableScriptSuiteRegistryHelper.isApplicationCommand(applicationName, parsedName.value)) {
        //if there is std command with longer prefix exists do not parse it here
        r = !checkStdLib || !ParsableScriptSuiteRegistryHelper.isStdCommandWithPrefixExist(nextTokenText);
        break;
      }
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // of? directParameterValue? commandParameters?
  public static boolean parseParametersForCommand(PsiBuilder b, int l,
                                                  @NotNull final AppleScriptCommand parsedCommandDefinition) {
    if (!recursion_guard_(b, l, "parseParametersForCommand")) return false;
    boolean r = true;
    PsiBuilder.Marker m = enter_section_(b, l, _NONE_, "<parse command handler call parameters>");
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

  public static boolean isHandlerLabeledParametersCallAllowed(PsiBuilder b, int l) {
    return b.getUserData(IS_PARSING_COMMAND_ASSIGNMENT_STATEMENT) != Boolean.TRUE
            && b.getUserData(IS_PARSING_TELL_SIMPLE_STATEMENT) != Boolean.TRUE
            && b.getUserData(IS_PARSING_COMMAND_HANDLER_CALL_PARAMETERS) != Boolean.TRUE;
  }

  public static boolean isTreePrevSimpleReference(PsiBuilder b, int l) {
    return b.getLatestDoneMarker() != null
            && b.getLatestDoneMarker().getTokenType() == REFERENCE_IDENTIFIER;
  }

  public static boolean parseAssignmentStatementInner(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parseAssignmentStatementInner")) return false;
    boolean r;
    b.putUserData(IS_PARSING_COMMAND_ASSIGNMENT_STATEMENT, true);
    r = AppleScriptParser.assignmentStatement(b, l + 1);
    b.putUserData(IS_PARSING_COMMAND_ASSIGNMENT_STATEMENT, false);
    return r;
  }

  public static boolean parseTellSimpleStatementInner(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tellSimpleStatement")) return false;
    if (!nextTokenIs(b, TELL)) return false;
    boolean r;
    boolean pushedBefore = b.getUserData(APPLICATION_NAME_PUSHED) == Boolean.TRUE;
    b.putUserData(APPLICATION_NAME_PUSHED, false);
    b.putUserData(IS_PARSING_TELL_SIMPLE_STATEMENT, true);
    r = AppleScriptParser.tellSimpleStatement(b, l + 1);
    b.putUserData(IS_PARSING_TELL_SIMPLE_STATEMENT, false);
    if (r) {
      popApplicationNameIfNeeded(b);
    }
    b.putUserData(APPLICATION_NAME_PUSHED, pushedBefore);
    return r;
  }

  private static void popApplicationNameIfNeeded(PsiBuilder b) {
    if (b.getUserData(APPLICATION_NAME_PUSHED) == Boolean.TRUE) {
      Stack<String> dictionaryNameStack = b.getUserData(TOLD_APPLICATION_NAME_STACK);
      if (dictionaryNameStack != null && !dictionaryNameStack.isEmpty()) {//should always be true if r==true
        dictionaryNameStack.pop(); //not always need to pop 'cause could be: tell 'front window' ... to...
      }
    }
  }

  public static boolean parseUsedApplicationNameExternal(PsiBuilder b, int l, Parser isImporting) {
    if (!recursion_guard_(b, l, "parseUsedApplicationNameExternal")) return false;
    boolean r;
    if (!nextTokenIs(b, "parseUsedApplicationNameExternal", APPLICATION, APP, SCRIPTING_ADDITIONS)) return false;
    String appName = null;
    r = consumeToken(b, SCRIPTING_ADDITIONS);
    if (r) {
      appName = ApplicationDictionary.STANDARD_ADDITIONS_LIBRARY;
    } else {
      PsiBuilder.Marker mAppRef = enter_section_(b, l, _NONE_, "<application reference>");
      PsiBuilder.Marker mCls = enter_section_(b, l, _NONE_, "<dictionary class name>");
      r = consumeToken(b, APPLICATION);
      if (!r) r = consumeToken(b, APP);
      exit_section_(b, l, mCls, DICTIONARY_CLASS_NAME, r, false, null);
      if (r) {
        String appNameStr = b.getTokenText();
        r = consumeToken(b, STRING_LITERAL);
        if (r && !StringUtil.isEmpty(appNameStr)) {
          appName = appNameStr.replace("\"", "");
        }
      }
      exit_section_(b, l, mAppRef, APPLICATION_REFERENCE, r, false, null);
    }
    boolean doTermsImport = isImporting.parse(b, l + 1);
    if (doTermsImport && !StringUtil.isEmpty(appName)) {
      Set<String> usedAppNames = b.getUserData(USED_APPLICATION_NAMES);
      if (usedAppNames == null) {
        usedAppNames = new HashSet<String>();
        b.putUserData(USED_APPLICATION_NAMES, usedAppNames);
      }
      usedAppNames.add(appName);
    }
    return r;
  }

  public static boolean parseUseStatement(PsiBuilder b, int l, Parser useStatement) {
    if (!recursion_guard_(b, l, "parseUseStatement")) return false;
    boolean r = useStatement.parse(b, l + 1);
    boolean prevPass = b.getUserData(WAS_USE_STATEMENT_USED) == Boolean.TRUE;
    b.putUserData(WAS_USE_STATEMENT_USED, r || prevPass);
    return r;
  }

  public static boolean parseRepeatStatement(PsiBuilder b, int l, Parser repeatStatement) {
    if (!recursion_guard_(b, l, "parseRepeatStatement")) return false;
    boolean r;
    if (!nextTokenIs(b, REPEAT)) return false;
    //if we are in tell statement - check application terms first
    String toldAppName = peekTargetApplicationName(b);
    if (!StringUtil.isEmpty(toldAppName)) {
      StringHolder parsedName = new StringHolder();
      PsiBuilder.Marker mComName = enter_section_(b, l, _AND_, "<parse Repeat Statement>");
      r = parseCommandNameForApplication(b, l + 1, parsedName, toldAppName, true);
      exit_section_(b, l, mComName, null, r, false, null);
      if (r) return false;
    }
    r = repeatStatement.parse(b, l + 1);
    return r;
  }


  public static boolean parseTellCompoundStatementInner(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parseTellCompoundStatementInner")) return false;
    if (!nextTokenIs(b, TELL)) return false;
    boolean r;
    boolean pushedBefore = b.getUserData(APPLICATION_NAME_PUSHED) == Boolean.TRUE;
    b.putUserData(APPLICATION_NAME_PUSHED, false);
    boolean compoundBefore = b.getUserData(IS_PARSING_TELL_COMPOUND_STATEMENT) == Boolean.TRUE;
    b.putUserData(IS_PARSING_TELL_COMPOUND_STATEMENT, true);//not used anywhere actually

    ErrorState state = ErrorState.get(b);

    r = AppleScriptParser.tellCompoundStatement(b, l + 1);
    b.putUserData(IS_PARSING_TELL_COMPOUND_STATEMENT, compoundBefore);
    if (r) {
      popApplicationNameIfNeeded(b);
    }
    b.putUserData(APPLICATION_NAME_PUSHED, pushedBefore);
    return r;
  }

  public static boolean parseUsingTermsFromStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parseUsingTermsFromStatement")) return false;
    boolean r;
    boolean oldParseUsingTermsState = b.getUserData(IS_PARSING_USING_TERMS_FROM_STATEMENT) == Boolean.TRUE;
    boolean oldPushedState = b.getUserData(APPLICATION_NAME_PUSHED) == Boolean.TRUE;
    b.putUserData(IS_PARSING_USING_TERMS_FROM_STATEMENT, true);
    b.putUserData(APPLICATION_NAME_PUSHED, false);

    r = AppleScriptParser.usingTermsFromStatement(b, l + 1);

    if (r) {
      popApplicationNameIfNeeded(b);
    }
    b.putUserData(IS_PARSING_USING_TERMS_FROM_STATEMENT, oldParseUsingTermsState);
    b.putUserData(APPLICATION_NAME_PUSHED, oldPushedState);

    return r;
  }

  public static boolean pushStdLibrary(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pushStdLibrary")) return false;
    boolean r;
    r = consumeToken(b, SCRIPTING_ADDITIONS);
    if (r) {
      pushTargetApplicationName(b, ApplicationDictionary.STANDARD_ADDITIONS_LIBRARY);
    }
    return r;
  }

  public static boolean parseApplicationName(PsiBuilder b, int l, Parser tellStatementStartCondition) {
    if (!recursion_guard_(b, l, "parseApplicationName")) return false;
    boolean r;
    consumeToken(b, THE_KW);
    if (!nextTokenIs(b, "", APPLICATION, APP)) return false;

    PsiBuilder.Marker mCls = enter_section_(b, l, _NONE_, "<dictionary class name>");
    r = consumeToken(b, APPLICATION);
    if (!r) r = consumeToken(b, APP);
    exit_section_(b, l, mCls, DICTIONARY_CLASS_NAME, r, false, null);

    if (!nextTokenIs(b, "parseApplicationName", STRING_LITERAL, ID)) return false;
    boolean idReference = consumeToken(b, ID);

    PsiBuilder.Marker m = enter_section_(b);
    String applicationNameString = b.getTokenText();
    if (applicationNameString != null)
      applicationNameString = applicationNameString.replace("\"", "");
    r = consumeToken(b, STRING_LITERAL);

    // may be do not check it here but move appRef rule to a tell and using terms statement explicitly (like for use)
    //check if this is start of tell compound or tell simple or using terms of statements
    if (r && tellStatementStartCondition.parse(b, l + 1) && !StringUtil.isEmptyOrSpaces(applicationNameString)) {
      pushTargetApplicationName(b, applicationNameString);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  public static boolean isTellStatementStart(PsiBuilder b, int l) {
    if (!isInTellStatement(b, l + 1)) return false;
    int i = -1;
    IElementType prevElem = b.rawLookup(i);
    while (prevElem == com.intellij.psi.TokenType.WHITE_SPACE || prevElem == MY
            || prevElem == APPLICATION || prevElem == STRING_LITERAL || prevElem == null
            || prevElem == ID) {
      prevElem = b.rawLookup(--i);
    }
    return prevElem == TELL
            || (b.getUserData(IS_PARSING_USING_TERMS_FROM_STATEMENT) == Boolean.TRUE)
            && prevElem == FROM;
  }

  public static boolean isInTellStatement(PsiBuilder b, int l) {
    return (b.getUserData(IS_PARSING_TELL_SIMPLE_STATEMENT) == Boolean.TRUE && nextTokenIs(b, TO))
            || (b.getUserData(IS_PARSING_TELL_COMPOUND_STATEMENT) == Boolean.TRUE
            && b.getUserData(IS_PARSING_TELL_SIMPLE_STATEMENT) == Boolean.FALSE)
            || b.getUserData(IS_PARSING_USING_TERMS_FROM_STATEMENT) == Boolean.TRUE;
  }

  public static Stack<String> pushTargetApplicationName(PsiBuilder b, @NotNull String applicationNameString) {
    Stack<String> dictionaryNameStack = b.getUserData(TOLD_APPLICATION_NAME_STACK);
    if (dictionaryNameStack == null) {
      dictionaryNameStack = new Stack<String>();
      b.putUserData(TOLD_APPLICATION_NAME_STACK, dictionaryNameStack);
    }
    dictionaryNameStack.push(applicationNameString);
    b.putUserData(APPLICATION_NAME_PUSHED, true);
    return dictionaryNameStack;
  }

//  public static Stack<String> pushTargetApplicationId(PsiBuilder b, String applicationIdReference) {
//    Stack<String> dictionaryIdStack = b.getUserData(TOLD_APPLICATION_ID_STACK);
//    if (dictionaryIdStack == null) {
//      dictionaryIdStack = new Stack<String>();
//      b.putUserData(TOLD_APPLICATION_ID_STACK, dictionaryIdStack);
//    }
//    dictionaryIdStack.push(applicationIdReference);
//    b.putUserData(APPLICATION_NAME_PUSHED, true);
//    return dictionaryIdStack;
//  }

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
  private static boolean parseGivenParameter(PsiBuilder b, int l, AppleScriptCommand command,
                                             StringHolder parsedParameterSelector) {
    if (!recursion_guard_(b, l, "parseGivenParameter")) return false;
    PsiBuilder.Marker m = enter_section_(b, l, _NONE_, "<parse Given Parameter>");
    consumeToken(b, GIVEN);//optional
    boolean r;
    r = parseCommandParameterSelector(b, l + 1, command, parsedParameterSelector);
    final CommandParameter parameterDefinition = command.getParameterByName(parsedParameterSelector.value);
    //todo: parameter value expression could be incorrectly parsed and needed to be rolled backed (__AND__ modifier?)
    //as in example: mount volume "" in AppleTalk zone ""  (in - parsed as range ref form)
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
      r = typeSpecifier(b, l + 1);
    } else if ("text".equals(parameterTypeSpecifier)) {
      r = AppleScriptParser.stringLiteralExpression(b, l + 1);
    }
    if (!r) r = AppleScriptParser.expression(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  //we need to parse tokens here and get text of the parameter selector and compare with one of possible parameter
  // names
  private static boolean parseCommandParameterSelector(PsiBuilder b, int l, AppleScriptCommand command,
                                                       StringHolder parsedParameterSelector) {
    if (!recursion_guard_(b, l, "parseCommandParameterSelector")) return false;
    boolean r = false;
    PsiBuilder.Marker m = enter_section_(b, l, _NONE_, "<parse Command Parameter Selector>");//todo check this _AND_
    parsedParameterSelector.value = b.getTokenText() == null ? "" : b.getTokenText();
    while (!b.eof() && b.getTokenType() != NLS && b.getTokenType() != COMMENT) {
      b.advanceLexer();
      if (command.getParameterByName(parsedParameterSelector.value) != null) {
        r = true;
        break;
      }
      parsedParameterSelector.value += " " + b.getTokenText();
    }
    exit_section_(b, l, m, COMMAND_PARAMETER_SELECTOR, r, false, null);
    return r;

  }

  private static boolean parseStdLibCommandName(PsiBuilder b, int l, StringHolder parsedName) {
    if (!recursion_guard_(b, l, "parseStdLibCommandName")) return false;
    boolean r = false;
    parsedName.value = "";
    parsedName.value = b.getTokenText() == null ? "" : b.getTokenText();
    PsiBuilder.Marker m = enter_section_(b);
    boolean commandWithPrefixExists = ParsableScriptSuiteRegistryHelper.isStdCommandWithPrefixExist(parsedName.value);
    String nextTokenText = parsedName.value;
    while (b.getTokenText() != null && commandWithPrefixExists) {
      b.advanceLexer(); //advance lexer in any case
      nextTokenText += " " + b.getTokenText();
      commandWithPrefixExists = ParsableScriptSuiteRegistryHelper.isStdCommandWithPrefixExist(nextTokenText);
      if (commandWithPrefixExists) {
        parsedName.value = nextTokenText;
      } else if (ParsableScriptSuiteRegistryHelper.isStdCommand(parsedName.value)) {
        r = true;
        break;
      }
    }
    exit_section_(b, m, null, r);
    return r;

  }

  private static boolean parseCommandDirectParameterValue(PsiBuilder b, int l,
                                                          @NotNull CommandDirectParameter parameter) {
    if (!recursion_guard_(b, l, "parseCommandDirectParameterValue")) return false;
    boolean r = false;
    String parameterTypeSpecifier = parameter.getTypeSpecifier();
    // if we are inside tell compound statement=> direct parameter is optional
    // so it may be wrongly detected instead of parameter selector. So, checking if it is a parameter selector first
    boolean isTellCompound = b.getUserData(IS_PARSING_TELL_COMPOUND_STATEMENT) == Boolean.TRUE;
    if (isTellCompound || parameter.isOptional()) {
      AppleScriptCommand myCmd = parameter.getCommand();
      for (String paramName : myCmd.getParameterNames()) {
        if (nextTokenIs(b, paramName)) return true;
      }
    }
    PsiBuilder.Marker m = enter_section_(b, l, _NONE_, "<parse Command Direct Parameter Value >");
//    if ("type".equals(parameterTypeSpecifier)) {
//      r = typeSpecifier(b, l + 1);
//    }
    if (!r) r = com.idea.plugin.applescript.lang.parcer.AppleScriptParser.expression(b, l + 1);
    exit_section_(b, l, m, DIRECT_PARAMETER_VAL, r, false, null);
    // A tell statement specifies a default target for all commands contained
    // within it, so the direct parameter is optional.
    return r || parameter.isOptional() || isTellCompound;
  }

  /* ********************************************************** */
  // singularClassName|pluralClassName
  static boolean typeSpecifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeSpecifier")) return false;
    boolean r;
    PsiBuilder.Marker m = enter_section_(b);
    r = singularClassName(b, l + 1);
    if (!r) r = AppleScriptParser.builtInClassIdentifierPlural(b, l + 1);
    if (!r) r = AppleScriptParser.dictionaryClassIdentifierPlural(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // dictionaryClassName|builtInClassIdentifier ITEM?
  static boolean singularClassName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "singularClassName")) return false;
    boolean r;
    PsiBuilder.Marker m = enter_section_(b);
    r = AppleScriptParser.dictionaryClassName(b, l + 1);
    if (!r) r = AppleScriptParser.builtInClassIdentifier(b, l + 1);
    consumeToken(b, ITEM);
    exit_section_(b, m, null, r);
    return r;
  }

  public static boolean parseCommandParameterSelector(PsiBuilder b, int l) {
    return false;
//    return parseDeclaredNameInner(b, l, DeclaredType.SDEF_COMMAND_PARAMETER_SELECTOR);
  }

  public static boolean parseDictionaryCommandName(PsiBuilder b, int l) {
    boolean r;
    if (nextTokenIs(b, NLS)) {
      return false;
    }
    StringHolder parsedCommandName = new StringHolder();
    String toldApplicationName = getTargetApplicationName(b);
    boolean areThereUseStatements = b.getUserData(WAS_USE_STATEMENT_USED) == Boolean.TRUE;
    Set<String> applicationsToImport = null;
    if (areThereUseStatements) {
      applicationsToImport = b.getUserData(USED_APPLICATION_NAMES);
    }
    PsiBuilder.Marker m = enter_section_(b, l, _COLLAPSE_, "<parse ApplicationDictionary Command Name>");
    r = parseDictionaryCommandNameInner(b, l + 1, parsedCommandName, toldApplicationName, areThereUseStatements,
            applicationsToImport);
    exit_section_(b, l, m, DICTIONARY_COMMAND_NAME, r, false, null);
    return r;
  }

  public static boolean parseIncompleteCommandCall(PsiBuilder b, int l) {
    return parseDictionaryCommandName(b, l + 1);
  }


  public static boolean parseObjectReferencePointer(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "objectReferencePointer_0_0")) return false;
    boolean r1, r2 = false;
    PsiBuilder.Marker m = enter_section_(b);
    r1 = consumeToken(b, OF);
    if (!r1) r1 = consumeToken(b, IN);
    if (!r1) r2 = consumeToken(b, APS);
    b.putUserData(IS_PARSING_POSSESSIVE_FORM, r2);
    exit_section_(b, m, null, r1 || r2);
    return r1 || r2;
  }

  public static boolean parseObjectReference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parseObjectReference")) return false;
    boolean r = AppleScriptParser.objectReference(b, l + 1);
    b.putUserData(IS_PARSING_POSSESSIVE_FORM, false);
    b.putUserData(IS_TREE_PREV_CLASS_NAME, false);
    return r;
  }

  public static boolean parseDictionaryPropertyName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parseDictionaryPropertyInner")) return false;
    boolean r;
    String toldApplicationName = getTargetApplicationName(b);
    boolean areThereUseStatements = b.getUserData(WAS_USE_STATEMENT_USED) == Boolean.TRUE;
    Set<String> applicationsToImportFrom = null;
    if (areThereUseStatements) {
      applicationsToImportFrom = b.getUserData(USED_APPLICATION_NAMES);
    }
    r = tryToParseApplicationProperty(b, l + 1, toldApplicationName);
    if (r) return true;

    if (areThereUseStatements) {
      if (applicationsToImportFrom != null && !applicationsToImportFrom.isEmpty()) {
        for (String appName : applicationsToImportFrom) {
          r = tryToParseApplicationProperty(b, l + 1, appName);
          if (r) return true;
        }
      }
    } else {
      r = tryToParseStdProperty(b, l + 1);
      if (r) return true;
      // if told app name == standard additions, Cocoa Standard terms were not checked
//      if (ApplicationDictionary.STANDARD_ADDITIONS_LIBRARY.equals(toldApplicationName)) {
      r = tryToParseApplicationProperty(b, l + 1, ApplicationDictionary.STANDARD_COCOA_LIBRARY);
      if (r) return true;
//      }
    }
    return false;
  }

  public static boolean parseDictionaryClassName(PsiBuilder b, int l, final boolean isPluralForm,
                                                 @NotNull Parser checkForUseStatements) {
    if (!recursion_guard_(b, l, "parseDictionaryClassName")) return false;
    boolean r;
    final String s = b.getTokenText();
    if (s == null || s.length() == 0 || !AppleScriptNames.isIdentifierStart(s.charAt(0))) return false;
    final String toldApplicationName = getTargetApplicationName(b);
    final boolean areThereUseStatements = checkForUseStatements.parse(b, l + 1);
    Set<String> applicationsToImportFrom = null;
    if (areThereUseStatements) {
      applicationsToImportFrom = b.getUserData(USED_APPLICATION_NAMES);
    }
    final StringHolder currentTokenText = new StringHolder();
    currentTokenText.value = s;
    r = findClassNameExactMatch(b, l + 1, currentTokenText, isPluralForm, toldApplicationName, areThereUseStatements,
            applicationsToImportFrom);
    return r;
  }

  public static boolean parseCheckForUseStatements(PsiBuilder b, int l) {
    return recursion_guard_(b, l, "parseCheckForUseStatements")
            && b.getUserData(WAS_USE_STATEMENT_USED) == Boolean.TRUE;
  }

  private static boolean tryToParseStdProperty(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryToParseStdProperty")) return false;
    boolean r = false;
    PsiBuilder.Marker m = enter_section_(b);
    StringHolder currentTokenText = new StringHolder();
    currentTokenText.value = b.getTokenText() == null ? "" : b.getTokenText();
    boolean propertyWithPrefixExists = ParsableScriptSuiteRegistryHelper.isStdPropertyWithPrefixExist
            (currentTokenText.value);
    String nextTokenText = currentTokenText.value;
    while (b.getTokenText() != null && propertyWithPrefixExists) {
      b.advanceLexer(); //advance lexer in any case
      nextTokenText += " " + b.getTokenText();
      propertyWithPrefixExists = ParsableScriptSuiteRegistryHelper.isStdPropertyWithPrefixExist(nextTokenText);
      if (propertyWithPrefixExists) {
        currentTokenText.value = nextTokenText;
      } else if (ParsableScriptSuiteRegistryHelper.isStdProperty(currentTokenText.value)) {
        r = true;
        break;
      }
    }
    exit_section_(b, m, null, r);
    return r;
  }

  private static boolean tryToParseApplicationProperty(PsiBuilder b, int l, @NotNull String applicationName) {
    if (!recursion_guard_(b, l, "tryToParseApplicationProperty")) return false;
    boolean r = false;
    PsiBuilder.Marker m = enter_section_(b);
    StringHolder currentTokenText = new StringHolder();
    currentTokenText.value = b.getTokenText() == null ? "" : b.getTokenText();
    boolean propertyWithPrefixExist = ParsableScriptSuiteRegistryHelper.isPropertyWithPrefixExist(applicationName,
            currentTokenText.value);
    //find the longest lexeme
    String nextTokenText = currentTokenText.value;
    while (b.getTokenText() != null && propertyWithPrefixExist) {
      b.advanceLexer(); //advance lexer in any case
      nextTokenText += " " + b.getTokenText();
      propertyWithPrefixExist = ParsableScriptSuiteRegistryHelper.isPropertyWithPrefixExist(applicationName,
              nextTokenText);
      if (propertyWithPrefixExist) {
        currentTokenText.value = nextTokenText;
      } else if (ParsableScriptSuiteRegistryHelper.isApplicationProperty(applicationName, currentTokenText.value)) {
        r = true;
        break;
      }
    }
    exit_section_(b, m, null, r);
    return r;
  }

  private static boolean findClassNameExactMatch(PsiBuilder b, int l, StringHolder currentTokenText,
                                                 final boolean isPluralForm,
                                                 @NotNull String toldApplicationName,
                                                 final boolean areThereUseStatements,
                                                 final @Nullable Set<String> applicationsToImportFrom) {
    boolean r, propertyExists = false;
    PsiBuilder.Marker m = enter_section_(b);
    r = findApplicationClassNameExactMatch(b, l + 1, currentTokenText, isPluralForm, toldApplicationName);
    if (r) {
      currentTokenText.value += " " + b.getTokenText();
      propertyExists = ParsableScriptSuiteRegistryHelper
              .isPropertyWithPrefixExist(toldApplicationName, currentTokenText.value);
    }
    exit_section_(b, m, null, r && !propertyExists);
    if (propertyExists) return false;
    if (r) return true;
    if (areThereUseStatements) {
      if (applicationsToImportFrom != null && !applicationsToImportFrom.isEmpty()) {
        for (String appName : applicationsToImportFrom) {
          m = enter_section_(b);
          r = findApplicationClassNameExactMatch(b, l + 1, currentTokenText, isPluralForm, appName);
          exit_section_(b, m, null, r);
          if (r) return true;
        }
      }
    } else {
      m = enter_section_(b);
      r = findStdClassNameExactMatch(b, l + 1, currentTokenText, isPluralForm);
      exit_section_(b, m, null, r);
      if (r) return true;
    }
    // ...it looks like not all CocoaStandard classes(and other terms) could be presented in applications
    // terminology. So need to check CocoaStandard any way...
    // If told application name == standard additions, terms from Cocoa Standard library were not checked
    // Checking them here
//    if (ApplicationDictionary.STANDARD_ADDITIONS_LIBRARY.equals(toldApplicationName)) {
    m = enter_section_(b);
    r = findApplicationClassNameExactMatch(b, l + 1, currentTokenText, isPluralForm,
            ApplicationDictionary.STANDARD_COCOA_LIBRARY);
    exit_section_(b, m, null, r);
    if (r) return true;
//    }
    return false;
  }

  private static boolean findStdClassNameExactMatch(PsiBuilder b, int l, StringHolder currentTokenText,
                                                    boolean isPluralForm) {
    currentTokenText.value = b.getTokenText() == null ? "" : b.getTokenText();
    if (isPluralForm) {
      boolean classWithPrefixExists = ParsableScriptSuiteRegistryHelper
              .isStdClassPluralWithPrefixExist(currentTokenText.value);
      String nextTokenText = currentTokenText.value;
      while (b.getTokenText() != null && classWithPrefixExists) {
        b.advanceLexer(); //advance lexer in any case
        nextTokenText += " " + b.getTokenText();
        classWithPrefixExists = ParsableScriptSuiteRegistryHelper.isStdClassPluralWithPrefixExist(nextTokenText);
        if (classWithPrefixExists) {
          currentTokenText.value = nextTokenText;
        } else if (ParsableScriptSuiteRegistryHelper.isStdLibClassPluralName(currentTokenText.value)) return true;
      }
      return false;
    } else {
      boolean classWithPrefixExists = ParsableScriptSuiteRegistryHelper
              .isStdClassWithPrefixExist(currentTokenText.value);
      String nextTokenText = currentTokenText.value;
      while (b.getTokenText() != null && classWithPrefixExists) {
        b.advanceLexer(); //advance lexer in any case
        nextTokenText += " " + b.getTokenText();
        classWithPrefixExists = ParsableScriptSuiteRegistryHelper.isStdClassWithPrefixExist(nextTokenText);
        if (classWithPrefixExists) {
          currentTokenText.value = nextTokenText;
        } else if (ParsableScriptSuiteRegistryHelper.isStdLibClass(currentTokenText.value)) return true;
      }
      return false;
    }
  }

  private static boolean findApplicationClassNameExactMatch(PsiBuilder b, int l, StringHolder currentTokenText,
                                                            final boolean isPluralForm,
                                                            @NotNull String applicationName) {
    currentTokenText.value = b.getTokenText() == null ? "" : b.getTokenText();
    if (isPluralForm) {
      boolean classWithPrefixExists = ParsableScriptSuiteRegistryHelper
              .isClassPluralWithPrefixExist(applicationName, currentTokenText.value);
      String nextTokenText = currentTokenText.value;
      while (b.getTokenText() != null && classWithPrefixExists) {
        b.advanceLexer(); //advance lexer in any case
        nextTokenText += " " + b.getTokenText();
        classWithPrefixExists = ParsableScriptSuiteRegistryHelper
                .isClassPluralWithPrefixExist(applicationName, nextTokenText);
        if (classWithPrefixExists) {
          currentTokenText.value = nextTokenText;
        } else if (ParsableScriptSuiteRegistryHelper
                .isApplicationClassPluralName(applicationName, currentTokenText.value)) {
          return true;
        }
      }
      return false;
    } else {
      boolean classWithPrefixExists = ParsableScriptSuiteRegistryHelper
              .isClassWithPrefixExist(applicationName, currentTokenText.value);
      String nextTokenText = currentTokenText.value;
      while (b.getTokenText() != null && classWithPrefixExists) {
        b.advanceLexer(); //advance lexer in any case
        nextTokenText += " " + b.getTokenText();
        classWithPrefixExists = ParsableScriptSuiteRegistryHelper
                .isClassWithPrefixExist(applicationName, nextTokenText);
        if (classWithPrefixExists) {
          currentTokenText.value = nextTokenText;
        } else if (ParsableScriptSuiteRegistryHelper
                .isApplicationClass(applicationName, currentTokenText.value)) return true;
      }
      return false;
    }
  }

  public static boolean parseDictionaryConstant(PsiBuilder b, int l) {
    return parseDictionaryConstantInner(b, l);
  }

  private static boolean parseDictionaryConstantInner(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parseDeclaredNameInner")) return false;
    boolean r;
    String toldApplicationName = getTargetApplicationName(b);
    //TODO: to think how to better handle such situations?
    // (if there are too many constants defined -> lead to many incorrect parsing errors like
    // 'end' tell/repeat etc is not detected
    // dictionary constant could appear only if we are inside dictionary command call
    if (!ApplicationDictionary.STANDARD_COCOA_LIBRARY.equals(toldApplicationName)
            && b.getUserData(IS_PARSING_COMMAND_HANDLER_CALL_PARAMETERS) != Boolean.TRUE)
      return false;

    boolean areThereUseStatements = b.getUserData(WAS_USE_STATEMENT_USED) == Boolean.TRUE;
    Set<String> applicationsToImportFrom = null;
    if (areThereUseStatements) {
      applicationsToImportFrom = b.getUserData(USED_APPLICATION_NAMES);
    }
    r = tryToParseApplicationConstant(b, l + 1, toldApplicationName);
    if (r) return true;
    if (areThereUseStatements) {
      if (applicationsToImportFrom != null && !applicationsToImportFrom.isEmpty()) {
        for (String appName : applicationsToImportFrom) {
          r = tryToParseApplicationConstant(b, l + 1, appName);
          if (r) return true;
        }
      }
    } else {
      r = tryToParseStdConstant(b, l + 1);
      if (r) return true;
      if (ApplicationDictionary.STANDARD_ADDITIONS_LIBRARY.equals(toldApplicationName)) {
        r = tryToParseApplicationConstant(b, l + 1, ApplicationDictionary.STANDARD_COCOA_LIBRARY);
        if (r) return true;
      }
    }
    return false;
  }

  private static boolean tryToParseStdConstant(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryToParseStdConstant")) return false;
    StringHolder currentTokenText = new StringHolder();
    currentTokenText.value = b.getTokenText() == null ? "" : b.getTokenText();
    boolean r = false, constantWithPrefixExists = ParsableScriptSuiteRegistryHelper
            .isStdConstantWithPrefixExist(currentTokenText.value);
    String nextTokenText = currentTokenText.value;
    PsiBuilder.Marker m = enter_section_(b);
    while (b.getTokenText() != null && constantWithPrefixExists) {
      b.advanceLexer();
      nextTokenText += " " + b.getTokenText();
      constantWithPrefixExists = ParsableScriptSuiteRegistryHelper.isStdConstantWithPrefixExist(nextTokenText);
      if (constantWithPrefixExists) {
        currentTokenText.value = nextTokenText;
      } else if (ParsableScriptSuiteRegistryHelper.isStdConstant(currentTokenText.value)) {
        r = true;
        break;
      }
    }
    exit_section_(b, m, null, r);
    return r;
  }

  private static boolean tryToParseApplicationConstant(PsiBuilder b, int l, @NotNull String applicationName) {
    if (!recursion_guard_(b, l, "tryToParseApplicationConstant")) return false;
    StringHolder currentTokenText = new StringHolder();
    currentTokenText.value = b.getTokenText() == null ? "" : b.getTokenText();
    boolean r = false, constantWithPrefixExists = ParsableScriptSuiteRegistryHelper
            .isConstantWithPrefixExist(applicationName, currentTokenText.value);
    String nextTokenText = currentTokenText.value;
    PsiBuilder.Marker m = enter_section_(b);
    while (b.getTokenText() != null && constantWithPrefixExists) {
      b.advanceLexer();
      nextTokenText += " " + b.getTokenText();
      constantWithPrefixExists = ParsableScriptSuiteRegistryHelper
              .isConstantWithPrefixExist(applicationName, nextTokenText);
      if (constantWithPrefixExists) {
        currentTokenText.value = nextTokenText;
      } else if (ParsableScriptSuiteRegistryHelper.isApplicationConstant(applicationName, currentTokenText.value)) {
        r = true;
        break;
      }
    }
    exit_section_(b, m, null, r);
    return r;
  }

}
