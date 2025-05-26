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