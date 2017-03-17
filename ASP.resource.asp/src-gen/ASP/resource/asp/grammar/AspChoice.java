/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASP.resource.asp.grammar;

public class AspChoice extends ASP.resource.asp.grammar.AspSyntaxElement {
	
	public AspChoice(ASP.resource.asp.grammar.AspCardinality cardinality, ASP.resource.asp.grammar.AspSyntaxElement... choices) {
		super(cardinality, choices);
	}
	
	public String toString() {
		return ASP.resource.asp.util.AspStringUtil.explode(getChildren(), "|");
	}
	
}
