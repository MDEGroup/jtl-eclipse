/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPMM.resource.aspmm.mopp;

public class AspmmBracketInformationProvider {
	
	public class BracketPair implements ASPMM.resource.aspmm.IAspmmBracketPair {
		
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
	
	public java.util.Collection<ASPMM.resource.aspmm.IAspmmBracketPair> getBracketPairs() {
		java.util.Collection<ASPMM.resource.aspmm.IAspmmBracketPair> result = new java.util.ArrayList<ASPMM.resource.aspmm.IAspmmBracketPair>();
		result.add(new BracketPair("(", ")", true));
		return result;
	}
	
}
