/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASP.resource.asp.analysis;

public class TerminalElementReferenceResolver implements ASP.resource.asp.IAspReferenceResolver<ASP.Terminal, ASP.Element> {
	
	private ASP.resource.asp.analysis.AspDefaultResolverDelegate<ASP.Terminal, ASP.Element> delegate = new ASP.resource.asp.analysis.AspDefaultResolverDelegate<ASP.Terminal, ASP.Element>();
	
	public void resolve(String identifier, ASP.Terminal container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final ASP.resource.asp.IAspReferenceResolveResult<ASP.Element> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(ASP.Element element, ASP.Terminal container, org.eclipse.emf.ecore.EReference reference) {
		return ElementPrinter.printElement(element);
		//return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
