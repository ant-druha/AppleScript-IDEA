package com.idea.plugin.applescript.lang.lexer;
import com.intellij.lexer.*;
import com.intellij.psi.tree.IElementType;
import static com.idea.plugin.applescript.psi.AppleScriptTypes.*;

%%

%{
  public _AppleScriptLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _AppleScriptLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

ONE_NL=(\r|\n|\r\n)
CC="¬"
WHITE_SPACE_CHAR=[\ \t\f]
WHITE_SPACE={WHITE_SPACE_CHAR}|{CC}({WHITE_SPACE_CHAR})*({ONE_NL})?//|{CC}
NLS={ONE_NL}({ONE_NL}|{WHITE_SPACE})*

STARTS_BEGINS_WITH=("start""s with"|"start with"|"begin""s with"|"begin with")
ENDS_WITH=("end""s with"|"end with")
DOES_NOT_CONTAIN=("does not contain"|"doesn't contain")
IS_IN=("is in"|"is contained by")
IS_NOT_IN=("is not in"|"is not contained by"|"isn't contained by")
IS_CONTAIN=("contain"|"contains")

//todo duplicate variants with and without to/is parts otherwise it is not parsed correctly
GT=(">"|"is greater than"|"greater than"|"comes after"|"is not less than or equal to"|"is not less than or equal"|"isn't less than or equal to"|"isn't less than or equal")
LE=("?"|"<="|"is less than or equal to"|"less than or equal to"|"is less than or equal"|"less than or equal"|"is not greater than"|"isn't greater than"|"does not come after"|"doesn't come after")
GE=("?"|">="|"is greater than or equal to"|"greater than or equal to"|"is greater than or equal"|"greater than or equal"|"is not less than"|"isn't less than"|"does not come before"|"doesn't come before")
LT=("<"|"is less than"|"less than"|"comes before"|"is not greater than or equal to"|"is not greater than or equal"|"isn't greater than or equal to"|"isn't greater than or equal")
NE=("isn't equal to"|"isn't equal"|"is not equal to"|"is not equal"|"doesn't equal"|"does not equal"|"is not"|"isn't")
EQ=("="|"is equal to"|"equal to"|"is"|"equal"|"equals")
REF_OP=("a reference to"|"a ref to"|"a ref"|"reference to"|"ref")

DIV=("/"|"?")
BUILT_IN_TYPE=("string"|"integer"|"real"|"boolean"|"class"|"constant"|"list"|"record"|"data"|"date"|"number"|"reference"|"styled text"|"text")
APP_RESPONSES=("application responses"|"app responses")
C_WHITE_SPACE=("white space")
STRING_LITERAL=\"([^\"\\]|\\.)*\"
DIGITS=[0-9]+
DEC_EXPONENT=[Ee][+-]?[_0-9]*
VAR_IDENTIFIER=([a-zA-Z][a-zA-Z0-9_]*)|(\|(([^\|])|(\\\|))*[^\\]\|)
COMMENT=(("#".*)|("--".*)|(("(*"[^"*"](([^"*"]*("*"+[^"*"")"])?)*("*"+")")?))|"(*"))
RAW_CODE=("<<"[^">>"]*">>")

%%
<YYINITIAL> {
  {WHITE_SPACE}               { return com.intellij.psi.TokenType.WHITE_SPACE; }

  "("                         { return LPAREN; }
  ")"                         { return RPAREN; }
  "+"                         { return PLUS; }
  "-"                         { return MINUS; }
  "*"                         { return STAR; }
  "div"                       { return INT_DIV; }
  "mod"                       { return MOD; }
  "^"                         { return POW; }
  "or"                        { return LOR; }
  "and"                       { return LAND; }
  "&"                         { return BAND; }
  "not"                       { return LNOT; }
  "as"                        { return AS; }
  "'s"                        { return APS; }
  "the"                       { return THE_KW; }
  "does"                      { return DOES; }
  "apart from"                { return APART_FROM; }
  "aside from"                { return ASIDE_FROM; }
  "out of"                    { return OUT_OF; }
  "instead of"                { return INSTEAD_OF; }
  "that"                      { return THAT; }
  "reference"                 { return REFERENCE; }
  "scripting additions"       { return SCRIPTING_ADDITIONS; }
  "current date"              { return CURRENT_DATE; }
  "text item delimiters"      { return TEXT_ITEM_DELIMETERS; }
  "missing value"             { return MISSING_VALUE; }
  "pi"                        { return PI_CONSTANT; }
  "minutes"                   { return MINUTES_CONSTANT; }
  "hours"                     { return HOURS_CONSTANT; }
  "days"                      { return DAYS_CONSTANT; }
  "weeks"                     { return WEEKS_CONSTANT; }
  "(*"                        { return MULTI_LINE_COMMENT_START; }
  "*)"                        { return MULTI_LINE_COMMENT_END; }
  ","                         { return COMMA; }
  "{"                         { return LCURLY; }
  "}"                         { return RCURLY; }
  ":"                         { return COLON; }
  "return"                    { return RETURN; }
  "exit"                      { return EXIT; }
  "repeat"                    { return REPEAT; }
  "end"                       { return END; }
  "times"                     { return TIMES; }
  "while"                     { return WHILE; }
  "until"                     { return UNTIL; }
  "with"                      { return WITH; }
  "from"                      { return FROM; }
  "to"                        { return TO; }
  "by"                        { return BY; }
  "in"                        { return IN; }
  "considering"               { return CONSIDERING; }
  "ignoring"                  { return IGNORING; }
  "tell"                      { return TELL; }
  "error"                     { return ERROR; }
  "try"                       { return TRY; }
  "using"                     { return USING; }
  "terms"                     { return TERMS; }
  "number"                    { return NUMBER; }
  "partial"                   { return PARTIAL; }
  "result"                    { return RESULT; }
  "on"                        { return ON; }
  "application"               { return APPLICATION; }
  "app"                       { return APP; }
  "but"                       { return BUT; }
  "case"                      { return CASE; }
  "diacriticals"              { return DIACRITICALS; }
  "expansion"                 { return EXPANSION; }
  "hyphens"                   { return HYPHENS; }
  "punctuation"               { return PUNCTUATION; }
  "timeout"                   { return TIMEOUT; }
  "of"                        { return OF; }
  "seconds"                   { return SECONDS; }
  "second"                    { return SECOND; }
  "transaction"               { return TRANSACTION; }
  "use"                       { return USE; }
  "version"                   { return VERSION; }
  "importing"                 { return IMPORTING; }
  "without"                   { return WITHOUT; }
  "script"                    { return SCRIPT; }
  "framework"                 { return FRAMEWORK; }
  "if"                        { return IF; }
  "then"                      { return THEN; }
  "else"                      { return ELSE; }
  "date"                      { return DATE; }
  "true"                      { return TRUE; }
  "false"                     { return FALSE; }
  "machine"                   { return MACHINE; }
  "zone"                      { return ZONE; }
  "file"                      { return FILE; }
  "alias"                     { return ALIAS; }
  "my"                        { return MY; }
  "some"                      { return SOME; }
  "every"                     { return EVERY; }
  "whose"                     { return WHOSE; }
  "where"                     { return WHERE; }
  "given"                     { return GIVEN; }
  "index"                     { return INDEX; }
  "first"                     { return FIRST; }
  "third"                     { return THIRD; }
  "fourth"                    { return FOURTH; }
  "fifth"                     { return FIFTH; }
  "sixth"                     { return SIXTH; }
  "seventh"                   { return SEVENTH; }
  "eighth"                    { return EIGHTH; }
  "ninth"                     { return NINTH; }
  "tenth"                     { return TENTH; }
  "last"                      { return LAST; }
  "front"                     { return FRONT; }
  "back"                      { return BACK; }
  "middle"                    { return MIDDLE; }
  "named"                     { return NAMED; }
  "thru"                      { return THRU; }
  "through"                   { return THROUGH; }
  "beginning"                 { return BEGINNING; }
  "before"                    { return BEFORE; }
  "after"                     { return AFTER; }
  "behind"                    { return BEHIND; }
  "property"                  { return PROPERTY; }
  "prop"                      { return PROP; }
  "global"                    { return GLOBAL; }
  "local"                     { return LOCAL; }
  "current"                   { return CURRENT; }
  "anything"                  { return ANYTHING; }
  "parent"                    { return PARENT; }
  "yes"                       { return YES; }
  "no"                        { return NO; }
  "ask"                       { return ASK; }
  "ref"                       { return REF; }
  "close"                     { return CLOSE; }
  "launch"                    { return LAUNCH; }
  "space"                     { return SPACE; }
  "tab"                       { return TAB; }
  "linefeed"                  { return LINEFEED; }
  "quote"                     { return QUOTE; }
  "it"                        { return IT; }
  "me"                        { return ME; }
  "about"                     { return ABOUT; }
  "above"                     { return ABOVE; }
  "against"                   { return AGAINST; }
  "around"                    { return AROUND; }
  "at"                        { return AT; }
  "below"                     { return BELOW; }
  "beneath"                   { return BENEATH; }
  "beside"                    { return BESIDE; }
  "between"                   { return BETWEEN; }
  "for"                       { return FOR; }
  "into"                      { return INTO; }
  "onto"                      { return ONTO; }
  "over"                      { return OVER; }
  "since"                     { return SINCE; }
  "under"                     { return UNDER; }
  "continue"                  { return CONTINUE; }
  "copy"                      { return COPY; }
  "put"                       { return PUT; }
  "count"                     { return COUNT; }
  "each"                      { return EACH; }
  "get"                       { return GET; }
  "run"                       { return RUN; }
  "set"                       { return SET; }
  "returning"                 { return RETURNING; }

  {NLS}                       { return NLS; }
  {STARTS_BEGINS_WITH}        { return STARTS_BEGINS_WITH; }
  {ENDS_WITH}                 { return ENDS_WITH; }
  {DOES_NOT_CONTAIN}          { return DOES_NOT_CONTAIN; }
  {IS_IN}                     { return IS_IN; }
  {IS_NOT_IN}                 { return IS_NOT_IN; }
  {IS_CONTAIN}                { return IS_CONTAIN; }
  {GT}                        { return GT; }
  {LE}                        { return LE; }
  {GE}                        { return GE; }
  {LT}                        { return LT; }
  {NE}                        { return NE; }
  {EQ}                        { return EQ; }
  {REF_OP}                    { return REF_OP; }
  {DIV}                       { return DIV; }
  {BUILT_IN_TYPE}             { return BUILT_IN_TYPE; }
  {C_WHITE_SPACE}             { return C_WHITE_SPACE; }
  {APP_RESPONSES}             { return APP_RESPONSES; }
  {STRING_LITERAL}            { return STRING_LITERAL; }
  {DIGITS}                    { return DIGITS; }
  {DEC_EXPONENT}              { return DEC_EXPONENT; }
  {VAR_IDENTIFIER}            { return VAR_IDENTIFIER; }
  {COMMENT}                   { return COMMENT; }
  {RAW_CODE}                  { return RAW_CODE; }

  [^] { return com.intellij.psi.TokenType.BAD_CHARACTER; }
}
