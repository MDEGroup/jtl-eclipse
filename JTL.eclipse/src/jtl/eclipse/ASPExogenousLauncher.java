package jtl.eclipse;

import java.io.ByteArrayOutputStream;

import jtl.launcher.ASPLauncher;

public class ASPExogenousLauncher extends AbstractEclipseExogenousLauncher implements ASPLauncher {

	private jtl.launcher.ASPExogenousLauncher launcher;

	/**
	 * Create an instance of ASPExogenousLauncher.
	 * @param leftmmFile source metamodel file
	 * @param rightmmFile target metamodel file
	 * @param leftmFile source model file
	 * @param rightmFile folder where to save generated target models
	 * @param transfFile file specifying the transformation
	 */
	public ASPExogenousLauncher(
			final String leftmmFile,
			final String rightmmFile,
			final String leftmFile,
			final String rightmFile,
			final String transfFile) {
		super(leftmmFile, rightmmFile, leftmFile, rightmFile, transfFile);
		launcher = new jtl.launcher.ASPExogenousLauncher(
				leftmmFile, rightmmFile, leftmFile, rightmFile, transfFile);
		launcher.setASP(asp);
	}

	/**
	 * Override the generateTransformation method to just
	 * append the transformation already in the .dl file.
	 * @param targetmmName name of the target metamodel
	 * @return filename of the final ASP program
	 */
	@Override
	public void generateTransformation(final String targetmmName) {
		// Temporary replace the relative file path with the absolute one
		final String transfFileRelative = launcher.getTransfFile();
		launcher.setTransfFile(getAbsolutePath(transfFileRelative));

		launcher.generateTransformation(targetmmName);

		// Restore the original path
		launcher.setTransfFile(transfFileRelative);
	}

	@Override
	public String appendTransformation(
			final String ASPFile,
			final String targetmmName,
			final ByteArrayOutputStream asp) {
		return new ASPLauncher.ASPLauncherImpl()
				.appendTransformation(ASPFile, targetmmName, asp);
	}
}
