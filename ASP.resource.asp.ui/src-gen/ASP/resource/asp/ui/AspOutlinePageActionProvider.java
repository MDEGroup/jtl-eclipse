/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASP.resource.asp.ui;

public class AspOutlinePageActionProvider {
	
	public java.util.List<org.eclipse.jface.action.IAction> getActions(ASP.resource.asp.ui.AspOutlinePageTreeViewer treeViewer) {
		// To add custom actions to the outline view, set the
		// 'overrideOutlinePageActionProvider' option to <code>false</code> and modify
		// this method.
		java.util.List<org.eclipse.jface.action.IAction> defaultActions = new java.util.ArrayList<org.eclipse.jface.action.IAction>();
		defaultActions.add(new ASP.resource.asp.ui.AspOutlinePageLinkWithEditorAction(treeViewer));
		defaultActions.add(new ASP.resource.asp.ui.AspOutlinePageCollapseAllAction(treeViewer));
		defaultActions.add(new ASP.resource.asp.ui.AspOutlinePageExpandAllAction(treeViewer));
		defaultActions.add(new ASP.resource.asp.ui.AspOutlinePageAutoExpandAction(treeViewer));
		defaultActions.add(new ASP.resource.asp.ui.AspOutlinePageLexicalSortingAction(treeViewer));
		defaultActions.add(new ASP.resource.asp.ui.AspOutlinePageTypeSortingAction(treeViewer));
		return defaultActions;
	}
	
}
