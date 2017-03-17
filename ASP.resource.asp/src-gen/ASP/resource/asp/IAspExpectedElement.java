/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASP.resource.asp;

/**
 * An element that is expected at a given position in a resource stream.
 */
public interface IAspExpectedElement {
	
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
	public ASP.resource.asp.grammar.AspSyntaxElement getSymtaxElement();
	
	/**
	 * Adds an element that is a valid follower for this element.
	 */
	public void addFollower(ASP.resource.asp.IAspExpectedElement follower, ASP.resource.asp.mopp.AspContainedFeature[] path);
	
	/**
	 * Returns all valid followers for this element. Each follower is represented by a
	 * pair of an expected elements and the containment trace that leads from the
	 * current element to the follower.
	 */
	public java.util.Collection<ASP.resource.asp.util.AspPair<ASP.resource.asp.IAspExpectedElement, ASP.resource.asp.mopp.AspContainedFeature[]>> getFollowers();
	
}
