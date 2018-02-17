/**
 */
package ASPT.util;

import ASPT.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see ASPT.ASPTPackage
 * @generated
 */
public class ASPTAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ASPTPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ASPTAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ASPTPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ASPTSwitch<Adapter> modelSwitch =
		new ASPTSwitch<Adapter>() {
			@Override
			public Adapter caseTraceModel(TraceModel object) {
				return createTraceModelAdapter();
			}
			@Override
			public Adapter caseTraceLink(TraceLink object) {
				return createTraceLinkAdapter();
			}
			@Override
			public Adapter caseTraceElement(TraceElement object) {
				return createTraceElementAdapter();
			}
			@Override
			public Adapter caseTraceNode(TraceNode object) {
				return createTraceNodeAdapter();
			}
			@Override
			public Adapter caseTraceProp(TraceProp object) {
				return createTracePropAdapter();
			}
			@Override
			public Adapter caseTraceEdge(TraceEdge object) {
				return createTraceEdgeAdapter();
			}
			@Override
			public Adapter caseTraceNbNode(TraceNbNode object) {
				return createTraceNbNodeAdapter();
			}
			@Override
			public Adapter caseTraceNbProp(TraceNbProp object) {
				return createTraceNbPropAdapter();
			}
			@Override
			public Adapter caseTraceNbEdge(TraceNbEdge object) {
				return createTraceNbEdgeAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link ASPT.TraceModel <em>Trace Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ASPT.TraceModel
	 * @generated
	 */
	public Adapter createTraceModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ASPT.TraceLink <em>Trace Link</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ASPT.TraceLink
	 * @generated
	 */
	public Adapter createTraceLinkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ASPT.TraceElement <em>Trace Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ASPT.TraceElement
	 * @generated
	 */
	public Adapter createTraceElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ASPT.TraceNode <em>Trace Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ASPT.TraceNode
	 * @generated
	 */
	public Adapter createTraceNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ASPT.TraceProp <em>Trace Prop</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ASPT.TraceProp
	 * @generated
	 */
	public Adapter createTracePropAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ASPT.TraceEdge <em>Trace Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ASPT.TraceEdge
	 * @generated
	 */
	public Adapter createTraceEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ASPT.TraceNbNode <em>Trace Nb Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ASPT.TraceNbNode
	 * @generated
	 */
	public Adapter createTraceNbNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ASPT.TraceNbProp <em>Trace Nb Prop</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ASPT.TraceNbProp
	 * @generated
	 */
	public Adapter createTraceNbPropAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ASPT.TraceNbEdge <em>Trace Nb Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ASPT.TraceNbEdge
	 * @generated
	 */
	public Adapter createTraceNbEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ASPTAdapterFactory
