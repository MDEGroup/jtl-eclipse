package jtl.transformations;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import jtl.utils.Files;

import org.eclipse.emf.ecore.EPackage;

/**
 * Perform model2text or text2model transformations using
 * EMFText generated factories and parsers.
 */
public class EmftextConverter {

	private static String ASPMM_URI = "http://jtl.univaq.it/aspmm";
	private static String ASPM_URI = "http://jtl.univaq.it/aspm";
	private static String ASP_URI = "http://jtl.univaq.it/asp";

	/**
	 * Perform a model2text or text2model transformation
	 * from file to file.
	 * @param file file to be transformed
	 * @return path of the target file
	 */
	public String convert(final File file) {

		Resource dslResource = doConvert(file);

		// Save the dsl resource (this will automatically use the <DSL>Printer)
		try {
			dslResource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return dslResource.getURI().toString();
	}

	/**
	 * Perform a model2tetx or text2model transformation
	 * from file to OutputStream.
	 * @param file file to be transformed
	 * @param out OutputStream to be used as target of the transformation
	 */
	public void convert(final File file, final OutputStream out) {

		Resource dslResource = doConvert(file);

		// Save the dsl resource (this will automatically use the <DSL>Printer)
		try {
			dslResource.save(out, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Register the DSL factories and create the necessary resources
	 * to perform model2text or text2model transformations.
	 * @param file file to be transformed
	 * @return the resource target of the transformation
	 */
	private Resource doConvert(final File file) {

		// Register XMI resource factory for all other extensions
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap()
				.put(Resource.Factory.Registry.DEFAULT_EXTENSION,
						new XMIResourceFactoryImpl());

		// Then you can load and save resources in the different
		// formats using a resource set:
		ResourceSet rs = new ResourceSetImpl();

		// Dispatch the ResourceFactory registration to specific factories
		Resource targetResource = dispatchResource(file, rs);
		Resource sourceResource = rs.getResource(URI.createURI(file.getPath()), true);

		// Transfer content from XMI to DSL resource
		targetResource.getContents().addAll(sourceResource.getContents());

		return targetResource;
	}

	/**
	 * Dispatch the ResourceFactory registration to specific factories.
	 * @param file file to convert
	 * @param rs ResourceSet for resource creation
	 * @return the target resource
	 */
	private Resource dispatchResource(final File file, final ResourceSet rs) {

		// The new resource to create
		Resource resource = null;

		// Get file location on filesystem
		String location = file.getPath();

		// Get the file extension
		String extension = Files.getFileExtension(location);

		if (extension.equals("ecore") || extension.equals("xmi")) {
			// model2text

			registerResourceFactory(registerEPackage(location));

			resource = rs.getResource(URI.createURI(location), true);

			final EObject root = resource.getContents().get(0);

			if (root instanceof ASP.impl.TransformationImpl) {
				// ASP
				resource = createDslResource(rs, location, "ASP");

			} else if (root instanceof ASPM.impl.ModelImpl) {
				// ASPM
				resource = createDslResource(rs, location, "ASPM");

			} else if (root instanceof ASPMM.impl.MetamodelImpl) {
				// ASPMM
				resource = createDslResource(rs, location, "ASPMM");

			} else if (root instanceof JTL.JTL.impl.TransformationImpl) {
				// JTLMM
				resource = createDslResource(rs, location, "JTL");
			}
		} else {
			// text2model
			registerResourceFactory(extension);
			resource = createDslResource(rs, location, extension);
			EPackage.Registry.INSTANCE.remove("http://jtl.univaq.it/" + extension);
		}

		return resource;
	}

	/**
	 * Return the ResourceFactory corresponding to the DSL.
	 * @param dsl DSL name
	 * @return ResourceFactory instance
	 */
	private Object getResourceFactory(final String dsl) {
		// The DSL specific ResourceFactory class object
		Object dslResourceFactory = null;
		try {
			dslResourceFactory = Class.forName(
					String.format("%s.resource.%s.mopp.%sResourceFactory",
							dsl.toUpperCase(),
							dsl.toLowerCase(),
							dsl.substring(0, 1).toUpperCase() + dsl.substring(1).toLowerCase()))
					.newInstance();
		} catch (InstantiationException
				| IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}
		return dslResourceFactory;
	}

	/**
	 * Register a DSL specific ResourceFactory.
	 * @param dsl DSL name
	 */
	private void registerResourceFactory(final String dsl) {

		// Register <DSL>ResourceFactory for "<DSL>" file extension
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap()
					.put(dsl.toLowerCase(), getResourceFactory(dsl));
	}

	/**
	 * Register the EPackage implementation specific to the given file.
	 * @param file file on which the EPackage will be used
	 * @return package extension
	 */
	private String registerEPackage(final String file) {
		if (file.endsWith(".aspmm.ecore")) {
			if (!(EPackage.Registry.INSTANCE.getEPackage(ASPMM_URI)
					instanceof ASPMM.impl.ASPMMPackageImpl)) {
				EPackage.Registry.INSTANCE.remove(ASPMM_URI);
				EPackage.Registry.INSTANCE.put(ASPMM_URI, ASPMM.ASPMMPackage.eINSTANCE);
			}
			return "aspmm";
		} else if (file.endsWith(".aspm.ecore")) {
			if (!(EPackage.Registry.INSTANCE.getEPackage(ASPM_URI)
					instanceof ASPM.impl.ASPMPackageImpl)) {
				EPackage.Registry.INSTANCE.remove(ASPM_URI);
				EPackage.Registry.INSTANCE.put(ASPM_URI, ASPM.ASPMPackage.eINSTANCE);
			}
			return "aspm";
		} else if (file.endsWith(".asp.ecore")) {
			if (!(EPackage.Registry.INSTANCE.getEPackage(ASP_URI)
					instanceof ASP.impl.ASPPackageImpl)) {
				EPackage.Registry.INSTANCE.remove(ASP_URI);
				EPackage.Registry.INSTANCE.put(ASP_URI, ASP.ASPPackage.eINSTANCE);
			}
			return "asp";
		}
		return "";
	}

	/**
	 * Create an new resource from a DSL ResourceFactory.
	 * @param rs ResourceSet for resource creation
	 * @param location resource file location
	 * @param dsl DSL name
	 * @return the new resource
	 */
	private Resource createDslResource(
			final ResourceSet rs,
			final String location,
			final String dsl) {

		// File extension of the location
		final String extension = Files.getFileExtension(location);

		// Sanitize URI paths
		final String fileLocation = location.startsWith("file:/") ? location.substring(5) : location;

		// The new resource to create
		Resource dslResource = null;

		// Create an empty DSL resource
		// (will be an instance of <DSL>Resource)
		if (extension.equals("ecore") || extension.equals("xmi")) {
			// model2text
			dslResource = rs.createResource(URI.createURI(
					Files.removeFileExtension(
					Files.removeFileExtension(fileLocation)) +
					'.' + dsl.toLowerCase()
				));
		} else if (extension.equals(dsl.toLowerCase())) {
			// text2model
			dslResource = rs.createResource(URI.createURI(
					Files.removeFileExtension(fileLocation) +
					'.' + dsl.toLowerCase() + ".ecore"
				));
		}

		return dslResource;
	}
}
