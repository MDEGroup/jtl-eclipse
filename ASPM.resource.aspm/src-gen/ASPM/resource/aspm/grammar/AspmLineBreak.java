/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPM.resource.aspm.grammar;

public class AspmLineBreak extends ASPM.resource.aspm.grammar.AspmFormattingElement {
	
	private final int tabs;
	
	public AspmLineBreak(ASPM.resource.aspm.grammar.AspmCardinality cardinality, int tabs) {
		super(cardinality);
		this.tabs = tabs;
	}
	
	public int getTabs() {
		return tabs;
	}
	
	public String toString() {
		return "!" + getTabs();
	}
	
}
