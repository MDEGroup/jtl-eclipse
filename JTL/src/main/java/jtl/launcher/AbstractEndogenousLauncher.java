package jtl.launcher;

public abstract class AbstractEndogenousLauncher extends AbstractJTLLauncher {


	private String sourcemmName;
	private String sourcemmASPmm;

	/**
	 * Default constructor to be used by implementing classes.
	 * @param sourcemmFile source metamodel file
	 * @param targetmmFile target metamodel file
	 * @param sourcemFile source model file
	 * @param targetmFolder folder where to save generated target models
	 * @param transfFile file specifying the transformation
	 */
	public AbstractEndogenousLauncher(
			final String sourcemmFile,
			final String sourcemFile,
			final String targetmFolder,
			final String transfFile) {
		super(sourcemmFile, sourcemmFile, sourcemFile, targetmFolder, transfFile);
	}

	/**
	 * Process the source metamodel to generate the corresponding ASP code.
	 * @param sourcemmFile source metamodel file
	 */
	@Override
	public void processSourceMetamodel() {
		// Ecore to ASPmm (ATL)
		sourcemmASPmm = metamodelEcoreToASPmm(sourcemmFile);
		// ASPmm model to text (EMFText)
		sourcemmName = getMetamodelName(sourcemmASPmm);
		// ASPmm model to text (EMFText)
		emftextModelToText(sourcemmASPmm,
							"%%% SOURCE METAMODEL %%%\n",
							sourcemmName,
							sourcemmName + "_source",
							asp);
	}

	/**
	 * Process the target metamodel to generate the corresponding ASP code.
	 * @param targetmmFile target metamodel file
	 * @return name of the target metamodel
	 */
	@Override
	public String processTargetMetamodel() {
		// ASPmm model to text (EMFText)
		final String targetmmASPmmFile = emftextModelToText(sourcemmASPmm,
							"\n%%% TARGET METAMODEL %%%\n",
							sourcemmName,
							sourcemmName + "_target",
							asp);
		// Remove the temporarily created file
		removeFile(targetmmASPmmFile);

		return sourcemmName;
	}

	/**
	 * Process the source model to generate the corresponding ASP code.
	 * @param sourcemmFile source metamodel file
	 * @param sourcemFile source model file
	 */
	@Override
	public void processSourceModel() {
		// Ecore to ASPm (ATL generated from HOT)
		final String sourcemASPm = modelEcoreToASPm(sourcemmFile, sourcemFile);
		// Transform ASPm back to Ecore to store the generated ASP ID in the original model
		modelASPmToEcore(sourcemmFile, sourcemASPm);
		// ASPm model to text (EMFText)
		final String sourcemASPmFile = emftextModelToText(sourcemASPm,
							"\n%%% SOURCE MODEL %%%\n",
							sourcemmName,
							sourcemmName + "_source",
							asp);
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
		emftextModelToText(traceASPm,
						"\n%%% TRACE MODEL %%%\n",
						sourcemmName,
						sourcemmName + "_source",
						asp);
	}
}
