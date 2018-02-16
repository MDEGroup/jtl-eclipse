/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPT.resource.aspt;

/**
 * Implementors of this interface provide an EMF resource.
 */
public interface IAsptResourceProvider {
	
	/**
	 * Returns the resource.
	 */
	public ASPT.resource.aspt.IAsptTextResource getResource();
	
}
