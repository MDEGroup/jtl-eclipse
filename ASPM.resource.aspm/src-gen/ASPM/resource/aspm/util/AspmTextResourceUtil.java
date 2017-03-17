/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPM.resource.aspm.util;

/**
 * Class AspmTextResourceUtil can be used to perform common tasks on text
 * resources, such as loading and saving resources, as well as, checking them for
 * errors. This class is deprecated and has been replaced by
 * ASPM.resource.aspm.util.AspmResourceUtil.
 */
public class AspmTextResourceUtil {
	
	/**
	 * Use ASPM.resource.aspm.util.AspmResourceUtil.getResource() instead.
	 */
	@Deprecated	
	public static ASPM.resource.aspm.mopp.AspmResource getResource(org.eclipse.core.resources.IFile file) {
		return new ASPM.resource.aspm.util.AspmEclipseProxy().getResource(file);
	}
	
	/**
	 * Use ASPM.resource.aspm.util.AspmResourceUtil.getResource() instead.
	 */
	@Deprecated	
	public static ASPM.resource.aspm.mopp.AspmResource getResource(java.io.File file, java.util.Map<?,?> options) {
		return ASPM.resource.aspm.util.AspmResourceUtil.getResource(file, options);
	}
	
	/**
	 * Use ASPM.resource.aspm.util.AspmResourceUtil.getResource() instead.
	 */
	@Deprecated	
	public static ASPM.resource.aspm.mopp.AspmResource getResource(org.eclipse.emf.common.util.URI uri) {
		return ASPM.resource.aspm.util.AspmResourceUtil.getResource(uri);
	}
	
	/**
	 * Use ASPM.resource.aspm.util.AspmResourceUtil.getResource() instead.
	 */
	@Deprecated	
	public static ASPM.resource.aspm.mopp.AspmResource getResource(org.eclipse.emf.common.util.URI uri, java.util.Map<?,?> options) {
		return ASPM.resource.aspm.util.AspmResourceUtil.getResource(uri, options);
	}
	
}
