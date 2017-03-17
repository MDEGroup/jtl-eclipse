/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package JTL.resource.jtl;

/**
 * Implementors of this interface provide an EMF resource.
 */
public interface IJtlResourceProvider {
	
	/**
	 * Returns the resource.
	 */
	public JTL.resource.jtl.IJtlTextResource getResource();
	
}
