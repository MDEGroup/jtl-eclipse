/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPM.resource.aspm.ui;

public class AspmOutlinePageExpandAllAction extends ASPM.resource.aspm.ui.AbstractAspmOutlinePageAction {
	
	public AspmOutlinePageExpandAllAction(ASPM.resource.aspm.ui.AspmOutlinePageTreeViewer treeViewer) {
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
