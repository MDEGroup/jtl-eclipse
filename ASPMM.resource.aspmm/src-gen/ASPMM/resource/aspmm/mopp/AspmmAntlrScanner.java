/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPMM.resource.aspmm.mopp;

public class AspmmAntlrScanner implements ASPMM.resource.aspmm.IAspmmTextScanner {
	
	private org.antlr.runtime3_4_0.Lexer antlrLexer;
	
	public AspmmAntlrScanner(org.antlr.runtime3_4_0.Lexer antlrLexer) {
		this.antlrLexer = antlrLexer;
	}
	
	public ASPMM.resource.aspmm.IAspmmTextToken getNextToken() {
		if (antlrLexer.getCharStream() == null) {
			return null;
		}
		final org.antlr.runtime3_4_0.Token current = antlrLexer.nextToken();
		if (current == null || current.getType() < 0) {
			return null;
		}
		ASPMM.resource.aspmm.IAspmmTextToken result = new ASPMM.resource.aspmm.mopp.AspmmANTLRTextToken(current);
		return result;
	}
	
	public void setText(String text) {
		antlrLexer.setCharStream(new org.antlr.runtime3_4_0.ANTLRStringStream(text));
	}
	
}
