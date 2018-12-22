package jtl.solver;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import jtl.launcher.AbstractJTLLauncher;
import jtl.utils.Jar;
import jtl.utils.WhereAmI;

public class ASPSolver extends AbstractASPSolver {

	/**
	 * Constructor.
	 * @param launcher the launcher instance invoking this solver
	 */
	public ASPSolver(AbstractJTLLauncher launcher) {
		super(launcher);
	}

	/**
	 * Extract the solver executable from the jar.
	 * @param solverFile the path of the solver inside the jar
	 * @return path to the extracted file
	 */
	private String extractSolver(final String solverFile) {
		final String file = Jar.extractFile(solverFile, launcher.getWorkingDir());
		new File(file).setExecutable(true);
		return file;
	}

	/**
	 * Locate the solver executable
	 * @return solver path
	 */
	@Override
	protected String getSolverPath(final String solverFile) {
		if (WhereAmI.isJar()) {
			return extractSolver(new File(solverFile).getName());
		}
		return launcher.getWorkingDir() + File.separator + solverFile;
	}

	/**
	 * Locate additional libraries paths
	 * @param librariesConfig List of colon-separated paths to libraries
	 * @return libraries paths
	 */
	@Override
	protected List<String> getLibrariesPaths(final String librariesConfig) {
		final List<String> libraries = new ArrayList<String>();
		for (String path : librariesConfig.split(":")) {
			libraries.add((WhereAmI.isJar()) ?
					Jar.extractFile(new File(path).getName(), launcher.getWorkingDir()) :
					launcher.getWorkingDir() + File.separator + path
			);
		}
		return libraries;
	}
}
