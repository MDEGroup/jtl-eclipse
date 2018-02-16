/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPT.resource.aspt.grammar;

public class AsptWhiteSpace extends ASPT.resource.aspt.grammar.AsptFormattingElement {
	
	private final int amount;
	
	public AsptWhiteSpace(int amount, ASPT.resource.aspt.grammar.AsptCardinality cardinality) {
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
