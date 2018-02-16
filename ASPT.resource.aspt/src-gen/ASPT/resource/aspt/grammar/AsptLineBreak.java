/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPT.resource.aspt.grammar;

public class AsptLineBreak extends ASPT.resource.aspt.grammar.AsptFormattingElement {
	
	private final int tabs;
	
	public AsptLineBreak(ASPT.resource.aspt.grammar.AsptCardinality cardinality, int tabs) {
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
