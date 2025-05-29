lexer grammar CommonLexerRules;

LINE_COMMENT : ':>' .*? '\r'? '\n' -> skip ;
COMMENT : '/*' .*? '*/' -> skip ; // Match "/*" stuff "*/"
VAR: 'var';
MIN: 'min';
COND_WHILE: '__cond';
IF: 'if';
THEN: 'then';
ELSE: 'else';
WHILE: 'while';
ASSIGN: '=' ;
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
INT_TYPE : 'int';
STRING_TYPE : 'string';
NEWLINE:'\r'? '\n' ;   // return newlines to parser (end-statement signal)
WS  :   [ \t]+ -> skip ; // toss out whitespace
STRING: '"' (ESC|.)*? '"' ;
ESC : '\\"' | '\\\\' ; // 2-char sequences \" and \\
ID : ('a'..'z'|'A'..'Z'|'_')('a'..'z'|'A'..'Z'|'_'|'0'..'9')* ;
INT : '-'?[0-9]+ ; // match integers
type_basic
        : INT_TYPE
        | STRING_TYPE
        ;

left_expr
        : ID
        ;