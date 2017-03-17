/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPM.resource.aspm.mopp;

public class AspmDynamicTokenStyler {
	
	/**
	 * This method is called to dynamically style tokens.
	 * 
	 * @param resource the TextResource that contains the token
	 * @param token the token to obtain a style for
	 * @param staticStyle the token style as set in the editor preferences (is
	 * <code>null</code> if syntax highlighting for the token is disabled)
	 */
	public ASPM.resource.aspm.IAspmTokenStyle getDynamicTokenStyle(ASPM.resource.aspm.IAspmTextResource resource, ASPM.resource.aspm.IAspmTextToken token, ASPM.resource.aspm.IAspmTokenStyle staticStyle) {
		// The default implementation returns the static style without any changes. To
		// implement dynamic token styling, set the overrideDynamicTokenStyler option to
		// <code>false</code> and customize this method.
		return staticStyle;
	}
	
}
