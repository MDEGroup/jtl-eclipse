package jtl.solver;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;

import jaspwrapper.analyzer.OutputAnalyzerFactory;
import jaspwrapper.exception.JASPException;
import jaspwrapper.exec.EngineRunner;
import jaspwrapper.exec.Program;
import jaspwrapper.exec.Solver;
import jaspwrapper.items.Atom;
import jaspwrapper.items.Model;

public class ASPSolver {
	
	// Configuration file
	private final static String config = "resources/config.properties";
	
	// Path to the solver executable
	private String solverPath;
	
	// OS type for jaspwrapper
	private String osType;
	
	/**
	 * Load configurations from file.
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	private void loadConfig() throws IOException, URISyntaxException {
		Properties prop = new Properties();
		InputStream in = getClass().getClassLoader().getResourceAsStream(config);
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
		
		this.solverPath = FileLocator.resolve(
				new URL(prop.getProperty("solver_" + osprop))).getPath();
	}
	
	/**
	 * Execute an ASP file using the solver.
	 * @param file ASP file
	 * @param target Folder where generated models are created
	 * @throws JASPException
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public ArrayList<String> run(final String file, final String target)
			throws JASPException, IOException, URISyntaxException {
		
		// Get the workspace full path
		String wsPath = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString();
		
		// Check if the target folder exists
		if (!Files.isDirectory(Paths.get(wsPath, target))) {
			System.err.println(wsPath + target + " not a directory.");
			return null;
		}
		
		// Load the solver configuration
		loadConfig();

		// Load the ASP program from file
		Program program = new Program();
		program.addFromFile(file);
		
		// On unix white spaces in filenames need to be escaped when
		// used as argument in a shell (/bin/sh) command.
		if (this.osType.equals("unix")) {
			ArrayList<String> inputFiles = new ArrayList<String>();
			inputFiles.add(file.replaceAll(" ", "\\\\ "));
			try {
				Field inputFilesField = Program.class.getDeclaredField("inputFiles");
				inputFilesField.setAccessible(true);
				inputFilesField.set(program, inputFiles);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// On windows FileLocator does not escape spaces
		// nor produces a valid path
		if (this.osType.equals("windows")) {
			// Remove a leading slash
			this.solverPath = this.solverPath.substring(1);
			
			// Surround the path with double quotes
			this.solverPath = "\"" + this.solverPath + "\"";
			
			// Surround the program file with double quotes
			ArrayList<String> inputFiles = new ArrayList<String>();
			inputFiles.add("\"" + file + "\"");
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
		
		// Process results
		Set<String> targets = new HashSet<String>();
		targets.add("nodex");
		targets.add("propx");
		targets.add("edgex");
		boolean newModel = true;
		String props = "";
		String edges = "";
		ArrayList<String> modelsFiles = new ArrayList<String>();
		for (int c = 1; engine.hasMoreModel(); c++) {
			Path modelPath = Paths.get(wsPath, target, "m" + c + ".aspm");
			modelsFiles.add(modelPath.toString());
			BufferedWriter writer = Files.newBufferedWriter(modelPath);
			Model model = engine.nextModel();
			newModel = true;
			for (Iterator<Atom> i = model.iterator(); i.hasNext();) {
				Atom atom = (Atom) i.next();
				
				// Only print nodex, propx and edgex
				if (targets.contains(atom.getName())) {
					
					// Wait until the first atom in the target model the
					// get the name of the target metamodel to use in model(_, _).
					if (newModel) {
						writer.write(String.format("model(\"m%d\", %s).%n", c,
								atom.getArguments().get(0).toString()
								.replaceFirst("x_(\\w+)_target", "x_$1")));
						newModel = false;
					}
					
					// Nodex go first
					if (atom.getName().equals("nodex")) {
						writer.write(String.format("%s.%n",
								atom.toString()
									.replaceFirst("x\\(", "(")
									.replaceFirst("x_(\\w+)_target", "x_$1")));						
					}
					
					// Propx are stored for later to ensure print order
					else if (atom.getName().equals("propx")) {
						props += String.format("%s.%n",
								atom.toString()
									.replaceFirst("x\\(", "(")
									.replaceFirst("x_(\\w+)_target", "x_$1"));
					}
					
					// Edgex are stored for later to ensure print order
					else if (atom.getName().equals("edgex")) {
						edges += String.format("%s.%n",
								atom.toString()
									.replaceFirst("x\\(", "(")
									.replaceFirst("x_(\\w+)_target", "x_$1"));
					}
				}
			}
			
			// Print props
			writer.write(props);
			props = "";
			
			// Print edges
			writer.write(edges);
			edges = "";
			
			writer.close();
		}
		return modelsFiles;
	}

}
