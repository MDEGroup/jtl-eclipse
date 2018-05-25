package jtl.transformations;

import java.io.File;
import java.io.IOException;

import org.eclipse.m2m.atl.core.ATLCoreException;

import jtl.utils.Files;

public class TraceModel2ASPT {

	public static String runTransformation(final File mIn)
			throws IOException, ATLCoreException {

		// Model path
		final String mInPath = mIn.getPath();

		// Generate the target filename
		final String targetFile = Files.addFileExtension(
				Files.removeFileExtension(mInPath) , "aspt.ecore");

		// Register the ASPm metamodel
		RegisterMetamodel.registerMetamodel(new File(
				new it.univaq.jtl.atl.tracemodel2aspt.TraceModel2ASPT()
					.getMetamodelUri("ASPT")));

		// Perform the transformation (ASPT to TraceModel)
		it.univaq.jtl.atl.tracemodel2aspt.TraceModel2ASPT.main(new String[] {
				mInPath,
				targetFile
		});

		return targetFile;
	}
}
