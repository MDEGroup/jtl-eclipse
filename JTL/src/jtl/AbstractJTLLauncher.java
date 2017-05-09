package jtl;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.atl.core.ATLCoreException;

import jaspwrapper.exception.JASPException;
import jtl.handlers.ASPm2MM;
import jtl.handlers.Ecore2ASPmm;
import jtl.handlers.EmftextConverter;
import jtl.handlers.JTL2ASP;
import jtl.handlers.MM2ASPm;
import jtl.solver.ASPSolver;

public abstract class AbstractJTLLauncher {

	// Configuration file
	protected final static String config = "resources/config.properties";

	// List of bundles names to get version from
	// FIXME check if needed
	protected final static String[] bundles = new String[] {
		"ASP.resource.asp",
		"ASP.resource.asp.ui",
		"ASPM.resource.aspm",
		"ASPM.resource.aspm.ui",
		"ASPMM.resource.aspmm",
		"ASPMM.resource.aspmm.ui",
		"JTL",
		"JTL.atl",
		"JTL.emftext.ASP",
		"JTL.emftext.ASPM",
		"JTL.emftext.ASPMM",
		"JTL.emftext.JTL",
		"JTL.resource.jtl",
		"JTL.resource.jtl.ui",
		"org.emftext.commons.antlr3_4_0"
	};

	/**
	 * Launch the transformation process.
	 * @param sourcemmFile source metamodel file
	 * @param targetmmFile target metamodel file
	 * @param sourcemFile source model file
	 * @param targetmFolder folder where to save generated target models
	 * @param transfFile file specifying the transformation
	 */
	public abstract void launch(File sourcemmFile,
								File targetmmFile,
								File sourcemFile,
								File targetmFolder,
								File transfFile);

	/**
	 * Get launch configuration information like
	 * plugins versions and MD5 hash of involved files
	 * and write them as a comment in the ASP program.
	 * @param launchFiles files involved in the launch
	 * @param asp OutputStream containing the ASP program
	 */
	protected void dumpLaunchConfiguration() {
		// TODO dump configuration for standalone launch
	}

	/**
	 * Generate the ASP transformation from the JTL source code.
	 * @param transfFile JTL transformation filename
	 * @param asp OutputStream containing the ASP program
	 * @return filename of the final ASP program
	 */
	protected String generateTransformation(final IFile transfFile,
										  final String targetmmName,
										  final ByteArrayOutputStream asp) {
		// JTL text to model (EMFText)
		emftextTextToModel(transfFile, "\n%%% TRANSFORMATION %%%\n", asp);

		// Refresh all the projects in order to find
		// the newly created Ecore transformation
		refreshWorkspace();

		// Generate the filename for the newly created Ecore transformation file
		String ecoreASPFile = transfFile.getFullPath()
				.removeFileExtension()
				.addFileExtension("jtl")
				.addFileExtension("ecore")
				.toString();
		IFile ecoreASPIFile = getIFileFromURI(ecoreASPFile);

		// JTL to ASP Ecore (ATL)
		String transfASPFile;
		try {
			transfASPFile = JTL2ASP.runTransformation(ecoreASPIFile);
		} catch (IOException | ATLCoreException e) {
			System.out.println("Unable to perform the JTL to Ecore transformation:");
			e.printStackTrace();
			return null;
		}
		// Remove the temporary created file
		removeFile(ecoreASPIFile);

		// Impose the transformation direction
		//setTransformationDirection(transfASPFile, targetmmName);

		// JTL ASP model to text (EMFText)
		ByteArrayOutputStream tmp = new ByteArrayOutputStream();
		IFile transfASPIFile = getIFileFromURI(transfASPFile);
		new EmftextConverter().convert(transfASPIFile, tmp);

		// Set the mmt constant
		String tmpStr = tmp.toString()
				.replaceFirst("(?s).+?(?=relation_)", "#const mmt = " + targetmmName + ".\n");

		// Remove an extra newline after the first comment in constraints
		tmpStr = tmpStr.replaceFirst("(relation_.*\n\n% .*\n)\n", "$1");

		// Append the target metamodel fact mmt= to the contraints
		tmpStr = setTransformationDirection(tmpStr);

		writeASP(tmpStr, asp);
		// Remove the temporary created file
		removeFile(transfASPIFile);

		// Append the transformation engine
		writeTransformationEngine(asp);

		// Write the ASP to file
		String ASPFile = writeASPToFile(transfFile, asp);
		refreshWorkspace();
		return ASPFile;
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

		// Process target models
		for (String target : modelsFiles) {
			File targetFile = new File(target);

			// Convert the ASP target models (text2model)
			new EmftextConverter().convert(targetIFile);
			refreshWorkspace();
			targetIFile = getIFileFromURI(target + ".ecore");

			// ASPm to Ecore (ATL generated from HOT)
			try {
				ASPm2MM.runTransformation(targetmmFile, targetIFile);
			} catch (IOException | ATLCoreException e) {
				System.out.println("Unable to perform the Target Model ASPm to Ecore transformation:");
				e.printStackTrace();
			}
		}
	}

