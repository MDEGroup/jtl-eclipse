/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPT.resource.aspt.grammar;

/**
 * A class to represent a rules in the grammar.
 */
public class AsptRule extends ASPT.resource.aspt.grammar.AsptSyntaxElement {
	
	private final org.eclipse.emf.ecore.EClass metaclass;
	
	public AsptRule(org.eclipse.emf.ecore.EClass metaclass, ASPT.resource.aspt.grammar.AsptChoice choice, ASPT.resource.aspt.grammar.AsptCardinality cardinality) {
		super(cardinality, new ASPT.resource.aspt.grammar.AsptSyntaxElement[] {choice});
		this.metaclass = metaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return metaclass;
	}
	
	public ASPT.resource.aspt.grammar.AsptChoice getDefinition() {
		return (ASPT.resource.aspt.grammar.AsptChoice) getChildren()[0];
	}
	
}

