/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPT.resource.aspt.mopp;

public class AsptBracketInformationProvider {
	
	public class BracketPair implements ASPT.resource.aspt.IAsptBracketPair {
		
		private String opening;
		private String closing;
		private boolean closingEnabledInside;
		
		public BracketPair(String opening, String closing, boolean closingEnabledInside) {
			super();
			this.opening = opening;
			this.closing = closing;
			this.closingEnabledInside = closingEnabledInside;
		}
		
		public String getOpeningBracket() {
			return opening;
		}
		
		public String getClosingBracket() {
			return closing;
		}
		
		public boolean isClosingEnabledInside() {
			return closingEnabledInside;
		}
	}
	
	public java.util.Collection<ASPT.resource.aspt.IAsptBracketPair> getBracketPairs() {
		java.util.Collection<ASPT.resource.aspt.IAsptBracketPair> result = new java.util.ArrayList<ASPT.resource.aspt.IAsptBracketPair>();
		result.add(new BracketPair("\"", "\"", false));
		return result;
	}
	
}
