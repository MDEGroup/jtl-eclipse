/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPMM.resource.aspmm;

/**
 * A simple interface to access information about matching brackets.
 */
public interface IAspmmBracketPair {
	
	/**
	 * Returns the opening bracket.
	 */
	public String getOpeningBracket();
	
	/**
	 * Returns the closing bracket.
	 */
	public String getClosingBracket();
	
	/**
	 * Returns whether other bracket pairs shall be automatically closed, when used
	 * inside of this bracket pair.
	 */
	public boolean isClosingEnabledInside();
}
