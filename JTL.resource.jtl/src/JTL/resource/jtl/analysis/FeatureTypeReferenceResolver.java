/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package JTL.resource.jtl.analysis;

public class FeatureTypeReferenceResolver implements JTL.resource.jtl.IJtlReferenceResolver<JTL.Feature, JTL.Type> {
	
	private JTL.resource.jtl.analysis.JtlDefaultResolverDelegate<JTL.Feature, JTL.Type> delegate = new JTL.resource.jtl.analysis.JtlDefaultResolverDelegate<JTL.Feature, JTL.Type>();
	
	public void resolve(String identifier, JTL.Feature container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final JTL.resource.jtl.IJtlReferenceResolveResult<JTL.Type> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(JTL.Type element, JTL.Feature container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
