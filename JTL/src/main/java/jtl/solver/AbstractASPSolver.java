package jtl.solver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

import jaspwrapper.analyzer.OutputAnalyzerFactory;
import jaspwrapper.exception.JASPException;
import jaspwrapper.exec.EngineRunner;
import jaspwrapper.exec.Program;
import jaspwrapper.exec.Solver;
import jaspwrapper.items.Atom;
import jaspwrapper.items.Model;
import jtl.utils.WhereAmI;

public abstract class AbstractASPSolver {

	// Configuration file
	private final static String config = "config.properties";

	// Path to the solver executable
	private String solverPath;

	// Path to the solver library
	private String libraryPath;

	// OS type for jaspwrapper
	private String osType;

	/**
	 * Locate the solver executable
	 * @return solver path
	 */
	protected abstract String getSolverPath(String solverFile);

	/**
	 * Locate the library path
	 * @return library path
	 */
	protected abstract String getLibraryPath(String libraryFile);

	/*
	 * Get the current working directory
	 */
	protected abstract String getWorkingDir();

	/**
	 * Load configurations from file.
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	private void loadConfig() throws IOException, URISyntaxException {
		Properties prop = new Properties();
		InputStream in = AbstractASPSolver.class.getClassLoader().getResourceAsStream(config);
		prop.load(in);
		String os = System.getProperty("os.name").toLowerCase();
		String osprop = "";
		if (os.contains("linux")) {
			osprop = "linux";
			this.osType = "unix";
		} else if (os.contains("mac")) {
			osprop = "macos";
			this.osType = "unix";
		} else if (os.contains("win")) {
			osprop = "windows";
			this.osType = "windows";
		}
		this.solverPath = getSolverPath(prop.getProperty("solver_" + osprop));

		// On linux and mac we need an additional library
		if (this.osType.equals("unix")) {
			this.libraryPath = getLibraryPath(prop.getProperty("solver_library"));
		}
	}

	/**
	 * Execute an ASP file using the solver.
	 * @param aspFile ASP file
	 * @param target Folder where generated models are created
	 * @throws JASPException
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public ArrayList<String> run(final File aspFile, File target, File sourcem)
			throws JASPException, IOException, URISyntaxException {

		// Get the working directory
		final String wd = getWorkingDir();

		// Get the target output directory
		final Path outputDir = getOutputDir(target);

		// If the user provided a target file name
		// set it as the base model file name and
		// remove the file extension
		final String basename = jtl.utils.Files.removeFileExtension(
				(target.getPath().endsWith(".xmi")) ? target.getName() : sourcem.getName());

		// Load the solver configuration
		loadConfig();

		// Load the ASP program from file
		Program program = new Program();
		program.addFromFile(aspFile.getAbsolutePath());

		// On unix white spaces in filenames need to be escaped when
		// used as argument in a shell (/bin/sh) command.
		if (this.osType.equals("unix")) {
			ArrayList<String> inputFiles = new ArrayList<String>();
			inputFiles.add(aspFile.getAbsolutePath().replaceAll(" ", "\\\\ "));
			try {
				Field inputFilesField = Program.class.getDeclaredField("inputFiles");
				inputFilesField.setAccessible(true);
				inputFilesField.set(program, inputFiles);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// And a required library must be included
			// extending the library path
			this.solverPath = "LD_LIBRARY_PATH=" +
					this.libraryPath.substring(0, this.libraryPath.lastIndexOf('/')) +
					" " + this.solverPath;
		}

		// On windows FileLocator does not escape spaces
		// nor produces a valid path
		if (this.osType.equals("windows") &&
			this.solverPath.charAt(0) == '/') {
			// Remove a leading slash
			this.solverPath = this.solverPath.substring(1);

			// Surround the path with double quotes
			this.solverPath = "\"" + this.solverPath + "\"";

			// Surround the program file with double quotes
			ArrayList<String> inputFiles = new ArrayList<String>();
			inputFiles.add("\"" + aspFile.getAbsolutePath() + "\"");
			try {
				Field inputFilesField = Program.class.getDeclaredField("inputFiles");
				inputFilesField.setAccessible(true);
				inputFilesField.set(program, inputFiles);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// Close the program
		program.end();

		// Setup the solver
		Solver solver = new Solver(solverPath);

		// Setup the engine
		EngineRunner engine = new EngineRunner(solver);
		engine.setOS(this.osType);
		engine.setSolverType(OutputAnalyzerFactory.DLV);
		engine.loadProgram(program);
		engine.compute();

		// Store formatted atoms for reprint
		Map<String, String> atoms = new LinkedHashMap<String, String>();
		initializeAtoms(atoms);

		// Process results
		boolean emptyModel = true;
		boolean emptyTraceModel = true;
		ArrayList<String> modelsFiles = new ArrayList<String>();
		for (int c = 0; engine.hasMoreModel(); c++) {
			Path modelPath = Paths.get(outputDir.toString(), basename + ((c>0) ? c : "") + ".aspm");
			Path traceModelPath = Paths.get(outputDir.toString(), basename + ((c>0) ? c : "") + "_trace.aspt");
			Model model = engine.nextModel();
			emptyModel = true;
			emptyTraceModel = true;
			for (Iterator<Atom> i = model.iterator(); i.hasNext();) {
				Atom atom = i.next();
				final String atomName = atom.getName();

				// Only print selected elements
				if (atoms.containsKey(atomName)) {

					// Wait until the first atom in the target model to
					// get the name of the target metamodel to use in model(_, _).
					if (emptyModel && !atomName.startsWith("trace_")) {
						atoms.put("nodex", atoms.get("nodex") +
								String.format("model(\"%s%d\", %s).%n", basename, c,
								atom.getArguments().get(0).toString()
								.replaceFirst("x_(\\w+)_target", "x_$1")));
						emptyModel = false;
					}

					// Wait until the first trace atom
					// to set the trace model not empty
					if (emptyTraceModel && atomName.startsWith("trace_")) {
						atoms.put("trace_nodex", atoms.get("trace_nodex") +
								String.format("trace_model(\"%s%d\", %s).%n", basename, c,
								atom.getArguments().get(0).toString()
								.replaceFirst("x_(\\w+)_target", "x_$1")));
						emptyTraceModel = false;
					}

					// Atoms are stored for later to ensure print order
					atoms.put(atomName, atoms.get(atomName) + formatAtom(atom));
				}
			}

			// Avoid writing empty models files
			if (!emptyModel) {

				// Add the processed model to the list of model files
				modelsFiles.add(modelPath.toString());

				// Open the model file for writing
				try (BufferedWriter writer = Files.newBufferedWriter(
						getAbsolutePath(modelPath, wd))) {
					// Print atoms of the target model
					for (Map.Entry<String, String> atomSet : atoms.entrySet()) {
						if (!atomSet.getKey().startsWith("trace_")) {
							writer.write(atomSet.getValue());
						}
					}
				}
			}

			// Avoid writing empty trace model files
			if (!emptyTraceModel) {

				// Add the trace file to the list of generated files
				modelsFiles.add(traceModelPath.toString());

				// Open the trace file for writing
				try (BufferedWriter writer = Files.newBufferedWriter(
						getAbsolutePath(traceModelPath, wd))) {
					// Print atoms of the trace model
					for (Map.Entry<String, String> atomSet : atoms.entrySet()) {
						if (atomSet.getKey().startsWith("trace_")) {
							writer.write(atomSet.getValue());
						}
					}
				}
			}

			// Reset the list of atoms
			initializeAtoms(atoms);
		}
		return modelsFiles;
	}

	/**
	 * Format an ASP atom for reprint.
	 * @param atom Atom to format
	 * @return formatted string
	 */
	private String formatAtom(final Atom atom) {
			return String.format("%s.%n", atom.toString()
					.replaceFirst("x\\(", "(")
					.replaceFirst("x_(\\w+)_target", "x_$1"));
	}

