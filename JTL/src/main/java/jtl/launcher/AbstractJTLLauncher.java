package jtl.launcher;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.atl.core.ATLCoreException;

import jaspwrapper.exception.JASPException;
import jtl.solver.ASPSolver;
import jtl.solver.AbstractASPSolver;
import jtl.transformations.ASPT2TraceModel;
import jtl.transformations.ASPm2MM;
import jtl.transformations.Ecore2ASPmm;
import jtl.transformations.EmftextConverter;
import jtl.transformations.JTL2ASP;
import jtl.transformations.MM2ASPm;
import jtl.transformations.RegisterMetamodel;
import jtl.transformations.TraceModel2ASPT;
import jtl.utils.Files;
import jtl.utils.WhereAmI;

public abstract class AbstractJTLLauncher {

	/** Logger */
	private static Logger logger = LogManager.getLogger(AbstractJTLLauncher.class);

	/** Configuration file */
	protected final static String config = "config.properties";

	/** Working directory */
	protected String workingDir = "";

	/** Source metamodel file */
	protected File sourcemmFile;

	/** Target metamodel file */
	protected File targetmmFile;

	/** Source model file */
	protected File sourcemFile;

	/** Target models folder */
	protected File targetmFolder;

	/** Transformation file */
	protected File transfFile;

	/** Traces model file */
	protected File tracesFile;

	/** Constraints file */
	protected List<File> constraintsFiles;

	/** Limit the number of output models (0 = no limit) */
	protected int targetModelsLimit = 0;

	/** Next transformation in the chain */
	protected String chainTransformation;

	/** Limit the number of models in input to the next transformation */
	protected int chainLimit;

	/** ASP output */
	protected ByteArrayOutputStream asp = new ByteArrayOutputStream();

	/**
	 * Default constructor to be used by implementing classes.
	 * @param sourcemmFile source metamodel file
	 * @param targetmmFile target metamodel file
	 * @param sourcemFile source model file
	 * @param targetmFolder folder where to save generated target models
	 * @param transfFile file specifying the transformation
	 */
	public AbstractJTLLauncher(
			final File sourcemmFile,
			final File targetmmFile,
			final File sourcemFile,
			final File targetmFolder,
			final File transfFile) {
		this.sourcemmFile = sourcemmFile;
		this.targetmmFile = targetmmFile;
		this.sourcemFile =  sourcemFile;
		this.targetmFolder = targetmFolder;
		this.transfFile = transfFile;
	}

	/**
	 * Returns the traces model file.
	 * @return the traces model file
	 */
	public File getTracesFile() {
		return tracesFile;
	}

	/**
	 * Sets the traces model file.
	 * @param tracesFile traces model file
	 */
	public void setTracesFile(File tracesFile) {
		this.tracesFile = tracesFile;
	}

	/**
	 * Sets the current working directory.
	 * @param workingDir working directory
	 */
	public void setWorkingDir(final String workingDir) {
		this.workingDir = workingDir;
	}

	/**
	 * Returns the transformation file.
	 * @return transformation file
	 */
	public File getTransfFile() {
		return transfFile;
	}

	/**
	 * Sets the transformation file.
	 * @param transfFile transformation file
	 */
	public void setTransfFile(final File transfFile) {
		this.transfFile = transfFile;
	}

	/**
	 * Returns the constraits file.
	 * @return constraints file
	 */
	public List<File> getConstraintsFile() {
		return constraintsFiles;
	}

	/**
	 * Set the constraints file
	 * @param constraintsFile2 constraints file
	 */
	public void setConstraintsFile(final List<File> constraintsFile2) {
		this.constraintsFiles = constraintsFile2;
	}

	/**
	 * Returns the ASP output stream.
	 * @returns ASP output stream
	 */
	public ByteArrayOutputStream getASP() {
		return asp;
	}

	/**
	 * Sets the ASP output stream.
	 * @param asp ASP output stream
	 */
	public void setASP(final ByteArrayOutputStream asp) {
		this.asp = asp;
	}

	/**
	 * Sets a limit on the number of generated target models.
	 * @param limit Limit on the number of generated models
	 */
	public void setTargetModelsLimit(final int limit) {
		this.targetModelsLimit = limit;
	}

	/**
	 * Sets the name of the next transformation in the chain.
	 * @param name Name of the next transformation
	 */
	public void setChainTransformation(final String name) {
		this.chainTransformation = name;
	}

