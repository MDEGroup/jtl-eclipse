/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPT.resource.aspt.util;

public class AsptURIUtil {
	
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
