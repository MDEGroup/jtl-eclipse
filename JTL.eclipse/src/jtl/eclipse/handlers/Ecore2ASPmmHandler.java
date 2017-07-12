/**
 *
 */
package jtl.eclipse.handlers;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import jtl.transformations.Ecore2ASPmm;

/**
 * Eclipse handler for Ecore2ASPmm transformations.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class Ecore2ASPmmHandler extends AbstractHandler {

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

		// Perform the transformation
		String targetFile;
		try {
			targetFile = Ecore2ASPmm.runTransformation(
					new File(file.getFullPath().toOSString()));
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
