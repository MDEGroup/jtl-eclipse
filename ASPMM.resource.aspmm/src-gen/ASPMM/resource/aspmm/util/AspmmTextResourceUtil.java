/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPMM.resource.aspmm.util;

/**
 * Class AspmmTextResourceUtil can be used to perform common tasks on text
 * resources, such as loading and saving resources, as well as, checking them for
 * errors. This class is deprecated and has been replaced by
 * ASPMM.resource.aspmm.util.AspmmResourceUtil.
 */
public class AspmmTextResourceUtil {
	
	/**
	 * Use ASPMM.resource.aspmm.util.AspmmResourceUtil.getResource() instead.
	 */
	@Deprecated	
	public static ASPMM.resource.aspmm.mopp.AspmmResource getResource(org.eclipse.core.resources.IFile file) {
		return new ASPMM.resource.aspmm.util.AspmmEclipseProxy().getResource(file);
	}
	
	/**
	 * Use ASPMM.resource.aspmm.util.AspmmResourceUtil.getResource() instead.
	 */
	@Deprecated	
	public static ASPMM.resource.aspmm.mopp.AspmmResource getResource(java.io.File file, java.util.Map<?,?> options) {
		return ASPMM.resource.aspmm.util.AspmmResourceUtil.getResource(file, options);
	}
	
	/**
	 * Use ASPMM.resource.aspmm.util.AspmmResourceUtil.getResource() instead.
	 */
	@Deprecated	
	public static ASPMM.resource.aspmm.mopp.AspmmResource getResource(org.eclipse.emf.common.util.URI uri) {
		return ASPMM.resource.aspmm.util.AspmmResourceUtil.getResource(uri);
	}
	
	/**
	 * Use ASPMM.resource.aspmm.util.AspmmResourceUtil.getResource() instead.
	 */
	@Deprecated	
	public static ASPMM.resource.aspmm.mopp.AspmmResource getResource(org.eclipse.emf.common.util.URI uri, java.util.Map<?,?> options) {
		return ASPMM.resource.aspmm.util.AspmmResourceUtil.getResource(uri, options);
	}
	
}
