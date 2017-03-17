/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package JTL.resource.jtl.grammar;

public class JtlGrammarInformationProvider {
	
	public final static org.eclipse.emf.ecore.EStructuralFeature ANONYMOUS_FEATURE = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEAttribute();
	static {
		ANONYMOUS_FEATURE.setName("_");
	}
	
	public final static JtlGrammarInformationProvider INSTANCE = new JtlGrammarInformationProvider();
	
	private java.util.Set<String> keywords;
	
	public final static JTL.resource.jtl.grammar.JtlKeyword JTL_0_0_0_0 = new JTL.resource.jtl.grammar.JtlKeyword("transformation", JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlPlaceholder JTL_0_0_0_1 = new JTL.resource.jtl.grammar.JtlPlaceholder(JTL.JTL.JTLPackage.eINSTANCE.getTransformation().getEStructuralFeature(JTL.JTL.JTLPackage.TRANSFORMATION__NAME), "TEXT", JTL.resource.jtl.grammar.JtlCardinality.ONE, 0);
	public final static JTL.resource.jtl.grammar.JtlWhiteSpace JTL_0_0_0_2 = new JTL.resource.jtl.grammar.JtlWhiteSpace(1, JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlKeyword JTL_0_0_0_3 = new JTL.resource.jtl.grammar.JtlKeyword("(", JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlContainment JTL_0_0_0_4_0_0_0 = new JTL.resource.jtl.grammar.JtlContainment(JTL.JTL.JTLPackage.eINSTANCE.getTransformation().getEStructuralFeature(JTL.JTL.JTLPackage.TRANSFORMATION__MODEL_PARAMETER), JTL.resource.jtl.grammar.JtlCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {JTL.JTL.JTLPackage.eINSTANCE.getModel(), }, 0);
	public final static JTL.resource.jtl.grammar.JtlKeyword JTL_0_0_0_4_0_0_1_0_0_0 = new JTL.resource.jtl.grammar.JtlKeyword(",", JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlWhiteSpace JTL_0_0_0_4_0_0_1_0_0_1 = new JTL.resource.jtl.grammar.JtlWhiteSpace(1, JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlContainment JTL_0_0_0_4_0_0_1_0_0_2 = new JTL.resource.jtl.grammar.JtlContainment(JTL.JTL.JTLPackage.eINSTANCE.getTransformation().getEStructuralFeature(JTL.JTL.JTLPackage.TRANSFORMATION__MODEL_PARAMETER), JTL.resource.jtl.grammar.JtlCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {JTL.JTL.JTLPackage.eINSTANCE.getModel(), }, 0);
	public final static JTL.resource.jtl.grammar.JtlSequence JTL_0_0_0_4_0_0_1_0_0 = new JTL.resource.jtl.grammar.JtlSequence(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_0_0_0_4_0_0_1_0_0_0, JTL_0_0_0_4_0_0_1_0_0_1, JTL_0_0_0_4_0_0_1_0_0_2);
	public final static JTL.resource.jtl.grammar.JtlChoice JTL_0_0_0_4_0_0_1_0 = new JTL.resource.jtl.grammar.JtlChoice(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_0_0_0_4_0_0_1_0_0);
	public final static JTL.resource.jtl.grammar.JtlCompound JTL_0_0_0_4_0_0_1 = new JTL.resource.jtl.grammar.JtlCompound(JTL_0_0_0_4_0_0_1_0, JTL.resource.jtl.grammar.JtlCardinality.STAR);
	public final static JTL.resource.jtl.grammar.JtlSequence JTL_0_0_0_4_0_0 = new JTL.resource.jtl.grammar.JtlSequence(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_0_0_0_4_0_0_0, JTL_0_0_0_4_0_0_1);
	public final static JTL.resource.jtl.grammar.JtlChoice JTL_0_0_0_4_0 = new JTL.resource.jtl.grammar.JtlChoice(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_0_0_0_4_0_0);
	public final static JTL.resource.jtl.grammar.JtlCompound JTL_0_0_0_4 = new JTL.resource.jtl.grammar.JtlCompound(JTL_0_0_0_4_0, JTL.resource.jtl.grammar.JtlCardinality.QUESTIONMARK);
	public final static JTL.resource.jtl.grammar.JtlKeyword JTL_0_0_0_5 = new JTL.resource.jtl.grammar.JtlKeyword(")", JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlWhiteSpace JTL_0_0_0_6 = new JTL.resource.jtl.grammar.JtlWhiteSpace(1, JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlKeyword JTL_0_0_0_7 = new JTL.resource.jtl.grammar.JtlKeyword("{", JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlLineBreak JTL_0_0_0_8_0_0_0 = new JTL.resource.jtl.grammar.JtlLineBreak(JTL.resource.jtl.grammar.JtlCardinality.ONE, 1);
	public final static JTL.resource.jtl.grammar.JtlContainment JTL_0_0_0_8_0_0_1 = new JTL.resource.jtl.grammar.JtlContainment(JTL.JTL.JTLPackage.eINSTANCE.getTransformation().getEStructuralFeature(JTL.JTL.JTLPackage.TRANSFORMATION__RELATION), JTL.resource.jtl.grammar.JtlCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {JTL.JTL.JTLPackage.eINSTANCE.getRelation(), }, 0);
	public final static JTL.resource.jtl.grammar.JtlSequence JTL_0_0_0_8_0_0 = new JTL.resource.jtl.grammar.JtlSequence(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_0_0_0_8_0_0_0, JTL_0_0_0_8_0_0_1);
	public final static JTL.resource.jtl.grammar.JtlChoice JTL_0_0_0_8_0 = new JTL.resource.jtl.grammar.JtlChoice(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_0_0_0_8_0_0);
	public final static JTL.resource.jtl.grammar.JtlCompound JTL_0_0_0_8 = new JTL.resource.jtl.grammar.JtlCompound(JTL_0_0_0_8_0, JTL.resource.jtl.grammar.JtlCardinality.PLUS);
	public final static JTL.resource.jtl.grammar.JtlLineBreak JTL_0_0_0_9 = new JTL.resource.jtl.grammar.JtlLineBreak(JTL.resource.jtl.grammar.JtlCardinality.ONE, 0);
	public final static JTL.resource.jtl.grammar.JtlKeyword JTL_0_0_0_10 = new JTL.resource.jtl.grammar.JtlKeyword("}", JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlSequence JTL_0_0_0 = new JTL.resource.jtl.grammar.JtlSequence(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_0_0_0_0, JTL_0_0_0_1, JTL_0_0_0_2, JTL_0_0_0_3, JTL_0_0_0_4, JTL_0_0_0_5, JTL_0_0_0_6, JTL_0_0_0_7, JTL_0_0_0_8, JTL_0_0_0_9, JTL_0_0_0_10);
	public final static JTL.resource.jtl.grammar.JtlChoice JTL_0_0 = new JTL.resource.jtl.grammar.JtlChoice(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_0_0_0);
	public final static JTL.resource.jtl.grammar.JtlRule JTL_0 = new JTL.resource.jtl.grammar.JtlRule(JTL.JTL.JTLPackage.eINSTANCE.getTransformation(), JTL_0_0, JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlPlaceholder JTL_1_0_0_0 = new JTL.resource.jtl.grammar.JtlPlaceholder(JTL.JTL.JTLPackage.eINSTANCE.getModel().getEStructuralFeature(JTL.JTL.JTLPackage.MODEL__NAME), "TEXT", JTL.resource.jtl.grammar.JtlCardinality.ONE, 0);
	public final static JTL.resource.jtl.grammar.JtlKeyword JTL_1_0_0_1 = new JTL.resource.jtl.grammar.JtlKeyword(":", JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlPlaceholder JTL_1_0_0_2 = new JTL.resource.jtl.grammar.JtlPlaceholder(JTL.JTL.JTLPackage.eINSTANCE.getModel().getEStructuralFeature(JTL.JTL.JTLPackage.MODEL__USED_PACKAGE), "TEXT", JTL.resource.jtl.grammar.JtlCardinality.ONE, 0);
	public final static JTL.resource.jtl.grammar.JtlSequence JTL_1_0_0 = new JTL.resource.jtl.grammar.JtlSequence(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_1_0_0_0, JTL_1_0_0_1, JTL_1_0_0_2);
	public final static JTL.resource.jtl.grammar.JtlChoice JTL_1_0 = new JTL.resource.jtl.grammar.JtlChoice(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_1_0_0);
	public final static JTL.resource.jtl.grammar.JtlRule JTL_1 = new JTL.resource.jtl.grammar.JtlRule(JTL.JTL.JTLPackage.eINSTANCE.getModel(), JTL_1_0, JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlBooleanTerminal JTL_2_0_0_0 = new JTL.resource.jtl.grammar.JtlBooleanTerminal(JTL.JTL.JTLPackage.eINSTANCE.getRelation().getEStructuralFeature(JTL.JTL.JTLPackage.RELATION__IS_TOP_LEVEL), "top", "", JTL.resource.jtl.grammar.JtlCardinality.ONE, 0);
	public final static JTL.resource.jtl.grammar.JtlKeyword JTL_2_0_0_1 = new JTL.resource.jtl.grammar.JtlKeyword("relation", JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlPlaceholder JTL_2_0_0_2 = new JTL.resource.jtl.grammar.JtlPlaceholder(JTL.JTL.JTLPackage.eINSTANCE.getRelation().getEStructuralFeature(JTL.JTL.JTLPackage.RELATION__NAME), "TEXT", JTL.resource.jtl.grammar.JtlCardinality.ONE, 0);
	public final static JTL.resource.jtl.grammar.JtlWhiteSpace JTL_2_0_0_3 = new JTL.resource.jtl.grammar.JtlWhiteSpace(1, JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlKeyword JTL_2_0_0_4 = new JTL.resource.jtl.grammar.JtlKeyword("{", JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlLineBreak JTL_2_0_0_5_0_0_0 = new JTL.resource.jtl.grammar.JtlLineBreak(JTL.resource.jtl.grammar.JtlCardinality.ONE, 1);
	public final static JTL.resource.jtl.grammar.JtlContainment JTL_2_0_0_5_0_0_1 = new JTL.resource.jtl.grammar.JtlContainment(JTL.JTL.JTLPackage.eINSTANCE.getRelation().getEStructuralFeature(JTL.JTL.JTLPackage.RELATION__VARIABLE), JTL.resource.jtl.grammar.JtlCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {JTL.essentialocl.EssentialoclPackage.eINSTANCE.getVariable(), }, 0);
	public final static JTL.resource.jtl.grammar.JtlSequence JTL_2_0_0_5_0_0 = new JTL.resource.jtl.grammar.JtlSequence(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_2_0_0_5_0_0_0, JTL_2_0_0_5_0_0_1);
	public final static JTL.resource.jtl.grammar.JtlChoice JTL_2_0_0_5_0 = new JTL.resource.jtl.grammar.JtlChoice(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_2_0_0_5_0_0);
	public final static JTL.resource.jtl.grammar.JtlCompound JTL_2_0_0_5 = new JTL.resource.jtl.grammar.JtlCompound(JTL_2_0_0_5_0, JTL.resource.jtl.grammar.JtlCardinality.STAR);
	public final static JTL.resource.jtl.grammar.JtlLineBreak JTL_2_0_0_6_0_0_0 = new JTL.resource.jtl.grammar.JtlLineBreak(JTL.resource.jtl.grammar.JtlCardinality.ONE, 1);
	public final static JTL.resource.jtl.grammar.JtlContainment JTL_2_0_0_6_0_0_1 = new JTL.resource.jtl.grammar.JtlContainment(JTL.JTL.JTLPackage.eINSTANCE.getRelation().getEStructuralFeature(JTL.JTL.JTLPackage.RELATION__DOMAIN), JTL.resource.jtl.grammar.JtlCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {JTL.JTL.JTLPackage.eINSTANCE.getDomain(), }, 0);
	public final static JTL.resource.jtl.grammar.JtlSequence JTL_2_0_0_6_0_0 = new JTL.resource.jtl.grammar.JtlSequence(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_2_0_0_6_0_0_0, JTL_2_0_0_6_0_0_1);
	public final static JTL.resource.jtl.grammar.JtlChoice JTL_2_0_0_6_0 = new JTL.resource.jtl.grammar.JtlChoice(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_2_0_0_6_0_0);
	public final static JTL.resource.jtl.grammar.JtlCompound JTL_2_0_0_6 = new JTL.resource.jtl.grammar.JtlCompound(JTL_2_0_0_6_0, JTL.resource.jtl.grammar.JtlCardinality.STAR);
	public final static JTL.resource.jtl.grammar.JtlLineBreak JTL_2_0_0_7_0_0_0 = new JTL.resource.jtl.grammar.JtlLineBreak(JTL.resource.jtl.grammar.JtlCardinality.ONE, 1);
	public final static JTL.resource.jtl.grammar.JtlContainment JTL_2_0_0_7_0_0_1 = new JTL.resource.jtl.grammar.JtlContainment(JTL.JTL.JTLPackage.eINSTANCE.getRelation().getEStructuralFeature(JTL.JTL.JTLPackage.RELATION__WHEN), JTL.resource.jtl.grammar.JtlCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {JTL.JTL.JTLPackage.eINSTANCE.getWhen(), }, 0);
	public final static JTL.resource.jtl.grammar.JtlSequence JTL_2_0_0_7_0_0 = new JTL.resource.jtl.grammar.JtlSequence(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_2_0_0_7_0_0_0, JTL_2_0_0_7_0_0_1);
	public final static JTL.resource.jtl.grammar.JtlChoice JTL_2_0_0_7_0 = new JTL.resource.jtl.grammar.JtlChoice(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_2_0_0_7_0_0);
	public final static JTL.resource.jtl.grammar.JtlCompound JTL_2_0_0_7 = new JTL.resource.jtl.grammar.JtlCompound(JTL_2_0_0_7_0, JTL.resource.jtl.grammar.JtlCardinality.QUESTIONMARK);
	public final static JTL.resource.jtl.grammar.JtlLineBreak JTL_2_0_0_8_0_0_0 = new JTL.resource.jtl.grammar.JtlLineBreak(JTL.resource.jtl.grammar.JtlCardinality.ONE, 1);
	public final static JTL.resource.jtl.grammar.JtlContainment JTL_2_0_0_8_0_0_1 = new JTL.resource.jtl.grammar.JtlContainment(JTL.JTL.JTLPackage.eINSTANCE.getRelation().getEStructuralFeature(JTL.JTL.JTLPackage.RELATION__WHERE), JTL.resource.jtl.grammar.JtlCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {JTL.JTL.JTLPackage.eINSTANCE.getWhere(), }, 0);
	public final static JTL.resource.jtl.grammar.JtlSequence JTL_2_0_0_8_0_0 = new JTL.resource.jtl.grammar.JtlSequence(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_2_0_0_8_0_0_0, JTL_2_0_0_8_0_0_1);
	public final static JTL.resource.jtl.grammar.JtlChoice JTL_2_0_0_8_0 = new JTL.resource.jtl.grammar.JtlChoice(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_2_0_0_8_0_0);
	public final static JTL.resource.jtl.grammar.JtlCompound JTL_2_0_0_8 = new JTL.resource.jtl.grammar.JtlCompound(JTL_2_0_0_8_0, JTL.resource.jtl.grammar.JtlCardinality.QUESTIONMARK);
	public final static JTL.resource.jtl.grammar.JtlLineBreak JTL_2_0_0_9 = new JTL.resource.jtl.grammar.JtlLineBreak(JTL.resource.jtl.grammar.JtlCardinality.ONE, 0);
	public final static JTL.resource.jtl.grammar.JtlKeyword JTL_2_0_0_10 = new JTL.resource.jtl.grammar.JtlKeyword("}", JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlSequence JTL_2_0_0 = new JTL.resource.jtl.grammar.JtlSequence(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_2_0_0_0, JTL_2_0_0_1, JTL_2_0_0_2, JTL_2_0_0_3, JTL_2_0_0_4, JTL_2_0_0_5, JTL_2_0_0_6, JTL_2_0_0_7, JTL_2_0_0_8, JTL_2_0_0_9, JTL_2_0_0_10);
	public final static JTL.resource.jtl.grammar.JtlChoice JTL_2_0 = new JTL.resource.jtl.grammar.JtlChoice(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_2_0_0);
	public final static JTL.resource.jtl.grammar.JtlRule JTL_2 = new JTL.resource.jtl.grammar.JtlRule(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL_2_0, JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlBooleanTerminal JTL_3_0_0_0 = new JTL.resource.jtl.grammar.JtlBooleanTerminal(JTL.JTL.JTLPackage.eINSTANCE.getDomain().getEStructuralFeature(JTL.JTL.JTLPackage.DOMAIN__IS_CHECKABLE), "checkonly", "", JTL.resource.jtl.grammar.JtlCardinality.ONE, 0);
	public final static JTL.resource.jtl.grammar.JtlBooleanTerminal JTL_3_0_0_1 = new JTL.resource.jtl.grammar.JtlBooleanTerminal(JTL.JTL.JTLPackage.eINSTANCE.getDomain().getEStructuralFeature(JTL.JTL.JTLPackage.DOMAIN__IS_ENFORCEABLE), "enforce", "", JTL.resource.jtl.grammar.JtlCardinality.ONE, 0);
	public final static JTL.resource.jtl.grammar.JtlKeyword JTL_3_0_0_2 = new JTL.resource.jtl.grammar.JtlKeyword("domain", JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlPlaceholder JTL_3_0_0_3 = new JTL.resource.jtl.grammar.JtlPlaceholder(JTL.JTL.JTLPackage.eINSTANCE.getDomain().getEStructuralFeature(JTL.JTL.JTLPackage.DOMAIN__NAME), "TEXT", JTL.resource.jtl.grammar.JtlCardinality.ONE, 0);
	public final static JTL.resource.jtl.grammar.JtlContainment JTL_3_0_0_4 = new JTL.resource.jtl.grammar.JtlContainment(JTL.JTL.JTLPackage.eINSTANCE.getDomain().getEStructuralFeature(JTL.JTL.JTLPackage.DOMAIN__PATTERN), JTL.resource.jtl.grammar.JtlCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {JTL.JTL.JTLPackage.eINSTANCE.getPattern(), }, 0);
	public final static JTL.resource.jtl.grammar.JtlSequence JTL_3_0_0 = new JTL.resource.jtl.grammar.JtlSequence(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_3_0_0_0, JTL_3_0_0_1, JTL_3_0_0_2, JTL_3_0_0_3, JTL_3_0_0_4);
	public final static JTL.resource.jtl.grammar.JtlChoice JTL_3_0 = new JTL.resource.jtl.grammar.JtlChoice(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_3_0_0);
	public final static JTL.resource.jtl.grammar.JtlRule JTL_3 = new JTL.resource.jtl.grammar.JtlRule(JTL.JTL.JTLPackage.eINSTANCE.getDomain(), JTL_3_0, JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlContainment JTL_4_0_0_0 = new JTL.resource.jtl.grammar.JtlContainment(JTL.JTL.JTLPackage.eINSTANCE.getPattern().getEStructuralFeature(JTL.JTL.JTLPackage.PATTERN__TEMPLATE_EXPRESSION), JTL.resource.jtl.grammar.JtlCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {JTL.template.TemplatePackage.eINSTANCE.getTemplateExp(), }, 0);
	public final static JTL.resource.jtl.grammar.JtlWhiteSpace JTL_4_0_0_1 = new JTL.resource.jtl.grammar.JtlWhiteSpace(1, JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlKeyword JTL_4_0_0_2 = new JTL.resource.jtl.grammar.JtlKeyword("{", JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlLineBreak JTL_4_0_0_3_0_0_0 = new JTL.resource.jtl.grammar.JtlLineBreak(JTL.resource.jtl.grammar.JtlCardinality.ONE, 1);
	public final static JTL.resource.jtl.grammar.JtlContainment JTL_4_0_0_3_0_0_1 = new JTL.resource.jtl.grammar.JtlContainment(JTL.JTL.JTLPackage.eINSTANCE.getPattern().getEStructuralFeature(JTL.JTL.JTLPackage.PATTERN__PREDICATE), JTL.resource.jtl.grammar.JtlCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {JTL.JTL.JTLPackage.eINSTANCE.getPredicate(), }, 0);
	public final static JTL.resource.jtl.grammar.JtlKeyword JTL_4_0_0_3_0_0_2_0_0_0 = new JTL.resource.jtl.grammar.JtlKeyword(",", JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlLineBreak JTL_4_0_0_3_0_0_2_0_0_1 = new JTL.resource.jtl.grammar.JtlLineBreak(JTL.resource.jtl.grammar.JtlCardinality.ONE, 1);
	public final static JTL.resource.jtl.grammar.JtlContainment JTL_4_0_0_3_0_0_2_0_0_2 = new JTL.resource.jtl.grammar.JtlContainment(JTL.JTL.JTLPackage.eINSTANCE.getPattern().getEStructuralFeature(JTL.JTL.JTLPackage.PATTERN__PREDICATE), JTL.resource.jtl.grammar.JtlCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {JTL.JTL.JTLPackage.eINSTANCE.getPredicate(), }, 0);
	public final static JTL.resource.jtl.grammar.JtlSequence JTL_4_0_0_3_0_0_2_0_0 = new JTL.resource.jtl.grammar.JtlSequence(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_4_0_0_3_0_0_2_0_0_0, JTL_4_0_0_3_0_0_2_0_0_1, JTL_4_0_0_3_0_0_2_0_0_2);
	public final static JTL.resource.jtl.grammar.JtlChoice JTL_4_0_0_3_0_0_2_0 = new JTL.resource.jtl.grammar.JtlChoice(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_4_0_0_3_0_0_2_0_0);
	public final static JTL.resource.jtl.grammar.JtlCompound JTL_4_0_0_3_0_0_2 = new JTL.resource.jtl.grammar.JtlCompound(JTL_4_0_0_3_0_0_2_0, JTL.resource.jtl.grammar.JtlCardinality.STAR);
	public final static JTL.resource.jtl.grammar.JtlLineBreak JTL_4_0_0_3_0_0_3 = new JTL.resource.jtl.grammar.JtlLineBreak(JTL.resource.jtl.grammar.JtlCardinality.ONE, 0);
	public final static JTL.resource.jtl.grammar.JtlSequence JTL_4_0_0_3_0_0 = new JTL.resource.jtl.grammar.JtlSequence(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_4_0_0_3_0_0_0, JTL_4_0_0_3_0_0_1, JTL_4_0_0_3_0_0_2, JTL_4_0_0_3_0_0_3);
	public final static JTL.resource.jtl.grammar.JtlChoice JTL_4_0_0_3_0 = new JTL.resource.jtl.grammar.JtlChoice(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_4_0_0_3_0_0);
	public final static JTL.resource.jtl.grammar.JtlCompound JTL_4_0_0_3 = new JTL.resource.jtl.grammar.JtlCompound(JTL_4_0_0_3_0, JTL.resource.jtl.grammar.JtlCardinality.QUESTIONMARK);
	public final static JTL.resource.jtl.grammar.JtlKeyword JTL_4_0_0_4 = new JTL.resource.jtl.grammar.JtlKeyword("};", JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlSequence JTL_4_0_0 = new JTL.resource.jtl.grammar.JtlSequence(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_4_0_0_0, JTL_4_0_0_1, JTL_4_0_0_2, JTL_4_0_0_3, JTL_4_0_0_4);
	public final static JTL.resource.jtl.grammar.JtlChoice JTL_4_0 = new JTL.resource.jtl.grammar.JtlChoice(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_4_0_0);
	public final static JTL.resource.jtl.grammar.JtlRule JTL_4 = new JTL.resource.jtl.grammar.JtlRule(JTL.JTL.JTLPackage.eINSTANCE.getPattern(), JTL_4_0, JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlKeyword JTL_5_0_0_0 = new JTL.resource.jtl.grammar.JtlKeyword("when", JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlWhiteSpace JTL_5_0_0_1 = new JTL.resource.jtl.grammar.JtlWhiteSpace(1, JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlKeyword JTL_5_0_0_2 = new JTL.resource.jtl.grammar.JtlKeyword("{", JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlLineBreak JTL_5_0_0_3_0_0_0 = new JTL.resource.jtl.grammar.JtlLineBreak(JTL.resource.jtl.grammar.JtlCardinality.ONE, 1);
	public final static JTL.resource.jtl.grammar.JtlContainment JTL_5_0_0_3_0_0_1 = new JTL.resource.jtl.grammar.JtlContainment(JTL.JTL.JTLPackage.eINSTANCE.getWhen().getEStructuralFeature(JTL.JTL.JTLPackage.WHEN__PREDICATE), JTL.resource.jtl.grammar.JtlCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {JTL.JTL.JTLPackage.eINSTANCE.getPredicate(), }, 0);
	public final static JTL.resource.jtl.grammar.JtlKeyword JTL_5_0_0_3_0_0_2 = new JTL.resource.jtl.grammar.JtlKeyword(";", JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlSequence JTL_5_0_0_3_0_0 = new JTL.resource.jtl.grammar.JtlSequence(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_5_0_0_3_0_0_0, JTL_5_0_0_3_0_0_1, JTL_5_0_0_3_0_0_2);
	public final static JTL.resource.jtl.grammar.JtlChoice JTL_5_0_0_3_0 = new JTL.resource.jtl.grammar.JtlChoice(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_5_0_0_3_0_0);
	public final static JTL.resource.jtl.grammar.JtlCompound JTL_5_0_0_3 = new JTL.resource.jtl.grammar.JtlCompound(JTL_5_0_0_3_0, JTL.resource.jtl.grammar.JtlCardinality.STAR);
	public final static JTL.resource.jtl.grammar.JtlLineBreak JTL_5_0_0_4 = new JTL.resource.jtl.grammar.JtlLineBreak(JTL.resource.jtl.grammar.JtlCardinality.ONE, 0);
	public final static JTL.resource.jtl.grammar.JtlKeyword JTL_5_0_0_5 = new JTL.resource.jtl.grammar.JtlKeyword("}", JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlSequence JTL_5_0_0 = new JTL.resource.jtl.grammar.JtlSequence(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_5_0_0_0, JTL_5_0_0_1, JTL_5_0_0_2, JTL_5_0_0_3, JTL_5_0_0_4, JTL_5_0_0_5);
	public final static JTL.resource.jtl.grammar.JtlChoice JTL_5_0 = new JTL.resource.jtl.grammar.JtlChoice(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_5_0_0);
	public final static JTL.resource.jtl.grammar.JtlRule JTL_5 = new JTL.resource.jtl.grammar.JtlRule(JTL.JTL.JTLPackage.eINSTANCE.getWhen(), JTL_5_0, JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlKeyword JTL_6_0_0_0 = new JTL.resource.jtl.grammar.JtlKeyword("where", JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlWhiteSpace JTL_6_0_0_1 = new JTL.resource.jtl.grammar.JtlWhiteSpace(1, JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlKeyword JTL_6_0_0_2 = new JTL.resource.jtl.grammar.JtlKeyword("{", JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlLineBreak JTL_6_0_0_3_0_0_0 = new JTL.resource.jtl.grammar.JtlLineBreak(JTL.resource.jtl.grammar.JtlCardinality.ONE, 1);
	public final static JTL.resource.jtl.grammar.JtlContainment JTL_6_0_0_3_0_0_1 = new JTL.resource.jtl.grammar.JtlContainment(JTL.JTL.JTLPackage.eINSTANCE.getWhere().getEStructuralFeature(JTL.JTL.JTLPackage.WHERE__PREDICATE), JTL.resource.jtl.grammar.JtlCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {JTL.JTL.JTLPackage.eINSTANCE.getPredicate(), }, 0);
	public final static JTL.resource.jtl.grammar.JtlKeyword JTL_6_0_0_3_0_0_2 = new JTL.resource.jtl.grammar.JtlKeyword(";", JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlSequence JTL_6_0_0_3_0_0 = new JTL.resource.jtl.grammar.JtlSequence(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_6_0_0_3_0_0_0, JTL_6_0_0_3_0_0_1, JTL_6_0_0_3_0_0_2);
	public final static JTL.resource.jtl.grammar.JtlChoice JTL_6_0_0_3_0 = new JTL.resource.jtl.grammar.JtlChoice(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_6_0_0_3_0_0);
	public final static JTL.resource.jtl.grammar.JtlCompound JTL_6_0_0_3 = new JTL.resource.jtl.grammar.JtlCompound(JTL_6_0_0_3_0, JTL.resource.jtl.grammar.JtlCardinality.STAR);
	public final static JTL.resource.jtl.grammar.JtlLineBreak JTL_6_0_0_4 = new JTL.resource.jtl.grammar.JtlLineBreak(JTL.resource.jtl.grammar.JtlCardinality.ONE, 0);
	public final static JTL.resource.jtl.grammar.JtlKeyword JTL_6_0_0_5 = new JTL.resource.jtl.grammar.JtlKeyword("}", JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlSequence JTL_6_0_0 = new JTL.resource.jtl.grammar.JtlSequence(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_6_0_0_0, JTL_6_0_0_1, JTL_6_0_0_2, JTL_6_0_0_3, JTL_6_0_0_4, JTL_6_0_0_5);
	public final static JTL.resource.jtl.grammar.JtlChoice JTL_6_0 = new JTL.resource.jtl.grammar.JtlChoice(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_6_0_0);
	public final static JTL.resource.jtl.grammar.JtlRule JTL_6 = new JTL.resource.jtl.grammar.JtlRule(JTL.JTL.JTLPackage.eINSTANCE.getWhere(), JTL_6_0, JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlContainment JTL_7_0_0_0 = new JTL.resource.jtl.grammar.JtlContainment(JTL.JTL.JTLPackage.eINSTANCE.getPredicate().getEStructuralFeature(JTL.JTL.JTLPackage.PREDICATE__CONDITION_EXPRESSION), JTL.resource.jtl.grammar.JtlCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {JTL.essentialocl.EssentialoclPackage.eINSTANCE.getOclExpression(), }, 0);
	public final static JTL.resource.jtl.grammar.JtlSequence JTL_7_0_0 = new JTL.resource.jtl.grammar.JtlSequence(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_7_0_0_0);
	public final static JTL.resource.jtl.grammar.JtlChoice JTL_7_0 = new JTL.resource.jtl.grammar.JtlChoice(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_7_0_0);
	public final static JTL.resource.jtl.grammar.JtlRule JTL_7 = new JTL.resource.jtl.grammar.JtlRule(JTL.JTL.JTLPackage.eINSTANCE.getPredicate(), JTL_7_0, JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlPlaceholder JTL_8_0_0_0 = new JTL.resource.jtl.grammar.JtlPlaceholder(JTL.template.TemplatePackage.eINSTANCE.getObjectTemplateExp().getEStructuralFeature(JTL.template.TemplatePackage.OBJECT_TEMPLATE_EXP__NAME), "TEXT", JTL.resource.jtl.grammar.JtlCardinality.ONE, 0);
	public final static JTL.resource.jtl.grammar.JtlWhiteSpace JTL_8_0_0_1 = new JTL.resource.jtl.grammar.JtlWhiteSpace(1, JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlKeyword JTL_8_0_0_2 = new JTL.resource.jtl.grammar.JtlKeyword(":", JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlWhiteSpace JTL_8_0_0_3_0_0_0 = new JTL.resource.jtl.grammar.JtlWhiteSpace(1, JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlPlaceholder JTL_8_0_0_3_0_0_1 = new JTL.resource.jtl.grammar.JtlPlaceholder(JTL.template.TemplatePackage.eINSTANCE.getObjectTemplateExp().getEStructuralFeature(JTL.template.TemplatePackage.OBJECT_TEMPLATE_EXP__TYPE), "TEXT", JTL.resource.jtl.grammar.JtlCardinality.ONE, 0);
	public final static JTL.resource.jtl.grammar.JtlSequence JTL_8_0_0_3_0_0 = new JTL.resource.jtl.grammar.JtlSequence(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_8_0_0_3_0_0_0, JTL_8_0_0_3_0_0_1);
	public final static JTL.resource.jtl.grammar.JtlChoice JTL_8_0_0_3_0 = new JTL.resource.jtl.grammar.JtlChoice(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_8_0_0_3_0_0);
	public final static JTL.resource.jtl.grammar.JtlCompound JTL_8_0_0_3 = new JTL.resource.jtl.grammar.JtlCompound(JTL_8_0_0_3_0, JTL.resource.jtl.grammar.JtlCardinality.QUESTIONMARK);
	public final static JTL.resource.jtl.grammar.JtlKeyword JTL_8_0_0_4_0_0_0 = new JTL.resource.jtl.grammar.JtlKeyword("::", JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlPlaceholder JTL_8_0_0_4_0_0_1 = new JTL.resource.jtl.grammar.JtlPlaceholder(JTL.template.TemplatePackage.eINSTANCE.getObjectTemplateExp().getEStructuralFeature(JTL.template.TemplatePackage.OBJECT_TEMPLATE_EXP__REFERRED_CLASS), "TEXT", JTL.resource.jtl.grammar.JtlCardinality.ONE, 0);
	public final static JTL.resource.jtl.grammar.JtlSequence JTL_8_0_0_4_0_0 = new JTL.resource.jtl.grammar.JtlSequence(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_8_0_0_4_0_0_0, JTL_8_0_0_4_0_0_1);
	public final static JTL.resource.jtl.grammar.JtlChoice JTL_8_0_0_4_0 = new JTL.resource.jtl.grammar.JtlChoice(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_8_0_0_4_0_0);
	public final static JTL.resource.jtl.grammar.JtlCompound JTL_8_0_0_4 = new JTL.resource.jtl.grammar.JtlCompound(JTL_8_0_0_4_0, JTL.resource.jtl.grammar.JtlCardinality.QUESTIONMARK);
	public final static JTL.resource.jtl.grammar.JtlWhiteSpace JTL_8_0_0_5_0_0_0 = new JTL.resource.jtl.grammar.JtlWhiteSpace(1, JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlKeyword JTL_8_0_0_5_0_0_1 = new JTL.resource.jtl.grammar.JtlKeyword("{", JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlLineBreak JTL_8_0_0_5_0_0_2_0_0_0 = new JTL.resource.jtl.grammar.JtlLineBreak(JTL.resource.jtl.grammar.JtlCardinality.ONE, 1);
	public final static JTL.resource.jtl.grammar.JtlContainment JTL_8_0_0_5_0_0_2_0_0_1 = new JTL.resource.jtl.grammar.JtlContainment(JTL.template.TemplatePackage.eINSTANCE.getObjectTemplateExp().getEStructuralFeature(JTL.template.TemplatePackage.OBJECT_TEMPLATE_EXP__INSIDE), JTL.resource.jtl.grammar.JtlCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), }, 0);
	public final static JTL.resource.jtl.grammar.JtlKeyword JTL_8_0_0_5_0_0_2_0_0_2_0_0_0 = new JTL.resource.jtl.grammar.JtlKeyword(",", JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlLineBreak JTL_8_0_0_5_0_0_2_0_0_2_0_0_1 = new JTL.resource.jtl.grammar.JtlLineBreak(JTL.resource.jtl.grammar.JtlCardinality.ONE, 1);
	public final static JTL.resource.jtl.grammar.JtlContainment JTL_8_0_0_5_0_0_2_0_0_2_0_0_2 = new JTL.resource.jtl.grammar.JtlContainment(JTL.template.TemplatePackage.eINSTANCE.getObjectTemplateExp().getEStructuralFeature(JTL.template.TemplatePackage.OBJECT_TEMPLATE_EXP__INSIDE), JTL.resource.jtl.grammar.JtlCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), }, 0);
	public final static JTL.resource.jtl.grammar.JtlSequence JTL_8_0_0_5_0_0_2_0_0_2_0_0 = new JTL.resource.jtl.grammar.JtlSequence(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_8_0_0_5_0_0_2_0_0_2_0_0_0, JTL_8_0_0_5_0_0_2_0_0_2_0_0_1, JTL_8_0_0_5_0_0_2_0_0_2_0_0_2);
	public final static JTL.resource.jtl.grammar.JtlChoice JTL_8_0_0_5_0_0_2_0_0_2_0 = new JTL.resource.jtl.grammar.JtlChoice(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_8_0_0_5_0_0_2_0_0_2_0_0);
	public final static JTL.resource.jtl.grammar.JtlCompound JTL_8_0_0_5_0_0_2_0_0_2 = new JTL.resource.jtl.grammar.JtlCompound(JTL_8_0_0_5_0_0_2_0_0_2_0, JTL.resource.jtl.grammar.JtlCardinality.STAR);
	public final static JTL.resource.jtl.grammar.JtlSequence JTL_8_0_0_5_0_0_2_0_0 = new JTL.resource.jtl.grammar.JtlSequence(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_8_0_0_5_0_0_2_0_0_0, JTL_8_0_0_5_0_0_2_0_0_1, JTL_8_0_0_5_0_0_2_0_0_2);
	public final static JTL.resource.jtl.grammar.JtlChoice JTL_8_0_0_5_0_0_2_0 = new JTL.resource.jtl.grammar.JtlChoice(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_8_0_0_5_0_0_2_0_0);
	public final static JTL.resource.jtl.grammar.JtlCompound JTL_8_0_0_5_0_0_2 = new JTL.resource.jtl.grammar.JtlCompound(JTL_8_0_0_5_0_0_2_0, JTL.resource.jtl.grammar.JtlCardinality.QUESTIONMARK);
	public final static JTL.resource.jtl.grammar.JtlLineBreak JTL_8_0_0_5_0_0_3 = new JTL.resource.jtl.grammar.JtlLineBreak(JTL.resource.jtl.grammar.JtlCardinality.ONE, 0);
	public final static JTL.resource.jtl.grammar.JtlKeyword JTL_8_0_0_5_0_0_4 = new JTL.resource.jtl.grammar.JtlKeyword("}", JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlSequence JTL_8_0_0_5_0_0 = new JTL.resource.jtl.grammar.JtlSequence(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_8_0_0_5_0_0_0, JTL_8_0_0_5_0_0_1, JTL_8_0_0_5_0_0_2, JTL_8_0_0_5_0_0_3, JTL_8_0_0_5_0_0_4);
	public final static JTL.resource.jtl.grammar.JtlChoice JTL_8_0_0_5_0 = new JTL.resource.jtl.grammar.JtlChoice(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_8_0_0_5_0_0);
	public final static JTL.resource.jtl.grammar.JtlCompound JTL_8_0_0_5 = new JTL.resource.jtl.grammar.JtlCompound(JTL_8_0_0_5_0, JTL.resource.jtl.grammar.JtlCardinality.QUESTIONMARK);
	public final static JTL.resource.jtl.grammar.JtlSequence JTL_8_0_0 = new JTL.resource.jtl.grammar.JtlSequence(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_8_0_0_0, JTL_8_0_0_1, JTL_8_0_0_2, JTL_8_0_0_3, JTL_8_0_0_4, JTL_8_0_0_5);
	public final static JTL.resource.jtl.grammar.JtlChoice JTL_8_0 = new JTL.resource.jtl.grammar.JtlChoice(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_8_0_0);
	public final static JTL.resource.jtl.grammar.JtlRule JTL_8 = new JTL.resource.jtl.grammar.JtlRule(JTL.template.TemplatePackage.eINSTANCE.getObjectTemplateExp(), JTL_8_0, JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlPlaceholder JTL_9_0_0_0 = new JTL.resource.jtl.grammar.JtlPlaceholder(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp().getEStructuralFeature(JTL.imperativeocl.ImperativeoclPackage.ASSIGN_EXP__NAME), "TEXT", JTL.resource.jtl.grammar.JtlCardinality.ONE, 0);
	public final static JTL.resource.jtl.grammar.JtlWhiteSpace JTL_9_0_0_1 = new JTL.resource.jtl.grammar.JtlWhiteSpace(1, JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlKeyword JTL_9_0_0_2 = new JTL.resource.jtl.grammar.JtlKeyword("=", JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlWhiteSpace JTL_9_0_0_3 = new JTL.resource.jtl.grammar.JtlWhiteSpace(1, JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlContainment JTL_9_0_0_4 = new JTL.resource.jtl.grammar.JtlContainment(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp().getEStructuralFeature(JTL.imperativeocl.ImperativeoclPackage.ASSIGN_EXP__VALUE), JTL.resource.jtl.grammar.JtlCardinality.STAR, new org.eclipse.emf.ecore.EClass[] {JTL.essentialocl.EssentialoclPackage.eINSTANCE.getOclExpression(), }, 0);
	public final static JTL.resource.jtl.grammar.JtlSequence JTL_9_0_0 = new JTL.resource.jtl.grammar.JtlSequence(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_9_0_0_0, JTL_9_0_0_1, JTL_9_0_0_2, JTL_9_0_0_3, JTL_9_0_0_4);
	public final static JTL.resource.jtl.grammar.JtlChoice JTL_9_0 = new JTL.resource.jtl.grammar.JtlChoice(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_9_0_0);
	public final static JTL.resource.jtl.grammar.JtlRule JTL_9 = new JTL.resource.jtl.grammar.JtlRule(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL_9_0, JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlPlaceholder JTL_10_0_0_0 = new JTL.resource.jtl.grammar.JtlPlaceholder(JTL.essentialocl.EssentialoclPackage.eINSTANCE.getOperationCallExp().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.OPERATION_CALL_EXP__NAME), "TEXT", JTL.resource.jtl.grammar.JtlCardinality.ONE, 0);
	public final static JTL.resource.jtl.grammar.JtlKeyword JTL_10_0_0_1 = new JTL.resource.jtl.grammar.JtlKeyword("(", JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlContainment JTL_10_0_0_2_0_0_0 = new JTL.resource.jtl.grammar.JtlContainment(JTL.essentialocl.EssentialoclPackage.eINSTANCE.getOperationCallExp().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.OPERATION_CALL_EXP__ARGUMENT), JTL.resource.jtl.grammar.JtlCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {JTL.essentialocl.EssentialoclPackage.eINSTANCE.getOclExpression(), }, 0);
	public final static JTL.resource.jtl.grammar.JtlKeyword JTL_10_0_0_2_0_0_1_0_0_0 = new JTL.resource.jtl.grammar.JtlKeyword(",", JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlContainment JTL_10_0_0_2_0_0_1_0_0_1 = new JTL.resource.jtl.grammar.JtlContainment(JTL.essentialocl.EssentialoclPackage.eINSTANCE.getOperationCallExp().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.OPERATION_CALL_EXP__ARGUMENT), JTL.resource.jtl.grammar.JtlCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {JTL.essentialocl.EssentialoclPackage.eINSTANCE.getOclExpression(), }, 0);
	public final static JTL.resource.jtl.grammar.JtlSequence JTL_10_0_0_2_0_0_1_0_0 = new JTL.resource.jtl.grammar.JtlSequence(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_10_0_0_2_0_0_1_0_0_0, JTL_10_0_0_2_0_0_1_0_0_1);
	public final static JTL.resource.jtl.grammar.JtlChoice JTL_10_0_0_2_0_0_1_0 = new JTL.resource.jtl.grammar.JtlChoice(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_10_0_0_2_0_0_1_0_0);
	public final static JTL.resource.jtl.grammar.JtlCompound JTL_10_0_0_2_0_0_1 = new JTL.resource.jtl.grammar.JtlCompound(JTL_10_0_0_2_0_0_1_0, JTL.resource.jtl.grammar.JtlCardinality.STAR);
	public final static JTL.resource.jtl.grammar.JtlSequence JTL_10_0_0_2_0_0 = new JTL.resource.jtl.grammar.JtlSequence(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_10_0_0_2_0_0_0, JTL_10_0_0_2_0_0_1);
	public final static JTL.resource.jtl.grammar.JtlChoice JTL_10_0_0_2_0 = new JTL.resource.jtl.grammar.JtlChoice(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_10_0_0_2_0_0);
	public final static JTL.resource.jtl.grammar.JtlCompound JTL_10_0_0_2 = new JTL.resource.jtl.grammar.JtlCompound(JTL_10_0_0_2_0, JTL.resource.jtl.grammar.JtlCardinality.QUESTIONMARK);
	public final static JTL.resource.jtl.grammar.JtlKeyword JTL_10_0_0_3 = new JTL.resource.jtl.grammar.JtlKeyword(")", JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlSequence JTL_10_0_0 = new JTL.resource.jtl.grammar.JtlSequence(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_10_0_0_0, JTL_10_0_0_1, JTL_10_0_0_2, JTL_10_0_0_3);
	public final static JTL.resource.jtl.grammar.JtlChoice JTL_10_0 = new JTL.resource.jtl.grammar.JtlChoice(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_10_0_0);
	public final static JTL.resource.jtl.grammar.JtlRule JTL_10 = new JTL.resource.jtl.grammar.JtlRule(JTL.essentialocl.EssentialoclPackage.eINSTANCE.getOperationCallExp(), JTL_10_0, JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlBooleanTerminal JTL_11_0_0_0 = new JTL.resource.jtl.grammar.JtlBooleanTerminal(JTL.essentialocl.EssentialoclPackage.eINSTANCE.getBooleanLiteralExp().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.BOOLEAN_LITERAL_EXP__BOOLEAN_SYMBOL), "true", "false", JTL.resource.jtl.grammar.JtlCardinality.ONE, 0);
	public final static JTL.resource.jtl.grammar.JtlSequence JTL_11_0_0 = new JTL.resource.jtl.grammar.JtlSequence(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_11_0_0_0);
	public final static JTL.resource.jtl.grammar.JtlChoice JTL_11_0 = new JTL.resource.jtl.grammar.JtlChoice(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_11_0_0);
	public final static JTL.resource.jtl.grammar.JtlRule JTL_11 = new JTL.resource.jtl.grammar.JtlRule(JTL.essentialocl.EssentialoclPackage.eINSTANCE.getBooleanLiteralExp(), JTL_11_0, JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlPlaceholder JTL_12_0_0_0 = new JTL.resource.jtl.grammar.JtlPlaceholder(JTL.essentialocl.EssentialoclPackage.eINSTANCE.getVariableExp().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.VARIABLE_EXP__NAME), "TEXT", JTL.resource.jtl.grammar.JtlCardinality.ONE, 0);
	public final static JTL.resource.jtl.grammar.JtlSequence JTL_12_0_0 = new JTL.resource.jtl.grammar.JtlSequence(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_12_0_0_0);
	public final static JTL.resource.jtl.grammar.JtlChoice JTL_12_0 = new JTL.resource.jtl.grammar.JtlChoice(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_12_0_0);
	public final static JTL.resource.jtl.grammar.JtlRule JTL_12 = new JTL.resource.jtl.grammar.JtlRule(JTL.essentialocl.EssentialoclPackage.eINSTANCE.getVariableExp(), JTL_12_0, JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlKeyword JTL_13_0_0_0 = new JTL.resource.jtl.grammar.JtlKeyword("|", JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlPlaceholder JTL_13_0_0_1 = new JTL.resource.jtl.grammar.JtlPlaceholder(JTL.essentialocl.EssentialoclPackage.eINSTANCE.getStringLiteralExp().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.STRING_LITERAL_EXP__NAME), "TEXT", JTL.resource.jtl.grammar.JtlCardinality.ONE, 0);
	public final static JTL.resource.jtl.grammar.JtlKeyword JTL_13_0_0_2 = new JTL.resource.jtl.grammar.JtlKeyword("|", JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlSequence JTL_13_0_0 = new JTL.resource.jtl.grammar.JtlSequence(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_13_0_0_0, JTL_13_0_0_1, JTL_13_0_0_2);
	public final static JTL.resource.jtl.grammar.JtlChoice JTL_13_0 = new JTL.resource.jtl.grammar.JtlChoice(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_13_0_0);
	public final static JTL.resource.jtl.grammar.JtlRule JTL_13 = new JTL.resource.jtl.grammar.JtlRule(JTL.essentialocl.EssentialoclPackage.eINSTANCE.getStringLiteralExp(), JTL_13_0, JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlPlaceholder JTL_14_0_0_0 = new JTL.resource.jtl.grammar.JtlPlaceholder(JTL.essentialocl.EssentialoclPackage.eINSTANCE.getVariable().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.VARIABLE__NAME), "TEXT", JTL.resource.jtl.grammar.JtlCardinality.ONE, 0);
	public final static JTL.resource.jtl.grammar.JtlWhiteSpace JTL_14_0_0_1_0_0_0 = new JTL.resource.jtl.grammar.JtlWhiteSpace(1, JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlKeyword JTL_14_0_0_1_0_0_1 = new JTL.resource.jtl.grammar.JtlKeyword(":", JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlWhiteSpace JTL_14_0_0_1_0_0_2 = new JTL.resource.jtl.grammar.JtlWhiteSpace(1, JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlPlaceholder JTL_14_0_0_1_0_0_3 = new JTL.resource.jtl.grammar.JtlPlaceholder(JTL.essentialocl.EssentialoclPackage.eINSTANCE.getVariable().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.VARIABLE__TYPE), "TEXT", JTL.resource.jtl.grammar.JtlCardinality.ONE, 0);
	public final static JTL.resource.jtl.grammar.JtlSequence JTL_14_0_0_1_0_0 = new JTL.resource.jtl.grammar.JtlSequence(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_14_0_0_1_0_0_0, JTL_14_0_0_1_0_0_1, JTL_14_0_0_1_0_0_2, JTL_14_0_0_1_0_0_3);
	public final static JTL.resource.jtl.grammar.JtlChoice JTL_14_0_0_1_0 = new JTL.resource.jtl.grammar.JtlChoice(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_14_0_0_1_0_0);
	public final static JTL.resource.jtl.grammar.JtlCompound JTL_14_0_0_1 = new JTL.resource.jtl.grammar.JtlCompound(JTL_14_0_0_1_0, JTL.resource.jtl.grammar.JtlCardinality.QUESTIONMARK);
	public final static JTL.resource.jtl.grammar.JtlKeyword JTL_14_0_0_2 = new JTL.resource.jtl.grammar.JtlKeyword(";", JTL.resource.jtl.grammar.JtlCardinality.ONE);
	public final static JTL.resource.jtl.grammar.JtlSequence JTL_14_0_0 = new JTL.resource.jtl.grammar.JtlSequence(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_14_0_0_0, JTL_14_0_0_1, JTL_14_0_0_2);
	public final static JTL.resource.jtl.grammar.JtlChoice JTL_14_0 = new JTL.resource.jtl.grammar.JtlChoice(JTL.resource.jtl.grammar.JtlCardinality.ONE, JTL_14_0_0);
	public final static JTL.resource.jtl.grammar.JtlRule JTL_14 = new JTL.resource.jtl.grammar.JtlRule(JTL.essentialocl.EssentialoclPackage.eINSTANCE.getVariable(), JTL_14_0, JTL.resource.jtl.grammar.JtlCardinality.ONE);
	
	public static String getSyntaxElementID(JTL.resource.jtl.grammar.JtlSyntaxElement syntaxElement) {
		if (syntaxElement == null) {
			// null indicates EOF
			return "<EOF>";
		}
		for (java.lang.reflect.Field field : JTL.resource.jtl.grammar.JtlGrammarInformationProvider.class.getFields()) {
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
	
	public static JTL.resource.jtl.grammar.JtlSyntaxElement getSyntaxElementByID(String syntaxElementID) {
		try {
			return (JTL.resource.jtl.grammar.JtlSyntaxElement) JTL.resource.jtl.grammar.JtlGrammarInformationProvider.class.getField(syntaxElementID).get(null);
		} catch (Exception e) {
			return null;
		}
	}
	
	public final static JTL.resource.jtl.grammar.JtlRule[] RULES = new JTL.resource.jtl.grammar.JtlRule[] {
		JTL_0,
		JTL_1,
		JTL_2,
		JTL_3,
		JTL_4,
		JTL_5,
		JTL_6,
		JTL_7,
		JTL_8,
		JTL_9,
		JTL_10,
		JTL_11,
		JTL_12,
		JTL_13,
		JTL_14,
	};
	
	/**
	 * Returns all keywords of the grammar. This includes all literals for boolean and
	 * enumeration terminals.
	 */
	public java.util.Set<String> getKeywords() {
		if (this.keywords == null) {
			this.keywords = new java.util.LinkedHashSet<String>();
			for (JTL.resource.jtl.grammar.JtlRule rule : RULES) {
				findKeywords(rule, this.keywords);
			}
		}
		return keywords;
	}
	
	/**
	 * Finds all keywords in the given element and its children and adds them to the
	 * set. This includes all literals for boolean and enumeration terminals.
	 */
	private void findKeywords(JTL.resource.jtl.grammar.JtlSyntaxElement element, java.util.Set<String> keywords) {
		if (element instanceof JTL.resource.jtl.grammar.JtlKeyword) {
			keywords.add(((JTL.resource.jtl.grammar.JtlKeyword) element).getValue());
		} else if (element instanceof JTL.resource.jtl.grammar.JtlBooleanTerminal) {
			keywords.add(((JTL.resource.jtl.grammar.JtlBooleanTerminal) element).getTrueLiteral());
			keywords.add(((JTL.resource.jtl.grammar.JtlBooleanTerminal) element).getFalseLiteral());
		} else if (element instanceof JTL.resource.jtl.grammar.JtlEnumerationTerminal) {
			JTL.resource.jtl.grammar.JtlEnumerationTerminal terminal = (JTL.resource.jtl.grammar.JtlEnumerationTerminal) element;
			for (String key : terminal.getLiteralMapping().keySet()) {
				keywords.add(key);
			}
		}
		for (JTL.resource.jtl.grammar.JtlSyntaxElement child : element.getChildren()) {
			findKeywords(child, this.keywords);
		}
	}
	
}
