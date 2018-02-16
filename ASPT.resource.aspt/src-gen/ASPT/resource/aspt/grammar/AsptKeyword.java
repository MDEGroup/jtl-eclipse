/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPT.resource.aspt.grammar;

/**
 * A class to represent a keyword in the grammar.
 */
public class AsptKeyword extends ASPT.resource.aspt.grammar.AsptSyntaxElement {
	
	private final String value;
	
	public AsptKeyword(String value, ASPT.resource.aspt.grammar.AsptCardinality cardinality) {
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
