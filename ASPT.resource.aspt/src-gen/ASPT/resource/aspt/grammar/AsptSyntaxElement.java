/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPT.resource.aspt.grammar;

/**
 * The abstract super class for all elements of a grammar. This class provides
 * methods to traverse the grammar rules.
 */
public abstract class AsptSyntaxElement {
	
	private AsptSyntaxElement[] children;
	private AsptSyntaxElement parent;
	private ASPT.resource.aspt.grammar.AsptCardinality cardinality;
	
	public AsptSyntaxElement(ASPT.resource.aspt.grammar.AsptCardinality cardinality, AsptSyntaxElement[] children) {
		this.cardinality = cardinality;
		this.children = children;
		if (this.children != null) {
			for (AsptSyntaxElement child : this.children) {
				child.setParent(this);
			}
		}
	}
	
	/**
	 * Sets the parent of this syntax element. This method must be invoked at most
	 * once.
	 */
	public void setParent(AsptSyntaxElement parent) {
		assert this.parent == null;
		this.parent = parent;
	}
	
	/**
	 * Returns the parent of this syntax element. This parent is determined by the
	 * containment hierarchy in the CS model.
	 */
	public AsptSyntaxElement getParent() {
		return parent;
	}
	
	public AsptSyntaxElement[] getChildren() {
		if (children == null) {
			return new AsptSyntaxElement[0];
		}
		return children;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return parent.getMetaclass();
	}
	
	public ASPT.resource.aspt.grammar.AsptCardinality getCardinality() {
		return cardinality;
	}
	
}
