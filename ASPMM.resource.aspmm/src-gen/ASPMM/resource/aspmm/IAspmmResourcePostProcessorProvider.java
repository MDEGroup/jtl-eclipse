/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPMM.resource.aspmm;

/**
 * Implementors of this interface can provide a post-processor for text resources.
 */
public interface IAspmmResourcePostProcessorProvider {
	
	/**
	 * Returns the processor that shall be called after text resource are successfully
	 * parsed.
	 */
	public ASPMM.resource.aspmm.IAspmmResourcePostProcessor getResourcePostProcessor();
	
}
