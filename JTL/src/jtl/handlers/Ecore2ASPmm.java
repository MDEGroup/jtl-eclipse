package jtl.handlers;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.m2m.atl.core.ATLCoreException;

public class Ecore2ASPmm {

	public static String runTransformation(IFile file) 
			throws IOException, ATLCoreException {

		// Generate the target filename
		String targetFile = file.getFullPath()
				.removeFileExtension()
				.addFileExtension("ASPmm.ecore")
				.toString();

		// Perform the transformation (Ecore to ASPmm)
		it.univaq.jtl.atl.ecore2aspmm.Ecore2ASPmm.main(new String[] {
				file.getFullPath().toString(),
				targetFile
		});
		
		return targetFile;
	}
}
