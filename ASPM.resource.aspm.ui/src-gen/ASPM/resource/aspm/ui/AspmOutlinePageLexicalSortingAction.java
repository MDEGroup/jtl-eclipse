/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPM.resource.aspm.ui;

public class AspmOutlinePageLexicalSortingAction extends ASPM.resource.aspm.ui.AbstractAspmOutlinePageAction {
	
	public AspmOutlinePageLexicalSortingAction(ASPM.resource.aspm.ui.AspmOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Sort alphabetically", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/sort_lexically_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewerComparator().setSortLexically(on);
		getTreeViewer().refresh();
	}
	
}