	/**
	 * Sets the limit to the number of model to use
	 * as input of the next transformation in the chain.
	 * @param limit Limit to the number of models
	 */
	public void setChainLimit(final int limit) {
		this.chainLimit = limit;
	}

	/**
	 * Launch the transformation process.
	 */
	public void launch() {

		// Check if the files involved in the transformation
		// changed since the last run to skip the ASP generation.
		if (launchFilesChanged()) {
			// Process the source metamodel
			processSourceMetamodel();

			// Process the target metamodel
			final String targetmmName = processTargetMetamodel();

			// Process the source model
			processSourceModel();

			// Process the traces model
			processTracesModel();

			// Append additional constraints
			if (constraintsFiles != null) {
				for (File file : constraintsFiles) {
					writeASP(file);
				}
			}

			// Generate the transformation
			generateTransformation(targetmmName);

			// Dump launch information
			dumpLaunchConfiguration();

			// Write the ASP to file
			writeASPToFile();
		}

		// Clear the target directory if needed
		if (Launcher.options.get(Launcher.OPTION_CLEAR_TARGET)) {
			clearTargetDirectory();
		}

		// Set the ASP filename
		transfFile = new File(getASPFilename());

		// Run the solver
		ArrayList<String> modelsFiles =
				runSolver(transfFile, targetmFolder, sourcemFile);

		if (modelsFiles != null && modelsFiles.size() > 0) {
			// Limit the number of target models
			if (targetModelsLimit > 0) {
				modelsFiles = new ArrayList<String>(modelsFiles.subList(0,
						(targetModelsLimit > modelsFiles.size()) ? modelsFiles.size() : targetModelsLimit));
			}

			// Process target models
			final ArrayList<String> targetFiles =
					processTargetModels(modelsFiles, targetmmFile);

			// Process target trace models
			processTargetTraceModels(modelsFiles);

			// Run the next transformation in the chain
			if (this.chainTransformation != null &&
				this.chainLimit > 0 &&
				this.chainLimit <= modelsFiles.size()) {

				runChainTransformation(targetFiles);
			}
		} else if (modelsFiles == null) {
			// TODO alert the user there are no output models
		}

		// Clean
		clean();
	};

	/**
	 * Get the current working directory
	 */
	public String getWorkingDir() {
		return System.getProperty("user.dir");
	}

	/**
	 * Get the directory that will be used to store target models.
	 * @return target models directory
	 */
	public File getOutputDir() {

		File outputDir = targetmFolder;

		// If we have an absolute path inside Eclipse, prepend the workspace
		// If we have an absolute path outside Eclipse, return it as it is
		Path targetPath = (outputDir.isAbsolute() == WhereAmI.isOSGI()) ?
				Paths.get(getWorkingDir(), outputDir.getPath()) : outputDir.toPath();

		if (outputDir.getName().endsWith(".xmi")) {
			outputDir = outputDir.getParentFile();
			targetPath = targetPath.getParent();
		}
		if (!java.nio.file.Files.isDirectory(targetPath)) {
			logger.error(targetPath + " is not a directory.");
			return null;
		}
		if (!java.nio.file.Files.isWritable(targetPath)) {
			logger.error(targetPath + " is a directory but it is not writable.");
			return null;
		}
		return outputDir;
	}

	/**
	 * Clear (as in remove all files) from the target directory.
	 */
	protected void clearTargetDirectory() {
		final File targetDir = getOutputDir();
		for (File file : targetDir.listFiles()) {
			if (file.isFile()) {
				file.delete();
			}
		}
	}

	/**
	 * Process the source metamodel to generate the corresponding ASP code.
	 */
	public abstract void processSourceMetamodel();

	/**
	 * Process the target metamodel to generate the corresponding ASP code.
	 * @return name of the target metamodel
	 */
	public abstract String processTargetMetamodel();

	/**
	 * Process the source model to generate the corresponding ASP code.
	 */
	public abstract void processSourceModel();

	/**
	 * Process the traces model to generate the corresponding ASP code.
	 */
	public abstract void processTracesModel();

