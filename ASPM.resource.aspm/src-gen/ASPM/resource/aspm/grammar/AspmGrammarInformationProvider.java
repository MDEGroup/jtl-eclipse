/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPM.resource.aspm.grammar;

public class AspmGrammarInformationProvider {
	
	public final static org.eclipse.emf.ecore.EStructuralFeature ANONYMOUS_FEATURE = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEAttribute();
	static {
		ANONYMOUS_FEATURE.setName("_");
	}
	
	public final static AspmGrammarInformationProvider INSTANCE = new AspmGrammarInformationProvider();
	
	private java.util.Set<String> keywords;
	
	public final static ASPM.resource.aspm.grammar.AspmKeyword ASPM_0_0_0_0 = new ASPM.resource.aspm.grammar.AspmKeyword("model", ASPM.resource.aspm.grammar.AspmCardinality.ONE);
	public final static ASPM.resource.aspm.grammar.AspmKeyword ASPM_0_0_0_1 = new ASPM.resource.aspm.grammar.AspmKeyword("(", ASPM.resource.aspm.grammar.AspmCardinality.ONE);
	public final static ASPM.resource.aspm.grammar.AspmPlaceholder ASPM_0_0_0_2 = new ASPM.resource.aspm.grammar.AspmPlaceholder(ASPM.ASPMPackage.eINSTANCE.getModel().getEStructuralFeature(ASPM.ASPMPackage.MODEL__ID), "QUOTED_34_34_92", ASPM.resource.aspm.grammar.AspmCardinality.ONE, 0);
	public final static ASPM.resource.aspm.grammar.AspmKeyword ASPM_0_0_0_3 = new ASPM.resource.aspm.grammar.AspmKeyword(",", ASPM.resource.aspm.grammar.AspmCardinality.ONE);
	public final static ASPM.resource.aspm.grammar.AspmPlaceholder ASPM_0_0_0_4 = new ASPM.resource.aspm.grammar.AspmPlaceholder(ASPM.ASPMPackage.eINSTANCE.getModel().getEStructuralFeature(ASPM.ASPMPackage.MODEL__NAME), "TEXT", ASPM.resource.aspm.grammar.AspmCardinality.ONE, 0);
	public final static ASPM.resource.aspm.grammar.AspmKeyword ASPM_0_0_0_5 = new ASPM.resource.aspm.grammar.AspmKeyword(")", ASPM.resource.aspm.grammar.AspmCardinality.ONE);
	public final static ASPM.resource.aspm.grammar.AspmKeyword ASPM_0_0_0_6 = new ASPM.resource.aspm.grammar.AspmKeyword(".", ASPM.resource.aspm.grammar.AspmCardinality.ONE);
	public final static ASPM.resource.aspm.grammar.AspmLineBreak ASPM_0_0_0_7 = new ASPM.resource.aspm.grammar.AspmLineBreak(ASPM.resource.aspm.grammar.AspmCardinality.ONE, 0);
	public final static ASPM.resource.aspm.grammar.AspmContainment ASPM_0_0_0_8 = new ASPM.resource.aspm.grammar.AspmContainment(ASPM.ASPMPackage.eINSTANCE.getModel().getEStructuralFeature(ASPM.ASPMPackage.MODEL__NODES), ASPM.resource.aspm.grammar.AspmCardinality.STAR, new org.eclipse.emf.ecore.EClass[] {ASPM.ASPMPackage.eINSTANCE.getNode(), }, 0);
	public final static ASPM.resource.aspm.grammar.AspmContainment ASPM_0_0_0_9 = new ASPM.resource.aspm.grammar.AspmContainment(ASPM.ASPMPackage.eINSTANCE.getModel().getEStructuralFeature(ASPM.ASPMPackage.MODEL__PROPS), ASPM.resource.aspm.grammar.AspmCardinality.STAR, new org.eclipse.emf.ecore.EClass[] {ASPM.ASPMPackage.eINSTANCE.getProp(), }, 0);
	public final static ASPM.resource.aspm.grammar.AspmContainment ASPM_0_0_0_10 = new ASPM.resource.aspm.grammar.AspmContainment(ASPM.ASPMPackage.eINSTANCE.getModel().getEStructuralFeature(ASPM.ASPMPackage.MODEL__EDGES), ASPM.resource.aspm.grammar.AspmCardinality.STAR, new org.eclipse.emf.ecore.EClass[] {ASPM.ASPMPackage.eINSTANCE.getEdge(), }, 0);
	public final static ASPM.resource.aspm.grammar.AspmSequence ASPM_0_0_0 = new ASPM.resource.aspm.grammar.AspmSequence(ASPM.resource.aspm.grammar.AspmCardinality.ONE, ASPM_0_0_0_0, ASPM_0_0_0_1, ASPM_0_0_0_2, ASPM_0_0_0_3, ASPM_0_0_0_4, ASPM_0_0_0_5, ASPM_0_0_0_6, ASPM_0_0_0_7, ASPM_0_0_0_8, ASPM_0_0_0_9, ASPM_0_0_0_10);
	public final static ASPM.resource.aspm.grammar.AspmChoice ASPM_0_0 = new ASPM.resource.aspm.grammar.AspmChoice(ASPM.resource.aspm.grammar.AspmCardinality.ONE, ASPM_0_0_0);
	public final static ASPM.resource.aspm.grammar.AspmRule ASPM_0 = new ASPM.resource.aspm.grammar.AspmRule(ASPM.ASPMPackage.eINSTANCE.getModel(), ASPM_0_0, ASPM.resource.aspm.grammar.AspmCardinality.ONE);
	public final static ASPM.resource.aspm.grammar.AspmKeyword ASPM_1_0_0_0 = new ASPM.resource.aspm.grammar.AspmKeyword("node", ASPM.resource.aspm.grammar.AspmCardinality.ONE);
	public final static ASPM.resource.aspm.grammar.AspmKeyword ASPM_1_0_0_1 = new ASPM.resource.aspm.grammar.AspmKeyword("(", ASPM.resource.aspm.grammar.AspmCardinality.ONE);
	public final static ASPM.resource.aspm.grammar.AspmPlaceholder ASPM_1_0_0_2 = new ASPM.resource.aspm.grammar.AspmPlaceholder(ASPM.ASPMPackage.eINSTANCE.getNode().getEStructuralFeature(ASPM.ASPMPackage.NODE__MODEL), "TEXT", ASPM.resource.aspm.grammar.AspmCardinality.ONE, 0);
	public final static ASPM.resource.aspm.grammar.AspmKeyword ASPM_1_0_0_3 = new ASPM.resource.aspm.grammar.AspmKeyword(",", ASPM.resource.aspm.grammar.AspmCardinality.ONE);
	public final static ASPM.resource.aspm.grammar.AspmPlaceholder ASPM_1_0_0_4 = new ASPM.resource.aspm.grammar.AspmPlaceholder(ASPM.ASPMPackage.eINSTANCE.getNode().getEStructuralFeature(ASPM.ASPMPackage.NODE__ID), "TEXT", ASPM.resource.aspm.grammar.AspmCardinality.ONE, 0);
	public final static ASPM.resource.aspm.grammar.AspmKeyword ASPM_1_0_0_5 = new ASPM.resource.aspm.grammar.AspmKeyword(",", ASPM.resource.aspm.grammar.AspmCardinality.ONE);
	public final static ASPM.resource.aspm.grammar.AspmPlaceholder ASPM_1_0_0_6 = new ASPM.resource.aspm.grammar.AspmPlaceholder(ASPM.ASPMPackage.eINSTANCE.getNode().getEStructuralFeature(ASPM.ASPMPackage.NODE__IDTRACE), "QUOTED_34_34_92", ASPM.resource.aspm.grammar.AspmCardinality.ONE, 0);
	public final static ASPM.resource.aspm.grammar.AspmKeyword ASPM_1_0_0_7 = new ASPM.resource.aspm.grammar.AspmKeyword(",", ASPM.resource.aspm.grammar.AspmCardinality.ONE);
	public final static ASPM.resource.aspm.grammar.AspmPlaceholder ASPM_1_0_0_8 = new ASPM.resource.aspm.grammar.AspmPlaceholder(ASPM.ASPMPackage.eINSTANCE.getNode().getEStructuralFeature(ASPM.ASPMPackage.NODE__NAME), "TEXT", ASPM.resource.aspm.grammar.AspmCardinality.ONE, 0);
	public final static ASPM.resource.aspm.grammar.AspmKeyword ASPM_1_0_0_9 = new ASPM.resource.aspm.grammar.AspmKeyword(")", ASPM.resource.aspm.grammar.AspmCardinality.ONE);
	public final static ASPM.resource.aspm.grammar.AspmKeyword ASPM_1_0_0_10 = new ASPM.resource.aspm.grammar.AspmKeyword(".", ASPM.resource.aspm.grammar.AspmCardinality.ONE);
	public final static ASPM.resource.aspm.grammar.AspmLineBreak ASPM_1_0_0_11 = new ASPM.resource.aspm.grammar.AspmLineBreak(ASPM.resource.aspm.grammar.AspmCardinality.ONE, 0);
	public final static ASPM.resource.aspm.grammar.AspmSequence ASPM_1_0_0 = new ASPM.resource.aspm.grammar.AspmSequence(ASPM.resource.aspm.grammar.AspmCardinality.ONE, ASPM_1_0_0_0, ASPM_1_0_0_1, ASPM_1_0_0_2, ASPM_1_0_0_3, ASPM_1_0_0_4, ASPM_1_0_0_5, ASPM_1_0_0_6, ASPM_1_0_0_7, ASPM_1_0_0_8, ASPM_1_0_0_9, ASPM_1_0_0_10, ASPM_1_0_0_11);
	public final static ASPM.resource.aspm.grammar.AspmChoice ASPM_1_0 = new ASPM.resource.aspm.grammar.AspmChoice(ASPM.resource.aspm.grammar.AspmCardinality.ONE, ASPM_1_0_0);
	public final static ASPM.resource.aspm.grammar.AspmRule ASPM_1 = new ASPM.resource.aspm.grammar.AspmRule(ASPM.ASPMPackage.eINSTANCE.getNode(), ASPM_1_0, ASPM.resource.aspm.grammar.AspmCardinality.ONE);
	public final static ASPM.resource.aspm.grammar.AspmKeyword ASPM_2_0_0_0 = new ASPM.resource.aspm.grammar.AspmKeyword("prop", ASPM.resource.aspm.grammar.AspmCardinality.ONE);
	public final static ASPM.resource.aspm.grammar.AspmKeyword ASPM_2_0_0_1 = new ASPM.resource.aspm.grammar.AspmKeyword("(", ASPM.resource.aspm.grammar.AspmCardinality.ONE);
	public final static ASPM.resource.aspm.grammar.AspmPlaceholder ASPM_2_0_0_2 = new ASPM.resource.aspm.grammar.AspmPlaceholder(ASPM.ASPMPackage.eINSTANCE.getProp().getEStructuralFeature(ASPM.ASPMPackage.PROP__MODEL), "TEXT", ASPM.resource.aspm.grammar.AspmCardinality.ONE, 0);
	public final static ASPM.resource.aspm.grammar.AspmKeyword ASPM_2_0_0_3 = new ASPM.resource.aspm.grammar.AspmKeyword(",", ASPM.resource.aspm.grammar.AspmCardinality.ONE);
	public final static ASPM.resource.aspm.grammar.AspmPlaceholder ASPM_2_0_0_4 = new ASPM.resource.aspm.grammar.AspmPlaceholder(ASPM.ASPMPackage.eINSTANCE.getProp().getEStructuralFeature(ASPM.ASPMPackage.PROP__ID), "TEXT", ASPM.resource.aspm.grammar.AspmCardinality.ONE, 0);
	public final static ASPM.resource.aspm.grammar.AspmKeyword ASPM_2_0_0_5 = new ASPM.resource.aspm.grammar.AspmKeyword(",", ASPM.resource.aspm.grammar.AspmCardinality.ONE);
	public final static ASPM.resource.aspm.grammar.AspmPlaceholder ASPM_2_0_0_6 = new ASPM.resource.aspm.grammar.AspmPlaceholder(ASPM.ASPMPackage.eINSTANCE.getProp().getEStructuralFeature(ASPM.ASPMPackage.PROP__IDTRACE), "QUOTED_34_34_92", ASPM.resource.aspm.grammar.AspmCardinality.ONE, 0);
	public final static ASPM.resource.aspm.grammar.AspmKeyword ASPM_2_0_0_7 = new ASPM.resource.aspm.grammar.AspmKeyword(",", ASPM.resource.aspm.grammar.AspmCardinality.ONE);
	public final static ASPM.resource.aspm.grammar.AspmPlaceholder ASPM_2_0_0_8 = new ASPM.resource.aspm.grammar.AspmPlaceholder(ASPM.ASPMPackage.eINSTANCE.getProp().getEStructuralFeature(ASPM.ASPMPackage.PROP__OWNER), "TEXT", ASPM.resource.aspm.grammar.AspmCardinality.ONE, 0);
	public final static ASPM.resource.aspm.grammar.AspmKeyword ASPM_2_0_0_9 = new ASPM.resource.aspm.grammar.AspmKeyword(",", ASPM.resource.aspm.grammar.AspmCardinality.ONE);
	public final static ASPM.resource.aspm.grammar.AspmPlaceholder ASPM_2_0_0_10 = new ASPM.resource.aspm.grammar.AspmPlaceholder(ASPM.ASPMPackage.eINSTANCE.getProp().getEStructuralFeature(ASPM.ASPMPackage.PROP__OWNER_TRACE), "QUOTED_34_34_92", ASPM.resource.aspm.grammar.AspmCardinality.ONE, 0);
	public final static ASPM.resource.aspm.grammar.AspmKeyword ASPM_2_0_0_11 = new ASPM.resource.aspm.grammar.AspmKeyword(",", ASPM.resource.aspm.grammar.AspmCardinality.ONE);
	public final static ASPM.resource.aspm.grammar.AspmPlaceholder ASPM_2_0_0_12 = new ASPM.resource.aspm.grammar.AspmPlaceholder(ASPM.ASPMPackage.eINSTANCE.getProp().getEStructuralFeature(ASPM.ASPMPackage.PROP__NAME), "TEXT", ASPM.resource.aspm.grammar.AspmCardinality.ONE, 0);
	public final static ASPM.resource.aspm.grammar.AspmKeyword ASPM_2_0_0_13 = new ASPM.resource.aspm.grammar.AspmKeyword(",", ASPM.resource.aspm.grammar.AspmCardinality.ONE);
	public final static ASPM.resource.aspm.grammar.AspmPlaceholder ASPM_2_0_0_14 = new ASPM.resource.aspm.grammar.AspmPlaceholder(ASPM.ASPMPackage.eINSTANCE.getProp().getEStructuralFeature(ASPM.ASPMPackage.PROP__VALUE), "QUOTED_34_34_92", ASPM.resource.aspm.grammar.AspmCardinality.ONE, 0);
	public final static ASPM.resource.aspm.grammar.AspmKeyword ASPM_2_0_0_15 = new ASPM.resource.aspm.grammar.AspmKeyword(")", ASPM.resource.aspm.grammar.AspmCardinality.ONE);
	public final static ASPM.resource.aspm.grammar.AspmKeyword ASPM_2_0_0_16 = new ASPM.resource.aspm.grammar.AspmKeyword(".", ASPM.resource.aspm.grammar.AspmCardinality.ONE);
	public final static ASPM.resource.aspm.grammar.AspmLineBreak ASPM_2_0_0_17 = new ASPM.resource.aspm.grammar.AspmLineBreak(ASPM.resource.aspm.grammar.AspmCardinality.ONE, 0);
	public final static ASPM.resource.aspm.grammar.AspmSequence ASPM_2_0_0 = new ASPM.resource.aspm.grammar.AspmSequence(ASPM.resource.aspm.grammar.AspmCardinality.ONE, ASPM_2_0_0_0, ASPM_2_0_0_1, ASPM_2_0_0_2, ASPM_2_0_0_3, ASPM_2_0_0_4, ASPM_2_0_0_5, ASPM_2_0_0_6, ASPM_2_0_0_7, ASPM_2_0_0_8, ASPM_2_0_0_9, ASPM_2_0_0_10, ASPM_2_0_0_11, ASPM_2_0_0_12, ASPM_2_0_0_13, ASPM_2_0_0_14, ASPM_2_0_0_15, ASPM_2_0_0_16, ASPM_2_0_0_17);
	public final static ASPM.resource.aspm.grammar.AspmChoice ASPM_2_0 = new ASPM.resource.aspm.grammar.AspmChoice(ASPM.resource.aspm.grammar.AspmCardinality.ONE, ASPM_2_0_0);
	public final static ASPM.resource.aspm.grammar.AspmRule ASPM_2 = new ASPM.resource.aspm.grammar.AspmRule(ASPM.ASPMPackage.eINSTANCE.getProp(), ASPM_2_0, ASPM.resource.aspm.grammar.AspmCardinality.ONE);
	public final static ASPM.resource.aspm.grammar.AspmKeyword ASPM_3_0_0_0 = new ASPM.resource.aspm.grammar.AspmKeyword("edge", ASPM.resource.aspm.grammar.AspmCardinality.ONE);
	public final static ASPM.resource.aspm.grammar.AspmKeyword ASPM_3_0_0_1 = new ASPM.resource.aspm.grammar.AspmKeyword("(", ASPM.resource.aspm.grammar.AspmCardinality.ONE);
	public final static ASPM.resource.aspm.grammar.AspmPlaceholder ASPM_3_0_0_2 = new ASPM.resource.aspm.grammar.AspmPlaceholder(ASPM.ASPMPackage.eINSTANCE.getEdge().getEStructuralFeature(ASPM.ASPMPackage.EDGE__MODEL), "TEXT", ASPM.resource.aspm.grammar.AspmCardinality.ONE, 0);
	public final static ASPM.resource.aspm.grammar.AspmKeyword ASPM_3_0_0_3 = new ASPM.resource.aspm.grammar.AspmKeyword(",", ASPM.resource.aspm.grammar.AspmCardinality.ONE);
	public final static ASPM.resource.aspm.grammar.AspmPlaceholder ASPM_3_0_0_4 = new ASPM.resource.aspm.grammar.AspmPlaceholder(ASPM.ASPMPackage.eINSTANCE.getEdge().getEStructuralFeature(ASPM.ASPMPackage.EDGE__ID), "TEXT", ASPM.resource.aspm.grammar.AspmCardinality.ONE, 0);
	public final static ASPM.resource.aspm.grammar.AspmKeyword ASPM_3_0_0_5 = new ASPM.resource.aspm.grammar.AspmKeyword(",", ASPM.resource.aspm.grammar.AspmCardinality.ONE);
	public final static ASPM.resource.aspm.grammar.AspmPlaceholder ASPM_3_0_0_6 = new ASPM.resource.aspm.grammar.AspmPlaceholder(ASPM.ASPMPackage.eINSTANCE.getEdge().getEStructuralFeature(ASPM.ASPMPackage.EDGE__IDTRACE), "QUOTED_34_34_92", ASPM.resource.aspm.grammar.AspmCardinality.ONE, 0);
	public final static ASPM.resource.aspm.grammar.AspmKeyword ASPM_3_0_0_7 = new ASPM.resource.aspm.grammar.AspmKeyword(",", ASPM.resource.aspm.grammar.AspmCardinality.ONE);
	public final static ASPM.resource.aspm.grammar.AspmPlaceholder ASPM_3_0_0_8 = new ASPM.resource.aspm.grammar.AspmPlaceholder(ASPM.ASPMPackage.eINSTANCE.getEdge().getEStructuralFeature(ASPM.ASPMPackage.EDGE__NAME), "TEXT", ASPM.resource.aspm.grammar.AspmCardinality.ONE, 0);
	public final static ASPM.resource.aspm.grammar.AspmKeyword ASPM_3_0_0_9 = new ASPM.resource.aspm.grammar.AspmKeyword(",", ASPM.resource.aspm.grammar.AspmCardinality.ONE);
	public final static ASPM.resource.aspm.grammar.AspmPlaceholder ASPM_3_0_0_10 = new ASPM.resource.aspm.grammar.AspmPlaceholder(ASPM.ASPMPackage.eINSTANCE.getEdge().getEStructuralFeature(ASPM.ASPMPackage.EDGE__SOURCE), "TEXT", ASPM.resource.aspm.grammar.AspmCardinality.ONE, 0);
	public final static ASPM.resource.aspm.grammar.AspmKeyword ASPM_3_0_0_11 = new ASPM.resource.aspm.grammar.AspmKeyword(",", ASPM.resource.aspm.grammar.AspmCardinality.ONE);
	public final static ASPM.resource.aspm.grammar.AspmPlaceholder ASPM_3_0_0_12 = new ASPM.resource.aspm.grammar.AspmPlaceholder(ASPM.ASPMPackage.eINSTANCE.getEdge().getEStructuralFeature(ASPM.ASPMPackage.EDGE__SOURCE_TRACE), "QUOTED_34_34_92", ASPM.resource.aspm.grammar.AspmCardinality.ONE, 0);
	public final static ASPM.resource.aspm.grammar.AspmKeyword ASPM_3_0_0_13 = new ASPM.resource.aspm.grammar.AspmKeyword(",", ASPM.resource.aspm.grammar.AspmCardinality.ONE);
	public final static ASPM.resource.aspm.grammar.AspmPlaceholder ASPM_3_0_0_14 = new ASPM.resource.aspm.grammar.AspmPlaceholder(ASPM.ASPMPackage.eINSTANCE.getEdge().getEStructuralFeature(ASPM.ASPMPackage.EDGE__TARGET), "TEXT", ASPM.resource.aspm.grammar.AspmCardinality.ONE, 0);
	public final static ASPM.resource.aspm.grammar.AspmKeyword ASPM_3_0_0_15 = new ASPM.resource.aspm.grammar.AspmKeyword(",", ASPM.resource.aspm.grammar.AspmCardinality.ONE);
	public final static ASPM.resource.aspm.grammar.AspmPlaceholder ASPM_3_0_0_16 = new ASPM.resource.aspm.grammar.AspmPlaceholder(ASPM.ASPMPackage.eINSTANCE.getEdge().getEStructuralFeature(ASPM.ASPMPackage.EDGE__TARGET_TRACE), "QUOTED_34_34_92", ASPM.resource.aspm.grammar.AspmCardinality.ONE, 0);
	public final static ASPM.resource.aspm.grammar.AspmKeyword ASPM_3_0_0_17 = new ASPM.resource.aspm.grammar.AspmKeyword(")", ASPM.resource.aspm.grammar.AspmCardinality.ONE);
	public final static ASPM.resource.aspm.grammar.AspmKeyword ASPM_3_0_0_18 = new ASPM.resource.aspm.grammar.AspmKeyword(".", ASPM.resource.aspm.grammar.AspmCardinality.ONE);
	public final static ASPM.resource.aspm.grammar.AspmLineBreak ASPM_3_0_0_19 = new ASPM.resource.aspm.grammar.AspmLineBreak(ASPM.resource.aspm.grammar.AspmCardinality.ONE, 0);
	public final static ASPM.resource.aspm.grammar.AspmSequence ASPM_3_0_0 = new ASPM.resource.aspm.grammar.AspmSequence(ASPM.resource.aspm.grammar.AspmCardinality.ONE, ASPM_3_0_0_0, ASPM_3_0_0_1, ASPM_3_0_0_2, ASPM_3_0_0_3, ASPM_3_0_0_4, ASPM_3_0_0_5, ASPM_3_0_0_6, ASPM_3_0_0_7, ASPM_3_0_0_8, ASPM_3_0_0_9, ASPM_3_0_0_10, ASPM_3_0_0_11, ASPM_3_0_0_12, ASPM_3_0_0_13, ASPM_3_0_0_14, ASPM_3_0_0_15, ASPM_3_0_0_16, ASPM_3_0_0_17, ASPM_3_0_0_18, ASPM_3_0_0_19);
	public final static ASPM.resource.aspm.grammar.AspmChoice ASPM_3_0 = new ASPM.resource.aspm.grammar.AspmChoice(ASPM.resource.aspm.grammar.AspmCardinality.ONE, ASPM_3_0_0);
	public final static ASPM.resource.aspm.grammar.AspmRule ASPM_3 = new ASPM.resource.aspm.grammar.AspmRule(ASPM.ASPMPackage.eINSTANCE.getEdge(), ASPM_3_0, ASPM.resource.aspm.grammar.AspmCardinality.ONE);
	
