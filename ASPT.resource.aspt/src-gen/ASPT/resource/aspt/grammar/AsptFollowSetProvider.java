/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPT.resource.aspt.grammar;

/**
 * This class provides the follow sets for all terminals of the grammar. These
 * sets are used during code completion.
 */
public class AsptFollowSetProvider {
	
	public final static ASPT.resource.aspt.IAsptExpectedElement TERMINALS[] = new ASPT.resource.aspt.IAsptExpectedElement[98];
	
	public final static org.eclipse.emf.ecore.EStructuralFeature[] FEATURES = new org.eclipse.emf.ecore.EStructuralFeature[1];
	
	public final static ASPT.resource.aspt.mopp.AsptContainedFeature[] LINKS = new ASPT.resource.aspt.mopp.AsptContainedFeature[77];
	
	public final static ASPT.resource.aspt.mopp.AsptContainedFeature[] EMPTY_LINK_ARRAY = new ASPT.resource.aspt.mopp.AsptContainedFeature[0];
	
	public static void initializeTerminals0() {
		TERMINALS[0] = new ASPT.resource.aspt.mopp.AsptExpectedCsString(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_0_0_0_0);
		TERMINALS[1] = new ASPT.resource.aspt.mopp.AsptExpectedStructuralFeature(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_0_0_0_1);
		TERMINALS[2] = new ASPT.resource.aspt.mopp.AsptExpectedCsString(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_0_0_0_2);
		TERMINALS[3] = new ASPT.resource.aspt.mopp.AsptExpectedStructuralFeature(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_0_0_0_3);
		TERMINALS[4] = new ASPT.resource.aspt.mopp.AsptExpectedCsString(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_0_0_0_4);
		TERMINALS[5] = new ASPT.resource.aspt.mopp.AsptExpectedCsString(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_1_0_0_0);
		TERMINALS[6] = new ASPT.resource.aspt.mopp.AsptExpectedCsString(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_2_0_0_0);
		TERMINALS[7] = new ASPT.resource.aspt.mopp.AsptExpectedCsString(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_0);
		TERMINALS[8] = new ASPT.resource.aspt.mopp.AsptExpectedCsString(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_0);
		TERMINALS[9] = new ASPT.resource.aspt.mopp.AsptExpectedCsString(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_5_0_0_0);
		TERMINALS[10] = new ASPT.resource.aspt.mopp.AsptExpectedCsString(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_6_0_0_0);
		TERMINALS[11] = new ASPT.resource.aspt.mopp.AsptExpectedCsString(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_7_0_0_0);
		TERMINALS[12] = new ASPT.resource.aspt.mopp.AsptExpectedStructuralFeature(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_1_0_0_1);
		TERMINALS[13] = new ASPT.resource.aspt.mopp.AsptExpectedCsString(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_1_0_0_2);
		TERMINALS[14] = new ASPT.resource.aspt.mopp.AsptExpectedStructuralFeature(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_1_0_0_3);
		TERMINALS[15] = new ASPT.resource.aspt.mopp.AsptExpectedCsString(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_1_0_0_4);
		TERMINALS[16] = new ASPT.resource.aspt.mopp.AsptExpectedStructuralFeature(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_1_0_0_5);
		TERMINALS[17] = new ASPT.resource.aspt.mopp.AsptExpectedCsString(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_1_0_0_6);
		TERMINALS[18] = new ASPT.resource.aspt.mopp.AsptExpectedStructuralFeature(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_1_0_0_7);
		TERMINALS[19] = new ASPT.resource.aspt.mopp.AsptExpectedCsString(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_1_0_0_8);
		TERMINALS[20] = new ASPT.resource.aspt.mopp.AsptExpectedStructuralFeature(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_2_0_0_1);
		TERMINALS[21] = new ASPT.resource.aspt.mopp.AsptExpectedCsString(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_2_0_0_2);
		TERMINALS[22] = new ASPT.resource.aspt.mopp.AsptExpectedStructuralFeature(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_2_0_0_3);
		TERMINALS[23] = new ASPT.resource.aspt.mopp.AsptExpectedCsString(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_2_0_0_4);
		TERMINALS[24] = new ASPT.resource.aspt.mopp.AsptExpectedStructuralFeature(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_2_0_0_5);
		TERMINALS[25] = new ASPT.resource.aspt.mopp.AsptExpectedCsString(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_2_0_0_6);
		TERMINALS[26] = new ASPT.resource.aspt.mopp.AsptExpectedStructuralFeature(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_2_0_0_7);
		TERMINALS[27] = new ASPT.resource.aspt.mopp.AsptExpectedCsString(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_2_0_0_8);
		TERMINALS[28] = new ASPT.resource.aspt.mopp.AsptExpectedStructuralFeature(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_2_0_0_9);
		TERMINALS[29] = new ASPT.resource.aspt.mopp.AsptExpectedCsString(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_2_0_0_10);
		TERMINALS[30] = new ASPT.resource.aspt.mopp.AsptExpectedStructuralFeature(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_2_0_0_11);
		TERMINALS[31] = new ASPT.resource.aspt.mopp.AsptExpectedCsString(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_2_0_0_12);
		TERMINALS[32] = new ASPT.resource.aspt.mopp.AsptExpectedStructuralFeature(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_2_0_0_13);
		TERMINALS[33] = new ASPT.resource.aspt.mopp.AsptExpectedCsString(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_2_0_0_14);
		TERMINALS[34] = new ASPT.resource.aspt.mopp.AsptExpectedStructuralFeature(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_1);
		TERMINALS[35] = new ASPT.resource.aspt.mopp.AsptExpectedCsString(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_2);
		TERMINALS[36] = new ASPT.resource.aspt.mopp.AsptExpectedStructuralFeature(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_3);
		TERMINALS[37] = new ASPT.resource.aspt.mopp.AsptExpectedCsString(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_4);
		TERMINALS[38] = new ASPT.resource.aspt.mopp.AsptExpectedStructuralFeature(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_5);
		TERMINALS[39] = new ASPT.resource.aspt.mopp.AsptExpectedCsString(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_6);
		TERMINALS[40] = new ASPT.resource.aspt.mopp.AsptExpectedStructuralFeature(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_7);
		TERMINALS[41] = new ASPT.resource.aspt.mopp.AsptExpectedCsString(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_8);
		TERMINALS[42] = new ASPT.resource.aspt.mopp.AsptExpectedStructuralFeature(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_9);
		TERMINALS[43] = new ASPT.resource.aspt.mopp.AsptExpectedCsString(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_10);
		TERMINALS[44] = new ASPT.resource.aspt.mopp.AsptExpectedStructuralFeature(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_11);
		TERMINALS[45] = new ASPT.resource.aspt.mopp.AsptExpectedCsString(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_12);
		TERMINALS[46] = new ASPT.resource.aspt.mopp.AsptExpectedStructuralFeature(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_13);
		TERMINALS[47] = new ASPT.resource.aspt.mopp.AsptExpectedCsString(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_14);
		TERMINALS[48] = new ASPT.resource.aspt.mopp.AsptExpectedStructuralFeature(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_15);
		TERMINALS[49] = new ASPT.resource.aspt.mopp.AsptExpectedCsString(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_16);
		TERMINALS[50] = new ASPT.resource.aspt.mopp.AsptExpectedStructuralFeature(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_1);
		TERMINALS[51] = new ASPT.resource.aspt.mopp.AsptExpectedCsString(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_2);
		TERMINALS[52] = new ASPT.resource.aspt.mopp.AsptExpectedStructuralFeature(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_3);
		TERMINALS[53] = new ASPT.resource.aspt.mopp.AsptExpectedCsString(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_4);
		TERMINALS[54] = new ASPT.resource.aspt.mopp.AsptExpectedStructuralFeature(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_5);
		TERMINALS[55] = new ASPT.resource.aspt.mopp.AsptExpectedCsString(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_6);
		TERMINALS[56] = new ASPT.resource.aspt.mopp.AsptExpectedStructuralFeature(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_7);
		TERMINALS[57] = new ASPT.resource.aspt.mopp.AsptExpectedCsString(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_8);
		TERMINALS[58] = new ASPT.resource.aspt.mopp.AsptExpectedStructuralFeature(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_9);
		TERMINALS[59] = new ASPT.resource.aspt.mopp.AsptExpectedCsString(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_10);
		TERMINALS[60] = new ASPT.resource.aspt.mopp.AsptExpectedStructuralFeature(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_11);
		TERMINALS[61] = new ASPT.resource.aspt.mopp.AsptExpectedCsString(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_12);
		TERMINALS[62] = new ASPT.resource.aspt.mopp.AsptExpectedStructuralFeature(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_13);
		TERMINALS[63] = new ASPT.resource.aspt.mopp.AsptExpectedCsString(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_14);
		TERMINALS[64] = new ASPT.resource.aspt.mopp.AsptExpectedStructuralFeature(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_15);
		TERMINALS[65] = new ASPT.resource.aspt.mopp.AsptExpectedCsString(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_16);
		TERMINALS[66] = new ASPT.resource.aspt.mopp.AsptExpectedStructuralFeature(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_5_0_0_1);
		TERMINALS[67] = new ASPT.resource.aspt.mopp.AsptExpectedCsString(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_5_0_0_2);
		TERMINALS[68] = new ASPT.resource.aspt.mopp.AsptExpectedStructuralFeature(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_5_0_0_3);
		TERMINALS[69] = new ASPT.resource.aspt.mopp.AsptExpectedCsString(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_5_0_0_4);
		TERMINALS[70] = new ASPT.resource.aspt.mopp.AsptExpectedStructuralFeature(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_5_0_0_5);
		TERMINALS[71] = new ASPT.resource.aspt.mopp.AsptExpectedCsString(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_5_0_0_6);
		TERMINALS[72] = new ASPT.resource.aspt.mopp.AsptExpectedStructuralFeature(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_5_0_0_7);
		TERMINALS[73] = new ASPT.resource.aspt.mopp.AsptExpectedCsString(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_5_0_0_8);
		TERMINALS[74] = new ASPT.resource.aspt.mopp.AsptExpectedStructuralFeature(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_5_0_0_9);
		TERMINALS[75] = new ASPT.resource.aspt.mopp.AsptExpectedCsString(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_5_0_0_10);
		TERMINALS[76] = new ASPT.resource.aspt.mopp.AsptExpectedStructuralFeature(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_5_0_0_11);
		TERMINALS[77] = new ASPT.resource.aspt.mopp.AsptExpectedCsString(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_5_0_0_12);
		TERMINALS[78] = new ASPT.resource.aspt.mopp.AsptExpectedStructuralFeature(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_5_0_0_13);
		TERMINALS[79] = new ASPT.resource.aspt.mopp.AsptExpectedCsString(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_5_0_0_14);
		TERMINALS[80] = new ASPT.resource.aspt.mopp.AsptExpectedStructuralFeature(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_6_0_0_1);
		TERMINALS[81] = new ASPT.resource.aspt.mopp.AsptExpectedCsString(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_6_0_0_2);
		TERMINALS[82] = new ASPT.resource.aspt.mopp.AsptExpectedStructuralFeature(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_6_0_0_3);
		TERMINALS[83] = new ASPT.resource.aspt.mopp.AsptExpectedCsString(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_6_0_0_4);
		TERMINALS[84] = new ASPT.resource.aspt.mopp.AsptExpectedStructuralFeature(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_6_0_0_5);
		TERMINALS[85] = new ASPT.resource.aspt.mopp.AsptExpectedCsString(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_6_0_0_6);
		TERMINALS[86] = new ASPT.resource.aspt.mopp.AsptExpectedStructuralFeature(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_6_0_0_7);
		TERMINALS[87] = new ASPT.resource.aspt.mopp.AsptExpectedCsString(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_6_0_0_8);
		TERMINALS[88] = new ASPT.resource.aspt.mopp.AsptExpectedStructuralFeature(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_7_0_0_1);
		TERMINALS[89] = new ASPT.resource.aspt.mopp.AsptExpectedCsString(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_7_0_0_2);
		TERMINALS[90] = new ASPT.resource.aspt.mopp.AsptExpectedStructuralFeature(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_7_0_0_3);
		TERMINALS[91] = new ASPT.resource.aspt.mopp.AsptExpectedCsString(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_7_0_0_4);
		TERMINALS[92] = new ASPT.resource.aspt.mopp.AsptExpectedStructuralFeature(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_7_0_0_5);
		TERMINALS[93] = new ASPT.resource.aspt.mopp.AsptExpectedCsString(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_7_0_0_6);
		TERMINALS[94] = new ASPT.resource.aspt.mopp.AsptExpectedStructuralFeature(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_7_0_0_7);
		TERMINALS[95] = new ASPT.resource.aspt.mopp.AsptExpectedCsString(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_7_0_0_8);
		TERMINALS[96] = new ASPT.resource.aspt.mopp.AsptExpectedStructuralFeature(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_7_0_0_9);
		TERMINALS[97] = new ASPT.resource.aspt.mopp.AsptExpectedCsString(ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_7_0_0_10);
	}
	
