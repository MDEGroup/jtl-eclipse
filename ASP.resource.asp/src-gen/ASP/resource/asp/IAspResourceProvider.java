/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASP.resource.asp;

/**
 * Implementors of this interface provide an EMF resource.
 */
public interface IAspResourceProvider {
	
	/**
	 * Returns the resource.
	 */
	public ASP.resource.asp.IAspTextResource getResource();
	
}
