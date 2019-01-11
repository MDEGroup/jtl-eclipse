package jtl.eclipse;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.core.runtime.FileLocator;

import jtl.launcher.AbstractJTLLauncher;
import jtl.solver.AbstractASPSolver;

public class ASPSolver extends AbstractASPSolver {

	/** Logger */
	private static Logger logger = LogManager.getLogger(ASPSolver.class);

	/**
	 * Constructor.
	 * @param launcher the launcher instance invoking this solver
	 */
	public ASPSolver(AbstractJTLLauncher launcher) {
		super(launcher);
	}

	/**
	 * Locate the solver executable
	 * @return solver path
	 */
	@Override
	protected String getSolverPath(final String solverFile) {
		try {
			return FileLocator.resolve(new URL("platform:/plugin/JTL/" + solverFile)).getPath();
		} catch (IOException e) {
			logger.error("Cannot locate file:" + solverFile, e);
		}
		return null;
	}

	/**
	 * Locate additional libraries paths
	 * @param librariesConfig List of colon-separated paths to libraries
	 * @return libraries paths
	 */
	@Override
	protected List<String> getLibrariesPaths(final String librariesConfig) {
		final List<String> libraries = new ArrayList<String>();
		if (librariesConfig != null) {
			for (String path : librariesConfig.split(":")) {
				try {
					libraries.add(FileLocator.resolve(new URL("platform:/plugin/JTL/" + path)).getPath());
				} catch (IOException e) {
					logger.error("Cannot locate file:" + path, e);
				}
			}
		}
		return libraries;
	}

}
