package jtl.transformations;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

public class RegisterMetamodel {

	public static void registerMetamodel(final File file) {
		ResourceSet rs = new ResourceSetImpl();
		final String path = file.getPath();
		registerResource(rs.getResource(
				(file.exists()) ?
				URI.createFileURI(path) :
				URI.createURI(path)
			, true));
	}

	public static void registerMetamodel(final String uri) {
		ResourceSet rs = new ResourceSetImpl();
		registerResource(rs.getResource(URI.createURI(uri), true));
	}

	private static void registerResource(final Resource resource) {
		// Get the EPackage element
		EObject mmPackage = resource.getContents().get(0);

		// Register the metamodel namespace URI
		if (mmPackage.eClass().getName().equals("EPackage")) {
			EPackage p = (EPackage) mmPackage;
			String nsURI = p.getNsURI();
			if (nsURI == null) {
				nsURI = p.getName();
				p.setNsURI(nsURI);
			}
			EPackage.Registry.INSTANCE.put(nsURI, p);
		}
	}
}
