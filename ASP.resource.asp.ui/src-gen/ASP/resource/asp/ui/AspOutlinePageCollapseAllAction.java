/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASP.resource.asp.ui;

public class AspOutlinePageCollapseAllAction extends ASP.resource.asp.ui.AbstractAspOutlinePageAction {
	
	public AspOutlinePageCollapseAllAction(ASP.resource.asp.ui.AspOutlinePageTreeViewer treeViewer) {
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
