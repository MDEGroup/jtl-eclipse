/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPM.resource.aspm.analysis;

public class EdgeTargetReferenceResolver implements ASPM.resource.aspm.IAspmReferenceResolver<ASPM.Edge, ASPM.Node> {
	
	private ASPM.resource.aspm.analysis.AspmDefaultResolverDelegate<ASPM.Edge, ASPM.Node> delegate = new ASPM.resource.aspm.analysis.AspmDefaultResolverDelegate<ASPM.Edge, ASPM.Node>();
	
	public void resolve(String identifier, ASPM.Edge container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final ASPM.resource.aspm.IAspmReferenceResolveResult<ASPM.Node> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(ASPM.Node element, ASPM.Edge container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
