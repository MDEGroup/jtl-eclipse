/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPMM.resource.aspmm.grammar;

/**
 * This class provides the follow sets for all terminals of the grammar. These
 * sets are used during code completion.
 */
public class AspmmFollowSetProvider {
	
	public final static ASPMM.resource.aspmm.IAspmmExpectedElement TERMINALS[] = new ASPMM.resource.aspmm.IAspmmExpectedElement[34];
	
	public final static org.eclipse.emf.ecore.EStructuralFeature[] FEATURES = new org.eclipse.emf.ecore.EStructuralFeature[3];
	
	public final static ASPMM.resource.aspmm.mopp.AspmmContainedFeature[] LINKS = new ASPMM.resource.aspmm.mopp.AspmmContainedFeature[15];
	
	public final static ASPMM.resource.aspmm.mopp.AspmmContainedFeature[] EMPTY_LINK_ARRAY = new ASPMM.resource.aspmm.mopp.AspmmContainedFeature[0];
	
	public static void initializeTerminals0() {
		TERMINALS[0] = new ASPMM.resource.aspmm.mopp.AspmmExpectedCsString(ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_0_0_0_0);
		TERMINALS[1] = new ASPMM.resource.aspmm.mopp.AspmmExpectedCsString(ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_0_0_0_1);
		TERMINALS[2] = new ASPMM.resource.aspmm.mopp.AspmmExpectedStructuralFeature(ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_0_0_0_2);
		TERMINALS[3] = new ASPMM.resource.aspmm.mopp.AspmmExpectedCsString(ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_0_0_0_3);
		TERMINALS[4] = new ASPMM.resource.aspmm.mopp.AspmmExpectedCsString(ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_0_0_0_4);
		TERMINALS[5] = new ASPMM.resource.aspmm.mopp.AspmmExpectedCsString(ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_1_0_0_0);
		TERMINALS[6] = new ASPMM.resource.aspmm.mopp.AspmmExpectedCsString(ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_2_0_0_0);
		TERMINALS[7] = new ASPMM.resource.aspmm.mopp.AspmmExpectedCsString(ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_3_0_0_0);
		TERMINALS[8] = new ASPMM.resource.aspmm.mopp.AspmmExpectedCsString(ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_1_0_0_1);
		TERMINALS[9] = new ASPMM.resource.aspmm.mopp.AspmmExpectedStructuralFeature(ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_1_0_0_2);
		TERMINALS[10] = new ASPMM.resource.aspmm.mopp.AspmmExpectedCsString(ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_1_0_0_3);
		TERMINALS[11] = new ASPMM.resource.aspmm.mopp.AspmmExpectedStructuralFeature(ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_1_0_0_4);
		TERMINALS[12] = new ASPMM.resource.aspmm.mopp.AspmmExpectedCsString(ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_1_0_0_5);
		TERMINALS[13] = new ASPMM.resource.aspmm.mopp.AspmmExpectedCsString(ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_1_0_0_6);
		TERMINALS[14] = new ASPMM.resource.aspmm.mopp.AspmmExpectedCsString(ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_2_0_0_1);
		TERMINALS[15] = new ASPMM.resource.aspmm.mopp.AspmmExpectedStructuralFeature(ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_2_0_0_2);
		TERMINALS[16] = new ASPMM.resource.aspmm.mopp.AspmmExpectedCsString(ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_2_0_0_3);
		TERMINALS[17] = new ASPMM.resource.aspmm.mopp.AspmmExpectedStructuralFeature(ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_2_0_0_4);
		TERMINALS[18] = new ASPMM.resource.aspmm.mopp.AspmmExpectedCsString(ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_2_0_0_5);
		TERMINALS[19] = new ASPMM.resource.aspmm.mopp.AspmmExpectedStructuralFeature(ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_2_0_0_6);
		TERMINALS[20] = new ASPMM.resource.aspmm.mopp.AspmmExpectedCsString(ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_2_0_0_7);
		TERMINALS[21] = new ASPMM.resource.aspmm.mopp.AspmmExpectedCsString(ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_2_0_0_8);
		TERMINALS[22] = new ASPMM.resource.aspmm.mopp.AspmmExpectedCsString(ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_3_0_0_1);
		TERMINALS[23] = new ASPMM.resource.aspmm.mopp.AspmmExpectedStructuralFeature(ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_3_0_0_2);
		TERMINALS[24] = new ASPMM.resource.aspmm.mopp.AspmmExpectedCsString(ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_3_0_0_3);
		TERMINALS[25] = new ASPMM.resource.aspmm.mopp.AspmmExpectedEnumerationTerminal(ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_3_0_0_4);
		TERMINALS[26] = new ASPMM.resource.aspmm.mopp.AspmmExpectedCsString(ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_3_0_0_5);
		TERMINALS[27] = new ASPMM.resource.aspmm.mopp.AspmmExpectedStructuralFeature(ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_3_0_0_6);
		TERMINALS[28] = new ASPMM.resource.aspmm.mopp.AspmmExpectedCsString(ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_3_0_0_7);
		TERMINALS[29] = new ASPMM.resource.aspmm.mopp.AspmmExpectedStructuralFeature(ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_3_0_0_8);
		TERMINALS[30] = new ASPMM.resource.aspmm.mopp.AspmmExpectedCsString(ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_3_0_0_9);
		TERMINALS[31] = new ASPMM.resource.aspmm.mopp.AspmmExpectedStructuralFeature(ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_3_0_0_10);
		TERMINALS[32] = new ASPMM.resource.aspmm.mopp.AspmmExpectedCsString(ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_3_0_0_11);
		TERMINALS[33] = new ASPMM.resource.aspmm.mopp.AspmmExpectedCsString(ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_3_0_0_12);
	}
	
