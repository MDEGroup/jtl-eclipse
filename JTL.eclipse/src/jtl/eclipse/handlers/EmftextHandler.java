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
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import jtl.transformations.EmftextConverter;
import jtl.transformations.RegisterMetamodel;

/**
 * Eclipse handler for Emftext transformations.
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
				file.getFullPath().toString());

		// Refresh the Project Explorer to show the new file
		try {
			((IResource) element).getProject()
					.refreshLocal(IResource.DEPTH_INFINITE, null);
		} catch (CoreException e) {
			e.printStackTrace();
		}

		// Register the target metamodel
		registerEmftextMetamodel(file.getFileExtension());

		MessageDialog.openInformation(
				window.getShell(),
				"Conversion completed",
				String.format("%s\nconverted to\n%s.",
						file.getFullPath(), targetFile));
		return null;
	}

	private void registerEmftextMetamodel(final String extension) {
		try {
			if (extension.equals("aspm")) {
				RegisterMetamodel.registerMetamodel(
						new it.univaq.jtl.atl.mm2aspm.MM2ASPmGenerator()
							.getMetamodelUri("ASPm"));
			} else if (extension.equals("aspmm")) {
				RegisterMetamodel.registerMetamodel(
						new it.univaq.jtl.atl.ecore2aspmm.Ecore2ASPmm()
							.getMetamodelUri("ASPmm"));
			} else if (extension.equals("aspt")) {
				RegisterMetamodel.registerMetamodel(
						new it.univaq.jtl.atl.tracemodel2aspt.TraceModel2ASPT()
							.getMetamodelUri("ASPT"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
