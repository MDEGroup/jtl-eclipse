/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package JTL.resource.jtl;

/**
 * Implementors of this interface can provide a post-processor for text resources.
 */
public interface IJtlResourcePostProcessorProvider {
	
	/**
	 * Returns the processor that shall be called after text resource are successfully
	 * parsed.
	 */
	public JTL.resource.jtl.IJtlResourcePostProcessor getResourcePostProcessor();
	
}
