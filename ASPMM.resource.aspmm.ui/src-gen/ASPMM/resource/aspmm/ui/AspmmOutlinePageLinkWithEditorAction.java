/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPMM.resource.aspmm.ui;

public class AspmmOutlinePageLinkWithEditorAction extends ASPMM.resource.aspmm.ui.AbstractAspmmOutlinePageAction {
	
	public AspmmOutlinePageLinkWithEditorAction(ASPMM.resource.aspmm.ui.AspmmOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Link with Editor", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/link_with_editor_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setLinkWithEditor(on);
	}
	
}
