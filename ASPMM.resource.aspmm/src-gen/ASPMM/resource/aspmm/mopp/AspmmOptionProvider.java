/**
 * <copyright>
 * </copyright>
 *
 * 
 */
/**
 * This class can be used to configure options that must be used when resources
 * are loaded. This is similar to using the extension point
 * 'ASPMM.resource.aspmm.default_load_options' with the difference that the
 * options defined in this class are used even if no Eclipse platform is running.
 */
package ASPMM.resource.aspmm.mopp;

public class AspmmOptionProvider implements ASPMM.resource.aspmm.IAspmmOptionProvider {
	
	public java.util.Map<?,?> getOptions() {
		// create a map with static option providers here
		return java.util.Collections.emptyMap();
	}
	
}
