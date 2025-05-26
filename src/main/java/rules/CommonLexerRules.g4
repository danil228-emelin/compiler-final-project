lexer grammar CommonLexerRules;

LINE_COMMENT : ':>' .*? '\r'? '\n' -> skip ;

COMMENT : '/*' .*? '*/' -> skip ; // Match "/*" stuff "*/"

ID : ('a'..'z'|'A'..'Z'|'_')('a'..'z'|'A'..'Z'|'_'|'0'..'9')* ;

INT : '-'?[0-9]+ ; // match integers

NEWLINE:'\r'? '\n' ;   // return newlines to parser (end-statement signal)

WS  :   [ \t]+ -> skip ; // toss out whitespace

STRING: '"' (ESC|.)*? '"' ;

ESC : '\\"' | '\\\\' ; // 2-char sequences \" and \\

INT_TYPE : 'int';

STRING_TYPE : 'string';

type_basic
        : INT_TYPE
        | STRING_TYPE
        ;

left_expr
        : ID
        ;