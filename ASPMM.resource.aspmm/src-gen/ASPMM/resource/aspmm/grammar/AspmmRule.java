/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPMM.resource.aspmm.grammar;

/**
 * A class to represent a rules in the grammar.
 */
public class AspmmRule extends ASPMM.resource.aspmm.grammar.AspmmSyntaxElement {
	
	private final org.eclipse.emf.ecore.EClass metaclass;
	
	public AspmmRule(org.eclipse.emf.ecore.EClass metaclass, ASPMM.resource.aspmm.grammar.AspmmChoice choice, ASPMM.resource.aspmm.grammar.AspmmCardinality cardinality) {
		super(cardinality, new ASPMM.resource.aspmm.grammar.AspmmSyntaxElement[] {choice});
		this.metaclass = metaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return metaclass;
	}
	
	public ASPMM.resource.aspmm.grammar.AspmmChoice getDefinition() {
		return (ASPMM.resource.aspmm.grammar.AspmmChoice) getChildren()[0];
	}
	
}

