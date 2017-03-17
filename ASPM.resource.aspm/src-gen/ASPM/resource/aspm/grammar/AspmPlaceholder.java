/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPM.resource.aspm.grammar;

/**
 * A class to represent placeholders in a grammar.
 */
public class AspmPlaceholder extends ASPM.resource.aspm.grammar.AspmTerminal {
	
	private final String tokenName;
	
	public AspmPlaceholder(org.eclipse.emf.ecore.EStructuralFeature feature, String tokenName, ASPM.resource.aspm.grammar.AspmCardinality cardinality, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.tokenName = tokenName;
	}
	
	public String getTokenName() {
		return tokenName;
	}
	
}
