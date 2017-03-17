/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package JTL.resource.jtl.grammar;

public class JtlCompound extends JTL.resource.jtl.grammar.JtlSyntaxElement {
	
	public JtlCompound(JTL.resource.jtl.grammar.JtlChoice choice, JTL.resource.jtl.grammar.JtlCardinality cardinality) {
		super(cardinality, new JTL.resource.jtl.grammar.JtlSyntaxElement[] {choice});
	}
	
	public String toString() {
		return "(" + getChildren()[0] + ")";
	}
	
}
