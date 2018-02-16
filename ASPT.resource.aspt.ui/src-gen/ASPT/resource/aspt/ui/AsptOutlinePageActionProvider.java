/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPT.resource.aspt.ui;

public class AsptOutlinePageActionProvider {
	
	public java.util.List<org.eclipse.jface.action.IAction> getActions(ASPT.resource.aspt.ui.AsptOutlinePageTreeViewer treeViewer) {
		// To add custom actions to the outline view, set the
		// 'overrideOutlinePageActionProvider' option to <code>false</code> and modify
		// this method.
		java.util.List<org.eclipse.jface.action.IAction> defaultActions = new java.util.ArrayList<org.eclipse.jface.action.IAction>();
		defaultActions.add(new ASPT.resource.aspt.ui.AsptOutlinePageLinkWithEditorAction(treeViewer));
		defaultActions.add(new ASPT.resource.aspt.ui.AsptOutlinePageCollapseAllAction(treeViewer));
		defaultActions.add(new ASPT.resource.aspt.ui.AsptOutlinePageExpandAllAction(treeViewer));
		defaultActions.add(new ASPT.resource.aspt.ui.AsptOutlinePageAutoExpandAction(treeViewer));
		defaultActions.add(new ASPT.resource.aspt.ui.AsptOutlinePageLexicalSortingAction(treeViewer));
		defaultActions.add(new ASPT.resource.aspt.ui.AsptOutlinePageTypeSortingAction(treeViewer));
		return defaultActions;
	}
	
}
