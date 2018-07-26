package jtl.launcher;

import java.io.File;

public abstract class AbstractExogenousLauncher extends AbstractJTLLauncher {

	/**
	 * Default constructor to be used by implementing classes.
	 * @param sourcemmFile source metamodel file
	 * @param targetmmFile target metamodel file
	 * @param sourcemFile source model file
	 * @param targetmFolder folder where to save generated target models
	 * @param transfFile file specifying the transformation
	 */
	public AbstractExogenousLauncher(
			final File sourcemmFile,
			final File targetmmFile,
			final File sourcemFile,
			final File targetmFolder,
			final File transfFile) {
		super(sourcemmFile, targetmmFile, sourcemFile, targetmFolder, transfFile);
	}

	/**
	 * Default constructor to be used by implementing classes.
	 * @param sourcemmFile source metamodel file
	 * @param targetmmFile target metamodel file
	 * @param sourcemFile source model file
	 * @param targetmFolder folder where to save generated target models
	 * @param transfFile file specifying the transformation
	 * @param tracesFile traces model file
	 */
	public AbstractExogenousLauncher(
			final File sourcemmFile,
			final File targetmmFile,
			final File sourcemFile,
			final File targetmFolder,
			final File transfFile,
			final File tracesFile) {
		super(sourcemmFile, targetmmFile, sourcemFile, targetmFolder, transfFile, tracesFile);
	}

	/**
	 * Process the source metamodel to generate the corresponding ASP code.
	 */
	@Override
	public void processSourceMetamodel() {
		// Ecore to ASPmm (ATL)
		final String sourcemmASPmm = metamodelEcoreToASPmm(sourcemmFile);
		// ASPmm model to text (EMFText)
		final File sourcemmASPmmFile =
					emftextModelToText(sourcemmASPmm, "%%% SOURCE METAMODEL %%%\n");
		// Remove the temporarily created file
		removeFile(sourcemmASPmmFile);
	}

	/**
	 * Process the target metamodel to generate the corresponding ASP code.
	 * @return name of the target metamodel
	 */
	@Override
	public String processTargetMetamodel() {
		// Ecore to ASPmm (ATL)
		final String targetmmASPmm = metamodelEcoreToASPmm(targetmmFile);
		// Get the name of the target metamodel
		final String targetmmName = getMetamodelName(targetmmASPmm);
		// ASPmm model to text (EMFText)
		final File targetmmASPmmFile =
				emftextModelToText(targetmmASPmm, "\n%%% TARGET METAMODEL %%%\n");
		// Remove the temporarily created file
		removeFile(targetmmASPmmFile);

		return targetmmName;
	}

	/**
	 * Process the source model to generate the corresponding ASP code.
	 */
	@Override
	public void processSourceModel() {
		// Ecore to ASPm (ATL generated from HOT)
		final String sourcemASPm = modelEcoreToASPm(sourcemmFile, sourcemFile);
		// Transform ASPm back to Ecore to store the generated ASP ID in the original model
		modelASPmToEcore(sourcemmFile, new File(sourcemASPm));
		// ASPm model to text (EMFText)
		final File sourcemASPmFile =
					emftextModelToText(sourcemASPm, "\n%%% SOURCE MODEL %%%\n");
		// Remove the temporarily created file
		removeFile(sourcemASPmFile);
	}

	/**
	 * Process the traces model to generate the corresponding ASP code.
	 */
	@Override
	public void processTracesModel() {
		if (tracesFile == null) return;
		// Ecore to ASPT (ATL)
		final String traceASPm = modelEcoreToASPT(tracesFile);
		// ASPT model to text (EMFText)
		final File traceASPTFile =
				emftextModelToText(traceASPm, "\n%%% TRACE MODEL %%%\n");
		// Remove the temporarily created file
		removeFile(traceASPTFile);
	}
}
