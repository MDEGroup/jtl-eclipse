/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPMM.resource.aspmm.grammar;

public class AspmmWhiteSpace extends ASPMM.resource.aspmm.grammar.AspmmFormattingElement {
	
	private final int amount;
	
	public AspmmWhiteSpace(int amount, ASPMM.resource.aspmm.grammar.AspmmCardinality cardinality) {
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
