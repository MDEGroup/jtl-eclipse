/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPMM.resource.aspmm.grammar;

public class AspmmGrammarInformationProvider {
	
	public final static org.eclipse.emf.ecore.EStructuralFeature ANONYMOUS_FEATURE = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEAttribute();
	static {
		ANONYMOUS_FEATURE.setName("_");
	}
	
	public final static AspmmGrammarInformationProvider INSTANCE = new AspmmGrammarInformationProvider();
	
	private java.util.Set<String> keywords;
	
	public final static ASPMM.resource.aspmm.grammar.AspmmKeyword ASPMM_0_0_0_0 = new ASPMM.resource.aspmm.grammar.AspmmKeyword("metamodel", ASPMM.resource.aspmm.grammar.AspmmCardinality.ONE);
	public final static ASPMM.resource.aspmm.grammar.AspmmKeyword ASPMM_0_0_0_1 = new ASPMM.resource.aspmm.grammar.AspmmKeyword("(", ASPMM.resource.aspmm.grammar.AspmmCardinality.ONE);
	public final static ASPMM.resource.aspmm.grammar.AspmmPlaceholder ASPMM_0_0_0_2 = new ASPMM.resource.aspmm.grammar.AspmmPlaceholder(ASPMM.ASPMMPackage.eINSTANCE.getMetamodel().getEStructuralFeature(ASPMM.ASPMMPackage.METAMODEL__NAME), "TEXT", ASPMM.resource.aspmm.grammar.AspmmCardinality.ONE, 0);
	public final static ASPMM.resource.aspmm.grammar.AspmmKeyword ASPMM_0_0_0_3 = new ASPMM.resource.aspmm.grammar.AspmmKeyword(")", ASPMM.resource.aspmm.grammar.AspmmCardinality.ONE);
	public final static ASPMM.resource.aspmm.grammar.AspmmKeyword ASPMM_0_0_0_4 = new ASPMM.resource.aspmm.grammar.AspmmKeyword(".", ASPMM.resource.aspmm.grammar.AspmmCardinality.ONE);
	public final static ASPMM.resource.aspmm.grammar.AspmmLineBreak ASPMM_0_0_0_5 = new ASPMM.resource.aspmm.grammar.AspmmLineBreak(ASPMM.resource.aspmm.grammar.AspmmCardinality.ONE, 0);
	public final static ASPMM.resource.aspmm.grammar.AspmmContainment ASPMM_0_0_0_6 = new ASPMM.resource.aspmm.grammar.AspmmContainment(ASPMM.ASPMMPackage.eINSTANCE.getMetamodel().getEStructuralFeature(ASPMM.ASPMMPackage.METAMODEL__METANODES), ASPMM.resource.aspmm.grammar.AspmmCardinality.STAR, new org.eclipse.emf.ecore.EClass[] {ASPMM.ASPMMPackage.eINSTANCE.getMetanode(), }, 0);
	public final static ASPMM.resource.aspmm.grammar.AspmmContainment ASPMM_0_0_0_7 = new ASPMM.resource.aspmm.grammar.AspmmContainment(ASPMM.ASPMMPackage.eINSTANCE.getMetamodel().getEStructuralFeature(ASPMM.ASPMMPackage.METAMODEL__METAPROPS), ASPMM.resource.aspmm.grammar.AspmmCardinality.STAR, new org.eclipse.emf.ecore.EClass[] {ASPMM.ASPMMPackage.eINSTANCE.getMetaprop(), }, 0);
	public final static ASPMM.resource.aspmm.grammar.AspmmContainment ASPMM_0_0_0_8 = new ASPMM.resource.aspmm.grammar.AspmmContainment(ASPMM.ASPMMPackage.eINSTANCE.getMetamodel().getEStructuralFeature(ASPMM.ASPMMPackage.METAMODEL__METAEDGES), ASPMM.resource.aspmm.grammar.AspmmCardinality.STAR, new org.eclipse.emf.ecore.EClass[] {ASPMM.ASPMMPackage.eINSTANCE.getMetaedge(), }, 0);
	public final static ASPMM.resource.aspmm.grammar.AspmmSequence ASPMM_0_0_0 = new ASPMM.resource.aspmm.grammar.AspmmSequence(ASPMM.resource.aspmm.grammar.AspmmCardinality.ONE, ASPMM_0_0_0_0, ASPMM_0_0_0_1, ASPMM_0_0_0_2, ASPMM_0_0_0_3, ASPMM_0_0_0_4, ASPMM_0_0_0_5, ASPMM_0_0_0_6, ASPMM_0_0_0_7, ASPMM_0_0_0_8);
	public final static ASPMM.resource.aspmm.grammar.AspmmChoice ASPMM_0_0 = new ASPMM.resource.aspmm.grammar.AspmmChoice(ASPMM.resource.aspmm.grammar.AspmmCardinality.ONE, ASPMM_0_0_0);
	public final static ASPMM.resource.aspmm.grammar.AspmmRule ASPMM_0 = new ASPMM.resource.aspmm.grammar.AspmmRule(ASPMM.ASPMMPackage.eINSTANCE.getMetamodel(), ASPMM_0_0, ASPMM.resource.aspmm.grammar.AspmmCardinality.ONE);
	public final static ASPMM.resource.aspmm.grammar.AspmmKeyword ASPMM_1_0_0_0 = new ASPMM.resource.aspmm.grammar.AspmmKeyword("metanode", ASPMM.resource.aspmm.grammar.AspmmCardinality.ONE);
	public final static ASPMM.resource.aspmm.grammar.AspmmKeyword ASPMM_1_0_0_1 = new ASPMM.resource.aspmm.grammar.AspmmKeyword("(", ASPMM.resource.aspmm.grammar.AspmmCardinality.ONE);
	public final static ASPMM.resource.aspmm.grammar.AspmmPlaceholder ASPMM_1_0_0_2 = new ASPMM.resource.aspmm.grammar.AspmmPlaceholder(ASPMM.ASPMMPackage.eINSTANCE.getMetanode().getEStructuralFeature(ASPMM.ASPMMPackage.METANODE__METAMODEL), "TEXT", ASPMM.resource.aspmm.grammar.AspmmCardinality.ONE, 0);
	public final static ASPMM.resource.aspmm.grammar.AspmmKeyword ASPMM_1_0_0_3 = new ASPMM.resource.aspmm.grammar.AspmmKeyword(",", ASPMM.resource.aspmm.grammar.AspmmCardinality.ONE);
	public final static ASPMM.resource.aspmm.grammar.AspmmPlaceholder ASPMM_1_0_0_4 = new ASPMM.resource.aspmm.grammar.AspmmPlaceholder(ASPMM.ASPMMPackage.eINSTANCE.getMetanode().getEStructuralFeature(ASPMM.ASPMMPackage.METANODE__NAME), "TEXT", ASPMM.resource.aspmm.grammar.AspmmCardinality.ONE, 0);
	public final static ASPMM.resource.aspmm.grammar.AspmmKeyword ASPMM_1_0_0_5 = new ASPMM.resource.aspmm.grammar.AspmmKeyword(")", ASPMM.resource.aspmm.grammar.AspmmCardinality.ONE);
	public final static ASPMM.resource.aspmm.grammar.AspmmKeyword ASPMM_1_0_0_6 = new ASPMM.resource.aspmm.grammar.AspmmKeyword(".", ASPMM.resource.aspmm.grammar.AspmmCardinality.ONE);
	public final static ASPMM.resource.aspmm.grammar.AspmmLineBreak ASPMM_1_0_0_7 = new ASPMM.resource.aspmm.grammar.AspmmLineBreak(ASPMM.resource.aspmm.grammar.AspmmCardinality.ONE, 0);
	public final static ASPMM.resource.aspmm.grammar.AspmmSequence ASPMM_1_0_0 = new ASPMM.resource.aspmm.grammar.AspmmSequence(ASPMM.resource.aspmm.grammar.AspmmCardinality.ONE, ASPMM_1_0_0_0, ASPMM_1_0_0_1, ASPMM_1_0_0_2, ASPMM_1_0_0_3, ASPMM_1_0_0_4, ASPMM_1_0_0_5, ASPMM_1_0_0_6, ASPMM_1_0_0_7);
	public final static ASPMM.resource.aspmm.grammar.AspmmChoice ASPMM_1_0 = new ASPMM.resource.aspmm.grammar.AspmmChoice(ASPMM.resource.aspmm.grammar.AspmmCardinality.ONE, ASPMM_1_0_0);
	public final static ASPMM.resource.aspmm.grammar.AspmmRule ASPMM_1 = new ASPMM.resource.aspmm.grammar.AspmmRule(ASPMM.ASPMMPackage.eINSTANCE.getMetanode(), ASPMM_1_0, ASPMM.resource.aspmm.grammar.AspmmCardinality.ONE);
	public final static ASPMM.resource.aspmm.grammar.AspmmKeyword ASPMM_2_0_0_0 = new ASPMM.resource.aspmm.grammar.AspmmKeyword("metaprop", ASPMM.resource.aspmm.grammar.AspmmCardinality.ONE);
	public final static ASPMM.resource.aspmm.grammar.AspmmKeyword ASPMM_2_0_0_1 = new ASPMM.resource.aspmm.grammar.AspmmKeyword("(", ASPMM.resource.aspmm.grammar.AspmmCardinality.ONE);
	public final static ASPMM.resource.aspmm.grammar.AspmmPlaceholder ASPMM_2_0_0_2 = new ASPMM.resource.aspmm.grammar.AspmmPlaceholder(ASPMM.ASPMMPackage.eINSTANCE.getMetaprop().getEStructuralFeature(ASPMM.ASPMMPackage.METAPROP__METAMODEL), "TEXT", ASPMM.resource.aspmm.grammar.AspmmCardinality.ONE, 0);
	public final static ASPMM.resource.aspmm.grammar.AspmmKeyword ASPMM_2_0_0_3 = new ASPMM.resource.aspmm.grammar.AspmmKeyword(",", ASPMM.resource.aspmm.grammar.AspmmCardinality.ONE);
	public final static ASPMM.resource.aspmm.grammar.AspmmPlaceholder ASPMM_2_0_0_4 = new ASPMM.resource.aspmm.grammar.AspmmPlaceholder(ASPMM.ASPMMPackage.eINSTANCE.getMetaprop().getEStructuralFeature(ASPMM.ASPMMPackage.METAPROP__NAME), "TEXT", ASPMM.resource.aspmm.grammar.AspmmCardinality.ONE, 0);
	public final static ASPMM.resource.aspmm.grammar.AspmmKeyword ASPMM_2_0_0_5 = new ASPMM.resource.aspmm.grammar.AspmmKeyword(",", ASPMM.resource.aspmm.grammar.AspmmCardinality.ONE);
	public final static ASPMM.resource.aspmm.grammar.AspmmPlaceholder ASPMM_2_0_0_6 = new ASPMM.resource.aspmm.grammar.AspmmPlaceholder(ASPMM.ASPMMPackage.eINSTANCE.getMetaprop().getEStructuralFeature(ASPMM.ASPMMPackage.METAPROP__METANODE), "TEXT", ASPMM.resource.aspmm.grammar.AspmmCardinality.ONE, 0);
	public final static ASPMM.resource.aspmm.grammar.AspmmKeyword ASPMM_2_0_0_7 = new ASPMM.resource.aspmm.grammar.AspmmKeyword(")", ASPMM.resource.aspmm.grammar.AspmmCardinality.ONE);
	public final static ASPMM.resource.aspmm.grammar.AspmmKeyword ASPMM_2_0_0_8 = new ASPMM.resource.aspmm.grammar.AspmmKeyword(".", ASPMM.resource.aspmm.grammar.AspmmCardinality.ONE);
	public final static ASPMM.resource.aspmm.grammar.AspmmLineBreak ASPMM_2_0_0_9 = new ASPMM.resource.aspmm.grammar.AspmmLineBreak(ASPMM.resource.aspmm.grammar.AspmmCardinality.ONE, 0);
	public final static ASPMM.resource.aspmm.grammar.AspmmSequence ASPMM_2_0_0 = new ASPMM.resource.aspmm.grammar.AspmmSequence(ASPMM.resource.aspmm.grammar.AspmmCardinality.ONE, ASPMM_2_0_0_0, ASPMM_2_0_0_1, ASPMM_2_0_0_2, ASPMM_2_0_0_3, ASPMM_2_0_0_4, ASPMM_2_0_0_5, ASPMM_2_0_0_6, ASPMM_2_0_0_7, ASPMM_2_0_0_8, ASPMM_2_0_0_9);
	public final static ASPMM.resource.aspmm.grammar.AspmmChoice ASPMM_2_0 = new ASPMM.resource.aspmm.grammar.AspmmChoice(ASPMM.resource.aspmm.grammar.AspmmCardinality.ONE, ASPMM_2_0_0);
	public final static ASPMM.resource.aspmm.grammar.AspmmRule ASPMM_2 = new ASPMM.resource.aspmm.grammar.AspmmRule(ASPMM.ASPMMPackage.eINSTANCE.getMetaprop(), ASPMM_2_0, ASPMM.resource.aspmm.grammar.AspmmCardinality.ONE);
	public final static ASPMM.resource.aspmm.grammar.AspmmKeyword ASPMM_3_0_0_0 = new ASPMM.resource.aspmm.grammar.AspmmKeyword("metaedge", ASPMM.resource.aspmm.grammar.AspmmCardinality.ONE);
	public final static ASPMM.resource.aspmm.grammar.AspmmKeyword ASPMM_3_0_0_1 = new ASPMM.resource.aspmm.grammar.AspmmKeyword("(", ASPMM.resource.aspmm.grammar.AspmmCardinality.ONE);
	public final static ASPMM.resource.aspmm.grammar.AspmmPlaceholder ASPMM_3_0_0_2 = new ASPMM.resource.aspmm.grammar.AspmmPlaceholder(ASPMM.ASPMMPackage.eINSTANCE.getMetaedge().getEStructuralFeature(ASPMM.ASPMMPackage.METAEDGE__METAMODEL), "TEXT", ASPMM.resource.aspmm.grammar.AspmmCardinality.ONE, 0);
	public final static ASPMM.resource.aspmm.grammar.AspmmKeyword ASPMM_3_0_0_3 = new ASPMM.resource.aspmm.grammar.AspmmKeyword(",", ASPMM.resource.aspmm.grammar.AspmmCardinality.ONE);
	public final static ASPMM.resource.aspmm.grammar.AspmmEnumerationTerminal ASPMM_3_0_0_4 = new ASPMM.resource.aspmm.grammar.AspmmEnumerationTerminal(ASPMM.ASPMMPackage.eINSTANCE.getMetaedge().getEStructuralFeature(ASPMM.ASPMMPackage.METAEDGE__TYPE), new String[] {"association", "association", "generalization", "generalization", "composition", "composition", }, ASPMM.resource.aspmm.grammar.AspmmCardinality.ONE, 0);
	public final static ASPMM.resource.aspmm.grammar.AspmmKeyword ASPMM_3_0_0_5 = new ASPMM.resource.aspmm.grammar.AspmmKeyword(",", ASPMM.resource.aspmm.grammar.AspmmCardinality.ONE);
	public final static ASPMM.resource.aspmm.grammar.AspmmPlaceholder ASPMM_3_0_0_6 = new ASPMM.resource.aspmm.grammar.AspmmPlaceholder(ASPMM.ASPMMPackage.eINSTANCE.getMetaedge().getEStructuralFeature(ASPMM.ASPMMPackage.METAEDGE__NAME), "TEXT", ASPMM.resource.aspmm.grammar.AspmmCardinality.ONE, 0);
	public final static ASPMM.resource.aspmm.grammar.AspmmKeyword ASPMM_3_0_0_7 = new ASPMM.resource.aspmm.grammar.AspmmKeyword(",", ASPMM.resource.aspmm.grammar.AspmmCardinality.ONE);
	public final static ASPMM.resource.aspmm.grammar.AspmmPlaceholder ASPMM_3_0_0_8 = new ASPMM.resource.aspmm.grammar.AspmmPlaceholder(ASPMM.ASPMMPackage.eINSTANCE.getMetaedge().getEStructuralFeature(ASPMM.ASPMMPackage.METAEDGE__SOURCE), "TEXT", ASPMM.resource.aspmm.grammar.AspmmCardinality.ONE, 0);
	public final static ASPMM.resource.aspmm.grammar.AspmmKeyword ASPMM_3_0_0_9 = new ASPMM.resource.aspmm.grammar.AspmmKeyword(",", ASPMM.resource.aspmm.grammar.AspmmCardinality.ONE);
	public final static ASPMM.resource.aspmm.grammar.AspmmPlaceholder ASPMM_3_0_0_10 = new ASPMM.resource.aspmm.grammar.AspmmPlaceholder(ASPMM.ASPMMPackage.eINSTANCE.getMetaedge().getEStructuralFeature(ASPMM.ASPMMPackage.METAEDGE__TARGET), "TEXT", ASPMM.resource.aspmm.grammar.AspmmCardinality.ONE, 0);
	public final static ASPMM.resource.aspmm.grammar.AspmmKeyword ASPMM_3_0_0_11 = new ASPMM.resource.aspmm.grammar.AspmmKeyword(")", ASPMM.resource.aspmm.grammar.AspmmCardinality.ONE);
	public final static ASPMM.resource.aspmm.grammar.AspmmKeyword ASPMM_3_0_0_12 = new ASPMM.resource.aspmm.grammar.AspmmKeyword(".", ASPMM.resource.aspmm.grammar.AspmmCardinality.ONE);
	public final static ASPMM.resource.aspmm.grammar.AspmmLineBreak ASPMM_3_0_0_13 = new ASPMM.resource.aspmm.grammar.AspmmLineBreak(ASPMM.resource.aspmm.grammar.AspmmCardinality.ONE, 0);
	public final static ASPMM.resource.aspmm.grammar.AspmmSequence ASPMM_3_0_0 = new ASPMM.resource.aspmm.grammar.AspmmSequence(ASPMM.resource.aspmm.grammar.AspmmCardinality.ONE, ASPMM_3_0_0_0, ASPMM_3_0_0_1, ASPMM_3_0_0_2, ASPMM_3_0_0_3, ASPMM_3_0_0_4, ASPMM_3_0_0_5, ASPMM_3_0_0_6, ASPMM_3_0_0_7, ASPMM_3_0_0_8, ASPMM_3_0_0_9, ASPMM_3_0_0_10, ASPMM_3_0_0_11, ASPMM_3_0_0_12, ASPMM_3_0_0_13);
	public final static ASPMM.resource.aspmm.grammar.AspmmChoice ASPMM_3_0 = new ASPMM.resource.aspmm.grammar.AspmmChoice(ASPMM.resource.aspmm.grammar.AspmmCardinality.ONE, ASPMM_3_0_0);
	public final static ASPMM.resource.aspmm.grammar.AspmmRule ASPMM_3 = new ASPMM.resource.aspmm.grammar.AspmmRule(ASPMM.ASPMMPackage.eINSTANCE.getMetaedge(), ASPMM_3_0, ASPMM.resource.aspmm.grammar.AspmmCardinality.ONE);
	
