/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPMM.resource.aspmm.mopp;

public class AspmmTokenStyleInformationProvider {
	
	public static String TASK_ITEM_TOKEN_NAME = "TASK_ITEM";
	
	public ASPMM.resource.aspmm.IAspmmTokenStyle getDefaultTokenStyle(String tokenName) {
		if ("metamodel".equals(tokenName)) {
			return new ASPMM.resource.aspmm.mopp.AspmmTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("metanode".equals(tokenName)) {
			return new ASPMM.resource.aspmm.mopp.AspmmTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("metaprop".equals(tokenName)) {
			return new ASPMM.resource.aspmm.mopp.AspmmTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("metaedge".equals(tokenName)) {
			return new ASPMM.resource.aspmm.mopp.AspmmTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("association".equals(tokenName)) {
			return new ASPMM.resource.aspmm.mopp.AspmmTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("generalization".equals(tokenName)) {
			return new ASPMM.resource.aspmm.mopp.AspmmTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("composition".equals(tokenName)) {
			return new ASPMM.resource.aspmm.mopp.AspmmTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("TASK_ITEM".equals(tokenName)) {
			return new ASPMM.resource.aspmm.mopp.AspmmTokenStyle(new int[] {0x7F, 0x9F, 0xBF}, null, true, false, false, false);
		}
		return null;
	}
	
}
