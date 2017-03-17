/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package JTL.resource.jtl;

/**
 * An interface used to access the result of parsing a document.
 */
public interface IJtlParseResult {
	
	/**
	 * Returns the root object of the document.
	 */
	public org.eclipse.emf.ecore.EObject getRoot();
	
	/**
	 * Returns a list of commands that must be executed after parsing the document.
	 */
	public java.util.Collection<JTL.resource.jtl.IJtlCommand<JTL.resource.jtl.IJtlTextResource>> getPostParseCommands();
	
}
