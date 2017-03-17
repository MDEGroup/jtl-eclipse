/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPMM.resource.aspmm.ui;

public class AspmmOutlinePageCollapseAllAction extends ASPMM.resource.aspmm.ui.AbstractAspmmOutlinePageAction {
	
	public AspmmOutlinePageCollapseAllAction(ASPMM.resource.aspmm.ui.AspmmOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Collapse all", org.eclipse.jface.action.IAction.AS_PUSH_BUTTON);
		initialize("icons/collapse_all_icon.gif");
	}
	
	public void runInternal(boolean on) {
		if (on) {
			getTreeViewer().collapseAll();
		}
	}
	
	public boolean keepState() {
		return false;
	}
	
}
