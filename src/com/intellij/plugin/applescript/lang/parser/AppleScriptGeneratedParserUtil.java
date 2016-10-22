package com.intellij.plugin.applescript.lang.parser;

import com.intellij.lang.LighterASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.parser.GeneratedParserUtilBase;
import com.intellij.openapi.util.Key;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.plugin.applescript.AppleScriptNames;
import com.intellij.plugin.applescript.lang.sdef.AppleScriptCommand;
import com.intellij.plugin.applescript.lang.sdef.ApplicationDictionary;
import com.intellij.plugin.applescript.lang.sdef.CommandDirectParameter;
import com.intellij.plugin.applescript.lang.sdef.CommandParameter;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.omg.CORBA.StringHolder;

import java.util.*;

import static com.intellij.plugin.applescript.psi.AppleScriptTypes.*;

/**
 * Andrey 13.04.2015
 */
public class AppleScriptGeneratedParserUtil extends GeneratedParserUtilBase {

  private static final Key<Boolean> PARSING_COMMAND_HANDLER_CALL_PARAMETERS =
          Key.create("applescript.parsing.command.handler.parameters");
  private static final Key<Boolean> PARSING_COMMAND_ASSIGNMENT_STATEMENT =
          Key.create("applescript.parsing.assignment.statement");
  private static final Key<Boolean> PARSING_COMMAND_HANDLER_BOOLEAN_PARAMETER =
          Key.create("applescript.parsing.command.handler.boolean.parameter");

  // for storing application names inside <tell...end tell> statements
  public static final Key<Stack<String>> TOLD_APPLICATION_NAME_STACK =
          Key.create("applescript.parsing.current.dictionary.name.stack");
  // for storing application id reference inside <tell...end tell> statements
  public static final Key<Stack<String>> TOLD_APPLICATION_ID_STACK =
          Key.create("applescript.parsing.current.dictionary.id.stack");
  private static final Key<Boolean> PARSING_TELL_SIMPLE_STATEMENT =
          Key.create("applescript.parsing.tell.simple.statement");
  private static final Key<Boolean> PARSING_TELL_SIMPLE_OBJECT_REF =
          Key.create("applescript.parsing.tell.simple.object.ref");
  private static final Key<Boolean> PARSING_TELL_COMPOUND_STATEMENT =
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
  // to allow parsing of constants inside list, record literals
  private static final Key<Boolean> PARSING_LITERAL_EXPRESSION =
          Key.create("applescript.parsing.literal.expression");

  /**
   * @param b                        {@link PsiBuilder}
   * @param l                        level deep
   * @param parsedName               holder for parsed command name string
   * @param toldApplicationName      name of the application to which all messages are sent by default (it's
   *                                 terminology is queried first)
   * @param areThereUseStatements    if there are use statements in script
   * @param applicationsToImportFrom list of application names to use for dictionary terms lookup
   * @return true if rule matches, false otherwise
   */
  private static boolean parseDictionaryCommandNameInner(PsiBuilder b, int l,
                                                         @NotNull StringHolder parsedName,
                                                         @NotNull String toldApplicationName,
                                                         boolean areThereUseStatements,
                                                         @Nullable Set<String> applicationsToImportFrom) {
    if (!recursion_guard_(b, l, "parseDictionaryCommandNameInner")) return false;
    boolean r;
    parsedName.value = "";
    // TODO: 12/1/2015 could be command with name which does not exist in this target app but in stanradr additions or
    // CocoaStandard dictionary or in use application dictionary. write all code here?? to find the longest
    // dictionary term
    //if there are use statements, do not check terms from scripting additions library (they should be explicitly
    // imported in this case)
    boolean checkStdLib = !areThereUseStatements || applicationsToImportFrom == null
            || applicationsToImportFrom.contains(ApplicationDictionary.SCRIPTING_ADDITIONS_LIBRARY);
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
    r = parseCommandNameForApplication(b, l + 1, parsedName, ApplicationDictionary.COCOA_STANDARD_LIBRARY,
            checkStdLib);
    return r;
  }

  /**
   * <<< COMMAND_HANDLER_CALL >>>
   */
  // commandName commandParameters?
  public static boolean parseCommandHandlerCallExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parseCommandHandlerCallExpression")) return false;
    boolean r;
    //return false if next is a new line
    if (nextTokenIs(b, NLS)) return false;
    final String s = b.getTokenText();
    //return false if next token is null or not allowed to use in AppleScript identifiers
    if (s == null || s.length() == 0 || !AppleScriptNames.isIdentifierStart(s.charAt(0))) return false;
    StringHolder parsedCommandName = new StringHolder();
    //get current application name to which messages will be sent in the current block
    String toldApplicationName = getTargetApplicationName(b);
    //if there are <use statements> present in the script
    boolean areThereUseStatements = b.getUserData(WAS_USE_STATEMENT_USED) == Boolean.TRUE;
    Set<String> applicationsToImport = null;
    if (areThereUseStatements) {
      //adding list of application names from use statements
      applicationsToImport = b.getUserData(USED_APPLICATION_NAMES);
    }
    PsiBuilder.Marker m2 = enter_section_(b, l, _COLLAPSE_, "<parse Command Handler Call Expression>");
    // TODO: 19/12/15 need to parse command name together with parameters for each possible application in order to be
    // able to parse the longest possible application name ('open for access' std lib vs 'open' from application dict)
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

