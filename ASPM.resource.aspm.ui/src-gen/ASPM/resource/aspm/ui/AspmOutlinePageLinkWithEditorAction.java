/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPM.resource.aspm.ui;

public class AspmOutlinePageLinkWithEditorAction extends ASPM.resource.aspm.ui.AbstractAspmOutlinePageAction {
	
	public AspmOutlinePageLinkWithEditorAction(ASPM.resource.aspm.ui.AspmOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Link with Editor", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/link_with_editor_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setLinkWithEditor(on);
	}
	
}
