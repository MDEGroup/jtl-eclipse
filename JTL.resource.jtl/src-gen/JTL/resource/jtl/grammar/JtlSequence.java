/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package JTL.resource.jtl.grammar;

public class JtlSequence extends JTL.resource.jtl.grammar.JtlSyntaxElement {
	
	public JtlSequence(JTL.resource.jtl.grammar.JtlCardinality cardinality, JTL.resource.jtl.grammar.JtlSyntaxElement... elements) {
		super(cardinality, elements);
	}
	
	public String toString() {
		return JTL.resource.jtl.util.JtlStringUtil.explode(getChildren(), " ");
	}
	
}
