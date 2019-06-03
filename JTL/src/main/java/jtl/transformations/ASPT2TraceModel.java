package jtl.transformations;

import java.io.IOException;

import org.eclipse.m2m.atl.core.ATLCoreException;

import jtl.utils.Files;

public class ASPT2TraceModel {

	public static String runTransformation(
			final String mIn,
			final String sourceIn,
			final String targetIn)
					throws IOException, ATLCoreException {

		// Model path
		final String mInPath = mIn;

		// Generate the target filename
		final String targetFile = Files.addFileExtension(
				Files.removeFileExtension(
				Files.removeFileExtension(mInPath)) , "xmi");

		// Register the ASPm metamodel
		RegisterMetamodel.registerMetamodel(
				new it.univaq.jtl.atl.aspt2tracemodel.ASPT2TraceModel()
					.getMetamodelUri("TraceModel"));

		// Perform the transformation (ASPT to TraceModel)
		it.univaq.jtl.atl.aspt2tracemodel.ASPT2TraceModel.main(new String[] {
				mInPath,
				sourceIn,
				targetIn,
				targetFile
		});

		return targetFile;
	}
}
