/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPT.resource.aspt.grammar;

public class AsptGrammarInformationProvider {
	
	public final static org.eclipse.emf.ecore.EStructuralFeature ANONYMOUS_FEATURE = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEAttribute();
	static {
		ANONYMOUS_FEATURE.setName("_");
	}
	
	public final static AsptGrammarInformationProvider INSTANCE = new AsptGrammarInformationProvider();
	
	private java.util.Set<String> keywords;
	
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_0_0_0_0 = new ASPT.resource.aspt.grammar.AsptKeyword("trace_model", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_0_0_0_1 = new ASPT.resource.aspt.grammar.AsptKeyword("(", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptPlaceholder ASPT_0_0_0_2 = new ASPT.resource.aspt.grammar.AsptPlaceholder(ASPT.ASPTPackage.eINSTANCE.getTraceModel().getEStructuralFeature(ASPT.ASPTPackage.TRACE_MODEL__ID), "QUOTED_34_34", ASPT.resource.aspt.grammar.AsptCardinality.ONE, 0);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_0_0_0_3 = new ASPT.resource.aspt.grammar.AsptKeyword(",", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptPlaceholder ASPT_0_0_0_4 = new ASPT.resource.aspt.grammar.AsptPlaceholder(ASPT.ASPTPackage.eINSTANCE.getTraceModel().getEStructuralFeature(ASPT.ASPTPackage.TRACE_MODEL__MMS), "IDENTIFIER", ASPT.resource.aspt.grammar.AsptCardinality.ONE, 0);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_0_0_0_5 = new ASPT.resource.aspt.grammar.AsptKeyword(")", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_0_0_0_6 = new ASPT.resource.aspt.grammar.AsptKeyword(".", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptLineBreak ASPT_0_0_0_7 = new ASPT.resource.aspt.grammar.AsptLineBreak(ASPT.resource.aspt.grammar.AsptCardinality.ONE, 0);
	public final static ASPT.resource.aspt.grammar.AsptContainment ASPT_0_0_0_8_0_0_0 = new ASPT.resource.aspt.grammar.AsptContainment(ASPT.ASPTPackage.eINSTANCE.getTraceModel().getEStructuralFeature(ASPT.ASPTPackage.TRACE_MODEL__TRACEELEMENTS), ASPT.resource.aspt.grammar.AsptCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {ASPT.ASPTPackage.eINSTANCE.getTraceElement(), }, 0);
	public final static ASPT.resource.aspt.grammar.AsptSequence ASPT_0_0_0_8_0_0 = new ASPT.resource.aspt.grammar.AsptSequence(ASPT.resource.aspt.grammar.AsptCardinality.ONE, ASPT_0_0_0_8_0_0_0);
	public final static ASPT.resource.aspt.grammar.AsptContainment ASPT_0_0_0_8_0_1_0 = new ASPT.resource.aspt.grammar.AsptContainment(ASPT.ASPTPackage.eINSTANCE.getTraceModel().getEStructuralFeature(ASPT.ASPTPackage.TRACE_MODEL__TRACELINKS), ASPT.resource.aspt.grammar.AsptCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {ASPT.ASPTPackage.eINSTANCE.getTraceLink(), }, 0);
	public final static ASPT.resource.aspt.grammar.AsptSequence ASPT_0_0_0_8_0_1 = new ASPT.resource.aspt.grammar.AsptSequence(ASPT.resource.aspt.grammar.AsptCardinality.ONE, ASPT_0_0_0_8_0_1_0);
	public final static ASPT.resource.aspt.grammar.AsptChoice ASPT_0_0_0_8_0 = new ASPT.resource.aspt.grammar.AsptChoice(ASPT.resource.aspt.grammar.AsptCardinality.ONE, ASPT_0_0_0_8_0_0, ASPT_0_0_0_8_0_1);
	public final static ASPT.resource.aspt.grammar.AsptCompound ASPT_0_0_0_8 = new ASPT.resource.aspt.grammar.AsptCompound(ASPT_0_0_0_8_0, ASPT.resource.aspt.grammar.AsptCardinality.STAR);
	public final static ASPT.resource.aspt.grammar.AsptSequence ASPT_0_0_0 = new ASPT.resource.aspt.grammar.AsptSequence(ASPT.resource.aspt.grammar.AsptCardinality.ONE, ASPT_0_0_0_0, ASPT_0_0_0_1, ASPT_0_0_0_2, ASPT_0_0_0_3, ASPT_0_0_0_4, ASPT_0_0_0_5, ASPT_0_0_0_6, ASPT_0_0_0_7, ASPT_0_0_0_8);
	public final static ASPT.resource.aspt.grammar.AsptChoice ASPT_0_0 = new ASPT.resource.aspt.grammar.AsptChoice(ASPT.resource.aspt.grammar.AsptCardinality.ONE, ASPT_0_0_0);
	public final static ASPT.resource.aspt.grammar.AsptRule ASPT_0 = new ASPT.resource.aspt.grammar.AsptRule(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT_0_0, ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_1_0_0_0 = new ASPT.resource.aspt.grammar.AsptKeyword("trace_node", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_1_0_0_1 = new ASPT.resource.aspt.grammar.AsptKeyword("(", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptPlaceholder ASPT_1_0_0_2 = new ASPT.resource.aspt.grammar.AsptPlaceholder(ASPT.ASPTPackage.eINSTANCE.getTraceNode().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NODE__METAMODEL), "IDENTIFIER", ASPT.resource.aspt.grammar.AsptCardinality.ONE, 0);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_1_0_0_3 = new ASPT.resource.aspt.grammar.AsptKeyword(",", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptPlaceholder ASPT_1_0_0_4 = new ASPT.resource.aspt.grammar.AsptPlaceholder(ASPT.ASPTPackage.eINSTANCE.getTraceNode().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NODE__ID), "INTEGER", ASPT.resource.aspt.grammar.AsptCardinality.ONE, 0);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_1_0_0_5 = new ASPT.resource.aspt.grammar.AsptKeyword(",", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptPlaceholder ASPT_1_0_0_6 = new ASPT.resource.aspt.grammar.AsptPlaceholder(ASPT.ASPTPackage.eINSTANCE.getTraceNode().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NODE__IDX), "QUOTED_34_34", ASPT.resource.aspt.grammar.AsptCardinality.ONE, 0);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_1_0_0_7 = new ASPT.resource.aspt.grammar.AsptKeyword(",", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptPlaceholder ASPT_1_0_0_8 = new ASPT.resource.aspt.grammar.AsptPlaceholder(ASPT.ASPTPackage.eINSTANCE.getTraceNode().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NODE__TYPE), "IDENTIFIER", ASPT.resource.aspt.grammar.AsptCardinality.ONE, 0);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_1_0_0_9 = new ASPT.resource.aspt.grammar.AsptKeyword(")", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_1_0_0_10 = new ASPT.resource.aspt.grammar.AsptKeyword(".", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptLineBreak ASPT_1_0_0_11 = new ASPT.resource.aspt.grammar.AsptLineBreak(ASPT.resource.aspt.grammar.AsptCardinality.ONE, 0);
	public final static ASPT.resource.aspt.grammar.AsptSequence ASPT_1_0_0 = new ASPT.resource.aspt.grammar.AsptSequence(ASPT.resource.aspt.grammar.AsptCardinality.ONE, ASPT_1_0_0_0, ASPT_1_0_0_1, ASPT_1_0_0_2, ASPT_1_0_0_3, ASPT_1_0_0_4, ASPT_1_0_0_5, ASPT_1_0_0_6, ASPT_1_0_0_7, ASPT_1_0_0_8, ASPT_1_0_0_9, ASPT_1_0_0_10, ASPT_1_0_0_11);
	public final static ASPT.resource.aspt.grammar.AsptChoice ASPT_1_0 = new ASPT.resource.aspt.grammar.AsptChoice(ASPT.resource.aspt.grammar.AsptCardinality.ONE, ASPT_1_0_0);
	public final static ASPT.resource.aspt.grammar.AsptRule ASPT_1 = new ASPT.resource.aspt.grammar.AsptRule(ASPT.ASPTPackage.eINSTANCE.getTraceNode(), ASPT_1_0, ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_2_0_0_0 = new ASPT.resource.aspt.grammar.AsptKeyword("trace_prop", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_2_0_0_1 = new ASPT.resource.aspt.grammar.AsptKeyword("(", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptPlaceholder ASPT_2_0_0_2 = new ASPT.resource.aspt.grammar.AsptPlaceholder(ASPT.ASPTPackage.eINSTANCE.getTraceProp().getEStructuralFeature(ASPT.ASPTPackage.TRACE_PROP__METAMODEL), "IDENTIFIER", ASPT.resource.aspt.grammar.AsptCardinality.ONE, 0);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_2_0_0_3 = new ASPT.resource.aspt.grammar.AsptKeyword(",", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptPlaceholder ASPT_2_0_0_4 = new ASPT.resource.aspt.grammar.AsptPlaceholder(ASPT.ASPTPackage.eINSTANCE.getTraceProp().getEStructuralFeature(ASPT.ASPTPackage.TRACE_PROP__ID), "INTEGER", ASPT.resource.aspt.grammar.AsptCardinality.ONE, 0);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_2_0_0_5 = new ASPT.resource.aspt.grammar.AsptKeyword(",", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptPlaceholder ASPT_2_0_0_6 = new ASPT.resource.aspt.grammar.AsptPlaceholder(ASPT.ASPTPackage.eINSTANCE.getTraceProp().getEStructuralFeature(ASPT.ASPTPackage.TRACE_PROP__IDX), "QUOTED_34_34", ASPT.resource.aspt.grammar.AsptCardinality.ONE, 0);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_2_0_0_7 = new ASPT.resource.aspt.grammar.AsptKeyword(",", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptPlaceholder ASPT_2_0_0_8 = new ASPT.resource.aspt.grammar.AsptPlaceholder(ASPT.ASPTPackage.eINSTANCE.getTraceProp().getEStructuralFeature(ASPT.ASPTPackage.TRACE_PROP__IDP), "INTEGER", ASPT.resource.aspt.grammar.AsptCardinality.ONE, 0);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_2_0_0_9 = new ASPT.resource.aspt.grammar.AsptKeyword(",", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptPlaceholder ASPT_2_0_0_10 = new ASPT.resource.aspt.grammar.AsptPlaceholder(ASPT.ASPTPackage.eINSTANCE.getTraceProp().getEStructuralFeature(ASPT.ASPTPackage.TRACE_PROP__IDPX), "QUOTED_34_34", ASPT.resource.aspt.grammar.AsptCardinality.ONE, 0);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_2_0_0_11 = new ASPT.resource.aspt.grammar.AsptKeyword(",", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptPlaceholder ASPT_2_0_0_12 = new ASPT.resource.aspt.grammar.AsptPlaceholder(ASPT.ASPTPackage.eINSTANCE.getTraceProp().getEStructuralFeature(ASPT.ASPTPackage.TRACE_PROP__TYPE), "IDENTIFIER", ASPT.resource.aspt.grammar.AsptCardinality.ONE, 0);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_2_0_0_13 = new ASPT.resource.aspt.grammar.AsptKeyword(",", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptPlaceholder ASPT_2_0_0_14 = new ASPT.resource.aspt.grammar.AsptPlaceholder(ASPT.ASPTPackage.eINSTANCE.getTraceProp().getEStructuralFeature(ASPT.ASPTPackage.TRACE_PROP__VALUE), "QUOTED_34_34", ASPT.resource.aspt.grammar.AsptCardinality.ONE, 0);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_2_0_0_15 = new ASPT.resource.aspt.grammar.AsptKeyword(")", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_2_0_0_16 = new ASPT.resource.aspt.grammar.AsptKeyword(".", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptLineBreak ASPT_2_0_0_17 = new ASPT.resource.aspt.grammar.AsptLineBreak(ASPT.resource.aspt.grammar.AsptCardinality.ONE, 0);
	public final static ASPT.resource.aspt.grammar.AsptSequence ASPT_2_0_0 = new ASPT.resource.aspt.grammar.AsptSequence(ASPT.resource.aspt.grammar.AsptCardinality.ONE, ASPT_2_0_0_0, ASPT_2_0_0_1, ASPT_2_0_0_2, ASPT_2_0_0_3, ASPT_2_0_0_4, ASPT_2_0_0_5, ASPT_2_0_0_6, ASPT_2_0_0_7, ASPT_2_0_0_8, ASPT_2_0_0_9, ASPT_2_0_0_10, ASPT_2_0_0_11, ASPT_2_0_0_12, ASPT_2_0_0_13, ASPT_2_0_0_14, ASPT_2_0_0_15, ASPT_2_0_0_16, ASPT_2_0_0_17);
	public final static ASPT.resource.aspt.grammar.AsptChoice ASPT_2_0 = new ASPT.resource.aspt.grammar.AsptChoice(ASPT.resource.aspt.grammar.AsptCardinality.ONE, ASPT_2_0_0);
	public final static ASPT.resource.aspt.grammar.AsptRule ASPT_2 = new ASPT.resource.aspt.grammar.AsptRule(ASPT.ASPTPackage.eINSTANCE.getTraceProp(), ASPT_2_0, ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_3_0_0_0 = new ASPT.resource.aspt.grammar.AsptKeyword("trace_edge", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_3_0_0_1 = new ASPT.resource.aspt.grammar.AsptKeyword("(", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptPlaceholder ASPT_3_0_0_2 = new ASPT.resource.aspt.grammar.AsptPlaceholder(ASPT.ASPTPackage.eINSTANCE.getTraceEdge().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__METAMODEL), "IDENTIFIER", ASPT.resource.aspt.grammar.AsptCardinality.ONE, 0);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_3_0_0_3 = new ASPT.resource.aspt.grammar.AsptKeyword(",", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptPlaceholder ASPT_3_0_0_4 = new ASPT.resource.aspt.grammar.AsptPlaceholder(ASPT.ASPTPackage.eINSTANCE.getTraceEdge().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__ID), "INTEGER", ASPT.resource.aspt.grammar.AsptCardinality.ONE, 0);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_3_0_0_5 = new ASPT.resource.aspt.grammar.AsptKeyword(",", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptPlaceholder ASPT_3_0_0_6 = new ASPT.resource.aspt.grammar.AsptPlaceholder(ASPT.ASPTPackage.eINSTANCE.getTraceEdge().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__IDX), "QUOTED_34_34", ASPT.resource.aspt.grammar.AsptCardinality.ONE, 0);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_3_0_0_7 = new ASPT.resource.aspt.grammar.AsptKeyword(",", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptPlaceholder ASPT_3_0_0_8 = new ASPT.resource.aspt.grammar.AsptPlaceholder(ASPT.ASPTPackage.eINSTANCE.getTraceEdge().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__TYPE), "IDENTIFIER", ASPT.resource.aspt.grammar.AsptCardinality.ONE, 0);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_3_0_0_9 = new ASPT.resource.aspt.grammar.AsptKeyword(",", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptPlaceholder ASPT_3_0_0_10 = new ASPT.resource.aspt.grammar.AsptPlaceholder(ASPT.ASPTPackage.eINSTANCE.getTraceEdge().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__IDS), "INTEGER", ASPT.resource.aspt.grammar.AsptCardinality.ONE, 0);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_3_0_0_11 = new ASPT.resource.aspt.grammar.AsptKeyword(",", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptPlaceholder ASPT_3_0_0_12 = new ASPT.resource.aspt.grammar.AsptPlaceholder(ASPT.ASPTPackage.eINSTANCE.getTraceEdge().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__IDSX), "QUOTED_34_34", ASPT.resource.aspt.grammar.AsptCardinality.ONE, 0);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_3_0_0_13 = new ASPT.resource.aspt.grammar.AsptKeyword(",", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptPlaceholder ASPT_3_0_0_14 = new ASPT.resource.aspt.grammar.AsptPlaceholder(ASPT.ASPTPackage.eINSTANCE.getTraceEdge().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__IDT), "INTEGER", ASPT.resource.aspt.grammar.AsptCardinality.ONE, 0);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_3_0_0_15 = new ASPT.resource.aspt.grammar.AsptKeyword(",", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptPlaceholder ASPT_3_0_0_16 = new ASPT.resource.aspt.grammar.AsptPlaceholder(ASPT.ASPTPackage.eINSTANCE.getTraceEdge().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__IDTX), "QUOTED_34_34", ASPT.resource.aspt.grammar.AsptCardinality.ONE, 0);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_3_0_0_17 = new ASPT.resource.aspt.grammar.AsptKeyword(")", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_3_0_0_18 = new ASPT.resource.aspt.grammar.AsptKeyword(".", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptLineBreak ASPT_3_0_0_19 = new ASPT.resource.aspt.grammar.AsptLineBreak(ASPT.resource.aspt.grammar.AsptCardinality.ONE, 0);
	public final static ASPT.resource.aspt.grammar.AsptSequence ASPT_3_0_0 = new ASPT.resource.aspt.grammar.AsptSequence(ASPT.resource.aspt.grammar.AsptCardinality.ONE, ASPT_3_0_0_0, ASPT_3_0_0_1, ASPT_3_0_0_2, ASPT_3_0_0_3, ASPT_3_0_0_4, ASPT_3_0_0_5, ASPT_3_0_0_6, ASPT_3_0_0_7, ASPT_3_0_0_8, ASPT_3_0_0_9, ASPT_3_0_0_10, ASPT_3_0_0_11, ASPT_3_0_0_12, ASPT_3_0_0_13, ASPT_3_0_0_14, ASPT_3_0_0_15, ASPT_3_0_0_16, ASPT_3_0_0_17, ASPT_3_0_0_18, ASPT_3_0_0_19);
	public final static ASPT.resource.aspt.grammar.AsptChoice ASPT_3_0 = new ASPT.resource.aspt.grammar.AsptChoice(ASPT.resource.aspt.grammar.AsptCardinality.ONE, ASPT_3_0_0);
	public final static ASPT.resource.aspt.grammar.AsptRule ASPT_3 = new ASPT.resource.aspt.grammar.AsptRule(ASPT.ASPTPackage.eINSTANCE.getTraceEdge(), ASPT_3_0, ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_4_0_0_0 = new ASPT.resource.aspt.grammar.AsptKeyword("trace_nb_edge", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_4_0_0_1 = new ASPT.resource.aspt.grammar.AsptKeyword("(", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptPlaceholder ASPT_4_0_0_2 = new ASPT.resource.aspt.grammar.AsptPlaceholder(ASPT.ASPTPackage.eINSTANCE.getTraceNbEdge().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__METAMODEL), "IDENTIFIER", ASPT.resource.aspt.grammar.AsptCardinality.ONE, 0);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_4_0_0_3 = new ASPT.resource.aspt.grammar.AsptKeyword(",", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptPlaceholder ASPT_4_0_0_4 = new ASPT.resource.aspt.grammar.AsptPlaceholder(ASPT.ASPTPackage.eINSTANCE.getTraceNbEdge().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__ID), "INTEGER", ASPT.resource.aspt.grammar.AsptCardinality.ONE, 0);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_4_0_0_5 = new ASPT.resource.aspt.grammar.AsptKeyword(",", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptPlaceholder ASPT_4_0_0_6 = new ASPT.resource.aspt.grammar.AsptPlaceholder(ASPT.ASPTPackage.eINSTANCE.getTraceNbEdge().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__IDX), "QUOTED_34_34", ASPT.resource.aspt.grammar.AsptCardinality.ONE, 0);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_4_0_0_7 = new ASPT.resource.aspt.grammar.AsptKeyword(",", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptPlaceholder ASPT_4_0_0_8 = new ASPT.resource.aspt.grammar.AsptPlaceholder(ASPT.ASPTPackage.eINSTANCE.getTraceNbEdge().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__TYPE), "IDENTIFIER", ASPT.resource.aspt.grammar.AsptCardinality.ONE, 0);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_4_0_0_9 = new ASPT.resource.aspt.grammar.AsptKeyword(",", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptPlaceholder ASPT_4_0_0_10 = new ASPT.resource.aspt.grammar.AsptPlaceholder(ASPT.ASPTPackage.eINSTANCE.getTraceNbEdge().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__IDS), "INTEGER", ASPT.resource.aspt.grammar.AsptCardinality.ONE, 0);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_4_0_0_11 = new ASPT.resource.aspt.grammar.AsptKeyword(",", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptPlaceholder ASPT_4_0_0_12 = new ASPT.resource.aspt.grammar.AsptPlaceholder(ASPT.ASPTPackage.eINSTANCE.getTraceNbEdge().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__IDSX), "QUOTED_34_34", ASPT.resource.aspt.grammar.AsptCardinality.ONE, 0);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_4_0_0_13 = new ASPT.resource.aspt.grammar.AsptKeyword(",", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptPlaceholder ASPT_4_0_0_14 = new ASPT.resource.aspt.grammar.AsptPlaceholder(ASPT.ASPTPackage.eINSTANCE.getTraceNbEdge().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__IDT), "INTEGER", ASPT.resource.aspt.grammar.AsptCardinality.ONE, 0);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_4_0_0_15 = new ASPT.resource.aspt.grammar.AsptKeyword(",", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptPlaceholder ASPT_4_0_0_16 = new ASPT.resource.aspt.grammar.AsptPlaceholder(ASPT.ASPTPackage.eINSTANCE.getTraceNbEdge().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__IDTX), "QUOTED_34_34", ASPT.resource.aspt.grammar.AsptCardinality.ONE, 0);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_4_0_0_17 = new ASPT.resource.aspt.grammar.AsptKeyword(")", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_4_0_0_18 = new ASPT.resource.aspt.grammar.AsptKeyword(".", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptLineBreak ASPT_4_0_0_19 = new ASPT.resource.aspt.grammar.AsptLineBreak(ASPT.resource.aspt.grammar.AsptCardinality.ONE, 0);
	public final static ASPT.resource.aspt.grammar.AsptSequence ASPT_4_0_0 = new ASPT.resource.aspt.grammar.AsptSequence(ASPT.resource.aspt.grammar.AsptCardinality.ONE, ASPT_4_0_0_0, ASPT_4_0_0_1, ASPT_4_0_0_2, ASPT_4_0_0_3, ASPT_4_0_0_4, ASPT_4_0_0_5, ASPT_4_0_0_6, ASPT_4_0_0_7, ASPT_4_0_0_8, ASPT_4_0_0_9, ASPT_4_0_0_10, ASPT_4_0_0_11, ASPT_4_0_0_12, ASPT_4_0_0_13, ASPT_4_0_0_14, ASPT_4_0_0_15, ASPT_4_0_0_16, ASPT_4_0_0_17, ASPT_4_0_0_18, ASPT_4_0_0_19);
	public final static ASPT.resource.aspt.grammar.AsptChoice ASPT_4_0 = new ASPT.resource.aspt.grammar.AsptChoice(ASPT.resource.aspt.grammar.AsptCardinality.ONE, ASPT_4_0_0);
	public final static ASPT.resource.aspt.grammar.AsptRule ASPT_4 = new ASPT.resource.aspt.grammar.AsptRule(ASPT.ASPTPackage.eINSTANCE.getTraceNbEdge(), ASPT_4_0, ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_5_0_0_0 = new ASPT.resource.aspt.grammar.AsptKeyword("trace_nb_prop", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_5_0_0_1 = new ASPT.resource.aspt.grammar.AsptKeyword("(", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptPlaceholder ASPT_5_0_0_2 = new ASPT.resource.aspt.grammar.AsptPlaceholder(ASPT.ASPTPackage.eINSTANCE.getTraceNbProp().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_PROP__METAMODEL), "IDENTIFIER", ASPT.resource.aspt.grammar.AsptCardinality.ONE, 0);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_5_0_0_3 = new ASPT.resource.aspt.grammar.AsptKeyword(",", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptPlaceholder ASPT_5_0_0_4 = new ASPT.resource.aspt.grammar.AsptPlaceholder(ASPT.ASPTPackage.eINSTANCE.getTraceNbProp().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_PROP__ID), "INTEGER", ASPT.resource.aspt.grammar.AsptCardinality.ONE, 0);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_5_0_0_5 = new ASPT.resource.aspt.grammar.AsptKeyword(",", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptPlaceholder ASPT_5_0_0_6 = new ASPT.resource.aspt.grammar.AsptPlaceholder(ASPT.ASPTPackage.eINSTANCE.getTraceNbProp().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_PROP__IDX), "QUOTED_34_34", ASPT.resource.aspt.grammar.AsptCardinality.ONE, 0);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_5_0_0_7 = new ASPT.resource.aspt.grammar.AsptKeyword(",", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptPlaceholder ASPT_5_0_0_8 = new ASPT.resource.aspt.grammar.AsptPlaceholder(ASPT.ASPTPackage.eINSTANCE.getTraceNbProp().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_PROP__IDP), "INTEGER", ASPT.resource.aspt.grammar.AsptCardinality.ONE, 0);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_5_0_0_9 = new ASPT.resource.aspt.grammar.AsptKeyword(",", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptPlaceholder ASPT_5_0_0_10 = new ASPT.resource.aspt.grammar.AsptPlaceholder(ASPT.ASPTPackage.eINSTANCE.getTraceNbProp().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_PROP__IDPX), "QUOTED_34_34", ASPT.resource.aspt.grammar.AsptCardinality.ONE, 0);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_5_0_0_11 = new ASPT.resource.aspt.grammar.AsptKeyword(",", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptPlaceholder ASPT_5_0_0_12 = new ASPT.resource.aspt.grammar.AsptPlaceholder(ASPT.ASPTPackage.eINSTANCE.getTraceNbProp().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_PROP__TYPE), "IDENTIFIER", ASPT.resource.aspt.grammar.AsptCardinality.ONE, 0);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_5_0_0_13 = new ASPT.resource.aspt.grammar.AsptKeyword(",", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptPlaceholder ASPT_5_0_0_14 = new ASPT.resource.aspt.grammar.AsptPlaceholder(ASPT.ASPTPackage.eINSTANCE.getTraceNbProp().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_PROP__VALUE), "QUOTED_34_34", ASPT.resource.aspt.grammar.AsptCardinality.ONE, 0);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_5_0_0_15 = new ASPT.resource.aspt.grammar.AsptKeyword(")", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_5_0_0_16 = new ASPT.resource.aspt.grammar.AsptKeyword(".", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptLineBreak ASPT_5_0_0_17 = new ASPT.resource.aspt.grammar.AsptLineBreak(ASPT.resource.aspt.grammar.AsptCardinality.ONE, 0);
	public final static ASPT.resource.aspt.grammar.AsptSequence ASPT_5_0_0 = new ASPT.resource.aspt.grammar.AsptSequence(ASPT.resource.aspt.grammar.AsptCardinality.ONE, ASPT_5_0_0_0, ASPT_5_0_0_1, ASPT_5_0_0_2, ASPT_5_0_0_3, ASPT_5_0_0_4, ASPT_5_0_0_5, ASPT_5_0_0_6, ASPT_5_0_0_7, ASPT_5_0_0_8, ASPT_5_0_0_9, ASPT_5_0_0_10, ASPT_5_0_0_11, ASPT_5_0_0_12, ASPT_5_0_0_13, ASPT_5_0_0_14, ASPT_5_0_0_15, ASPT_5_0_0_16, ASPT_5_0_0_17);
	public final static ASPT.resource.aspt.grammar.AsptChoice ASPT_5_0 = new ASPT.resource.aspt.grammar.AsptChoice(ASPT.resource.aspt.grammar.AsptCardinality.ONE, ASPT_5_0_0);
	public final static ASPT.resource.aspt.grammar.AsptRule ASPT_5 = new ASPT.resource.aspt.grammar.AsptRule(ASPT.ASPTPackage.eINSTANCE.getTraceNbProp(), ASPT_5_0, ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_6_0_0_0 = new ASPT.resource.aspt.grammar.AsptKeyword("trace_nb_node", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_6_0_0_1 = new ASPT.resource.aspt.grammar.AsptKeyword("(", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptPlaceholder ASPT_6_0_0_2 = new ASPT.resource.aspt.grammar.AsptPlaceholder(ASPT.ASPTPackage.eINSTANCE.getTraceNbNode().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_NODE__METAMODEL), "IDENTIFIER", ASPT.resource.aspt.grammar.AsptCardinality.ONE, 0);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_6_0_0_3 = new ASPT.resource.aspt.grammar.AsptKeyword(",", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptPlaceholder ASPT_6_0_0_4 = new ASPT.resource.aspt.grammar.AsptPlaceholder(ASPT.ASPTPackage.eINSTANCE.getTraceNbNode().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_NODE__ID), "INTEGER", ASPT.resource.aspt.grammar.AsptCardinality.ONE, 0);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_6_0_0_5 = new ASPT.resource.aspt.grammar.AsptKeyword(",", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptPlaceholder ASPT_6_0_0_6 = new ASPT.resource.aspt.grammar.AsptPlaceholder(ASPT.ASPTPackage.eINSTANCE.getTraceNbNode().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_NODE__IDX), "QUOTED_34_34", ASPT.resource.aspt.grammar.AsptCardinality.ONE, 0);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_6_0_0_7 = new ASPT.resource.aspt.grammar.AsptKeyword(",", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptPlaceholder ASPT_6_0_0_8 = new ASPT.resource.aspt.grammar.AsptPlaceholder(ASPT.ASPTPackage.eINSTANCE.getTraceNbNode().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_NODE__TYPE), "IDENTIFIER", ASPT.resource.aspt.grammar.AsptCardinality.ONE, 0);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_6_0_0_9 = new ASPT.resource.aspt.grammar.AsptKeyword(")", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_6_0_0_10 = new ASPT.resource.aspt.grammar.AsptKeyword(".", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptLineBreak ASPT_6_0_0_11 = new ASPT.resource.aspt.grammar.AsptLineBreak(ASPT.resource.aspt.grammar.AsptCardinality.ONE, 0);
	public final static ASPT.resource.aspt.grammar.AsptSequence ASPT_6_0_0 = new ASPT.resource.aspt.grammar.AsptSequence(ASPT.resource.aspt.grammar.AsptCardinality.ONE, ASPT_6_0_0_0, ASPT_6_0_0_1, ASPT_6_0_0_2, ASPT_6_0_0_3, ASPT_6_0_0_4, ASPT_6_0_0_5, ASPT_6_0_0_6, ASPT_6_0_0_7, ASPT_6_0_0_8, ASPT_6_0_0_9, ASPT_6_0_0_10, ASPT_6_0_0_11);
	public final static ASPT.resource.aspt.grammar.AsptChoice ASPT_6_0 = new ASPT.resource.aspt.grammar.AsptChoice(ASPT.resource.aspt.grammar.AsptCardinality.ONE, ASPT_6_0_0);
	public final static ASPT.resource.aspt.grammar.AsptRule ASPT_6 = new ASPT.resource.aspt.grammar.AsptRule(ASPT.ASPTPackage.eINSTANCE.getTraceNbNode(), ASPT_6_0, ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_7_0_0_0 = new ASPT.resource.aspt.grammar.AsptKeyword("trace_link", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_7_0_0_1 = new ASPT.resource.aspt.grammar.AsptKeyword("(", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptPlaceholder ASPT_7_0_0_2 = new ASPT.resource.aspt.grammar.AsptPlaceholder(ASPT.ASPTPackage.eINSTANCE.getTraceLink().getEStructuralFeature(ASPT.ASPTPackage.TRACE_LINK__METAMODEL), "IDENTIFIER", ASPT.resource.aspt.grammar.AsptCardinality.ONE, 0);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_7_0_0_3 = new ASPT.resource.aspt.grammar.AsptKeyword(",", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptPlaceholder ASPT_7_0_0_4 = new ASPT.resource.aspt.grammar.AsptPlaceholder(ASPT.ASPTPackage.eINSTANCE.getTraceLink().getEStructuralFeature(ASPT.ASPTPackage.TRACE_LINK__ID), "INTEGER", ASPT.resource.aspt.grammar.AsptCardinality.ONE, 0);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_7_0_0_5 = new ASPT.resource.aspt.grammar.AsptKeyword(",", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptPlaceholder ASPT_7_0_0_6 = new ASPT.resource.aspt.grammar.AsptPlaceholder(ASPT.ASPTPackage.eINSTANCE.getTraceLink().getEStructuralFeature(ASPT.ASPTPackage.TRACE_LINK__IDX), "QUOTED_34_34", ASPT.resource.aspt.grammar.AsptCardinality.ONE, 0);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_7_0_0_7 = new ASPT.resource.aspt.grammar.AsptKeyword(",", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptPlaceholder ASPT_7_0_0_8 = new ASPT.resource.aspt.grammar.AsptPlaceholder(ASPT.ASPTPackage.eINSTANCE.getTraceLink().getEStructuralFeature(ASPT.ASPTPackage.TRACE_LINK__TYPE), "IDENTIFIER", ASPT.resource.aspt.grammar.AsptCardinality.ONE, 0);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_7_0_0_9 = new ASPT.resource.aspt.grammar.AsptKeyword(",", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptPlaceholder ASPT_7_0_0_10 = new ASPT.resource.aspt.grammar.AsptPlaceholder(ASPT.ASPTPackage.eINSTANCE.getTraceLink().getEStructuralFeature(ASPT.ASPTPackage.TRACE_LINK__RELATION), "QUOTED_34_34", ASPT.resource.aspt.grammar.AsptCardinality.ONE, 0);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_7_0_0_11 = new ASPT.resource.aspt.grammar.AsptKeyword(")", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptKeyword ASPT_7_0_0_12 = new ASPT.resource.aspt.grammar.AsptKeyword(".", ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	public final static ASPT.resource.aspt.grammar.AsptLineBreak ASPT_7_0_0_13 = new ASPT.resource.aspt.grammar.AsptLineBreak(ASPT.resource.aspt.grammar.AsptCardinality.ONE, 0);
	public final static ASPT.resource.aspt.grammar.AsptSequence ASPT_7_0_0 = new ASPT.resource.aspt.grammar.AsptSequence(ASPT.resource.aspt.grammar.AsptCardinality.ONE, ASPT_7_0_0_0, ASPT_7_0_0_1, ASPT_7_0_0_2, ASPT_7_0_0_3, ASPT_7_0_0_4, ASPT_7_0_0_5, ASPT_7_0_0_6, ASPT_7_0_0_7, ASPT_7_0_0_8, ASPT_7_0_0_9, ASPT_7_0_0_10, ASPT_7_0_0_11, ASPT_7_0_0_12, ASPT_7_0_0_13);
	public final static ASPT.resource.aspt.grammar.AsptChoice ASPT_7_0 = new ASPT.resource.aspt.grammar.AsptChoice(ASPT.resource.aspt.grammar.AsptCardinality.ONE, ASPT_7_0_0);
	public final static ASPT.resource.aspt.grammar.AsptRule ASPT_7 = new ASPT.resource.aspt.grammar.AsptRule(ASPT.ASPTPackage.eINSTANCE.getTraceLink(), ASPT_7_0, ASPT.resource.aspt.grammar.AsptCardinality.ONE);
	
	public static String getSyntaxElementID(ASPT.resource.aspt.grammar.AsptSyntaxElement syntaxElement) {
		if (syntaxElement == null) {
			// null indicates EOF
			return "<EOF>";
		}
		for (java.lang.reflect.Field field : ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.class.getFields()) {
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
	
	public static ASPT.resource.aspt.grammar.AsptSyntaxElement getSyntaxElementByID(String syntaxElementID) {
		try {
			return (ASPT.resource.aspt.grammar.AsptSyntaxElement) ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.class.getField(syntaxElementID).get(null);
		} catch (Exception e) {
			return null;
		}
	}
	
	public final static ASPT.resource.aspt.grammar.AsptRule[] RULES = new ASPT.resource.aspt.grammar.AsptRule[] {
		ASPT_0,
		ASPT_1,
		ASPT_2,
		ASPT_3,
		ASPT_4,
		ASPT_5,
		ASPT_6,
		ASPT_7,
	};
	
	/**
	 * Returns all keywords of the grammar. This includes all literals for boolean and
	 * enumeration terminals.
	 */
	public java.util.Set<String> getKeywords() {
		if (this.keywords == null) {
			this.keywords = new java.util.LinkedHashSet<String>();
			for (ASPT.resource.aspt.grammar.AsptRule rule : RULES) {
				findKeywords(rule, this.keywords);
			}
		}
		return keywords;
	}
	
	/**
	 * Finds all keywords in the given element and its children and adds them to the
	 * set. This includes all literals for boolean and enumeration terminals.
	 */
	private void findKeywords(ASPT.resource.aspt.grammar.AsptSyntaxElement element, java.util.Set<String> keywords) {
		if (element instanceof ASPT.resource.aspt.grammar.AsptKeyword) {
			keywords.add(((ASPT.resource.aspt.grammar.AsptKeyword) element).getValue());
		} else if (element instanceof ASPT.resource.aspt.grammar.AsptBooleanTerminal) {
			keywords.add(((ASPT.resource.aspt.grammar.AsptBooleanTerminal) element).getTrueLiteral());
			keywords.add(((ASPT.resource.aspt.grammar.AsptBooleanTerminal) element).getFalseLiteral());
		} else if (element instanceof ASPT.resource.aspt.grammar.AsptEnumerationTerminal) {
			ASPT.resource.aspt.grammar.AsptEnumerationTerminal terminal = (ASPT.resource.aspt.grammar.AsptEnumerationTerminal) element;
			for (String key : terminal.getLiteralMapping().keySet()) {
				keywords.add(key);
			}
		}
		for (ASPT.resource.aspt.grammar.AsptSyntaxElement child : element.getChildren()) {
			findKeywords(child, this.keywords);
		}
	}
	
}
