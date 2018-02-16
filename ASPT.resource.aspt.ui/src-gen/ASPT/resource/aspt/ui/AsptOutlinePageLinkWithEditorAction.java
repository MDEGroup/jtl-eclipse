/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPT.resource.aspt.ui;

public class AsptOutlinePageLinkWithEditorAction extends ASPT.resource.aspt.ui.AbstractAsptOutlinePageAction {
	
	public AsptOutlinePageLinkWithEditorAction(ASPT.resource.aspt.ui.AsptOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Link with Editor", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/link_with_editor_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setLinkWithEditor(on);
	}
	
}
