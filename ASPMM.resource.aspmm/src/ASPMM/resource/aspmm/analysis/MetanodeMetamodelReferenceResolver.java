/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPMM.resource.aspmm.analysis;

public class MetanodeMetamodelReferenceResolver implements ASPMM.resource.aspmm.IAspmmReferenceResolver<ASPMM.Metanode, ASPMM.Metamodel> {
	
	private ASPMM.resource.aspmm.analysis.AspmmDefaultResolverDelegate<ASPMM.Metanode, ASPMM.Metamodel> delegate = new ASPMM.resource.aspmm.analysis.AspmmDefaultResolverDelegate<ASPMM.Metanode, ASPMM.Metamodel>();
	
	public void resolve(String identifier, ASPMM.Metanode container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final ASPMM.resource.aspmm.IAspmmReferenceResolveResult<ASPMM.Metamodel> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(ASPMM.Metamodel element, ASPMM.Metanode container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
