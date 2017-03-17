/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPMM.resource.aspmm.mopp;

public class AspmmSyntaxElementDecorator {
	
	/**
	 * the syntax element to be decorated
	 */
	private ASPMM.resource.aspmm.grammar.AspmmSyntaxElement decoratedElement;
	
	/**
	 * an array of child decorators (one decorator per child of the decorated syntax
	 * element
	 */
	private AspmmSyntaxElementDecorator[] childDecorators;
	
	/**
	 * a list of the indices that must be printed
	 */
	private java.util.List<Integer> indicesToPrint = new java.util.ArrayList<Integer>();
	
	public AspmmSyntaxElementDecorator(ASPMM.resource.aspmm.grammar.AspmmSyntaxElement decoratedElement, AspmmSyntaxElementDecorator[] childDecorators) {
		super();
		this.decoratedElement = decoratedElement;
		this.childDecorators = childDecorators;
	}
	
	public void addIndexToPrint(Integer index) {
		indicesToPrint.add(index);
	}
	
	public ASPMM.resource.aspmm.grammar.AspmmSyntaxElement getDecoratedElement() {
		return decoratedElement;
	}
	
	public AspmmSyntaxElementDecorator[] getChildDecorators() {
		return childDecorators;
	}
	
	public Integer getNextIndexToPrint() {
		if (indicesToPrint.size() == 0) {
			return null;
		}
		return indicesToPrint.remove(0);
	}
	
	public String toString() {
		return "" + getDecoratedElement();
	}
	
}
