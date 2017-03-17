/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPMM.resource.aspmm.grammar;

/**
 * A class to represent a keyword in the grammar.
 */
public class AspmmKeyword extends ASPMM.resource.aspmm.grammar.AspmmSyntaxElement {
	
	private final String value;
	
	public AspmmKeyword(String value, ASPMM.resource.aspmm.grammar.AspmmCardinality cardinality) {
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