	public static String getSyntaxElementID(ASPM.resource.aspm.grammar.AspmSyntaxElement syntaxElement) {
		if (syntaxElement == null) {
			// null indicates EOF
			return "<EOF>";
		}
		for (java.lang.reflect.Field field : ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.class.getFields()) {
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
	
	public static ASPM.resource.aspm.grammar.AspmSyntaxElement getSyntaxElementByID(String syntaxElementID) {
		try {
			return (ASPM.resource.aspm.grammar.AspmSyntaxElement) ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.class.getField(syntaxElementID).get(null);
		} catch (Exception e) {
			return null;
		}
	}
	
	public final static ASPM.resource.aspm.grammar.AspmRule[] RULES = new ASPM.resource.aspm.grammar.AspmRule[] {
		ASPM_0,
		ASPM_1,
		ASPM_2,
		ASPM_3,
	};
	
	/**
	 * Returns all keywords of the grammar. This includes all literals for boolean and
	 * enumeration terminals.
	 */
	public java.util.Set<String> getKeywords() {
		if (this.keywords == null) {
			this.keywords = new java.util.LinkedHashSet<String>();
			for (ASPM.resource.aspm.grammar.AspmRule rule : RULES) {
				findKeywords(rule, this.keywords);
			}
		}
		return keywords;
	}
	
	/**
	 * Finds all keywords in the given element and its children and adds them to the
	 * set. This includes all literals for boolean and enumeration terminals.
	 */
	private void findKeywords(ASPM.resource.aspm.grammar.AspmSyntaxElement element, java.util.Set<String> keywords) {
		if (element instanceof ASPM.resource.aspm.grammar.AspmKeyword) {
			keywords.add(((ASPM.resource.aspm.grammar.AspmKeyword) element).getValue());
		} else if (element instanceof ASPM.resource.aspm.grammar.AspmBooleanTerminal) {
			keywords.add(((ASPM.resource.aspm.grammar.AspmBooleanTerminal) element).getTrueLiteral());
			keywords.add(((ASPM.resource.aspm.grammar.AspmBooleanTerminal) element).getFalseLiteral());
		} else if (element instanceof ASPM.resource.aspm.grammar.AspmEnumerationTerminal) {
			ASPM.resource.aspm.grammar.AspmEnumerationTerminal terminal = (ASPM.resource.aspm.grammar.AspmEnumerationTerminal) element;
			for (String key : terminal.getLiteralMapping().keySet()) {
				keywords.add(key);
			}
		}
		for (ASPM.resource.aspm.grammar.AspmSyntaxElement child : element.getChildren()) {
			findKeywords(child, this.keywords);
		}
	}
	
}
