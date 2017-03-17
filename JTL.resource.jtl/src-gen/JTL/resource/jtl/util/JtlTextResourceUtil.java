/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package JTL.resource.jtl.util;

/**
 * Class JtlTextResourceUtil can be used to perform common tasks on text
 * resources, such as loading and saving resources, as well as, checking them for
 * errors. This class is deprecated and has been replaced by
 * JTL.resource.jtl.util.JtlResourceUtil.
 */
public class JtlTextResourceUtil {
	
	/**
	 * Use JTL.resource.jtl.util.JtlResourceUtil.getResource() instead.
	 */
	@Deprecated	
	public static JTL.resource.jtl.mopp.JtlResource getResource(org.eclipse.core.resources.IFile file) {
		return new JTL.resource.jtl.util.JtlEclipseProxy().getResource(file);
	}
	
	/**
	 * Use JTL.resource.jtl.util.JtlResourceUtil.getResource() instead.
	 */
	@Deprecated	
	public static JTL.resource.jtl.mopp.JtlResource getResource(java.io.File file, java.util.Map<?,?> options) {
		return JTL.resource.jtl.util.JtlResourceUtil.getResource(file, options);
	}
	
	/**
	 * Use JTL.resource.jtl.util.JtlResourceUtil.getResource() instead.
	 */
	@Deprecated	
	public static JTL.resource.jtl.mopp.JtlResource getResource(org.eclipse.emf.common.util.URI uri) {
		return JTL.resource.jtl.util.JtlResourceUtil.getResource(uri);
	}
	
	/**
	 * Use JTL.resource.jtl.util.JtlResourceUtil.getResource() instead.
	 */
	@Deprecated	
	public static JTL.resource.jtl.mopp.JtlResource getResource(org.eclipse.emf.common.util.URI uri, java.util.Map<?,?> options) {
		return JTL.resource.jtl.util.JtlResourceUtil.getResource(uri, options);
	}
	
}
