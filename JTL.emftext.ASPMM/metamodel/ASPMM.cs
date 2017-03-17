SYNTAXDEF aspmm
FOR <http://jtl.univaq.it/aspmm>
START Metamodel

OPTIONS {
	reloadGeneratorModel = "true";
}

RULES {

	Metamodel ::= "metamodel" "(" name[] ")" "." !0 metanodes* metaprops* metaedges*;
	
	Metanode ::= "metanode" "(" metamodel[] "," name[] ")" "." !0;
	
	Metaprop ::= "metaprop" "(" metamodel[] "," name[] "," metanode[] ")" "." !0;
	
	Metaedge ::= "metaedge" "(" metamodel[] "," 
	                            type[association: "association", generalization:  "generalization", composition: "composition"] "," 
	                            name[] "," source[] "," target[] ")" "." !0;

	//MetaedgeType ::=  "association" | "generalization" | "composition" ; 
	
	// syntax definition for class 'StartMetaClass'
	//StartMetaClass   ::= "myKeyword" attributeOfStartMetaClass[] aContainmentReference* ;
	
	// syntax definition for class 'AnotherMetaClass'
	//AnotherMetaClass ::= "otherKeyword" aNonContainmentReference[];
}
