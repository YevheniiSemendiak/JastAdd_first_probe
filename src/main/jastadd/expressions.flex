package de.tudresden.inf.st.most.jastadd.scanner;

import de.tudresden.inf.st.most.jastadd.parser.ExpressionParser.Terminals;

%%

// define the signature for the generated scanner
%public
%final
%class ExpressionScanner
%extends beaver.Scanner

// the interface between the scanner and the parser is the nextToken() method
%type beaver.Symbol
%function nextToken
%yylexthrow beaver.Scanner.Exception

// store line and column information in the tokens
%line
%column

// this code will be inlined in the body of the generated scanner class
%{
  private beaver.Symbol sym(short id) {
    return new beaver.Symbol(id, yyline + 1, yycolumn + 1, yylength(), yytext());
  }
%}

WhiteSpace = [ ] | \t | \f
NewLine    = \n | \r | \r\n
Identifier = [:jletter:][:jletterdigit:]*


Number = [:digit:]+ | [:digit:]+ "." [:digit:]* | "." [:digit:]+


%%

// discard whitespace information
{WhiteSpace}  { }

// token definitions
"="           { return sym(Terminals.EQUALS); }
"+"           { return sym(Terminals.PLUS); }
"*"           { return sym(Terminals.MULT); }
"/"           { return sym(Terminals.DIV); }
"-"           { return sym(Terminals.MINUS); }
"("           { return sym(Terminals.LP); }
")"           { return sym(Terminals.RP); }
{NewLine}     { return sym(Terminals.NEWLINE); }
{Identifier}  { return sym(Terminals.IDENTIFIER); }
{Number}      { return sym(Terminals.NUMBER); }
<<EOF>>       { return sym(Terminals.EOF); }