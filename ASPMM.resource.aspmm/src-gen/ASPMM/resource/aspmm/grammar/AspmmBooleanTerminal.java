/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPMM.resource.aspmm.grammar;

/**
 * A class to represent boolean terminals in a grammar.
 */
public class AspmmBooleanTerminal extends ASPMM.resource.aspmm.grammar.AspmmTerminal {
	
	private String trueLiteral;
	private String falseLiteral;
	
	public AspmmBooleanTerminal(org.eclipse.emf.ecore.EStructuralFeature attribute, String trueLiteral, String falseLiteral, ASPMM.resource.aspmm.grammar.AspmmCardinality cardinality, int mandatoryOccurrencesAfter) {
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
