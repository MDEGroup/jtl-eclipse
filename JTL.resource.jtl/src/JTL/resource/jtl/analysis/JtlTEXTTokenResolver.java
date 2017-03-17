/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package JTL.resource.jtl.analysis;

public class JtlTEXTTokenResolver implements JTL.resource.jtl.IJtlTokenResolver {
	
	private JTL.resource.jtl.analysis.JtlDefaultTokenResolver defaultTokenResolver = new JTL.resource.jtl.analysis.JtlDefaultTokenResolver(true);
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		// By default token de-resolving is delegated to the DefaultTokenResolver.
		String result = defaultTokenResolver.deResolve(value, feature, container, null, null, null);
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, JTL.resource.jtl.IJtlTokenResolveResult result) {
		// By default token resolving is delegated to the DefaultTokenResolver.
		defaultTokenResolver.resolve(lexem, feature, result, null, null, null);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
