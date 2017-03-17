/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPMM.resource.aspmm.grammar;

/**
 * The abstract super class for all elements of a grammar. This class provides
 * methods to traverse the grammar rules.
 */
public abstract class AspmmSyntaxElement {
	
	private AspmmSyntaxElement[] children;
	private AspmmSyntaxElement parent;
	private ASPMM.resource.aspmm.grammar.AspmmCardinality cardinality;
	
	public AspmmSyntaxElement(ASPMM.resource.aspmm.grammar.AspmmCardinality cardinality, AspmmSyntaxElement[] children) {
		this.cardinality = cardinality;
		this.children = children;
		if (this.children != null) {
			for (AspmmSyntaxElement child : this.children) {
				child.setParent(this);
			}
		}
	}
	
	/**
	 * Sets the parent of this syntax element. This method must be invoked at most
	 * once.
	 */
	public void setParent(AspmmSyntaxElement parent) {
		assert this.parent == null;
		this.parent = parent;
	}
	
	/**
	 * Returns the parent of this syntax element. This parent is determined by the
	 * containment hierarchy in the CS model.
	 */
	public AspmmSyntaxElement getParent() {
		return parent;
	}
	
	public AspmmSyntaxElement[] getChildren() {
		if (children == null) {
			return new AspmmSyntaxElement[0];
		}
		return children;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return parent.getMetaclass();
	}
	
	public ASPMM.resource.aspmm.grammar.AspmmCardinality getCardinality() {
		return cardinality;
	}
	
}
