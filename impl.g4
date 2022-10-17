grammar impl;

start :'.hardware ' nm=SIGNAL
         '.inputs ' in+=SIGNAL+
         '.outputs' out+=SIGNAL+
          ('.latch ' lt+=latches)+
          '.update' sig+=assignment*
            '.simulate' inp+=inpseq*
            EOF
            ;

assignment : x=SIGNAL op='=' e=expr ;

latches: in=SIGNAL '->' out=SIGNAL;


expr : 	'!' e1=expr			# BoolNot
            	| e1=expr op='&&' e2=expr # BoolAnd
            	| e1=expr op='||' e2=expr # BoolOr
		| '(' e1=expr ')'	  # Parentheses
            	| e1=SIGNAL		 # Sig

            	;

inpseq      : e1=SIGNAL '=' e2=('0'|'1')+;
SIGNAL : [a-zA-Z] [a-zA-Z0-9_]*;


HVIDRUM : [ \t\n]+ -> skip ;
KOMMENTAR : '//' ~[\n]* -> skip ;
MULTILINECOMMENTS :  '/*'  ( '*'~[/] | ~[*]  )* '*/' -> skip;

