@SuppressWarnings(noRuleForMetaClass)
SYNTAXDEF asp
FOR <http://jtl.univaq.it/asp>
START Transformation

OPTIONS {
//	disableTokenSorting = "true";
	usePredefinedTokens = "false";
//	useClassicPrinter = "true";
	tokenspace = "0";
}

TOKENS {
	DEFINE COMMENT $'%'(~('\n'|'\r'|'\uffff'))*$;
	DEFINE TEXT $('A'..'Z'|'a'..'z'|'0'..'9'|'-'|'_'|'!'|':')+$;
	DEFINE LINEBREAK $('\r\n'|'\r'|'\n')$;
	DEFINE WHITESPACE $(' '|'\t'|'\f')$;
	DEFINE ELEMENT TEXT + $('(')$;
}

TOKENSTYLES {
	"COMMENT" COLOR #666666;
}

RULES {
	@SuppressWarnings(featureWithoutSyntax)
	Transformation ::= elements+ !0 relations+ !0 constraints*;
	
	@SuppressWarnings(featureWithoutSyntax)
	Relation ::= patterns !0 patterns : RightPattern !0;
//	Relation ::= patterns (!0 patterns)+;
	
	@SuppressWarnings(featureWithoutSyntax,explicitSyntaxChoice)
//	LeftPattern  ::= ("relation_node" | "relation_prop" | "relation_edge") element['(',')'] ".";
	LeftPattern  ::= type[node : "relation_node", prop : "relation_prop", edge : "relation_edge"] #0 element['(',')'] ".";
	@SuppressWarnings(featureWithoutSyntax,explicitSyntaxChoice)
//	RightPattern ::= ("relation_node" | "relation_prop" | "relation_edge") element['(',')'] ".";
	RightPattern ::= type[node : "relation_node", prop : "relation_prop", edge : "relation_edge"] #0 element['(',')'] ".";
	
	@SuppressWarnings(featureWithoutSyntax,minOccurenceMismatch)
	Metanode ::= "metanode(" literals[] "," #1 literals[] ")." !0;
	@SuppressWarnings(featureWithoutSyntax,minOccurenceMismatch)
	Metaprop ::= "metaprop(" literals[] "," #1 literals[] "," #1 literals[] ")." !0;
	@SuppressWarnings(featureWithoutSyntax,minOccurenceMismatch)
	Metaedge ::= "metaedge(" literals[] "," #1 literals[] "," #1 literals[] "," #1 literals[] ")." !0;

	@SuppressWarnings(featureWithoutSyntax,minOccurenceMismatch,explicitSyntaxChoice)
//	Node ::= "node(" literals[] "," #1 literals[] "," #1 literals[] ")." !0;
//	Node ::= ("node(" | "nodex(") literals[] "," #1 literals[] "," #1 literals[] ")." !0;
	Node ::= isNodex["nodex(" : "node("] literals[] "," #1 literals[] "," #1 literals[] ")." !0;
	@SuppressWarnings(featureWithoutSyntax,minOccurenceMismatch,explicitSyntaxChoice)
//	Prop ::= ("prop(" | "propx(") literals[] "," #1 literals[] "," #1 literals[] "," #1 literals[] ")." !0;
	Prop ::= isPropx["propx(" : "prop("] literals[] "," #1 literals[] "," #1 literals[] "," #1 literals[] ")." !0;
	@SuppressWarnings(featureWithoutSyntax,minOccurenceMismatch,explicitSyntaxChoice)
//	Edge ::= ("edge(" | "edgex(") literals[] "," #1 literals[] "," #1 literals[] "," #1 literals[] "," #1 literals[] ")." !0;
	Edge ::= isEdgex["edgex(" : "edge("] literals[] "," #1 literals[] "," #1 literals[] "," #1 literals[] "," #1 literals[] ")." !0;

	@SuppressWarnings(featureWithoutSyntax)
	Constraint ::= (comment[] !0)? ":-" #1 expressions ("," #1 expressions)* #0 "." !0;

	@SuppressWarnings(featureWithoutSyntax,optionalKeyword)
	Literal ::= name[] (#0 ".")? !0;

	@SuppressWarnings(featureWithoutSyntax)
	Terminal ::= element[];

	@SuppressWarnings(featureWithoutSyntax)
	Not ::= "not" #1 element[];
	
	@SuppressWarnings(featureWithoutSyntax)
	Eq ::= left[] #1 "==" #1 right[];

	@SuppressWarnings(featureWithoutSyntax)
	NotEq ::= left[] #1 "!=" #1 right[];

//	And ::= "And" "{" ("name" ":" name['"','"'] | "transformation" ":" transformation[] | "right" ":" right | "left" ":" left)* "}";
//	@SuppressWarnings(featureWithoutSyntax)
//	And ::= left "and" right;
}