package jtl.eclipse;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import org.eclipse.core.resources.IFile;

public class JTLEndogenousLauncher extends AbstractEclipseJTLLauncher {

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

		// ASP file to launch
		String ASPFile = transfFile.getLocation()
				.removeFileExtension().addFileExtension("dl")
				.toOSString();

		// Files involved in the launch
		IFile[] launchFiles = new IFile[] {
			sourcemmFile,
			sourcemFile,
			transfFile
		};

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

			// Transformation
			generateTransformation(transfFile, sourcemmName + "_target", asp);
		}
		// Run the solver
		ArrayList<String> modelsFiles = runSolver(ASPFile, targetmFolder);

		// Process target models
		processTargetModels(modelsFiles, targetmmFile);

	}

}
