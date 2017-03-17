/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPM.resource.aspm.analysis;

public class EdgeModelReferenceResolver implements ASPM.resource.aspm.IAspmReferenceResolver<ASPM.Edge, ASPM.Model> {
	
	private ASPM.resource.aspm.analysis.AspmDefaultResolverDelegate<ASPM.Edge, ASPM.Model> delegate = new ASPM.resource.aspm.analysis.AspmDefaultResolverDelegate<ASPM.Edge, ASPM.Model>();
	
	public void resolve(String identifier, ASPM.Edge container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final ASPM.resource.aspm.IAspmReferenceResolveResult<ASPM.Model> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(ASPM.Model element, ASPM.Edge container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
