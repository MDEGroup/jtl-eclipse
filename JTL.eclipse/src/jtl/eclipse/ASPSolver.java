package jtl.eclipse;

import java.io.IOException;
import java.net.URL;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;

import jtl.solver.AbstractASPSolver;

public class ASPSolver extends AbstractASPSolver {

	/**
	 * Locate the solver executable
	 */
	@Override
	protected String getSolverPath(final String solverFile) {
		try {
			return FileLocator.resolve(new URL("platform:/plugin/JTL/" + solverFile)).getPath();
		} catch (IOException e) {
			System.err.println("Cannot locate file:" + solverFile);
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Get the current working directory
	 */
	@Override
	protected String getWorkingDir() {
		return ResourcesPlugin.getWorkspace()
				.getRoot().getLocation().toString();
	}

	@Override
	protected String getLibraryPath(final String libraryFile) {
		try {
			return FileLocator.resolve(new URL("platform:/plugin/JTL/" + libraryFile)).getPath();
		} catch (IOException e) {
			System.err.println("Cannot locate file:" + libraryFile);
			e.printStackTrace();
		}
		return null;
	}

}
