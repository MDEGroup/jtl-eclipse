/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package JTL.resource.jtl.mopp;

public class JtlResourceFactory implements org.eclipse.emf.ecore.resource.Resource.Factory {
	
	public JtlResourceFactory() {
		super();
	}
	
	public org.eclipse.emf.ecore.resource.Resource createResource(org.eclipse.emf.common.util.URI uri) {
		return new JTL.resource.jtl.mopp.JtlResource(uri);
	}
	
}
