package jtl.eclipse;

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
			final String sourcemmFile,
			final String sourcemFile,
			final String targetmFolder,
			final String transfFile) {
		super(sourcemmFile, sourcemFile, targetmFolder, transfFile);
	}
}