	public static String getSyntaxElementID(ASPMM.resource.aspmm.grammar.AspmmSyntaxElement syntaxElement) {
		if (syntaxElement == null) {
			// null indicates EOF
			return "<EOF>";
		}
		for (java.lang.reflect.Field field : ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.class.getFields()) {
			Object fieldValue;
			try {
				fieldValue = field.get(null);
				if (fieldValue == syntaxElement) {
					String id = field.getName();
					return id;
				}
			} catch (Exception e) { }
		}
		return null;
	}
	
	public static ASPMM.resource.aspmm.grammar.AspmmSyntaxElement getSyntaxElementByID(String syntaxElementID) {
		try {
			return (ASPMM.resource.aspmm.grammar.AspmmSyntaxElement) ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.class.getField(syntaxElementID).get(null);
		} catch (Exception e) {
			return null;
		}
	}
	
	public final static ASPMM.resource.aspmm.grammar.AspmmRule[] RULES = new ASPMM.resource.aspmm.grammar.AspmmRule[] {
		ASPMM_0,
		ASPMM_1,
		ASPMM_2,
		ASPMM_3,
	};
	
	/**
	 * Returns all keywords of the grammar. This includes all literals for boolean and
	 * enumeration terminals.
	 */
	public java.util.Set<String> getKeywords() {
		if (this.keywords == null) {
			this.keywords = new java.util.LinkedHashSet<String>();
			for (ASPMM.resource.aspmm.grammar.AspmmRule rule : RULES) {
				findKeywords(rule, this.keywords);
			}
		}
		return keywords;
	}
	
