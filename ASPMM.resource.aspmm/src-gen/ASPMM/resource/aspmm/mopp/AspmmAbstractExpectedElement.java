/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPMM.resource.aspmm.mopp;

/**
 * Abstract super class for all expected elements. Provides methods to add
 * followers.
 */
public abstract class AspmmAbstractExpectedElement implements ASPMM.resource.aspmm.IAspmmExpectedElement {
	
	private org.eclipse.emf.ecore.EClass ruleMetaclass;
	
	private java.util.Set<ASPMM.resource.aspmm.util.AspmmPair<ASPMM.resource.aspmm.IAspmmExpectedElement, ASPMM.resource.aspmm.mopp.AspmmContainedFeature[]>> followers = new java.util.LinkedHashSet<ASPMM.resource.aspmm.util.AspmmPair<ASPMM.resource.aspmm.IAspmmExpectedElement, ASPMM.resource.aspmm.mopp.AspmmContainedFeature[]>>();
	
	public AspmmAbstractExpectedElement(org.eclipse.emf.ecore.EClass ruleMetaclass) {
		super();
		this.ruleMetaclass = ruleMetaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getRuleMetaclass() {
		return ruleMetaclass;
	}
	
	public void addFollower(ASPMM.resource.aspmm.IAspmmExpectedElement follower, ASPMM.resource.aspmm.mopp.AspmmContainedFeature[] path) {
		followers.add(new ASPMM.resource.aspmm.util.AspmmPair<ASPMM.resource.aspmm.IAspmmExpectedElement, ASPMM.resource.aspmm.mopp.AspmmContainedFeature[]>(follower, path));
	}
	
	public java.util.Collection<ASPMM.resource.aspmm.util.AspmmPair<ASPMM.resource.aspmm.IAspmmExpectedElement, ASPMM.resource.aspmm.mopp.AspmmContainedFeature[]>> getFollowers() {
		return followers;
	}
	
}
