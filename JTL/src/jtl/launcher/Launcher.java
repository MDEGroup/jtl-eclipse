package jtl.launcher;

import java.io.File;

public class Launcher {

	private static String getFileExtension(final File file) {
		if (file.isDirectory()) {
			return "";
		}
		final String name = file.getName();
		return name.substring(name.lastIndexOf('.') + 1);
	}

	public static void main(String[] args) {

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
		File sourcemmFile = new File(args[0]);

		// Target metamodel
		File targetmmFile = new File(args[1]);

		// Source model
		File sourcemFile = new File(args[2]);

		// Target models folder
		File targetmFolder = new File(args[3]);

		// Transformation
		File transfFile = new File(args[4]);

		// Dispatch execution to specific launchers:
		AbstractJTLLauncher launcher;
		if (getFileExtension(transfFile).equals("dl")) {
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
		} else if (getFileExtension(transfFile).equals("jtl")) {
			if (sourcemmFile.equals(targetmmFile)) {
				// Endogenous transformation
				//launcher = new JTLEndogenousLauncher();
				launcher = null;
			} else {
				// Exogenous transformation
				//launcher = new JTLExogenousLauncher();
				launcher = null;
			}
		} else {
			System.err.println("Transformation file must have '.jtl' or '.dl' extension.");
			return;
		}

		// Launch
		launcher.launch();
	}

}