	/**
	 * Finds all keywords in the given element and its children and adds them to the
	 * set. This includes all literals for boolean and enumeration terminals.
	 */
	private void findKeywords(ASPMM.resource.aspmm.grammar.AspmmSyntaxElement element, java.util.Set<String> keywords) {
		if (element instanceof ASPMM.resource.aspmm.grammar.AspmmKeyword) {
			keywords.add(((ASPMM.resource.aspmm.grammar.AspmmKeyword) element).getValue());
		} else if (element instanceof ASPMM.resource.aspmm.grammar.AspmmBooleanTerminal) {
			keywords.add(((ASPMM.resource.aspmm.grammar.AspmmBooleanTerminal) element).getTrueLiteral());
			keywords.add(((ASPMM.resource.aspmm.grammar.AspmmBooleanTerminal) element).getFalseLiteral());
		} else if (element instanceof ASPMM.resource.aspmm.grammar.AspmmEnumerationTerminal) {
			ASPMM.resource.aspmm.grammar.AspmmEnumerationTerminal terminal = (ASPMM.resource.aspmm.grammar.AspmmEnumerationTerminal) element;
			for (String key : terminal.getLiteralMapping().keySet()) {
				keywords.add(key);
			}
		}
		for (ASPMM.resource.aspmm.grammar.AspmmSyntaxElement child : element.getChildren()) {
			findKeywords(child, this.keywords);
		}
	}
	
}
