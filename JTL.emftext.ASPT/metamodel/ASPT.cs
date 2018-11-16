@SuppressWarnings
SYNTAXDEF aspt
FOR <http://jtl.univaq.it/aspt>
START TraceModel

OPTIONS {
	reloadGeneratorModel = "true";
	usePredefinedTokens = "false";
}

TOKENS {
	DEFINE TEXT $('A'..'Z'|'a'..'z'|'0'..'9'|'-'|'_'|'/'|'@'|'.'|':')+$;
	DEFINE LINEBREAK $('\r\n'|'\r'|'\n')$;
	DEFINE WHITESPACE $(' '|'\t'|'\f')$;
}

RULES {
	TraceModel ::= "trace_model" "(" ID['"','"','\\'] "," MMS[] ")" "." !0 (traceelements | tracelinks)* ;
	TraceNode ::= "trace_node" "(" metamodel[] "," id[] "," idx['"','"','\\'] "," type[] ")" "." !0;
	TraceProp ::= "trace_prop" "(" metamodel[] "," id[] "," idx['"','"','\\'] "," idp[] "," idpx['"','"','\\'] "," type[] "," value['"','"','\\'] ")" "." !0;
	TraceEdge ::= "trace_edge" "(" metamodel[] "," id[] "," idx['"','"','\\'] "," type[] "," ids[] "," idsx['"','"','\\'] "," idt[] "," idtx['"','"','\\'] ")" "." !0;
	TraceNbEdge ::= "trace_nb_edge" "(" metamodel[] "," id[] "," idx['"','"','\\'] "," type[] "," ids[] "," idsx['"','"','\\'] "," idt[] "," idtx['"','"','\\'] ")" "." !0;
	TraceNbProp ::= "trace_nb_prop" "(" metamodel[] "," id[] "," idx['"','"','\\'] "," idp[] "," idpx['"','"','\\'] "," type[] "," value['"','"','\\'] ")" "." !0;
	TraceNbNode ::= "trace_nb_node" "(" metamodel[] "," id[] "," idx['"','"','\\'] "," type[] ")" "." !0;
	TraceLink ::= "trace_link" "(" metamodel[] "," id[] "," idx['"','"','\\'] "," idref[] "," idrefx['"','"','\\'] "," type[] "," relation['"','"','\\'] ")" "." !0;
}