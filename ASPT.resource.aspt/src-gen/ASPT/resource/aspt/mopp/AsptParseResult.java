/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPT.resource.aspt.mopp;

public class AsptParseResult implements ASPT.resource.aspt.IAsptParseResult {
	
	private org.eclipse.emf.ecore.EObject root;
	private java.util.Collection<ASPT.resource.aspt.IAsptCommand<ASPT.resource.aspt.IAsptTextResource>> commands = new java.util.ArrayList<ASPT.resource.aspt.IAsptCommand<ASPT.resource.aspt.IAsptTextResource>>();
	
	public AsptParseResult() {
		super();
	}
	
	public void setRoot(org.eclipse.emf.ecore.EObject root) {
		this.root = root;
	}
	
	public org.eclipse.emf.ecore.EObject getRoot() {
		return root;
	}
	
	public java.util.Collection<ASPT.resource.aspt.IAsptCommand<ASPT.resource.aspt.IAsptTextResource>> getPostParseCommands() {
		return commands;
	}
	
}
