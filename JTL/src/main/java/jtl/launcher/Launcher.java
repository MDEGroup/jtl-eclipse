package jtl.launcher;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jtl.utils.Files;

public class Launcher {

	/** Logger */
	private static Logger logger = LogManager.getLogger(AbstractJTLLauncher.class);

	/** JTL launcher */
	private AbstractJTLLauncher launcher;

	/** A map to keep the launch options status */
	public final static Map<String, Boolean> options = new HashMap<String, Boolean>();

	/** Command line option to provide a trace model */
	public static final String OPTION_TRACE = "--trace";

	/** Command line option to provide additional constraints */
	public static final String OPTION_CONSTRAINTS = "--constraints";

	/** Command line option to keep .asp files */
	public static final String OPTION_GENERATE_ASP = "--asp";

	/** Command line option to clear the target directory before the launch */
	public static final String OPTION_CLEAR_TARGET = "--clear-target";

	public void launch(
			final File sourcemmFile,
			final File targetmmFile,
			final File sourcemFile,
			final File targetmFolder,
			final File transfFile,
			final File tracesFile,
			final List<File> constraintsFile) {

		// Dispatch execution to specific launchers
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
			logger.error("Transformation file must have '.jtl' or '.dl' extension.");
			return;
		}

		// Traces model
		launcher.setTracesFile(tracesFile);

		// Additional constraints
		launcher.setConstraintsFile(constraintsFile);

		// Launch
		launcher.launch();
	}

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
					"Options:\n" +
					"--trace			trace model" +
					"--constraints		file containing additional constraints" +
					"--asp				generate .asp files of target and traces models\n" +
					"--clear-target		clear the target directory before the launch"
			);
			return;
		}

		// Parse command line options
		List<String> argsList = Arrays.asList(args);
		options.put(OPTION_GENERATE_ASP, argsList.contains(OPTION_GENERATE_ASP));
		options.put(OPTION_CLEAR_TARGET, argsList.contains(OPTION_CLEAR_TARGET));

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
		if (argsList.contains(OPTION_TRACE)) {
			tracesFile = new File(argsList.get(argsList.indexOf(OPTION_TRACE) + 1));
		}

		// Additional constraints
		List<File> constraintsFiles = null;
		if (argsList.contains(OPTION_CONSTRAINTS)) {
			constraintsFiles = new ArrayList<File>();
			for (int i = 0; i < argsList.size(); i++) {
				if (argsList.get(i).equals(OPTION_CONSTRAINTS)) {
					constraintsFiles.add(new File(argsList.get(i + 1)));
					i++;
				}
			}
		}

		// Launch
		new Launcher().launch(sourcemmFile, targetmmFile,	sourcemFile,
				targetmFolder, transfFile, tracesFile, constraintsFiles);
	}
}
