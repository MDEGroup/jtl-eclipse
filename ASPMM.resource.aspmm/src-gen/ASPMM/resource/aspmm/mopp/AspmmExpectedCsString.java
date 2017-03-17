/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPMM.resource.aspmm.mopp;

/**
 * A representation for a range in a document where a keyword (i.e., a static
 * string) is expected.
 */
public class AspmmExpectedCsString extends ASPMM.resource.aspmm.mopp.AspmmAbstractExpectedElement {
	
	private ASPMM.resource.aspmm.grammar.AspmmKeyword keyword;
	
	public AspmmExpectedCsString(ASPMM.resource.aspmm.grammar.AspmmKeyword keyword) {
		super(keyword.getMetaclass());
		this.keyword = keyword;
	}
	
	public String getValue() {
		return keyword.getValue();
	}
	
	/**
	 * Returns the expected keyword.
	 */
	public ASPMM.resource.aspmm.grammar.AspmmSyntaxElement getSymtaxElement() {
		return keyword;
	}
	
	public java.util.Set<String> getTokenNames() {
		return java.util.Collections.singleton("'" + getValue() + "'");
	}
	
	public String toString() {
		return "CsString \"" + getValue() + "\"";
	}
	
	public boolean equals(Object o) {
		if (o instanceof AspmmExpectedCsString) {
			return getValue().equals(((AspmmExpectedCsString) o).getValue());
		}
		return false;
	}
	
	@Override	
	public int hashCode() {
		return getValue().hashCode();
	}
	
}
