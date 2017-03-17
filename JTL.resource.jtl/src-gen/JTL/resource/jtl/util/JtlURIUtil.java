/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package JTL.resource.jtl.util;

public class JtlURIUtil {
	
	public boolean isInBinFolder(org.eclipse.emf.common.util.URI uri) {
		String[] segments = uri.segments();
		for (String segment : segments) {
			if ("bin".equals(segment)) {
				return true;
			}
		}
		return false;
	}
	
}