	/**
	 * Run the solver to generate the target models.
	 * @param ASPFile filename of the file containing the ASP program
	 * @param targetmFolder folder where to save generated target models
	 * @return List of target models
	 */
	protected ArrayList<String> runSolver(final File ASPFile, final File targetmFolder) {
		ArrayList<String> modelsFiles = null;
		try {
			modelsFiles = new ASPSolver().run(ASPFile, targetmFolder);
		} catch (JASPException | IOException |  URISyntaxException e) {
			e.printStackTrace();
		}
		return modelsFiles;
	}

	/**
	 * Ecore to ASPmm (ATL).
	 * This will create the target file of the ATL transformation:
	 * source filename + .ASPmm.ecore
	 * @param metamodelFile IFile of the metamodel
	 * @return Path to the converted file
	 */
	protected String metamodelEcoreToASPmm(final IFile metamodelFile) {
		// The file created by the transformation
		String mmASPmmFile;
		try {
			mmASPmmFile = Ecore2ASPmm.runTransformation(metamodelFile);
		} catch (IOException | ATLCoreException e) {
			System.out.println(
					"Unable to perform the Ecore to ASPmm transformation of file: " +
					metamodelFile.getFullPath().toString());
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
	protected String modelEcoreToASPm(final IFile metamodelFile, final IFile modelFile) {
		// The file created by the transformation
		String mASPmFile;
		try {
			mASPmFile = MM2ASPm.runTransformation(metamodelFile, modelFile);
		} catch (IOException | ATLCoreException e) {
			System.out.println(
					"Unable to perform the Ecore to ASPm transformation: " +
					modelFile.getFullPath().toString());
			e.printStackTrace();
			return null;
		}
		return mASPmFile;
	}

	/**
	 * EMFText Model to Text
	 * @param modelFile Path of the model to convert
	 * @param comment Comment to write before the produced ASP
	 * @param asp OutputStream containing the ASP program
	 * @return IFile of the converted file
	 */
	protected IFile emftextModelToText(
			final String modelFile,
			final String comment,
			final ByteArrayOutputStream asp) {
		IFile modelASPmmIFile = getIFileFromURI(modelFile);
		if (comment != null) {
			writeASP(comment, asp);
		}
		new EmftextConverter().convert(modelASPmmIFile, asp);
		return modelASPmmIFile;
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
	protected IFile emftextModelToText(
			final String modelFile,
			final String comment,
			final String modelname,
			final String replace,
			final ByteArrayOutputStream asp) {
		IFile modelASPmmIFile = getIFileFromURI(modelFile);
		if (comment != null) {
			writeASP(comment, asp);
		}

		// Temporary BAOS to replace the text
		ByteArrayOutputStream tmpReplace = new ByteArrayOutputStream();

		// Convert
		new EmftextConverter().convert(modelASPmmIFile, tmpReplace);
		String converted = tmpReplace.toString();

		// Replace
		converted = converted.replaceAll(modelname, replace);

		// Write to the output
		writeASP(converted, asp);

		return modelASPmmIFile;
	}

	/**
	 * EMFText Text to Model
	 * @param textFile IFile of the text file
	 * @param comment Comment to write before he produced ASP
	 * @param asp OutputStream containing the ASP program
	 */
	protected void emftextTextToModel(
			final IFile textFile,
			final String comment,
			final ByteArrayOutputStream asp) {
		if (comment != null) {
			writeASP(comment, asp);
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
	protected void writeASP(final String content, final ByteArrayOutputStream asp) {
		try {
			asp.write(content.getBytes());
		} catch (IOException e) {
			System.out.println("Unable to write the generated ASP:");
			e.printStackTrace();
		}
	}

	/**
	 * Append the transformation engine to the ASP program.
	 * @param asp OutputStream containing the ASP program
	 */
	protected void writeTransformationEngine(final ByteArrayOutputStream asp) {
		try {
			Properties prop = new Properties();
			ClassLoader cl = getClass().getClassLoader();
			prop.load(cl.getResourceAsStream(config));
			String te = prop.getProperty("transformation_engine");
			InputStream is = cl.getResourceAsStream(te);
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
	 * @param transfFile IFile of the transformation used to
	 * 		  generate the filename of the ASP final file
	 * @param asp OutputStream containing the ASP program
	 * @return filename of the ASP final file
	 */
	protected String writeASPToFile(final IFile transfFile, final ByteArrayOutputStream asp) {
		String ASPFile = transfFile.getLocation()
				.removeFileExtension().addFileExtension("dl")
				.toOSString();
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

		//try {
			//file.delete(true, new NullProgressMonitor());
		//} catch (CoreException e) {
		//	System.out.println("There was a problem deleting the file: ");
		//	e.printStackTrace();
		//}
	}
}
