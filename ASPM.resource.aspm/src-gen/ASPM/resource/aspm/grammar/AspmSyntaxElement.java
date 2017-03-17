/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPM.resource.aspm.grammar;

/**
 * The abstract super class for all elements of a grammar. This class provides
 * methods to traverse the grammar rules.
 */
public abstract class AspmSyntaxElement {
	
	private AspmSyntaxElement[] children;
	private AspmSyntaxElement parent;
	private ASPM.resource.aspm.grammar.AspmCardinality cardinality;
	
	public AspmSyntaxElement(ASPM.resource.aspm.grammar.AspmCardinality cardinality, AspmSyntaxElement[] children) {
		this.cardinality = cardinality;
		this.children = children;
		if (this.children != null) {
			for (AspmSyntaxElement child : this.children) {
				child.setParent(this);
			}
		}
	}
	
	/**
	 * Sets the parent of this syntax element. This method must be invoked at most
	 * once.
	 */
	public void setParent(AspmSyntaxElement parent) {
		assert this.parent == null;
		this.parent = parent;
	}
	
	/**
	 * Returns the parent of this syntax element. This parent is determined by the
	 * containment hierarchy in the CS model.
	 */
	public AspmSyntaxElement getParent() {
		return parent;
	}
	
	public AspmSyntaxElement[] getChildren() {
		if (children == null) {
			return new AspmSyntaxElement[0];
		}
		return children;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return parent.getMetaclass();
	}
	
	public ASPM.resource.aspm.grammar.AspmCardinality getCardinality() {
		return cardinality;
	}
	
}
