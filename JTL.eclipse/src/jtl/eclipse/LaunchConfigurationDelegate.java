package jtl.eclipse;


import java.io.File;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;

import jtl.transformations.RegisterMetamodel;

public class LaunchConfigurationDelegate
		implements ILaunchConfigurationDelegate {

	@Override
	public void launch(ILaunchConfiguration configuration,
					   String mode,
					   ILaunch launch,
					   IProgressMonitor monitor)
			throws CoreException {

		// Source Metamodel
		final File sourcemmFile = new File(configuration
				.getAttribute(LaunchConfigurationAttributes.SOURCEMM_TEXT, ""));

		// Target metamodel
		final File targetmmFile = new File(configuration
				.getAttribute(LaunchConfigurationAttributes.TARGETMM_TEXT, ""));

		// Source model
		final File sourcemFile = new File(configuration
				.getAttribute(LaunchConfigurationAttributes.SOURCEM_TEXT, ""));

		// Target models folder
		final File targetmFolder = new File(configuration
				.getAttribute(LaunchConfigurationAttributes.TARGETM_TEXT, ""));

		// Transformation
		final File transfFile = new File(configuration
				.getAttribute(LaunchConfigurationAttributes.TRANSF_TEXT, ""));

		// Register the metamodels
		RegisterMetamodel.registerMetamodel(sourcemmFile);
		RegisterMetamodel.registerMetamodel(targetmmFile);

		// Dispatch execution to specific launchers:
		AbstractEclipseJTLLauncher launcher;
		if (jtl.utils.File.getFileExtension(transfFile).equals("dl")) {
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
		} else if (sourcemmFile.equals(targetmmFile)) {
			// Endogenous transformation
//			launcher = new JTLEndogenousLauncher();
			launcher = null;
		} else {
			// Exogenous transformation
//			launcher = new JTLExogenousLauncher();
			launcher = null;
		}

		// Launch
		launcher.launch();
	}
}
