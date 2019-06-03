package jtl.eclipse;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.emf.common.util.URI;

import jtl.launcher.AbstractJTLLauncher;
import jtl.solver.AbstractASPSolver;

public abstract class AbstractEclipseJTLLauncher extends AbstractJTLLauncher {

	/** Logger */
	private static Logger logger = LogManager.getLogger(AbstractEclipseJTLLauncher.class);

	// List of bundles names to get version from
	protected final static String[] bundles = new String[] {
		"ASP.resource.asp",
		"ASP.resource.asp.ui",
		"ASPM.resource.aspm",
		"ASPM.resource.aspm.ui",
		"ASPMM.resource.aspmm",
		"ASPMM.resource.aspmm.ui",
		"ASPT.resource.aspt",
		"ASPT.resource.aspt.ui",
		"JTL",
		"JTL.atl",
		"JTL.eclipse",
		"JTL.emftext.ASP",
		"JTL.emftext.ASPM",
		"JTL.emftext.ASPMM",
		"JTL.emftext.ASPT",
		"JTL.emftext.JTL",
		"JTL.resource.jtl",
		"JTL.resource.jtl.ui",
		"org.emftext.commons.antlr3_4_0"
	};

	/**
	 * Default constructor to be used by implementing classes.
	 * @param leftmmFile source metamodel file
	 * @param rightmmFile target metamodel file
	 * @param leftmFile source model file
	 * @param rightmFile folder where to save generated target models
	 * @param transfFile file specifying the transformation
	 */
	public AbstractEclipseJTLLauncher(
			final String leftmmFile,
			final String rightmmFile,
			final String leftmFile,
			final String rightmFile,
			final String transfFile) {
		super(leftmmFile, rightmmFile, leftmFile,
				rightmFile, transfFile);
	}

	/**
	 * Return the solver implementation class.
	 * @return solver object
	 */
	@Override
	protected AbstractASPSolver getSolver() {
		return new ASPSolver(this);
	}

	/**
	 * Runs the next transformation in the chain.
	 * @param targetFiles List of files to use as input
	 *        of the chained transformation
	 */
	@Override
	protected void runChainTransformation(final ArrayList<String> targetFiles) {
		// Get the launch configuration of the
		// next transformation in the chain
		ILaunchConfiguration lc = getLaunchConfiguration(this.chainTransformation);
		if (lc != null) {
			for (int i = 0; i < this.chainLimit; i++) {
				try {
					ILaunchConfigurationWorkingCopy lcwc =
							lc.copy("CHAINED_" + this.chainTransformation);
					lcwc.setAttribute(LaunchConfigurationAttributes.SOURCEM_TEXT, targetFiles.get(i));
					lcwc.launch(ILaunchManager.RUN_MODE, null);
				} catch (CoreException e) {
					logger.error("An error occurred launching a chained transformation...", e);
				}
			}
		}
	}


	/**
	 * Retrieves a JTL launch configuration specified by a name.
	 * @param name Name of the launch configuration
	 */
	protected ILaunchConfiguration  getLaunchConfiguration(final String name) {
		final ILaunchManager launchManager =
        		DebugPlugin.getDefault().getLaunchManager();
        ILaunchConfigurationType launchConfigurationType = launchManager
        		.getLaunchConfigurationType("JTL.launchConfigurationType");
        ILaunchConfiguration[] launchConfigurations = null;
        try {
			launchConfigurations = launchManager
					.getLaunchConfigurations(launchConfigurationType);
		} catch (CoreException e1) {
			e1.printStackTrace();
		}

        for (ILaunchConfiguration lc : launchConfigurations) {
        	if (lc.getName().equals(name)) {
        		return lc;
        	}
        }
        return null;
	}

	/**
	 * Compute MD5 of files involved in the launch
	 */
	@Override
	protected void computeMD5() {
		// Files involved in the launch
		final ArrayList<String> launchFilesList = new ArrayList<String>(Arrays.asList(
			sourcemmFile,
			targetmmFile,
			sourcemFile,
			transfFile
		));
		if (tracesFile != null) {
			launchFilesList.add(tracesFile);
		}
		final File[] launchFiles = launchFilesList.toArray(new File[launchFilesList.size()]);

		for (File file : launchFiles) {
			writeASP("% " + file.getPath() + " : " +
					getMD5Digest(getAbsolutePath(file.getPath())) + "\n");
		}
	}

	/**
	 * Get bundles versions
	 */
	@Override
	protected void getBundlesVersions() {
		// Get plugins versions
		for (String bundle : bundles) {
			writeASP("% " + bundle + " : " +
					Platform.getBundle(bundle).getVersion().toString() + "\n");
		}
	}

	/**
	 * Write the ASP to file.
	 * @return filename of the ASP final file
	 */
	@Override
	protected String writeASPToFile() {
		transfFile = getAbsolutePath(transfFile);
		return super.writeASPToFile();
	}

	/**
	 * Find the IFile corresponding to an URI.
	 * @param uriString URI to convert
	 * @return corresponding IFile
	 */
	protected static IFile getIFileFromURI(final String uriString) {
		URI uri = URI.createURI(uriString);
		if (uri.isPlatformResource()) {
			return (IFile) ResourcesPlugin.getWorkspace().getRoot()
					.findMember(uri.toPlatformString(true));
		} else if (uri.isRelative()) {
			IFile file = (IFile) ResourcesPlugin.getWorkspace().getRoot()
					.findMember(uri.toString());
			if (file != null) {
				return file;
			}
		}
		return getIFileFromURI(uriString.substring(
				ResourcesPlugin.getWorkspace()
				.getRoot().getLocation().toString().length()));
	}

	/**
	 * Remove a file in the workspace.
	 * @param file The file to remove.
	 */
	@Override
	protected void removeFile(final String file) {
		new File(getAbsolutePath(file)).delete();
	}

	/**
	 * Clean up the environment at the end of a launch
	 */
	@Override
	public void clean() {
		refreshWorkspace();
	}

	/**
	 * Refresh all the projects in the workspace.
	 */
	protected static void refreshWorkspace() {
		try {
			for(IProject project :
					ResourcesPlugin.getWorkspace().getRoot().getProjects()){
			    project.refreshLocal(IResource.DEPTH_INFINITE, null);
			}
		} catch (CoreException e) {
			logger.warn("An error occurred refreshing the workspace.", e);
			return;
		}
	}

	/**
	 * Return the absolute path of a resource
	 * (including the workspace path).
	 * @param path Path relative to the workspace
	 * @return absolute path
	 */
	protected static String getAbsolutePath(final String path) {
		return Paths.get(
				ResourcesPlugin.getWorkspace().getRoot().getLocation().toString(),
				path).toString();
	}

	/**
	 * Get the current working directory
	 */
	@Override
	public String getWorkingDir() {
		return ResourcesPlugin.getWorkspace().getRoot().getLocation().toString();
	}

	/**
	 * Clear (as in remove all files) from the target directory.
	 */
	@Override
	protected void clearTargetDirectory() {
		final File targetDir = Paths.get(getWorkingDir(), getOutputDir().toString()).toFile();
		for (File file : targetDir.listFiles()) {
			if (file.isFile()) {
				file.delete();
			}
		}
	}
}
