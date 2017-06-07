package jtl.transformations;

import java.io.File;
import java.io.IOException;

import org.eclipse.m2m.atl.core.ATLCoreException;

public class MM2ASPm {

	public static String runTransformation(final File mmIn, final File mIn)
			throws IOException, ATLCoreException {

		// Model path
		final String mInPath = mIn.getPath();

		// Generate the target filename
		final String targetFile = mInPath.substring(
				0, mInPath.lastIndexOf(".xmi")) + ".aspm.ecore";

		// Register the ASPm metamodel
		RegisterMetamodel.registerMetamodel(new File(
				new it.univaq.jtl.atl.mm2aspm.MM2ASPmGenerator()
					.getMetamodelUri("ASPm")));

		// Perform the transformation (Ecore model to ASPm)
		it.univaq.jtl.atl.mm2aspm.MM2ASPmGenerator.main(new String[] {
				mmIn.getPath(),
				mInPath,
				targetFile
		});

		return targetFile;
	}
}
