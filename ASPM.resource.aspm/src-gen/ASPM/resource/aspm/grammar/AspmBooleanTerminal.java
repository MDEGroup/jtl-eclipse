/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPM.resource.aspm.grammar;

/**
 * A class to represent boolean terminals in a grammar.
 */
public class AspmBooleanTerminal extends ASPM.resource.aspm.grammar.AspmTerminal {
	
	private String trueLiteral;
	private String falseLiteral;
	
	public AspmBooleanTerminal(org.eclipse.emf.ecore.EStructuralFeature attribute, String trueLiteral, String falseLiteral, ASPM.resource.aspm.grammar.AspmCardinality cardinality, int mandatoryOccurrencesAfter) {
		super(attribute, cardinality, mandatoryOccurrencesAfter);
		assert attribute instanceof org.eclipse.emf.ecore.EAttribute;
		this.trueLiteral = trueLiteral;
		this.falseLiteral = falseLiteral;
	}
	
	public String getTrueLiteral() {
		return trueLiteral;
	}
	
	public String getFalseLiteral() {
		return falseLiteral;
	}
	
	public org.eclipse.emf.ecore.EAttribute getAttribute() {
		return (org.eclipse.emf.ecore.EAttribute) getFeature();
	}
	
}
