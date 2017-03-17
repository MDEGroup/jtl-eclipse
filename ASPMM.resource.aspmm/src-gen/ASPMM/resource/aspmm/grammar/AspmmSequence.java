/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPMM.resource.aspmm.grammar;

public class AspmmSequence extends ASPMM.resource.aspmm.grammar.AspmmSyntaxElement {
	
	public AspmmSequence(ASPMM.resource.aspmm.grammar.AspmmCardinality cardinality, ASPMM.resource.aspmm.grammar.AspmmSyntaxElement... elements) {
		super(cardinality, elements);
	}
	
	public String toString() {
		return ASPMM.resource.aspmm.util.AspmmStringUtil.explode(getChildren(), " ");
	}
	
}
