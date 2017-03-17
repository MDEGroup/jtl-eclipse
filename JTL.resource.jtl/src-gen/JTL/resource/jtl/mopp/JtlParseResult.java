/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package JTL.resource.jtl.mopp;

public class JtlParseResult implements JTL.resource.jtl.IJtlParseResult {
	
	private org.eclipse.emf.ecore.EObject root;
	private java.util.Collection<JTL.resource.jtl.IJtlCommand<JTL.resource.jtl.IJtlTextResource>> commands = new java.util.ArrayList<JTL.resource.jtl.IJtlCommand<JTL.resource.jtl.IJtlTextResource>>();
	
	public JtlParseResult() {
		super();
	}
	
	public void setRoot(org.eclipse.emf.ecore.EObject root) {
		this.root = root;
	}
	
	public org.eclipse.emf.ecore.EObject getRoot() {
		return root;
	}
	
	public java.util.Collection<JTL.resource.jtl.IJtlCommand<JTL.resource.jtl.IJtlTextResource>> getPostParseCommands() {
		return commands;
	}
	
}
