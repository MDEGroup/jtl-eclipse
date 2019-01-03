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
package it.univaq.jtl.atl.aspm2mm;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.StreamHandler;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.apache.logging.log4j.LogManager;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.m2m.atl.common.ATLExecutionException;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IExtractor;
import org.eclipse.m2m.atl.core.IInjector;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.core.ModelFactory;
import org.eclipse.m2m.atl.core.emf.EMFExtractor;
import org.eclipse.m2m.atl.core.emf.EMFInjector;
import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.eclipse.m2m.atl.core.emf.EMFModelFactory;
import org.eclipse.m2m.atl.core.emf.EMFReferenceModel;
import org.eclipse.m2m.atl.core.launch.ILauncher;
import org.eclipse.m2m.atl.engine.compiler.AtlCompiler;
import org.eclipse.m2m.atl.engine.emfvm.launch.EMFVMLauncher;

/**
 * Entry point of the 'ASPm2MMGenerator' transformation module.
 */
public class ASPm2MMGenerator {

	/** Logger */
	private static org.apache.logging.log4j.Logger logger = LogManager.getLogger(ASPm2MMGenerator.class);

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

	protected IModel outModel;

	protected InputStream generated;

	protected String mmOut;
	protected String mmOutName;

	/**
	 * The main method.
	 *
	 * @param args
	 *            are the arguments
	 */
	public static void main(String[] args) {
		try {
			if (args.length < 3) {
				logger.error("Arguments not valid : {OUT_metamodel_path, IN_model_path, OUT_model_oath}.");
			} else {
				ASPm2MMGenerator runner = new ASPm2MMGenerator();
				runner.loadModels(args[0]);
				runner.mmOut = args[0];

				// The generated transformation

				// Since ATL is printing the generated transformation
                // to Standard Error we need to intercept it adding
                // a handler to the logger registered by ATL
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                Logger logger = Logger.getLogger("org.eclipse.m2m.atl");
                logger.setUseParentHandlers(false);
                Handler handler = new StreamHandler(baos, new SimpleFormatter());
                logger.addHandler(handler);
                PrintStream err = System.err;
                System.setErr(new PrintStream(new ByteArrayOutputStream()));

                // Run the HOT
                runner.doASPm2MMGenerator(new NullProgressMonitor());

                // Flush the handler before we can use the OutputStream
                handler.flush();

                // Remove log output in order to keep only the generated transformation
                runner.generated = new ByteArrayInputStream(baos.toString().replaceFirst("(?s).+?(?=--)", "").getBytes());
                if (ASPm2MMGenerator.logger.isDebugEnabled()) {
                	ASPm2MMGenerator.logger.debug("ASPm2MM generated ATL transformation:\n" +
                			baos.toString().replaceFirst("(?s).+?(?=--)", ""));
                }

                // Unregister the handler
                handler.setLevel(Level.OFF);
                logger.removeHandler(handler);
                System.setErr(err);

				// Detect the root element in the input metamodel
				// in order to get the URI for the injector
				EObject mmRoot = new ResourceSetImpl().getResource(URI.createURI(args[0]), true).getContents().get(0);
				EStructuralFeature name = mmRoot.eClass().getEStructuralFeature("name");
				runner.mmOutName = mmRoot.eGet(name).toString();

				// Load the models to apply the generated transformation
				runner.genLoadModels(args[1]);

				// Launch the generated transformation
				runner.doASPm2MM(new NullProgressMonitor());

				// Try to set values of types not supported by ATL
				runner.setMissingValues();

				// Save the target model of the generated transformation
				runner.saveModels(args[2]);
			}
		} catch (ATLCoreException e) {
			// TODO print the generated transformation on ATL errors
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
	public ASPm2MMGenerator() throws IOException {
		properties = new Properties();
		properties.load(getFileURL("ASPm2MMGenerator.properties").openStream());
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
		IReferenceModel ecoreMetamodel = factory.getMetametamodel();
		this.inModel = factory.newModel(ecoreMetamodel);
		injector.inject(inModel, inModelPath);
	}

	public void genLoadModels(String inModelPath) throws ATLCoreException {
		ModelFactory factory = new EMFModelFactory();
		ModelFactory xmifactory = new EMFModelFactory() {
			@Override
			public IModel newModel(IReferenceModel referenceModel) {
				return new EMFModel((EMFReferenceModel)referenceModel, this) {
					@Override
					public Object newElement(Object metaElement) {
						Resource mainResource = getResource();
						if (mainResource == null) {
							mainResource = new XMIResourceImpl(URI.createURI("new-model")) {
								@Override
								protected boolean useUUIDs() {
									return true;
								}
							};
							setResource(mainResource);
						}
						EClass ec = (EClass)metaElement;
						EObject ret = null;
						ret = ec.getEPackage().getEFactoryInstance().create(ec);
						mainResource.getContents().add(ret);
						return ret;
					}
				};
			}
		};
		IInjector injector = new EMFInjector();
		IReferenceModel mmMetamodel = factory.newReferenceModel();
		injector.inject(mmMetamodel, this.mmOut);
		IReferenceModel aspmMetamodel = factory.newReferenceModel();
		injector.inject(aspmMetamodel, getMetamodelUri("ASPm"));
		this.inModel = factory.newModel(aspmMetamodel);
		injector.inject(inModel, inModelPath);
		this.outModel = xmifactory.newModel(mmMetamodel);
	}

	public void saveModels(String outModelPath) throws ATLCoreException {
		IExtractor extractor = new EMFExtractor();
		HashMap<String, Object> options = new HashMap<String, Object>();
		options.put(XMLResource.OPTION_SCHEMA_LOCATION, true);
		extractor.extract(outModel, outModelPath, options);
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
	public Object doASPm2MMGenerator(IProgressMonitor monitor) throws ATLCoreException, IOException, ATLExecutionException {
		ILauncher launcher = new EMFVMLauncher();
		Map<String, Object> launcherOptions = getOptions();
		launcher.initialize(launcherOptions);
		launcher.addInModel(inModel, "IN", "ECORE");
		return launcher.launch("run", monitor, launcherOptions, (Object[]) getModulesList());
	}

	public Object doASPm2MM(IProgressMonitor monitor) throws ATLCoreException, IOException, ATLExecutionException {
		ILauncher launcher = new EMFVMLauncher();
		launcher.initialize(new HashMap<String,Object>());
		launcher.addInModel(inModel, "IN", "ASPm");
		launcher.addOutModel(outModel, "OUT", this.mmOutName);

		// Compile the generated transformation
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		AtlCompiler.compile(this.generated, out);
		ByteArrayInputStream asm = new ByteArrayInputStream(out.toByteArray());

		return launcher.launch("run", monitor, new HashMap<String,Object>(), new Object[]{asm});
	}

	/**
	 * Try to set values of types not supported by ATL.
	 */
	@SuppressWarnings("unchecked")
	private void setMissingValues() {
		// Get the metamodel of the output model
		final IReferenceModel metamodel = outModel.getReferenceModel();

		// Get all the metaclasses in the metamodel
		final Set<EClass> metaclasses = (Set<EClass>) metamodel.getElementsByType(
				metamodel.getReferenceModel().getMetaElementByName("EClass"));

		// Build a Map containing all the attributes of
		// type EDate and their corresponding classes
		final Map<String, List<EAttribute>> fixAttributes = metaclasses.stream()
			.collect(Collectors.<EClass, String, List<EAttribute>>toMap(e -> e.getName(), e ->
				((EList<EObject>) e.eGet(e.eClass().getEStructuralFeature("eStructuralFeatures")))
				.stream().filter(o ->
					((EObject) o.eGet(o.eClass().getEStructuralFeature("eType")))
						.eGet(o.eClass().getEStructuralFeature("name")).equals("EDate")
				).map(EAttribute.class::cast).collect(Collectors.toList())
		));

		// Create a resource from the output model
		final XMIResourceImpl outputResource = extractStreamedResource();

		// Build a list of the elements of the output model
		// that need to be fixed according to the Map
		final List<EObject> needFixing = fixAttributes.entrySet()
				.stream().filter(e -> !e.getValue().isEmpty())
				.flatMap(e -> {
					Iterable<EObject> iterable = () -> outputResource.getAllContents();
					return StreamSupport.stream(iterable.spliterator(), false)
							.filter(o ->
								o.eClass().getName().equals(e.getKey()) ||
								o.eClass().getEAllSuperTypes().stream()
									.map(t -> t.getName()).collect(Collectors.toList())
									.contains(e.getKey()));
				})
				.collect(Collectors.toList());

		// Derive what attributes need fixing for each object
		// and set the corresponding value from the input model
		needFixing.forEach(e -> setValueFromInputModel(outputResource, e, e.eClass().getEAllSuperTypes()
				.stream().flatMap(c -> fixAttributes.get(c.getName()).stream()).collect(Collectors.toList())));

		// Inject the modified resource for serialization
		injectStreamedResource(outputResource);
	}

	/**
	 * Look in the input model for the corresponding (and missing)
	 * value to be set in the output model.
	 * @param resource output model resource
	 * @param element element having missing values
	 * @param attributes list of attributes that need to be set
	 */
	@SuppressWarnings("unchecked")
	private void setValueFromInputModel(
			final XMIResourceImpl resource, final EObject element, final List<EAttribute> attributes) {
		final Set<EObject> props = ((Set<EObject>) inModel.getElementsByType(
				inModel.getReferenceModel().getMetaElementByName("Prop")));

		for (String tag : resource.getID(element).split("-")) {
			for (EAttribute attr : attributes) {
				if (attr.getName().equals(tag.split("_")[0])) {
					final EClass prop = props.stream().findAny().get().eClass();
					final String value = (String) props.stream().filter(p -> p.eGet(prop.getEStructuralFeature("ID"))
							.equals(tag.split("_")[1])).findFirst().get().eGet(prop.getEStructuralFeature("value"));
					if (attr.getEType().getName().equals("EDate")) {
						setDate(element, attr.getName(), value.substring(2));
					}
				}
			}
		}
	}

	/**
	 * Set a Date attribute in a feature of a given element.
	 * @param element element in which to set the date
	 * @param feature name of the feature having type Date
	 * @param date date string to be parsed
	 */
	private void setDate(final EObject element, final String feature, final String date) {
		try {
			element.eSet(element.eClass().getEStructuralFeature(feature),
					new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy").parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create a resource from the output model before it
	 * is serialized. This resource can be modified and
	 * restored as stream for searialization using the
	 * {@link #injectStreamedResource(Resource)} method.
	 * @return extracted resource
	 */
	private XMIResourceImpl extractStreamedResource() {
		final PipedOutputStream outputStream = new PipedOutputStream();
		Runnable extractor = () -> {
			try {
				new EMFExtractor().extract(outModel, outputStream, null);
				outputStream.close();
			} catch (ATLCoreException | IOException e) {
				e.printStackTrace();
			}
		};
		try (final PipedInputStream inputStream = new PipedInputStream(outputStream)) {
			new Thread(extractor).start();
			registerMetamodel();
			XMIResourceImpl resource = new XMIResourceImpl();
			resource.load(inputStream, new HashMap<Object,Object>());
			return resource;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Rebuild the output model from a previously extracted
	 * resource. The resource should be extracted using the
	 * {@link #extractStreamedResource()} method.
	 * @param resource The resource to be serialized
	 */
	private void injectStreamedResource(final Resource resource) {
		final PipedOutputStream outputStream = new PipedOutputStream();
		Runnable injector = () -> {
			try {
				resource.save(outputStream, new HashMap<Object,Object>());
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		};
		try (final PipedInputStream inputStream = new PipedInputStream(outputStream)) {
			new Thread(injector).start();
			new EMFInjector().inject(outModel, inputStream, null);
		} catch (IOException | ATLCoreException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Register the metamodel provided as input.
	 */
	private void registerMetamodel() {
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.getResource(
				(new File(mmOut).exists()) ? URI.createFileURI(mmOut) : URI.createURI(mmOut)
			, true);
		resource.getContents()
			.stream().filter(p -> p.eClass().getName().equals("EPackage"))
			.map(EPackage.class::cast)
			.forEach(p -> EPackage.Registry.INSTANCE.put(p.getNsURI(), p));
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
		String modulesList = properties.getProperty("ASPm2MMGenerator.modules");
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
		String uriString = properties.getProperty("ASPm2MMGenerator.metamodels." + metamodelName);
		try {
			new EMFModelFactory().getResourceSet().getResource(URI.createURI(uriString), true);
		} catch (Exception e) {
			if (ASPm2MMGenerator.class.getResource("ASPm2MMGenerator.class").toString().startsWith("jar:")) {
				return ASPm2MMGenerator.class.getResource(uriString.replaceFirst("platform:/plugin/JTL.atl", "")).toString();
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
		return getFileURL(properties.getProperty("ASPm2MMGenerator.libraries." + libraryName)).openStream();
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
			if (entry.getKey().toString().startsWith("ASPm2MMGenerator.options.")) {
				options.put(entry.getKey().toString().replaceFirst("ASPm2MMGenerator.options.", ""),
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
			URL resourceURL = ASPm2MMGenerator.class.getResource(fileName);
			if (resourceURL != null) {
				fileURL = FileLocator.toFileURL(resourceURL);
			} else {
				fileURL = null;
			}
		} else {
			fileURL = ASPm2MMGenerator.class.getResource(fileName);
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
