/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPT.resource.aspt;

/**
 * Implementors of this interface can provide InputStreamProcessors. These
 * processors can be used to pre-process input stream before a text resource is
 * actually lexed and parsed. This can be for example useful to do an encoding
 * conversion.
 */
public interface IAsptInputStreamProcessorProvider {
	
	/**
	 * Returns a processor for the given input stream.
	 * 
	 * @param inputStream the actual stream that provides the content of a resource
	 * 
	 * @return a processor that pre-processes the input stream
	 */
	public ASPT.resource.aspt.mopp.AsptInputStreamProcessor getInputStreamProcessor(java.io.InputStream inputStream);
}
