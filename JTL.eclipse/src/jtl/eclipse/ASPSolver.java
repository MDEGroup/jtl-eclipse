package jtl.eclipse;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;

import jtl.solver.AbstractASPSolver;

public class ASPSolver extends AbstractASPSolver {

	/**
	 * Locate the solver executable
	 */
	@Override
	protected String getSolverPath(final String solverFile)
			throws MalformedURLException, IOException {
		return FileLocator.resolve(new URL(solverFile)).getPath();
	}

	/**
	 * Get the current working directory
	 */
	@Override
	protected String getWorkingDir() {
		return ResourcesPlugin.getWorkspace()
				.getRoot().getLocation().toString();
	}

}
