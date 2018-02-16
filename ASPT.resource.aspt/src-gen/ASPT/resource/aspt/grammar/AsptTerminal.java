/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPT.resource.aspt.grammar;

public class AsptTerminal extends ASPT.resource.aspt.grammar.AsptSyntaxElement {
	
	private final org.eclipse.emf.ecore.EStructuralFeature feature;
	private final int mandatoryOccurencesAfter;
	
	public AsptTerminal(org.eclipse.emf.ecore.EStructuralFeature feature, ASPT.resource.aspt.grammar.AsptCardinality cardinality, int mandatoryOccurencesAfter) {
		super(cardinality, null);
		this.feature = feature;
		this.mandatoryOccurencesAfter = mandatoryOccurencesAfter;
	}
	
	public org.eclipse.emf.ecore.EStructuralFeature getFeature() {
		return feature;
	}
	
	public int getMandatoryOccurencesAfter() {
		return mandatoryOccurencesAfter;
	}
	
	public String toString() {
		return feature.getName() + "[]";
	}
	
}
