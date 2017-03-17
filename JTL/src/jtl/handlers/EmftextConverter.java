package jtl.handlers;

import java.io.IOException;
import java.io.OutputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

/**
 * TODO comment
 *
 */
public class EmftextConverter {
	
	public String convert(IFile file) {
		
		Resource dslResource = doConvert(file);
		
		// Save the dsl resource (this will automatically use the <DSL>Printer)
		try {
			dslResource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		return dslResource.getURI().toString();
	}
	
	public void convert(IFile file, OutputStream out) {
		
		Resource dslResource = doConvert(file);
		
		// Save the dsl resource (this will automatically use the <DSL>Printer)
		try {
			dslResource.save(out, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private Resource doConvert(IFile file) {
		
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
		
		// Perform the transformation
		Resource dslResource = 
				dispatch(file, rs, xmiResource.getContents().get(0));

		// Transfer content from XMI to DSL resource
		dslResource.getContents().addAll(xmiResource.getContents());
		
		return dslResource;
	}
	
	private Resource dispatch(IFile file, ResourceSet rs, EObject root) {
		
		// The new resource to create
		Resource dslResource = null;
		
		// Get file location on filesystem
		IPath location = file.getLocation();
		
		// Get the file extension
		String extension = location.getFileExtension();
		
		if (root instanceof ASP.impl.TransformationImpl) {
			// ASP
			return registerResources(rs, location, extension, "ASP");
			
		} else if (root instanceof ASPM.impl.ModelImpl) {
			// ASPM
			return registerResources(rs, location, extension, "ASPM");

		} else if (root instanceof ASPMM.impl.MetamodelImpl) {
			// ASPMM
			return registerResources(rs, location, extension, "ASPMM");

		} if (root instanceof JTL.JTL.impl.TransformationImpl) {
			// JTLMM
			return registerResources(rs, location, extension, "JTL");
		}
		
		return dslResource;
	}
	
	private Resource registerResources(
			ResourceSet rs, IPath location, String extension, String dsl) {
		
		// The new resource to create
		Resource dslResource = null;
		
		// The DSL specific ResourceFactory class object
		Object dslResourceFactory = null;
		try {
			dslResourceFactory = Class.forName(
					String.format("%s.resource.%s.mopp.%sResourceFactory", 
							dsl,
							dsl.toLowerCase(),
							dsl.charAt(0) + dsl.substring(1).toLowerCase()))
					.newInstance();
		} catch (InstantiationException 
				| IllegalAccessException 
				| ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// Register <DSL>ResourceFactory for "<DSL>" file extension
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap()
				.put(dsl.toLowerCase(), dslResourceFactory);
		
		// Create an empty DSL resource
		// (will be an instance of <DSL>Resource)
		if (extension.equals("ecore")) {
			// model2text
			dslResource = rs.createResource(URI.createFileURI(location
					.removeFileExtension().removeFileExtension()
					.addFileExtension(dsl.toLowerCase())
					.toString()));
		} else if (extension.equals(dsl.toLowerCase())) {
			// text2model
			dslResource = rs.createResource(URI.createFileURI(location
					.removeFileExtension()
					.addFileExtension(dsl.toLowerCase())
					.addFileExtension("ecore")
					.toString()));
		}
		
		return dslResource;
	}

}
