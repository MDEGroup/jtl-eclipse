/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPMM.resource.aspmm.grammar;

/**
 * A class to represent placeholders in a grammar.
 */
public class AspmmPlaceholder extends ASPMM.resource.aspmm.grammar.AspmmTerminal {
	
	private final String tokenName;
	
	public AspmmPlaceholder(org.eclipse.emf.ecore.EStructuralFeature feature, String tokenName, ASPMM.resource.aspmm.grammar.AspmmCardinality cardinality, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.tokenName = tokenName;
	}
	
	public String getTokenName() {
		return tokenName;
	}
	
}
