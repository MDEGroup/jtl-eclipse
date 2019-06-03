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
import java.util.List;
import java.util.Map;
import java.util.Properties;

import jaspwrapper.analyzer.OutputAnalyzerFactory;
import jaspwrapper.exception.JASPException;
import jaspwrapper.exec.EngineRunner;
import jaspwrapper.exec.Program;
import jaspwrapper.exec.Solver;
import jaspwrapper.items.Atom;
import jaspwrapper.items.Model;
import jtl.launcher.AbstractJTLLauncher;

public abstract class AbstractASPSolver {

	// Configuration file
	private final static String config = "config.properties";

	// Launcher instance invoking this solver
	protected AbstractJTLLauncher launcher;

	// Path to the solver executable
	private String solverPath;

	// Paths to the solver libraries
	private List<String> librariesPaths;

	// OS type for jaspwrapper
	private String osType;

	// Current working directory
	private String workingDir;

	// Output directory
	private Path outputDir;

	// Output model basename
	private String outputBasename;

	/**
	 * Constructor.
	 *
	 * @param launcher
	 *            the launcher instance invoking this solver
	 */
	public AbstractASPSolver(AbstractJTLLauncher launcher) {
		this.launcher = launcher;
	}

	/**
	 * Locate the solver executable
	 *
	 * @return solver path
	 */
	protected abstract String getSolverPath(String solverFile);

	/**
	 * Locate additional libraries paths
	 *
	 * @param librariesConfig
	 *            List of colon-separated paths to libraries
	 * @return libraries paths
	 */
	protected abstract List<String> getLibrariesPaths(String libraryFile);

