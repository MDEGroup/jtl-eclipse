package jtl.transformations;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.m2m.atl.core.ATLCoreException;

import jtl.utils.Files;

public class JTL2ASP {

	/** Logger */
	private static Logger logger = LogManager.getLogger(JTL2ASP.class);

	public static String runTransformation(final File file)
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
				URI.createURI(file.getPath()), true);

		// Check if the ecore looks like a JTL model
		if (xmiResource.getContents().get(0)
				instanceof JTL.JTL.impl.TransformationImpl) {

			// File path
			final String path = file.getPath();

			// Generate the target filename
			final String targetFile = Files.addFileExtension(
					Files.removeFileExtension(path), "asp.ecore");

			// Perform the transformation (JTL to ASP)
			it.univaq.jtl.atl.jtl2asp.JTL2ASP.main(new String[] {
					path,
					targetFile
			});

			return targetFile;
		} else {
			logger.warn("This is not a JTL model. Found:" +
					xmiResource.getContents().get(0));
			return null;
		}
	}
}
