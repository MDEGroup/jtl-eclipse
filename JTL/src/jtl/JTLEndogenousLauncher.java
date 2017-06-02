package jtl;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.core.resources.IFile;

public class JTLEndogenousLauncher extends AbstractJTLLauncher {

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
					   final IFile transfFile,
					   final IFile tracesFile) {
		// Initialize the OutputStream that will hold the generated ASP
		ByteArrayOutputStream asp = new ByteArrayOutputStream();

		// ASP file to launch
		String ASPFile = transfFile.getLocation()
				.removeFileExtension().addFileExtension("dl")
				.toOSString();
		// Files involved in the launch
		final ArrayList<IFile> launchFilesList = new ArrayList<IFile>(Arrays.asList(
			sourcemmFile,
			sourcemFile,
			transfFile
		));
		if (tracesFile != null) {
			launchFilesList.add(tracesFile);
		}
		final IFile[] launchFiles = launchFilesList.toArray(new IFile[launchFilesList.size()]);

		// Check if the files involved in the transformation
		// changed since the last run to skip the ASP generation.
		if (launchFilesChanged(launchFiles, transfFile)) {
			// Dump launch information
			dumpLaunchConfiguration(launchFiles, asp);

			// Source Metamodel
			// Ecore to ASPmm (ATL)
			String sourcemmASPmmFile = metamodelEcoreToASPmm(sourcemmFile);
			// ASPmm model to text (EMFText)
			String sourcemmName = getMetamodelName(sourcemmASPmmFile);
			// Source Metamodel
			IFile sourcemmASPmmIFile = emftextModelToText(sourcemmASPmmFile,
						"%%% SOURCE METAMODEL %%%\n",
						sourcemmName,
						sourcemmName + "_source",
						asp);
			// Target Metamodel (the same as the source one)
			emftextModelToText(sourcemmASPmmFile,
					"%%% TARGET METAMODEL %%%\n",
					sourcemmName,
					sourcemmName + "_target",
					asp);
			// Remove the temporary created file
			removeFile(sourcemmASPmmIFile);

			// Source model
			// Ecore to ASPm (ATL generated from HOT)
			String sourcemASPmFile = modelEcoreToASPm(sourcemmFile, sourcemFile);
			// ASPm model to text (EMFText)
			IFile sourcemASPmIFile;
			sourcemASPmIFile = emftextModelToText(sourcemASPmFile,
						"\n%%% SOURCE MODEL %%%\n",
						sourcemmName,
						sourcemmName + "_source",
						asp);
			// Remove the temporary created file
			removeFile(sourcemASPmIFile);

			// Trace model
			if (tracesFile != null) {
				// IFile filename to string
				String tracesFilePath = tracesFile.getLocation().toOSString();

				try (BufferedReader br = new BufferedReader(new FileReader(tracesFilePath))) {
					String line;
					writeASP("\n%%% TRACE MODEL %%%\n", asp);
					while ((line = br.readLine()) != null) {
						writeASP(line + "\n", asp);
					}
				} catch (FileNotFoundException e) {
					System.out.println("File not found: " + tracesFilePath);
					e.printStackTrace();
				} catch (IOException e) {
					System.out.println("Unable to read the file: " + tracesFilePath);
					e.printStackTrace();
				}
			}

			// Transformation
			generateTransformation(transfFile, sourcemmName + "_target", asp);
		}
		// Run the solver
		ArrayList<String> modelsFiles = runSolver(ASPFile, targetmFolder, sourcemFile.getName());

		// Process target models
		processTargetModels(modelsFiles, targetmmFile);

	}

}
