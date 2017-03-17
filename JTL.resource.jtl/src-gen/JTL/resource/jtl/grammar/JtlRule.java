/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package JTL.resource.jtl.grammar;

/**
 * A class to represent a rules in the grammar.
 */
public class JtlRule extends JTL.resource.jtl.grammar.JtlSyntaxElement {
	
	private final org.eclipse.emf.ecore.EClass metaclass;
	
	public JtlRule(org.eclipse.emf.ecore.EClass metaclass, JTL.resource.jtl.grammar.JtlChoice choice, JTL.resource.jtl.grammar.JtlCardinality cardinality) {
		super(cardinality, new JTL.resource.jtl.grammar.JtlSyntaxElement[] {choice});
		this.metaclass = metaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return metaclass;
	}
	
	public JTL.resource.jtl.grammar.JtlChoice getDefinition() {
		return (JTL.resource.jtl.grammar.JtlChoice) getChildren()[0];
	}
	
}

