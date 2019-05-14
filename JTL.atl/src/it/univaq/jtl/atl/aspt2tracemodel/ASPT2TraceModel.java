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
package it.univaq.jtl.atl.aspt2tracemodel;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
 * Entry point of the 'ASPT2TraceModel' transformation module.
 */
public class ASPT2TraceModel {

	/** Logger */
	private static Logger logger = LogManager.getLogger(ASPT2TraceModel.class);

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
	 * The Source model.
	 * @generated
	 */
	protected IModel sourceModel;

	/**
	 * The Target model.
	 * @generated
	 */
	protected IModel targetModel;

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
	 */
	public static void main(String[] args) {
		try {
			if (args.length < 4) {
				logger.error("Arguments not valid : {IN_model_path, Source_model_path, Target_model_path, OUT_model_path}.");
			} else {
				ASPT2TraceModel runner = new ASPT2TraceModel();
				runner.loadModels(args[0], args[1], args[2]);
				runner.doASPT2TraceModel(new NullProgressMonitor());
				runner.saveModels(args[3]);
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
	public ASPT2TraceModel() throws IOException {
		properties = new Properties();
		properties.load(getFileURL("ASPT2TraceModel.properties").openStream());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
	}

	/**
	 * Load the input and input/output models, initialize output models.
	 *
	 * @param inModelPath
	 *            the IN model path
	 * @param sourceModelPath
	 *            the Source model path
	 * @param targetModelPath
	 *            the Target model path
	 * @throws ATLCoreException
	 *             if a problem occurs while loading models
	 *
	 * @generated
	 */
	public void loadModels(String inModelPath, String sourceModelPath, String targetModelPath) throws ATLCoreException {
		ModelFactory factory = new EMFModelFactory();
		IInjector injector = new EMFInjector();
	 	IReferenceModel tracemodelMetamodel = factory.newReferenceModel();
		injector.inject(tracemodelMetamodel, getMetamodelUri("TraceModel"));
	 	IReferenceModel asptMetamodel = factory.newReferenceModel();
		injector.inject(asptMetamodel, getMetamodelUri("ASPT"));
		IReferenceModel ecoreMetamodel = factory.getMetametamodel();
		this.inModel = factory.newModel(asptMetamodel);
		injector.inject(inModel, inModelPath);
		this.sourceModel = factory.newModel(ecoreMetamodel);
		injector.inject(sourceModel, sourceModelPath);
		this.targetModel = factory.newModel(ecoreMetamodel);
		injector.inject(targetModel, targetModelPath);
		this.outModel = factory.newModel(tracemodelMetamodel);
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
	public Object doASPT2TraceModel(IProgressMonitor monitor) throws ATLCoreException, IOException, ATLExecutionException {
		ILauncher launcher = new EMFVMLauncher();
		Map<String, Object> launcherOptions = getOptions();
		launcher.initialize(launcherOptions);
		launcher.addInModel(inModel, "IN", "ASPT");
		launcher.addInModel(sourceModel, "Source", "ECORE");
		launcher.addInModel(targetModel, "Target", "ECORE");
		launcher.addOutModel(outModel, "OUT", "TraceModel");
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
		String modulesList = properties.getProperty("ASPT2TraceModel.modules");
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
		String uriString = properties.getProperty("ASPT2TraceModel.metamodels." + metamodelName);
		try {
			new EMFModelFactory().getResourceSet().getResource(URI.createURI(uriString), true);
		} catch (Exception e) {
			if (ASPT2TraceModel.class.getResource("ASPT2TraceModel.class").toString().startsWith("jar:")) {
				return ASPT2TraceModel.class.getResource(uriString.replaceFirst("platform:/plugin/JTL.atl", "")).toString();
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
		return getFileURL(properties.getProperty("ASPT2TraceModel.libraries." + libraryName)).openStream();
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
			if (entry.getKey().toString().startsWith("ASPT2TraceModel.options.")) {
				options.put(entry.getKey().toString().replaceFirst("ASPT2TraceModel.options.", ""), 
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
			URL resourceURL = ASPT2TraceModel.class.getResource(fileName);
			if (resourceURL != null) {
				fileURL = FileLocator.toFileURL(resourceURL);
			} else {
				fileURL = null;
			}
		} else {
			fileURL = ASPT2TraceModel.class.getResource(fileName);
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
