/**
 */
package ASPT.impl;

import ASPT.ASPTFactory;
import ASPT.ASPTPackage;
import ASPT.TraceEdge;
import ASPT.TraceElement;
import ASPT.TraceLink;
import ASPT.TraceModel;
import ASPT.TraceNbEdge;
import ASPT.TraceNbNode;
import ASPT.TraceNbProp;
import ASPT.TraceNode;
import ASPT.TraceProp;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ASPTPackageImpl extends EPackageImpl implements ASPTPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass traceModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass traceLinkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass traceElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass traceNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tracePropEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass traceEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass traceNbNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass traceNbPropEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass traceNbEdgeEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see ASPT.ASPTPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ASPTPackageImpl() {
		super(eNS_URI, ASPTFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ASPTPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ASPTPackage init() {
		if (isInited) return (ASPTPackage)EPackage.Registry.INSTANCE.getEPackage(ASPTPackage.eNS_URI);

		// Obtain or create and register package
		ASPTPackageImpl theASPTPackage = (ASPTPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ASPTPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ASPTPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theASPTPackage.createPackageContents();

		// Initialize created meta-data
		theASPTPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theASPTPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ASPTPackage.eNS_URI, theASPTPackage);
		return theASPTPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTraceModel() {
		return traceModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTraceModel_Tracelinks() {
		return (EReference)traceModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTraceModel_Traceelements() {
		return (EReference)traceModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTraceModel_ID() {
		return (EAttribute)traceModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTraceModel_MMS() {
		return (EAttribute)traceModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTraceLink() {
		return traceLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTraceLink_Relation() {
		return (EAttribute)traceLinkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTraceElement() {
		return traceElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTraceElement_Metamodel() {
		return (EAttribute)traceElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTraceElement_Id() {
		return (EAttribute)traceElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTraceElement_Idx() {
		return (EAttribute)traceElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTraceElement_Type() {
		return (EAttribute)traceElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTraceNode() {
		return traceNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTraceProp() {
		return tracePropEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTraceProp_Idp() {
		return (EAttribute)tracePropEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTraceProp_Idpx() {
		return (EAttribute)tracePropEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTraceProp_Value() {
		return (EAttribute)tracePropEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTraceEdge() {
		return traceEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTraceEdge_Ids() {
		return (EAttribute)traceEdgeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTraceEdge_Idsx() {
		return (EAttribute)traceEdgeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTraceEdge_Idt() {
		return (EAttribute)traceEdgeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTraceEdge_Idtx() {
		return (EAttribute)traceEdgeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTraceNbNode() {
		return traceNbNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTraceNbProp() {
		return traceNbPropEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTraceNbEdge() {
		return traceNbEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ASPTFactory getASPTFactory() {
		return (ASPTFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		traceModelEClass = createEClass(TRACE_MODEL);
		createEReference(traceModelEClass, TRACE_MODEL__TRACELINKS);
		createEReference(traceModelEClass, TRACE_MODEL__TRACEELEMENTS);
		createEAttribute(traceModelEClass, TRACE_MODEL__ID);
		createEAttribute(traceModelEClass, TRACE_MODEL__MMS);

		traceLinkEClass = createEClass(TRACE_LINK);
		createEAttribute(traceLinkEClass, TRACE_LINK__RELATION);

		traceElementEClass = createEClass(TRACE_ELEMENT);
		createEAttribute(traceElementEClass, TRACE_ELEMENT__METAMODEL);
		createEAttribute(traceElementEClass, TRACE_ELEMENT__ID);
		createEAttribute(traceElementEClass, TRACE_ELEMENT__IDX);
		createEAttribute(traceElementEClass, TRACE_ELEMENT__TYPE);

		traceNodeEClass = createEClass(TRACE_NODE);

		tracePropEClass = createEClass(TRACE_PROP);
		createEAttribute(tracePropEClass, TRACE_PROP__IDP);
		createEAttribute(tracePropEClass, TRACE_PROP__IDPX);
		createEAttribute(tracePropEClass, TRACE_PROP__VALUE);

		traceEdgeEClass = createEClass(TRACE_EDGE);
		createEAttribute(traceEdgeEClass, TRACE_EDGE__IDS);
		createEAttribute(traceEdgeEClass, TRACE_EDGE__IDSX);
		createEAttribute(traceEdgeEClass, TRACE_EDGE__IDT);
		createEAttribute(traceEdgeEClass, TRACE_EDGE__IDTX);

		traceNbNodeEClass = createEClass(TRACE_NB_NODE);

		traceNbPropEClass = createEClass(TRACE_NB_PROP);

		traceNbEdgeEClass = createEClass(TRACE_NB_EDGE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		traceLinkEClass.getESuperTypes().add(this.getTraceElement());
		traceNodeEClass.getESuperTypes().add(this.getTraceElement());
		tracePropEClass.getESuperTypes().add(this.getTraceElement());
		traceEdgeEClass.getESuperTypes().add(this.getTraceElement());
		traceNbNodeEClass.getESuperTypes().add(this.getTraceNode());
		traceNbPropEClass.getESuperTypes().add(this.getTraceProp());
		traceNbEdgeEClass.getESuperTypes().add(this.getTraceEdge());

		// Initialize classes, features, and operations; add parameters
		initEClass(traceModelEClass, TraceModel.class, "TraceModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTraceModel_Tracelinks(), this.getTraceLink(), null, "tracelinks", null, 0, -1, TraceModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTraceModel_Traceelements(), this.getTraceElement(), null, "traceelements", null, 0, -1, TraceModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTraceModel_ID(), ecorePackage.getEString(), "ID", null, 0, 1, TraceModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTraceModel_MMS(), ecorePackage.getEString(), "MMS", null, 0, 1, TraceModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(traceLinkEClass, TraceLink.class, "TraceLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTraceLink_Relation(), ecorePackage.getEString(), "relation", null, 0, 1, TraceLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(traceElementEClass, TraceElement.class, "TraceElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTraceElement_Metamodel(), ecorePackage.getEString(), "metamodel", null, 0, 1, TraceElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTraceElement_Id(), ecorePackage.getEString(), "id", null, 0, 1, TraceElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTraceElement_Idx(), ecorePackage.getEString(), "idx", null, 0, 1, TraceElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTraceElement_Type(), ecorePackage.getEString(), "type", null, 0, 1, TraceElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(traceNodeEClass, TraceNode.class, "TraceNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tracePropEClass, TraceProp.class, "TraceProp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTraceProp_Idp(), ecorePackage.getEString(), "idp", null, 0, 1, TraceProp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTraceProp_Idpx(), ecorePackage.getEString(), "idpx", null, 0, 1, TraceProp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTraceProp_Value(), ecorePackage.getEString(), "value", null, 0, 1, TraceProp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(traceEdgeEClass, TraceEdge.class, "TraceEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTraceEdge_Ids(), ecorePackage.getEString(), "ids", null, 0, 1, TraceEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTraceEdge_Idsx(), ecorePackage.getEString(), "idsx", null, 0, 1, TraceEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTraceEdge_Idt(), ecorePackage.getEString(), "idt", null, 0, 1, TraceEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTraceEdge_Idtx(), ecorePackage.getEString(), "idtx", null, 0, 1, TraceEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(traceNbNodeEClass, TraceNbNode.class, "TraceNbNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(traceNbPropEClass, TraceNbProp.class, "TraceNbProp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(traceNbEdgeEClass, TraceNbEdge.class, "TraceNbEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //ASPTPackageImpl
