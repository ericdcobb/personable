grammar PersonableGrammar;

prog:   stat+ ;

stat:   expr NEWLINE?               # printExpr
    |   NEWLINE             # blank
    ;

expr: DEF ID 						# DefinePerson
	| REM ID  						# RemovePerson
	| BLAME ID 						# BlamePerson
	| KICK ID 						# KickPerson
	| HUG ID 						# HugPerson
	;

//people actions
DEF : 'define' ;
REM : 'remove' ;
BLAME: 'blame' ;
HUG: 'hug' ;


ID  :   [a-zA-Z]+ ;      // match identifiers
INT :   [0-9]+ ;         // match integers
NEWLINE:'\r'? '\n' ;     // return newlines to parser (is end-statement signal)
WS  :   [ \t]+ -> skip ; // toss out whitespace
LINE_COMMENT : '//' .*? '\r'? '\n' -> skip ; // Match "//" stuff '\n'