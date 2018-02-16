/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPT.resource.aspt.grammar;

public class AsptCompound extends ASPT.resource.aspt.grammar.AsptSyntaxElement {
	
	public AsptCompound(ASPT.resource.aspt.grammar.AsptChoice choice, ASPT.resource.aspt.grammar.AsptCardinality cardinality) {
		super(cardinality, new ASPT.resource.aspt.grammar.AsptSyntaxElement[] {choice});
	}
	
	public String toString() {
		return "(" + getChildren()[0] + ")";
	}
	
}
