/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPT.resource.aspt.analysis;

public class AsptIDENTIFIERTokenResolver implements ASPT.resource.aspt.IAsptTokenResolver {
	
	private ASPT.resource.aspt.analysis.AsptDefaultTokenResolver defaultTokenResolver = new ASPT.resource.aspt.analysis.AsptDefaultTokenResolver(true);
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		// By default token de-resolving is delegated to the DefaultTokenResolver.
		String result = defaultTokenResolver.deResolve(value, feature, container, null, null, null);
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, ASPT.resource.aspt.IAsptTokenResolveResult result) {
		// By default token resolving is delegated to the DefaultTokenResolver.
		defaultTokenResolver.resolve(lexem, feature, result, null, null, null);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
