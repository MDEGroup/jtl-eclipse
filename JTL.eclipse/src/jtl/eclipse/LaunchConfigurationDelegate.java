package jtl.eclipse;


import java.nio.file.Paths;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;

import jtl.launcher.Launcher;
import jtl.transformations.RegisterMetamodel;
import jtl.utils.Files;

public class LaunchConfigurationDelegate
		implements ILaunchConfigurationDelegate {

	/** Logger */
	private static Logger logger = LogManager.getLogger(LaunchConfigurationDelegate.class);

	@Override
	public void launch(ILaunchConfiguration configuration,
					   String mode,
					   ILaunch launch,
					   IProgressMonitor monitor)
			throws CoreException {

		// Workspace absolute path
		final String wsPath = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString();

		// Source Metamodel
		final String sourcemmFile = configuration
				.getAttribute(LaunchConfigurationAttributes.SOURCEMM_TEXT, "");

		// Target metamodel
		final String targetmmFile = configuration
				.getAttribute(LaunchConfigurationAttributes.TARGETMM_TEXT, "");

		// Source model
		final String sourcemFile = configuration
				.getAttribute(LaunchConfigurationAttributes.SOURCEM_TEXT, "");

		// Target models folder
		final String targetmFolder = configuration
				.getAttribute(LaunchConfigurationAttributes.TARGETM_TEXT, "");

		// Transformation
		final String transfFile = configuration
				.getAttribute(LaunchConfigurationAttributes.TRANSF_TEXT, "");

		// Traces model
		String tracesFile = null;
		if (configuration.getAttribute(LaunchConfigurationAttributes.TRACE_CHECK, false)) {
			tracesFile = configuration
					.getAttribute(LaunchConfigurationAttributes.TRACE_TEXT, "");
		}

		// Register the metamodels
		RegisterMetamodel.registerMetamodel(Paths.get(wsPath, sourcemmFile).toFile());
		RegisterMetamodel.registerMetamodel(Paths.get(wsPath, targetmmFile).toFile());

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
			logger.error("Transformation file must have '.jtl' or '.dl' extension.");
			return;
		}

		// Traces model
		launcher.setTracesFile(tracesFile);

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

		// Process options
		Launcher.options.put(Launcher.OPTION_GENERATE_ASP,
				configuration.getAttribute(LaunchConfigurationAttributes.GENERATE_ASP, false));
		Launcher.options.put(Launcher.OPTION_CLEAR_TARGET,
				configuration.getAttribute(LaunchConfigurationAttributes.CLEAR_TARGET, false));

		// Launch
		launcher.launch();
	}
}
