/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASP.resource.asp.analysis;

public class RuleDirectionReferenceResolver implements ASP.resource.asp.IAspReferenceResolver<ASP.Rule, ASP.Literal> {
	
	private ASP.resource.asp.analysis.AspDefaultResolverDelegate<ASP.Rule, ASP.Literal> delegate = new ASP.resource.asp.analysis.AspDefaultResolverDelegate<ASP.Rule, ASP.Literal>();
	
	public void resolve(String identifier, ASP.Rule container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final ASP.resource.asp.IAspReferenceResolveResult<ASP.Literal> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(ASP.Literal element, ASP.Rule container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
