/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASP.resource.asp;

/**
 * An interface used to access the result of parsing a document.
 */
public interface IAspParseResult {
	
	/**
	 * Returns the root object of the document.
	 */
	public org.eclipse.emf.ecore.EObject getRoot();
	
	/**
	 * Returns a list of commands that must be executed after parsing the document.
	 */
	public java.util.Collection<ASP.resource.asp.IAspCommand<ASP.resource.asp.IAspTextResource>> getPostParseCommands();
	
}
