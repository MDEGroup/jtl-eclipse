/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPT.resource.aspt.analysis;

public class FeatureTypeReferenceResolver implements ASPT.resource.aspt.IAsptReferenceResolver<ASPT.Feature, ASPT.Type> {
	
	private ASPT.resource.aspt.analysis.AsptDefaultResolverDelegate<ASPT.Feature, ASPT.Type> delegate = new ASPT.resource.aspt.analysis.AsptDefaultResolverDelegate<ASPT.Feature, ASPT.Type>();
	
	public void resolve(String identifier, ASPT.Feature container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final ASPT.resource.aspt.IAsptReferenceResolveResult<ASPT.Type> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(ASPT.Type element, ASPT.Feature container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
