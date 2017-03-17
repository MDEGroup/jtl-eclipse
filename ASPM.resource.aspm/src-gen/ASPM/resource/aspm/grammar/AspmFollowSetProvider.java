/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPM.resource.aspm.grammar;

/**
 * This class provides the follow sets for all terminals of the grammar. These
 * sets are used during code completion.
 */
public class AspmFollowSetProvider {
	
	public final static ASPM.resource.aspm.IAspmExpectedElement TERMINALS[] = new ASPM.resource.aspm.IAspmExpectedElement[54];
	
	public final static org.eclipse.emf.ecore.EStructuralFeature[] FEATURES = new org.eclipse.emf.ecore.EStructuralFeature[3];
	
	public final static ASPM.resource.aspm.mopp.AspmContainedFeature[] LINKS = new ASPM.resource.aspm.mopp.AspmContainedFeature[15];
	
	public final static ASPM.resource.aspm.mopp.AspmContainedFeature[] EMPTY_LINK_ARRAY = new ASPM.resource.aspm.mopp.AspmContainedFeature[0];
	
	public static void initializeTerminals0() {
		TERMINALS[0] = new ASPM.resource.aspm.mopp.AspmExpectedCsString(ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_0_0_0_0);
		TERMINALS[1] = new ASPM.resource.aspm.mopp.AspmExpectedCsString(ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_0_0_0_1);
		TERMINALS[2] = new ASPM.resource.aspm.mopp.AspmExpectedStructuralFeature(ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_0_0_0_2);
		TERMINALS[3] = new ASPM.resource.aspm.mopp.AspmExpectedCsString(ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_0_0_0_3);
		TERMINALS[4] = new ASPM.resource.aspm.mopp.AspmExpectedStructuralFeature(ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_0_0_0_4);
		TERMINALS[5] = new ASPM.resource.aspm.mopp.AspmExpectedCsString(ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_0_0_0_5);
		TERMINALS[6] = new ASPM.resource.aspm.mopp.AspmExpectedCsString(ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_0_0_0_6);
		TERMINALS[7] = new ASPM.resource.aspm.mopp.AspmExpectedCsString(ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_1_0_0_0);
		TERMINALS[8] = new ASPM.resource.aspm.mopp.AspmExpectedCsString(ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_2_0_0_0);
		TERMINALS[9] = new ASPM.resource.aspm.mopp.AspmExpectedCsString(ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_3_0_0_0);
		TERMINALS[10] = new ASPM.resource.aspm.mopp.AspmExpectedCsString(ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_1_0_0_1);
		TERMINALS[11] = new ASPM.resource.aspm.mopp.AspmExpectedStructuralFeature(ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_1_0_0_2);
		TERMINALS[12] = new ASPM.resource.aspm.mopp.AspmExpectedCsString(ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_1_0_0_3);
		TERMINALS[13] = new ASPM.resource.aspm.mopp.AspmExpectedStructuralFeature(ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_1_0_0_4);
		TERMINALS[14] = new ASPM.resource.aspm.mopp.AspmExpectedCsString(ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_1_0_0_5);
		TERMINALS[15] = new ASPM.resource.aspm.mopp.AspmExpectedStructuralFeature(ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_1_0_0_6);
		TERMINALS[16] = new ASPM.resource.aspm.mopp.AspmExpectedCsString(ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_1_0_0_7);
		TERMINALS[17] = new ASPM.resource.aspm.mopp.AspmExpectedStructuralFeature(ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_1_0_0_8);
		TERMINALS[18] = new ASPM.resource.aspm.mopp.AspmExpectedCsString(ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_1_0_0_9);
		TERMINALS[19] = new ASPM.resource.aspm.mopp.AspmExpectedCsString(ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_1_0_0_10);
		TERMINALS[20] = new ASPM.resource.aspm.mopp.AspmExpectedCsString(ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_2_0_0_1);
		TERMINALS[21] = new ASPM.resource.aspm.mopp.AspmExpectedStructuralFeature(ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_2_0_0_2);
		TERMINALS[22] = new ASPM.resource.aspm.mopp.AspmExpectedCsString(ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_2_0_0_3);
		TERMINALS[23] = new ASPM.resource.aspm.mopp.AspmExpectedStructuralFeature(ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_2_0_0_4);
		TERMINALS[24] = new ASPM.resource.aspm.mopp.AspmExpectedCsString(ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_2_0_0_5);
		TERMINALS[25] = new ASPM.resource.aspm.mopp.AspmExpectedStructuralFeature(ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_2_0_0_6);
		TERMINALS[26] = new ASPM.resource.aspm.mopp.AspmExpectedCsString(ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_2_0_0_7);
		TERMINALS[27] = new ASPM.resource.aspm.mopp.AspmExpectedStructuralFeature(ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_2_0_0_8);
		TERMINALS[28] = new ASPM.resource.aspm.mopp.AspmExpectedCsString(ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_2_0_0_9);
		TERMINALS[29] = new ASPM.resource.aspm.mopp.AspmExpectedStructuralFeature(ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_2_0_0_10);
		TERMINALS[30] = new ASPM.resource.aspm.mopp.AspmExpectedCsString(ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_2_0_0_11);
		TERMINALS[31] = new ASPM.resource.aspm.mopp.AspmExpectedStructuralFeature(ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_2_0_0_12);
		TERMINALS[32] = new ASPM.resource.aspm.mopp.AspmExpectedCsString(ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_2_0_0_13);
		TERMINALS[33] = new ASPM.resource.aspm.mopp.AspmExpectedStructuralFeature(ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_2_0_0_14);
		TERMINALS[34] = new ASPM.resource.aspm.mopp.AspmExpectedCsString(ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_2_0_0_15);
		TERMINALS[35] = new ASPM.resource.aspm.mopp.AspmExpectedCsString(ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_2_0_0_16);
		TERMINALS[36] = new ASPM.resource.aspm.mopp.AspmExpectedCsString(ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_3_0_0_1);
		TERMINALS[37] = new ASPM.resource.aspm.mopp.AspmExpectedStructuralFeature(ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_3_0_0_2);
		TERMINALS[38] = new ASPM.resource.aspm.mopp.AspmExpectedCsString(ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_3_0_0_3);
		TERMINALS[39] = new ASPM.resource.aspm.mopp.AspmExpectedStructuralFeature(ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_3_0_0_4);
		TERMINALS[40] = new ASPM.resource.aspm.mopp.AspmExpectedCsString(ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_3_0_0_5);
		TERMINALS[41] = new ASPM.resource.aspm.mopp.AspmExpectedStructuralFeature(ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_3_0_0_6);
		TERMINALS[42] = new ASPM.resource.aspm.mopp.AspmExpectedCsString(ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_3_0_0_7);
		TERMINALS[43] = new ASPM.resource.aspm.mopp.AspmExpectedStructuralFeature(ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_3_0_0_8);
		TERMINALS[44] = new ASPM.resource.aspm.mopp.AspmExpectedCsString(ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_3_0_0_9);
		TERMINALS[45] = new ASPM.resource.aspm.mopp.AspmExpectedStructuralFeature(ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_3_0_0_10);
		TERMINALS[46] = new ASPM.resource.aspm.mopp.AspmExpectedCsString(ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_3_0_0_11);
		TERMINALS[47] = new ASPM.resource.aspm.mopp.AspmExpectedStructuralFeature(ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_3_0_0_12);
		TERMINALS[48] = new ASPM.resource.aspm.mopp.AspmExpectedCsString(ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_3_0_0_13);
		TERMINALS[49] = new ASPM.resource.aspm.mopp.AspmExpectedStructuralFeature(ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_3_0_0_14);
		TERMINALS[50] = new ASPM.resource.aspm.mopp.AspmExpectedCsString(ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_3_0_0_15);
		TERMINALS[51] = new ASPM.resource.aspm.mopp.AspmExpectedStructuralFeature(ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_3_0_0_16);
		TERMINALS[52] = new ASPM.resource.aspm.mopp.AspmExpectedCsString(ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_3_0_0_17);
		TERMINALS[53] = new ASPM.resource.aspm.mopp.AspmExpectedCsString(ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_3_0_0_18);
	}
	
