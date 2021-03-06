package jtl.eclipse;

public class JTLExogenousLauncher extends AbstractEclipseExogenousLauncher {

	/**
	 * Create an instance of JTLExogenousLauncher.
	 * @param sourcemmFile source metamodel file
	 * @param targetmmFile target metamodel file
	 * @param sourcemFile source model file
	 * @param targetmFolder folder where to save generated target models
	 * @param transfFile file specifying the transformation
	 */
	public JTLExogenousLauncher(
			final String sourcemmFile,
			final String targetmmFile,
			final String sourcemFile,
			final String targetmFolder,
			final String transfFile) {
		super(sourcemmFile, targetmmFile, sourcemFile, targetmFolder, transfFile);
	}
}
