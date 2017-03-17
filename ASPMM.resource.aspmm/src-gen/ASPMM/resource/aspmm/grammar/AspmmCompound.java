/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPMM.resource.aspmm.grammar;

public class AspmmCompound extends ASPMM.resource.aspmm.grammar.AspmmSyntaxElement {
	
	public AspmmCompound(ASPMM.resource.aspmm.grammar.AspmmChoice choice, ASPMM.resource.aspmm.grammar.AspmmCardinality cardinality) {
		super(cardinality, new ASPMM.resource.aspmm.grammar.AspmmSyntaxElement[] {choice});
	}
	
	public String toString() {
		return "(" + getChildren()[0] + ")";
	}
	
}