	public static void initializeTerminals() {
		initializeTerminals0();
	}
	
	public static void initializeFeatures0() {
		FEATURES[0] = ASPM.ASPMPackage.eINSTANCE.getModel().getEStructuralFeature(ASPM.ASPMPackage.MODEL__NODES);
		FEATURES[1] = ASPM.ASPMPackage.eINSTANCE.getModel().getEStructuralFeature(ASPM.ASPMPackage.MODEL__PROPS);
		FEATURES[2] = ASPM.ASPMPackage.eINSTANCE.getModel().getEStructuralFeature(ASPM.ASPMPackage.MODEL__EDGES);
	}
	
	public static void initializeFeatures() {
		initializeFeatures0();
	}
	
	public static void initializeLinks0() {
		LINKS[0] = new ASPM.resource.aspm.mopp.AspmContainedFeature(ASPM.ASPMPackage.eINSTANCE.getNode(), FEATURES[0]);
		LINKS[1] = new ASPM.resource.aspm.mopp.AspmContainedFeature(ASPM.ASPMPackage.eINSTANCE.getProp(), FEATURES[1]);
		LINKS[2] = new ASPM.resource.aspm.mopp.AspmContainedFeature(ASPM.ASPMPackage.eINSTANCE.getEdge(), FEATURES[2]);
		LINKS[3] = new ASPM.resource.aspm.mopp.AspmContainedFeature(ASPM.ASPMPackage.eINSTANCE.getNode(), FEATURES[0]);
		LINKS[4] = new ASPM.resource.aspm.mopp.AspmContainedFeature(ASPM.ASPMPackage.eINSTANCE.getProp(), FEATURES[1]);
		LINKS[5] = new ASPM.resource.aspm.mopp.AspmContainedFeature(ASPM.ASPMPackage.eINSTANCE.getEdge(), FEATURES[2]);
		LINKS[6] = new ASPM.resource.aspm.mopp.AspmContainedFeature(ASPM.ASPMPackage.eINSTANCE.getProp(), FEATURES[1]);
		LINKS[7] = new ASPM.resource.aspm.mopp.AspmContainedFeature(ASPM.ASPMPackage.eINSTANCE.getEdge(), FEATURES[2]);
		LINKS[8] = new ASPM.resource.aspm.mopp.AspmContainedFeature(ASPM.ASPMPackage.eINSTANCE.getEdge(), FEATURES[2]);
		LINKS[9] = new ASPM.resource.aspm.mopp.AspmContainedFeature(ASPM.ASPMPackage.eINSTANCE.getNode(), FEATURES[0]);
		LINKS[10] = new ASPM.resource.aspm.mopp.AspmContainedFeature(ASPM.ASPMPackage.eINSTANCE.getProp(), FEATURES[1]);
		LINKS[11] = new ASPM.resource.aspm.mopp.AspmContainedFeature(ASPM.ASPMPackage.eINSTANCE.getEdge(), FEATURES[2]);
		LINKS[12] = new ASPM.resource.aspm.mopp.AspmContainedFeature(ASPM.ASPMPackage.eINSTANCE.getProp(), FEATURES[1]);
		LINKS[13] = new ASPM.resource.aspm.mopp.AspmContainedFeature(ASPM.ASPMPackage.eINSTANCE.getEdge(), FEATURES[2]);
		LINKS[14] = new ASPM.resource.aspm.mopp.AspmContainedFeature(ASPM.ASPMPackage.eINSTANCE.getEdge(), FEATURES[2]);
	}
	
