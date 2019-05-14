package jtl.eclipse;


import java.io.File;
import java.nio.file.Paths;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;

import jtl.transformations.RegisterMetamodel;
import jtl.utils.Files;

public class LaunchConfigurationDelegateTraceability
		implements ILaunchConfigurationDelegate {

	@Override
	public void launch(ILaunchConfiguration configuration,
					   String mode,
					   ILaunch launch,
					   IProgressMonitor monitor)
			throws CoreException {

		// Workspace absolute path
		final String wsPath = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString();

		// Left Metamodel
		final File leftmmFile = new File(configuration
				.getAttribute(LaunchConfigurationAttributes.LEFTMM_TEXT, ""));

		// Right metamodel
		final File rightmmFile = new File(configuration
				.getAttribute(LaunchConfigurationAttributes.RIGHTMM_TEXT, ""));

		// Left model
		final File leftmFile = new File(configuration
				.getAttribute(LaunchConfigurationAttributes.LEFTM_TEXT, ""));

		// Right model
		final File rightmFolder = new File(configuration
				.getAttribute(LaunchConfigurationAttributes.RIGHTM_TEXT, ""));

		// Transformation
		final File transfFile = new File(configuration
				.getAttribute(LaunchConfigurationAttributes.TRANSF_TEXT, ""));

		// Trace model (output)
		final File traceFile = new File(configuration
				.getAttribute(LaunchConfigurationAttributes.TRACE_TEXT, ""));

		// Register the metamodels
		RegisterMetamodel.registerMetamodel(Paths.get(wsPath, leftmmFile.getPath()).toFile());
		RegisterMetamodel.registerMetamodel(Paths.get(wsPath, rightmmFile.getPath()).toFile());

		// Dispatch execution to specific launchers:
		jtl.launcher.ASPExogenousTraceabilityLauncher launcher;
		if (Files.getFileExtension(transfFile).equals("dl")) {
			if (leftmmFile.equals(rightmmFile)) {
				System.err.println("Not implemented");
				return;
			} else {
				// ASP Exogenous transformation
				launcher = new ASPExogenousTraceabilityLauncher(
						leftmmFile, rightmmFile, leftmFile,
						rightmFolder, transfFile, traceFile);
			}
		} else if (Files.getFileExtension(transfFile).equals("jtl")) {
			System.err.println("Not implemented");
			return;
		} else {
			System.err.println("Transformation file must have '.jtl' or '.dl' extension.");
			return;
		}

		// Launch
		launcher.launch();
	}
}