	/**
	 * Check if the files involved in the transformation
	 * changed since the last run to skip the ASP generation.
	 * @return true if files changed since the last run
	 */
	protected boolean launchFilesChanged() {
		// Files involved in the launch
		final ArrayList<File> launchFilesList = new ArrayList<File>(Arrays.asList(
			sourcemmFile,
			targetmmFile,
			sourcemFile,
			transfFile
		));
		if (tracesFile != null) {
			launchFilesList.add(tracesFile);
		}
		final File[] launchFiles = launchFilesList.toArray(new File[launchFilesList.size()]);

		// Generate the ASP filename
		final String ASPFile = getASPFilename();

		// Check if the ASP file exists
		if (!new File(ASPFile).exists()) {
			return true;
		}

		// Get launch files locations and compute the MD5 checksums
		String[] launchFilesLoc = new String[launchFiles.length];
		String[] launchFilesMD5 = new String[launchFiles.length];
		for (int i = 0; i < launchFiles.length; i++) {
			launchFilesLoc[i] = launchFiles[i].getPath();
			launchFilesMD5[i] = getMD5Digest(launchFiles[i].getPath());
		}

		// Look for MD5 checksums in the ASP file
		try (BufferedReader br = new BufferedReader(new FileReader(ASPFile))) {
			int verified = 0;
			String line;
			// Read the file line by line until %%%-
			// marking the end of the information section
			while (verified < launchFiles.length &&
				   !(line = br.readLine()).equals("%%%-")) {
				for (int i = 0; i < launchFilesLoc.length; i++) {
					if (line.contains(launchFilesLoc[i]) &&
						line.substring(line.lastIndexOf(':') + 2)
							.equals(launchFilesMD5[i])) {
						verified++;
						break;
					}
				}
			}
			return verified != launchFiles.length;
		} catch (FileNotFoundException e) {
			logger.error("File not found: " + ASPFile, e);
		} catch (IOException e) {
			logger.error("Unable to read the file: " + ASPFile, e);
		}

		return true;
	}

	/**
	 * Get launch configuration information like
	 * plugins versions and MD5 hash of involved files
	 * and write them as a comment in the ASP program.
	 */
	protected void dumpLaunchConfiguration() {
		// The launch configuration should be prepended
		// at the beginning of the current ASP output.
		// We save the current output in order to
		// later append it after the launch configuration.
		final ByteArrayOutputStream tmp = this.asp;
		this.asp = new ByteArrayOutputStream();

		// Open the information section
		writeASP("%%% Generated on: " + LocalDateTime.now() + "\n");

		// Compute MD5 of files involved in the launch
		computeMD5();

		// Get bundles versions
		getBundlesVersions();

		// Close the information section
		writeASP("%%%-\n\n");

		// Append the rest of the output
		try {
			tmp.writeTo(this.asp);
		} catch (IOException e) {
			logger.error("An error occurred while dumping the launch configuration.", e);
		}
	}

	/**
	 * Compute MD5 of files involved in the launch
	 */
	protected void computeMD5() {
		// Files involved in the launch
		final ArrayList<File> launchFilesList = new ArrayList<File>(Arrays.asList(
			sourcemmFile,
			targetmmFile,
			sourcemFile,
			transfFile
		));
		if (tracesFile != null) {
			launchFilesList.add(tracesFile);
		}
		final File[] launchFiles = launchFilesList.toArray(new File[launchFilesList.size()]);

		for (File file : launchFiles) {
			writeASP("% " + file.getPath() + " : " +
					getMD5Digest(file.getPath()) + "\n");
		}
	}

	/**
	 * Get bundles versions
	 */
	protected void getBundlesVersions() {
		// TODO make it work outside Eclipse
	}

	/**
	 * Generate the ASP transformation from the JTL source code.
	 * @param targetmmName name of the target metamodel
	 * @return filename of the final ASP program
	 */
	public void generateTransformation(final String targetmmName) {
		// JTL text to model (EMFText)
		final File ecoreASPFile = emftextTextToModel(transfFile);

		// JTL to ASP Ecore (ATL)
		File transfASPFile;
		try {
			transfASPFile = new File(JTL2ASP.runTransformation(ecoreASPFile));
		} catch (IOException | ATLCoreException e) {
			logger.error("Unable to perform the JTL to Ecore transformation.", e);
			return;
		}
		// Remove the temporary created file
		removeFile(ecoreASPFile);

		// JTL ASP model to text (EMFText)
		ByteArrayOutputStream tmp = new ByteArrayOutputStream();
		new EmftextConverter().convert(transfASPFile, tmp);

		// Set the mmt constant
		String tmpStr = tmp.toString()
				.replaceFirst("(?s).+?(?=relation_)", "#const mmt = " +
						targetmmName + ".\n");

		// Remove an extra newline after the first comment in constraints
		tmpStr = tmpStr.replaceFirst("(relation_.*\n\n% .*\n)\n", "$1");

		writeASP("\n%%% TRANSFORMATION %%%\n" + tmpStr);

		// Remove the temporary created file
		removeFile(transfASPFile);

		// Append the transformation engine
		writeTransformationEngine();
	}

