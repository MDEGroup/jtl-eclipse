/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASP.resource.asp.mopp;

public class AspParseResult implements ASP.resource.asp.IAspParseResult {
	
	private org.eclipse.emf.ecore.EObject root;
	private java.util.Collection<ASP.resource.asp.IAspCommand<ASP.resource.asp.IAspTextResource>> commands = new java.util.ArrayList<ASP.resource.asp.IAspCommand<ASP.resource.asp.IAspTextResource>>();
	
	public AspParseResult() {
		super();
	}
	
	public void setRoot(org.eclipse.emf.ecore.EObject root) {
		this.root = root;
	}
	
	public org.eclipse.emf.ecore.EObject getRoot() {
		return root;
	}
	
	public java.util.Collection<ASP.resource.asp.IAspCommand<ASP.resource.asp.IAspTextResource>> getPostParseCommands() {
		return commands;
	}
	
}
