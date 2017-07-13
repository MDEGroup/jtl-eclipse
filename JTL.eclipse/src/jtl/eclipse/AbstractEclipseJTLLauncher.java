package jtl.eclipse;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;

import jtl.launcher.AbstractJTLLauncher;
import jtl.solver.AbstractASPSolver;

public abstract class AbstractEclipseJTLLauncher extends AbstractJTLLauncher {

	// List of bundles names to get version from
	protected final static String[] bundles = new String[] {
		"ASP.resource.asp",
		"ASP.resource.asp.ui",
		"ASPM.resource.aspm",
		"ASPM.resource.aspm.ui",
		"ASPMM.resource.aspmm",
		"ASPMM.resource.aspmm.ui",
		"JTL",
		"JTL.atl",
		"JTL.eclipse",
		"JTL.emftext.ASP",
		"JTL.emftext.ASPM",
		"JTL.emftext.ASPMM",
		"JTL.emftext.JTL",
		"JTL.resource.jtl",
		"JTL.resource.jtl.ui",
		"org.emftext.commons.antlr3_4_0"
	};

	/**
	 * Default constructor to be used by implementing classes.
	 * @param sourcemmFile source metamodel file
	 * @param targetmmFile target metamodel file
	 * @param sourcemFile source model file
	 * @param targetmFolder folder where to save generated target models
	 * @param transfFile file specifying the transformation
	 */
	public AbstractEclipseJTLLauncher(
			final File sourcemmFile,
			final File targetmmFile,
			final File sourcemFile,
			final File targetmFolder,
			final File transfFile) {
		super(sourcemmFile, targetmmFile, sourcemFile,
				targetmFolder, transfFile);
	}

	/**
	 * Default constructor to be used by implementing classes.
	 * @param sourcemmFile source metamodel file
	 * @param targetmmFile target metamodel file
	 * @param sourcemFile source model file
	 * @param targetmFolder folder where to save generated target models
	 * @param transfFile file specifying the transformation
	 * @param tracesFile traces model file
	 */
	public AbstractEclipseJTLLauncher(
			final File sourcemmFile,
			final File targetmmFile,
			final File sourcemFile,
			final File targetmFolder,
			final File transfFile,
			final File tracesFile) {
		super(sourcemmFile, targetmmFile, sourcemFile,
				targetmFolder, transfFile, tracesFile);
	}

	/**
	 * Return the solver implementation class.
	 * @return solver object
	 */
	@Override
	protected AbstractASPSolver getSolver() {
		return new ASPSolver();
	}

	/**
	 * Process the traces model.
	 */
	@Override
	protected void processTracesModel() {
		if (tracesFile == null) return;

		// Temporary replace the relative file path with the absolute one
		final File tracesFileRelative = tracesFile;
		tracesFile = new File(getAbsolutePath(tracesFile.getPath()));

		super.processTracesModel();

		// Restore the original path
		tracesFile = tracesFileRelative;
	}

	/**
	 * Compute MD5 of files involved in the launch
	 */
	@Override
	protected void computeMD5() {
		// Files involved in the launch
		final ArrayList<File> launchFilesList = new ArrayList<File>(Arrays.asList(
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
		transfFile = new File(getAbsolutePath(transfFile.getPath()));
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
	protected void removeFile(final File file) {
		new File(getAbsolutePath(file.getPath())).delete();
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
			System.out.println("An error occurred refreshing the workspace:");
			e.printStackTrace();
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
}
