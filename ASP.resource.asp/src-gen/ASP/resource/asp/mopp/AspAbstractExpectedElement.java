/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASP.resource.asp.mopp;

/**
 * Abstract super class for all expected elements. Provides methods to add
 * followers.
 */
public abstract class AspAbstractExpectedElement implements ASP.resource.asp.IAspExpectedElement {
	
	private org.eclipse.emf.ecore.EClass ruleMetaclass;
	
	private java.util.Set<ASP.resource.asp.util.AspPair<ASP.resource.asp.IAspExpectedElement, ASP.resource.asp.mopp.AspContainedFeature[]>> followers = new java.util.LinkedHashSet<ASP.resource.asp.util.AspPair<ASP.resource.asp.IAspExpectedElement, ASP.resource.asp.mopp.AspContainedFeature[]>>();
	
	public AspAbstractExpectedElement(org.eclipse.emf.ecore.EClass ruleMetaclass) {
		super();
		this.ruleMetaclass = ruleMetaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getRuleMetaclass() {
		return ruleMetaclass;
	}
	
	public void addFollower(ASP.resource.asp.IAspExpectedElement follower, ASP.resource.asp.mopp.AspContainedFeature[] path) {
		followers.add(new ASP.resource.asp.util.AspPair<ASP.resource.asp.IAspExpectedElement, ASP.resource.asp.mopp.AspContainedFeature[]>(follower, path));
	}
	
	public java.util.Collection<ASP.resource.asp.util.AspPair<ASP.resource.asp.IAspExpectedElement, ASP.resource.asp.mopp.AspContainedFeature[]>> getFollowers() {
		return followers;
	}
	
}
