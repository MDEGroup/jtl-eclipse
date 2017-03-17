/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASP.resource.asp.analysis;

public class NotEqRightReferenceResolver implements ASP.resource.asp.IAspReferenceResolver<ASP.NotEq, ASP.Literal> {
	
	private ASP.resource.asp.analysis.AspDefaultResolverDelegate<ASP.NotEq, ASP.Literal> delegate = new ASP.resource.asp.analysis.AspDefaultResolverDelegate<ASP.NotEq, ASP.Literal>();
	
	public void resolve(String identifier, ASP.NotEq container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final ASP.resource.asp.IAspReferenceResolveResult<ASP.Literal> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(ASP.Literal element, ASP.NotEq container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
