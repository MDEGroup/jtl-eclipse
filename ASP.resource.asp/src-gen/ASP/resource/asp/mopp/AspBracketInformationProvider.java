/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASP.resource.asp.mopp;

public class AspBracketInformationProvider {
	
	public class BracketPair implements ASP.resource.asp.IAspBracketPair {
		
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
	
	public java.util.Collection<ASP.resource.asp.IAspBracketPair> getBracketPairs() {
		java.util.Collection<ASP.resource.asp.IAspBracketPair> result = new java.util.ArrayList<ASP.resource.asp.IAspBracketPair>();
		result.add(new BracketPair("(", ")", true));
		return result;
	}
	
}
