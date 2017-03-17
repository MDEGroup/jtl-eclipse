/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPMM.resource.aspmm.analysis;

public class MetapropMetanodeReferenceResolver implements ASPMM.resource.aspmm.IAspmmReferenceResolver<ASPMM.Metaprop, ASPMM.Metanode> {
	
	private ASPMM.resource.aspmm.analysis.AspmmDefaultResolverDelegate<ASPMM.Metaprop, ASPMM.Metanode> delegate = new ASPMM.resource.aspmm.analysis.AspmmDefaultResolverDelegate<ASPMM.Metaprop, ASPMM.Metanode>();
	
	public void resolve(String identifier, ASPMM.Metaprop container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final ASPMM.resource.aspmm.IAspmmReferenceResolveResult<ASPMM.Metanode> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(ASPMM.Metanode element, ASPMM.Metaprop container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
