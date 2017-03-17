/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPM.resource.aspm;

/**
 * Implementors of this interface provide an EMF resource.
 */
public interface IAspmResourceProvider {
	
	/**
	 * Returns the resource.
	 */
	public ASPM.resource.aspm.IAspmTextResource getResource();
	
}
