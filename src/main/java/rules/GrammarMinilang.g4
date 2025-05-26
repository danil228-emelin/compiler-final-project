grammar GrammarMinilang;
import CommonLexerRules;

prog:   stat+ ;

stat:   assignSt NEWLINE            # assign
    |   ifStat                      # ifStatement
    |   whileStat                   # whileStatement
    |   NEWLINE                     # blank
    | LINE_COMMENT                  # comment
    | COMMENT                       # multipleComment
    | variable_decl NEWLINE         # declaration
    | printing NEWLINE              # printSmth
    ;

whileStat:  'while' expr block ;

ifStat: IF expr THEN block ('else' block)? ;

block: '{' stat* '}'                # multiple_logic_block
        | stat                      # single_logic_block
        ;

assignSt: left_expr ASSIGN expr; # assignSt

expr: expr op=(MUL|DIV) expr         # mulDiv
    |   expr op=(ADD|SUB) expr         # addSub
    |   expr op=(LT|GT|LE|GE) expr # relational
    |   expr op=(EQ|NE) expr    # equality
    |   '(' expr ')'                # parens
    |   op=INT                      # value
    |   op=STRING                   # value
    |   ID                          # id
    ;


variable_decl
        : VAR ID (',' ID )* ':' type_basic # variable_decl
        ;

printing: PRINT expr NEWLINE # printExpr
    |  PRINT STRING NEWLINE # printString

//reserved words
IF: 'if';
THEN: 'then';
ASSIGN: '=' ;
VAR: 'var';
PRINT: 'print';
MUL : '*' ;
DIV : '/' ;
ADD : '+' ;
SUB : '-' ;
NOT : '!' ;
AND : '&&' ;
OR  : '||' ;
GT  : '>' ;
LT  : '<' ;
GE  : '>=' ;
LE  : '<=' ;
EQ  : '==' ;
NE  : '!=' ;