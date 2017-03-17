/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPM.resource.aspm.grammar;

public class AspmCompound extends ASPM.resource.aspm.grammar.AspmSyntaxElement {
	
	public AspmCompound(ASPM.resource.aspm.grammar.AspmChoice choice, ASPM.resource.aspm.grammar.AspmCardinality cardinality) {
		super(cardinality, new ASPM.resource.aspm.grammar.AspmSyntaxElement[] {choice});
	}
	
	public String toString() {
		return "(" + getChildren()[0] + ")";
	}
	
}