	public static void initializeLinks() {
		initializeLinks0();
	}
	
	public static void wire0() {
		TERMINALS[0].addFollower(TERMINALS[1], EMPTY_LINK_ARRAY);
		TERMINALS[1].addFollower(TERMINALS[2], EMPTY_LINK_ARRAY);
		TERMINALS[2].addFollower(TERMINALS[3], EMPTY_LINK_ARRAY);
		TERMINALS[3].addFollower(TERMINALS[4], EMPTY_LINK_ARRAY);
		TERMINALS[4].addFollower(TERMINALS[5], EMPTY_LINK_ARRAY);
		TERMINALS[5].addFollower(TERMINALS[6], EMPTY_LINK_ARRAY);
		TERMINALS[6].addFollower(TERMINALS[7], new ASPM.resource.aspm.mopp.AspmContainedFeature[] {new ASPM.resource.aspm.mopp.AspmContainedFeature(ASPM.ASPMPackage.eINSTANCE.getNode(), FEATURES[0]), });
		TERMINALS[6].addFollower(TERMINALS[8], new ASPM.resource.aspm.mopp.AspmContainedFeature[] {new ASPM.resource.aspm.mopp.AspmContainedFeature(ASPM.ASPMPackage.eINSTANCE.getProp(), FEATURES[1]), });
		TERMINALS[6].addFollower(TERMINALS[9], new ASPM.resource.aspm.mopp.AspmContainedFeature[] {new ASPM.resource.aspm.mopp.AspmContainedFeature(ASPM.ASPMPackage.eINSTANCE.getEdge(), FEATURES[2]), });
		TERMINALS[7].addFollower(TERMINALS[10], EMPTY_LINK_ARRAY);
		TERMINALS[10].addFollower(TERMINALS[11], EMPTY_LINK_ARRAY);
		TERMINALS[11].addFollower(TERMINALS[12], EMPTY_LINK_ARRAY);
		TERMINALS[12].addFollower(TERMINALS[13], EMPTY_LINK_ARRAY);
		TERMINALS[13].addFollower(TERMINALS[14], EMPTY_LINK_ARRAY);
		TERMINALS[14].addFollower(TERMINALS[15], EMPTY_LINK_ARRAY);
		TERMINALS[15].addFollower(TERMINALS[16], EMPTY_LINK_ARRAY);
		TERMINALS[16].addFollower(TERMINALS[17], EMPTY_LINK_ARRAY);
		TERMINALS[17].addFollower(TERMINALS[18], EMPTY_LINK_ARRAY);
		TERMINALS[18].addFollower(TERMINALS[19], EMPTY_LINK_ARRAY);
		TERMINALS[19].addFollower(TERMINALS[7], new ASPM.resource.aspm.mopp.AspmContainedFeature[] {new ASPM.resource.aspm.mopp.AspmContainedFeature(ASPM.ASPMPackage.eINSTANCE.getNode(), FEATURES[0]), });
		TERMINALS[19].addFollower(TERMINALS[8], new ASPM.resource.aspm.mopp.AspmContainedFeature[] {new ASPM.resource.aspm.mopp.AspmContainedFeature(ASPM.ASPMPackage.eINSTANCE.getProp(), FEATURES[1]), });
		TERMINALS[19].addFollower(TERMINALS[9], new ASPM.resource.aspm.mopp.AspmContainedFeature[] {new ASPM.resource.aspm.mopp.AspmContainedFeature(ASPM.ASPMPackage.eINSTANCE.getEdge(), FEATURES[2]), });
		TERMINALS[8].addFollower(TERMINALS[20], EMPTY_LINK_ARRAY);
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
		TERMINALS[33].addFollower(TERMINALS[34], EMPTY_LINK_ARRAY);
		TERMINALS[34].addFollower(TERMINALS[35], EMPTY_LINK_ARRAY);
		TERMINALS[35].addFollower(TERMINALS[8], new ASPM.resource.aspm.mopp.AspmContainedFeature[] {new ASPM.resource.aspm.mopp.AspmContainedFeature(ASPM.ASPMPackage.eINSTANCE.getProp(), FEATURES[1]), });
		TERMINALS[35].addFollower(TERMINALS[9], new ASPM.resource.aspm.mopp.AspmContainedFeature[] {new ASPM.resource.aspm.mopp.AspmContainedFeature(ASPM.ASPMPackage.eINSTANCE.getEdge(), FEATURES[2]), });
		TERMINALS[9].addFollower(TERMINALS[36], EMPTY_LINK_ARRAY);
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
		TERMINALS[49].addFollower(TERMINALS[50], EMPTY_LINK_ARRAY);
		TERMINALS[50].addFollower(TERMINALS[51], EMPTY_LINK_ARRAY);
		TERMINALS[51].addFollower(TERMINALS[52], EMPTY_LINK_ARRAY);
		TERMINALS[52].addFollower(TERMINALS[53], EMPTY_LINK_ARRAY);
		TERMINALS[53].addFollower(TERMINALS[9], new ASPM.resource.aspm.mopp.AspmContainedFeature[] {new ASPM.resource.aspm.mopp.AspmContainedFeature(ASPM.ASPMPackage.eINSTANCE.getEdge(), FEATURES[2]), });
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
