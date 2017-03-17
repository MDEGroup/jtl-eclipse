/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package JTL.resource.jtl.grammar;

public class JtlLineBreak extends JTL.resource.jtl.grammar.JtlFormattingElement {
	
	private final int tabs;
	
	public JtlLineBreak(JTL.resource.jtl.grammar.JtlCardinality cardinality, int tabs) {
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
