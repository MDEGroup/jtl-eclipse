/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPM.resource.aspm.mopp;

public class AspmResourceFactory implements org.eclipse.emf.ecore.resource.Resource.Factory {
	
	public AspmResourceFactory() {
		super();
	}
	
	public org.eclipse.emf.ecore.resource.Resource createResource(org.eclipse.emf.common.util.URI uri) {
		return new ASPM.resource.aspm.mopp.AspmResource(uri);
	}
	
}
