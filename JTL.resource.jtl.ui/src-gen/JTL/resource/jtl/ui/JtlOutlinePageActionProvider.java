/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package JTL.resource.jtl.ui;

public class JtlOutlinePageActionProvider {
	
	public java.util.List<org.eclipse.jface.action.IAction> getActions(JTL.resource.jtl.ui.JtlOutlinePageTreeViewer treeViewer) {
		// To add custom actions to the outline view, set the
		// 'overrideOutlinePageActionProvider' option to <code>false</code> and modify
		// this method.
		java.util.List<org.eclipse.jface.action.IAction> defaultActions = new java.util.ArrayList<org.eclipse.jface.action.IAction>();
		defaultActions.add(new JTL.resource.jtl.ui.JtlOutlinePageLinkWithEditorAction(treeViewer));
		defaultActions.add(new JTL.resource.jtl.ui.JtlOutlinePageCollapseAllAction(treeViewer));
		defaultActions.add(new JTL.resource.jtl.ui.JtlOutlinePageExpandAllAction(treeViewer));
		defaultActions.add(new JTL.resource.jtl.ui.JtlOutlinePageAutoExpandAction(treeViewer));
		defaultActions.add(new JTL.resource.jtl.ui.JtlOutlinePageLexicalSortingAction(treeViewer));
		defaultActions.add(new JTL.resource.jtl.ui.JtlOutlinePageTypeSortingAction(treeViewer));
		return defaultActions;
	}
	
}
