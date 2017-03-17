/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASP.resource.asp.grammar;

/**
 * A class to represent a rules in the grammar.
 */
public class AspRule extends ASP.resource.asp.grammar.AspSyntaxElement {
	
	private final org.eclipse.emf.ecore.EClass metaclass;
	
	public AspRule(org.eclipse.emf.ecore.EClass metaclass, ASP.resource.asp.grammar.AspChoice choice, ASP.resource.asp.grammar.AspCardinality cardinality) {
		super(cardinality, new ASP.resource.asp.grammar.AspSyntaxElement[] {choice});
		this.metaclass = metaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return metaclass;
	}
	
	public ASP.resource.asp.grammar.AspChoice getDefinition() {
		return (ASP.resource.asp.grammar.AspChoice) getChildren()[0];
	}
	
}

