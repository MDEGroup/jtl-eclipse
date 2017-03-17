/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASP.resource.asp.ui;

public class AspOutlinePageTypeSortingAction extends ASP.resource.asp.ui.AbstractAspOutlinePageAction {
	
	public AspOutlinePageTypeSortingAction(ASP.resource.asp.ui.AspOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Group types", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/group_types_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewerComparator().setGroupTypes(on);
		getTreeViewer().refresh();
	}
	
}
