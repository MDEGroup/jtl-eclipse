/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPMM.resource.aspmm.grammar;

public class AspmmLineBreak extends ASPMM.resource.aspmm.grammar.AspmmFormattingElement {
	
	private final int tabs;
	
	public AspmmLineBreak(ASPMM.resource.aspmm.grammar.AspmmCardinality cardinality, int tabs) {
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