	public static void initializeTerminals() {
		initializeTerminals0();
	}
	
	public static void initializeFeatures0() {
		FEATURES[0] = ASPMM.ASPMMPackage.eINSTANCE.getMetamodel().getEStructuralFeature(ASPMM.ASPMMPackage.METAMODEL__METANODES);
		FEATURES[1] = ASPMM.ASPMMPackage.eINSTANCE.getMetamodel().getEStructuralFeature(ASPMM.ASPMMPackage.METAMODEL__METAPROPS);
		FEATURES[2] = ASPMM.ASPMMPackage.eINSTANCE.getMetamodel().getEStructuralFeature(ASPMM.ASPMMPackage.METAMODEL__METAEDGES);
	}
	
	public static void initializeFeatures() {
		initializeFeatures0();
	}
	
	public static void initializeLinks0() {
		LINKS[0] = new ASPMM.resource.aspmm.mopp.AspmmContainedFeature(ASPMM.ASPMMPackage.eINSTANCE.getMetanode(), FEATURES[0]);
		LINKS[1] = new ASPMM.resource.aspmm.mopp.AspmmContainedFeature(ASPMM.ASPMMPackage.eINSTANCE.getMetaprop(), FEATURES[1]);
		LINKS[2] = new ASPMM.resource.aspmm.mopp.AspmmContainedFeature(ASPMM.ASPMMPackage.eINSTANCE.getMetaedge(), FEATURES[2]);
		LINKS[3] = new ASPMM.resource.aspmm.mopp.AspmmContainedFeature(ASPMM.ASPMMPackage.eINSTANCE.getMetanode(), FEATURES[0]);
		LINKS[4] = new ASPMM.resource.aspmm.mopp.AspmmContainedFeature(ASPMM.ASPMMPackage.eINSTANCE.getMetaprop(), FEATURES[1]);
		LINKS[5] = new ASPMM.resource.aspmm.mopp.AspmmContainedFeature(ASPMM.ASPMMPackage.eINSTANCE.getMetaedge(), FEATURES[2]);
		LINKS[6] = new ASPMM.resource.aspmm.mopp.AspmmContainedFeature(ASPMM.ASPMMPackage.eINSTANCE.getMetaprop(), FEATURES[1]);
		LINKS[7] = new ASPMM.resource.aspmm.mopp.AspmmContainedFeature(ASPMM.ASPMMPackage.eINSTANCE.getMetaedge(), FEATURES[2]);
		LINKS[8] = new ASPMM.resource.aspmm.mopp.AspmmContainedFeature(ASPMM.ASPMMPackage.eINSTANCE.getMetaedge(), FEATURES[2]);
		LINKS[9] = new ASPMM.resource.aspmm.mopp.AspmmContainedFeature(ASPMM.ASPMMPackage.eINSTANCE.getMetanode(), FEATURES[0]);
		LINKS[10] = new ASPMM.resource.aspmm.mopp.AspmmContainedFeature(ASPMM.ASPMMPackage.eINSTANCE.getMetaprop(), FEATURES[1]);
		LINKS[11] = new ASPMM.resource.aspmm.mopp.AspmmContainedFeature(ASPMM.ASPMMPackage.eINSTANCE.getMetaedge(), FEATURES[2]);
		LINKS[12] = new ASPMM.resource.aspmm.mopp.AspmmContainedFeature(ASPMM.ASPMMPackage.eINSTANCE.getMetaprop(), FEATURES[1]);
		LINKS[13] = new ASPMM.resource.aspmm.mopp.AspmmContainedFeature(ASPMM.ASPMMPackage.eINSTANCE.getMetaedge(), FEATURES[2]);
		LINKS[14] = new ASPMM.resource.aspmm.mopp.AspmmContainedFeature(ASPMM.ASPMMPackage.eINSTANCE.getMetaedge(), FEATURES[2]);
	}
	
