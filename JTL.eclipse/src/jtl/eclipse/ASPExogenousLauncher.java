package jtl.eclipse;

import java.io.ByteArrayOutputStream;
import java.io.File;

import jtl.launcher.ASPLauncher;

public class ASPExogenousLauncher extends AbstractEclipseExogenousLauncher implements ASPLauncher {

	private jtl.launcher.ASPExogenousLauncher launcher;

	/**
	 * Create an instance of ASPExogenousLauncher.
	 * @param sourcemmFile source metamodel file
	 * @param targetmmFile target metamodel file
	 * @param sourcemFile source model file
	 * @param targetmFolder folder where to save generated target models
	 * @param transfFile file specifying the transformation
	 */
	public ASPExogenousLauncher(
			final File sourcemmFile,
			final File targetmmFile,
			final File sourcemFile,
			final File targetmFolder,
			final File transfFile) {
		super(sourcemmFile, targetmmFile, sourcemFile, targetmFolder, transfFile);
		launcher = new jtl.launcher.ASPExogenousLauncher(
				sourcemmFile, targetmmFile, sourcemFile, targetmFolder, transfFile);
		launcher.setASP(asp);
	}

	/**
	 * Create an instance of ASPExogenousLauncher.
	 * @param sourcemmFile source metamodel file
	 * @param targetmmFile target metamodel file
	 * @param sourcemFile source model file
	 * @param targetmFolder folder where to save generated target models
	 * @param transfFile file specifying the transformation
	 * @param tracesFile traces model file
	 */
	public ASPExogenousLauncher(
			final File sourcemmFile,
			final File targetmmFile,
			final File sourcemFile,
			final File targetmFolder,
			final File transfFile,
			final File tracesFile) {
		super(sourcemmFile, targetmmFile, sourcemFile, targetmFolder, transfFile, tracesFile);
		launcher = new jtl.launcher.ASPExogenousLauncher(
				sourcemmFile, targetmmFile, sourcemFile, targetmFolder, transfFile, tracesFile);
		launcher.setASP(asp);
	}

	/**
	 * Override the generateTransformation method to just
	 * append the transformation already in the .dl file.
	 * @param targetmmName name of the target metamodel
	 * @return filename of the final ASP program
	 */
	@Override
	protected void generateTransformation(final String targetmmName) {
		// Temporary replace the relative file path with the absolute one
		final File transfFileRelative = launcher.getTransfFile();
		launcher.setTransfFile(new File(getAbsolutePath(transfFileRelative.getPath())));

		launcher.generateTransformation(targetmmName);

		// Restore the original path
		launcher.setTransfFile(transfFileRelative);
	}

	@Override
	public String appendTransformation(
			final File ASPFile,
			final String targetmmName,
			final ByteArrayOutputStream asp) {
		return new ASPLauncher.ASPLauncherImpl()
				.appendTransformation(ASPFile, targetmmName, asp);
	}
}
