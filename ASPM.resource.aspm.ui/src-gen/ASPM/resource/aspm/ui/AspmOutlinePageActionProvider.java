/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPM.resource.aspm.ui;

public class AspmOutlinePageActionProvider {
	
	public java.util.List<org.eclipse.jface.action.IAction> getActions(ASPM.resource.aspm.ui.AspmOutlinePageTreeViewer treeViewer) {
		// To add custom actions to the outline view, set the
		// 'overrideOutlinePageActionProvider' option to <code>false</code> and modify
		// this method.
		java.util.List<org.eclipse.jface.action.IAction> defaultActions = new java.util.ArrayList<org.eclipse.jface.action.IAction>();
		defaultActions.add(new ASPM.resource.aspm.ui.AspmOutlinePageLinkWithEditorAction(treeViewer));
		defaultActions.add(new ASPM.resource.aspm.ui.AspmOutlinePageCollapseAllAction(treeViewer));
		defaultActions.add(new ASPM.resource.aspm.ui.AspmOutlinePageExpandAllAction(treeViewer));
		defaultActions.add(new ASPM.resource.aspm.ui.AspmOutlinePageAutoExpandAction(treeViewer));
		defaultActions.add(new ASPM.resource.aspm.ui.AspmOutlinePageLexicalSortingAction(treeViewer));
		defaultActions.add(new ASPM.resource.aspm.ui.AspmOutlinePageTypeSortingAction(treeViewer));
		return defaultActions;
	}
	
}
