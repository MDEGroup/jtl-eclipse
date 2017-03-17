/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPM.resource.aspm.ui;

public class AspmOutlinePageTypeSortingAction extends ASPM.resource.aspm.ui.AbstractAspmOutlinePageAction {
	
	public AspmOutlinePageTypeSortingAction(ASPM.resource.aspm.ui.AspmOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Group types", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/group_types_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewerComparator().setGroupTypes(on);
		getTreeViewer().refresh();
	}
	
}
