/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPM.resource.aspm;

/**
 * Implementors of this interface can provide a post-processor for text resources.
 */
public interface IAspmResourcePostProcessorProvider {
	
	/**
	 * Returns the processor that shall be called after text resource are successfully
	 * parsed.
	 */
	public ASPM.resource.aspm.IAspmResourcePostProcessor getResourcePostProcessor();
	
}
