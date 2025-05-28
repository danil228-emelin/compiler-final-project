grammar GrammarMinilang;
import CommonLexerRules;

prog:   stat+ ;

stat:   assignSt NEWLINE?            # assign
    |   ifStat                      # ifStatement
    |   whileStat                   # whileStatement
    |   NEWLINE                     # blank
    | LINE_COMMENT                  # comment
    | COMMENT                       # multipleComment
    | variable_decl NEWLINE?         # declaration
    | printing NEWLINE?              # printSmth
    | expr NEWLINE?                  #expr_action
    ;

block: '{' stat+ '}'                # multiple_logic_block
        | stat                      # single_logic_block
        ;

whileStat:  WHILE expr block ;

ifStat: IF expr THEN  block (ELSE block) ? ;

assignSt: left_expr ASSIGN expr ;

expr: expr op=(MUL|DIV) expr         # mulDiv
    |   expr op=(ADD|SUB) expr         # addSub
    |   expr op=(LT|GT|LE|GE) expr # relational
    |   expr op=(EQ|NE) expr    # equality
    |   '(' expr ')'                # parens
    |   op=INT                      # value
    |   op=STRING                   # value
    |   ID                          # id
    |   op=MIN expr expr               # minValue
    |   op=NOT expr                    # logicalNot
    |   expr op=AND expr               # logicalAnd
    |   expr op=OR expr                # logicalOr
    ;


variable_decl
        : VAR ID (',' ID )* ':' type_basic # variable_decl_id
        ;

printing: PRINT expr NEWLINE # printExpr
    |  PRINT STRING NEWLINE # printString
    ;

