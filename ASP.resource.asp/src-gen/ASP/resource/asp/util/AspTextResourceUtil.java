/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASP.resource.asp.util;

/**
 * Class AspTextResourceUtil can be used to perform common tasks on text
 * resources, such as loading and saving resources, as well as, checking them for
 * errors. This class is deprecated and has been replaced by
 * ASP.resource.asp.util.AspResourceUtil.
 */
public class AspTextResourceUtil {
	
	/**
	 * Use ASP.resource.asp.util.AspResourceUtil.getResource() instead.
	 */
	@Deprecated	
	public static ASP.resource.asp.mopp.AspResource getResource(org.eclipse.core.resources.IFile file) {
		return new ASP.resource.asp.util.AspEclipseProxy().getResource(file);
	}
	
	/**
	 * Use ASP.resource.asp.util.AspResourceUtil.getResource() instead.
	 */
	@Deprecated	
	public static ASP.resource.asp.mopp.AspResource getResource(java.io.File file, java.util.Map<?,?> options) {
		return ASP.resource.asp.util.AspResourceUtil.getResource(file, options);
	}
	
	/**
	 * Use ASP.resource.asp.util.AspResourceUtil.getResource() instead.
	 */
	@Deprecated	
	public static ASP.resource.asp.mopp.AspResource getResource(org.eclipse.emf.common.util.URI uri) {
		return ASP.resource.asp.util.AspResourceUtil.getResource(uri);
	}
	
	/**
	 * Use ASP.resource.asp.util.AspResourceUtil.getResource() instead.
	 */
	@Deprecated	
	public static ASP.resource.asp.mopp.AspResource getResource(org.eclipse.emf.common.util.URI uri, java.util.Map<?,?> options) {
		return ASP.resource.asp.util.AspResourceUtil.getResource(uri, options);
	}
	
}
