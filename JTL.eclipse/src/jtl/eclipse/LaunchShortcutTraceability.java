package jtl.eclipse;

import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.ILaunchGroup;
import org.eclipse.debug.ui.ILaunchShortcut;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

public class LaunchShortcutTraceability implements ILaunchShortcut {

	@Override
	public void launch(ISelection selection, String mode) {
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			Iterator<?> it = structuredSelection.iterator();
			while (it.hasNext()) {
				Object object = it.next();
				if (object instanceof IFile) {
					IFile file = (IFile) object;
					launch(file, mode);
				}
			}
		}
	}

	@Override
	public void launch(IEditorPart arg0, String arg1) {	}

	private void launch(IFile file, String mode) {
		try {
			// Get the full path of the launched file
			String transformationFile = file.getFullPath().toPortableString();

			ILaunchManager lm = DebugPlugin.getDefault().getLaunchManager();
			ILaunchConfigurationType type = lm.getLaunchConfigurationType("JTL.launchtraceConfigurationType");

			// If no configuration is found, create a new one
			ILaunchConfigurationWorkingCopy workingCopy =
					type.newInstance(null, lm.generateLaunchConfigurationName(file.getName()));

			// Set the transformation path
			workingCopy.setAttribute(LaunchConfigurationAttributes.TRANSF_TEXT, transformationFile);

			// Launch the run configuration dialog
			ILaunchGroup group = DebugUITools.getLaunchGroup(workingCopy, mode);
			if (DebugUITools.openLaunchConfigurationDialog(
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
					workingCopy,
					group.getIdentifier(),
					Status.OK_STATUS) != Window.CANCEL) {
				workingCopy.doSave();
			}
		} catch (CoreException e) {
			System.err.println("Exception while launching selection.");
			e.printStackTrace();
			return;
		}
	}

}
