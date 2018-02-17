/**
 */
package ASPT.impl;

import ASPT.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ASPTFactoryImpl extends EFactoryImpl implements ASPTFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ASPTFactory init() {
		try {
			ASPTFactory theASPTFactory = (ASPTFactory)EPackage.Registry.INSTANCE.getEFactory(ASPTPackage.eNS_URI);
			if (theASPTFactory != null) {
				return theASPTFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ASPTFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ASPTFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ASPTPackage.TRACE_MODEL: return createTraceModel();
			case ASPTPackage.TRACE_LINK: return createTraceLink();
			case ASPTPackage.TRACE_ELEMENT: return createTraceElement();
			case ASPTPackage.TRACE_NODE: return createTraceNode();
			case ASPTPackage.TRACE_PROP: return createTraceProp();
			case ASPTPackage.TRACE_EDGE: return createTraceEdge();
			case ASPTPackage.TRACE_NB_NODE: return createTraceNbNode();
			case ASPTPackage.TRACE_NB_PROP: return createTraceNbProp();
			case ASPTPackage.TRACE_NB_EDGE: return createTraceNbEdge();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceModel createTraceModel() {
		TraceModelImpl traceModel = new TraceModelImpl();
		return traceModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceLink createTraceLink() {
		TraceLinkImpl traceLink = new TraceLinkImpl();
		return traceLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceElement createTraceElement() {
		TraceElementImpl traceElement = new TraceElementImpl();
		return traceElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceNode createTraceNode() {
		TraceNodeImpl traceNode = new TraceNodeImpl();
		return traceNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceProp createTraceProp() {
		TracePropImpl traceProp = new TracePropImpl();
		return traceProp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceEdge createTraceEdge() {
		TraceEdgeImpl traceEdge = new TraceEdgeImpl();
		return traceEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceNbNode createTraceNbNode() {
		TraceNbNodeImpl traceNbNode = new TraceNbNodeImpl();
		return traceNbNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceNbProp createTraceNbProp() {
		TraceNbPropImpl traceNbProp = new TraceNbPropImpl();
		return traceNbProp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceNbEdge createTraceNbEdge() {
		TraceNbEdgeImpl traceNbEdge = new TraceNbEdgeImpl();
		return traceNbEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ASPTPackage getASPTPackage() {
		return (ASPTPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ASPTPackage getPackage() {
		return ASPTPackage.eINSTANCE;
	}

} //ASPTFactoryImpl