  // commandName commandParameters?
  public static boolean parseApplicationHandlerDefinitionSignature(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parseApplicationHandlerDefinitionSignature")) return false;
    boolean r;
    if (b.getUserData(IS_PARSING_USING_TERMS_FROM_STATEMENT) != Boolean.TRUE
            || b.getUserData(PARSING_TELL_COMPOUND_STATEMENT) == Boolean.TRUE) return false;

    StringHolder parsedCommandName = new StringHolder();
    String toldApplicationName = getTargetApplicationName(b);
    PsiBuilder.Marker m2 = enter_section_(b, l, _COLLAPSE_, "<parse Application Handler Definition");
    r = parseDictionaryCommandNameInner(b, l + 1, parsedCommandName, toldApplicationName, true, null);
    exit_section_(b, l, m2, DICTIONARY_COMMAND_NAME, r, false, null);

    if (!r) return false;
    // TODO: 06/12/15 may be try to avoid creating PSI here!..
    List<AppleScriptCommand> allCommandsWithName = getAllCommandsWithName(b, parsedCommandName.value,
            toldApplicationName, false, null);

    for (AppleScriptCommand command : allCommandsWithName) {
      r = parseParametersForCommand(b, l + 1, command);//custom parsing here
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
    List<AppleScriptCommand> allCommandsWithName = new ArrayList<>();
    allCommandsWithName.addAll(ParsableScriptSuiteRegistryHelper
            .findApplicationCommands(b.getProject(), toldApplicationName, parsedCommandName));
    // Scripting Additions StandardAdditions fake application does not contain CocoaStandard terms. Adding them here
    if (ApplicationDictionary.SCRIPTING_ADDITIONS_LIBRARY.equals(toldApplicationName)) {
      allCommandsWithName.addAll(ParsableScriptSuiteRegistryHelper.findApplicationCommands(b.getProject(),
              ApplicationDictionary.COCOA_STANDARD_LIBRARY, parsedCommandName));
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
              ApplicationDictionary.COCOA_STANDARD_LIBRARY, parsedCommandName));
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
  private static String getTargetApplicationName(PsiBuilder b) {
    String toldApplicationName = peekTargetApplicationName(b);
    // CocoaStandard library is always available for the scriptable application
    return toldApplicationName != null ? toldApplicationName : ApplicationDictionary.COCOA_STANDARD_LIBRARY;
  }

  @Nullable
  private static String peekTargetApplicationName(PsiBuilder b) {
    Stack<String> applicationNameStack = b.getUserData(TOLD_APPLICATION_NAME_STACK);
    String toldApplicationName = null;
    if (applicationNameStack != null && !applicationNameStack.isEmpty()) {
      toldApplicationName = applicationNameStack.peek();
    }
    return toldApplicationName;
  }

  /**
   * @param b               {@link PsiBuilder}
   * @param l               level deep
   * @param parsedName      holder for parsed term string
   * @param applicationName name of the application, which dictionary terms will be queried
   * @param checkStdLib     whether to check in scripting additions library if no terms were found in this application
   * @return true if command name was parsed
   */
  private static boolean parseCommandNameForApplication(PsiBuilder b, int l,
                                                        StringHolder parsedName,
                                                        @NotNull String applicationName,
                                                        boolean checkStdLib) {
    if (!recursion_guard_(b, l, "parseCommandNameForApplication")) return false;
    boolean r = false;
    parsedName.value = "";
    PsiBuilder.Marker m = enter_section_(b);
    parsedName.value = b.getTokenText() == null ? "" : b.getTokenText();

    boolean commandWithPrefixExists = ParsableScriptSuiteRegistryHelper.isCommandWithPrefixExist(applicationName,
            parsedName.value);
    String nextTokenText = parsedName.value;
    while (b.getTokenText() != null && commandWithPrefixExists) {
      b.advanceLexer(); //advance lexer to the next token
      nextTokenText += " " + b.getTokenText();
      commandWithPrefixExists = ParsableScriptSuiteRegistryHelper
              .isCommandWithPrefixExist(applicationName, nextTokenText);
      if (commandWithPrefixExists) {
        //if command with prefix exists, append token text
        parsedName.value = nextTokenText;
      } else if (ParsableScriptSuiteRegistryHelper.isApplicationCommand(applicationName, parsedName.value)) {
        //if there is std command with longer prefix exists do not parse it here
        r = !checkStdLib || !ParsableScriptSuiteRegistryHelper.isStdCommandWithPrefixExist(nextTokenText);
        // if there is class name with longer prefix exists !! AND !! next is NLS token => do not this as command name
//        boolean longerClassNameExists = ParsableScriptSuiteRegistryHelper
//                .isClassWithPrefixExist(applicationName, nextTokenText);
//        if (r && longerClassNameExists) {
//          while (b.getTokenType() != NLS) {
//            b.advanceLexer();
//            nextTokenText += " " + b.getTokenText();
//          }
//          r = ParsableScriptSuiteRegistryHelper.isApplicationClass(applicationName, nextTokenText);
//        }
        r = r && !ParsableScriptSuiteRegistryHelper.isClassWithPrefixExist(applicationName, nextTokenText);
        break;
      }
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // of? directParameterValue? commandParameters?

  /**
   * @param b                       {@link PsiBuilder}
   * @param l                       level deep
   * @param parsedCommandDefinition command for which pars the parameters
   * @return true if rule matches, false otherwise
   */
  private static boolean parseParametersForCommand(PsiBuilder b, int l,
                                                   @NotNull final AppleScriptCommand parsedCommandDefinition) {
    if (!recursion_guard_(b, l, "parseParametersForCommand")) return false;
    boolean r = true;
    PsiBuilder.Marker m = enter_section_(b, l, _NONE_, "<parse command handler call parameters>");
    b.putUserData(PARSING_COMMAND_HANDLER_CALL_PARAMETERS, true);
    if (parsedCommandDefinition.getDirectParameter() != null) {
      consumeToken(b, OF); //not mandatory
      r = parseCommandDirectParameterValue(b, l + 1, parsedCommandDefinition.getDirectParameter());
    }
    if (!parsedCommandDefinition.getParameters().isEmpty()) {
      r = parseCommandParameters(b, l + 1, parsedCommandDefinition);
    }
    exit_section_(b, l, m, null, r, false, null);
    b.putUserData(PARSING_COMMAND_HANDLER_CALL_PARAMETERS, false);
    return true;
  }

  /**
   * Call handler with labeled parameters in grammar not allowed in assignment, tell statements or when parsing
   * application command parameters
   *
   * @param b {@link PsiBuilder}
   * @param l level deep
   * @return true if handlerLabeledParametersCall is currently allowed
   */
  public static boolean isHandlerLabeledParametersCallAllowed(PsiBuilder b, int l) {
    return b.getUserData(PARSING_COMMAND_ASSIGNMENT_STATEMENT) != Boolean.TRUE
//            && b.getUserData(PARSING_TELL_SIMPLE_STATEMENT) != Boolean.TRUE
            && b.getUserData(PARSING_TELL_SIMPLE_OBJECT_REF) != Boolean.TRUE
            && b.getUserData(PARSING_COMMAND_HANDLER_CALL_PARAMETERS) != Boolean.TRUE;
  }

  public static boolean isTreePrevSimpleReference(PsiBuilder b, int l) {
    return b.getLatestDoneMarker() != null
            && b.getLatestDoneMarker().getTokenType() == REFERENCE_EXPRESSION;
  }

  public static boolean parseAssignmentStatementInner(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parseAssignmentStatementInner")) return false;
    boolean r;
    b.putUserData(PARSING_COMMAND_ASSIGNMENT_STATEMENT, true);
    r = AppleScriptParser.assignmentStatement(b, l + 1);
    b.putUserData(PARSING_COMMAND_ASSIGNMENT_STATEMENT, false);
    return r;
  }

  public static boolean parseLiteralExpression(PsiBuilder b, int l, Parser literalExpression) {
    if (!recursion_guard_(b, l, "parseLiteralExpression")) return false;
    boolean r;
    b.putUserData(PARSING_LITERAL_EXPRESSION, true);
    r = literalExpression.parse(b, l + 1);
    b.putUserData(PARSING_LITERAL_EXPRESSION, false);
    return r;
  }

  public static boolean parseTellSimpleStatementInner(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tellSimpleStatement")) return false;
    if (!nextTokenIs(b, TELL)) return false;
    boolean r;
    boolean pushStateBefore = b.getUserData(APPLICATION_NAME_PUSHED) == Boolean.TRUE;
    b.putUserData(APPLICATION_NAME_PUSHED, false);
    b.putUserData(PARSING_TELL_SIMPLE_STATEMENT, true);
    r = AppleScriptParser.tellSimpleStatement(b, l + 1);
    b.putUserData(PARSING_TELL_SIMPLE_STATEMENT, false);
    popApplicationNameIfWasPushed(b);
    b.putUserData(APPLICATION_NAME_PUSHED, pushStateBefore);
    return r;
  }

  /**
   * For custom parsing, so not to detect 'referenceIdentifier to ...' as labeled handler call
   */
  public static boolean parseTellSimpleObjectReference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parseTellSimpleObjectReference")) return false;
    boolean r;
    r = nextTokenIsFast(b, LPAREN) && AppleScriptParser.parenthesizedExpression(b, l + 1);
    if (!r) {
      b.putUserData(PARSING_TELL_SIMPLE_OBJECT_REF, true);
      r = AppleScriptParser.expression(b, l + 1);
      b.putUserData(PARSING_TELL_SIMPLE_OBJECT_REF, false);
    }
    return r;
  }

  private static void popApplicationNameIfWasPushed(PsiBuilder b) {
    if (b.getUserData(APPLICATION_NAME_PUSHED) == Boolean.TRUE) {
      Stack<String> dictionaryNameStack = b.getUserData(TOLD_APPLICATION_NAME_STACK);
      if (dictionaryNameStack != null && !dictionaryNameStack.isEmpty()) {//should always be true if r==true
        dictionaryNameStack.pop();
      }
    }
  }

  /**
   * Add application name from this &lt;use statement&gt; to the set of application names from dictionary of which to
   * import terms if importing condition is not explicitly prohibited by syntax
   *
   * @param b           {@link PsiBuilder}
   * @param l           level deep
   * @param isImporting whether to make terms from this application's dictionary available in the script
   * @return true if this is application reference
   */
  public static boolean parseUsedApplicationNameExternal(PsiBuilder b, int l, Parser isImporting) {
    if (!recursion_guard_(b, l, "parseUsedApplicationNameExternal")) return false;
    boolean r;
    if (!nextTokenIs(b, "parseUsedApplicationNameExternal", APPLICATION, APP, SCRIPTING_ADDITIONS)) return false;
    String appName = null;
    r = consumeToken(b, SCRIPTING_ADDITIONS);
    if (r) {
      appName = ApplicationDictionary.SCRIPTING_ADDITIONS_LIBRARY;
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
        usedAppNames = new HashSet<>();
        b.putUserData(USED_APPLICATION_NAMES, usedAppNames);
      }
      usedAppNames.add(appName);
    }
    return r;
  }

  /**
   * If there is at least one &lt;use statement&gt; in script, set WAS_USE_STATEMENT_USED flag to true
   */
  public static boolean parseUseStatement(PsiBuilder b, int l, Parser useStatement) {
    if (!recursion_guard_(b, l, "parseUseStatement")) return false;
    boolean r = useStatement.parse(b, l + 1);
    boolean prevPass = b.getUserData(WAS_USE_STATEMENT_USED) == Boolean.TRUE;
    b.putUserData(WAS_USE_STATEMENT_USED, r || prevPass);
    return r;
  }

//  /**
//   * Checks if inside &lt;tell statement&gt; - first check it's terms
//   */
//  public static boolean parseRepeatStatement(PsiBuilder b, int l, Parser repeatStatement) {
//    if (!recursion_guard_(b, l, "parseRepeatStatement")) return false;
//    boolean r;
//    if (!nextTokenIs(b, REPEAT)) return false;
//    //if we are in tell statement - check application terms first
//    String toldAppName = peekTargetApplicationName(b);
//    if (!StringUtil.isEmpty(toldAppName)) {
//      StringHolder parsedName = new StringHolder();
//      PsiBuilder.Marker mComName = enter_section_(b, l, _AND_, "<parse Repeat Statement>");
//      r = parseCommandNameForApplication(b, l + 1, parsedName, toldAppName, true);
//      exit_section_(b, l, mComName, null, r, false, null);
//      if (r) return false;
//    }
//    r = repeatStatement.parse(b, l + 1);
//    return r;
//  }

  /**
   * If inside tell (only in a tell?) compound statement - first check it's terms
   */
  public static boolean parseExpression(PsiBuilder b, int l, String dictionaryTermToken, Parser expression) {
    if (!recursion_guard_(b, l, "parseExpression")) return false;
    if (!nextTokenIsFast(b, dictionaryTermToken)) return false;
    boolean r;

    //check application terms first
    if (b.getUserData(PARSING_TELL_COMPOUND_STATEMENT) == Boolean.TRUE) {
      String toldAppName = peekTargetApplicationName(b);
      if (!StringUtil.isEmpty(toldAppName)) {
        StringHolder parsedName = new StringHolder();
        PsiBuilder.Marker mComName = enter_section_(b, l, _AND_, "<parse Expression>");
        r = parseCommandNameForApplication(b, l + 1, parsedName, toldAppName, true);
        exit_section_(b, l, mComName, null, r, false, null);
        if (r) return false;
        if (ParsableScriptSuiteRegistryHelper.isPropertyWithPrefixExist(toldAppName, dictionaryTermToken)) {
          return false;
//          PsiBuilder.Marker m = enter_section_(b, l, _AND_, null, "<dictionary constant>");
//          r = parseDictionaryConstant(b, l + 1);
//          exit_section_(b, l, m, r, false, null);
//          if (r) return false;
        }
      }
    }
    return expression.parse(b, l + 1);
  }

  /**
   * If rule matches, removes added application name from the name stack which was used for parsing application terms
   *
   * @param b {@link PsiBuilder}
   * @param l level deep
   * @return true if rule matches
   */
  public static boolean parseTellCompoundStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parseTellCompoundStatement")) return false;
    if (!nextTokenIs(b, TELL)) return false;
    boolean r;
    boolean pushStateBefore = b.getUserData(APPLICATION_NAME_PUSHED) == Boolean.TRUE;
    boolean compoundStateBefore = b.getUserData(PARSING_TELL_COMPOUND_STATEMENT) == Boolean.TRUE;
    b.putUserData(APPLICATION_NAME_PUSHED, false);
    b.putUserData(PARSING_TELL_COMPOUND_STATEMENT, true);

    r = AppleScriptParser.tellCompoundStatement(b, l + 1);

    b.putUserData(PARSING_TELL_COMPOUND_STATEMENT, compoundStateBefore);
    popApplicationNameIfWasPushed(b);
    b.putUserData(APPLICATION_NAME_PUSHED, pushStateBefore);
    return r;
  }

