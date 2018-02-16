@SuppressWarnings
SYNTAXDEF aspt
FOR <http://jtl.univaq.it/aspt>
START TraceModel

OPTIONS {
	usePredefinedTokens = "false";
	defaultTokenName = "IDENTIFIER";
}

TOKENS {
	DEFINE IDENTIFIER $('A'..'Z' | 'a'..'z' | '-'| '_')('A'..'Z' | 'a'..'z' | '0'..'9' | '-'| '_' | '/' | '.' | '@' )*$;
	DEFINE WHITESPACE $(' ' | '\t' | '\f')$;
	DEFINE LINEBREAK $('\r\n' | '\r' | '\n')$;
	DEFINE INTEGER $('-')?('1'..'9')('0'..'9')*|'0'$;
	DEFINE FLOAT $('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ $;
	DEFINE SL_COMMENT $'//'(~('\n'|'\r'|'\uffff'))*$;
}

RULES {
	TraceModel ::= "trace_model(" ID['"','"'] "," MMS[] ")." (traceelements | tracelinks)* ;
	TraceNode ::= "trace_node(" metamodel[] "," id[INTEGER] "," idx['"','"'] "," type[] ").";
	TraceProp ::= "trace_prop(" metamodel[] "," id[INTEGER] "," idx['"','"'] "," idp[INTEGER] "," idpx['"','"'] "," type[] "," value['"','"'] ")." ;
	TraceEdge ::= "trace_edge(" metamodel[] "," id[INTEGER] "," idx['"','"'] "," type[] "," ids[INTEGER] "," idsx['"','"'] "," idt[INTEGER] "," idtx['"','"'] ").";
	TraceNbEdge ::= "trace_nb_edge(" metamodel[] "," id[INTEGER] "," idx['"','"'] "," type[] "," ids[INTEGER] "," idsx['"','"'] "," idt[INTEGER] "," idtx['"','"'] ").";
	TraceNbProp ::= "trace_nb_prop(" metamodel[] "," id[INTEGER] "," idx['"','"'] "," idp[INTEGER] "," idpx['"','"'] "," type[] "," value['"','"'] ")." ;
	TraceNbNode ::= "trace_nb_node(" metamodel[] "," id[INTEGER] "," idx['"','"'] "," type[] ").";
	TraceLink ::= "trace_link(" metamodel[] "," id[INTEGER] "," idx['"','"'] "," type[] "," relation['"','"'] ").";
}