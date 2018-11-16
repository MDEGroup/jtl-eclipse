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
		if ("trace_model".equals(tokenName)) {
			return new ASPT.resource.aspt.mopp.AsptTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("trace_node".equals(tokenName)) {
			return new ASPT.resource.aspt.mopp.AsptTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("trace_prop".equals(tokenName)) {
			return new ASPT.resource.aspt.mopp.AsptTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("trace_edge".equals(tokenName)) {
			return new ASPT.resource.aspt.mopp.AsptTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("trace_nb_edge".equals(tokenName)) {
			return new ASPT.resource.aspt.mopp.AsptTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("trace_nb_prop".equals(tokenName)) {
			return new ASPT.resource.aspt.mopp.AsptTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("trace_nb_node".equals(tokenName)) {
			return new ASPT.resource.aspt.mopp.AsptTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("trace_link".equals(tokenName)) {
			return new ASPT.resource.aspt.mopp.AsptTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("QUOTED_34_34_92".equals(tokenName)) {
			return new ASPT.resource.aspt.mopp.AsptTokenStyle(new int[] {0x2A, 0x00, 0xFF}, null, false, false, false, false);
		}
		if ("TASK_ITEM".equals(tokenName)) {
			return new ASPT.resource.aspt.mopp.AsptTokenStyle(new int[] {0x7F, 0x9F, 0xBF}, null, true, false, false, false);
		}
		return null;
	}
	
}
