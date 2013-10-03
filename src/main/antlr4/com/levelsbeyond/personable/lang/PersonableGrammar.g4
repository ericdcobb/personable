grammar PersonableGrammar;

prog:   stat+ ;

stat:   expr NEWLINE                # printExpr
    |   NEWLINE                     # blank
    ;

expr: DEF ID 						# DefinePerson
	;


DEF : 'define' ;
ID  :   [a-zA-Z]+ ;      // match identifiers
INT :   [0-9]+ ;         // match integers
NEWLINE:'\r'? '\n' ;     // return newlines to parser (is end-statement signal)
WS  :   [ \t]+ -> skip ; // toss out whitespace