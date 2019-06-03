package jtl.transformations;

import java.io.IOException;

import org.eclipse.m2m.atl.core.ATLCoreException;

import jtl.utils.Files;

public class MM2ASPm {

	public static String runTransformation(final String mmIn, final String mIn)
			throws IOException, ATLCoreException {

		// Model path
		final String mInPath = mIn;

		// Generate the target filename
		final String targetFile = Files.addFileExtension(
				Files.removeFileExtension(mInPath) , "aspm.ecore");

		// Register the ASPm metamodel
		RegisterMetamodel.registerMetamodel(
				new it.univaq.jtl.atl.mm2aspm.MM2ASPmGenerator()
					.getMetamodelUri("ASPm"));

		// Perform the transformation (Ecore model to ASPm)
		it.univaq.jtl.atl.mm2aspm.MM2ASPmGenerator.main(new String[] {
				mmIn,
				mInPath,
				targetFile
		});

		return targetFile;
	}
}
