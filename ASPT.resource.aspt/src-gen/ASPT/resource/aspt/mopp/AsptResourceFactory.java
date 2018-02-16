/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPT.resource.aspt.mopp;

public class AsptResourceFactory implements org.eclipse.emf.ecore.resource.Resource.Factory {
	
	public AsptResourceFactory() {
		super();
	}
	
	public org.eclipse.emf.ecore.resource.Resource createResource(org.eclipse.emf.common.util.URI uri) {
		return new ASPT.resource.aspt.mopp.AsptResource(uri);
	}
	
}
