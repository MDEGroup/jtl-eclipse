/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package JTL.resource.jtl.grammar;

/**
 * A class to represent placeholders in a grammar.
 */
public class JtlPlaceholder extends JTL.resource.jtl.grammar.JtlTerminal {
	
	private final String tokenName;
	
	public JtlPlaceholder(org.eclipse.emf.ecore.EStructuralFeature feature, String tokenName, JTL.resource.jtl.grammar.JtlCardinality cardinality, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.tokenName = tokenName;
	}
	
	public String getTokenName() {
		return tokenName;
	}
	
}
