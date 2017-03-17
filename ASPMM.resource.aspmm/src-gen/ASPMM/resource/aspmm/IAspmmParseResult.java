/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPMM.resource.aspmm;

/**
 * An interface used to access the result of parsing a document.
 */
public interface IAspmmParseResult {
	
	/**
	 * Returns the root object of the document.
	 */
	public org.eclipse.emf.ecore.EObject getRoot();
	
	/**
	 * Returns a list of commands that must be executed after parsing the document.
	 */
	public java.util.Collection<ASPMM.resource.aspmm.IAspmmCommand<ASPMM.resource.aspmm.IAspmmTextResource>> getPostParseCommands();
	
}
