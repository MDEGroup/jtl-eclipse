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
import java.io.StringReader;
import java.net.URISyntaxException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.atl.core.ATLCoreException;

import jaspwrapper.exception.JASPException;
import jtl.solver.ASPSolver;
import jtl.solver.AbstractASPSolver;
import jtl.transformations.ASPm2MM;
import jtl.transformations.Ecore2ASPmm;
import jtl.transformations.EmftextConverter;
import jtl.transformations.JTL2ASP;
import jtl.transformations.MM2ASPm;
import jtl.transformations.RegisterMetamodel;

public abstract class AbstractJTLLauncher {

	// Configuration file
	protected final static String config = "resources/config.properties";

	// Source metamodel file
	protected File sourcemmFile;

	// Target metamodel file
	protected File targetmmFile;

	// Source model file
	protected File sourcemFile;

	// Target models folder
	protected File targetmFolder;

	// Transformation file
	protected File transfFile;

	// ASP output
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
	 * Launch the transformation process.
	 */
	public void launch() {

		// Check if the files involved in the transformation
		// changed since the last run to skip the ASP generation.
		if (launchFilesChanged()) {

			// Dump launch information
			dumpLaunchConfiguration();

			// Process the source metamodel
			processSourceMetamodel();

			// Process the target metamodel
			final String targetmmName = processTargetMetamodel();

			// Process the source model
			processSourceModel();

			// Generate the transformation
			generateTransformation(targetmmName);

			// Write the ASP to file
			writeASPToFile();
		}

		// Set the ASP filename
		transfFile = new File(getASPFilename());

		// Run the solver
		ArrayList<String> modelsFiles =
				runSolver(transfFile, targetmFolder, sourcemFile);

		// Process target models
		processTargetModels(modelsFiles, targetmmFile);
	};

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
	 * Check if the files involved in the transformation
	 * changed since the last run to skip the ASP generation.
	 * @return true if files changed since the last run
	 */
	protected boolean launchFilesChanged() {
		// Files involved in the launch
		final File[] launchFiles = new File[] {
			sourcemmFile,
			targetmmFile,
			sourcemFile,
			transfFile
		};

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
			System.out.println("File not found: " + ASPFile);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Unable to read the file: " + ASPFile);
			e.printStackTrace();
		}

