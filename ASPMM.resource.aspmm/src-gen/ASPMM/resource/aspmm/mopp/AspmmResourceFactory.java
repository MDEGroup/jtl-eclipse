/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPMM.resource.aspmm.mopp;

public class AspmmResourceFactory implements org.eclipse.emf.ecore.resource.Resource.Factory {
	
	public AspmmResourceFactory() {
		super();
	}
	
	public org.eclipse.emf.ecore.resource.Resource createResource(org.eclipse.emf.common.util.URI uri) {
		return new ASPMM.resource.aspmm.mopp.AspmmResource(uri);
	}
	
}
