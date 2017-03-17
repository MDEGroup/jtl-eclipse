/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASP.resource.asp.mopp;

public class AspResourceFactory implements org.eclipse.emf.ecore.resource.Resource.Factory {
	
	public AspResourceFactory() {
		super();
	}
	
	public org.eclipse.emf.ecore.resource.Resource createResource(org.eclipse.emf.common.util.URI uri) {
		return new ASP.resource.asp.mopp.AspResource(uri);
	}
	
}
