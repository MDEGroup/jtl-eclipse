/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPT.resource.aspt.ui;

public class AsptOutlinePageTypeSortingAction extends ASPT.resource.aspt.ui.AbstractAsptOutlinePageAction {
	
	public AsptOutlinePageTypeSortingAction(ASPT.resource.aspt.ui.AsptOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Group types", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/group_types_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewerComparator().setGroupTypes(on);
		getTreeViewer().refresh();
	}
	
}
