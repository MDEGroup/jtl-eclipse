/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASP.resource.asp.grammar;

/**
 * A class to represent a keyword in the grammar.
 */
public class AspKeyword extends ASP.resource.asp.grammar.AspSyntaxElement {
	
	private final String value;
	
	public AspKeyword(String value, ASP.resource.asp.grammar.AspCardinality cardinality) {
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
