/**
 * <copyright>
 * </copyright>
 *
 *
 */
/**
 * This class can be used to configure options that must be used when resources
 * are loaded. This is similar to using the extension point
 * 'JTL.resource.jtl.default_load_options' with the difference that the options
 * defined in this class are used even if no Eclipse platform is running.
 */
package JTL.resource.jtl.mopp;

public class JtlOptionProvider implements JTL.resource.jtl.IJtlOptionProvider {

	@Override
	public java.util.Map<?,?> getOptions() {
		// create a map with static option providers here
		//return java.util.Collections.emptyMap();
		return java.util.Collections.singletonMap(
				JTL.resource.jtl.IJtlOptions.RESOURCE_POSTPROCESSOR_PROVIDER,
				new JTL.resource.jtl.PostProcessor());
	}

}
