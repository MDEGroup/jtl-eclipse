/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASP.resource.asp.ui;

public class AspOutlinePageLinkWithEditorAction extends ASP.resource.asp.ui.AbstractAspOutlinePageAction {
	
	public AspOutlinePageLinkWithEditorAction(ASP.resource.asp.ui.AspOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Link with Editor", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/link_with_editor_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setLinkWithEditor(on);
	}
	
}
