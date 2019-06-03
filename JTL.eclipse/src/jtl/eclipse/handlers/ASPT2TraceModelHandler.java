package jtl.eclipse.handlers;

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

import jtl.transformations.ASPT2TraceModel;

/**
 * Eclipse handler for ASPT2TraceModel transformations.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class ASPT2TraceModelHandler extends AbstractHandler {

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

		// Let the user select a source and target metamodel
		final IFile sourceM = selectMetamodel(window,
				"Select the source model of this trace:");
		final IFile targetM = selectMetamodel(window,
				"Select the target model of this trace:");

		// Perform the transformation
		String targetFile;
		try {
			targetFile = ASPT2TraceModel.runTransformation(
					file.getFullPath().toOSString(),
					sourceM.getFullPath().toOSString(),
					targetM.getFullPath().toOSString());
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
			// Sorry, this is not a JTL model
			MessageDialog.openInformation(
					window.getShell(),
					"ATL Transformation",
					"The source model must be a JTL model.");
			return null;
		}
	}

	private IFile selectMetamodel(
			final IWorkbenchWindow window,
			final String message) {
		ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(
		    window.getShell(),
		    new WorkbenchLabelProvider(),
		    new BaseWorkbenchContentProvider());
		dialog.setTitle("Metamodel selection");
		dialog.setMessage(message);
		dialog.setInput(ResourcesPlugin.getWorkspace().getRoot());
		dialog.setAllowMultiple(false);
		dialog.addFilter(new ViewerFilter() {
			@Override
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				if (element instanceof IFile) {
					return ((IFile) element).getFileExtension().equals("xmi");
				}
				return true;
			}
		});
		if (dialog.open() == Window.OK) {
		    IResource selected = (IResource) dialog.getFirstResult();
		    if (selected instanceof IFile) {
		    	return (IFile) selected;
		    } else {
				MessageDialog.openInformation(window.getShell(),
						"Error",
						selected.getFullPath() + " is not a valid selection.");
				return null;
		    }
		} else {
			return null;
		}
	}

}
