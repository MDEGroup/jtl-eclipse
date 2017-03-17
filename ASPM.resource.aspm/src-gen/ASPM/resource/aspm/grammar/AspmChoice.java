/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPM.resource.aspm.grammar;

public class AspmChoice extends ASPM.resource.aspm.grammar.AspmSyntaxElement {
	
	public AspmChoice(ASPM.resource.aspm.grammar.AspmCardinality cardinality, ASPM.resource.aspm.grammar.AspmSyntaxElement... choices) {
		super(cardinality, choices);
	}
	
	public String toString() {
		return ASPM.resource.aspm.util.AspmStringUtil.explode(getChildren(), "|");
	}
	
}
