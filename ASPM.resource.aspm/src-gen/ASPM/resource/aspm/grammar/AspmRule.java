/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPM.resource.aspm.grammar;

/**
 * A class to represent a rules in the grammar.
 */
public class AspmRule extends ASPM.resource.aspm.grammar.AspmSyntaxElement {
	
	private final org.eclipse.emf.ecore.EClass metaclass;
	
	public AspmRule(org.eclipse.emf.ecore.EClass metaclass, ASPM.resource.aspm.grammar.AspmChoice choice, ASPM.resource.aspm.grammar.AspmCardinality cardinality) {
		super(cardinality, new ASPM.resource.aspm.grammar.AspmSyntaxElement[] {choice});
		this.metaclass = metaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return metaclass;
	}
	
	public ASPM.resource.aspm.grammar.AspmChoice getDefinition() {
		return (ASPM.resource.aspm.grammar.AspmChoice) getChildren()[0];
	}
	
}

