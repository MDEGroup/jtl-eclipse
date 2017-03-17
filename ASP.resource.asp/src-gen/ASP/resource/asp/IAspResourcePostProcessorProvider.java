/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASP.resource.asp;

/**
 * Implementors of this interface can provide a post-processor for text resources.
 */
public interface IAspResourcePostProcessorProvider {
	
	/**
	 * Returns the processor that shall be called after text resource are successfully
	 * parsed.
	 */
	public ASP.resource.asp.IAspResourcePostProcessor getResourcePostProcessor();
	
}
