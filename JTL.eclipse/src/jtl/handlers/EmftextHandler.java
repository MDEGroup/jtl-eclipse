package jtl.handlers;

import java.io.File;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * TODO comment
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class EmftextHandler extends AbstractHandler {
	/**
	 * The constructor.
	 */
	public EmftextHandler() {
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
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
		String targetFile = new EmftextConverter().convert(
				new File(file.getFullPath().toString()));

		// Refresh the Project Explorer to show the new file
		try {
			((IResource) element).getProject()
					.refreshLocal(IResource.DEPTH_INFINITE, null);
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		MessageDialog.openInformation(
				window.getShell(),
				"Conversion completed",
				String.format("%s\nconverted to\n%s.",
						file.getFullPath(), targetFile));
		return null;
	}
}
