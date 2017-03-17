/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPMM.resource.aspmm.grammar;

public class AspmmChoice extends ASPMM.resource.aspmm.grammar.AspmmSyntaxElement {
	
	public AspmmChoice(ASPMM.resource.aspmm.grammar.AspmmCardinality cardinality, ASPMM.resource.aspmm.grammar.AspmmSyntaxElement... choices) {
		super(cardinality, choices);
	}
	
	public String toString() {
		return ASPMM.resource.aspmm.util.AspmmStringUtil.explode(getChildren(), "|");
	}
	
}