	public static void initializeLinks() {
		initializeLinks0();
	}
	
	public static void wire0() {
		TERMINALS[0].addFollower(TERMINALS[1], EMPTY_LINK_ARRAY);
		TERMINALS[1].addFollower(TERMINALS[2], EMPTY_LINK_ARRAY);
		TERMINALS[2].addFollower(TERMINALS[3], EMPTY_LINK_ARRAY);
		TERMINALS[3].addFollower(TERMINALS[4], EMPTY_LINK_ARRAY);
		TERMINALS[4].addFollower(TERMINALS[5], new ASPMM.resource.aspmm.mopp.AspmmContainedFeature[] {new ASPMM.resource.aspmm.mopp.AspmmContainedFeature(ASPMM.ASPMMPackage.eINSTANCE.getMetanode(), FEATURES[0]), });
		TERMINALS[4].addFollower(TERMINALS[6], new ASPMM.resource.aspmm.mopp.AspmmContainedFeature[] {new ASPMM.resource.aspmm.mopp.AspmmContainedFeature(ASPMM.ASPMMPackage.eINSTANCE.getMetaprop(), FEATURES[1]), });
		TERMINALS[4].addFollower(TERMINALS[7], new ASPMM.resource.aspmm.mopp.AspmmContainedFeature[] {new ASPMM.resource.aspmm.mopp.AspmmContainedFeature(ASPMM.ASPMMPackage.eINSTANCE.getMetaedge(), FEATURES[2]), });
		TERMINALS[5].addFollower(TERMINALS[8], EMPTY_LINK_ARRAY);
		TERMINALS[8].addFollower(TERMINALS[9], EMPTY_LINK_ARRAY);
		TERMINALS[9].addFollower(TERMINALS[10], EMPTY_LINK_ARRAY);
		TERMINALS[10].addFollower(TERMINALS[11], EMPTY_LINK_ARRAY);
		TERMINALS[11].addFollower(TERMINALS[12], EMPTY_LINK_ARRAY);
		TERMINALS[12].addFollower(TERMINALS[13], EMPTY_LINK_ARRAY);
		TERMINALS[13].addFollower(TERMINALS[5], new ASPMM.resource.aspmm.mopp.AspmmContainedFeature[] {new ASPMM.resource.aspmm.mopp.AspmmContainedFeature(ASPMM.ASPMMPackage.eINSTANCE.getMetanode(), FEATURES[0]), });
		TERMINALS[13].addFollower(TERMINALS[6], new ASPMM.resource.aspmm.mopp.AspmmContainedFeature[] {new ASPMM.resource.aspmm.mopp.AspmmContainedFeature(ASPMM.ASPMMPackage.eINSTANCE.getMetaprop(), FEATURES[1]), });
		TERMINALS[13].addFollower(TERMINALS[7], new ASPMM.resource.aspmm.mopp.AspmmContainedFeature[] {new ASPMM.resource.aspmm.mopp.AspmmContainedFeature(ASPMM.ASPMMPackage.eINSTANCE.getMetaedge(), FEATURES[2]), });
		TERMINALS[6].addFollower(TERMINALS[14], EMPTY_LINK_ARRAY);
		TERMINALS[14].addFollower(TERMINALS[15], EMPTY_LINK_ARRAY);
		TERMINALS[15].addFollower(TERMINALS[16], EMPTY_LINK_ARRAY);
		TERMINALS[16].addFollower(TERMINALS[17], EMPTY_LINK_ARRAY);
		TERMINALS[17].addFollower(TERMINALS[18], EMPTY_LINK_ARRAY);
		TERMINALS[18].addFollower(TERMINALS[19], EMPTY_LINK_ARRAY);
		TERMINALS[19].addFollower(TERMINALS[20], EMPTY_LINK_ARRAY);
		TERMINALS[20].addFollower(TERMINALS[21], EMPTY_LINK_ARRAY);
		TERMINALS[21].addFollower(TERMINALS[6], new ASPMM.resource.aspmm.mopp.AspmmContainedFeature[] {new ASPMM.resource.aspmm.mopp.AspmmContainedFeature(ASPMM.ASPMMPackage.eINSTANCE.getMetaprop(), FEATURES[1]), });
		TERMINALS[21].addFollower(TERMINALS[7], new ASPMM.resource.aspmm.mopp.AspmmContainedFeature[] {new ASPMM.resource.aspmm.mopp.AspmmContainedFeature(ASPMM.ASPMMPackage.eINSTANCE.getMetaedge(), FEATURES[2]), });
		TERMINALS[7].addFollower(TERMINALS[22], EMPTY_LINK_ARRAY);
		TERMINALS[22].addFollower(TERMINALS[23], EMPTY_LINK_ARRAY);
		TERMINALS[23].addFollower(TERMINALS[24], EMPTY_LINK_ARRAY);
		TERMINALS[24].addFollower(TERMINALS[25], EMPTY_LINK_ARRAY);
		TERMINALS[26].addFollower(TERMINALS[27], EMPTY_LINK_ARRAY);
		TERMINALS[27].addFollower(TERMINALS[28], EMPTY_LINK_ARRAY);
		TERMINALS[28].addFollower(TERMINALS[29], EMPTY_LINK_ARRAY);
		TERMINALS[29].addFollower(TERMINALS[30], EMPTY_LINK_ARRAY);
		TERMINALS[30].addFollower(TERMINALS[31], EMPTY_LINK_ARRAY);
		TERMINALS[31].addFollower(TERMINALS[32], EMPTY_LINK_ARRAY);
		TERMINALS[32].addFollower(TERMINALS[33], EMPTY_LINK_ARRAY);
		TERMINALS[33].addFollower(TERMINALS[7], new ASPMM.resource.aspmm.mopp.AspmmContainedFeature[] {new ASPMM.resource.aspmm.mopp.AspmmContainedFeature(ASPMM.ASPMMPackage.eINSTANCE.getMetaedge(), FEATURES[2]), });
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
