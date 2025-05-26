grammar GrammarMinilang;
import CommonLexerRules;

prog:   stat+ ;

stat:   expr NEWLINE                # printExpr
    |   ID '=' expr NEWLINE         # assign
    |   ifStat                      # ifStatement
    |   whileStat                   # whileStatement
    |   NEWLINE                     # blank
    | LINE_COMMENT                  # comment
    | STRING NEWLINE                # printString
    | ID '=' STRING NEWLINE         # assignString
    ;


assignSt: left_expr ASSIGN expr; # assignSt

variable_decl
        : VAR ID (',' ID )* ':' type_basic # variable_decl
        ;


//reserved words
ASSIGN    : '=' ;
VAR       : 'var';