	/**
	 * Load configurations from file.
	 *
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

		// Load additional libraries
		this.librariesPaths = getLibrariesPaths(prop.getProperty("solver_library_" + osprop));
	}

	/**
	 * Setup the solver engine
	 * @param aspFile ASP file
	 * @param target Folder where generated models are created
	 * @param sourcem source model file
	 * @return the solver engine
	 * @throws IOException
	 * @throws URISyntaxException
	 * @throws JASPException
	 */
	private EngineRunner solverSetup(final String aspFile, final String target, final String sourcem)
			throws IOException, URISyntaxException, JASPException {
		// Get the working directory
		workingDir = launcher.getWorkingDir();

		// Get the target output directory
		outputDir = launcher.getOutputDir();

		// If the user provided a target file name
		// set it as the base model file name and
		// remove the file extension
		outputBasename = jtl.utils.Files
				.removeFileExtension((target.endsWith(".xmi")) ?
						Paths.get(target).getFileName().toString() :
						Paths.get(sourcem).getFileName().toString());

		// Load the solver configuration
		loadConfig();

		// Load the ASP program from file
		Program program = new Program();
		final File aspProgramFile = new File(aspFile);
		program.addFromFile(aspProgramFile.getAbsolutePath());

		// On unix white spaces in filenames need to be escaped when
		// used as argument in a shell (/bin/sh) command.
		if (this.osType.equals("unix")) {
			ArrayList<String> inputFiles = new ArrayList<String>();
			inputFiles.add(aspProgramFile.getAbsolutePath().replaceAll(" ", "\\\\ "));
			try {
				Field inputFilesField = Program.class.getDeclaredField("inputFiles");
				inputFilesField.setAccessible(true);
				inputFilesField.set(program, inputFiles);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// And a required library must be included
			// extending the library path
			if (librariesPaths.size() > 0) {
				this.solverPath = "LD_LIBRARY_PATH="
						+ this.librariesPaths.get(0).substring(0, this.librariesPaths.get(0).lastIndexOf('/')) + " "
						+ this.solverPath;
			}
		}

		// On windows FileLocator does not escape spaces
		// nor produces a valid path
		if (this.osType.equals("windows") && this.solverPath.charAt(0) == '/') {
			// Remove a leading slash
			this.solverPath = this.solverPath.substring(1);

			// Surround the path with double quotes
			this.solverPath = "\"" + this.solverPath + "\"";

			// Surround the program file with double quotes
			ArrayList<String> inputFiles = new ArrayList<String>();
			inputFiles.add("\"" + aspProgramFile.getAbsolutePath() + "\"");
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

		return engine;
	}

	/**
	 * Execute an ASP file using the solver.
	 *
	 * @param aspFile ASP file
	 * @param target Folder where generated models are created
	 * @param sourcem source model file
	 * @throws JASPException
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public ArrayList<String> run(final String aspFile, String target, String sourcem)
			throws JASPException, IOException, URISyntaxException {

		// Setup the solver
		final EngineRunner engine = solverSetup(aspFile, target, sourcem);

		// Store formatted atoms for reprint
		Map<String, String> atoms = new LinkedHashMap<String, String>();
		initializeAtoms(atoms);

		// Process results
		boolean emptyModel = true;
		boolean emptyTraceModel = true;
		ArrayList<String> modelsFiles = new ArrayList<String>();
		for (int c = 0; engine.hasMoreModel(); c++) {
			Path modelPath = Paths.get(outputDir.toString(), outputBasename + ((c > 0) ? c : "") + ".aspm");
			Path traceModelPath = Paths.get(outputDir.toString(), outputBasename + ((c > 0) ? c : "") + "_trace.aspt");
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
						atoms.put("nodex", atoms.get("nodex") + String.format("model(\"%s%d\", %s).%n", outputBasename, c,
								atom.getArguments().get(0).toString().replaceFirst("x_(\\w+)_target", "x_$1")));
						emptyModel = false;
					}

					// Wait until the first trace atom
					// to set the trace model not empty
					if (emptyTraceModel && atomName.startsWith("trace_")) {
						atoms.put("trace_nodex",
								atoms.get("trace_nodex") + String.format("trace_model(\"%s%d\", %s).%n", outputBasename, c,
										atom.getArguments().get(0).toString().replaceFirst("x_(\\w+)_target", "x_$1")));
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
				try (BufferedWriter writer = Files.newBufferedWriter(getAbsolutePath(modelPath.toString(), workingDir))) {
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
				try (BufferedWriter writer = Files.newBufferedWriter(getAbsolutePath(traceModelPath.toString(), workingDir))) {
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
	 * Execute an ASP file using the solver to generate a trace model.
	 *
	 * @param string ASP file
	 * @param traceFile Folder where generated models are created
	 * @param trasformation File containing the correspondences specification
	 * @throws JASPException
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public String runTraceability(final String string, String traceFile)
			throws JASPException, IOException, URISyntaxException {
		// Setup the solver
		final EngineRunner engine = solverSetup(string, traceFile, string);

		if (!engine.hasMoreModel()) {
			throw new JASPException("The solver returned zero models.");
		}

		// Trace model output file
		if (traceFile.endsWith(".xmi")) {
			traceFile = jtl.utils.Files.addFileExtension(
					jtl.utils.Files.removeFileExtension(traceFile.toString()), "aspt");
		} else {
			// TODO Implement the directory case
			throw new IOException("The output trace model must be an .xmi file.");
		}

		// Store formatted atoms for reprint
		Map<String, String> atoms = new LinkedHashMap<String, String>();
		initializeTraceabilityAtoms(atoms);

		// Process results
		boolean emptyTraceModel = true;
		final Model model = engine.nextModel();
		for (Iterator<Atom> i = model.iterator(); i.hasNext();) {
			Atom atom = i.next();
			final String atomName = atom.getName();

			if (emptyTraceModel) {
				atoms.put("trace_nodex", String.format("trace_model(\"%s\", %s).%n", outputBasename,
						atom.getArguments().get(0).toString().replaceFirst("x_(\\w+)_target", "x_$1")));
				emptyTraceModel = false;
			}

			// Only print selected elements
			if (atoms.containsKey(atomName)) {
				// Atoms are stored for later to ensure print order
				atoms.put(atomName, atoms.get(atomName) + formatAtom(atom));
			}
		}

		// Avoid writing empty trace model files
		if (!emptyTraceModel) {

			// Open the trace file for writing
			try (BufferedWriter writer = Files.newBufferedWriter(getAbsolutePath(traceFile, workingDir))) {
				// Print atoms of the trace model
				for (Map.Entry<String, String> atomSet : atoms.entrySet()) {
					writer.write(atomSet.getValue());
				}
			}
		}

		if (engine.hasMoreModel()) {
			throw new JASPException("Only one model expected as output. Got " + engine.getNumberModels());
		}

		return traceFile;
	}

	/**
	 * Format an ASP atom for reprint.
	 *
	 * @param atom Atom to format
	 * @return formatted string
	 */
	private String formatAtom(final Atom atom) {
		return String.format("%s.%n",
				atom.toString().replaceFirst("x\\(", "(").replaceFirst("x_(\\w+)_target", "x_$1"));
	}

	/**
	 * Initialize the atoms list.
	 *
	 * @param atoms The list of atoms
	 */
	private void initializeAtoms(final Map<String, String> atoms) {
		atoms.put("nodex", "");
		atoms.put("propx", "");
		atoms.put("edgex", "");
		initializeTraceabilityAtoms(atoms);
	}

	/**
	 * Initialize the traceability atoms list.
	 *
	 * @param atoms The list of atoms for traceability
	 */
	private void initializeTraceabilityAtoms(final Map<String, String> atoms) {
		atoms.put("trace_nodex", "");
		atoms.put("trace_nb_nodex", "");
		atoms.put("trace_propx", "");
		atoms.put("trace_nb_propx", "");
		atoms.put("trace_edgex", "");
		atoms.put("trace_nb_edgex", "");
		atoms.put("trace_linkx", "");
	}

	/**
	 * Build an absolute pathname that will work inside and outside Eclipse.
	 *
	 * @param path
	 * @param working directory
	 * @return target model absolute pathname
	 */
	private Path getAbsolutePath(final String path, final String wd) {
		// FIXME we probably don't need this method anymore
		final Path target = Paths.get(path);
		return (Files.isDirectory(target.getParent()) ? target : Paths.get(wd, path));
	}
}
