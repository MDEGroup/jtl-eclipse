/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASP.resource.asp.mopp;

public class AspTokenStyleInformationProvider {
	
	public static String TASK_ITEM_TOKEN_NAME = "TASK_ITEM";
	
	public ASP.resource.asp.IAspTokenStyle getDefaultTokenStyle(String tokenName) {
		if ("COMMENT".equals(tokenName)) {
			return new ASP.resource.asp.mopp.AspTokenStyle(new int[] {0x66, 0x66, 0x66}, null, false, false, false, false);
		}
		if ("relation_node".equals(tokenName)) {
			return new ASP.resource.asp.mopp.AspTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("relation_prop".equals(tokenName)) {
			return new ASP.resource.asp.mopp.AspTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("relation_edge".equals(tokenName)) {
			return new ASP.resource.asp.mopp.AspTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("not".equals(tokenName)) {
			return new ASP.resource.asp.mopp.AspTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("QUOTED_40_41".equals(tokenName)) {
			return new ASP.resource.asp.mopp.AspTokenStyle(new int[] {0x2A, 0x00, 0xFF}, null, false, false, false, false);
		}
		if ("TASK_ITEM".equals(tokenName)) {
			return new ASP.resource.asp.mopp.AspTokenStyle(new int[] {0x7F, 0x9F, 0xBF}, null, true, false, false, false);
		}
		return null;
	}
	
}
