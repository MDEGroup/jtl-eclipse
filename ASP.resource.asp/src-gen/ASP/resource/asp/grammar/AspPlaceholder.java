/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASP.resource.asp.grammar;

/**
 * A class to represent placeholders in a grammar.
 */
public class AspPlaceholder extends ASP.resource.asp.grammar.AspTerminal {
	
	private final String tokenName;
	
	public AspPlaceholder(org.eclipse.emf.ecore.EStructuralFeature feature, String tokenName, ASP.resource.asp.grammar.AspCardinality cardinality, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.tokenName = tokenName;
	}
	
	public String getTokenName() {
		return tokenName;
	}
	
}
