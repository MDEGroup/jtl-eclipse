/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPM.resource.aspm.grammar;

public class AspmSequence extends ASPM.resource.aspm.grammar.AspmSyntaxElement {
	
	public AspmSequence(ASPM.resource.aspm.grammar.AspmCardinality cardinality, ASPM.resource.aspm.grammar.AspmSyntaxElement... elements) {
		super(cardinality, elements);
	}
	
	public String toString() {
		return ASPM.resource.aspm.util.AspmStringUtil.explode(getChildren(), " ");
	}
	
}