  /**
   * If rule matches, removes added application name from the name stack which was used for parsing application terms
   *
   * @param b {@link PsiBuilder}
   * @param l level deep
   * @return true if rule matches
   */
  public static boolean parseUsingTermsFromStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parseUsingTermsFromStatement")) return false;
    boolean r;
    boolean oldParseUsingTermsState = b.getUserData(IS_PARSING_USING_TERMS_FROM_STATEMENT) == Boolean.TRUE;
    boolean oldPushedState = b.getUserData(APPLICATION_NAME_PUSHED) == Boolean.TRUE;
    b.putUserData(IS_PARSING_USING_TERMS_FROM_STATEMENT, true);
    b.putUserData(APPLICATION_NAME_PUSHED, false);

    r = AppleScriptParser.usingTermsFromStatement(b, l + 1);

    popApplicationNameIfWasPushed(b);
    b.putUserData(IS_PARSING_USING_TERMS_FROM_STATEMENT, oldParseUsingTermsState);
    b.putUserData(APPLICATION_NAME_PUSHED, oldPushedState);

    return r;
  }

  /**
   * Adds scripting additions library to the application name stack which is used for parsing application terms
   */
  public static boolean pushStdLibrary(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pushStdLibrary")) return false;
    boolean r;
    r = consumeToken(b, SCRIPTING_ADDITIONS);
    if (r) {
      pushTargetApplicationName(b, ApplicationDictionary.SCRIPTING_ADDITIONS_LIBRARY);
    }
    return r;
  }

  /**
   * @param b                           {@link PsiBuilder}
   * @param l                           Level deep
   * @param tellStatementStartCondition If this is the application reference of a &lt;tell&gt; or &lt;using terms
   *                                    from&gt; statements
   * @return true if parsed
   */
  public static boolean parseApplicationName(PsiBuilder b, int l, Parser tellStatementStartCondition) {
    if (!recursion_guard_(b, l, "parseApplicationName")) return false;
    boolean r;
    consumeToken(b, THE_KW);
    if (!nextTokenIs(b, "", APPLICATION, APP)) return false;

    PsiBuilder.Marker mCls = enter_section_(b, l, _NONE_, "<parse application name>");
    r = consumeToken(b, APPLICATION);
    if (!r) r = consumeToken(b, APP);
    exit_section_(b, l, mCls, DICTIONARY_CLASS_NAME, r, false, null);

    if (!nextTokenIs(b, "", STRING_LITERAL, ID)) return false;
    PsiBuilder.Marker mProp = enter_section_(b, l, _NONE_, "<parse application name>");
    boolean idReference = consumeToken(b, ID);
    exit_section_(b, l, mProp, DICTIONARY_PROPERTY_NAME, idReference, false, null);
    PsiBuilder.Marker m = enter_section_(b);
    String applicationNameString = b.getTokenText();
    r = consumeToken(b, STRING_LITERAL);

    // if this is start of <tell compound> or <tell simple> or <using terms from> statements, push the application name
    // which dictionary will be consulted for terms parsing (only the last pushed application is queried)
    if (r && applicationNameString != null) {
      applicationNameString = applicationNameString.replace("\"", "");
      if (!StringUtil.isEmptyOrSpaces(applicationNameString) && tellStatementStartCondition.parse(b, l + 1)) {
        pushTargetApplicationName(b, applicationNameString);
      }
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /**
   * @return true if this is the application reference of a &lt;tell&gt; or &lt;using terms
   * from&gt; statements
   */
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

  private static boolean isInTellStatement(PsiBuilder b, int l) {
    return (b.getUserData(PARSING_TELL_SIMPLE_STATEMENT) == Boolean.TRUE && nextTokenIs(b, TO))
            || (b.getUserData(PARSING_TELL_COMPOUND_STATEMENT) == Boolean.TRUE
            && b.getUserData(PARSING_TELL_SIMPLE_STATEMENT) == Boolean.FALSE)
            || b.getUserData(IS_PARSING_USING_TERMS_FROM_STATEMENT) == Boolean.TRUE;
  }

  private static Stack<String> pushTargetApplicationName(PsiBuilder b, @NotNull String applicationNameString) {
    Stack<String> dictionaryNameStack = b.getUserData(TOLD_APPLICATION_NAME_STACK);
    if (dictionaryNameStack == null) {
      dictionaryNameStack = new Stack<>();
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
      boolean givenForm = consumeToken(b, GIVEN);
      for (int i = 0; i < commandDefinition.getParameters().size() && !nextTokenIs(b, "", COMMENT, NLS) && r; i++) {
        r = parseParameterForCommand(b, l + 1, commandDefinition, parsedParameterSelector, givenForm, i == 0);
        mandatoryParams.remove(commandDefinition.getParameterByName(parsedParameterSelector.value));
        parsedParameterSelector.value = "";
      }
    } else {
      boolean givenForm = consumeToken(b, GIVEN);
      for (int i = 0; i < commandDefinition.getParameters().size() && !nextTokenIs(b, "", COMMENT, NLS) && r; i++) {
        r = parseParameterForCommand(b, l + 1, commandDefinition, parsedParameterSelector, givenForm, i == 0);
        parsedParameterSelector.value = "";
      }
    }
    r = mandatoryParams.isEmpty();//we only need to ensure that all mandatory params were specified
    r = true;
    exit_section_(b, l, m, null, r, false, null);

    return r;
  }

  // (given? commandParameterSelector parameterValue)
  // | ( (with|without) commandParameterSelector )
  private static boolean parseParameterForCommand(PsiBuilder b, int l, AppleScriptCommand command,
                                                  StringHolder parsedParameterSelector, boolean givenForm, boolean
                                                          first) {
    if (!recursion_guard_(b, l, "parseParameterForCommand")) return false;
    boolean r;
    PsiBuilder.Marker m = enter_section_(b, l, _NONE_, "<parse Parameter For Command>");//todo check here if it works
    r = parseGivenParameter(b, l + 1, command, parsedParameterSelector, givenForm, first);
    //todo and here exit and enter once again if it is true??
    if (!r) r = parseBooleanParameter(b, l + 1, command, parsedParameterSelector);

    exit_section_(b, l, m, COMMAND_PARAMETER, r, false, null);
    return r;
  }

  //(with|without) parameterSelector
  private static boolean parseBooleanParameter(PsiBuilder b, int l, AppleScriptCommand command, StringHolder
          parsedParameterSelector) {
    if (!recursion_guard_(b, l, "parseBooleanParameter")) return false;
    boolean r;
    //need to rollback with/without if there is no match
    PsiBuilder.Marker m = enter_section_(b, l, _NONE_, "<parse Boolean Parameter>");
    b.putUserData(PARSING_COMMAND_HANDLER_BOOLEAN_PARAMETER, true);
    r = consumeToken(b, WITH);
    if (!r) r = consumeToken(b, WITHOUT);
    if (!r) r = consumeToken(b, LAND); //for cases like: '...with regexp and all occurrences without case sensitive'
    r = r && parseCommandParameterSelector(b, l + 1, command, parsedParameterSelector);
    exit_section_(b, l, m, null, r, false, null);
    b.putUserData(PARSING_COMMAND_HANDLER_BOOLEAN_PARAMETER, false);
    return r;
  }

  // TODO: 08/12/15 the correct syntax is: (given paramSelector:paramValue (,paramSelector:paramValue)*) |
  // (paramSelector paramValue)
  //given? commandParameterSelector parameterValue
  private static boolean parseGivenParameter(PsiBuilder b, int l, AppleScriptCommand command,
                                             StringHolder parsedParameterSelector, boolean givenForm, boolean first) {
    if (!recursion_guard_(b, l, "parseGivenParameter")) return false;
    PsiBuilder.Marker m = enter_section_(b, l, _NONE_, "<parse Given Parameter>");
    boolean r = !givenForm || first || consumeToken(b, COMMA);//if it is a given form and not the first parameter ->
    // should be comma
    r = r && parseCommandParameterSelector(b, l + 1, command, parsedParameterSelector);
    final CommandParameter parameterDefinition = command.getParameterByName(parsedParameterSelector.value);
    //todo: parameter value expression could be incorrectly parsed and needed to be rolled backed (__AND__ modifier?)
    //as in example: mount volume "" in AppleTalk zone ""  (in - parsed as range ref form)
    if (givenForm) r = consumeToken(b, COLON);
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
//    String parameterTypeSpecifier = parameter.getTypeSpecifier();
    // if we are inside tell compound statement=> direct parameter is optional
    // so it may be wrongly detected instead of parameter selector. So, checking if it is a parameter selector first
    boolean isTellCompound = b.getUserData(PARSING_TELL_COMPOUND_STATEMENT) == Boolean.TRUE;
    if (isTellCompound || parameter.isOptional()) {
      AppleScriptCommand myCmd = parameter.getCommand();
      for (String paramName : myCmd.getParameterNames()) {
        if (nextTokenIs(b, paramName)) return true;
      }
    }
    PsiBuilder.Marker m = enter_section_(b, l, _NONE_, "<parse Command Direct Parameter Value >");
    String parameterTypeSpecifier = parameter.getTypeSpecifier();
    if ("type".equals(parameterTypeSpecifier)) {
      r = typeSpecifier(b, l + 1);
    }
    // see https://bitbucket.org/adernov/applescript-internal/issues/23/coercion-expression-priority
//    else if ("text".equals(parameterTypeSpecifier)) {
//      r = AppleScriptParser.coercionExpressionWrapper(b, l + 1);
//      if (!r) r = AppleScriptParser.concatenationExpressionWrapper(b, l + 1);
//      if (!r) r = AppleScriptParser.stringLiteralExpression(b, l + 1);
//    }
    if (!r)
      r = com.intellij.plugin.applescript.lang.parser.AppleScriptParser.expression(b, l + 1);
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
  }

  public static boolean isPossessivePpronoun(PsiBuilder b, int l) {
    LighterASTNode prevNode = b.getLatestDoneMarker();
    return prevNode != null && prevNode.getTokenType() == BUILT_IN_CONSTANT_LITERAL_EXPRESSION
            && prevNode.toString().equalsIgnoreCase("its");
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
      r = tryToParseApplicationProperty(b, l + 1, ApplicationDictionary.COCOA_STANDARD_LIBRARY);
      if (r) return true;
    }
    return false;
  }

  /**
   * @param b                     {@link PsiBuilder}
   * @param l                     level deep
   * @param isPluralForm          if parsing plural form of a class name
   * @param checkForUseStatements parser rule for the check if there are use statements in the script
   * @return true in case rule matches, false otherwise
   */
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
    r = parseDictionaryClassName(b, l + 1, currentTokenText, isPluralForm, toldApplicationName, areThereUseStatements,
            applicationsToImportFrom);
    return r;
  }

  public static boolean parseCheckForUseStatements(PsiBuilder b, int l) {
    return recursion_guard_(b, l, "parseCheckForUseStatements")
            && b.getUserData(WAS_USE_STATEMENT_USED) == Boolean.TRUE;
  }

  /**
   * @param b {@link PsiBuilder}
   * @param l level deep
   * @return true if parsed token(s) is the property of the scripting additions library
   */
  private static boolean tryToParseStdProperty(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryToParseStdProperty")) return false;
    boolean r = false;
    PsiBuilder.Marker m = enter_section_(b);
    StringHolder currentTokenText = new StringHolder();
    currentTokenText.value = b.getTokenText() == null ? "" : b.getTokenText();
    boolean propertyWithPrefixExists = ParsableScriptSuiteRegistryHelper
            .isStdPropertyWithPrefixExist(currentTokenText.value);
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

  /**
   * @param b               {@link PsiBuilder}
   * @param l               level deep
   * @param applicationName name of the application
   * @return true if parsed token(s) is the property of the specified application
   */
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

  /**
   * @param b                        {@link PsiBuilder}
   * @param l                        Level deep
   * @param currentTokenText         Text string of the token being parsed
   * @param isPluralForm             Whether we are parsing class name in plural form
   * @param toldApplicationName      The name of the application (which is the target of all messages in current block)
   *                                 dictionary of which will be queried first of all when searching for class names
   * @param areThereUseStatements    Whether there are use statements used in the script, in which case standard library
   *                                 Should be specified explicitly
   * @param applicationsToImportFrom Set list of the applications (if specified) attached to script from use statements
   * @return true if class name parsed
   */
  private static boolean parseDictionaryClassName(PsiBuilder b, int l, StringHolder currentTokenText,
                                                  final boolean isPluralForm,
                                                  @NotNull String toldApplicationName,
                                                  final boolean areThereUseStatements,
                                                  final @Nullable Set<String> applicationsToImportFrom) {
    boolean r, propertyExists = false;
    PsiBuilder.Marker m = enter_section_(b);
    r = parseApplicationClassName(b, l + 1, currentTokenText, isPluralForm, toldApplicationName);
    if (r) {
      // grammar allows className and propertyName as primaryExpression, so we should match the longest token between
      // className or propertyName tokens. Here we check and return false if the property with the longer name exists,
      // as it will be parsed later
      currentTokenText.value += " " + b.getTokenText();
      propertyExists = ParsableScriptSuiteRegistryHelper
              .isPropertyWithPrefixExist(toldApplicationName, currentTokenText.value);
    }
    exit_section_(b, m, null, r && !propertyExists);
    if (propertyExists) return false;
    if (r) return true;
    if (areThereUseStatements) {
      // if there are <use> statements in script (with importing dictionary terms condition), checking dictionary for
      // each application
      if (applicationsToImportFrom != null && !applicationsToImportFrom.isEmpty()) {
        for (String appName : applicationsToImportFrom) {
          m = enter_section_(b);
          r = parseApplicationClassName(b, l + 1, currentTokenText, isPluralForm, appName);
          if (r) {
            // check here as well for the property with longer name
            currentTokenText.value += " " + b.getTokenText();
            propertyExists = ParsableScriptSuiteRegistryHelper
                    .isPropertyWithPrefixExist(appName, currentTokenText.value);
          }
          exit_section_(b, m, null, r && !propertyExists);
          if (propertyExists) return false;
          if (r) return true;
        }
      }
    } else {
      m = enter_section_(b);
      r = parseStdClassName(b, l + 1, currentTokenText, isPluralForm);
      exit_section_(b, m, null, r);
      if (r) return true;
    }
    // It looks like not always CocoaStandard classes(and other terms) could be presented in applications terminology,
    // so in this case we check CocoaStandard here
    m = enter_section_(b);
    r = parseApplicationClassName(b, l + 1, currentTokenText, isPluralForm,
            ApplicationDictionary.COCOA_STANDARD_LIBRARY);
    if (r) {
      // grammar allows className and propertyName as primaryExpression, so we should match the longest token between
      // className or propertyName tokens. Here we check and return false if the property with the longer name exists,
      // as it will be parsed later
      currentTokenText.value += " " + b.getTokenText();
      propertyExists = ParsableScriptSuiteRegistryHelper
              .isPropertyWithPrefixExist(toldApplicationName, currentTokenText.value);
    }
    exit_section_(b, m, null, r && !propertyExists);
    return !propertyExists && r;
  }

  /**
   * @param b                {@link PsiBuilder}
   * @param l                Level deep
   * @param currentTokenText Text string of the token being parsed
   * @param isPluralForm     Whether we are parsing class name in plural form
   * @return true if class name parsed
   */
  private static boolean parseStdClassName(PsiBuilder b, int l, StringHolder currentTokenText, boolean isPluralForm) {
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

  private static boolean parseApplicationClassName(PsiBuilder b, int l, StringHolder currentTokenText,
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

  public static boolean parseCommandParametersExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parseCommandParametersExpression")) return false;
    boolean r;
    b.putUserData(PARSING_COMMAND_HANDLER_CALL_PARAMETERS, true);
    r = AppleScriptParser.expression(b, l + 1);
    b.putUserData(PARSING_COMMAND_HANDLER_CALL_PARAMETERS, false);
    return r;
  }

  public static boolean parseDictionaryConstant(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parseDictionaryConstant")) return false;
    boolean r, propertyOrClassExists = false;
    String toldApplicationName = getTargetApplicationName(b);
    //TODO: to think how to better handle such situations?
    // (if there are too many constants defined -> lead to many incorrect parsing errors like
    // 'end' tell/repeat etc is not detected
    // dictionary constant could appear only if we are inside dictionary command call
    boolean insideExpression = (b.getUserData(PARSING_COMMAND_HANDLER_CALL_PARAMETERS) == Boolean.TRUE
            || b.getUserData(PARSING_COMMAND_ASSIGNMENT_STATEMENT) == Boolean.TRUE)
            || b.getUserData(PARSING_LITERAL_EXPRESSION) == Boolean.TRUE;
    if (!ApplicationDictionary.COCOA_STANDARD_LIBRARY.equals(toldApplicationName) && !insideExpression)//only inside 
      // tell statements?
      return false;

    final StringHolder currentTokenText = new StringHolder();
    currentTokenText.value = "";
    boolean areThereUseStatements = b.getUserData(WAS_USE_STATEMENT_USED) == Boolean.TRUE;
    Set<String> applicationsToImportFrom = null;
    if (areThereUseStatements) {
      applicationsToImportFrom = b.getUserData(USED_APPLICATION_NAMES);
    }
    r = tryToParseApplicationConstant(b, l + 1, toldApplicationName);
    if (r) return true;
    if (areThereUseStatements && insideExpression) {
      if (applicationsToImportFrom != null && !applicationsToImportFrom.isEmpty()) {
        for (String appName : applicationsToImportFrom) {
          r = tryToParseApplicationConstant(b, l + 1, appName);
          if (r) return true;
        }
      }
    } else {
      r = tryToParseStdConstant(b, l + 1);
      if (r) return true;
      r = tryToParseApplicationConstant(b, l + 1, ApplicationDictionary.COCOA_STANDARD_LIBRARY);
      if (r) return true;
    }
    return false;
  }

  private static boolean tryToParseStdConstant(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryToParseStdConstant")) return false;
    StringHolder currentTokenText = new StringHolder();
    currentTokenText.value = b.getTokenText() == null ? "" : b.getTokenText();
    boolean r = false, propertyOrClassExists = false, constantWithPrefixExists = ParsableScriptSuiteRegistryHelper
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
    if (r) {
      // grammar allows className and propertyName as primaryExpression, so we should match the longest token between
      // className or propertyName tokens. We check and return false if the property or class with the longer name
      // exists, as it will be parsed later
      currentTokenText.value += " " + b.getTokenText();
      propertyOrClassExists = ParsableScriptSuiteRegistryHelper
              .isStdPropertyWithPrefixExist(currentTokenText.value) ||
              ParsableScriptSuiteRegistryHelper
                      .isStdClassWithPrefixExist(currentTokenText.value);
    }
    r = r && !propertyOrClassExists;
    exit_section_(b, m, null, r);
    return r;
  }

  private static boolean tryToParseApplicationConstant(PsiBuilder b, int l, @NotNull String applicationName) {
    if (!recursion_guard_(b, l, "tryToParseApplicationConstant")) return false;
    StringHolder currentTokenText = new StringHolder();
    currentTokenText.value = b.getTokenText() == null ? "" : b.getTokenText();
    boolean r = false, propertyOrClassExists = false, constantWithPrefixExists = ParsableScriptSuiteRegistryHelper
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
    if (r) {
      // grammar allows className and propertyName as primaryExpression, so we should match the longest token between
      // className or propertyName tokens. We check and return false if the property or class with the longer name
      // exists, as it will be parsed later
      propertyOrClassExists = ParsableScriptSuiteRegistryHelper
              .isPropertyWithPrefixExist(applicationName, currentTokenText.value) ||
              ParsableScriptSuiteRegistryHelper
                      .isClassWithPrefixExist(applicationName, currentTokenText.value);
      if (propertyOrClassExists) {
        currentTokenText.value += " " + b.getTokenText();
        propertyOrClassExists = ParsableScriptSuiteRegistryHelper
                .isPropertyWithPrefixExist(applicationName, currentTokenText.value) ||
                ParsableScriptSuiteRegistryHelper
                        .isClassWithPrefixExist(applicationName, currentTokenText.value);
      }
    }
    r = r && !propertyOrClassExists;
    exit_section_(b, m, null, r);
    return r;
  }

}
