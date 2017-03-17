/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPMM.resource.aspmm.ui;

public class AspmmOutlinePageActionProvider {
	
	public java.util.List<org.eclipse.jface.action.IAction> getActions(ASPMM.resource.aspmm.ui.AspmmOutlinePageTreeViewer treeViewer) {
		// To add custom actions to the outline view, set the
		// 'overrideOutlinePageActionProvider' option to <code>false</code> and modify
		// this method.
		java.util.List<org.eclipse.jface.action.IAction> defaultActions = new java.util.ArrayList<org.eclipse.jface.action.IAction>();
		defaultActions.add(new ASPMM.resource.aspmm.ui.AspmmOutlinePageLinkWithEditorAction(treeViewer));
		defaultActions.add(new ASPMM.resource.aspmm.ui.AspmmOutlinePageCollapseAllAction(treeViewer));
		defaultActions.add(new ASPMM.resource.aspmm.ui.AspmmOutlinePageExpandAllAction(treeViewer));
		defaultActions.add(new ASPMM.resource.aspmm.ui.AspmmOutlinePageAutoExpandAction(treeViewer));
		defaultActions.add(new ASPMM.resource.aspmm.ui.AspmmOutlinePageLexicalSortingAction(treeViewer));
		defaultActions.add(new ASPMM.resource.aspmm.ui.AspmmOutlinePageTypeSortingAction(treeViewer));
		return defaultActions;
	}
	
}
