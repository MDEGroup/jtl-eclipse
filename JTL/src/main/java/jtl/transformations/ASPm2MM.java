package jtl.transformations;

import java.io.IOException;

import org.eclipse.m2m.atl.core.ATLCoreException;

import jtl.utils.Files;

public class ASPm2MM {

	public static String runTransformation(final String mmIn, final String mIn)
			throws IOException, ATLCoreException {

		// Model path
		final String mInPath = mIn;

		// Generate the target filename
		final String targetFile = Files.addFileExtension(
				Files.removeFileExtension(
				Files.removeFileExtension(mInPath)), "xmi");

		// Register the ASPm metamodel
		RegisterMetamodel.registerMetamodel(
				new it.univaq.jtl.atl.aspm2mm.ASPm2MMGenerator()
					.getMetamodelUri("ASPm"));

		// Register the input metamodel
		RegisterMetamodel.registerMetamodel(mmIn);

		// Perform the transformation (ASPm to Ecore model)
		it.univaq.jtl.atl.aspm2mm.ASPm2MMGenerator.main(new String[] {
				mmIn,
				mInPath,
				targetFile
		});

		return targetFile;
	}
}
