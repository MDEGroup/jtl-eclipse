/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPT.resource.aspt.util;

/**
 * Class AsptTextResourceUtil can be used to perform common tasks on text
 * resources, such as loading and saving resources, as well as, checking them for
 * errors. This class is deprecated and has been replaced by
 * ASPT.resource.aspt.util.AsptResourceUtil.
 */
public class AsptTextResourceUtil {
	
	/**
	 * Use ASPT.resource.aspt.util.AsptResourceUtil.getResource() instead.
	 */
	@Deprecated	
	public static ASPT.resource.aspt.mopp.AsptResource getResource(org.eclipse.core.resources.IFile file) {
		return new ASPT.resource.aspt.util.AsptEclipseProxy().getResource(file);
	}
	
	/**
	 * Use ASPT.resource.aspt.util.AsptResourceUtil.getResource() instead.
	 */
	@Deprecated	
	public static ASPT.resource.aspt.mopp.AsptResource getResource(java.io.File file, java.util.Map<?,?> options) {
		return ASPT.resource.aspt.util.AsptResourceUtil.getResource(file, options);
	}
	
	/**
	 * Use ASPT.resource.aspt.util.AsptResourceUtil.getResource() instead.
	 */
	@Deprecated	
	public static ASPT.resource.aspt.mopp.AsptResource getResource(org.eclipse.emf.common.util.URI uri) {
		return ASPT.resource.aspt.util.AsptResourceUtil.getResource(uri);
	}
	
	/**
	 * Use ASPT.resource.aspt.util.AsptResourceUtil.getResource() instead.
	 */
	@Deprecated	
	public static ASPT.resource.aspt.mopp.AsptResource getResource(org.eclipse.emf.common.util.URI uri, java.util.Map<?,?> options) {
		return ASPT.resource.aspt.util.AsptResourceUtil.getResource(uri, options);
	}
	
}
