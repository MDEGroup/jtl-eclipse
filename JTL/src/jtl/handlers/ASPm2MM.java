package jtl.handlers;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.m2m.atl.core.ATLCoreException;

public class ASPm2MM {

	public static String runTransformation(IFile mmIn, IFile mIn) 
			throws IOException, ATLCoreException {

		// Generate the target filename
		String targetFile = mIn.getFullPath()
				.removeFileExtension()
				.removeFileExtension()
				.addFileExtension("ecore")
				.toString();

		// Perform the transformation (ASPm to Ecore model)
		it.univaq.jtl.atl.aspm2mm.ASPm2MMGenerator.main(new String[] {
				mmIn.getFullPath().toString(),
				mIn.getFullPath().toString(),
				targetFile
		});
		
		return targetFile;
	}
}
