/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package JTL.resource.jtl;

/**
 * An element that is expected at a given position in a resource stream.
 */
public interface IJtlExpectedElement {
	
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
	public JTL.resource.jtl.grammar.JtlSyntaxElement getSymtaxElement();
	
	/**
	 * Adds an element that is a valid follower for this element.
	 */
	public void addFollower(JTL.resource.jtl.IJtlExpectedElement follower, JTL.resource.jtl.mopp.JtlContainedFeature[] path);
	
	/**
	 * Returns all valid followers for this element. Each follower is represented by a
	 * pair of an expected elements and the containment trace that leads from the
	 * current element to the follower.
	 */
	public java.util.Collection<JTL.resource.jtl.util.JtlPair<JTL.resource.jtl.IJtlExpectedElement, JTL.resource.jtl.mopp.JtlContainedFeature[]>> getFollowers();
	
}
