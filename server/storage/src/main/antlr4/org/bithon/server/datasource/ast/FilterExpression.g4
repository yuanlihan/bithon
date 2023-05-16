grammar FilterExpression;


parse
   : filterExpression EOF
   ;

filterExpression
  : binaryExpression
  | filterExpression logicOperator filterExpression
  | '(' filterExpression ')'
  ;

binaryExpression
  : unaryExpression comparisonOperator unaryExpression
  | unaryExpression 'in' experssionList
  ;

unaryExpression
  : nameExpression
  | literalExperssion
  ;

nameExpression
  : qualifiedNameExpression
  | simpleNameExpression
  ;

qualifiedNameExpression
  : VARIABLE ('.' VARIABLE)+
  ;

simpleNameExpression
  : VARIABLE
  ;

literalExperssion
  : STRING_LITERAL | NUMBER_LITERAL
  ;

experssionList
  : '(' unaryExpression (',' unaryExpression)* ')'
  ;

logicOperator
  : AND | OR
  ;

AND
  : [aA][nN][dD]
  ;

OR
  : [oO][rR]
  ;

comparisonOperator
    : '='
    | '>'
    | '<'
    | '<='
    | '>='
    | '<>'
    | '!='
    | 'like'
    ;

VARIABLE
  : [a-zA-Z_][a-zA-Z_0-9]*
  ;

NUMBER_LITERAL
 : [0-9]+('.'?[0-9]+)?
 ;

STRING_LITERAL
 : SQUOTA_STRING;

fragment SQUOTA_STRING
  : '\'' ('\\'. | '\'\'' | ~('\'' | '\\'))* '\'';

WS: [ \n\t\r]+ -> skip;
