/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASP.resource.asp.grammar;

public class AspGrammarInformationProvider {
	
	public final static org.eclipse.emf.ecore.EStructuralFeature ANONYMOUS_FEATURE = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEAttribute();
	static {
		ANONYMOUS_FEATURE.setName("_");
	}
	
	public final static AspGrammarInformationProvider INSTANCE = new AspGrammarInformationProvider();
	
	private java.util.Set<String> keywords;
	
	public final static ASP.resource.asp.grammar.AspContainment ASP_0_0_0_0 = new ASP.resource.asp.grammar.AspContainment(ASP.ASPPackage.eINSTANCE.getTransformation().getEStructuralFeature(ASP.ASPPackage.TRANSFORMATION__ELEMENTS), ASP.resource.asp.grammar.AspCardinality.PLUS, new org.eclipse.emf.ecore.EClass[] {ASP.ASPPackage.eINSTANCE.getElement(), }, 0);
	public final static ASP.resource.asp.grammar.AspLineBreak ASP_0_0_0_1 = new ASP.resource.asp.grammar.AspLineBreak(ASP.resource.asp.grammar.AspCardinality.ONE, 0);
	public final static ASP.resource.asp.grammar.AspContainment ASP_0_0_0_2 = new ASP.resource.asp.grammar.AspContainment(ASP.ASPPackage.eINSTANCE.getTransformation().getEStructuralFeature(ASP.ASPPackage.TRANSFORMATION__RELATIONS), ASP.resource.asp.grammar.AspCardinality.PLUS, new org.eclipse.emf.ecore.EClass[] {ASP.ASPPackage.eINSTANCE.getRelation(), }, 0);
	public final static ASP.resource.asp.grammar.AspLineBreak ASP_0_0_0_3 = new ASP.resource.asp.grammar.AspLineBreak(ASP.resource.asp.grammar.AspCardinality.ONE, 0);
	public final static ASP.resource.asp.grammar.AspContainment ASP_0_0_0_4 = new ASP.resource.asp.grammar.AspContainment(ASP.ASPPackage.eINSTANCE.getTransformation().getEStructuralFeature(ASP.ASPPackage.TRANSFORMATION__RULES), ASP.resource.asp.grammar.AspCardinality.STAR, new org.eclipse.emf.ecore.EClass[] {ASP.ASPPackage.eINSTANCE.getRule(), }, 0);
	public final static ASP.resource.asp.grammar.AspLineBreak ASP_0_0_0_5 = new ASP.resource.asp.grammar.AspLineBreak(ASP.resource.asp.grammar.AspCardinality.ONE, 0);
	public final static ASP.resource.asp.grammar.AspContainment ASP_0_0_0_6 = new ASP.resource.asp.grammar.AspContainment(ASP.ASPPackage.eINSTANCE.getTransformation().getEStructuralFeature(ASP.ASPPackage.TRANSFORMATION__CONSTRAINTS), ASP.resource.asp.grammar.AspCardinality.STAR, new org.eclipse.emf.ecore.EClass[] {ASP.ASPPackage.eINSTANCE.getConstraint(), }, 0);
	public final static ASP.resource.asp.grammar.AspSequence ASP_0_0_0 = new ASP.resource.asp.grammar.AspSequence(ASP.resource.asp.grammar.AspCardinality.ONE, ASP_0_0_0_0, ASP_0_0_0_1, ASP_0_0_0_2, ASP_0_0_0_3, ASP_0_0_0_4, ASP_0_0_0_5, ASP_0_0_0_6);
	public final static ASP.resource.asp.grammar.AspChoice ASP_0_0 = new ASP.resource.asp.grammar.AspChoice(ASP.resource.asp.grammar.AspCardinality.ONE, ASP_0_0_0);
	public final static ASP.resource.asp.grammar.AspRule ASP_0 = new ASP.resource.asp.grammar.AspRule(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP_0_0, ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspContainment ASP_1_0_0_0 = new ASP.resource.asp.grammar.AspContainment(ASP.ASPPackage.eINSTANCE.getRelation().getEStructuralFeature(ASP.ASPPackage.RELATION__PATTERNS), ASP.resource.asp.grammar.AspCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {ASP.ASPPackage.eINSTANCE.getPattern(), }, 1);
	public final static ASP.resource.asp.grammar.AspLineBreak ASP_1_0_0_1 = new ASP.resource.asp.grammar.AspLineBreak(ASP.resource.asp.grammar.AspCardinality.ONE, 0);
	public final static ASP.resource.asp.grammar.AspContainment ASP_1_0_0_2 = new ASP.resource.asp.grammar.AspContainment(ASP.ASPPackage.eINSTANCE.getRelation().getEStructuralFeature(ASP.ASPPackage.RELATION__PATTERNS), ASP.resource.asp.grammar.AspCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {ASP.ASPPackage.eINSTANCE.getRightPattern(), }, 0);
	public final static ASP.resource.asp.grammar.AspLineBreak ASP_1_0_0_3 = new ASP.resource.asp.grammar.AspLineBreak(ASP.resource.asp.grammar.AspCardinality.ONE, 0);
	public final static ASP.resource.asp.grammar.AspSequence ASP_1_0_0 = new ASP.resource.asp.grammar.AspSequence(ASP.resource.asp.grammar.AspCardinality.ONE, ASP_1_0_0_0, ASP_1_0_0_1, ASP_1_0_0_2, ASP_1_0_0_3);
	public final static ASP.resource.asp.grammar.AspChoice ASP_1_0 = new ASP.resource.asp.grammar.AspChoice(ASP.resource.asp.grammar.AspCardinality.ONE, ASP_1_0_0);
	public final static ASP.resource.asp.grammar.AspRule ASP_1 = new ASP.resource.asp.grammar.AspRule(ASP.ASPPackage.eINSTANCE.getRelation(), ASP_1_0, ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspEnumerationTerminal ASP_2_0_0_0 = new ASP.resource.asp.grammar.AspEnumerationTerminal(ASP.ASPPackage.eINSTANCE.getLeftPattern().getEStructuralFeature(ASP.ASPPackage.LEFT_PATTERN__TYPE), new String[] {"node", "relation_node", "prop", "relation_prop", "edge", "relation_edge", }, ASP.resource.asp.grammar.AspCardinality.ONE, 0);
	public final static ASP.resource.asp.grammar.AspWhiteSpace ASP_2_0_0_1 = new ASP.resource.asp.grammar.AspWhiteSpace(0, ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspPlaceholder ASP_2_0_0_2 = new ASP.resource.asp.grammar.AspPlaceholder(ASP.ASPPackage.eINSTANCE.getLeftPattern().getEStructuralFeature(ASP.ASPPackage.LEFT_PATTERN__ELEMENT), "QUOTED_40_41", ASP.resource.asp.grammar.AspCardinality.ONE, 0);
	public final static ASP.resource.asp.grammar.AspKeyword ASP_2_0_0_3 = new ASP.resource.asp.grammar.AspKeyword(".", ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspSequence ASP_2_0_0 = new ASP.resource.asp.grammar.AspSequence(ASP.resource.asp.grammar.AspCardinality.ONE, ASP_2_0_0_0, ASP_2_0_0_1, ASP_2_0_0_2, ASP_2_0_0_3);
	public final static ASP.resource.asp.grammar.AspChoice ASP_2_0 = new ASP.resource.asp.grammar.AspChoice(ASP.resource.asp.grammar.AspCardinality.ONE, ASP_2_0_0);
	public final static ASP.resource.asp.grammar.AspRule ASP_2 = new ASP.resource.asp.grammar.AspRule(ASP.ASPPackage.eINSTANCE.getLeftPattern(), ASP_2_0, ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspEnumerationTerminal ASP_3_0_0_0 = new ASP.resource.asp.grammar.AspEnumerationTerminal(ASP.ASPPackage.eINSTANCE.getRightPattern().getEStructuralFeature(ASP.ASPPackage.RIGHT_PATTERN__TYPE), new String[] {"node", "relation_node", "prop", "relation_prop", "edge", "relation_edge", }, ASP.resource.asp.grammar.AspCardinality.ONE, 0);
	public final static ASP.resource.asp.grammar.AspWhiteSpace ASP_3_0_0_1 = new ASP.resource.asp.grammar.AspWhiteSpace(0, ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspPlaceholder ASP_3_0_0_2 = new ASP.resource.asp.grammar.AspPlaceholder(ASP.ASPPackage.eINSTANCE.getRightPattern().getEStructuralFeature(ASP.ASPPackage.RIGHT_PATTERN__ELEMENT), "QUOTED_40_41", ASP.resource.asp.grammar.AspCardinality.ONE, 0);
	public final static ASP.resource.asp.grammar.AspKeyword ASP_3_0_0_3 = new ASP.resource.asp.grammar.AspKeyword(".", ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspSequence ASP_3_0_0 = new ASP.resource.asp.grammar.AspSequence(ASP.resource.asp.grammar.AspCardinality.ONE, ASP_3_0_0_0, ASP_3_0_0_1, ASP_3_0_0_2, ASP_3_0_0_3);
	public final static ASP.resource.asp.grammar.AspChoice ASP_3_0 = new ASP.resource.asp.grammar.AspChoice(ASP.resource.asp.grammar.AspCardinality.ONE, ASP_3_0_0);
	public final static ASP.resource.asp.grammar.AspRule ASP_3 = new ASP.resource.asp.grammar.AspRule(ASP.ASPPackage.eINSTANCE.getRightPattern(), ASP_3_0, ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspKeyword ASP_4_0_0_0 = new ASP.resource.asp.grammar.AspKeyword("metanode(", ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspPlaceholder ASP_4_0_0_1 = new ASP.resource.asp.grammar.AspPlaceholder(ASP.ASPPackage.eINSTANCE.getMetanode().getEStructuralFeature(ASP.ASPPackage.METANODE__LITERALS), "TEXT", ASP.resource.asp.grammar.AspCardinality.ONE, 1);
	public final static ASP.resource.asp.grammar.AspKeyword ASP_4_0_0_2 = new ASP.resource.asp.grammar.AspKeyword(",", ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspWhiteSpace ASP_4_0_0_3 = new ASP.resource.asp.grammar.AspWhiteSpace(1, ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspPlaceholder ASP_4_0_0_4 = new ASP.resource.asp.grammar.AspPlaceholder(ASP.ASPPackage.eINSTANCE.getMetanode().getEStructuralFeature(ASP.ASPPackage.METANODE__LITERALS), "TEXT", ASP.resource.asp.grammar.AspCardinality.ONE, 0);
	public final static ASP.resource.asp.grammar.AspKeyword ASP_4_0_0_5 = new ASP.resource.asp.grammar.AspKeyword(").", ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspLineBreak ASP_4_0_0_6 = new ASP.resource.asp.grammar.AspLineBreak(ASP.resource.asp.grammar.AspCardinality.ONE, 0);
	public final static ASP.resource.asp.grammar.AspSequence ASP_4_0_0 = new ASP.resource.asp.grammar.AspSequence(ASP.resource.asp.grammar.AspCardinality.ONE, ASP_4_0_0_0, ASP_4_0_0_1, ASP_4_0_0_2, ASP_4_0_0_3, ASP_4_0_0_4, ASP_4_0_0_5, ASP_4_0_0_6);
	public final static ASP.resource.asp.grammar.AspChoice ASP_4_0 = new ASP.resource.asp.grammar.AspChoice(ASP.resource.asp.grammar.AspCardinality.ONE, ASP_4_0_0);
	public final static ASP.resource.asp.grammar.AspRule ASP_4 = new ASP.resource.asp.grammar.AspRule(ASP.ASPPackage.eINSTANCE.getMetanode(), ASP_4_0, ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspKeyword ASP_5_0_0_0 = new ASP.resource.asp.grammar.AspKeyword("metaprop(", ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspPlaceholder ASP_5_0_0_1 = new ASP.resource.asp.grammar.AspPlaceholder(ASP.ASPPackage.eINSTANCE.getMetaprop().getEStructuralFeature(ASP.ASPPackage.METAPROP__LITERALS), "TEXT", ASP.resource.asp.grammar.AspCardinality.ONE, 2);
	public final static ASP.resource.asp.grammar.AspKeyword ASP_5_0_0_2 = new ASP.resource.asp.grammar.AspKeyword(",", ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspWhiteSpace ASP_5_0_0_3 = new ASP.resource.asp.grammar.AspWhiteSpace(1, ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspPlaceholder ASP_5_0_0_4 = new ASP.resource.asp.grammar.AspPlaceholder(ASP.ASPPackage.eINSTANCE.getMetaprop().getEStructuralFeature(ASP.ASPPackage.METAPROP__LITERALS), "TEXT", ASP.resource.asp.grammar.AspCardinality.ONE, 1);
	public final static ASP.resource.asp.grammar.AspKeyword ASP_5_0_0_5 = new ASP.resource.asp.grammar.AspKeyword(",", ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspWhiteSpace ASP_5_0_0_6 = new ASP.resource.asp.grammar.AspWhiteSpace(1, ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspPlaceholder ASP_5_0_0_7 = new ASP.resource.asp.grammar.AspPlaceholder(ASP.ASPPackage.eINSTANCE.getMetaprop().getEStructuralFeature(ASP.ASPPackage.METAPROP__LITERALS), "TEXT", ASP.resource.asp.grammar.AspCardinality.ONE, 0);
	public final static ASP.resource.asp.grammar.AspKeyword ASP_5_0_0_8 = new ASP.resource.asp.grammar.AspKeyword(").", ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspLineBreak ASP_5_0_0_9 = new ASP.resource.asp.grammar.AspLineBreak(ASP.resource.asp.grammar.AspCardinality.ONE, 0);
	public final static ASP.resource.asp.grammar.AspSequence ASP_5_0_0 = new ASP.resource.asp.grammar.AspSequence(ASP.resource.asp.grammar.AspCardinality.ONE, ASP_5_0_0_0, ASP_5_0_0_1, ASP_5_0_0_2, ASP_5_0_0_3, ASP_5_0_0_4, ASP_5_0_0_5, ASP_5_0_0_6, ASP_5_0_0_7, ASP_5_0_0_8, ASP_5_0_0_9);
	public final static ASP.resource.asp.grammar.AspChoice ASP_5_0 = new ASP.resource.asp.grammar.AspChoice(ASP.resource.asp.grammar.AspCardinality.ONE, ASP_5_0_0);
	public final static ASP.resource.asp.grammar.AspRule ASP_5 = new ASP.resource.asp.grammar.AspRule(ASP.ASPPackage.eINSTANCE.getMetaprop(), ASP_5_0, ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspKeyword ASP_6_0_0_0 = new ASP.resource.asp.grammar.AspKeyword("metaedge(", ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspPlaceholder ASP_6_0_0_1 = new ASP.resource.asp.grammar.AspPlaceholder(ASP.ASPPackage.eINSTANCE.getMetaedge().getEStructuralFeature(ASP.ASPPackage.METAEDGE__LITERALS), "TEXT", ASP.resource.asp.grammar.AspCardinality.ONE, 3);
	public final static ASP.resource.asp.grammar.AspKeyword ASP_6_0_0_2 = new ASP.resource.asp.grammar.AspKeyword(",", ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspWhiteSpace ASP_6_0_0_3 = new ASP.resource.asp.grammar.AspWhiteSpace(1, ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspPlaceholder ASP_6_0_0_4 = new ASP.resource.asp.grammar.AspPlaceholder(ASP.ASPPackage.eINSTANCE.getMetaedge().getEStructuralFeature(ASP.ASPPackage.METAEDGE__LITERALS), "TEXT", ASP.resource.asp.grammar.AspCardinality.ONE, 2);
	public final static ASP.resource.asp.grammar.AspKeyword ASP_6_0_0_5 = new ASP.resource.asp.grammar.AspKeyword(",", ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspWhiteSpace ASP_6_0_0_6 = new ASP.resource.asp.grammar.AspWhiteSpace(1, ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspPlaceholder ASP_6_0_0_7 = new ASP.resource.asp.grammar.AspPlaceholder(ASP.ASPPackage.eINSTANCE.getMetaedge().getEStructuralFeature(ASP.ASPPackage.METAEDGE__LITERALS), "TEXT", ASP.resource.asp.grammar.AspCardinality.ONE, 1);
	public final static ASP.resource.asp.grammar.AspKeyword ASP_6_0_0_8 = new ASP.resource.asp.grammar.AspKeyword(",", ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspWhiteSpace ASP_6_0_0_9 = new ASP.resource.asp.grammar.AspWhiteSpace(1, ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspPlaceholder ASP_6_0_0_10 = new ASP.resource.asp.grammar.AspPlaceholder(ASP.ASPPackage.eINSTANCE.getMetaedge().getEStructuralFeature(ASP.ASPPackage.METAEDGE__LITERALS), "TEXT", ASP.resource.asp.grammar.AspCardinality.ONE, 0);
	public final static ASP.resource.asp.grammar.AspKeyword ASP_6_0_0_11 = new ASP.resource.asp.grammar.AspKeyword(").", ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspLineBreak ASP_6_0_0_12 = new ASP.resource.asp.grammar.AspLineBreak(ASP.resource.asp.grammar.AspCardinality.ONE, 0);
	public final static ASP.resource.asp.grammar.AspSequence ASP_6_0_0 = new ASP.resource.asp.grammar.AspSequence(ASP.resource.asp.grammar.AspCardinality.ONE, ASP_6_0_0_0, ASP_6_0_0_1, ASP_6_0_0_2, ASP_6_0_0_3, ASP_6_0_0_4, ASP_6_0_0_5, ASP_6_0_0_6, ASP_6_0_0_7, ASP_6_0_0_8, ASP_6_0_0_9, ASP_6_0_0_10, ASP_6_0_0_11, ASP_6_0_0_12);
	public final static ASP.resource.asp.grammar.AspChoice ASP_6_0 = new ASP.resource.asp.grammar.AspChoice(ASP.resource.asp.grammar.AspCardinality.ONE, ASP_6_0_0);
	public final static ASP.resource.asp.grammar.AspRule ASP_6 = new ASP.resource.asp.grammar.AspRule(ASP.ASPPackage.eINSTANCE.getMetaedge(), ASP_6_0, ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspBooleanTerminal ASP_7_0_0_0 = new ASP.resource.asp.grammar.AspBooleanTerminal(ASP.ASPPackage.eINSTANCE.getNode().getEStructuralFeature(ASP.ASPPackage.NODE__IS_NODEX), "nodex(", "node(", ASP.resource.asp.grammar.AspCardinality.ONE, 0);
	public final static ASP.resource.asp.grammar.AspPlaceholder ASP_7_0_0_1 = new ASP.resource.asp.grammar.AspPlaceholder(ASP.ASPPackage.eINSTANCE.getNode().getEStructuralFeature(ASP.ASPPackage.NODE__LITERALS), "TEXT", ASP.resource.asp.grammar.AspCardinality.ONE, 2);
	public final static ASP.resource.asp.grammar.AspKeyword ASP_7_0_0_2 = new ASP.resource.asp.grammar.AspKeyword(",", ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspWhiteSpace ASP_7_0_0_3 = new ASP.resource.asp.grammar.AspWhiteSpace(1, ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspPlaceholder ASP_7_0_0_4 = new ASP.resource.asp.grammar.AspPlaceholder(ASP.ASPPackage.eINSTANCE.getNode().getEStructuralFeature(ASP.ASPPackage.NODE__LITERALS), "TEXT", ASP.resource.asp.grammar.AspCardinality.ONE, 1);
	public final static ASP.resource.asp.grammar.AspKeyword ASP_7_0_0_5 = new ASP.resource.asp.grammar.AspKeyword(",", ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspWhiteSpace ASP_7_0_0_6 = new ASP.resource.asp.grammar.AspWhiteSpace(1, ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspPlaceholder ASP_7_0_0_7 = new ASP.resource.asp.grammar.AspPlaceholder(ASP.ASPPackage.eINSTANCE.getNode().getEStructuralFeature(ASP.ASPPackage.NODE__LITERALS), "TEXT", ASP.resource.asp.grammar.AspCardinality.ONE, 0);
	public final static ASP.resource.asp.grammar.AspKeyword ASP_7_0_0_8 = new ASP.resource.asp.grammar.AspKeyword(").", ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspLineBreak ASP_7_0_0_9 = new ASP.resource.asp.grammar.AspLineBreak(ASP.resource.asp.grammar.AspCardinality.ONE, 0);
	public final static ASP.resource.asp.grammar.AspSequence ASP_7_0_0 = new ASP.resource.asp.grammar.AspSequence(ASP.resource.asp.grammar.AspCardinality.ONE, ASP_7_0_0_0, ASP_7_0_0_1, ASP_7_0_0_2, ASP_7_0_0_3, ASP_7_0_0_4, ASP_7_0_0_5, ASP_7_0_0_6, ASP_7_0_0_7, ASP_7_0_0_8, ASP_7_0_0_9);
	public final static ASP.resource.asp.grammar.AspChoice ASP_7_0 = new ASP.resource.asp.grammar.AspChoice(ASP.resource.asp.grammar.AspCardinality.ONE, ASP_7_0_0);
	public final static ASP.resource.asp.grammar.AspRule ASP_7 = new ASP.resource.asp.grammar.AspRule(ASP.ASPPackage.eINSTANCE.getNode(), ASP_7_0, ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspBooleanTerminal ASP_8_0_0_0 = new ASP.resource.asp.grammar.AspBooleanTerminal(ASP.ASPPackage.eINSTANCE.getProp().getEStructuralFeature(ASP.ASPPackage.PROP__IS_PROPX), "propx(", "prop(", ASP.resource.asp.grammar.AspCardinality.ONE, 0);
	public final static ASP.resource.asp.grammar.AspPlaceholder ASP_8_0_0_1 = new ASP.resource.asp.grammar.AspPlaceholder(ASP.ASPPackage.eINSTANCE.getProp().getEStructuralFeature(ASP.ASPPackage.PROP__LITERALS), "TEXT", ASP.resource.asp.grammar.AspCardinality.ONE, 3);
	public final static ASP.resource.asp.grammar.AspKeyword ASP_8_0_0_2 = new ASP.resource.asp.grammar.AspKeyword(",", ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspWhiteSpace ASP_8_0_0_3 = new ASP.resource.asp.grammar.AspWhiteSpace(1, ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspPlaceholder ASP_8_0_0_4 = new ASP.resource.asp.grammar.AspPlaceholder(ASP.ASPPackage.eINSTANCE.getProp().getEStructuralFeature(ASP.ASPPackage.PROP__LITERALS), "TEXT", ASP.resource.asp.grammar.AspCardinality.ONE, 2);
	public final static ASP.resource.asp.grammar.AspKeyword ASP_8_0_0_5 = new ASP.resource.asp.grammar.AspKeyword(",", ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspWhiteSpace ASP_8_0_0_6 = new ASP.resource.asp.grammar.AspWhiteSpace(1, ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspPlaceholder ASP_8_0_0_7 = new ASP.resource.asp.grammar.AspPlaceholder(ASP.ASPPackage.eINSTANCE.getProp().getEStructuralFeature(ASP.ASPPackage.PROP__LITERALS), "TEXT", ASP.resource.asp.grammar.AspCardinality.ONE, 1);
	public final static ASP.resource.asp.grammar.AspKeyword ASP_8_0_0_8 = new ASP.resource.asp.grammar.AspKeyword(",", ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspWhiteSpace ASP_8_0_0_9 = new ASP.resource.asp.grammar.AspWhiteSpace(1, ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspPlaceholder ASP_8_0_0_10 = new ASP.resource.asp.grammar.AspPlaceholder(ASP.ASPPackage.eINSTANCE.getProp().getEStructuralFeature(ASP.ASPPackage.PROP__LITERALS), "TEXT", ASP.resource.asp.grammar.AspCardinality.ONE, 0);
	public final static ASP.resource.asp.grammar.AspKeyword ASP_8_0_0_11 = new ASP.resource.asp.grammar.AspKeyword(").", ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspLineBreak ASP_8_0_0_12 = new ASP.resource.asp.grammar.AspLineBreak(ASP.resource.asp.grammar.AspCardinality.ONE, 0);
	public final static ASP.resource.asp.grammar.AspSequence ASP_8_0_0 = new ASP.resource.asp.grammar.AspSequence(ASP.resource.asp.grammar.AspCardinality.ONE, ASP_8_0_0_0, ASP_8_0_0_1, ASP_8_0_0_2, ASP_8_0_0_3, ASP_8_0_0_4, ASP_8_0_0_5, ASP_8_0_0_6, ASP_8_0_0_7, ASP_8_0_0_8, ASP_8_0_0_9, ASP_8_0_0_10, ASP_8_0_0_11, ASP_8_0_0_12);
	public final static ASP.resource.asp.grammar.AspChoice ASP_8_0 = new ASP.resource.asp.grammar.AspChoice(ASP.resource.asp.grammar.AspCardinality.ONE, ASP_8_0_0);
	public final static ASP.resource.asp.grammar.AspRule ASP_8 = new ASP.resource.asp.grammar.AspRule(ASP.ASPPackage.eINSTANCE.getProp(), ASP_8_0, ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspBooleanTerminal ASP_9_0_0_0 = new ASP.resource.asp.grammar.AspBooleanTerminal(ASP.ASPPackage.eINSTANCE.getEdge().getEStructuralFeature(ASP.ASPPackage.EDGE__IS_EDGEX), "edgex(", "edge(", ASP.resource.asp.grammar.AspCardinality.ONE, 0);
	public final static ASP.resource.asp.grammar.AspPlaceholder ASP_9_0_0_1 = new ASP.resource.asp.grammar.AspPlaceholder(ASP.ASPPackage.eINSTANCE.getEdge().getEStructuralFeature(ASP.ASPPackage.EDGE__LITERALS), "TEXT", ASP.resource.asp.grammar.AspCardinality.ONE, 4);
	public final static ASP.resource.asp.grammar.AspKeyword ASP_9_0_0_2 = new ASP.resource.asp.grammar.AspKeyword(",", ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspWhiteSpace ASP_9_0_0_3 = new ASP.resource.asp.grammar.AspWhiteSpace(1, ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspPlaceholder ASP_9_0_0_4 = new ASP.resource.asp.grammar.AspPlaceholder(ASP.ASPPackage.eINSTANCE.getEdge().getEStructuralFeature(ASP.ASPPackage.EDGE__LITERALS), "TEXT", ASP.resource.asp.grammar.AspCardinality.ONE, 3);
	public final static ASP.resource.asp.grammar.AspKeyword ASP_9_0_0_5 = new ASP.resource.asp.grammar.AspKeyword(",", ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspWhiteSpace ASP_9_0_0_6 = new ASP.resource.asp.grammar.AspWhiteSpace(1, ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspPlaceholder ASP_9_0_0_7 = new ASP.resource.asp.grammar.AspPlaceholder(ASP.ASPPackage.eINSTANCE.getEdge().getEStructuralFeature(ASP.ASPPackage.EDGE__LITERALS), "TEXT", ASP.resource.asp.grammar.AspCardinality.ONE, 2);
	public final static ASP.resource.asp.grammar.AspKeyword ASP_9_0_0_8 = new ASP.resource.asp.grammar.AspKeyword(",", ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspWhiteSpace ASP_9_0_0_9 = new ASP.resource.asp.grammar.AspWhiteSpace(1, ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspPlaceholder ASP_9_0_0_10 = new ASP.resource.asp.grammar.AspPlaceholder(ASP.ASPPackage.eINSTANCE.getEdge().getEStructuralFeature(ASP.ASPPackage.EDGE__LITERALS), "TEXT", ASP.resource.asp.grammar.AspCardinality.ONE, 1);
	public final static ASP.resource.asp.grammar.AspKeyword ASP_9_0_0_11 = new ASP.resource.asp.grammar.AspKeyword(",", ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspWhiteSpace ASP_9_0_0_12 = new ASP.resource.asp.grammar.AspWhiteSpace(1, ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspPlaceholder ASP_9_0_0_13 = new ASP.resource.asp.grammar.AspPlaceholder(ASP.ASPPackage.eINSTANCE.getEdge().getEStructuralFeature(ASP.ASPPackage.EDGE__LITERALS), "TEXT", ASP.resource.asp.grammar.AspCardinality.ONE, 0);
	public final static ASP.resource.asp.grammar.AspKeyword ASP_9_0_0_14 = new ASP.resource.asp.grammar.AspKeyword(").", ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspLineBreak ASP_9_0_0_15 = new ASP.resource.asp.grammar.AspLineBreak(ASP.resource.asp.grammar.AspCardinality.ONE, 0);
	public final static ASP.resource.asp.grammar.AspSequence ASP_9_0_0 = new ASP.resource.asp.grammar.AspSequence(ASP.resource.asp.grammar.AspCardinality.ONE, ASP_9_0_0_0, ASP_9_0_0_1, ASP_9_0_0_2, ASP_9_0_0_3, ASP_9_0_0_4, ASP_9_0_0_5, ASP_9_0_0_6, ASP_9_0_0_7, ASP_9_0_0_8, ASP_9_0_0_9, ASP_9_0_0_10, ASP_9_0_0_11, ASP_9_0_0_12, ASP_9_0_0_13, ASP_9_0_0_14, ASP_9_0_0_15);
	public final static ASP.resource.asp.grammar.AspChoice ASP_9_0 = new ASP.resource.asp.grammar.AspChoice(ASP.resource.asp.grammar.AspCardinality.ONE, ASP_9_0_0);
	public final static ASP.resource.asp.grammar.AspRule ASP_9 = new ASP.resource.asp.grammar.AspRule(ASP.ASPPackage.eINSTANCE.getEdge(), ASP_9_0, ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspPlaceholder ASP_10_0_0_0 = new ASP.resource.asp.grammar.AspPlaceholder(ASP.ASPPackage.eINSTANCE.getNamedFunction().getEStructuralFeature(ASP.ASPPackage.NAMED_FUNCTION__NAME), "TEXT", ASP.resource.asp.grammar.AspCardinality.ONE, 0);
	public final static ASP.resource.asp.grammar.AspWhiteSpace ASP_10_0_0_1 = new ASP.resource.asp.grammar.AspWhiteSpace(0, ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspKeyword ASP_10_0_0_2 = new ASP.resource.asp.grammar.AspKeyword("(", ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspWhiteSpace ASP_10_0_0_3 = new ASP.resource.asp.grammar.AspWhiteSpace(0, ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspPlaceholder ASP_10_0_0_4 = new ASP.resource.asp.grammar.AspPlaceholder(ASP.ASPPackage.eINSTANCE.getNamedFunction().getEStructuralFeature(ASP.ASPPackage.NAMED_FUNCTION__LITERALS), "TEXT", ASP.resource.asp.grammar.AspCardinality.ONE, 0);
	public final static ASP.resource.asp.grammar.AspKeyword ASP_10_0_0_5_0_0_0 = new ASP.resource.asp.grammar.AspKeyword(",", ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspWhiteSpace ASP_10_0_0_5_0_0_1 = new ASP.resource.asp.grammar.AspWhiteSpace(1, ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspPlaceholder ASP_10_0_0_5_0_0_2 = new ASP.resource.asp.grammar.AspPlaceholder(ASP.ASPPackage.eINSTANCE.getNamedFunction().getEStructuralFeature(ASP.ASPPackage.NAMED_FUNCTION__LITERALS), "TEXT", ASP.resource.asp.grammar.AspCardinality.ONE, 0);
	public final static ASP.resource.asp.grammar.AspSequence ASP_10_0_0_5_0_0 = new ASP.resource.asp.grammar.AspSequence(ASP.resource.asp.grammar.AspCardinality.ONE, ASP_10_0_0_5_0_0_0, ASP_10_0_0_5_0_0_1, ASP_10_0_0_5_0_0_2);
	public final static ASP.resource.asp.grammar.AspChoice ASP_10_0_0_5_0 = new ASP.resource.asp.grammar.AspChoice(ASP.resource.asp.grammar.AspCardinality.ONE, ASP_10_0_0_5_0_0);
	public final static ASP.resource.asp.grammar.AspCompound ASP_10_0_0_5 = new ASP.resource.asp.grammar.AspCompound(ASP_10_0_0_5_0, ASP.resource.asp.grammar.AspCardinality.STAR);
	public final static ASP.resource.asp.grammar.AspWhiteSpace ASP_10_0_0_6 = new ASP.resource.asp.grammar.AspWhiteSpace(0, ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspKeyword ASP_10_0_0_7 = new ASP.resource.asp.grammar.AspKeyword(")", ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspLineBreak ASP_10_0_0_8 = new ASP.resource.asp.grammar.AspLineBreak(ASP.resource.asp.grammar.AspCardinality.ONE, 0);
	public final static ASP.resource.asp.grammar.AspSequence ASP_10_0_0 = new ASP.resource.asp.grammar.AspSequence(ASP.resource.asp.grammar.AspCardinality.ONE, ASP_10_0_0_0, ASP_10_0_0_1, ASP_10_0_0_2, ASP_10_0_0_3, ASP_10_0_0_4, ASP_10_0_0_5, ASP_10_0_0_6, ASP_10_0_0_7, ASP_10_0_0_8);
	public final static ASP.resource.asp.grammar.AspChoice ASP_10_0 = new ASP.resource.asp.grammar.AspChoice(ASP.resource.asp.grammar.AspCardinality.ONE, ASP_10_0_0);
	public final static ASP.resource.asp.grammar.AspRule ASP_10 = new ASP.resource.asp.grammar.AspRule(ASP.ASPPackage.eINSTANCE.getNamedFunction(), ASP_10_0, ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspPlaceholder ASP_11_0_0_0_0_0_0 = new ASP.resource.asp.grammar.AspPlaceholder(ASP.ASPPackage.eINSTANCE.getRule().getEStructuralFeature(ASP.ASPPackage.RULE__COMMENT), "TEXT", ASP.resource.asp.grammar.AspCardinality.ONE, 0);
	public final static ASP.resource.asp.grammar.AspLineBreak ASP_11_0_0_0_0_0_1 = new ASP.resource.asp.grammar.AspLineBreak(ASP.resource.asp.grammar.AspCardinality.ONE, 0);
	public final static ASP.resource.asp.grammar.AspSequence ASP_11_0_0_0_0_0 = new ASP.resource.asp.grammar.AspSequence(ASP.resource.asp.grammar.AspCardinality.ONE, ASP_11_0_0_0_0_0_0, ASP_11_0_0_0_0_0_1);
	public final static ASP.resource.asp.grammar.AspChoice ASP_11_0_0_0_0 = new ASP.resource.asp.grammar.AspChoice(ASP.resource.asp.grammar.AspCardinality.ONE, ASP_11_0_0_0_0_0);
	public final static ASP.resource.asp.grammar.AspCompound ASP_11_0_0_0 = new ASP.resource.asp.grammar.AspCompound(ASP_11_0_0_0_0, ASP.resource.asp.grammar.AspCardinality.QUESTIONMARK);
	public final static ASP.resource.asp.grammar.AspContainment ASP_11_0_0_1 = new ASP.resource.asp.grammar.AspContainment(ASP.ASPPackage.eINSTANCE.getRule().getEStructuralFeature(ASP.ASPPackage.RULE__HEAD), ASP.resource.asp.grammar.AspCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {ASP.ASPPackage.eINSTANCE.getTerminal(), }, 0);
	public final static ASP.resource.asp.grammar.AspWhiteSpace ASP_11_0_0_2 = new ASP.resource.asp.grammar.AspWhiteSpace(1, ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspKeyword ASP_11_0_0_3 = new ASP.resource.asp.grammar.AspKeyword(":-", ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspWhiteSpace ASP_11_0_0_4 = new ASP.resource.asp.grammar.AspWhiteSpace(1, ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspContainment ASP_11_0_0_5 = new ASP.resource.asp.grammar.AspContainment(ASP.ASPPackage.eINSTANCE.getRule().getEStructuralFeature(ASP.ASPPackage.RULE__EXPRESSIONS), ASP.resource.asp.grammar.AspCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {ASP.ASPPackage.eINSTANCE.getExpression(), }, 0);
	public final static ASP.resource.asp.grammar.AspKeyword ASP_11_0_0_6_0_0_0 = new ASP.resource.asp.grammar.AspKeyword(",", ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspWhiteSpace ASP_11_0_0_6_0_0_1 = new ASP.resource.asp.grammar.AspWhiteSpace(1, ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspContainment ASP_11_0_0_6_0_0_2 = new ASP.resource.asp.grammar.AspContainment(ASP.ASPPackage.eINSTANCE.getRule().getEStructuralFeature(ASP.ASPPackage.RULE__EXPRESSIONS), ASP.resource.asp.grammar.AspCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {ASP.ASPPackage.eINSTANCE.getExpression(), }, 0);
	public final static ASP.resource.asp.grammar.AspSequence ASP_11_0_0_6_0_0 = new ASP.resource.asp.grammar.AspSequence(ASP.resource.asp.grammar.AspCardinality.ONE, ASP_11_0_0_6_0_0_0, ASP_11_0_0_6_0_0_1, ASP_11_0_0_6_0_0_2);
	public final static ASP.resource.asp.grammar.AspChoice ASP_11_0_0_6_0 = new ASP.resource.asp.grammar.AspChoice(ASP.resource.asp.grammar.AspCardinality.ONE, ASP_11_0_0_6_0_0);
	public final static ASP.resource.asp.grammar.AspCompound ASP_11_0_0_6 = new ASP.resource.asp.grammar.AspCompound(ASP_11_0_0_6_0, ASP.resource.asp.grammar.AspCardinality.STAR);
	public final static ASP.resource.asp.grammar.AspWhiteSpace ASP_11_0_0_7 = new ASP.resource.asp.grammar.AspWhiteSpace(0, ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspKeyword ASP_11_0_0_8 = new ASP.resource.asp.grammar.AspKeyword(",", ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspWhiteSpace ASP_11_0_0_9_0_0_0 = new ASP.resource.asp.grammar.AspWhiteSpace(1, ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspKeyword ASP_11_0_0_9_0_0_1 = new ASP.resource.asp.grammar.AspKeyword("mmt=", ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspWhiteSpace ASP_11_0_0_9_0_0_2 = new ASP.resource.asp.grammar.AspWhiteSpace(0, ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspPlaceholder ASP_11_0_0_9_0_0_3 = new ASP.resource.asp.grammar.AspPlaceholder(ASP.ASPPackage.eINSTANCE.getRule().getEStructuralFeature(ASP.ASPPackage.RULE__DIRECTION), "TEXT", ASP.resource.asp.grammar.AspCardinality.ONE, 0);
	public final static ASP.resource.asp.grammar.AspSequence ASP_11_0_0_9_0_0 = new ASP.resource.asp.grammar.AspSequence(ASP.resource.asp.grammar.AspCardinality.ONE, ASP_11_0_0_9_0_0_0, ASP_11_0_0_9_0_0_1, ASP_11_0_0_9_0_0_2, ASP_11_0_0_9_0_0_3);
	public final static ASP.resource.asp.grammar.AspChoice ASP_11_0_0_9_0 = new ASP.resource.asp.grammar.AspChoice(ASP.resource.asp.grammar.AspCardinality.ONE, ASP_11_0_0_9_0_0);
	public final static ASP.resource.asp.grammar.AspCompound ASP_11_0_0_9 = new ASP.resource.asp.grammar.AspCompound(ASP_11_0_0_9_0, ASP.resource.asp.grammar.AspCardinality.QUESTIONMARK);
	public final static ASP.resource.asp.grammar.AspWhiteSpace ASP_11_0_0_10 = new ASP.resource.asp.grammar.AspWhiteSpace(0, ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspKeyword ASP_11_0_0_11 = new ASP.resource.asp.grammar.AspKeyword(".", ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspLineBreak ASP_11_0_0_12 = new ASP.resource.asp.grammar.AspLineBreak(ASP.resource.asp.grammar.AspCardinality.ONE, 0);
	public final static ASP.resource.asp.grammar.AspSequence ASP_11_0_0 = new ASP.resource.asp.grammar.AspSequence(ASP.resource.asp.grammar.AspCardinality.ONE, ASP_11_0_0_0, ASP_11_0_0_1, ASP_11_0_0_2, ASP_11_0_0_3, ASP_11_0_0_4, ASP_11_0_0_5, ASP_11_0_0_6, ASP_11_0_0_7, ASP_11_0_0_8, ASP_11_0_0_9, ASP_11_0_0_10, ASP_11_0_0_11, ASP_11_0_0_12);
	public final static ASP.resource.asp.grammar.AspChoice ASP_11_0 = new ASP.resource.asp.grammar.AspChoice(ASP.resource.asp.grammar.AspCardinality.ONE, ASP_11_0_0);
	public final static ASP.resource.asp.grammar.AspRule ASP_11 = new ASP.resource.asp.grammar.AspRule(ASP.ASPPackage.eINSTANCE.getRule(), ASP_11_0, ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspPlaceholder ASP_12_0_0_0_0_0_0 = new ASP.resource.asp.grammar.AspPlaceholder(ASP.ASPPackage.eINSTANCE.getConstraint().getEStructuralFeature(ASP.ASPPackage.CONSTRAINT__COMMENT), "TEXT", ASP.resource.asp.grammar.AspCardinality.ONE, 0);
	public final static ASP.resource.asp.grammar.AspLineBreak ASP_12_0_0_0_0_0_1 = new ASP.resource.asp.grammar.AspLineBreak(ASP.resource.asp.grammar.AspCardinality.ONE, 0);
	public final static ASP.resource.asp.grammar.AspSequence ASP_12_0_0_0_0_0 = new ASP.resource.asp.grammar.AspSequence(ASP.resource.asp.grammar.AspCardinality.ONE, ASP_12_0_0_0_0_0_0, ASP_12_0_0_0_0_0_1);
	public final static ASP.resource.asp.grammar.AspChoice ASP_12_0_0_0_0 = new ASP.resource.asp.grammar.AspChoice(ASP.resource.asp.grammar.AspCardinality.ONE, ASP_12_0_0_0_0_0);
	public final static ASP.resource.asp.grammar.AspCompound ASP_12_0_0_0 = new ASP.resource.asp.grammar.AspCompound(ASP_12_0_0_0_0, ASP.resource.asp.grammar.AspCardinality.QUESTIONMARK);
	public final static ASP.resource.asp.grammar.AspKeyword ASP_12_0_0_1 = new ASP.resource.asp.grammar.AspKeyword(":-", ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspWhiteSpace ASP_12_0_0_2 = new ASP.resource.asp.grammar.AspWhiteSpace(1, ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspContainment ASP_12_0_0_3 = new ASP.resource.asp.grammar.AspContainment(ASP.ASPPackage.eINSTANCE.getConstraint().getEStructuralFeature(ASP.ASPPackage.CONSTRAINT__EXPRESSIONS), ASP.resource.asp.grammar.AspCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {ASP.ASPPackage.eINSTANCE.getExpression(), }, 0);
	public final static ASP.resource.asp.grammar.AspKeyword ASP_12_0_0_4_0_0_0 = new ASP.resource.asp.grammar.AspKeyword(",", ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspWhiteSpace ASP_12_0_0_4_0_0_1 = new ASP.resource.asp.grammar.AspWhiteSpace(1, ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspContainment ASP_12_0_0_4_0_0_2 = new ASP.resource.asp.grammar.AspContainment(ASP.ASPPackage.eINSTANCE.getConstraint().getEStructuralFeature(ASP.ASPPackage.CONSTRAINT__EXPRESSIONS), ASP.resource.asp.grammar.AspCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {ASP.ASPPackage.eINSTANCE.getExpression(), }, 0);
	public final static ASP.resource.asp.grammar.AspSequence ASP_12_0_0_4_0_0 = new ASP.resource.asp.grammar.AspSequence(ASP.resource.asp.grammar.AspCardinality.ONE, ASP_12_0_0_4_0_0_0, ASP_12_0_0_4_0_0_1, ASP_12_0_0_4_0_0_2);
	public final static ASP.resource.asp.grammar.AspChoice ASP_12_0_0_4_0 = new ASP.resource.asp.grammar.AspChoice(ASP.resource.asp.grammar.AspCardinality.ONE, ASP_12_0_0_4_0_0);
	public final static ASP.resource.asp.grammar.AspCompound ASP_12_0_0_4 = new ASP.resource.asp.grammar.AspCompound(ASP_12_0_0_4_0, ASP.resource.asp.grammar.AspCardinality.STAR);
	public final static ASP.resource.asp.grammar.AspWhiteSpace ASP_12_0_0_5 = new ASP.resource.asp.grammar.AspWhiteSpace(0, ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspKeyword ASP_12_0_0_6 = new ASP.resource.asp.grammar.AspKeyword(", mmt=", ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspWhiteSpace ASP_12_0_0_7 = new ASP.resource.asp.grammar.AspWhiteSpace(0, ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspPlaceholder ASP_12_0_0_8 = new ASP.resource.asp.grammar.AspPlaceholder(ASP.ASPPackage.eINSTANCE.getConstraint().getEStructuralFeature(ASP.ASPPackage.CONSTRAINT__DIRECTION), "TEXT", ASP.resource.asp.grammar.AspCardinality.ONE, 0);
	public final static ASP.resource.asp.grammar.AspWhiteSpace ASP_12_0_0_9 = new ASP.resource.asp.grammar.AspWhiteSpace(0, ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspKeyword ASP_12_0_0_10 = new ASP.resource.asp.grammar.AspKeyword(".", ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspLineBreak ASP_12_0_0_11 = new ASP.resource.asp.grammar.AspLineBreak(ASP.resource.asp.grammar.AspCardinality.ONE, 0);
	public final static ASP.resource.asp.grammar.AspSequence ASP_12_0_0 = new ASP.resource.asp.grammar.AspSequence(ASP.resource.asp.grammar.AspCardinality.ONE, ASP_12_0_0_0, ASP_12_0_0_1, ASP_12_0_0_2, ASP_12_0_0_3, ASP_12_0_0_4, ASP_12_0_0_5, ASP_12_0_0_6, ASP_12_0_0_7, ASP_12_0_0_8, ASP_12_0_0_9, ASP_12_0_0_10, ASP_12_0_0_11);
	public final static ASP.resource.asp.grammar.AspChoice ASP_12_0 = new ASP.resource.asp.grammar.AspChoice(ASP.resource.asp.grammar.AspCardinality.ONE, ASP_12_0_0);
	public final static ASP.resource.asp.grammar.AspRule ASP_12 = new ASP.resource.asp.grammar.AspRule(ASP.ASPPackage.eINSTANCE.getConstraint(), ASP_12_0, ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspPlaceholder ASP_13_0_0_0 = new ASP.resource.asp.grammar.AspPlaceholder(ASP.ASPPackage.eINSTANCE.getLiteral().getEStructuralFeature(ASP.ASPPackage.LITERAL__NAME), "TEXT", ASP.resource.asp.grammar.AspCardinality.ONE, 0);
	public final static ASP.resource.asp.grammar.AspWhiteSpace ASP_13_0_0_1_0_0_0 = new ASP.resource.asp.grammar.AspWhiteSpace(0, ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspKeyword ASP_13_0_0_1_0_0_1 = new ASP.resource.asp.grammar.AspKeyword(".", ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspSequence ASP_13_0_0_1_0_0 = new ASP.resource.asp.grammar.AspSequence(ASP.resource.asp.grammar.AspCardinality.ONE, ASP_13_0_0_1_0_0_0, ASP_13_0_0_1_0_0_1);
	public final static ASP.resource.asp.grammar.AspChoice ASP_13_0_0_1_0 = new ASP.resource.asp.grammar.AspChoice(ASP.resource.asp.grammar.AspCardinality.ONE, ASP_13_0_0_1_0_0);
	public final static ASP.resource.asp.grammar.AspCompound ASP_13_0_0_1 = new ASP.resource.asp.grammar.AspCompound(ASP_13_0_0_1_0, ASP.resource.asp.grammar.AspCardinality.QUESTIONMARK);
	public final static ASP.resource.asp.grammar.AspLineBreak ASP_13_0_0_2 = new ASP.resource.asp.grammar.AspLineBreak(ASP.resource.asp.grammar.AspCardinality.ONE, 0);
	public final static ASP.resource.asp.grammar.AspSequence ASP_13_0_0 = new ASP.resource.asp.grammar.AspSequence(ASP.resource.asp.grammar.AspCardinality.ONE, ASP_13_0_0_0, ASP_13_0_0_1, ASP_13_0_0_2);
	public final static ASP.resource.asp.grammar.AspChoice ASP_13_0 = new ASP.resource.asp.grammar.AspChoice(ASP.resource.asp.grammar.AspCardinality.ONE, ASP_13_0_0);
	public final static ASP.resource.asp.grammar.AspRule ASP_13 = new ASP.resource.asp.grammar.AspRule(ASP.ASPPackage.eINSTANCE.getLiteral(), ASP_13_0, ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspPlaceholder ASP_14_0_0_0 = new ASP.resource.asp.grammar.AspPlaceholder(ASP.ASPPackage.eINSTANCE.getTerminal().getEStructuralFeature(ASP.ASPPackage.TERMINAL__ELEMENT), "TEXT", ASP.resource.asp.grammar.AspCardinality.ONE, 0);
	public final static ASP.resource.asp.grammar.AspSequence ASP_14_0_0 = new ASP.resource.asp.grammar.AspSequence(ASP.resource.asp.grammar.AspCardinality.ONE, ASP_14_0_0_0);
	public final static ASP.resource.asp.grammar.AspChoice ASP_14_0 = new ASP.resource.asp.grammar.AspChoice(ASP.resource.asp.grammar.AspCardinality.ONE, ASP_14_0_0);
	public final static ASP.resource.asp.grammar.AspRule ASP_14 = new ASP.resource.asp.grammar.AspRule(ASP.ASPPackage.eINSTANCE.getTerminal(), ASP_14_0, ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspKeyword ASP_15_0_0_0 = new ASP.resource.asp.grammar.AspKeyword("not", ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspWhiteSpace ASP_15_0_0_1 = new ASP.resource.asp.grammar.AspWhiteSpace(1, ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspPlaceholder ASP_15_0_0_2 = new ASP.resource.asp.grammar.AspPlaceholder(ASP.ASPPackage.eINSTANCE.getNot().getEStructuralFeature(ASP.ASPPackage.NOT__ELEMENT), "TEXT", ASP.resource.asp.grammar.AspCardinality.ONE, 0);
	public final static ASP.resource.asp.grammar.AspSequence ASP_15_0_0 = new ASP.resource.asp.grammar.AspSequence(ASP.resource.asp.grammar.AspCardinality.ONE, ASP_15_0_0_0, ASP_15_0_0_1, ASP_15_0_0_2);
	public final static ASP.resource.asp.grammar.AspChoice ASP_15_0 = new ASP.resource.asp.grammar.AspChoice(ASP.resource.asp.grammar.AspCardinality.ONE, ASP_15_0_0);
	public final static ASP.resource.asp.grammar.AspRule ASP_15 = new ASP.resource.asp.grammar.AspRule(ASP.ASPPackage.eINSTANCE.getNot(), ASP_15_0, ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspPlaceholder ASP_16_0_0_0 = new ASP.resource.asp.grammar.AspPlaceholder(ASP.ASPPackage.eINSTANCE.getEq().getEStructuralFeature(ASP.ASPPackage.EQ__LEFT), "TEXT", ASP.resource.asp.grammar.AspCardinality.ONE, 0);
	public final static ASP.resource.asp.grammar.AspWhiteSpace ASP_16_0_0_1 = new ASP.resource.asp.grammar.AspWhiteSpace(1, ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspKeyword ASP_16_0_0_2 = new ASP.resource.asp.grammar.AspKeyword("==", ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspWhiteSpace ASP_16_0_0_3 = new ASP.resource.asp.grammar.AspWhiteSpace(1, ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspPlaceholder ASP_16_0_0_4 = new ASP.resource.asp.grammar.AspPlaceholder(ASP.ASPPackage.eINSTANCE.getEq().getEStructuralFeature(ASP.ASPPackage.EQ__RIGHT), "TEXT", ASP.resource.asp.grammar.AspCardinality.ONE, 0);
	public final static ASP.resource.asp.grammar.AspSequence ASP_16_0_0 = new ASP.resource.asp.grammar.AspSequence(ASP.resource.asp.grammar.AspCardinality.ONE, ASP_16_0_0_0, ASP_16_0_0_1, ASP_16_0_0_2, ASP_16_0_0_3, ASP_16_0_0_4);
	public final static ASP.resource.asp.grammar.AspChoice ASP_16_0 = new ASP.resource.asp.grammar.AspChoice(ASP.resource.asp.grammar.AspCardinality.ONE, ASP_16_0_0);
	public final static ASP.resource.asp.grammar.AspRule ASP_16 = new ASP.resource.asp.grammar.AspRule(ASP.ASPPackage.eINSTANCE.getEq(), ASP_16_0, ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspPlaceholder ASP_17_0_0_0 = new ASP.resource.asp.grammar.AspPlaceholder(ASP.ASPPackage.eINSTANCE.getNotEq().getEStructuralFeature(ASP.ASPPackage.NOT_EQ__LEFT), "TEXT", ASP.resource.asp.grammar.AspCardinality.ONE, 0);
	public final static ASP.resource.asp.grammar.AspWhiteSpace ASP_17_0_0_1 = new ASP.resource.asp.grammar.AspWhiteSpace(1, ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspKeyword ASP_17_0_0_2 = new ASP.resource.asp.grammar.AspKeyword("!=", ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspWhiteSpace ASP_17_0_0_3 = new ASP.resource.asp.grammar.AspWhiteSpace(1, ASP.resource.asp.grammar.AspCardinality.ONE);
	public final static ASP.resource.asp.grammar.AspPlaceholder ASP_17_0_0_4 = new ASP.resource.asp.grammar.AspPlaceholder(ASP.ASPPackage.eINSTANCE.getNotEq().getEStructuralFeature(ASP.ASPPackage.NOT_EQ__RIGHT), "TEXT", ASP.resource.asp.grammar.AspCardinality.ONE, 0);
	public final static ASP.resource.asp.grammar.AspSequence ASP_17_0_0 = new ASP.resource.asp.grammar.AspSequence(ASP.resource.asp.grammar.AspCardinality.ONE, ASP_17_0_0_0, ASP_17_0_0_1, ASP_17_0_0_2, ASP_17_0_0_3, ASP_17_0_0_4);
	public final static ASP.resource.asp.grammar.AspChoice ASP_17_0 = new ASP.resource.asp.grammar.AspChoice(ASP.resource.asp.grammar.AspCardinality.ONE, ASP_17_0_0);
	public final static ASP.resource.asp.grammar.AspRule ASP_17 = new ASP.resource.asp.grammar.AspRule(ASP.ASPPackage.eINSTANCE.getNotEq(), ASP_17_0, ASP.resource.asp.grammar.AspCardinality.ONE);
	
	public static String getSyntaxElementID(ASP.resource.asp.grammar.AspSyntaxElement syntaxElement) {
		if (syntaxElement == null) {
			// null indicates EOF
			return "<EOF>";
		}
		for (java.lang.reflect.Field field : ASP.resource.asp.grammar.AspGrammarInformationProvider.class.getFields()) {
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
	
	public static ASP.resource.asp.grammar.AspSyntaxElement getSyntaxElementByID(String syntaxElementID) {
		try {
			return (ASP.resource.asp.grammar.AspSyntaxElement) ASP.resource.asp.grammar.AspGrammarInformationProvider.class.getField(syntaxElementID).get(null);
		} catch (Exception e) {
			return null;
		}
	}
	
	public final static ASP.resource.asp.grammar.AspRule[] RULES = new ASP.resource.asp.grammar.AspRule[] {
		ASP_0,
		ASP_1,
		ASP_2,
		ASP_3,
		ASP_4,
		ASP_5,
		ASP_6,
		ASP_7,
		ASP_8,
		ASP_9,
		ASP_10,
		ASP_11,
		ASP_12,
		ASP_13,
		ASP_14,
		ASP_15,
		ASP_16,
		ASP_17,
	};
	
	/**
	 * Returns all keywords of the grammar. This includes all literals for boolean and
	 * enumeration terminals.
	 */
	public java.util.Set<String> getKeywords() {
		if (this.keywords == null) {
			this.keywords = new java.util.LinkedHashSet<String>();
			for (ASP.resource.asp.grammar.AspRule rule : RULES) {
				findKeywords(rule, this.keywords);
			}
		}
		return keywords;
	}
	
	/**
	 * Finds all keywords in the given element and its children and adds them to the
	 * set. This includes all literals for boolean and enumeration terminals.
	 */
	private void findKeywords(ASP.resource.asp.grammar.AspSyntaxElement element, java.util.Set<String> keywords) {
		if (element instanceof ASP.resource.asp.grammar.AspKeyword) {
			keywords.add(((ASP.resource.asp.grammar.AspKeyword) element).getValue());
		} else if (element instanceof ASP.resource.asp.grammar.AspBooleanTerminal) {
			keywords.add(((ASP.resource.asp.grammar.AspBooleanTerminal) element).getTrueLiteral());
			keywords.add(((ASP.resource.asp.grammar.AspBooleanTerminal) element).getFalseLiteral());
		} else if (element instanceof ASP.resource.asp.grammar.AspEnumerationTerminal) {
			ASP.resource.asp.grammar.AspEnumerationTerminal terminal = (ASP.resource.asp.grammar.AspEnumerationTerminal) element;
			for (String key : terminal.getLiteralMapping().keySet()) {
				keywords.add(key);
			}
		}
		for (ASP.resource.asp.grammar.AspSyntaxElement child : element.getChildren()) {
			findKeywords(child, this.keywords);
		}
	}
	
}
