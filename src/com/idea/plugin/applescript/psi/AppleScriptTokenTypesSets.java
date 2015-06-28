package com.idea.plugin.applescript.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;

import static com.idea.plugin.applescript.psi.AppleScriptTypes.*;

public interface AppleScriptTokenTypesSets {


  TokenSet OPERATORS = TokenSet.create(PLUS, MINUS, MOD, POW, BAND, LNOT, DIV, INT_DIV, STAR, INT_DIV, EQ, NE, IS_IN,
          IS_CONTAIN, IS_NOT_IN,
          LE, GE, GT, LT, LCURLY, RCURLY, AS);

  TokenSet NUMBERS = TokenSet.create(DIGITS, DEC_EXPONENT);

  TokenSet KEYWORDS = TokenSet.create(ABOUT, ABOVE, AFTER, AGAINST, LAND, APART_FROM, AROUND, AS, ASIDE_FROM, AT,
          BACK, BEFORE, BEGINNING,
          BEHIND, BELOW, BENEATH, BESIDE, BETWEEN, BUT, BY, CONSIDERING, CONTINUE, COPY, DIV, DOES, DOES_NOT_CONTAIN,
          EIGHTH, ELSE, END,
            /*EQUAL,EQUALS,*/
          ERROR, EVERY, EXIT, FALSE, FIFTH, FIRST, FOR, FOURTH, FROM, FRONT, GET, GIVEN, GLOBAL, IF, IGNORING, IN,
          INSTEAD_OF, INTO, IT,
            /*ITS,*/ LAST, LOCAL, ME, MIDDLE, MOD, MY, NINTH, LNOT, OF, ON, ONTO, LOR, OUT_OF, OVER, PROP, PROPERTY,
            /*PUT,*/ REF, REFERENCE,
          REPEAT, RETURN, RETURNING, SCRIPT, SECOND, SET, SEVENTH, SINCE, SIXTH, SOME, TELL, TENTH, THAT, THE_KW,
          THEN, THIRD, THROUGH,
          THRU, TIMEOUT, TIMES, TO, TRANSACTION, TRUE, TRY, UNTIL, WHERE, WHILE, WHOSE, WITH, WITHOUT);

  TokenSet HANDLER_PARAMETER_LABELS = TokenSet.create(ABOUT, ABOVE, AGAINST, APART_FROM, AROUND, ASIDE_FROM, AT,
          BELOW, BENEATH, BESIDE,
          BETWEEN, BY, FOR, FROM, INSTEAD_OF, INTO, ON, ONTO, OUT_OF, OVER, SINCE, THRU, THROUGH, UNDER, TO);

  TokenSet HANDLER_DEFINITIONS = TokenSet.create(HANDLER_POSITIONAL_PARAMETERS_DEFINITION,
          HANDLER_INTERLEAVED_PARAMETERS_DEFINITION,
          HANDLER_LABELED_PARAMETERS_DEFINITION
//            HANDLER_IDLE_DEFINITION, HANDLER_OPEN_DEFINITION, HANDLER_QUIT_DEFINITION, HANDLER_RUN_DEFINITION
  );
//    about|above|against|'apart from'|around|'aside from'|at|below|beneath|beside|between   // spaces ??
//    |by|for|from|'instead of'|into|on|onto|'out of'|over|since|thru|through|under
//    |to //no such label in documentation but it works!

//    about,above,after,against,and,apart from,around,as,aside  from,at,back,before,beginning,behind,below,beneath,
// beside,between,but,by,
// considering,contain,contains,
//    contains,continue,copy,div,does,eighth,else,end,equal,equals,error,every,exit,false,fifth,first,for,
//    fourth,from,front,get,given,global,if,ignoring,in,instead of,into,is,it,its,last,local,me,middle,mod,
//    my,ninth,not,of,on,onto,or,out of,over,prop,property,put,ref,reference,repeat,return,returning,script,second,
// set,seventh,since,
//    sixth,some,tell,tenth,that,the,then,third,through,thru,timeout,times,to,transaction,true,try,until,where,while,
// whose,with,without

  TokenSet STRINGS = TokenSet.create(STRING_LITERAL);
  TokenSet WHITE_SPACES_SET = TokenSet.create(NLS, com.intellij.psi.TokenType.WHITE_SPACE);
  TokenSet COMMENT_OR_WHITE_SPACE = TokenSet.create(NLS, com.intellij.psi.TokenType.WHITE_SPACE, COMMENT);
  IElementType DICTIONARY_COMMAND = new AppleScriptTokenType("DICTIONARY_COMMAND");
}
