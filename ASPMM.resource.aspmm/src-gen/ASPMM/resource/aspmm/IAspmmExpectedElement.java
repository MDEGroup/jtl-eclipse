/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPMM.resource.aspmm;

/**
 * An element that is expected at a given position in a resource stream.
 */
public interface IAspmmExpectedElement {
	
	/**
	 * Returns the names of all tokens that are expected at the given position.
	 */
	public java.util.Set<String> getTokenNames();
	
	/**
	 * Returns the metaclass of the rule that contains the expected element.
	 */
	public org.eclipse.emf.ecore.EClass getRuleMetaclass();
	
	/**
	 * Returns the syntax element that is expected.
	 */
	public ASPMM.resource.aspmm.grammar.AspmmSyntaxElement getSymtaxElement();
	
	/**
	 * Adds an element that is a valid follower for this element.
	 */
	public void addFollower(ASPMM.resource.aspmm.IAspmmExpectedElement follower, ASPMM.resource.aspmm.mopp.AspmmContainedFeature[] path);
	
	/**
	 * Returns all valid followers for this element. Each follower is represented by a
	 * pair of an expected elements and the containment trace that leads from the
	 * current element to the follower.
	 */
	public java.util.Collection<ASPMM.resource.aspmm.util.AspmmPair<ASPMM.resource.aspmm.IAspmmExpectedElement, ASPMM.resource.aspmm.mopp.AspmmContainedFeature[]>> getFollowers();
	
}
