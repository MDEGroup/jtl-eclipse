/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASP.resource.asp.grammar;

/**
 * A class to represent boolean terminals in a grammar.
 */
public class AspBooleanTerminal extends ASP.resource.asp.grammar.AspTerminal {
	
	private String trueLiteral;
	private String falseLiteral;
	
	public AspBooleanTerminal(org.eclipse.emf.ecore.EStructuralFeature attribute, String trueLiteral, String falseLiteral, ASP.resource.asp.grammar.AspCardinality cardinality, int mandatoryOccurrencesAfter) {
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
