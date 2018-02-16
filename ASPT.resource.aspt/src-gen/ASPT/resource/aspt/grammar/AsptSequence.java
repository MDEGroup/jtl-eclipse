/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPT.resource.aspt.grammar;

public class AsptSequence extends ASPT.resource.aspt.grammar.AsptSyntaxElement {
	
	public AsptSequence(ASPT.resource.aspt.grammar.AsptCardinality cardinality, ASPT.resource.aspt.grammar.AsptSyntaxElement... elements) {
		super(cardinality, elements);
	}
	
	public String toString() {
		return ASPT.resource.aspt.util.AsptStringUtil.explode(getChildren(), " ");
	}
	
}
