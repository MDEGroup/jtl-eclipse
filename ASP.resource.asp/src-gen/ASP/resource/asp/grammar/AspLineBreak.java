/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASP.resource.asp.grammar;

public class AspLineBreak extends ASP.resource.asp.grammar.AspFormattingElement {
	
	private final int tabs;
	
	public AspLineBreak(ASP.resource.asp.grammar.AspCardinality cardinality, int tabs) {
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
