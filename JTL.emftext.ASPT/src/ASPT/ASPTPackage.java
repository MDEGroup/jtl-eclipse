/**
 */
package ASPT;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see ASPT.ASPTFactory
 * @model kind="package"
 * @generated
 */
public interface ASPTPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ASPT";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://jtl.univaq.it/aspt";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ASPT";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ASPTPackage eINSTANCE = ASPT.impl.ASPTPackageImpl.init();

	/**
	 * The meta object id for the '{@link ASPT.impl.TraceModelImpl <em>Trace Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ASPT.impl.TraceModelImpl
	 * @see ASPT.impl.ASPTPackageImpl#getTraceModel()
	 * @generated
	 */
	int TRACE_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Tracelinks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_MODEL__TRACELINKS = 0;

	/**
	 * The feature id for the '<em><b>Traceelements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_MODEL__TRACEELEMENTS = 1;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_MODEL__ID = 2;

	/**
	 * The feature id for the '<em><b>MMS</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_MODEL__MMS = 3;

	/**
	 * The number of structural features of the '<em>Trace Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_MODEL_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Trace Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link ASPT.impl.TraceElementImpl <em>Trace Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ASPT.impl.TraceElementImpl
	 * @see ASPT.impl.ASPTPackageImpl#getTraceElement()
	 * @generated
	 */
	int TRACE_ELEMENT = 2;

	/**
	 * The feature id for the '<em><b>Metamodel</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_ELEMENT__METAMODEL = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_ELEMENT__ID = 1;

	/**
	 * The feature id for the '<em><b>Idx</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_ELEMENT__IDX = 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_ELEMENT__TYPE = 3;

	/**
	 * The number of structural features of the '<em>Trace Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_ELEMENT_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Trace Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link ASPT.impl.TraceLinkImpl <em>Trace Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ASPT.impl.TraceLinkImpl
	 * @see ASPT.impl.ASPTPackageImpl#getTraceLink()
	 * @generated
	 */
	int TRACE_LINK = 1;

	/**
	 * The feature id for the '<em><b>Metamodel</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_LINK__METAMODEL = TRACE_ELEMENT__METAMODEL;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_LINK__ID = TRACE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Idx</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_LINK__IDX = TRACE_ELEMENT__IDX;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_LINK__TYPE = TRACE_ELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Relation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_LINK__RELATION = TRACE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Trace Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_LINK_FEATURE_COUNT = TRACE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Trace Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_LINK_OPERATION_COUNT = TRACE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ASPT.impl.TraceNodeImpl <em>Trace Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ASPT.impl.TraceNodeImpl
	 * @see ASPT.impl.ASPTPackageImpl#getTraceNode()
	 * @generated
	 */
	int TRACE_NODE = 3;

	/**
	 * The feature id for the '<em><b>Metamodel</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_NODE__METAMODEL = TRACE_ELEMENT__METAMODEL;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_NODE__ID = TRACE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Idx</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_NODE__IDX = TRACE_ELEMENT__IDX;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_NODE__TYPE = TRACE_ELEMENT__TYPE;

	/**
	 * The number of structural features of the '<em>Trace Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_NODE_FEATURE_COUNT = TRACE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Trace Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_NODE_OPERATION_COUNT = TRACE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ASPT.impl.TracePropImpl <em>Trace Prop</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ASPT.impl.TracePropImpl
	 * @see ASPT.impl.ASPTPackageImpl#getTraceProp()
	 * @generated
	 */
	int TRACE_PROP = 4;

	/**
	 * The feature id for the '<em><b>Metamodel</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_PROP__METAMODEL = TRACE_ELEMENT__METAMODEL;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_PROP__ID = TRACE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Idx</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_PROP__IDX = TRACE_ELEMENT__IDX;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_PROP__TYPE = TRACE_ELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Idp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_PROP__IDP = TRACE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Idpx</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_PROP__IDPX = TRACE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_PROP__VALUE = TRACE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Trace Prop</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_PROP_FEATURE_COUNT = TRACE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Trace Prop</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_PROP_OPERATION_COUNT = TRACE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ASPT.impl.TraceEdgeImpl <em>Trace Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ASPT.impl.TraceEdgeImpl
	 * @see ASPT.impl.ASPTPackageImpl#getTraceEdge()
	 * @generated
	 */
	int TRACE_EDGE = 5;

	/**
	 * The feature id for the '<em><b>Metamodel</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_EDGE__METAMODEL = TRACE_ELEMENT__METAMODEL;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_EDGE__ID = TRACE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Idx</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_EDGE__IDX = TRACE_ELEMENT__IDX;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_EDGE__TYPE = TRACE_ELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Ids</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_EDGE__IDS = TRACE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Idsx</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_EDGE__IDSX = TRACE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Idt</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_EDGE__IDT = TRACE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Idtx</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_EDGE__IDTX = TRACE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Trace Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_EDGE_FEATURE_COUNT = TRACE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Trace Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_EDGE_OPERATION_COUNT = TRACE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ASPT.impl.TraceNbNodeImpl <em>Trace Nb Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ASPT.impl.TraceNbNodeImpl
	 * @see ASPT.impl.ASPTPackageImpl#getTraceNbNode()
	 * @generated
	 */
	int TRACE_NB_NODE = 6;

	/**
	 * The feature id for the '<em><b>Metamodel</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_NB_NODE__METAMODEL = TRACE_NODE__METAMODEL;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_NB_NODE__ID = TRACE_NODE__ID;

	/**
	 * The feature id for the '<em><b>Idx</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_NB_NODE__IDX = TRACE_NODE__IDX;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_NB_NODE__TYPE = TRACE_NODE__TYPE;

	/**
	 * The number of structural features of the '<em>Trace Nb Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_NB_NODE_FEATURE_COUNT = TRACE_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Trace Nb Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_NB_NODE_OPERATION_COUNT = TRACE_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ASPT.impl.TraceNbPropImpl <em>Trace Nb Prop</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ASPT.impl.TraceNbPropImpl
	 * @see ASPT.impl.ASPTPackageImpl#getTraceNbProp()
	 * @generated
	 */
	int TRACE_NB_PROP = 7;

	/**
	 * The feature id for the '<em><b>Metamodel</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_NB_PROP__METAMODEL = TRACE_PROP__METAMODEL;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_NB_PROP__ID = TRACE_PROP__ID;

	/**
	 * The feature id for the '<em><b>Idx</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_NB_PROP__IDX = TRACE_PROP__IDX;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_NB_PROP__TYPE = TRACE_PROP__TYPE;

	/**
	 * The feature id for the '<em><b>Idp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_NB_PROP__IDP = TRACE_PROP__IDP;

	/**
	 * The feature id for the '<em><b>Idpx</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_NB_PROP__IDPX = TRACE_PROP__IDPX;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_NB_PROP__VALUE = TRACE_PROP__VALUE;

	/**
	 * The number of structural features of the '<em>Trace Nb Prop</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_NB_PROP_FEATURE_COUNT = TRACE_PROP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Trace Nb Prop</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_NB_PROP_OPERATION_COUNT = TRACE_PROP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ASPT.impl.TraceNbEdgeImpl <em>Trace Nb Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ASPT.impl.TraceNbEdgeImpl
	 * @see ASPT.impl.ASPTPackageImpl#getTraceNbEdge()
	 * @generated
	 */
	int TRACE_NB_EDGE = 8;

	/**
	 * The feature id for the '<em><b>Metamodel</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_NB_EDGE__METAMODEL = TRACE_EDGE__METAMODEL;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_NB_EDGE__ID = TRACE_EDGE__ID;

	/**
	 * The feature id for the '<em><b>Idx</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_NB_EDGE__IDX = TRACE_EDGE__IDX;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_NB_EDGE__TYPE = TRACE_EDGE__TYPE;

	/**
	 * The feature id for the '<em><b>Ids</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_NB_EDGE__IDS = TRACE_EDGE__IDS;

	/**
	 * The feature id for the '<em><b>Idsx</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_NB_EDGE__IDSX = TRACE_EDGE__IDSX;

	/**
	 * The feature id for the '<em><b>Idt</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_NB_EDGE__IDT = TRACE_EDGE__IDT;

	/**
	 * The feature id for the '<em><b>Idtx</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_NB_EDGE__IDTX = TRACE_EDGE__IDTX;

	/**
	 * The number of structural features of the '<em>Trace Nb Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_NB_EDGE_FEATURE_COUNT = TRACE_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Trace Nb Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_NB_EDGE_OPERATION_COUNT = TRACE_EDGE_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link ASPT.TraceModel <em>Trace Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trace Model</em>'.
	 * @see ASPT.TraceModel
	 * @generated
	 */
	EClass getTraceModel();

	/**
	 * Returns the meta object for the containment reference list '{@link ASPT.TraceModel#getTracelinks <em>Tracelinks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tracelinks</em>'.
	 * @see ASPT.TraceModel#getTracelinks()
	 * @see #getTraceModel()
	 * @generated
	 */
	EReference getTraceModel_Tracelinks();

	/**
	 * Returns the meta object for the containment reference list '{@link ASPT.TraceModel#getTraceelements <em>Traceelements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Traceelements</em>'.
	 * @see ASPT.TraceModel#getTraceelements()
	 * @see #getTraceModel()
	 * @generated
	 */
	EReference getTraceModel_Traceelements();

	/**
	 * Returns the meta object for the attribute '{@link ASPT.TraceModel#getID <em>ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>ID</em>'.
	 * @see ASPT.TraceModel#getID()
	 * @see #getTraceModel()
	 * @generated
	 */
	EAttribute getTraceModel_ID();

	/**
	 * Returns the meta object for the attribute '{@link ASPT.TraceModel#getMMS <em>MMS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>MMS</em>'.
	 * @see ASPT.TraceModel#getMMS()
	 * @see #getTraceModel()
	 * @generated
	 */
	EAttribute getTraceModel_MMS();

	/**
	 * Returns the meta object for class '{@link ASPT.TraceLink <em>Trace Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trace Link</em>'.
	 * @see ASPT.TraceLink
	 * @generated
	 */
	EClass getTraceLink();

	/**
	 * Returns the meta object for the attribute '{@link ASPT.TraceLink#getRelation <em>Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Relation</em>'.
	 * @see ASPT.TraceLink#getRelation()
	 * @see #getTraceLink()
	 * @generated
	 */
	EAttribute getTraceLink_Relation();

	/**
	 * Returns the meta object for class '{@link ASPT.TraceElement <em>Trace Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trace Element</em>'.
	 * @see ASPT.TraceElement
	 * @generated
	 */
	EClass getTraceElement();

	/**
	 * Returns the meta object for the attribute '{@link ASPT.TraceElement#getMetamodel <em>Metamodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Metamodel</em>'.
	 * @see ASPT.TraceElement#getMetamodel()
	 * @see #getTraceElement()
	 * @generated
	 */
	EAttribute getTraceElement_Metamodel();

	/**
	 * Returns the meta object for the attribute '{@link ASPT.TraceElement#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see ASPT.TraceElement#getId()
	 * @see #getTraceElement()
	 * @generated
	 */
	EAttribute getTraceElement_Id();

	/**
	 * Returns the meta object for the attribute '{@link ASPT.TraceElement#getIdx <em>Idx</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Idx</em>'.
	 * @see ASPT.TraceElement#getIdx()
	 * @see #getTraceElement()
	 * @generated
	 */
	EAttribute getTraceElement_Idx();

	/**
	 * Returns the meta object for the attribute '{@link ASPT.TraceElement#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see ASPT.TraceElement#getType()
	 * @see #getTraceElement()
	 * @generated
	 */
	EAttribute getTraceElement_Type();

	/**
	 * Returns the meta object for class '{@link ASPT.TraceNode <em>Trace Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trace Node</em>'.
	 * @see ASPT.TraceNode
	 * @generated
	 */
	EClass getTraceNode();

	/**
	 * Returns the meta object for class '{@link ASPT.TraceProp <em>Trace Prop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trace Prop</em>'.
	 * @see ASPT.TraceProp
	 * @generated
	 */
	EClass getTraceProp();

	/**
	 * Returns the meta object for the attribute '{@link ASPT.TraceProp#getIdp <em>Idp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Idp</em>'.
	 * @see ASPT.TraceProp#getIdp()
	 * @see #getTraceProp()
	 * @generated
	 */
	EAttribute getTraceProp_Idp();

	/**
	 * Returns the meta object for the attribute '{@link ASPT.TraceProp#getIdpx <em>Idpx</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Idpx</em>'.
	 * @see ASPT.TraceProp#getIdpx()
	 * @see #getTraceProp()
	 * @generated
	 */
	EAttribute getTraceProp_Idpx();

	/**
	 * Returns the meta object for the attribute '{@link ASPT.TraceProp#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see ASPT.TraceProp#getValue()
	 * @see #getTraceProp()
	 * @generated
	 */
	EAttribute getTraceProp_Value();

	/**
	 * Returns the meta object for class '{@link ASPT.TraceEdge <em>Trace Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trace Edge</em>'.
	 * @see ASPT.TraceEdge
	 * @generated
	 */
	EClass getTraceEdge();

	/**
	 * Returns the meta object for the attribute '{@link ASPT.TraceEdge#getIds <em>Ids</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ids</em>'.
	 * @see ASPT.TraceEdge#getIds()
	 * @see #getTraceEdge()
	 * @generated
	 */
	EAttribute getTraceEdge_Ids();

	/**
	 * Returns the meta object for the attribute '{@link ASPT.TraceEdge#getIdsx <em>Idsx</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Idsx</em>'.
	 * @see ASPT.TraceEdge#getIdsx()
	 * @see #getTraceEdge()
	 * @generated
	 */
	EAttribute getTraceEdge_Idsx();

	/**
	 * Returns the meta object for the attribute '{@link ASPT.TraceEdge#getIdt <em>Idt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Idt</em>'.
	 * @see ASPT.TraceEdge#getIdt()
	 * @see #getTraceEdge()
	 * @generated
	 */
	EAttribute getTraceEdge_Idt();

	/**
	 * Returns the meta object for the attribute '{@link ASPT.TraceEdge#getIdtx <em>Idtx</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Idtx</em>'.
	 * @see ASPT.TraceEdge#getIdtx()
	 * @see #getTraceEdge()
	 * @generated
	 */
	EAttribute getTraceEdge_Idtx();

	/**
	 * Returns the meta object for class '{@link ASPT.TraceNbNode <em>Trace Nb Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trace Nb Node</em>'.
	 * @see ASPT.TraceNbNode
	 * @generated
	 */
	EClass getTraceNbNode();

	/**
	 * Returns the meta object for class '{@link ASPT.TraceNbProp <em>Trace Nb Prop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trace Nb Prop</em>'.
	 * @see ASPT.TraceNbProp
	 * @generated
	 */
	EClass getTraceNbProp();

	/**
	 * Returns the meta object for class '{@link ASPT.TraceNbEdge <em>Trace Nb Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trace Nb Edge</em>'.
	 * @see ASPT.TraceNbEdge
	 * @generated
	 */
	EClass getTraceNbEdge();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ASPTFactory getASPTFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link ASPT.impl.TraceModelImpl <em>Trace Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ASPT.impl.TraceModelImpl
		 * @see ASPT.impl.ASPTPackageImpl#getTraceModel()
		 * @generated
		 */
		EClass TRACE_MODEL = eINSTANCE.getTraceModel();

		/**
		 * The meta object literal for the '<em><b>Tracelinks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE_MODEL__TRACELINKS = eINSTANCE.getTraceModel_Tracelinks();

		/**
		 * The meta object literal for the '<em><b>Traceelements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE_MODEL__TRACEELEMENTS = eINSTANCE.getTraceModel_Traceelements();

		/**
		 * The meta object literal for the '<em><b>ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACE_MODEL__ID = eINSTANCE.getTraceModel_ID();

		/**
		 * The meta object literal for the '<em><b>MMS</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACE_MODEL__MMS = eINSTANCE.getTraceModel_MMS();

		/**
		 * The meta object literal for the '{@link ASPT.impl.TraceLinkImpl <em>Trace Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ASPT.impl.TraceLinkImpl
		 * @see ASPT.impl.ASPTPackageImpl#getTraceLink()
		 * @generated
		 */
		EClass TRACE_LINK = eINSTANCE.getTraceLink();

		/**
		 * The meta object literal for the '<em><b>Relation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACE_LINK__RELATION = eINSTANCE.getTraceLink_Relation();

		/**
		 * The meta object literal for the '{@link ASPT.impl.TraceElementImpl <em>Trace Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ASPT.impl.TraceElementImpl
		 * @see ASPT.impl.ASPTPackageImpl#getTraceElement()
		 * @generated
		 */
		EClass TRACE_ELEMENT = eINSTANCE.getTraceElement();

		/**
		 * The meta object literal for the '<em><b>Metamodel</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACE_ELEMENT__METAMODEL = eINSTANCE.getTraceElement_Metamodel();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACE_ELEMENT__ID = eINSTANCE.getTraceElement_Id();

		/**
		 * The meta object literal for the '<em><b>Idx</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACE_ELEMENT__IDX = eINSTANCE.getTraceElement_Idx();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACE_ELEMENT__TYPE = eINSTANCE.getTraceElement_Type();

		/**
		 * The meta object literal for the '{@link ASPT.impl.TraceNodeImpl <em>Trace Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ASPT.impl.TraceNodeImpl
		 * @see ASPT.impl.ASPTPackageImpl#getTraceNode()
		 * @generated
		 */
		EClass TRACE_NODE = eINSTANCE.getTraceNode();

		/**
		 * The meta object literal for the '{@link ASPT.impl.TracePropImpl <em>Trace Prop</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ASPT.impl.TracePropImpl
		 * @see ASPT.impl.ASPTPackageImpl#getTraceProp()
		 * @generated
		 */
		EClass TRACE_PROP = eINSTANCE.getTraceProp();

		/**
		 * The meta object literal for the '<em><b>Idp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACE_PROP__IDP = eINSTANCE.getTraceProp_Idp();

		/**
		 * The meta object literal for the '<em><b>Idpx</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACE_PROP__IDPX = eINSTANCE.getTraceProp_Idpx();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACE_PROP__VALUE = eINSTANCE.getTraceProp_Value();

		/**
		 * The meta object literal for the '{@link ASPT.impl.TraceEdgeImpl <em>Trace Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ASPT.impl.TraceEdgeImpl
		 * @see ASPT.impl.ASPTPackageImpl#getTraceEdge()
		 * @generated
		 */
		EClass TRACE_EDGE = eINSTANCE.getTraceEdge();

		/**
		 * The meta object literal for the '<em><b>Ids</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACE_EDGE__IDS = eINSTANCE.getTraceEdge_Ids();

		/**
		 * The meta object literal for the '<em><b>Idsx</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACE_EDGE__IDSX = eINSTANCE.getTraceEdge_Idsx();

		/**
		 * The meta object literal for the '<em><b>Idt</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACE_EDGE__IDT = eINSTANCE.getTraceEdge_Idt();

		/**
		 * The meta object literal for the '<em><b>Idtx</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACE_EDGE__IDTX = eINSTANCE.getTraceEdge_Idtx();

		/**
		 * The meta object literal for the '{@link ASPT.impl.TraceNbNodeImpl <em>Trace Nb Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ASPT.impl.TraceNbNodeImpl
		 * @see ASPT.impl.ASPTPackageImpl#getTraceNbNode()
		 * @generated
		 */
		EClass TRACE_NB_NODE = eINSTANCE.getTraceNbNode();

		/**
		 * The meta object literal for the '{@link ASPT.impl.TraceNbPropImpl <em>Trace Nb Prop</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ASPT.impl.TraceNbPropImpl
		 * @see ASPT.impl.ASPTPackageImpl#getTraceNbProp()
		 * @generated
		 */
		EClass TRACE_NB_PROP = eINSTANCE.getTraceNbProp();

		/**
		 * The meta object literal for the '{@link ASPT.impl.TraceNbEdgeImpl <em>Trace Nb Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ASPT.impl.TraceNbEdgeImpl
		 * @see ASPT.impl.ASPTPackageImpl#getTraceNbEdge()
		 * @generated
		 */
		EClass TRACE_NB_EDGE = eINSTANCE.getTraceNbEdge();

	}

} //ASPTPackage
