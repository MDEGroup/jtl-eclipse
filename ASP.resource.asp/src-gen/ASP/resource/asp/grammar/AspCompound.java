/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASP.resource.asp.grammar;

public class AspCompound extends ASP.resource.asp.grammar.AspSyntaxElement {
	
	public AspCompound(ASP.resource.asp.grammar.AspChoice choice, ASP.resource.asp.grammar.AspCardinality cardinality) {
		super(cardinality, new ASP.resource.asp.grammar.AspSyntaxElement[] {choice});
	}
	
	public String toString() {
		return "(" + getChildren()[0] + ")";
	}
	
}