		return true;
	}

	/**
	 * Get launch configuration information like
	 * plugins versions and MD5 hash of involved files
	 * and write them as a comment in the ASP program.
	 */
	protected void dumpLaunchConfiguration() {

		// Open the information section
		writeASP("%%% Generated on: " + LocalDateTime.now() + "\n");

		// Compute MD5 of files involved in the launch
		computeMD5();

		// Get bundles versions
		getBundlesVersions();

		// Close the information section
		writeASP("%%%-\n\n");
	}

	/**
	 * Compute MD5 of files involved in the launch
	 */
	protected void computeMD5() {
		// Files involved in the launch
		final File[] launchFiles = new File[] {
			sourcemmFile,
			targetmmFile,
			sourcemFile,
			transfFile
		};

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
	protected void generateTransformation(final String targetmmName) {
		// JTL text to model (EMFText)
		emftextTextToModel(transfFile, "\n%%% TRANSFORMATION %%%\n");

		// Generate the filename for the newly created Ecore transformation file
		final File ecoreASPFile = new File(transfFile.getPath().substring(
				0, transfFile.getPath().lastIndexOf('.')) + ".jtl.ecore");

		// JTL to ASP Ecore (ATL)
		File transfASPFile;
		try {
			transfASPFile = new File(JTL2ASP.runTransformation(ecoreASPFile));
		} catch (IOException | ATLCoreException e) {
			System.out.println("Unable to perform the JTL to Ecore transformation:");
			e.printStackTrace();
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

		// Append the target metamodel fact mmt= to the contraints
		tmpStr = setTransformationDirection(tmpStr);

		writeASP(tmpStr);
		// Remove the temporary created file
		removeFile(transfASPFile);

		// Append the transformation engine
		writeTransformationEngine();
	}

	/**
	 * Impose the transformation direction in the ASP transformation
	 * setting the constant mmt for each generated constraint.
	 * @param transfASP generated ASP program to update
	 * @return ASP program updated witj transformation direction
	 */
	private String setTransformationDirection(final String transfASP) {
		final String newline = System.getProperty("line.separator");
		String result = "";
		Pattern p = Pattern.compile("(nodex|propx|edgex)\\(([^,]+)");
		try (BufferedReader br = new BufferedReader(new StringReader(transfASP))) {
			String line = null;
			while ((line = br.readLine()) != null) {
				Matcher m = p.matcher(line);
				if (m.find()) {
					result += line.replaceFirst("\\.$", ", mmt=" + m.group(2) + ".");
				} else {
					result += line;
				}
				result += newline;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * Process the ASP target models.
	 * @param modelsFiles list of generated target models files
	 * @param targetmmFile target metamodel filename
	 */
	protected void processTargetModels(
			final ArrayList<String> modelsFiles,
			final File targetmmFile) {

		// FIXME check modelsFiles for null and alert the user

		// Register the ASPm metamodel
		try {
			RegisterMetamodel.registerMetamodel(new File(
					new it.univaq.jtl.atl.aspm2mm.ASPm2MMGenerator()
						.getMetamodelUri("ASPm")));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Process target models
		for (String target : modelsFiles) {
			File targetFile = new File(target);

			// Convert the ASP target models (text2model)
			new EmftextConverter().convert(targetFile);
			targetFile = new File(target + ".ecore");

			// ASPm to Ecore (ATL generated from HOT)
			try {
				ASPm2MM.runTransformation(targetmmFile, targetFile);
			} catch (IOException | ATLCoreException e) {
				System.out.println("Unable to perform the Target Model ASPm to Ecore transformation:");
				e.printStackTrace();
			} finally {
				removeFile(targetFile);
			}
		}
	}

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
		return new ASPSolver();
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
			System.out.println(
					"Unable to perform the Ecore to ASPmm transformation of file: " +
					metamodelFile.getPath());
			e.printStackTrace();
			return null;
		}
		return mmASPmmFile;
	}

	/**
	 * Ecore to ASPm (ATL generated from HOT).
	 * @param metamodelFile IFile of the metamodel
	 * @param modelFile IFile of the model
	 * @return Path to the converted file
	 */
	protected String modelEcoreToASPm(final File metamodelFile, final File modelFile) {
		// The file created by the transformation
		String mASPmFile;
		try {
			mASPmFile = MM2ASPm.runTransformation(metamodelFile, modelFile);
		} catch (IOException | ATLCoreException e) {
			System.out.println(
					"Unable to perform the Ecore to ASPm transformation: " +
					modelFile.getPath());
			e.printStackTrace();
			return null;
		}
		return mASPmFile;
	}

	/**
	 * EMFText Model to Text
	 * @param modelFile Path of the model to convert
	 * @param comment Comment to write before the produced ASP
	 * @return IFile of the converted file
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
	 * @return IFile of the converted file
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
	 * @param textFile IFile of the text file
	 * @param comment Comment to write before he produced ASP
	 */
	protected void emftextTextToModel(
			final File textFile, final String comment) {
		if (comment != null) {
			writeASP(comment);
		}
		new EmftextConverter().convert(textFile);
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
	 * Write a string to buffer of the ASP file.
	 * @param content String to write
	 * @param asp OutputStream containing the ASP program
	 */
	protected void writeASP(final String content) {
		try {
			asp.write(content.getBytes());
		} catch (IOException e) {
			System.out.println("Unable to write the generated ASP:");
			e.printStackTrace();
		}
	}

	/**
	 * Append the transformation engine to the ASP program.
	 */
	protected void writeTransformationEngine() {
		try {
			Properties prop = new Properties();
			ClassLoader cl = getClass().getClassLoader();
			InputStream in = cl.getResourceAsStream(config);
			// FIXME create a method to deal with inside/outside Eclipse resource loading
			if (in == null) {
				in = cl.getResourceAsStream(config.substring(config.lastIndexOf('/') + 1));
			}
			prop.load(in);
			String te = prop.getProperty("transformation_engine");
			InputStream is = cl.getResourceAsStream(te);
			if (is == null) {
				is = cl.getResourceAsStream(te.substring(te.lastIndexOf('/') + 1));
			}
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
			System.out.println("Unable to write the ASP file:");
			e.printStackTrace();
			return null;
		}
		return ASPFile;
	}

	/**
	 * Remove a file.
	 * @param file The file to remove.
	 */
	protected static void removeFile(final File file) {
		file.delete();
	}

	/**
	 * Returns the ASP filename.
	 * @return ASP filename
	 */
	protected String getASPFilename() {
		return transfFile.getPath().substring(
				0, transfFile.getPath().lastIndexOf('.')) + ".dl";
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
			System.out.println("No MD5 algorithm found.");
			e.printStackTrace();
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
			System.out.println("Unable to read the file: " + file);
			e.printStackTrace();
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
