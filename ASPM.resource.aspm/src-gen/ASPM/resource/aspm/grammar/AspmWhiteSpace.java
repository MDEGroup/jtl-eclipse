/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPM.resource.aspm.grammar;

public class AspmWhiteSpace extends ASPM.resource.aspm.grammar.AspmFormattingElement {
	
	private final int amount;
	
	public AspmWhiteSpace(int amount, ASPM.resource.aspm.grammar.AspmCardinality cardinality) {
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
