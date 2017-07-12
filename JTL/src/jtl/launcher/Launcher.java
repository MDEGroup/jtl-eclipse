package jtl.launcher;

import java.io.File;

import jtl.utils.Files;

public class Launcher {

	public static void main(final String[] args) {

		if (args.length < 5) {
			System.out.println("Insufficient arguments:");
			System.out.println("Arguments:");
			System.out.println("1. source metamodel");
			System.out.println("2. target metamodel");
			System.out.println("3. source model");
			System.out.println("4. target models folder");
			System.out.println("5. transformation (JTL or ASP)");
			return;
		}

		// Source metamodel
		final File sourcemmFile = new File(args[0]);

		// Target metamodel
		final File targetmmFile = new File(args[1]);

		// Source model
		final File sourcemFile = new File(args[2]);

		// Target models folder
		final File targetmFolder = new File(args[3]);

		// Transformation
		final File transfFile = new File(args[4]);

		// Dispatch execution to specific launchers:
		AbstractJTLLauncher launcher;
		if (Files.getFileExtension(transfFile).equals("dl")) {
			if (sourcemmFile.equals(targetmmFile)) {
				// ASP Endogenous transformation
				launcher = new ASPEndogenousLauncher(
						sourcemmFile, sourcemFile, targetmFolder, transfFile);
			} else {
				// ASP Exogenous transformation
				launcher = new ASPExogenousLauncher(
						sourcemmFile, targetmmFile,	sourcemFile,
						targetmFolder, transfFile);
			}
		} else if (Files.getFileExtension(transfFile).equals("jtl")) {
			if (sourcemmFile.equals(targetmmFile)) {
				// Endogenous transformation
				launcher = new JTLEndogenousLauncher(
						sourcemmFile, sourcemFile, targetmFolder, transfFile);
			} else {
				// Exogenous transformation
				launcher = new JTLExogenousLauncher(
						sourcemmFile, targetmmFile,	sourcemFile,
						targetmFolder, transfFile);
			}
		} else {
			System.err.println("Transformation file must have '.jtl' or '.dl' extension.");
			return;
		}

		// Launch
		launcher.launch();
	}

}
