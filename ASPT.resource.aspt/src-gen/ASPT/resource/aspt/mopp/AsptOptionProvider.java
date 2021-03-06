/**
 * <copyright>
 * </copyright>
 *
 *
 */
/**
 * This class can be used to configure options that must be used when resources
 * are loaded. This is similar to using the extension point
 * 'ASPT.resource.aspt.default_load_options' with the difference that the options
 * defined in this class are used even if no Eclipse platform is running.
 */
package ASPT.resource.aspt.mopp;

import java.util.Collections;

import ASPT.resource.aspt.IAsptOptions;
import ASPT.resource.aspt.PreProcessor;

public class AsptOptionProvider implements ASPT.resource.aspt.IAsptOptionProvider {

	@Override
	public java.util.Map<?,?> getOptions() {
		// create a map with static option providers here
//		return java.util.Collections.emptyMap();
		return Collections.singletonMap(IAsptOptions.INPUT_STREAM_PREPROCESSOR_PROVIDER, new PreProcessor());
	}

}
