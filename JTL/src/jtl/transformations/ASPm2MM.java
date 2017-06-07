package jtl.transformations;

import java.io.File;
import java.io.IOException;

import org.eclipse.m2m.atl.core.ATLCoreException;

public class ASPm2MM {

	public static String runTransformation(final File mmIn, final File mIn)
			throws IOException, ATLCoreException {

		// Model path
		final String mInPath = mIn.getPath();

		// Generate the target filename
		final String targetFile = mInPath.substring(
				0, mInPath.lastIndexOf(".aspm.ecore")) + ".xmi";

		// Register the ASPm metamodel
		RegisterMetamodel.registerMetamodel(new File(
				new it.univaq.jtl.atl.aspm2mm.ASPm2MMGenerator()
					.getMetamodelUri("ASPm")));

		// Perform the transformation (ASPm to Ecore model)
		it.univaq.jtl.atl.aspm2mm.ASPm2MMGenerator.main(new String[] {
				mmIn.getPath(),
				mInPath,
				targetFile
		});

		return targetFile;
	}
}
