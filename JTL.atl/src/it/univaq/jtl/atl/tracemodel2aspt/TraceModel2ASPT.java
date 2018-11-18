/*******************************************************************************
 * Copyright (c) 2010, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package it.univaq.jtl.atl.tracemodel2aspt;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.m2m.atl.common.ATLExecutionException;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IExtractor;
import org.eclipse.m2m.atl.core.IInjector;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.core.ModelFactory;
import org.eclipse.m2m.atl.core.emf.EMFExtractor;
import org.eclipse.m2m.atl.core.emf.EMFInjector;
import org.eclipse.m2m.atl.core.emf.EMFModelFactory;
import org.eclipse.m2m.atl.core.launch.ILauncher;
import org.eclipse.m2m.atl.engine.emfvm.launch.EMFVMLauncher;

/**
 * Entry point of the 'TraceModel2ASPT' transformation module.
 */
public class TraceModel2ASPT {

	/**
	 * The property file. Stores module list, the metamodel and library locations.
	 * @generated
	 */
	private Properties properties;

	/**
	 * The IN model.
	 * @generated
	 */
	protected IModel inModel;

	/**
	 * The OUT model.
	 * @generated
	 */
	protected IModel outModel;

	/**
	 * The main method.
	 *
	 * @param args
	 *            are the arguments
	 * @generated
	 */
	public static void main(String[] args) {
		try {
			if (args.length < 2) {
				System.out.println("Arguments not valid : {IN_model_path, OUT_model_path}.");
			} else {
				TraceModel2ASPT runner = new TraceModel2ASPT();
				runner.loadModels(args[0]);
				runner.doTraceModel2ASPT(new NullProgressMonitor());
				runner.saveModels(args[1]);
			}
		} catch (ATLCoreException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ATLExecutionException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Constructor.
	 *
	 * @generated
	 */
	public TraceModel2ASPT() throws IOException {
		properties = new Properties();
		properties.load(getFileURL("TraceModel2ASPT.properties").openStream());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
	}

	/**
	 * Load the input and input/output models, initialize output models.
	 *
	 * @param inModelPath
	 *            the IN model path
	 * @throws ATLCoreException
	 *             if a problem occurs while loading models
	 *
	 * @generated
	 */
	public void loadModels(String inModelPath) throws ATLCoreException {
		ModelFactory factory = new EMFModelFactory();
		IInjector injector = new EMFInjector();
	 	IReferenceModel tracemodelMetamodel = factory.newReferenceModel();
		injector.inject(tracemodelMetamodel, getMetamodelUri("TraceModel"));
	 	IReferenceModel asptMetamodel = factory.newReferenceModel();
		injector.inject(asptMetamodel, getMetamodelUri("ASPT"));
		this.inModel = factory.newModel(tracemodelMetamodel);
		injector.inject(inModel, inModelPath);
		this.outModel = factory.newModel(asptMetamodel);
	}

	/**
	 * Save the output and input/output models.
	 *
	 * @param outModelPath
	 *            the OUT model path
	 * @throws ATLCoreException
	 *             if a problem occurs while saving models
	 *
	 * @generated
	 */
	public void saveModels(String outModelPath) throws ATLCoreException {
		IExtractor extractor = new EMFExtractor();
		extractor.extract(outModel, outModelPath);
	}

	/**
	 * Transform the models.
	 *
	 * @param monitor
	 *            the progress monitor
	 * @throws ATLCoreException
	 *             if an error occurs during models handling
	 * @throws IOException
	 *             if a module cannot be read
	 * @throws ATLExecutionException
	 *             if an error occurs during the execution
	 *
	 * @generated
	 */
	public Object doTraceModel2ASPT(IProgressMonitor monitor) throws ATLCoreException, IOException, ATLExecutionException {
		ILauncher launcher = new EMFVMLauncher();
		Map<String, Object> launcherOptions = getOptions();
		launcher.initialize(launcherOptions);
		launcher.addInModel(inModel, "IN", "TraceModel");
		launcher.addOutModel(outModel, "OUT", "ASPT");
		return launcher.launch("run", monitor, launcherOptions, (Object[]) getModulesList());
	}

	/**
	 * Returns an Array of the module input streams, parameterized by the
	 * property file.
	 *
	 * @return an Array of the module input streams
	 * @throws IOException
	 *             if a module cannot be read
	 *
	 * @generated
	 */
	protected InputStream[] getModulesList() throws IOException {
		InputStream[] modules = null;
		String modulesList = properties.getProperty("TraceModel2ASPT.modules");
		if (modulesList != null) {
			String[] moduleNames = modulesList.split(",");
			modules = new InputStream[moduleNames.length];
			for (int i = 0; i < moduleNames.length; i++) {
				String asmModulePath = new Path(moduleNames[i].trim()).removeFileExtension().addFileExtension("asm").toString();
				modules[i] = getFileURL(asmModulePath).openStream();
			}
		}
		return modules;
	}

	/**
	 * Returns the URI of the given metamodel, parameterized from the property file.
	 *
	 * @param metamodelName
	 *            the metamodel name
	 * @return the metamodel URI
	 */
	public String getMetamodelUri(String metamodelName) {
		String uriString = properties.getProperty("TraceModel2ASPT.metamodels." + metamodelName);
		try {
			new EMFModelFactory().getResourceSet().getResource(URI.createURI(uriString), true);
		} catch (Exception e) {
			if (TraceModel2ASPT.class.getResource("TraceModel2ASPT.class").toString().startsWith("jar:")) {
				return TraceModel2ASPT.class.getResource(uriString.replaceFirst("platform:/plugin/JTL.atl", "")).toString();
			}
			return uriString.replaceFirst("platform:/plugin", "..");
		}
		return uriString;
	}

	/**
	 * Returns the file name of the given library, parameterized from the property file.
	 *
	 * @param libraryName
	 *            the library name
	 * @return the library file name
	 *
	 * @generated
	 */
	protected InputStream getLibraryAsStream(String libraryName) throws IOException {
		return getFileURL(properties.getProperty("TraceModel2ASPT.libraries." + libraryName)).openStream();
	}

	/**
	 * Returns the options map, parameterized from the property file.
	 *
	 * @return the options map
	 *
	 * @generated
	 */
	protected Map<String, Object> getOptions() {
		Map<String, Object> options = new HashMap<String, Object>();
		for (Entry<Object, Object> entry : properties.entrySet()) {
			if (entry.getKey().toString().startsWith("TraceModel2ASPT.options.")) {
				options.put(entry.getKey().toString().replaceFirst("TraceModel2ASPT.options.", ""),
				entry.getValue().toString());
			}
		}
		return options;
	}

	/**
	 * Finds the file in the plug-in. Returns the file URL.
	 *
	 * @param fileName
	 *            the file name
	 * @return the file URL
	 * @throws IOException
	 *             if the file doesn't exist
	 *
	 * @generated
	 */
	protected static URL getFileURL(String fileName) throws IOException {
		final URL fileURL;
		if (isEclipseRunning()) {
			URL resourceURL = TraceModel2ASPT.class.getResource(fileName);
			if (resourceURL != null) {
				fileURL = FileLocator.toFileURL(resourceURL);
			} else {
				fileURL = null;
			}
		} else {
			fileURL = TraceModel2ASPT.class.getResource(fileName);
		}
		if (fileURL == null) {
			throw new IOException("'" + fileName + "' not found");
		} else {
			return fileURL;
		}
	}

	/**
	 * Tests if eclipse is running.
	 *
	 * @return <code>true</code> if eclipse is running
	 *
	 * @generated
	 */
	public static boolean isEclipseRunning() {
		try {
			return Platform.isRunning();
		} catch (Throwable exception) {
			// Assume that we aren't running.
		}
		return false;
	}
}
