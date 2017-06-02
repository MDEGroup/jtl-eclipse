/**
 *
 */
package jtl.handlers;

import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.window.Window;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

/**
 * TODO comment
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class ASPm2MMHandler extends AbstractHandler {

	/* (non-Javadoc)
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		// Get the active window
		IWorkbenchWindow window =
				HandlerUtil.getActiveWorkbenchWindowChecked(event);

		// Get the selected resource (file)
		Object element = ((IStructuredSelection) window
				.getSelectionService().getSelection()).getFirstElement();
		IFile file = Platform.getAdapterManager()
				.getAdapter(element, IFile.class);

		// Let the user select a metamodel
		ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(
		    window.getShell(),
		    new WorkbenchLabelProvider(),
		    new BaseWorkbenchContentProvider());
		dialog.setMessage("Metamodel selection");
		dialog.setMessage("Select a metamodel for this model:");
		dialog.setInput(ResourcesPlugin.getWorkspace().getRoot());
		dialog.setAllowMultiple(false);
		dialog.addFilter(new ViewerFilter() {
			@Override
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				if (element instanceof IFile) {
					return ((IFile) element).getFileExtension().equals("ecore");
				}
				return true;
			}
		});
		IFile metamodel;
		if (dialog.open() == Window.OK) {
		    IResource selected = (IResource) dialog.getFirstResult();
		    if (selected instanceof IFile) {
		    	metamodel = (IFile) selected;
		    } else {
				MessageDialog.openInformation(window.getShell(),
						"Error",
						selected.getFullPath() + " is not a valid selection.");
				return null;
		    }
		} else {
			return null;
		}

		// Perform the transformation
		String targetFile;
		try {
			targetFile = ASPm2MM.runTransformation(metamodel, file);
		} catch (IOException | ATLCoreException e1) {
			MessageDialog.openInformation(window.getShell(),
					"ATL Transformation",
					"There was an error performing the transformation.");
			e1.printStackTrace();
			return null;
		}

		// Refresth the Project Explorer to show the new file
		try {
			((IResource) element).getProject()
					.refreshLocal(IResource.DEPTH_INFINITE, null);
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		MessageDialog.openInformation(
				window.getShell(),
				"ATL Transformation",
				String.format("%s\nconverted to\n%s.",
						file.getFullPath(), targetFile));

		return null;
	}

}