	public static void initializeTerminals() {
		initializeTerminals0();
	}
	
	public static void initializeFeatures0() {
		FEATURES[0] = ASPT.ASPTPackage.eINSTANCE.getTraceModel().getEStructuralFeature(ASPT.ASPTPackage.TRACE_MODEL__TRACEELEMENTS);
	}
	
	public static void initializeFeatures() {
		initializeFeatures0();
	}
	
	public static void initializeLinks0() {
		LINKS[0] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNode(), FEATURES[0]);
		LINKS[1] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceProp(), FEATURES[0]);
		LINKS[2] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceEdge(), FEATURES[0]);
		LINKS[3] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNbEdge(), FEATURES[0]);
		LINKS[4] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNbProp(), FEATURES[0]);
		LINKS[5] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNbNode(), FEATURES[0]);
		LINKS[6] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceLink(), FEATURES[0]);
		LINKS[7] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNode(), FEATURES[0]);
		LINKS[8] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceProp(), FEATURES[0]);
		LINKS[9] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceEdge(), FEATURES[0]);
		LINKS[10] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNbEdge(), FEATURES[0]);
		LINKS[11] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNbProp(), FEATURES[0]);
		LINKS[12] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNbNode(), FEATURES[0]);
		LINKS[13] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceLink(), FEATURES[0]);
		LINKS[14] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNode(), FEATURES[0]);
		LINKS[15] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceProp(), FEATURES[0]);
		LINKS[16] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceEdge(), FEATURES[0]);
		LINKS[17] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNbEdge(), FEATURES[0]);
		LINKS[18] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNbProp(), FEATURES[0]);
		LINKS[19] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNbNode(), FEATURES[0]);
		LINKS[20] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceLink(), FEATURES[0]);
		LINKS[21] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNode(), FEATURES[0]);
		LINKS[22] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceProp(), FEATURES[0]);
		LINKS[23] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceEdge(), FEATURES[0]);
		LINKS[24] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNbEdge(), FEATURES[0]);
		LINKS[25] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNbProp(), FEATURES[0]);
		LINKS[26] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNbNode(), FEATURES[0]);
		LINKS[27] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceLink(), FEATURES[0]);
		LINKS[28] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNode(), FEATURES[0]);
		LINKS[29] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceProp(), FEATURES[0]);
		LINKS[30] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceEdge(), FEATURES[0]);
		LINKS[31] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNbEdge(), FEATURES[0]);
		LINKS[32] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNbProp(), FEATURES[0]);
		LINKS[33] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNbNode(), FEATURES[0]);
		LINKS[34] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceLink(), FEATURES[0]);
		LINKS[35] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNode(), FEATURES[0]);
		LINKS[36] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceProp(), FEATURES[0]);
		LINKS[37] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceEdge(), FEATURES[0]);
		LINKS[38] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNbEdge(), FEATURES[0]);
		LINKS[39] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNbProp(), FEATURES[0]);
		LINKS[40] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNbNode(), FEATURES[0]);
		LINKS[41] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceLink(), FEATURES[0]);
		LINKS[42] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNode(), FEATURES[0]);
		LINKS[43] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceProp(), FEATURES[0]);
		LINKS[44] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceEdge(), FEATURES[0]);
		LINKS[45] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNbEdge(), FEATURES[0]);
		LINKS[46] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNbProp(), FEATURES[0]);
		LINKS[47] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNbNode(), FEATURES[0]);
		LINKS[48] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceLink(), FEATURES[0]);
		LINKS[49] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNode(), FEATURES[0]);
		LINKS[50] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceProp(), FEATURES[0]);
		LINKS[51] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceEdge(), FEATURES[0]);
		LINKS[52] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNbEdge(), FEATURES[0]);
		LINKS[53] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNbProp(), FEATURES[0]);
		LINKS[54] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNbNode(), FEATURES[0]);
		LINKS[55] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceLink(), FEATURES[0]);
		LINKS[56] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNode(), FEATURES[0]);
		LINKS[57] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceProp(), FEATURES[0]);
		LINKS[58] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceEdge(), FEATURES[0]);
		LINKS[59] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNbEdge(), FEATURES[0]);
		LINKS[60] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNbProp(), FEATURES[0]);
		LINKS[61] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNbNode(), FEATURES[0]);
		LINKS[62] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceLink(), FEATURES[0]);
		LINKS[63] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNode(), FEATURES[0]);
		LINKS[64] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceProp(), FEATURES[0]);
		LINKS[65] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceEdge(), FEATURES[0]);
		LINKS[66] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNbEdge(), FEATURES[0]);
		LINKS[67] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNbProp(), FEATURES[0]);
		LINKS[68] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNbNode(), FEATURES[0]);
		LINKS[69] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceLink(), FEATURES[0]);
		LINKS[70] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNode(), FEATURES[0]);
		LINKS[71] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceProp(), FEATURES[0]);
		LINKS[72] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceEdge(), FEATURES[0]);
		LINKS[73] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNbEdge(), FEATURES[0]);
		LINKS[74] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNbProp(), FEATURES[0]);
		LINKS[75] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNbNode(), FEATURES[0]);
		LINKS[76] = new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceLink(), FEATURES[0]);
	}
	
	public static void initializeLinks() {
		initializeLinks0();
	}
	
	public static void wire0() {
		TERMINALS[0].addFollower(TERMINALS[1], EMPTY_LINK_ARRAY);
		TERMINALS[1].addFollower(TERMINALS[2], EMPTY_LINK_ARRAY);
		TERMINALS[2].addFollower(TERMINALS[3], EMPTY_LINK_ARRAY);
		TERMINALS[3].addFollower(TERMINALS[4], EMPTY_LINK_ARRAY);
		TERMINALS[4].addFollower(TERMINALS[5], new ASPT.resource.aspt.mopp.AsptContainedFeature[] {new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNode(), FEATURES[0]), });
		TERMINALS[4].addFollower(TERMINALS[6], new ASPT.resource.aspt.mopp.AsptContainedFeature[] {new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceProp(), FEATURES[0]), });
		TERMINALS[4].addFollower(TERMINALS[7], new ASPT.resource.aspt.mopp.AsptContainedFeature[] {new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceEdge(), FEATURES[0]), });
		TERMINALS[4].addFollower(TERMINALS[8], new ASPT.resource.aspt.mopp.AsptContainedFeature[] {new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNbEdge(), FEATURES[0]), });
		TERMINALS[4].addFollower(TERMINALS[9], new ASPT.resource.aspt.mopp.AsptContainedFeature[] {new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNbProp(), FEATURES[0]), });
		TERMINALS[4].addFollower(TERMINALS[10], new ASPT.resource.aspt.mopp.AsptContainedFeature[] {new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNbNode(), FEATURES[0]), });
		TERMINALS[4].addFollower(TERMINALS[11], new ASPT.resource.aspt.mopp.AsptContainedFeature[] {new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceLink(), FEATURES[0]), });
		TERMINALS[5].addFollower(TERMINALS[12], EMPTY_LINK_ARRAY);
		TERMINALS[12].addFollower(TERMINALS[13], EMPTY_LINK_ARRAY);
		TERMINALS[13].addFollower(TERMINALS[14], EMPTY_LINK_ARRAY);
		TERMINALS[14].addFollower(TERMINALS[15], EMPTY_LINK_ARRAY);
		TERMINALS[15].addFollower(TERMINALS[16], EMPTY_LINK_ARRAY);
		TERMINALS[16].addFollower(TERMINALS[17], EMPTY_LINK_ARRAY);
		TERMINALS[17].addFollower(TERMINALS[18], EMPTY_LINK_ARRAY);
		TERMINALS[18].addFollower(TERMINALS[19], EMPTY_LINK_ARRAY);
		TERMINALS[19].addFollower(TERMINALS[5], new ASPT.resource.aspt.mopp.AsptContainedFeature[] {new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNode(), FEATURES[0]), });
		TERMINALS[19].addFollower(TERMINALS[6], new ASPT.resource.aspt.mopp.AsptContainedFeature[] {new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceProp(), FEATURES[0]), });
		TERMINALS[19].addFollower(TERMINALS[7], new ASPT.resource.aspt.mopp.AsptContainedFeature[] {new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceEdge(), FEATURES[0]), });
		TERMINALS[19].addFollower(TERMINALS[8], new ASPT.resource.aspt.mopp.AsptContainedFeature[] {new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNbEdge(), FEATURES[0]), });
		TERMINALS[19].addFollower(TERMINALS[9], new ASPT.resource.aspt.mopp.AsptContainedFeature[] {new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNbProp(), FEATURES[0]), });
		TERMINALS[19].addFollower(TERMINALS[10], new ASPT.resource.aspt.mopp.AsptContainedFeature[] {new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNbNode(), FEATURES[0]), });
		TERMINALS[19].addFollower(TERMINALS[11], new ASPT.resource.aspt.mopp.AsptContainedFeature[] {new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceLink(), FEATURES[0]), });
		TERMINALS[6].addFollower(TERMINALS[20], EMPTY_LINK_ARRAY);
		TERMINALS[20].addFollower(TERMINALS[21], EMPTY_LINK_ARRAY);
		TERMINALS[21].addFollower(TERMINALS[22], EMPTY_LINK_ARRAY);
		TERMINALS[22].addFollower(TERMINALS[23], EMPTY_LINK_ARRAY);
		TERMINALS[23].addFollower(TERMINALS[24], EMPTY_LINK_ARRAY);
		TERMINALS[24].addFollower(TERMINALS[25], EMPTY_LINK_ARRAY);
		TERMINALS[25].addFollower(TERMINALS[26], EMPTY_LINK_ARRAY);
		TERMINALS[26].addFollower(TERMINALS[27], EMPTY_LINK_ARRAY);
		TERMINALS[27].addFollower(TERMINALS[28], EMPTY_LINK_ARRAY);
		TERMINALS[28].addFollower(TERMINALS[29], EMPTY_LINK_ARRAY);
		TERMINALS[29].addFollower(TERMINALS[30], EMPTY_LINK_ARRAY);
		TERMINALS[30].addFollower(TERMINALS[31], EMPTY_LINK_ARRAY);
		TERMINALS[31].addFollower(TERMINALS[32], EMPTY_LINK_ARRAY);
		TERMINALS[32].addFollower(TERMINALS[33], EMPTY_LINK_ARRAY);
		TERMINALS[33].addFollower(TERMINALS[5], new ASPT.resource.aspt.mopp.AsptContainedFeature[] {new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNode(), FEATURES[0]), });
		TERMINALS[33].addFollower(TERMINALS[6], new ASPT.resource.aspt.mopp.AsptContainedFeature[] {new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceProp(), FEATURES[0]), });
		TERMINALS[33].addFollower(TERMINALS[7], new ASPT.resource.aspt.mopp.AsptContainedFeature[] {new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceEdge(), FEATURES[0]), });
		TERMINALS[33].addFollower(TERMINALS[8], new ASPT.resource.aspt.mopp.AsptContainedFeature[] {new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNbEdge(), FEATURES[0]), });
		TERMINALS[33].addFollower(TERMINALS[9], new ASPT.resource.aspt.mopp.AsptContainedFeature[] {new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNbProp(), FEATURES[0]), });
		TERMINALS[33].addFollower(TERMINALS[10], new ASPT.resource.aspt.mopp.AsptContainedFeature[] {new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNbNode(), FEATURES[0]), });
		TERMINALS[33].addFollower(TERMINALS[11], new ASPT.resource.aspt.mopp.AsptContainedFeature[] {new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceLink(), FEATURES[0]), });
		TERMINALS[7].addFollower(TERMINALS[34], EMPTY_LINK_ARRAY);
		TERMINALS[34].addFollower(TERMINALS[35], EMPTY_LINK_ARRAY);
		TERMINALS[35].addFollower(TERMINALS[36], EMPTY_LINK_ARRAY);
		TERMINALS[36].addFollower(TERMINALS[37], EMPTY_LINK_ARRAY);
		TERMINALS[37].addFollower(TERMINALS[38], EMPTY_LINK_ARRAY);
		TERMINALS[38].addFollower(TERMINALS[39], EMPTY_LINK_ARRAY);
		TERMINALS[39].addFollower(TERMINALS[40], EMPTY_LINK_ARRAY);
		TERMINALS[40].addFollower(TERMINALS[41], EMPTY_LINK_ARRAY);
		TERMINALS[41].addFollower(TERMINALS[42], EMPTY_LINK_ARRAY);
		TERMINALS[42].addFollower(TERMINALS[43], EMPTY_LINK_ARRAY);
		TERMINALS[43].addFollower(TERMINALS[44], EMPTY_LINK_ARRAY);
		TERMINALS[44].addFollower(TERMINALS[45], EMPTY_LINK_ARRAY);
		TERMINALS[45].addFollower(TERMINALS[46], EMPTY_LINK_ARRAY);
		TERMINALS[46].addFollower(TERMINALS[47], EMPTY_LINK_ARRAY);
		TERMINALS[47].addFollower(TERMINALS[48], EMPTY_LINK_ARRAY);
		TERMINALS[48].addFollower(TERMINALS[49], EMPTY_LINK_ARRAY);
		TERMINALS[49].addFollower(TERMINALS[5], new ASPT.resource.aspt.mopp.AsptContainedFeature[] {new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNode(), FEATURES[0]), });
		TERMINALS[49].addFollower(TERMINALS[6], new ASPT.resource.aspt.mopp.AsptContainedFeature[] {new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceProp(), FEATURES[0]), });
		TERMINALS[49].addFollower(TERMINALS[7], new ASPT.resource.aspt.mopp.AsptContainedFeature[] {new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceEdge(), FEATURES[0]), });
		TERMINALS[49].addFollower(TERMINALS[8], new ASPT.resource.aspt.mopp.AsptContainedFeature[] {new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNbEdge(), FEATURES[0]), });
		TERMINALS[49].addFollower(TERMINALS[9], new ASPT.resource.aspt.mopp.AsptContainedFeature[] {new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNbProp(), FEATURES[0]), });
		TERMINALS[49].addFollower(TERMINALS[10], new ASPT.resource.aspt.mopp.AsptContainedFeature[] {new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNbNode(), FEATURES[0]), });
		TERMINALS[49].addFollower(TERMINALS[11], new ASPT.resource.aspt.mopp.AsptContainedFeature[] {new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceLink(), FEATURES[0]), });
		TERMINALS[8].addFollower(TERMINALS[50], EMPTY_LINK_ARRAY);
		TERMINALS[50].addFollower(TERMINALS[51], EMPTY_LINK_ARRAY);
		TERMINALS[51].addFollower(TERMINALS[52], EMPTY_LINK_ARRAY);
		TERMINALS[52].addFollower(TERMINALS[53], EMPTY_LINK_ARRAY);
		TERMINALS[53].addFollower(TERMINALS[54], EMPTY_LINK_ARRAY);
		TERMINALS[54].addFollower(TERMINALS[55], EMPTY_LINK_ARRAY);
		TERMINALS[55].addFollower(TERMINALS[56], EMPTY_LINK_ARRAY);
		TERMINALS[56].addFollower(TERMINALS[57], EMPTY_LINK_ARRAY);
		TERMINALS[57].addFollower(TERMINALS[58], EMPTY_LINK_ARRAY);
		TERMINALS[58].addFollower(TERMINALS[59], EMPTY_LINK_ARRAY);
		TERMINALS[59].addFollower(TERMINALS[60], EMPTY_LINK_ARRAY);
		TERMINALS[60].addFollower(TERMINALS[61], EMPTY_LINK_ARRAY);
		TERMINALS[61].addFollower(TERMINALS[62], EMPTY_LINK_ARRAY);
		TERMINALS[62].addFollower(TERMINALS[63], EMPTY_LINK_ARRAY);
		TERMINALS[63].addFollower(TERMINALS[64], EMPTY_LINK_ARRAY);
		TERMINALS[64].addFollower(TERMINALS[65], EMPTY_LINK_ARRAY);
		TERMINALS[65].addFollower(TERMINALS[5], new ASPT.resource.aspt.mopp.AsptContainedFeature[] {new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNode(), FEATURES[0]), });
		TERMINALS[65].addFollower(TERMINALS[6], new ASPT.resource.aspt.mopp.AsptContainedFeature[] {new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceProp(), FEATURES[0]), });
		TERMINALS[65].addFollower(TERMINALS[7], new ASPT.resource.aspt.mopp.AsptContainedFeature[] {new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceEdge(), FEATURES[0]), });
		TERMINALS[65].addFollower(TERMINALS[8], new ASPT.resource.aspt.mopp.AsptContainedFeature[] {new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNbEdge(), FEATURES[0]), });
		TERMINALS[65].addFollower(TERMINALS[9], new ASPT.resource.aspt.mopp.AsptContainedFeature[] {new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNbProp(), FEATURES[0]), });
		TERMINALS[65].addFollower(TERMINALS[10], new ASPT.resource.aspt.mopp.AsptContainedFeature[] {new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNbNode(), FEATURES[0]), });
		TERMINALS[65].addFollower(TERMINALS[11], new ASPT.resource.aspt.mopp.AsptContainedFeature[] {new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceLink(), FEATURES[0]), });
		TERMINALS[9].addFollower(TERMINALS[66], EMPTY_LINK_ARRAY);
		TERMINALS[66].addFollower(TERMINALS[67], EMPTY_LINK_ARRAY);
		TERMINALS[67].addFollower(TERMINALS[68], EMPTY_LINK_ARRAY);
		TERMINALS[68].addFollower(TERMINALS[69], EMPTY_LINK_ARRAY);
		TERMINALS[69].addFollower(TERMINALS[70], EMPTY_LINK_ARRAY);
		TERMINALS[70].addFollower(TERMINALS[71], EMPTY_LINK_ARRAY);
		TERMINALS[71].addFollower(TERMINALS[72], EMPTY_LINK_ARRAY);
		TERMINALS[72].addFollower(TERMINALS[73], EMPTY_LINK_ARRAY);
		TERMINALS[73].addFollower(TERMINALS[74], EMPTY_LINK_ARRAY);
		TERMINALS[74].addFollower(TERMINALS[75], EMPTY_LINK_ARRAY);
		TERMINALS[75].addFollower(TERMINALS[76], EMPTY_LINK_ARRAY);
		TERMINALS[76].addFollower(TERMINALS[77], EMPTY_LINK_ARRAY);
		TERMINALS[77].addFollower(TERMINALS[78], EMPTY_LINK_ARRAY);
		TERMINALS[78].addFollower(TERMINALS[79], EMPTY_LINK_ARRAY);
		TERMINALS[79].addFollower(TERMINALS[5], new ASPT.resource.aspt.mopp.AsptContainedFeature[] {new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNode(), FEATURES[0]), });
		TERMINALS[79].addFollower(TERMINALS[6], new ASPT.resource.aspt.mopp.AsptContainedFeature[] {new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceProp(), FEATURES[0]), });
		TERMINALS[79].addFollower(TERMINALS[7], new ASPT.resource.aspt.mopp.AsptContainedFeature[] {new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceEdge(), FEATURES[0]), });
		TERMINALS[79].addFollower(TERMINALS[8], new ASPT.resource.aspt.mopp.AsptContainedFeature[] {new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNbEdge(), FEATURES[0]), });
		TERMINALS[79].addFollower(TERMINALS[9], new ASPT.resource.aspt.mopp.AsptContainedFeature[] {new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNbProp(), FEATURES[0]), });
		TERMINALS[79].addFollower(TERMINALS[10], new ASPT.resource.aspt.mopp.AsptContainedFeature[] {new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNbNode(), FEATURES[0]), });
		TERMINALS[79].addFollower(TERMINALS[11], new ASPT.resource.aspt.mopp.AsptContainedFeature[] {new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceLink(), FEATURES[0]), });
		TERMINALS[10].addFollower(TERMINALS[80], EMPTY_LINK_ARRAY);
		TERMINALS[80].addFollower(TERMINALS[81], EMPTY_LINK_ARRAY);
		TERMINALS[81].addFollower(TERMINALS[82], EMPTY_LINK_ARRAY);
		TERMINALS[82].addFollower(TERMINALS[83], EMPTY_LINK_ARRAY);
		TERMINALS[83].addFollower(TERMINALS[84], EMPTY_LINK_ARRAY);
		TERMINALS[84].addFollower(TERMINALS[85], EMPTY_LINK_ARRAY);
		TERMINALS[85].addFollower(TERMINALS[86], EMPTY_LINK_ARRAY);
		TERMINALS[86].addFollower(TERMINALS[87], EMPTY_LINK_ARRAY);
		TERMINALS[87].addFollower(TERMINALS[5], new ASPT.resource.aspt.mopp.AsptContainedFeature[] {new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNode(), FEATURES[0]), });
		TERMINALS[87].addFollower(TERMINALS[6], new ASPT.resource.aspt.mopp.AsptContainedFeature[] {new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceProp(), FEATURES[0]), });
		TERMINALS[87].addFollower(TERMINALS[7], new ASPT.resource.aspt.mopp.AsptContainedFeature[] {new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceEdge(), FEATURES[0]), });
		TERMINALS[87].addFollower(TERMINALS[8], new ASPT.resource.aspt.mopp.AsptContainedFeature[] {new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNbEdge(), FEATURES[0]), });
		TERMINALS[87].addFollower(TERMINALS[9], new ASPT.resource.aspt.mopp.AsptContainedFeature[] {new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNbProp(), FEATURES[0]), });
		TERMINALS[87].addFollower(TERMINALS[10], new ASPT.resource.aspt.mopp.AsptContainedFeature[] {new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNbNode(), FEATURES[0]), });
		TERMINALS[87].addFollower(TERMINALS[11], new ASPT.resource.aspt.mopp.AsptContainedFeature[] {new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceLink(), FEATURES[0]), });
		TERMINALS[11].addFollower(TERMINALS[88], EMPTY_LINK_ARRAY);
		TERMINALS[88].addFollower(TERMINALS[89], EMPTY_LINK_ARRAY);
		TERMINALS[89].addFollower(TERMINALS[90], EMPTY_LINK_ARRAY);
		TERMINALS[90].addFollower(TERMINALS[91], EMPTY_LINK_ARRAY);
		TERMINALS[91].addFollower(TERMINALS[92], EMPTY_LINK_ARRAY);
		TERMINALS[92].addFollower(TERMINALS[93], EMPTY_LINK_ARRAY);
		TERMINALS[93].addFollower(TERMINALS[94], EMPTY_LINK_ARRAY);
		TERMINALS[94].addFollower(TERMINALS[95], EMPTY_LINK_ARRAY);
		TERMINALS[95].addFollower(TERMINALS[96], EMPTY_LINK_ARRAY);
		TERMINALS[96].addFollower(TERMINALS[97], EMPTY_LINK_ARRAY);
		TERMINALS[97].addFollower(TERMINALS[5], new ASPT.resource.aspt.mopp.AsptContainedFeature[] {new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNode(), FEATURES[0]), });
		TERMINALS[97].addFollower(TERMINALS[6], new ASPT.resource.aspt.mopp.AsptContainedFeature[] {new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceProp(), FEATURES[0]), });
		TERMINALS[97].addFollower(TERMINALS[7], new ASPT.resource.aspt.mopp.AsptContainedFeature[] {new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceEdge(), FEATURES[0]), });
		TERMINALS[97].addFollower(TERMINALS[8], new ASPT.resource.aspt.mopp.AsptContainedFeature[] {new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNbEdge(), FEATURES[0]), });
		TERMINALS[97].addFollower(TERMINALS[9], new ASPT.resource.aspt.mopp.AsptContainedFeature[] {new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNbProp(), FEATURES[0]), });
		TERMINALS[97].addFollower(TERMINALS[10], new ASPT.resource.aspt.mopp.AsptContainedFeature[] {new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceNbNode(), FEATURES[0]), });
		TERMINALS[97].addFollower(TERMINALS[11], new ASPT.resource.aspt.mopp.AsptContainedFeature[] {new ASPT.resource.aspt.mopp.AsptContainedFeature(ASPT.ASPTPackage.eINSTANCE.getTraceLink(), FEATURES[0]), });
	}
	
	public static void wire() {
		wire0();
	}
	
	static {
		// initialize the arrays
		initializeTerminals();
		initializeFeatures();
		initializeLinks();
		// wire the terminals
		wire();
	}
}
