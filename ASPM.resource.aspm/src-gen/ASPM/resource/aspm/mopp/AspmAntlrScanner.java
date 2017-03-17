/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPM.resource.aspm.mopp;

public class AspmAntlrScanner implements ASPM.resource.aspm.IAspmTextScanner {
	
	private org.antlr.runtime3_4_0.Lexer antlrLexer;
	
	public AspmAntlrScanner(org.antlr.runtime3_4_0.Lexer antlrLexer) {
		this.antlrLexer = antlrLexer;
	}
	
	public ASPM.resource.aspm.IAspmTextToken getNextToken() {
		if (antlrLexer.getCharStream() == null) {
			return null;
		}
		final org.antlr.runtime3_4_0.Token current = antlrLexer.nextToken();
		if (current == null || current.getType() < 0) {
			return null;
		}
		ASPM.resource.aspm.IAspmTextToken result = new ASPM.resource.aspm.mopp.AspmANTLRTextToken(current);
		return result;
	}
	
	public void setText(String text) {
		antlrLexer.setCharStream(new org.antlr.runtime3_4_0.ANTLRStringStream(text));
	}
	
}
