/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package JTL.resource.jtl.grammar;

/**
 * The abstract super class for all elements of a grammar. This class provides
 * methods to traverse the grammar rules.
 */
public abstract class JtlSyntaxElement {
	
	private JtlSyntaxElement[] children;
	private JtlSyntaxElement parent;
	private JTL.resource.jtl.grammar.JtlCardinality cardinality;
	
	public JtlSyntaxElement(JTL.resource.jtl.grammar.JtlCardinality cardinality, JtlSyntaxElement[] children) {
		this.cardinality = cardinality;
		this.children = children;
		if (this.children != null) {
			for (JtlSyntaxElement child : this.children) {
				child.setParent(this);
			}
		}
	}
	
	/**
	 * Sets the parent of this syntax element. This method must be invoked at most
	 * once.
	 */
	public void setParent(JtlSyntaxElement parent) {
		assert this.parent == null;
		this.parent = parent;
	}
	
	/**
	 * Returns the parent of this syntax element. This parent is determined by the
	 * containment hierarchy in the CS model.
	 */
	public JtlSyntaxElement getParent() {
		return parent;
	}
	
	public JtlSyntaxElement[] getChildren() {
		if (children == null) {
			return new JtlSyntaxElement[0];
		}
		return children;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return parent.getMetaclass();
	}
	
	public JTL.resource.jtl.grammar.JtlCardinality getCardinality() {
		return cardinality;
	}
	
}
