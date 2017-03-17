/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPMM.resource.aspmm;

/**
 * Implementors of this interface provide an EMF resource.
 */
public interface IAspmmResourceProvider {
	
	/**
	 * Returns the resource.
	 */
	public ASPMM.resource.aspmm.IAspmmTextResource getResource();
	
}
