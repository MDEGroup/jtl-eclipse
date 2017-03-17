/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPMM.resource.aspmm.mopp;

public class AspmmParseResult implements ASPMM.resource.aspmm.IAspmmParseResult {
	
	private org.eclipse.emf.ecore.EObject root;
	private java.util.Collection<ASPMM.resource.aspmm.IAspmmCommand<ASPMM.resource.aspmm.IAspmmTextResource>> commands = new java.util.ArrayList<ASPMM.resource.aspmm.IAspmmCommand<ASPMM.resource.aspmm.IAspmmTextResource>>();
	
	public AspmmParseResult() {
		super();
	}
	
	public void setRoot(org.eclipse.emf.ecore.EObject root) {
		this.root = root;
	}
	
	public org.eclipse.emf.ecore.EObject getRoot() {
		return root;
	}
	
	public java.util.Collection<ASPMM.resource.aspmm.IAspmmCommand<ASPMM.resource.aspmm.IAspmmTextResource>> getPostParseCommands() {
		return commands;
	}
	
}
