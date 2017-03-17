/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package JTL.resource.jtl.ui;

public class JtlOutlinePageLinkWithEditorAction extends JTL.resource.jtl.ui.AbstractJtlOutlinePageAction {
	
	public JtlOutlinePageLinkWithEditorAction(JTL.resource.jtl.ui.JtlOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Link with Editor", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/link_with_editor_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setLinkWithEditor(on);
	}
	
}
