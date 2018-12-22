package jtl.transformations;

import java.io.File;
import java.io.IOException;

import org.eclipse.m2m.atl.core.ATLCoreException;

import jtl.utils.Files;

public class ASPT2TraceModel {

	public static String runTransformation(
			final File mIn,
			final File sourceIn,
			final File targetIn)
					throws IOException, ATLCoreException {

		// Model path
		final String mInPath = mIn.getPath();

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
				sourceIn.getPath(),
				targetIn.getPath(),
				targetFile
		});

		return targetFile;
	}
}
