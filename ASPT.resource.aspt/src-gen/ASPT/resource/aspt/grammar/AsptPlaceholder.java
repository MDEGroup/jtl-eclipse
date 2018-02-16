/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPT.resource.aspt.grammar;

/**
 * A class to represent placeholders in a grammar.
 */
public class AsptPlaceholder extends ASPT.resource.aspt.grammar.AsptTerminal {
	
	private final String tokenName;
	
	public AsptPlaceholder(org.eclipse.emf.ecore.EStructuralFeature feature, String tokenName, ASPT.resource.aspt.grammar.AsptCardinality cardinality, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.tokenName = tokenName;
	}
	
	public String getTokenName() {
		return tokenName;
	}
	
}
