/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPM.resource.aspm.mopp;

public class AspmParseResult implements ASPM.resource.aspm.IAspmParseResult {
	
	private org.eclipse.emf.ecore.EObject root;
	private java.util.Collection<ASPM.resource.aspm.IAspmCommand<ASPM.resource.aspm.IAspmTextResource>> commands = new java.util.ArrayList<ASPM.resource.aspm.IAspmCommand<ASPM.resource.aspm.IAspmTextResource>>();
	
	public AspmParseResult() {
		super();
	}
	
	public void setRoot(org.eclipse.emf.ecore.EObject root) {
		this.root = root;
	}
	
	public org.eclipse.emf.ecore.EObject getRoot() {
		return root;
	}
	
	public java.util.Collection<ASPM.resource.aspm.IAspmCommand<ASPM.resource.aspm.IAspmTextResource>> getPostParseCommands() {
		return commands;
	}
	
}
