package jtl.launcher;

import java.io.ByteArrayOutputStream;
import java.io.File;

public class ASPEndogenousLauncher extends AbstractEndogenousLauncher implements ASPLauncher {

	/**
	 * Create an instance of ASPEndogenousLauncher.
	 * @param sourcemmFile source metamodel file
	 * @param targetmmFile target metamodel file
	 * @param sourcemFile source model file
	 * @param targetmFolder folder where to save generated target models
	 * @param transfFile file specifying the transformation
	 */
	public ASPEndogenousLauncher(
			final File sourcemmFile,
			final File sourcemFile,
			final File targetmFolder,
			final File transfFile) {
		super(sourcemmFile, sourcemFile, targetmFolder, transfFile);
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
		appendTransformation(transfFile, targetmmName + "_target", asp);
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
