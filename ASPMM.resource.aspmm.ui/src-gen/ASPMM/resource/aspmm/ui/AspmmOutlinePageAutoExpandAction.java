/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPMM.resource.aspmm.ui;

public class AspmmOutlinePageAutoExpandAction extends ASPMM.resource.aspmm.ui.AbstractAspmmOutlinePageAction {
	
	public AspmmOutlinePageAutoExpandAction(ASPMM.resource.aspmm.ui.AspmmOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Auto expand", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/auto_expand_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setAutoExpand(on);
		getTreeViewer().refresh();
	}
	
}
