/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package JTL.resource.jtl.grammar;

public class JtlWhiteSpace extends JTL.resource.jtl.grammar.JtlFormattingElement {
	
	private final int amount;
	
	public JtlWhiteSpace(int amount, JTL.resource.jtl.grammar.JtlCardinality cardinality) {
		super(cardinality);
		this.amount = amount;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public String toString() {
		return "#" + getAmount();
	}
	
}
