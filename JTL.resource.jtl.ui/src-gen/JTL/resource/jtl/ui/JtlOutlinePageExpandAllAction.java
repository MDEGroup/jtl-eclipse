/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package JTL.resource.jtl.ui;

public class JtlOutlinePageExpandAllAction extends JTL.resource.jtl.ui.AbstractJtlOutlinePageAction {
	
	public JtlOutlinePageExpandAllAction(JTL.resource.jtl.ui.JtlOutlinePageTreeViewer treeViewer) {
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
