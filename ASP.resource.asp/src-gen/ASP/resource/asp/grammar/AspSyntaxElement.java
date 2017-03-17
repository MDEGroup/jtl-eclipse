/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASP.resource.asp.grammar;

/**
 * The abstract super class for all elements of a grammar. This class provides
 * methods to traverse the grammar rules.
 */
public abstract class AspSyntaxElement {
	
	private AspSyntaxElement[] children;
	private AspSyntaxElement parent;
	private ASP.resource.asp.grammar.AspCardinality cardinality;
	
	public AspSyntaxElement(ASP.resource.asp.grammar.AspCardinality cardinality, AspSyntaxElement[] children) {
		this.cardinality = cardinality;
		this.children = children;
		if (this.children != null) {
			for (AspSyntaxElement child : this.children) {
				child.setParent(this);
			}
		}
	}
	
	/**
	 * Sets the parent of this syntax element. This method must be invoked at most
	 * once.
	 */
	public void setParent(AspSyntaxElement parent) {
		assert this.parent == null;
		this.parent = parent;
	}
	
	/**
	 * Returns the parent of this syntax element. This parent is determined by the
	 * containment hierarchy in the CS model.
	 */
	public AspSyntaxElement getParent() {
		return parent;
	}
	
	public AspSyntaxElement[] getChildren() {
		if (children == null) {
			return new AspSyntaxElement[0];
		}
		return children;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return parent.getMetaclass();
	}
	
	public ASP.resource.asp.grammar.AspCardinality getCardinality() {
		return cardinality;
	}
	
}
