/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASP.resource.asp.grammar;

public class AspSequence extends ASP.resource.asp.grammar.AspSyntaxElement {
	
	public AspSequence(ASP.resource.asp.grammar.AspCardinality cardinality, ASP.resource.asp.grammar.AspSyntaxElement... elements) {
		super(cardinality, elements);
	}
	
	public String toString() {
		return ASP.resource.asp.util.AspStringUtil.explode(getChildren(), " ");
	}
	
}
