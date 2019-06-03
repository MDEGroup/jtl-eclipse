package jtl.eclipse.handlers;

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

import jtl.transformations.TraceModel2ASPT;

/**
 * Eclipse handler for TraceModel2ASPT transformations.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class TraceModel2ASPTHandler extends AbstractHandler {

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
			targetFile = TraceModel2ASPT.runTransformation(
					file.getFullPath().toOSString());
		} catch (IOException | ATLCoreException e1) {
			MessageDialog.openInformation(window.getShell(),
					"ATL Transformation",
					"There was an error performing the transformation.");
			e1.printStackTrace();
			return null;
		}

		// Refresh the Project Explorer to show the new file
		try {
			((IResource) element).getProject()
					.refreshLocal(IResource.DEPTH_INFINITE, null);
		} catch (CoreException e) {
			e.printStackTrace();
		}

		if (targetFile != null) {
			MessageDialog.openInformation(
					window.getShell(),
					"ATL Transformation",
					String.format("%s\nconverted to\n%s.",
							file.getFullPath(), targetFile));

			return null;
		} else {
			// Sorry, this is not a trace model
			MessageDialog.openInformation(
					window.getShell(),
					"ATL Transformation",
					"The model must be a trace model.");
			return null;
		}
	}

}
