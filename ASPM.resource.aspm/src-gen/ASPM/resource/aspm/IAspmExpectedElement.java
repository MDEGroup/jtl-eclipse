/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPM.resource.aspm;

/**
 * An element that is expected at a given position in a resource stream.
 */
public interface IAspmExpectedElement {
	
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
	public ASPM.resource.aspm.grammar.AspmSyntaxElement getSymtaxElement();
	
	/**
	 * Adds an element that is a valid follower for this element.
	 */
	public void addFollower(ASPM.resource.aspm.IAspmExpectedElement follower, ASPM.resource.aspm.mopp.AspmContainedFeature[] path);
	
	/**
	 * Returns all valid followers for this element. Each follower is represented by a
	 * pair of an expected elements and the containment trace that leads from the
	 * current element to the follower.
	 */
	public java.util.Collection<ASPM.resource.aspm.util.AspmPair<ASPM.resource.aspm.IAspmExpectedElement, ASPM.resource.aspm.mopp.AspmContainedFeature[]>> getFollowers();
	
}
