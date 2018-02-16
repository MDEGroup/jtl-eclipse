/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPT.resource.aspt;

/**
 * An element that is expected at a given position in a resource stream.
 */
public interface IAsptExpectedElement {
	
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
	public ASPT.resource.aspt.grammar.AsptSyntaxElement getSymtaxElement();
	
	/**
	 * Adds an element that is a valid follower for this element.
	 */
	public void addFollower(ASPT.resource.aspt.IAsptExpectedElement follower, ASPT.resource.aspt.mopp.AsptContainedFeature[] path);
	
	/**
	 * Returns all valid followers for this element. Each follower is represented by a
	 * pair of an expected elements and the containment trace that leads from the
	 * current element to the follower.
	 */
	public java.util.Collection<ASPT.resource.aspt.util.AsptPair<ASPT.resource.aspt.IAsptExpectedElement, ASPT.resource.aspt.mopp.AsptContainedFeature[]>> getFollowers();
	
}
