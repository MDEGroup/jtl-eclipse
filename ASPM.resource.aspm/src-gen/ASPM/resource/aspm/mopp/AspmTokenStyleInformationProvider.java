/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPM.resource.aspm.mopp;

public class AspmTokenStyleInformationProvider {
	
	public static String TASK_ITEM_TOKEN_NAME = "TASK_ITEM";
	
	public ASPM.resource.aspm.IAspmTokenStyle getDefaultTokenStyle(String tokenName) {
		if ("model".equals(tokenName)) {
			return new ASPM.resource.aspm.mopp.AspmTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("node".equals(tokenName)) {
			return new ASPM.resource.aspm.mopp.AspmTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("prop".equals(tokenName)) {
			return new ASPM.resource.aspm.mopp.AspmTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("edge".equals(tokenName)) {
			return new ASPM.resource.aspm.mopp.AspmTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("QUOTED_34_34_92".equals(tokenName)) {
			return new ASPM.resource.aspm.mopp.AspmTokenStyle(new int[] {0x2A, 0x00, 0xFF}, null, false, false, false, false);
		}
		if ("TASK_ITEM".equals(tokenName)) {
			return new ASPM.resource.aspm.mopp.AspmTokenStyle(new int[] {0x7F, 0x9F, 0xBF}, null, true, false, false, false);
		}
		return null;
	}
	
}
