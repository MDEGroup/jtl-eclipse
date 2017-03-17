/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPM.resource.aspm;

/**
 * An interface used to access the result of parsing a document.
 */
public interface IAspmParseResult {
	
	/**
	 * Returns the root object of the document.
	 */
	public org.eclipse.emf.ecore.EObject getRoot();
	
	/**
	 * Returns a list of commands that must be executed after parsing the document.
	 */
	public java.util.Collection<ASPM.resource.aspm.IAspmCommand<ASPM.resource.aspm.IAspmTextResource>> getPostParseCommands();
	
}
