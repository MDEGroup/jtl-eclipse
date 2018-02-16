/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPT.resource.aspt.mopp;

public class AsptTokenStyleInformationProvider {
	
	public static String TASK_ITEM_TOKEN_NAME = "TASK_ITEM";
	
	public ASPT.resource.aspt.IAsptTokenStyle getDefaultTokenStyle(String tokenName) {
		if ("QUOTED_34_34".equals(tokenName)) {
			return new ASPT.resource.aspt.mopp.AsptTokenStyle(new int[] {0x2A, 0x00, 0xFF}, null, false, false, false, false);
		}
		if ("TASK_ITEM".equals(tokenName)) {
			return new ASPT.resource.aspt.mopp.AsptTokenStyle(new int[] {0x7F, 0x9F, 0xBF}, null, true, false, false, false);
		}
		return null;
	}
	
}
