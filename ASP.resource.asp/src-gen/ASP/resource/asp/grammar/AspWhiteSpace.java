/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASP.resource.asp.grammar;

public class AspWhiteSpace extends ASP.resource.asp.grammar.AspFormattingElement {
	
	private final int amount;
	
	public AspWhiteSpace(int amount, ASP.resource.asp.grammar.AspCardinality cardinality) {
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
