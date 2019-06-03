package jtl.launcher;

import java.io.ByteArrayOutputStream;

public class ASPExogenousLauncher extends AbstractExogenousLauncher implements ASPLauncher {

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
	}

	/**
	 * Override the generateTransformation method to just
	 * append the transformation already in the .dl file.
	 * @param targetmmName name of the target metamodel
	 * @return filename of the final ASP program
	 */
	@Override
	public void generateTransformation(final String targetmmName) {
		// Keep the text from the '%%% TRANSFORMATION %%%' line on
		appendTransformation(transfFile, targetmmName, asp);
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
