/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package JTL.resource.jtl.grammar;

/**
 * A class to represent boolean terminals in a grammar.
 */
public class JtlBooleanTerminal extends JTL.resource.jtl.grammar.JtlTerminal {
	
	private String trueLiteral;
	private String falseLiteral;
	
	public JtlBooleanTerminal(org.eclipse.emf.ecore.EStructuralFeature attribute, String trueLiteral, String falseLiteral, JTL.resource.jtl.grammar.JtlCardinality cardinality, int mandatoryOccurrencesAfter) {
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
