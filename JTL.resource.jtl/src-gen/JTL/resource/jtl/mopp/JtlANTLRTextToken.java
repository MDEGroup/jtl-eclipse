/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package JTL.resource.jtl.mopp;

public class JtlANTLRTextToken extends JTL.resource.jtl.mopp.JtlTextToken {
	
	private final static JTL.resource.jtl.IJtlMetaInformation metaInformation = new JTL.resource.jtl.mopp.JtlMetaInformation();
	
	public JtlANTLRTextToken(org.antlr.runtime3_4_0.Token antlrToken) {
		super(getTokenName(metaInformation.getTokenNames(), antlrToken.getType()), antlrToken.getText(), ((org.antlr.runtime3_4_0.CommonToken) antlrToken).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) antlrToken).getStopIndex() - ((org.antlr.runtime3_4_0.CommonToken) antlrToken).getStartIndex() + 1, antlrToken.getLine(), antlrToken.getCharPositionInLine(), canBeUsedForSyntaxHighlighting(antlrToken.getType()));
	}
	
	public static String getTokenName(String[] tokenNames, int index) {
		if (tokenNames == null) {
			return null;
		}
		String tokenName = tokenNames[index];
		if (tokenName != null && tokenName.startsWith("'")) {
			tokenName = tokenName.substring(1, tokenName.length() - 1).trim();
		}
		return tokenName;
	}
	
	public static boolean canBeUsedForSyntaxHighlighting(int tokenType) {
		if (tokenType < 0) {
			return false;
		}
		if (tokenType == org.antlr.runtime3_4_0.Token.UP) {
			return false;
		}
		if (tokenType == org.antlr.runtime3_4_0.Token.DOWN) {
			return false;
		}
		if (tokenType == org.antlr.runtime3_4_0.Token.EOR_TOKEN_TYPE) {
			return false;
		}
		if (tokenType == org.antlr.runtime3_4_0.Token.INVALID_TOKEN_TYPE) {
			return false;
		}
		return true;
	}
	
}
