package jtl.launcher;

import java.io.File;

public class JTLExogenousLauncher extends AbstractExogenousLauncher {

	/**
	 * Create an instance of JTLExogenousLauncher.
	 * @param sourcemmFile source metamodel file
	 * @param targetmmFile target metamodel file
	 * @param sourcemFile source model file
	 * @param targetmFolder folder where to save generated target models
	 * @param transfFile file specifying the transformation
	 */
	public JTLExogenousLauncher(
			final File sourcemmFile,
			final File targetmmFile,
			final File sourcemFile,
			final File targetmFolder,
			final File transfFile) {
		super(sourcemmFile, targetmmFile, sourcemFile, targetmFolder, transfFile);
	}
}
