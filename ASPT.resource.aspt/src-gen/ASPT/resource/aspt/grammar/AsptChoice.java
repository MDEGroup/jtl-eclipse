/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPT.resource.aspt.grammar;

public class AsptChoice extends ASPT.resource.aspt.grammar.AsptSyntaxElement {
	
	public AsptChoice(ASPT.resource.aspt.grammar.AsptCardinality cardinality, ASPT.resource.aspt.grammar.AsptSyntaxElement... choices) {
		super(cardinality, choices);
	}
	
	public String toString() {
		return ASPT.resource.aspt.util.AsptStringUtil.explode(getChildren(), "|");
	}
	
}
