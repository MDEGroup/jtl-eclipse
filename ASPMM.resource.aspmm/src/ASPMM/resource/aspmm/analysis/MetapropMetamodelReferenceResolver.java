/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPMM.resource.aspmm.analysis;

public class MetapropMetamodelReferenceResolver implements ASPMM.resource.aspmm.IAspmmReferenceResolver<ASPMM.Metaprop, ASPMM.Metamodel> {
	
	private ASPMM.resource.aspmm.analysis.AspmmDefaultResolverDelegate<ASPMM.Metaprop, ASPMM.Metamodel> delegate = new ASPMM.resource.aspmm.analysis.AspmmDefaultResolverDelegate<ASPMM.Metaprop, ASPMM.Metamodel>();
	
	public void resolve(String identifier, ASPMM.Metaprop container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final ASPMM.resource.aspmm.IAspmmReferenceResolveResult<ASPMM.Metamodel> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(ASPMM.Metamodel element, ASPMM.Metaprop container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
