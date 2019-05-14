package jtl.launcher;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import org.eclipse.m2m.atl.core.ATLCoreException;

import jaspwrapper.exception.JASPException;
import jtl.transformations.ASPT2TraceModel;
import jtl.transformations.RegisterMetamodel;

public class ASPExogenousTraceabilityLauncher {

	public jtl.launcher.AbstractJTLLauncher launcher;
	protected File leftmmFile;
	protected File rightmmFile;
	protected File leftmFile;
	protected File rightmFile;
	protected File transfFile;
	protected File traceFile;

	public ASPExogenousTraceabilityLauncher(
			File leftmmFile,
			File rightmmFile,
			File leftmFile,
			File rightmFile,
			File transfFile,
			File traceFile) {
		this.leftmmFile = leftmmFile;
		this.rightmmFile = rightmmFile;
		this.leftmFile = leftmFile;
		this.rightmFile = rightmFile;
		this.transfFile = transfFile;
		this.traceFile = traceFile;
		launcher = new ASPExogenousLauncher(
				leftmmFile, rightmmFile, leftmFile, rightmFile, transfFile);
	}

	public void launch() {
		// TODO define and use a new launchFilesChanged method
		// that will check also the right model

		// Process the left metamodel
		launcher.processSourceMetamodel();

		// Process the right metamodel
		final String targetmmName = launcher.processTargetMetamodel();

		// Process the left model
		launcher.processSourceModel();

		// Process the right model
		processRightModel();

		// Generate the transformation
		generateTransformation(targetmmName);

		// TODO Dump launch information
		// dumpLaunchConfiguration();

		// Write the ASP to file
		launcher.writeASPToFile();

		// Run the solver
		File traceModel = null;
		try {
			traceModel = launcher.getSolver().runTraceability(launcher.getTransfFile(), traceFile);

			// Process the trace model
			if (traceModel != null) {
				processTraceModel(traceModel);
			} else {
				// TODO alert the user
			}
		} catch (JASPException | IOException | URISyntaxException | ATLCoreException e) {
			// TODO alert the user
			e.printStackTrace();
		}
	}

	protected void generateTransformation(String targetmmName) {
		launcher.generateTransformation(targetmmName);
	}

	public void processRightModel() {
		// Ecore to ASPm (ATL generated from HOT)
		final String rightmASPm = launcher.modelEcoreToASPm(rightmmFile, rightmFile);
		// Transform ASPm back to Ecore to store the generated ASP ID in the original model
		launcher.modelASPmToEcore(rightmmFile, new File(rightmASPm));
		// ASPm model to text (EMFText)
		final File rightmASPmFile =
					launcher.emftextModelToText(rightmASPm, "\n%%% TARGET MODEL %%%\n");
		// Remove the temporarily created file
		launcher.removeFile(rightmASPmFile);
	}

	public void processTraceModel(final File traceFile) throws IOException, ATLCoreException {
		// Register the traceability metamodel
		RegisterMetamodel.registerMetamodel(
				new it.univaq.jtl.atl.aspt2tracemodel.ASPT2TraceModel()
					.getMetamodelUri("ASPT"));


		// Convert the ASP trace models (text2model)
		final File traceFileModel = launcher.emftextTextToModel(traceFile);

		// ASPT to Ecore
		ASPT2TraceModel.runTransformation(traceFileModel, leftmFile, rightmFile);

		// Remote the .aspt.ecore file
		launcher.removeFile(traceFileModel);

		// Remove the .aspt file
		//launcher.removeFile(traceFile);
	}
}
