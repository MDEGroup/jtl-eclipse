/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPM.resource.aspm.grammar;

/**
 * A class to represent a keyword in the grammar.
 */
public class AspmKeyword extends ASPM.resource.aspm.grammar.AspmSyntaxElement {
	
	private final String value;
	
	public AspmKeyword(String value, ASPM.resource.aspm.grammar.AspmCardinality cardinality) {
		super(cardinality, null);
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public String toString() {
		return value;
	}
	
}
