package jtl.eclipse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.ILaunchGroup;
import org.eclipse.debug.ui.ILaunchShortcut;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

public class LaunchShortcut implements ILaunchShortcut {

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
	public void launch(IEditorPart arg0, String arg1) {
		// TODO Auto-generated method stub

	}

	private void launch(IFile file, String mode) {
		try {
			// Get the full path of the launched file
			String transformationFile = file.getFullPath().toPortableString();

			// Load existing launch configurations
			ILaunchManager lm = DebugPlugin.getDefault().getLaunchManager();
			ILaunchConfigurationType type = lm.getLaunchConfigurationType("JTL.launchConfigurationType");
			ILaunchConfiguration[] configurations = lm.getLaunchConfigurations(type);

			// Check if there exists a launch configuration using this transformation
			for (ILaunchConfiguration configuration : configurations) {
				if (configuration.getAttribute(LaunchConfigurationAttributes.TRANSF_TEXT, "")
						.equals(transformationFile)) {
					DebugUITools.launch(configuration, mode);
					return;
				}
			}

			// If no configuration is found, create a new one
			ILaunchConfigurationWorkingCopy workingCopy =
					type.newInstance(null, lm.generateLaunchConfigurationName(file.getName()));

			// Set the transformation path
			workingCopy.setAttribute(LaunchConfigurationAttributes.TRANSF_TEXT, transformationFile);

			// Try to guess source and target metamodel
			// Extract metamodels URIs from the JTL transformation
			if (file.getFileExtension().equals("jtl")) {
				try (BufferedReader br = new BufferedReader(new FileReader(file.getLocation().toOSString()))) {
					String line;
					Pattern p =
							Pattern.compile("^.*transformation [^\\(]+\\([^:]+ *: *([^ ]+) *, *[^:]+ *: *([^\\)]+ *)");
					while ((line = br.readLine()) != null) {
						Matcher m = p.matcher(line);
						if (m.find()) {
							workingCopy
								.setAttribute(LaunchConfigurationAttributes.SOURCEMM_TEXT,
										findMathingMetamodel(file.getProject(), m.group(1)));
							workingCopy
								.setAttribute(LaunchConfigurationAttributes.TARGETMM_TEXT,
										findMathingMetamodel(file.getProject(), m.group(2)));
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

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

	/**
	 * Look for a metamodel matching an nsURI in a give container.
	 * @param container container in which to look (ex. a project in the workspace)
	 * @param nsURI nsURI to find
	 * @return path to the metamodel file
	 */
	private String findMathingMetamodel(final IContainer container, final String nsURI) {
		ResourceSet rs = new ResourceSetImpl();
		try {
			IResource [] members = container.members();
			for (IResource member : members) {
				if (member instanceof IContainer) {
					return findMathingMetamodel((IContainer) member, nsURI);
				} else if (member instanceof IFile && member.getFileExtension().equals("ecore")) {
					Resource mmResource = rs.getResource(
							URI.createURI(member.getFullPath().toString()), true);
					EObject mmPackage = mmResource.getContents().get(0);
					if (mmPackage.eClass().getName().equals("EPackage")) {
						EPackage p = (EPackage) mmPackage;
						if (p.getNsURI().equals(nsURI)) {
							return member.getFullPath().toPortableString();
						}
					}
				}
			}
		} catch (CoreException e) {
			e.printStackTrace();
			return "";
		}
		return "";
	}

}
