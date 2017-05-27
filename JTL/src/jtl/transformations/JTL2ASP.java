package jtl.transformations;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.m2m.atl.core.ATLCoreException;

public class JTL2ASP {

	public static String runTransformation(IFile file) 
			throws IOException, ATLCoreException {
		// Register XMI resource factory for all other extensions
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap()
		.put(Resource.Factory.Registry.DEFAULT_EXTENSION,
				new XMIResourceFactoryImpl());

		// Then you can load and save resources in the different 
		// formats using a resource set:
		ResourceSet rs = new ResourceSetImpl();

		// Load xmi resource
		Resource xmiResource = rs.getResource(
				URI.createURI(file.getFullPath().toString()), true);

		// Check if the ecore looks like a JTL model
		if (xmiResource.getContents().get(0) 
				instanceof JTL.JTL.impl.TransformationImpl) {

			// Generate the target filename
			String targetFile = file.getFullPath()
					.removeFileExtension()
					.addFileExtension("ASP.ecore")
					.toString();

			// Perform the transformation (JTL to ASP)
			it.univaq.jtl.atl.jtl2asp.JTL2ASP.main(new String[] {
					file.getFullPath().toString(),
					targetFile
			});
			
			return targetFile;
		} else {
			System.out.println("This is not a JTL model. Found:");
			System.out.println(xmiResource.getContents().get(0));
			return null;
		}
	}
}