	/**
	 * Process the ASP target models.
	 * @param modelsFiles list of generated target models files
	 * @param targetmmFile target metamodel filename
	 * @return list of the target models files after processing
	 */
	protected ArrayList<String> processTargetModels(
			final ArrayList<String> modelsFiles,
			final File targetmmFile) {

		// Register the ASPm metamodel
		try {
			RegisterMetamodel.registerMetamodel(
					new it.univaq.jtl.atl.aspm2mm.ASPm2MMGenerator()
						.getMetamodelUri("ASPm"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Process target models
		ArrayList<String> targetFiles = new ArrayList<String>();
		for (String target : modelsFiles) {
			// Distinguish target models from trace models
			if (target.endsWith(".aspm")) {
				final File targetFile = new File(target);

				// Convert the ASP target models (text2model)
				final File targetFileModel = emftextTextToModel(targetFile);

				// ASPm to Ecore (ATL generated from HOT)
				final String xmiFilename = modelASPmToEcore(targetmmFile, targetFileModel);

				// Add the generated file to the list of processed models files
				targetFiles.add(xmiFilename);

				// Remove temporary itermediate files
				if (!Launcher.options.get(Launcher.OPTION_GENERATE_ASP)) {
					removeFile(targetFile);
				}
				removeFile(targetFileModel);
			}
		}

		return targetFiles;
	}

	/**
	 * Process the ASPT target trace models.
	 * @param modelsFiles list of generated target files
	 * @return list of the target trace models files after processing
	 */
	protected ArrayList<String> processTargetTraceModels(
			final ArrayList<String> modelsFiles) {

		// Register the ASPT metamodel
		try {
			RegisterMetamodel.registerMetamodel(
					new it.univaq.jtl.atl.aspt2tracemodel.ASPT2TraceModel()
						.getMetamodelUri("ASPT"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Process trace  models
		ArrayList<String> traceFiles = new ArrayList<String>();
		for (String trace : modelsFiles) {
			// Distinguish trace models from target models
			if (trace.endsWith(".aspt")) {
				final File traceFile = new File(trace);

				// Convert the ASP trace models (text2model)
				final File traceFileModel = emftextTextToModel(traceFile);

				// ASPT to Ecore
				// The name of the trace model has the "_trace.aspt" suffix.
				// This is why we need to remove the last 11 chars and replace them
				// with ".xmi" to get the name of the corresponding target model.
				final String xmiFilename = modelASPTToEcore(traceFileModel, sourcemFile,
						new File(trace.substring(0, trace.length() - 11) + ".xmi"));

				// Add the generated file to the list of processed trace files
				traceFiles.add(xmiFilename);

				// Remove temporary itermediate files
				if (!Launcher.options.get(Launcher.OPTION_GENERATE_ASP)) {
					removeFile(traceFile);
				}
				removeFile(traceFileModel);
			}
		}

		return traceFiles;
	}

	/**
	 * Runs the next transformation in the chain.
	 * @param targetFiles List of files to use as input
	 *        of the chained transformation
	 */
	protected void runChainTransformation(ArrayList<String> targetFiles) {}

	/**
	 * Run the solver to generate the target models.
	 * @param ASPFile filename of the file containing the ASP program
	 * @param targetmFolder folder where to save generated target models
	 * @return List of target models
	 */
	protected ArrayList<String> runSolver(
			final File ASPFile,
			final File targetmFolder,
			final File sourcemFile) {
		ArrayList<String> modelsFiles = null;
		try {
			modelsFiles = getSolver().run(ASPFile, targetmFolder, sourcemFile);
		} catch (JASPException | IOException |  URISyntaxException e) {
			e.printStackTrace();
		}
		return modelsFiles;
	}

	/**
	 * Return the solver implementation class.
	 * @return solver object
	 */
	protected AbstractASPSolver getSolver() {
		return new ASPSolver(this);
	}

	/**
	 * Ecore to ASPmm (ATL).
	 * This will create the target file of the ATL transformation:
	 * source filename + .ASPmm.ecore
	 * @param metamodelFile File of the metamodel
	 * @return Path to the converted file
	 */
	protected String metamodelEcoreToASPmm(final File metamodelFile) {
		// The file created by the transformation
		String mmASPmmFile;
		try {
			mmASPmmFile = Ecore2ASPmm.runTransformation(metamodelFile);
		} catch (IOException | ATLCoreException e) {
			logger.error(
					"Unable to perform the Ecore to ASPmm transformation of file: " +
					metamodelFile.getPath(), e);
			return null;
		}
		return mmASPmmFile;
	}

	/**
	 * Ecore to ASPm (ATL generated from HOT).
	 * @param metamodelFile File of the metamodel
	 * @param modelFile File of the model
	 * @return Path to the converted file
	 */
	protected String modelEcoreToASPm(final File metamodelFile, final File modelFile) {
		// The file created by the transformation
		String mASPmFile;
		try {
			mASPmFile = MM2ASPm.runTransformation(metamodelFile, modelFile);
		} catch (IOException | ATLCoreException e) {
			logger.error(
					"Unable to perform the Ecore to ASPm transformation: " +
					modelFile.getPath(), e);
			return null;
		}
		return mASPmFile;
	}

	/**
	 * Ecore to ASPT
	 * @param modelFile File of the trace model
	 * @return Path to the converted file
	 */
	protected String modelEcoreToASPT(final File modelFile) {
		String mASPTFile;
		try {
			mASPTFile = TraceModel2ASPT.runTransformation(modelFile);
		} catch (IOException | ATLCoreException e) {
			logger.error(
					"Unable to perform the Ecore to ASPT transformation: " +
					modelFile.getPath(), e);
			return null;
		}
		return mASPTFile;
	}

	/**
	 * ASPm to Ecore (ATL generated from HOT).
	 * @param metamodelFile File of the metamodel
	 * @param modelFile File of the model
	 * @return Path to the converted file
	 */
	protected String modelASPmToEcore(final File metamodelFile, final File modelFile) {
		String mEcoreFile;
		try {
			mEcoreFile = ASPm2MM.runTransformation(metamodelFile, modelFile);
		} catch (IOException | ATLCoreException e) {
			logger.error(
					"Unable to perform the ASPm to Ecore transformation: " +
					modelFile.getPath(), e);
			return null;
		}
		return mEcoreFile;
	}

	/**
	 * ASPT to Ecore.
	 * @param modelFile File of the model
	 * @return Path to the converted file
	 */
	protected String modelASPTToEcore(
			final File modelFile,
			final File source,
			final File target) {
		String mEcoreFile;
		try {
			mEcoreFile = ASPT2TraceModel.runTransformation(modelFile, source, target);
		} catch (IOException | ATLCoreException e) {
			logger.error(
					"Unable to perform the ASPT to Ecore transformation: " +
					modelFile.getPath(), e);
			return null;
		}
		return mEcoreFile;
	}

	/**
	 * EMFText Model to Text
	 * @param modelFile Path of the model to convert
	 * @param comment Comment to write before the produced ASP
	 * @return File of the converted file
	 */
	protected File emftextModelToText(
			final String modelFile, final String comment) {
		final File modelASPmmFile = new File(modelFile);
		if (comment != null) {
			writeASP(comment);
		}
		new EmftextConverter().convert(new File(modelFile), asp);
		return modelASPmmFile;
	}

	/**
	 * EMFText Model to Text
	 * @param modelFile Path of the model to convert
	 * @param comment Comment to write before the produced ASP
	 * @param modelname Name of the model to replace
	 * @param replace Replacement text for the model name
	 * @param asp OutputStream containing the ASP program
	 * @return File of the converted file
	 */
	protected File emftextModelToText(
			final String modelFile,
			final String comment,
			final String modelname,
			final String replace,
			final ByteArrayOutputStream asp) {
		final File modelASPmmFile = new File(modelFile);
		if (comment != null) {
			writeASP(comment);
		}

		// Temporary BAOS to replace the text
		ByteArrayOutputStream tmpReplace = new ByteArrayOutputStream();

		// Convert
		new EmftextConverter().convert(modelASPmmFile, tmpReplace);
		String converted = tmpReplace.toString();

		// Replace
		converted = converted.replaceAll(modelname, replace);

		// Write to the output
		writeASP(converted);

		return modelASPmmFile;
	}

	/**
	 * EMFText Text to Model
	 * @param textFile File of the text file
	 * @param comment Comment to write before the produced ASP
	 * @return File of the converted file
	 */
	protected File emftextTextToModel(final File textFile) {
		return new File(new EmftextConverter().convert(textFile));
	}

	/**
	 * Get the name of the metamodel.
	 * @param metamodelFile Path to the metamodel file
	 * @return The name of the metamodel
	 */
	protected String getMetamodelName(final String metamodelFile) {
		// Create a Resource Set
		ResourceSet rs = new ResourceSetImpl();

		// Get the name of the target metamodel
		Resource mmResource = rs.getResource(URI.createURI(metamodelFile), true);
		EObject mmPackage = mmResource.getContents().get(0);
		Object mmName = mmPackage.eGet(mmPackage.eClass().getEStructuralFeature("name"));

		return mmName.toString();
	}

	/**
	 * Clean up the environment at the end of a launch
	 */
	public void clean() { }

	/**
	 * Write a string to the buffer of the ASP file.
	 * @param content String to write
	 * @param asp OutputStream containing the ASP program
	 */
	protected void writeASP(final String content) {
		try {
			asp.write(content.getBytes());
		} catch (IOException e) {
			logger.error("Unable to write the generated ASP.", e);
		}
	}

	/**
	 * Write an entire file to the buffer of the ASP file.
	 * @param file file to write
	 */
	protected void writeASP(final File file) {
		String line = null;
		try (BufferedReader r = new BufferedReader(new FileReader(file))) {
			while ((line = r.readLine()) != null) {
				writeASP(line + "\n");
			}
		} catch (FileNotFoundException e) {
			logger.error("File not found: " + constraintsFiles, e);
		} catch (IOException e) {
			logger.error("Unable to read the file: " + constraintsFiles, e);
		}
	}

	/**
	 * Append the transformation engine to the ASP program.
	 */
	protected void writeTransformationEngine() {
		try {
			Properties prop = new Properties();
			ClassLoader cl = AbstractJTLLauncher.class.getClassLoader();
			InputStream in = null;
			in = cl.getResourceAsStream(config);
			if (in == null) cl.getResourceAsStream("resources/" + config);
			prop.load(in);
			String te = prop.getProperty("transformation_engine");
			InputStream is = null;
			is = cl.getResourceAsStream(te);
			if (is == null) cl.getResourceAsStream("resources/" + te);
			byte[] buffer = new byte[10240]; // 10KB
			int len;
			while ((len = is.read(buffer)) != -1) {
			    asp.write(buffer, 0, len);
			}
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Write the ASP to file.
	 * @return filename of the ASP final file
	 */
	protected String writeASPToFile() {
		final String ASPFile = getASPFilename();
		try (OutputStream ASPout = new FileOutputStream(ASPFile)) {
			asp.writeTo(ASPout);
		} catch (IOException e) {
			logger.error("Unable to write the ASP file: " + ASPFile, e);
			return null;
		}
		return ASPFile;
	}

	/**
	 * Remove a file.
	 * @param file The file to remove.
	 */
	protected void removeFile(final File file) {
		if (file.exists()) {
			file.delete();
		} else {
			final File fullPath = Paths.get(workingDir, file.getPath()).toFile();
			if (fullPath.exists()) {
				fullPath.delete();
			}
		}
	}

	/**
	 * Returns the ASP filename.
	 * @return ASP filename
	 */
	protected String getASPFilename() {
		return Files.addFileExtension(
			   Files.removeFileExtension(transfFile.getPath()), "dl");
	}

	/**
	 * Get MD5 digest of file.
	 * @param file path to file
	 * @return MD5 digest
	 */
	protected static String getMD5Digest(final String file) {
		// TODO move to jtl.utils
		// Get the MD5 algorithm instance
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			logger.error("No MD5 algorithm found.", e);
			return null;
		}

		// Compute the digest
		try (FileInputStream fis = new FileInputStream(file)) {
			byte[] data = new byte[10240];
			int nread = 0;
			while ((nread = fis.read(data)) != -1) {
				md.update(data, 0, nread);
			}
		} catch (IOException e) {
			logger.error("Unable to read the file: " + file, e);
			return null;
		}
		byte[] mdbytes = md.digest();

		// Convert the bytes to hex format
	    StringBuffer sb = new StringBuffer("");
	    for (int i = 0; i < mdbytes.length; i++) {
	    		sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
	    }

		return sb.toString();
	}
}
