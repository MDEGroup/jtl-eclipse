/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPM.resource.aspm.ui;

public class AspmOutlinePageCollapseAllAction extends ASPM.resource.aspm.ui.AbstractAspmOutlinePageAction {
	
	public AspmOutlinePageCollapseAllAction(ASPM.resource.aspm.ui.AspmOutlinePageTreeViewer treeViewer) {
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
