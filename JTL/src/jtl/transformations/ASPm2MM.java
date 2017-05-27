package jtl.transformations;

import java.io.File;
import java.io.IOException;

import org.eclipse.m2m.atl.core.ATLCoreException;

public class ASPm2MM {

	public static String runTransformation(final File mmIn, final File mIn)
			throws IOException, ATLCoreException {

		// Generate the target filename
		String targetFile = mIn.getPath().substring(
				0, mIn.getPath().lastIndexOf(".aspm.ecore")) + ".xmi";

		// Perform the transformation (ASPm to Ecore model)
		it.univaq.jtl.atl.aspm2mm.ASPm2MMGenerator.main(new String[] {
				mmIn.getPath(),
				mIn.getPath(),
				targetFile
		});

		return targetFile;
	}
}
