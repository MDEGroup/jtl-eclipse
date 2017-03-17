/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPM.resource.aspm.mopp;

/**
 * Abstract super class for all expected elements. Provides methods to add
 * followers.
 */
public abstract class AspmAbstractExpectedElement implements ASPM.resource.aspm.IAspmExpectedElement {
	
	private org.eclipse.emf.ecore.EClass ruleMetaclass;
	
	private java.util.Set<ASPM.resource.aspm.util.AspmPair<ASPM.resource.aspm.IAspmExpectedElement, ASPM.resource.aspm.mopp.AspmContainedFeature[]>> followers = new java.util.LinkedHashSet<ASPM.resource.aspm.util.AspmPair<ASPM.resource.aspm.IAspmExpectedElement, ASPM.resource.aspm.mopp.AspmContainedFeature[]>>();
	
	public AspmAbstractExpectedElement(org.eclipse.emf.ecore.EClass ruleMetaclass) {
		super();
		this.ruleMetaclass = ruleMetaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getRuleMetaclass() {
		return ruleMetaclass;
	}
	
	public void addFollower(ASPM.resource.aspm.IAspmExpectedElement follower, ASPM.resource.aspm.mopp.AspmContainedFeature[] path) {
		followers.add(new ASPM.resource.aspm.util.AspmPair<ASPM.resource.aspm.IAspmExpectedElement, ASPM.resource.aspm.mopp.AspmContainedFeature[]>(follower, path));
	}
	
	public java.util.Collection<ASPM.resource.aspm.util.AspmPair<ASPM.resource.aspm.IAspmExpectedElement, ASPM.resource.aspm.mopp.AspmContainedFeature[]>> getFollowers() {
		return followers;
	}
	
}
