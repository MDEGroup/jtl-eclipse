/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package JTL.resource.jtl.grammar;

/**
 * A class to represent a keyword in the grammar.
 */
public class JtlKeyword extends JTL.resource.jtl.grammar.JtlSyntaxElement {
	
	private final String value;
	
	public JtlKeyword(String value, JTL.resource.jtl.grammar.JtlCardinality cardinality) {
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
