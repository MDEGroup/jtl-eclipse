package jtl.solver;

import java.io.File;

import jtl.utils.Jar;
import jtl.utils.WhereAmI;

public class ASPSolver extends AbstractASPSolver {

	/**
	 * Extract the solver executable from the jar.
	 * @param solverFile the path of the solver inside the jar
	 * @return path to the extracted file
	 */
	private String extractSolver(final String solverFile) {
		final String file = Jar.extractFile(solverFile, getWorkingDir());
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
		return getWorkingDir() + File.separator + solverFile;
	}

	/**
	 * Locate the library path
	 * @return library path
	 */
	@Override
	protected String getLibraryPath(final String libraryFile) {
		if (WhereAmI.isJar()) {
			return Jar.extractFile(new File(libraryFile).getName(), getWorkingDir());
		}
		return getWorkingDir() + File.separator + libraryFile;
	}

	/**
	 * Get the current working directory
	 */
	@Override
	protected String getWorkingDir() {
		return System.getProperty("user.dir");
	}
}
