/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package JTL.resource.jtl.ui;

public class JtlOutlinePageAutoExpandAction extends JTL.resource.jtl.ui.AbstractJtlOutlinePageAction {
	
	public JtlOutlinePageAutoExpandAction(JTL.resource.jtl.ui.JtlOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Auto expand", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/auto_expand_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setAutoExpand(on);
		getTreeViewer().refresh();
	}
	
}
