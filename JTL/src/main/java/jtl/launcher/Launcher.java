package jtl.launcher;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jtl.utils.Files;

public class Launcher {

	/** A map to keep the launch options status */
	public final static Map<String, Boolean> options = new HashMap<String, Boolean>();

	/** Command line option to keep .asp files */
	public static final String OPTION_GENERATE_ASP = "--asp";

	public static void main(final String[] args) {

		if (args.length < 5) {
			System.out.println(
					"Insufficient arguments:\n" +
					"Arguments:\n" +
			        "1. source metamodel\n" +
					"2. target metamodel\n" +
					"3. source model\n" +
					"4. target models folder\n" +
					"5. transformation (JTL or ASP)\n" +
					"6. traces model (optional)\n" +
					"Options:\n" +
					"--asp		generate .asp files of target and traces models"
			);
			return;
		}

		// Parse command line options
		List<String> argsList = Arrays.asList(args);
		options.put(OPTION_GENERATE_ASP, argsList.contains(OPTION_GENERATE_ASP));

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

		// Traces model
		File tracesFile = null;
		if (args.length == 6) {
			tracesFile = new File(args[5]);
		}

		// Dispatch execution to specific launchers:
		AbstractJTLLauncher launcher;
		if (Files.getFileExtension(transfFile).equals("dl")) {
			if (sourcemmFile.equals(targetmmFile)) {
				// ASP Endogenous transformation
				if (tracesFile == null) {
					launcher = new ASPEndogenousLauncher(
							sourcemmFile, sourcemFile, targetmFolder, transfFile);
				} else {
					launcher = new ASPEndogenousLauncher(
							sourcemmFile, sourcemFile, targetmFolder,
							transfFile, tracesFile);
				}
			} else {
				// ASP Exogenous transformation
				if (tracesFile == null) {
					launcher = new ASPExogenousLauncher(
							sourcemmFile, targetmmFile,	sourcemFile,
							targetmFolder, transfFile);
				} else {
					launcher = new ASPExogenousLauncher(
							sourcemmFile, targetmmFile,	sourcemFile,
							targetmFolder, transfFile, tracesFile);
				}
			}
		} else if (Files.getFileExtension(transfFile).equals("jtl")) {
			if (sourcemmFile.equals(targetmmFile)) {
				// Endogenous transformation
				if (tracesFile == null) {
					launcher = new JTLEndogenousLauncher(
							sourcemmFile, sourcemFile, targetmFolder, transfFile);
				} else {
					launcher = new JTLEndogenousLauncher(
							sourcemmFile, sourcemFile, targetmFolder,
							transfFile, tracesFile);
				}
			} else {
				// Exogenous transformation
				if (tracesFile == null) {
					launcher = new JTLExogenousLauncher(
							sourcemmFile, targetmmFile,	sourcemFile,
							targetmFolder, transfFile);
				} else {
					launcher = new JTLExogenousLauncher(
							sourcemmFile, targetmmFile,	sourcemFile,
							targetmFolder, transfFile, tracesFile);
				}
			}
		} else {
			System.err.println("Transformation file must have '.jtl' or '.dl' extension.");
			return;
		}

		// Launch
		launcher.launch();
	}

}
