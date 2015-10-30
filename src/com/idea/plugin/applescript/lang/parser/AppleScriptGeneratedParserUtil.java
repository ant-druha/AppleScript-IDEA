package com.idea.plugin.applescript.lang.parser;

import com.idea.plugin.applescript.lang.parcer.AppleScriptParser;
import com.idea.plugin.applescript.lang.sdef.*;
import com.intellij.lang.LighterASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.parser.GeneratedParserUtilBase;
import com.intellij.openapi.util.Key;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
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

  // CocoaStandard library is by default supported in all scripting applications
  private static Stack<String> defaultToldApplicationNameStack = new Stack<String>();

  static {
    defaultToldApplicationNameStack.push(ApplicationDictionary.STANDARD_COCOA_LIBRARY);
  }

  enum DeclaredType {
    SDEF_COMMAND_NAME,
    PROPERTY_LABEL_NAME,
    SDEF_COMMAND_PARAMETER_SELECTOR,
    SDEF_CLASS_NAME,
    SDEF_CONSTANT

  }

  public static boolean parseDictionaryCommandNameInner(PsiBuilder b, int l, @NotNull StringHolder parsedName,
                                                        @NotNull String toldApplicationName,
                                                        boolean areThereUseStatements,
                                                        @Nullable Set<String> applicationsToImportFrom) {
    if (!recursion_guard_(b, l, "parseDictionaryCommandNameInner")) return false;
    boolean r;
    parsedName.value = "";
//    if (!StringUtil.isEmpty(toldApplicationName)) {
    PsiBuilder.Marker mComName = enter_section_(b, l, _AND_, "<parse Dictionary Command Name Inner>");
    r = parseCommandNameForApplication(b, l + 1, parsedName, toldApplicationName);
    exit_section_(b, l, mComName, null, r, false, null);
    if (r) return parseCommandNameForApplication(b, l + 1, parsedName, toldApplicationName);
//    }
      if (areThereUseStatements) {
        if (applicationsToImportFrom != null && !applicationsToImportFrom.isEmpty()) {
          for (String appName : applicationsToImportFrom) {
//            if (ApplicationDictionary.STD_LIBRARY_NAMES.contains(appName))
//              r = parseStdLibCommandName(b, l + 1, parsedName);
//            else
            //in case of SCRIPTING_ADDITIONS 'StandardAdditions' app name is added to app names import list
            mComName = enter_section_(b, l, _AND_, "<parse Dictionary Command Name Inner>");
            r = parseCommandNameForApplication(b, l + 1, parsedName, appName);
            exit_section_(b, l, mComName, null, r, false, null);
            if (r) return parseCommandNameForApplication(b, l + 1, parsedName, appName);
          }
        }
      }
    if (!areThereUseStatements) {
      mComName = enter_section_(b, l, _AND_, "<parse Dictionary Command Name Inner>");
      r = parseStdLibCommandName(b, l + 1, parsedName);
      exit_section_(b, l, mComName, null, r, false, null);
      if (r) return parseStdLibCommandName(b, l + 1, parsedName);
    }
    // Could be command from Cocoa Standard library which was not yet checked, because
    // applicationName == ScriptingAdditions.
    // The could happen when parsing <using terms from scripting additions> stms
//    if (ApplicationDictionary.STANDARD_ADDITIONS_LIBRARY.equals(toldApplicationName)) {
    mComName = enter_section_(b, l, _AND_, "<parse Dictionary Command Name Inner>");
    r = parseCommandNameForApplication(b, l + 1, parsedName, ApplicationDictionary.STANDARD_COCOA_LIBRARY);
    exit_section_(b, l, mComName, null, r, false, null);
    if (r) return parseCommandNameForApplication(b, l + 1, parsedName, ApplicationDictionary.STANDARD_COCOA_LIBRARY);
//    }
    return false;
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
//    PsiBuilder.Marker mComName = enter_section_(b, l, _AND_, "<parse Command Handler Call Expression>");
//    r = parseDictionaryCommandNameInner(b, l + 1, parsedCommandName, toldApplicationName, areThereUseStatements,
//            applicationsToImport);
//    exit_section_(b, l, mComName, null, r, false, null);
//    if (r) {
      PsiBuilder.Marker m2 = enter_section_(b, l, _COLLAPSE_, "<parse Command Handler Call Expression>");
      r = parseDictionaryCommandNameInner(b, l + 1, parsedCommandName, toldApplicationName, areThereUseStatements,
              applicationsToImport);
      exit_section_(b, l, m2, DICTIONARY_COMMAND_NAME, r, false, null);
//    }

    if (!r) return false;
    List<AppleScriptCommand> allCommandsWithName = new ArrayList<AppleScriptCommand>();
    allCommandsWithName.addAll(ParsableScriptSuiteRegistryHelper
            .findApplicationCommands(b.getProject(), toldApplicationName, parsedCommandName.value));
    // StandardAdditions fake application does not contain CocoaStandard terms. Adding them here
    if (ApplicationDictionary.STANDARD_ADDITIONS_LIBRARY.equals(toldApplicationName)) {
      allCommandsWithName.addAll(ParsableScriptSuiteRegistryHelper
              .findApplicationCommands(b.getProject(), ApplicationDictionary.STANDARD_COCOA_LIBRARY,
                      parsedCommandName.value));
    }
    if (areThereUseStatements) {
      if (applicationsToImport != null) {
        for (String appName : applicationsToImport) {
//          if (ApplicationDictionary.STD_LIBRARY_NAMES.contains(appName)) {
//            allCommandsWithName.addAll(ParsableScriptSuiteRegistryHelper
//                    .findStdCommands(b.getProject(), parsedCommandName.value));
//          } else {
          allCommandsWithName.addAll(ParsableScriptSuiteRegistryHelper
                  .findApplicationCommands(b.getProject(), appName, parsedCommandName.value));
//          }
        }
      }
    } else {
      allCommandsWithName.addAll(ParsableScriptSuiteRegistryHelper
              .findStdCommands(b.getProject(), parsedCommandName.value));
    }

    for (AppleScriptCommand command : allCommandsWithName) {
      PsiBuilder.Marker m = enter_section_(b, l, _AND_, "<parse command handler call Expression>");
      r = parseParametersForCommand(b, l + 1, command);
      //todo NLS does not work in the cases when command is written in parenthesis
      r = r && (b.getTokenType() == NLS || b.getTokenType() == COMMENT || b.eof() //todo could not be correct
              // condition in some cases???
              || b.getTokenType() == RPAREN || b.getTokenType() == THEN);// THEN - inside IF statements
      exit_section_(b, l, m, null, r, false, null);
      if (r) {
        r = parseParametersForCommand(b, l + 1, command);
        break;
      }
    }
    boolean incompleteHandlerCall = !r && allCommandsWithName.size() > 0 && (b.getTokenType() == NLS || b.eof());
    return r || incompleteHandlerCall;
  }

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
                                                        @NotNull String applicationName) {
    if (!recursion_guard_(b, l, "parseCommandNameForApplication")) return false;
    boolean r = false;
    PsiBuilder.Marker m = enter_section_(b, l, _NONE_, "<parse Command Name>");
    parsedName.value = "";
    while (consumeTokenForCommandNameAndAppendNameText(b, l + 1, parsedName)) {
      boolean validId = parsedName.value.length() > 0 && StringUtil.isJavaIdentifierStart(parsedName.value.charAt(0));
      boolean foundMatch = validId && ParsableScriptSuiteRegistryHelper
              .isApplicationCommand(applicationName, parsedName.value);
      String tryLookAheadName = "";
      if (foundMatch) {
        r = true;
        tryLookAheadName = parsedName.value + " " + b.getTokenText();
        if (tryLookAheadName.length() > 0 && StringUtil.isJavaIdentifierStart(tryLookAheadName.charAt(0))
                && ParsableScriptSuiteRegistryHelper
                .countApplicationCommandsStartingWithName(applicationName, tryLookAheadName) > 0) {
          continue;
        }
        break;
      }
    }
    exit_section_(b, l, m, null, r, false, null);
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
    if (!recursion_guard_(b, l, "assignmentStatement")) return false;
    boolean r = false;
    b.putUserData(IS_PARSING_COMMAND_ASSIGNMENT_STATEMENT, true);
    boolean isApplicationCommand;
    StringHolder parsedCommandName = new StringHolder();
    String toldApplicationName = getTargetApplicationName(b);
    boolean areThereUseStatements = b.getUserData(WAS_USE_STATEMENT_USED) == Boolean.TRUE;
    Set<String> applicationsToImport = null;
    if (areThereUseStatements) {
      applicationsToImport = b.getUserData(USED_APPLICATION_NAMES);
    }
    PsiBuilder.Marker mComName = enter_section_(b, l, _AND_, "<parse Command Handler Call Expression>");
    isApplicationCommand = parseDictionaryCommandNameInner(b, l + 1, parsedCommandName, toldApplicationName, areThereUseStatements,
            applicationsToImport);
    exit_section_(b, l, mComName, null, isApplicationCommand, false, null);
    if (!isApplicationCommand)
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

  public static boolean parseUsedApplicationNameExternal(PsiBuilder b, int l, Parser isWithDictionaryImport) {
    if (!recursion_guard_(b, l, "parseUsedApplicationNameExternal")) return false;
    boolean r;
    if (!nextTokenIs(b, "parseUsedApplicationNameExternal", APPLICATION, APP, SCRIPTING_ADDITIONS)) return false;
//    if (!nextTokenIs(b, STRING_LITERAL) && !nextTokenIs(b, SCRIPTING_ADDITIONS)) {
//      return false;
//    }
    List<String> appNames = new ArrayList<String>();
    r = consumeToken(b, SCRIPTING_ADDITIONS);
    if (r) {
      appNames.add(ApplicationDictionary.STANDARD_ADDITIONS_LIBRARY);
//      for (String stdLibName : ApplicationDictionary.STD_LIBRARY_NAMES) {
//        appNames.add(stdLibName);
//      }
    } else {
      r = consumeToken(b, APPLICATION);
      if (!r) r = consumeToken(b, APP);

      if (r) {
        String appName = b.getTokenText();
        if (!StringUtil.isEmpty(appName)) {
          appNames.add(appName.replace("\"", ""));
        }
        r = consumeToken(b, STRING_LITERAL);
      }
    }

    boolean isImportTerms = isWithDictionaryImport.parse(b, l + 1);
    if (isImportTerms) {
      Set<String> usedAppNames = b.getUserData(USED_APPLICATION_NAMES);
      if (usedAppNames == null) {
        usedAppNames = new HashSet<String>();
        b.putUserData(USED_APPLICATION_NAMES, usedAppNames);
      }
      if (r) {
        usedAppNames.addAll(appNames);
      }
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


  public static boolean parseTellCompoundStatementInner(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parseTellCompoundStatementInner")) return false;
    if (!nextTokenIs(b, TELL)) return false;
    boolean r;
    boolean pushedBefore = b.getUserData(APPLICATION_NAME_PUSHED) == Boolean.TRUE;
    b.putUserData(APPLICATION_NAME_PUSHED, false);
    boolean compoundBefore = b.getUserData(IS_PARSING_TELL_COMPOUND_STATEMENT) == Boolean.TRUE;
    b.putUserData(IS_PARSING_TELL_COMPOUND_STATEMENT, true);//not used anywhere actually
    r = AppleScriptParser.tellCompoundStatement(b, l + 1);
    b.putUserData(IS_PARSING_TELL_COMPOUND_STATEMENT, compoundBefore);
    if (r) {
      popApplicationNameIfNeeded(b);
    }
    b.putUserData(APPLICATION_NAME_PUSHED, pushedBefore);
    return r;
  }

  public static boolean parseApplicationReference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parseApplicationReference")) return false;
    boolean r;

    r = AppleScriptParser.applicationReference(b, l + 1);

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

  public static boolean putStdLibrary(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pushApplicationNameString")) return false;
    boolean r;
    r = consumeToken(b, SCRIPTING_ADDITIONS);
    if (r) {
//      Stack<String> currentTargetAppNameStack = b.getUserData(TOLD_APPLICATION_NAME_STACK);
      pushTargetApplicationName(b, ApplicationDictionary.STANDARD_ADDITIONS_LIBRARY);
//      if (importingApps == null) {
//        importingApps = new HashSet<String>();
//        b.putUserData(USED_APPLICATION_NAMES, importingApps);
//      }
//      importingApps.add(ApplicationDictionary.STANDARD_ADDITIONS_LIBRARY);
//      for (String stdLib : ApplicationDictionary.STD_LIBRARY_NAMES) {
//        importingApps.add(stdLib);
//      }
    }
    return r;
  }

  public static boolean pushApplicationNameString(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pushApplicationNameString")) return false;
//    boolean r;
    if (!nextTokenIs(b, STRING_LITERAL)) return false;
    boolean r;
    PsiBuilder.Marker m = enter_section_(b);
    String applicationNameString = b.getTokenText();
    if (applicationNameString != null)
      applicationNameString = applicationNameString.replace("\"", "");//todo need make sure only needed quotes are
    // trimmed
    r = consumeToken(b, STRING_LITERAL);

    LighterASTNode lastNode = b.getLatestDoneMarker();
    IElementType prevElemType = b.rawLookup(-1);

    //check if this is tell compound or tell simple statements or using terms of
//    boolean appNamePushed = false;
    if (r && ((b.getUserData(IS_PARSING_TELL_SIMPLE_STATEMENT) == Boolean.TRUE && nextTokenIs(b, TO))
            || (b.getUserData(IS_PARSING_TELL_COMPOUND_STATEMENT) == Boolean.TRUE
            && b.getUserData(IS_PARSING_TELL_SIMPLE_STATEMENT) == Boolean.FALSE)
            || b.getUserData(IS_PARSING_USING_TERMS_FROM_STATEMENT) == Boolean.TRUE)
            ) {
      int i = -1;
      IElementType prevElem = b.rawLookup(i);
      while (prevElem == com.intellij.psi.TokenType.WHITE_SPACE
              || prevElem == APPLICATION || prevElem == STRING_LITERAL || prevElem == null) {
        prevElem = b.rawLookup(--i);
      }
      if (prevElem == TELL
              || (b.getUserData(IS_PARSING_USING_TERMS_FROM_STATEMENT) == Boolean.TRUE)
              && prevElem == FROM) {
        pushTargetApplicationName(b, applicationNameString);
//        appNamePushed = true;
      }
    }
//    b.putUserData(APPLICATION_NAME_PUSHED, appNamePushed);
    exit_section_(b, m, null, r);
    return r;
  }

  public static Stack<String> pushTargetApplicationName(PsiBuilder b, String applicationNameString) {
    Stack<String> dictionaryNameStack = b.getUserData(TOLD_APPLICATION_NAME_STACK);
    if (dictionaryNameStack == null) {
      dictionaryNameStack = new Stack<String>();
      b.putUserData(TOLD_APPLICATION_NAME_STACK, dictionaryNameStack);
    }
    dictionaryNameStack.push(applicationNameString);
    b.putUserData(APPLICATION_NAME_PUSHED, true);
    return dictionaryNameStack;
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

  private static boolean parseStdLibCommandName(PsiBuilder b, int l, StringHolder parsedName) {
    if (!recursion_guard_(b, l, "parseCommandNameForApplication")) return false;
    boolean r = false;
    PsiBuilder.Marker m = enter_section_(b, l, _NONE_, "<parse Command Name>");
    parsedName.value = "";
    while (consumeTokenForCommandNameAndAppendNameText(b, l + 1, parsedName)) {
      boolean foundMatch = parsedName.value.length() > 0 && StringUtil.isJavaIdentifierStart(parsedName.value.charAt(0))
              && ParsableScriptSuiteRegistryHelper.isStdCommand(parsedName.value);
//      boolean foundMatch = ServiceManager.getService(b.getProject(), ParsableScriptSuiteRegistryHelper.class)
//              .findCommandWithName(parsedName.value) != null;
      String tryLookAheadName = "";
      if (foundMatch) {
        //todo check if the text of next tokens matches other dictionary command which starts with parsed name
        r = true;
        tryLookAheadName = parsedName.value + " " + b.getTokenText();
        if (tryLookAheadName.length() > 0 && StringUtil.isJavaIdentifierStart(tryLookAheadName.charAt(0))
                && ParsableScriptSuiteRegistryHelper.countStdCommandsStartingWithName(tryLookAheadName) > 0) {
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
//    if (!r) r = pluralClassName(b, l + 1);
    exit_section_(b, m, null, r);
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
    StringHolder parsedCommandName = new StringHolder();
    boolean r;
    PsiBuilder.Marker m = enter_section_(b, l, _COLLAPSE_, "<parse ApplicationDictionary Command Name>");
    r = parseDictionaryCommandNameInner(b, l + 1, parsedCommandName, null, false, null);
    exit_section_(b, l, m, DICTIONARY_COMMAND_NAME, r, false, null);
    return r;
  }

  public static boolean parseIncompleteCommandCall(PsiBuilder b, int l) {
    return parseDictionaryCommandNameInner(b, l + 1);
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

//  private static boolean parseDeclaredNameInner(PsiBuilder b, int l, DeclaredType declaredNameType) {
//    if (!recursion_guard_(b, l, "parseDeclaredNameInner")) return false;
//    boolean r;
//    //todo how not to make it check twice?
//    PsiBuilder.Marker m = enter_section_(b, l, _AND_, "<parse Declared Name Inner>");
//    r = tryToParseDeclaredName(b, l + 1, declaredNameType);
//    exit_section_(b, l, m, null, r, false, null);
//    if (r) {
//      r = tryToParseDeclaredName(b, l + 1, declaredNameType);
//      return r;
//    }
//    return false;
//  }

  public static boolean parseDictionaryPropertyName(PsiBuilder b, int l) {
//    return parseDeclaredNameInner(b, l, DeclaredType.PROPERTY_LABEL_NAME);
    return parseDictionaryPropertyInner(b, l);
  }

  private static boolean parseDictionaryPropertyInner(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parseDictionaryPropertyInner")) return false;
    boolean r;
    //todo how not to make it check twice?
//    PsiBuilder.Marker m = enter_section_(b, l, _AND_, "<parse Dictionary Property Inner>");
    String toldApplicationName = getTargetApplicationName(b);
    boolean areThereUseStatements = b.getUserData(WAS_USE_STATEMENT_USED) == Boolean.TRUE;
    Set<String> applicationsToImportFrom = null;
    if (areThereUseStatements) {
      applicationsToImportFrom = b.getUserData(USED_APPLICATION_NAMES);
    }
//    if (toldApplicationName != null) {
    PsiBuilder.Marker m = enter_section_(b, l, _AND_, "<parse Dictionary Property Inner>");
    r = tryToParseApplicationProperty(b, l + 1, toldApplicationName);
    exit_section_(b, l, m, null, r, false, null);
    if (r) {
      return tryToParseApplicationProperty(b, l + 1, toldApplicationName);
    }
//    }
    if (areThereUseStatements) {
      if (applicationsToImportFrom != null && !applicationsToImportFrom.isEmpty()) {
        for (String appName : applicationsToImportFrom) {
//          if (ApplicationDictionary.STD_LIBRARY_NAMES.contains(appName)) {
//            m = enter_section_(b, l, _AND_, "<parse Dictionary Property Inner>");
//            r = tryToParseStdProperty(b, l + 1);
//            exit_section_(b, l, m, null, r, false, null);
//            if (r) {
//              r = tryToParseStdProperty(b, l + 1);
//              return r;
//            }
//          } else {
          m = enter_section_(b, l, _AND_, "<parse Dictionary Property Inner>");
          r = tryToParseApplicationProperty(b, l + 1, appName);
          exit_section_(b, l, m, null, r, false, null);
          if (r) {
            return tryToParseApplicationProperty(b, l + 1, appName);
          }
//          }
        }
      }
    } else {
      m = enter_section_(b, l, _AND_, "<parse Dictionary Property Inner>");
      r = tryToParseStdProperty(b, l + 1);
      exit_section_(b, l, m, null, r, false, null);
      if (r) {
        return tryToParseStdProperty(b, l + 1);
      }
      // if told app name == standard additions, Cocoa Standard terms were not checked
//      if (ApplicationDictionary.STANDARD_ADDITIONS_LIBRARY.equals(toldApplicationName)) {
        m = enter_section_(b, l, _AND_, "<parse Dictionary Property Inner>");
        r = tryToParseApplicationProperty(b, l + 1, ApplicationDictionary.STANDARD_COCOA_LIBRARY);
        exit_section_(b, l, m, null, r, false, null);
        if (r) {
          return tryToParseApplicationProperty(b, l + 1, ApplicationDictionary.STANDARD_COCOA_LIBRARY);
        }
//      }
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
    return parseDictionaryClassNameInner(b, l, false);
  }

//  public static boolean parseClassNamePrimaryExpression(PsiBuilder b, int l) {
//    boolean r = AppleScriptParser.classNamePrimaryExpression(b, l + 1);
//    b.putUserData(IS_TREE_PREV_CLASS_NAME, r);
//    return r;
//  }


  public static boolean isTreePrevClassName(PsiBuilder b, int l) {
    IElementType prevElemType;

    int i = -1;
    prevElemType = b.rawLookup(i--);
    while (prevElemType == com.intellij.psi.TokenType.WHITE_SPACE) {
      prevElemType = b.rawLookup(i--);
    }
// BUILT_IN_CLASS_IDENTIFIER
    boolean result = prevElemType == DICTIONARY_CLASS_NAME
            || prevElemType == BUILT_IN_CLASS_IDENTIFIER
            || prevElemType == BUILT_IN_TYPE_S
            || prevElemType == SCRIPTS
            || prevElemType == DICTIONARY_CLASS_IDENTIFIER_PLURAL;
//            || prevElemType == VAR_IDENTIFIER;
    if (!result) {
      prevElemType = b.getLatestDoneMarker() != null ?
              b.getLatestDoneMarker().getTokenType() : null;
      result = prevElemType == DICTIONARY_CLASS_NAME
              || prevElemType == BUILT_IN_CLASS_IDENTIFIER
              || prevElemType == BUILT_IN_TYPE_S
              || prevElemType == SCRIPTS
              || prevElemType == DICTIONARY_CLASS_IDENTIFIER_PLURAL;
    }
    return result;
  }


  private static boolean parseDictionaryClassNameInner(PsiBuilder b, int l, final boolean isPluralForm) {
    if (!recursion_guard_(b, l, "parseDeclaredNameInner")) return false;
    boolean r;
    String toldApplicationName = getTargetApplicationName(b);
    boolean areThereUseStatements = b.getUserData(WAS_USE_STATEMENT_USED) == Boolean.TRUE;
    Set<String> applicationsToImportFrom = null;
    if (areThereUseStatements) {
      applicationsToImportFrom = b.getUserData(USED_APPLICATION_NAMES);
    }
    //todo how not to make it check twice?
//    PsiBuilder.Marker m = enter_section_(b, l, _AND_, "<parse Declared Name Inner>");
    r = tryToParseDictionaryClass(b, l + 1, isPluralForm, toldApplicationName, areThereUseStatements,
            applicationsToImportFrom);
//    exit_section_(b, l, m, null, r, false, null);
//    if (r) {
//      r = tryToParseDictionaryClass(b, l + 1, isPluralForm, toldApplicationName, areThereUseStatements,
//              applicationsToImportFrom);
      return r;
//    }

//    return false;
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

  private static boolean tryToParseDictionaryClass(PsiBuilder b, int l, final boolean isPluralForm,
                                                   @NotNull String toldApplicationName,
                                                   boolean areThereUseStatements,
                                                   @Nullable Set<String> applicationsToImportFrom) {
    if (!recursion_guard_(b, l, "tryToParseDictionaryClass")) return false;
    StringHolder currentTokenText = new StringHolder();
    currentTokenText.value = b.getTokenText() == null ? "" : b.getTokenText();
    return currentTokenText.value.length() > 0 && StringUtil.isJavaIdentifierStart(currentTokenText.value.charAt(0))
            && findClassNameExactMatch(b, l + 1, currentTokenText, isPluralForm, toldApplicationName,
            areThereUseStatements, applicationsToImportFrom);
  }

  private static boolean tryToParseStdProperty(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryToParseStdProperty")) return false;
    boolean r;

    StringHolder currentTokenText = new StringHolder();
    currentTokenText.value = b.getTokenText() == null ? "" : b.getTokenText();
    int candidatesCount = ParsableScriptSuiteRegistryHelper.countStdPropertiesStartingWithName(currentTokenText.value);
    //find the longest lexeme
    while (b.getTokenText() != null && candidatesCount > 0) {
      if (candidatesCount == 1) {
        if (ParsableScriptSuiteRegistryHelper.isStdProperty(currentTokenText.value)) {
          r = identifier(b, l + 1);
          if (!r) r = builtInClassIdentifier(b, l + 1);
          if (!r) b.advanceLexer(); //advance lexer in any case

          return true;
        }
        r = identifier(b, l + 1);
        if (!r) r = builtInClassIdentifier(b, l + 1);
        if (!r) b.advanceLexer(); //advance lexer in any case

        currentTokenText.value = currentTokenText.value + " " + b.getTokenText();
        candidatesCount = ParsableScriptSuiteRegistryHelper.countStdPropertiesStartingWithName(currentTokenText.value);

      } else {
        boolean foundExactMatch = ParsableScriptSuiteRegistryHelper.isStdProperty(currentTokenText.value);
        r = identifier(b, l + 1);
        if (!r) r = builtInClassIdentifier(b, l + 1);
        if (!r) b.advanceLexer(); //advance lexer in any case

        currentTokenText.value = currentTokenText.value + " " + b.getTokenText();
        candidatesCount = ParsableScriptSuiteRegistryHelper.countStdPropertiesStartingWithName(currentTokenText.value);
        if (candidatesCount == 0) {
          return foundExactMatch;
        }
      }
    }
    return false;
  }

  private static boolean tryToParseApplicationProperty(PsiBuilder b, int l, @NotNull String applicationName) {
    if (!recursion_guard_(b, l, "tryToParseApplicationProperty")) return false;
    boolean r;
    StringHolder currentTokenText = new StringHolder();
    currentTokenText.value = b.getTokenText() == null ? "" : b.getTokenText();
    int candidatesCount = ParsableScriptSuiteRegistryHelper
            .countApplicationPropertiesStartingWithName(applicationName, currentTokenText.value);
//            .findPropertiesStartingWithName(applicationName, currentTokenText.value).size();
//    if (candidatesCount > 0) {
    //find the longest lexeme
    while (b.getTokenText() != null && candidatesCount > 0) {
      r = identifier(b, l + 1);
      if (!r) r = builtInClassIdentifier(b, l + 1);
      if (!r) b.advanceLexer(); //advance lexer in any case
      if (candidatesCount == 1) {
        if (ParsableScriptSuiteRegistryHelper.isApplicationProperty(applicationName, currentTokenText.value)) {
          return true;
        }
        currentTokenText.value = currentTokenText.value + " " + b.getTokenText();
        candidatesCount = ParsableScriptSuiteRegistryHelper
                .countApplicationPropertiesStartingWithName(applicationName, currentTokenText.value);
//                .findPropertiesStartingWithName(applicationName, currentTokenText.value).size();

      } else {
        boolean foundExactMatch = ParsableScriptSuiteRegistryHelper
                .isApplicationProperty(applicationName, currentTokenText.value);
//                .getPropertyWithName(applicationName, currentTokenText.value) != null;
        currentTokenText.value = currentTokenText.value + " " + b.getTokenText();
        candidatesCount = ParsableScriptSuiteRegistryHelper
                .countApplicationPropertiesStartingWithName(applicationName, currentTokenText.value);
//                .findPropertiesStartingWithName(applicationName, currentTokenText.value).size();
        if (candidatesCount == 0) {
          return foundExactMatch;
        }
      }
    }
//    }
//  else {//searching in standard additions
    candidatesCount = ParsableScriptSuiteRegistryHelper.countStdPropertiesStartingWithName(currentTokenText.value);
    while (b.getTokenText() != null && candidatesCount > 0) {
      r = identifier(b, l + 1);
      if (!r) r = builtInClassIdentifier(b, l + 1);
      if (!r) b.advanceLexer(); //advance lexer in any case
      if (candidatesCount == 1) {
        if (ParsableScriptSuiteRegistryHelper.isStdProperty(currentTokenText.value)) {
          return true;
        }
        currentTokenText.value = currentTokenText.value + " " + b.getTokenText();
        candidatesCount = ParsableScriptSuiteRegistryHelper
                .countStdPropertiesStartingWithName(currentTokenText.value);
//                .findPropertiesStartingWithName(currentTokenText.value).size();

      } else {
        boolean foundExactMatch = ParsableScriptSuiteRegistryHelper.isStdProperty(currentTokenText.value);

        currentTokenText.value = currentTokenText.value + " " + b.getTokenText();
        candidatesCount = ParsableScriptSuiteRegistryHelper.countStdPropertiesStartingWithName(currentTokenText.value);
        if (candidatesCount == 0) {
          return foundExactMatch;
        }
      }
    }
//    }
    return false;
  }

  private static boolean findClassNameExactMatch(PsiBuilder b, int l, StringHolder currentTokenText,
                                                 final boolean isPluralForm,
                                                 @NotNull String toldApplicationName,
                                                 boolean areThereUseStatements,
                                                 @Nullable Set<String> applicationsToImportFrom) {
    boolean r;
    //toldAppName = CocoaStandard by default
//    if (toldApplicationName != null) {
    PsiBuilder.Marker m = enter_section_(b, l, _AND_, "<find Class Name Exact Match>");
    r = findApplicationClassNameExactMatch(b, l + 1, currentTokenText, isPluralForm, toldApplicationName);
    exit_section_(b, l, m, null, r, false, null);
    if (r) return findApplicationClassNameExactMatch(b, l + 1, currentTokenText, isPluralForm, toldApplicationName);
//    if (r) return true;
//    }
    if (areThereUseStatements) {
      if (applicationsToImportFrom != null && !applicationsToImportFrom.isEmpty()) {
        for (String appName : applicationsToImportFrom) {
//          if (ApplicationDictionary.STD_LIBRARY_NAMES.contains(appName)) {
//            r = findStdClassNameExactMatch(b, l + 1, currentTokenText, isPluralForm);
//            if (r) return true;
//          } else {
          m = enter_section_(b, l, _AND_, "<find Class Name Exact Match>");
          r = findApplicationClassNameExactMatch(b, l + 1, currentTokenText, isPluralForm, appName);
          exit_section_(b, l, m, null, r, false, null);
          if (r) return findApplicationClassNameExactMatch(b, l + 1, currentTokenText, isPluralForm, appName);
//          if (r) return true;
//          }
        }
      }
    } else {
      m = enter_section_(b, l, _AND_, "<find Class Name Exact Match>");
      r = findStdClassNameExactMatch(b, l + 1, currentTokenText, isPluralForm);
      exit_section_(b, l, m, null, r, false, null);
      if (r) return findStdClassNameExactMatch(b, l + 1, currentTokenText, isPluralForm);
    }
    // ...it looks like not all CocoaStandard classes(and other terms) could be presented in applications
    // terminology. So need to check CocoaStandard any way...
    // If told application name == standard additions, terms from Cocoa Standard library were not checked
    // Checking them here
//    if (ApplicationDictionary.STANDARD_ADDITIONS_LIBRARY.equals(toldApplicationName)) {
      m = enter_section_(b, l, _AND_, "<find Class Name Exact Match>");
      r = findApplicationClassNameExactMatch(b, l + 1, currentTokenText, isPluralForm,
              ApplicationDictionary.STANDARD_COCOA_LIBRARY);
      exit_section_(b, l, m, null, r, false, null);
      if (r) return findApplicationClassNameExactMatch(b, l + 1, currentTokenText, isPluralForm,
              ApplicationDictionary.STANDARD_COCOA_LIBRARY);
//    }
    return false;
  }

  private static boolean findStdClassNameExactMatch(PsiBuilder b, int l, StringHolder currentTokenText,
                                                    boolean isPluralForm) {
    currentTokenText.value = b.getTokenText() == null ? "" : b.getTokenText();
    if (isPluralForm) {
      int candidatesCount = ParsableScriptSuiteRegistryHelper
              .countStdClassesStartingWithPluralName(currentTokenText.value);
      while (b.getTokenText() != null && candidatesCount > 0) {
        boolean r = identifier(b, l + 1);
        if (!r) r = builtInClassIdentifier(b, l + 1);
        if (!r) b.advanceLexer(); //advance lexer in any case
        if (candidatesCount == 1) {
          if (ParsableScriptSuiteRegistryHelper.isStdLibClassPluralName(currentTokenText.value)) {
            return true;
          }

          currentTokenText.value = currentTokenText.value + " " + b.getTokenText();
          candidatesCount = ParsableScriptSuiteRegistryHelper
                  .countStdClassesStartingWithPluralName(currentTokenText.value);

        } else {
          boolean foundExactMatch = ParsableScriptSuiteRegistryHelper
                  .isStdLibClassPluralName(currentTokenText.value);

          currentTokenText.value = currentTokenText.value + " " + b.getTokenText();
          candidatesCount = ParsableScriptSuiteRegistryHelper
                  .countStdClassesStartingWithPluralName(currentTokenText.value);
          if (candidatesCount == 0) {
            return foundExactMatch;
          }
        }
      }
      return false;
    } else {
      int candidatesCount = ParsableScriptSuiteRegistryHelper
              .countStdClassesStartingWithName(currentTokenText.value);
      while (b.getTokenText() != null && candidatesCount > 0) {
        boolean r = identifier(b, l + 1);
        if (!r) r = builtInClassIdentifier(b, l + 1);
        if (!r) b.advanceLexer(); //advance lexer in any case
        if (candidatesCount == 1) {
          if (ParsableScriptSuiteRegistryHelper.isStdLibClass(currentTokenText.value)) {
            return true;
          }

          currentTokenText.value = currentTokenText.value + " " + b.getTokenText();
          candidatesCount = ParsableScriptSuiteRegistryHelper
                  .countStdClassesStartingWithName(currentTokenText.value);

        } else {
          boolean foundExactMatch = ParsableScriptSuiteRegistryHelper.isStdLibClass(currentTokenText.value);

          currentTokenText.value = currentTokenText.value + " " + b.getTokenText();
          candidatesCount = ParsableScriptSuiteRegistryHelper
                  .countStdClassesStartingWithName(currentTokenText.value);
          if (candidatesCount == 0) {
            return foundExactMatch;
          }
        }
      }
      return false;
    }
  }

  private static boolean findApplicationClassNameExactMatch(PsiBuilder b, int l, StringHolder currentTokenText,
                                                            final boolean isPluralForm,
                                                            @NotNull String applicationName) {
    currentTokenText.value = b.getTokenText() == null ? "" : b.getTokenText();
    if (isPluralForm) {
      int candidatesCount = ParsableScriptSuiteRegistryHelper
              .countApplicationClassesStartingWithPluralName(applicationName, currentTokenText.value);
      if (candidatesCount > 0) {//checking in this application's dictionary
        while (b.getTokenText() != null) {
          boolean r = identifier(b, l + 1);
          if (!r) r = builtInClassIdentifier(b, l + 1);
          if (!r) b.advanceLexer(); //advance lexer in any case
          if (candidatesCount == 1) {
            if (ParsableScriptSuiteRegistryHelper.isApplicationClassPluralName(applicationName, currentTokenText
                    .value)) {
              return true;
            }

            currentTokenText.value = currentTokenText.value + " " + b.getTokenText();
            candidatesCount = ParsableScriptSuiteRegistryHelper.countApplicationClassesStartingWithPluralName
                    (applicationName,
                            currentTokenText.value);

          } else {
            boolean foundExactMatch = ParsableScriptSuiteRegistryHelper.isApplicationClassPluralName(applicationName,
                    currentTokenText.value);
            currentTokenText.value = currentTokenText.value + " " + b.getTokenText();
            candidatesCount = ParsableScriptSuiteRegistryHelper.countApplicationClassesStartingWithPluralName
                    (applicationName,
                            currentTokenText.value);
            if (candidatesCount == 0) {
              return foundExactMatch;
            }
          }
        }
      }
//      else {
//        candidatesCount = ParsableScriptSuiteRegistryHelper.countStdClassesStartingWithPluralName(currentTokenText
//                .value);
//        while (b.getTokenText() != null && candidatesCount > 0) {//checking in standard definitions
//          boolean r = identifier(b, l + 1);
//          if (!r) r = builtInClassIdentifier(b, l + 1);
//          if (!r) b.advanceLexer(); //advance lexer in any case
//          if (candidatesCount == 1) {
//            if (ParsableScriptSuiteRegistryHelper.isStdLibClassPluralName(currentTokenText.value)) {
//              return true;
//            }
//
//            currentTokenText.value = currentTokenText.value + " " + b.getTokenText();
//            candidatesCount = ParsableScriptSuiteRegistryHelper
//                    .countStdClassesStartingWithPluralName(currentTokenText.value);
//          } else {
//            boolean foundExactMatch = ParsableScriptSuiteRegistryHelper
//                    .isStdLibClassPluralName(currentTokenText.value);
//
//            currentTokenText.value = currentTokenText.value + " " + b.getTokenText();
//            candidatesCount = ParsableScriptSuiteRegistryHelper
//                    .countStdClassesStartingWithPluralName(currentTokenText.value);
//            if (candidatesCount == 0) {
//              return foundExactMatch;
//            }
//          }
//        }
//      }
      return false;
    } else {
      int candidatesCount = ParsableScriptSuiteRegistryHelper.countApplicationClassesStartingWithName(applicationName,
              currentTokenText.value);
      if (candidatesCount > 0) { //if there are classes exist in this application's dictionary

        while (b.getTokenText() != null) {
          boolean r = identifier(b, l + 1);
          if (!r) r = builtInClassIdentifier(b, l + 1);
          if (!r) b.advanceLexer(); //advance lexer in any case

          if (candidatesCount == 1) {
            if (ParsableScriptSuiteRegistryHelper.isApplicationClass(applicationName, currentTokenText.value)) {
              return true;
            }
            currentTokenText.value = currentTokenText.value + " " + b.getTokenText();
            candidatesCount = ParsableScriptSuiteRegistryHelper
                    .countApplicationClassesStartingWithName(applicationName, currentTokenText.value);

          } else {
            boolean foundExactMatch = ParsableScriptSuiteRegistryHelper
                    .isApplicationClass(applicationName, currentTokenText.value);
            currentTokenText.value = currentTokenText.value + " " + b.getTokenText();
            candidatesCount = ParsableScriptSuiteRegistryHelper
                    .countApplicationClassesStartingWithName(applicationName, currentTokenText.value);
            if (candidatesCount == 0) {
              return foundExactMatch;
            }
          }
        }
      }
//      else {//else if there were no classes found in application dictionary searching in standard definitions
//        candidatesCount = ParsableScriptSuiteRegistryHelper.countStdClassesStartingWithName(currentTokenText.value);
//        while (b.getTokenText() != null && candidatesCount > 0) {
//          boolean r = identifier(b, l + 1);
//          if (!r) r = builtInClassIdentifier(b, l + 1);
//          if (!r) b.advanceLexer(); //advance lexer in any case
//
//          if (candidatesCount == 1) {
//            if (ParsableScriptSuiteRegistryHelper.isStdLibClass(currentTokenText.value)) {
//              return true;
//            }
//            currentTokenText.value = currentTokenText.value + " " + b.getTokenText();
//            candidatesCount = ParsableScriptSuiteRegistryHelper
//                    .countStdClassesStartingWithName(currentTokenText.value);
//          } else {
//            boolean foundExactMatch = ParsableScriptSuiteRegistryHelper.isStdLibClass(currentTokenText.value);
//            currentTokenText.value = currentTokenText.value + " " + b.getTokenText();
//            candidatesCount = ParsableScriptSuiteRegistryHelper
//                    .countStdClassesStartingWithName(currentTokenText.value);
//            if (candidatesCount == 0) {
//              return foundExactMatch;
//            }
//          }
//        }
//      }
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
    String toldApplicationName = getTargetApplicationName(b);
    boolean areThereUseStatements = b.getUserData(WAS_USE_STATEMENT_USED) == Boolean.TRUE;
    Set<String> applicationsToImportFrom = null;
    if (areThereUseStatements) {
      applicationsToImportFrom = b.getUserData(USED_APPLICATION_NAMES);
    }
//    if (toldApplicationName != null) {
    //todo how not to make it check twice?
    PsiBuilder.Marker m = enter_section_(b, l, _AND_, "<parse Declared Name Inner>");
    r = tryToParseApplicationConstant(b, l + 1, toldApplicationName);
    exit_section_(b, l, m, null, r, false, null);
    if (r) {
      r = tryToParseApplicationConstant(b, l + 1, toldApplicationName);
      return r;
    }
//    }
    if (areThereUseStatements) {
      if (applicationsToImportFrom != null && !applicationsToImportFrom.isEmpty()) {
        for (String appName : applicationsToImportFrom) {
//          if (ApplicationDictionary.STD_LIBRARY_NAMES.contains(appName)) {
//            m = enter_section_(b, l, _AND_, "<parse Declared Name Inner>");
//            r = tryToParseStdConstant(b, l + 1);
//            exit_section_(b, l, m, null, r, false, null);
//            if (r) {
//              r = tryToParseStdConstant(b, l + 1);
//              return r;
//            }
//          } else {
          m = enter_section_(b, l, _AND_, "<parse Declared Name Inner>");
          r = tryToParseApplicationConstant(b, l + 1, appName);
          exit_section_(b, l, m, null, r, false, null);
          if (r) {
            r = tryToParseApplicationConstant(b, l + 1, appName);
            return r;
          }
//          }
        }
      }
    } else {
      m = enter_section_(b, l, _AND_, "<parse Declared Name Inner>");
      r = tryToParseStdConstant(b, l + 1);
      exit_section_(b, l, m, null, r, false, null);
      if (r) {
        r = tryToParseStdConstant(b, l + 1);
        return r;
      }
      if (ApplicationDictionary.STANDARD_ADDITIONS_LIBRARY.equals(toldApplicationName)) {
        m = enter_section_(b, l, _AND_, "<parse Declared Name Inner>");
        r = tryToParseApplicationConstant(b, l + 1, ApplicationDictionary.STANDARD_COCOA_LIBRARY);
        exit_section_(b, l, m, null, r, false, null);
        if (r) {
          r = tryToParseApplicationConstant(b, l + 1, ApplicationDictionary.STANDARD_COCOA_LIBRARY);
          return r;
        }
      }
    }
    return false;
  }

  private static boolean tryToParseStdConstant(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryToParseStdConstant")) return false;
    StringHolder currentTokenText = new StringHolder();
    currentTokenText.value = "";
    currentTokenText.value = b.getTokenText() == null ? "" : b.getTokenText();
    int candidatesCount = ParsableScriptSuiteRegistryHelper.countStdConstantStartingWithName(currentTokenText.value);
//    int candidatesCount = ParsableScriptSuiteRegistryHelper.findConstantsStartingWithWord(currentTokenText.value)
//            .size();
    while (b.getTokenText() != null && candidatesCount > 0) {
      if (candidatesCount == 1) {
        if (ParsableScriptSuiteRegistryHelper.isStdConstant(currentTokenText.value)) {
          b.advanceLexer();
          return true;
        }
        b.advanceLexer();
        currentTokenText.value = currentTokenText.value + " " + b.getTokenText();
        candidatesCount = ParsableScriptSuiteRegistryHelper.countStdConstantStartingWithName(currentTokenText.value);
      } else {
        boolean foundExactMatch = ParsableScriptSuiteRegistryHelper.isStdConstant(currentTokenText.value);
        b.advanceLexer();
        currentTokenText.value = currentTokenText.value + " " + b.getTokenText();
        candidatesCount = ParsableScriptSuiteRegistryHelper.countStdConstantStartingWithName(currentTokenText.value);
        if (candidatesCount == 0) {
          return foundExactMatch;
        }
      }

    }
    return false;
  }

  private static boolean tryToParseApplicationConstant(PsiBuilder b, int l, @NotNull String applicationName) {
    if (!recursion_guard_(b, l, "tryToParseApplicationConstant")) return false;
    StringHolder currentTokenText = new StringHolder();
    currentTokenText.value = "";
    currentTokenText.value = b.getTokenText() == null ? "" : b.getTokenText();
    int candidatesCount = ParsableScriptSuiteRegistryHelper
            .countApplicationConstantStartingWithName(applicationName, currentTokenText.value);
//            .findConstantsStartingWithWord(applicationName,currentTokenText.value).size();
    if (candidatesCount > 0) {
      while (b.getTokenText() != null) {
        b.advanceLexer();
        if (candidatesCount == 1) {
          if (ParsableScriptSuiteRegistryHelper.isApplicationConstant(applicationName, currentTokenText.value)) {
            return true;
          }
          currentTokenText.value = currentTokenText.value + " " + b.getTokenText();
          candidatesCount = ParsableScriptSuiteRegistryHelper
                  .countApplicationConstantStartingWithName(applicationName, currentTokenText.value);
//                  .findConstantsStartingWithWord(applicationName,currentTokenText.value).size();
        } else {
          boolean foundExactMatch = ParsableScriptSuiteRegistryHelper
                  .isApplicationConstant(applicationName, currentTokenText.value);
          currentTokenText.value = currentTokenText.value + " " + b.getTokenText();
          candidatesCount = ParsableScriptSuiteRegistryHelper
                  .countApplicationConstantStartingWithName(applicationName, currentTokenText.value);
//                  .findConstantsStartingWithWord(applicationName,currentTokenText.value).size();
          if (candidatesCount == 0) {
            return foundExactMatch;
          }
        }

      }
    } else {
      candidatesCount = ParsableScriptSuiteRegistryHelper.countStdConstantStartingWithName(currentTokenText.value);
      while (b.getTokenText() != null && candidatesCount > 0) {
        b.advanceLexer();
        if (candidatesCount == 1) {
          if (ParsableScriptSuiteRegistryHelper.isStdConstant(currentTokenText.value)) {
            return true;
          }
          currentTokenText.value = currentTokenText.value + " " + b.getTokenText();
          candidatesCount = ParsableScriptSuiteRegistryHelper.countStdConstantStartingWithName(currentTokenText.value);
        } else {
          boolean foundExactMatch = ParsableScriptSuiteRegistryHelper.isStdConstant(currentTokenText.value);
          currentTokenText.value = currentTokenText.value + " " + b.getTokenText();
          candidatesCount = ParsableScriptSuiteRegistryHelper.countStdConstantStartingWithName(currentTokenText.value);
          if (candidatesCount == 0) {
            return foundExactMatch;
          }
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

//  /**
//   * Matches to the shortest parsed name
//   *
//   * @return true if name matches
//   */
//  //todo add not only identifiers parsing
//  //todo candidates count like with dictionary classes to match the biggest input
//  private static boolean tryToParseDeclaredName(PsiBuilder b, int l, DeclaredType declaredNameType) {
//    if (!recursion_guard_(b, l, "tryToParseDeclaredName")) return false;
//
//    boolean advance;
//    StringHolder currentTokenText = new StringHolder();
//    currentTokenText.value = b.getTokenText() == null ? "" : b.getTokenText();
//    String currTokenTextVal = currentTokenText.value;
//    if (isThisNameDeclared(currTokenTextVal, declaredNameType)) {
//      b.advanceLexer();
//      return true;
//    }
//    advance = consumeSimpleIdentifierAndAppendText(b, l + 1, currentTokenText, declaredNameType);
//    while (advance) {
//      boolean foundDictionaryMatch = isThisNameDeclared(currentTokenText.value, declaredNameType);
//      if (foundDictionaryMatch) {
//        b.advanceLexer();
//        return true;
//      }
//      advance = consumeSimpleIdentifierAndAppendText(b, l + 1, currentTokenText, declaredNameType);
//    }
//    return false;
//  }

  private static List<DictionaryComponent> findDictionaryTypeWithName(String currTokenTextVal, DeclaredType
          declaredNameType) {
    return null;
  }

//  private static boolean tryToParseDeclaredName(PsiBuilder b, int l, DeclaredType dictionaryDeclaredType,
//                                                StringHolder parsedName) {
//    if (!recursion_guard_(b, l, "tryToParseDeclaredName")) return false;
//
//    boolean advance;
//    StringHolder currentTokenText = new StringHolder();
//    currentTokenText.value = "";
////    TokenSet tokensToConsume;
////
////    if (dictionaryDeclaredType == DeclaredType.SDEF_COMMAND_NAME) {//DICTIONARY_COMMAND_NAME IElementType
////      tokensToConsume = TokenSet.create(VAR_IDENTIFIER, BY, FROM, INSTEAD_OF, INTO, ON, OUT_OF, THRU,
////              THROUGH, TO, BUILT_IN_CLASS_ID);
////    } else if (dictionaryDeclaredType == DeclaredType.SDEF_COMMAND_PARAMETER_SELECTOR) {
////      //todo where to check for with/without?
////    }
//    currentTokenText.value = b.getTokenText() == null ? "" : b.getTokenText();
//    if (isThisNameDeclared(currentTokenText.value, dictionaryDeclaredType)) {
//      b.advanceLexer();
//      return true;
//    }
//    advance = consumeSimpleIdentifierAndAppendText(b, l + 1, currentTokenText, dictionaryDeclaredType);
//    while (advance) {
//      if (isThisNameDeclared(currentTokenText.value, dictionaryDeclaredType)) {
//        b.advanceLexer();
//        return true;
//      }
//      advance = consumeSimpleIdentifierAndAppendText(b, l + 1, currentTokenText, dictionaryDeclaredType);
//    }
//    return false;
//  }

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
    if (!r) r = consumeToken(b, ZONE);
    if (!r) r = consumeToken(b, COPY); //without one copy
    if (!r) r = consumeToken(b, AFTER);
    if (!r) r = consumeToken(b, BEFORE);
    if (!r) r = consumeToken(b, BEGINNING);
    if (!r) r = consumeToken(b, FRONT);
    if (!r) r = consumeToken(b, BACK);
    if (!r) r = consumeToken(b, END);
    if (!r) r = consumeToken(b, AS);
    if (!r) r = consumeToken(b, USING);

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
//    if (!r) b.advanceLexer();
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
    if (!r) r = consumeToken(b, CURRENT);
    if (!r) r = consumeToken(b, COUNT);
    if (!r) r = consumeToken(b, SCRIPT);
    if (!r) r = consumeToken(b, WITH);//todo check this
    if (!r) r = consumeToken(b, WITHOUT);
    if (!r) r = consumeToken(b, SET);
    if (!r) r = consumeToken(b, COPY);
    if (!r) r = consumeToken(b, APPLICATION);
    if (!r) r = consumeToken(b, THE_KW);
    if (!r) r = consumeToken(b, GET);
    if (!r) r = consumeToken(b, SET);//todo need to handle this somehow as assignment statement
//    if (!r && nextTokenIs(b, "dictionaryCommandNameTokens", NLS)) {
//      b.advanceLexer();
//      r = true;
//    }
//    exit_section_(b, m, null, true);
    exit_section_(b, m, null, r);
    return r;
//    return true;
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
  // BUILT_IN_TYPE_S|scripts
  static boolean builtInClassIdentifierPlural(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "builtInClassIdentifierPlural")) return false;
    if (!nextTokenIs(b, "", BUILT_IN_TYPE_S, SCRIPTS)) return false;
    boolean r;
    PsiBuilder.Marker m = enter_section_(b);
    r = consumeToken(b, BUILT_IN_TYPE_S);
    if (!r) r = consumeToken(b, SCRIPTS);
    exit_section_(b, m, null, r);
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


//  private static boolean isThisNameDeclared(String name, DeclaredType declaredNameType) {
//    if (!StringUtil.isEmpty(name)) {
//      boolean r;
//      switch (declaredNameType) {
//        case SDEF_COMMAND_NAME:
//          if (ParsableScriptSuiteRegistryHelper.findCommandWithName(name) != null)
//            return true;
//
////          for (String stdName : SCRIPTING_ADDITION_COMMAND_NAMES) {
////            if (stdName.equals(name))
////              return true;
////          }
//          break;
//        case PROPERTY_LABEL_NAME:
//          if (ParsableScriptSuiteRegistryHelper.getPropertyWithName(name) != null)
//            return true;
//
////          for (String stdName : PARSED_SCRIPT_OBJECTS_PROPERTIES) {
////            if (stdName.equals(name))
////              return true;
////          }
//          break;
//        case SDEF_COMMAND_PARAMETER_SELECTOR:
//          for (String stdName : PARSED_COMMAND_PARAMETER_NAMES) {
//            if (stdName.equals(name))
//              return true;
//          }
//          break;
//        case SDEF_CLASS_NAME:
//          if (ParsableScriptSuiteRegistryHelper.findClassWithName(name) != null)
//            return true;
//
////          for (String stdName : PARSED_CLASS_NAMES) {
////            if (stdName.equals(name))
////              return true;
////          }
//          break;
//        case SDEF_CONSTANT:
//          if (ParsableScriptSuiteRegistryHelper.getEnumerator(name) != null)
//            return true;
//          break;
//
//        default:
//          return false;
//      }
//    }
//    return false;
//  }
}
