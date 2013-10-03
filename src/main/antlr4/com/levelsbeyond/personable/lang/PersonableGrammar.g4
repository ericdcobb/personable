grammar PersonableGrammar;

prog:   stat+ ;

stat:   expr NEWLINE?               # printExpr
    |   NEWLINE             # blank
    ;

expr: DEF ID 						# DefinePerson
	| REM ID  						# RemovePerson
	;


DEF : 'define' ;
REM : 'remove' ;
ID  :   [a-zA-Z]+ ;      // match identifiers
INT :   [0-9]+ ;         // match integers
NEWLINE:'\r'? '\n' ;     // return newlines to parser (is end-statement signal)
WS  :   [ \t]+ -> skip ; // toss out whitespace
LINE_COMMENT : '//' .*? '\r'? '\n' -> skip ; // Match "//" stuff '\n'