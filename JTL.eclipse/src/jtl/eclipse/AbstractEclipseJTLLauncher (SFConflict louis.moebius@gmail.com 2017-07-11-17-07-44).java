package jtl.eclipse;

import java.io.File;
import java.nio.file.Paths;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
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
	 * Return the solver implementation class.
	 * @return solver object
	 */
	@Override
	protected AbstractASPSolver getSolver() {
		return new ASPSolver();
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
	 * Generate the ASP transformation from the JTL source code.
	 * @param targetmmName name of the target metamodel
	 * @return filename of the final ASP program
	 */
//	@Override
//	protected void generateTransformation(final String targetmmName) {
//		// Check for paths relative to the Eclipse working directory
//		final File transfFileRelative = transfFile;
//		if (!transfFile.exists()) {
//			transfFile = Paths.get(
//					ResourcesPlugin.getWorkspace().getRoot().getLocation().toString(),
//					transfFile.getPath().toString()).toFile();
//		}
//
//		super.generateTransformation(targetmmName);
//
//		// Restore the original File
//		transfFile = transfFileRelative;
//	}

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
	protected static void removeFile(final IFile file) {
		try {
			file.delete(true, new NullProgressMonitor());
		} catch (CoreException e) {
			System.out.println("There was a problem deleting the file: " +
					file.getFullPath().toString());
			e.printStackTrace();
		}
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
}
