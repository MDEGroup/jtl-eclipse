package jtl.eclipse;

import java.io.File;

public class ASPExogenousTraceabilityLauncher extends jtl.launcher.ASPExogenousTraceabilityLauncher {

	public ASPExogenousTraceabilityLauncher(
			File leftmmFile,
			File rightmmFile,
			File leftmFile,
			File rightmFile,
			File transfFile,
			File traceFile) {
		super(leftmmFile, rightmmFile, leftmFile, rightmFile, transfFile, traceFile);
		launcher = new jtl.eclipse.ASPExogenousLauncher(
				leftmmFile, rightmmFile, leftmFile, rightmFile, transfFile);
	}

	/**
	 * Override the generateTransformation method just to
	 * replace the relative file path with the absolute one.
	 * @param targetmmName name of the target metamodel
	 */
	@Override
	protected void generateTransformation(final String targetmmName) {
		// Replace the relative file path with the absolute one
		final File transfFileRelative = launcher.getTransfFile();
		launcher.setTransfFile(new File(
				AbstractEclipseJTLLauncher.getAbsolutePath(transfFileRelative.getPath())));

		launcher.generateTransformation(targetmmName);

		// Restore the original path
		launcher.setTransfFile(transfFileRelative);
	}
}
