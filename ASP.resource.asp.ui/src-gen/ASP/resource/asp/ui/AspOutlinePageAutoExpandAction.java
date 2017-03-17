/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASP.resource.asp.ui;

public class AspOutlinePageAutoExpandAction extends ASP.resource.asp.ui.AbstractAspOutlinePageAction {
	
	public AspOutlinePageAutoExpandAction(ASP.resource.asp.ui.AspOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Auto expand", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/auto_expand_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setAutoExpand(on);
		getTreeViewer().refresh();
	}
	
}
