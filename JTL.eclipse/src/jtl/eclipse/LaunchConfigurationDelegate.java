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

public class LaunchConfigurationDelegate
		implements ILaunchConfigurationDelegate {

	@Override
	public void launch(ILaunchConfiguration configuration,
					   String mode,
					   ILaunch launch,
					   IProgressMonitor monitor)
			throws CoreException {

		// Workspace absolute path
		final String wsPath = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString();

		// Source Metamodel
		final File sourcemmFile = new File(Paths.get(wsPath, configuration
				.getAttribute(LaunchConfigurationAttributes.SOURCEMM_TEXT, "")).toString());

		// Target metamodel
		final File targetmmFile = new File(Paths.get(wsPath, configuration
				.getAttribute(LaunchConfigurationAttributes.TARGETMM_TEXT, "")).toString());

		// Source model
		final File sourcemFile = new File(Paths.get(wsPath, configuration
				.getAttribute(LaunchConfigurationAttributes.SOURCEM_TEXT, "")).toString());

		// Target models folder
		final File targetmFolder = new File(Paths.get(wsPath, configuration
				.getAttribute(LaunchConfigurationAttributes.TARGETM_TEXT, "")).toString());

		// Transformation
		final File transfFile = new File(Paths.get(wsPath, configuration
				.getAttribute(LaunchConfigurationAttributes.TRANSF_TEXT, "")).toString());

		// Register the metamodels
		RegisterMetamodel.registerMetamodel(sourcemmFile);
		RegisterMetamodel.registerMetamodel(targetmmFile);

		// Dispatch execution to specific launchers:
		AbstractEclipseJTLLauncher launcher;
		if (Files.getFileExtension(transfFile).equals("dl")) {
			if (sourcemmFile.equals(targetmmFile)) {
				// ASP Endogenous transformation
				launcher = new ASPEndogenousLauncher(
						sourcemmFile, sourcemFile, targetmFolder, transfFile);
			} else {
				// ASP Exogenous transformation
				launcher = new ASPExogenousLauncher(
						sourcemmFile, targetmmFile,	sourcemFile,
						targetmFolder, transfFile);
			}
		} else if (Files.getFileExtension(transfFile).equals("jtl")) {
			if (sourcemmFile.equals(targetmmFile)) {
				// Endogenous transformation
				launcher = new JTLEndogenousLauncher(
						sourcemmFile, sourcemFile, targetmFolder, transfFile);
			} else {
				// Exogenous transformation
				launcher = new JTLExogenousLauncher(
						sourcemmFile, targetmmFile,	sourcemFile,
						targetmFolder, transfFile);
			}
		} else {
			System.err.println("Transformation file must have '.jtl' or '.dl' extension.");
			return;
		}

		// Launch
		launcher.launch();
	}
}
