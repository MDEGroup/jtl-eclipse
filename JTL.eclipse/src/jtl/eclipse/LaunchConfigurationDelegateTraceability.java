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

		// Traces model
		File tracesFile = null;
		if (configuration.getAttribute(LaunchConfigurationAttributes.TRACE_CHECK, false)) {
			tracesFile = new File(configuration
					.getAttribute(LaunchConfigurationAttributes.TRACE_TEXT, ""));
		}

		// Register the metamodels
		RegisterMetamodel.registerMetamodel(Paths.get(wsPath, sourcemmFile.getPath()).toFile());
		RegisterMetamodel.registerMetamodel(Paths.get(wsPath, targetmmFile.getPath()).toFile());

		// Dispatch execution to specific launchers:
		AbstractEclipseJTLLauncher launcher;
		if (Files.getFileExtension(transfFile).equals("dl")) {
			if (sourcemmFile.equals(targetmmFile)) {
				// ASP Endogenous transformation
				if (tracesFile == null) {
					launcher = new ASPEndogenousLauncher(
							sourcemmFile, sourcemFile, targetmFolder, transfFile);
				} else {
					launcher = new ASPEndogenousLauncher(
							sourcemmFile, sourcemFile, targetmFolder,
							transfFile, tracesFile);
				}
			} else {
				// ASP Exogenous transformation
				if (tracesFile == null) {
					launcher = new ASPExogenousLauncher(
							sourcemmFile, targetmmFile,	sourcemFile,
							targetmFolder, transfFile);
				} else {
					launcher = new ASPExogenousLauncher(
							sourcemmFile, targetmmFile,	sourcemFile,
							targetmFolder, transfFile, tracesFile);
				}
			}
		} else if (Files.getFileExtension(transfFile).equals("jtl")) {
			if (sourcemmFile.equals(targetmmFile)) {
				// Endogenous transformation
				if (tracesFile == null) {
					launcher = new JTLEndogenousLauncher(
							sourcemmFile, sourcemFile, targetmFolder, transfFile);
				} else {
					launcher = new JTLEndogenousLauncher(
							sourcemmFile, sourcemFile, targetmFolder,
							transfFile, tracesFile);
				}
			} else {
				// Exogenous transformation
				if (tracesFile == null) {
					launcher = new JTLExogenousLauncher(
							sourcemmFile, targetmmFile,	sourcemFile,
							targetmFolder, transfFile);
				} else {
					launcher = new JTLExogenousLauncher(
							sourcemmFile, targetmmFile,	sourcemFile,
							targetmFolder, transfFile, tracesFile);
				}
			}
		} else {
			System.err.println("Transformation file must have '.jtl' or '.dl' extension.");
			return;
		}

		// Target models limit
		if (configuration.getAttribute(LaunchConfigurationAttributes.TRANSF_LIMIT, 0) > 0) {
			launcher.setTargetModelsLimit(
					configuration.getAttribute(LaunchConfigurationAttributes.TRANSF_LIMIT, 0));
		}

		// Set the chained trasformation, if needed
		if (configuration.getAttribute(LaunchConfigurationAttributes.CHAIN_CHECK, false)) {
			launcher.setChainTransformation(
					configuration.getAttribute(LaunchConfigurationAttributes.CHAIN_COMBO, ""));
			launcher.setChainLimit(
					configuration.getAttribute(LaunchConfigurationAttributes.CHAIN_LIMIT, 1));
		}

		// Launch
		launcher.launch();
	}
}
