/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package JTL.resource.jtl.grammar;

public class JtlChoice extends JTL.resource.jtl.grammar.JtlSyntaxElement {
	
	public JtlChoice(JTL.resource.jtl.grammar.JtlCardinality cardinality, JTL.resource.jtl.grammar.JtlSyntaxElement... choices) {
		super(cardinality, choices);
	}
	
	public String toString() {
		return JTL.resource.jtl.util.JtlStringUtil.explode(getChildren(), "|");
	}
	
}
