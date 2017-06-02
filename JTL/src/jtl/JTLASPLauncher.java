package jtl;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.core.resources.IFile;

public class JTLASPLauncher extends AbstractJTLLauncher {

	/**
	 * Launch the transformation process.
	 * @param sourcemmFile source metamodel file
	 * @param targetmmFile target metamodel file
	 * @param sourcemFile source model file
	 * @param targetmFolder folder where to save generated target models
	 * @param transfFile file specifying the transformation
	 */
	@Override
	public void launch(final IFile sourcemmFile,
					   final IFile targetmmFile,
					   final IFile sourcemFile,
					   final String targetmFolder,
					   final IFile transfFile) {
		// Initialize the OutputStream that will hold the generated ASP
		ByteArrayOutputStream asp = new ByteArrayOutputStream();

		// IFile filename to string
		String ASPFile = transfFile.getLocation().toOSString();

		// Files involved in the launch
		IFile[] launchFiles = new IFile[] {
			sourcemmFile,
			targetmmFile,
			sourcemFile,
			transfFile
		};

		// TODO endogenous case

		// Check if the files involved in the transformation
		// changed since the last run to skip the ASP generation.
		if (launchFilesChanged(launchFiles, transfFile)) {
			// Dump launch information
			dumpLaunchConfiguration(launchFiles, asp);

			// Source Metamodel
			// Ecore to ASPmm (ATL)
			String sourcemmASPmmFile = metamodelEcoreToASPmm(sourcemmFile);
			// ASPmm model to text (EMFText)
			IFile sourcemmASPmmIFile =
						emftextModelToText(sourcemmASPmmFile, "%%% SOURCE METAMODEL %%%\n", asp);
			// Remove the temporary created file
			removeFile(sourcemmASPmmIFile);

			// Target metamodel
			// Ecore to ASPmm (ATL)
			String targetmmASPmmFile = metamodelEcoreToASPmm(targetmmFile);
			// Get the name of the target metamodel
			String targetmmName = getMetamodelName(targetmmASPmmFile);
			// ASPmm model to text (EMFText)
			IFile targetmmASPmmIFile =
					emftextModelToText(targetmmASPmmFile, "\n%%% TARGET METAMODEL %%%\n", asp);
			// Remove the temporary created file
			removeFile(targetmmASPmmIFile);

			// Source model
			// Ecore to ASPm (ATL generated from HOT)
			String sourcemASPmFile = modelEcoreToASPm(sourcemmFile, sourcemFile);
			// ASPm model to text (EMFText)
			IFile sourcemASPmIFile =
						emftextModelToText(sourcemASPmFile, "\n%%% SOURCE MODEL %%%\n", asp);
			// Remove the temporary created file
			removeFile(sourcemASPmIFile);

			// Keep the text from the '%%% TRANSFORMATION %%%' line on
			try (BufferedReader br = new BufferedReader(new FileReader(ASPFile))) {
				boolean append = false;
				String line;
				while ((line = br.readLine()) != null) {
					if (append) {
						if (line.startsWith("#const mmt")) {
							writeASP("#const mmt = " + targetmmName + ".\n", asp);
						} else {
							writeASP(line + "\n", asp);
						}
					} else if (line.equals("%%% TRANSFORMATION %%%")) {
						append = true;
						writeASP("\n" + line + "\n", asp);
					}
				}
			} catch (FileNotFoundException e) {
				System.out.println("File not found: " + ASPFile);
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Unable to read the file: " + ASPFile);
				e.printStackTrace();
			}
		}

		// Write the ASP to file
		writeASPToFile(transfFile, asp);

		// Run the solver
		ArrayList<String> modelsFiles = runSolver(ASPFile, targetmFolder, sourcemFile.getName());

		// Process target models
		processTargetModels(modelsFiles, targetmmFile);
	}

}