	/**
	 * Initialize the atoms list.
	 * @param atoms The list of atoms
	 */
	private void initializeAtoms(final Map<String, String> atoms) {
		atoms.put("nodex", "");
		atoms.put("propx", "");
		atoms.put("edgex", "");
		atoms.put("trace_nodex", "");
		atoms.put("trace_nb_nodex", "");
		atoms.put("trace_propx", "");
		atoms.put("trace_nb_propx", "");
		atoms.put("trace_edgex", "");
		atoms.put("trace_nb_edgex", "");
		atoms.put("trace_linkx", "");
	}

	/**
	 * Get the directory that will be used to store target models.
	 * @param target Folder where generated models are created
	 * @return target models directory
	 */
	private Path getOutputDir(final File target) {

		String wd = getWorkingDir();

		// If we have an absolute path inside Eclipse, prepend the workspace
		// If we have an absolute path outside Eclipse, return it as it is
		final Path targetPath = (target.isAbsolute() == WhereAmI.isEclipse()) ?
				Paths.get(getWorkingDir(), target.getPath()) : target.toPath();

		if (WhereAmI.isOSGI()) {
			final Path fullPath = Paths.get(wd, target.toString());
			if (Files.isDirectory(fullPath) && Files.isWritable(fullPath)) {
				return target.toPath();
			} else if (target.getPath().endsWith(".xmi")) {
				return getOutputDir(target.getParentFile());
			}
		} else if (target.isAbsolute()) {
			if (Files.isDirectory(target.toPath())) {
				return target.toPath();
			} else {
				return target.getParentFile().toPath();
			}
		}

		System.err.println(targetPath + " not a valid file or directory.");
		return null;
	}

	/**
	 * Build an absolute pathname that will work inside and outside Eclipse.
	 * @param path
	 * @param working directory
	 * @return target model absolute pathname
	 */
	private Path getAbsolutePath(final Path path, final String wd) {
		return (Files.isDirectory(path.getParent())) ? path : Paths.get(wd, path.toString());
	}
}
