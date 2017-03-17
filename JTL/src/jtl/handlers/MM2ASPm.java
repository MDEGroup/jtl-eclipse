package jtl.handlers;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.m2m.atl.core.ATLCoreException;

public class MM2ASPm {

	public static String runTransformation(IFile mmIn, IFile mIn) 
			throws IOException, ATLCoreException {

		// Generate the target filename
		String targetFile = mIn.getFullPath()
				.removeFileExtension()
				.addFileExtension("aspm.ecore")
				.toString();

		// Perform the transformation (Ecore model to ASPm)
		it.univaq.jtl.atl.mm2aspm.MM2ASPmGenerator.main(new String[] {
				mmIn.getFullPath().toString(),
				mIn.getFullPath().toString(),
				targetFile
		});
		
		return targetFile;
	}
}
