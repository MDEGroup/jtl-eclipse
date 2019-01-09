package jtl.eclipse;

import java.io.File;

public class JTLEndogenousLauncher extends AbstractEclipseEndogenousLauncher {

	/**
	 * Create an instance of JTLEndogenousLauncher.
	 * @param sourcemmFile source metamodel file
	 * @param targetmmFile target metamodel file
	 * @param sourcemFile source model file
	 * @param targetmFolder folder where to save generated target models
	 * @param transfFile file specifying the transformation, tracesFile
	 */
	public JTLEndogenousLauncher(
			final File sourcemmFile,
			final File sourcemFile,
			final File targetmFolder,
			final File transfFile) {
		super(sourcemmFile, sourcemFile, targetmFolder, transfFile);
	}
}
