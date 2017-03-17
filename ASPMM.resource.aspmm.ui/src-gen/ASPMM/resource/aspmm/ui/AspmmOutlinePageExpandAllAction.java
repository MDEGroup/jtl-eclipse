/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPMM.resource.aspmm.ui;

public class AspmmOutlinePageExpandAllAction extends ASPMM.resource.aspmm.ui.AbstractAspmmOutlinePageAction {
	
	public AspmmOutlinePageExpandAllAction(ASPMM.resource.aspmm.ui.AspmmOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Expand all", org.eclipse.jface.action.IAction.AS_PUSH_BUTTON);
		initialize("icons/expand_all_icon.gif");
	}
	
	public void runInternal(boolean on) {
		if (on) {
			getTreeViewer().expandAll();
		}
	}
	
	public boolean keepState() {
		return false;
	}
	
}
