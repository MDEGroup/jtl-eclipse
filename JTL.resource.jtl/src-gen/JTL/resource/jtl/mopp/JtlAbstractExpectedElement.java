/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package JTL.resource.jtl.mopp;

/**
 * Abstract super class for all expected elements. Provides methods to add
 * followers.
 */
public abstract class JtlAbstractExpectedElement implements JTL.resource.jtl.IJtlExpectedElement {
	
	private org.eclipse.emf.ecore.EClass ruleMetaclass;
	
	private java.util.Set<JTL.resource.jtl.util.JtlPair<JTL.resource.jtl.IJtlExpectedElement, JTL.resource.jtl.mopp.JtlContainedFeature[]>> followers = new java.util.LinkedHashSet<JTL.resource.jtl.util.JtlPair<JTL.resource.jtl.IJtlExpectedElement, JTL.resource.jtl.mopp.JtlContainedFeature[]>>();
	
	public JtlAbstractExpectedElement(org.eclipse.emf.ecore.EClass ruleMetaclass) {
		super();
		this.ruleMetaclass = ruleMetaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getRuleMetaclass() {
		return ruleMetaclass;
	}
	
	public void addFollower(JTL.resource.jtl.IJtlExpectedElement follower, JTL.resource.jtl.mopp.JtlContainedFeature[] path) {
		followers.add(new JTL.resource.jtl.util.JtlPair<JTL.resource.jtl.IJtlExpectedElement, JTL.resource.jtl.mopp.JtlContainedFeature[]>(follower, path));
	}
	
	public java.util.Collection<JTL.resource.jtl.util.JtlPair<JTL.resource.jtl.IJtlExpectedElement, JTL.resource.jtl.mopp.JtlContainedFeature[]>> getFollowers() {
		return followers;
	}
	
}
