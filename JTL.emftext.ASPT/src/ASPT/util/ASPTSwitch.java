/**
 */
package ASPT.util;

import ASPT.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see ASPT.ASPTPackage
 * @generated
 */
public class ASPTSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ASPTPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ASPTSwitch() {
		if (modelPackage == null) {
			modelPackage = ASPTPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ASPTPackage.TRACE_MODEL: {
				TraceModel traceModel = (TraceModel)theEObject;
				T result = caseTraceModel(traceModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ASPTPackage.TRACE_LINK: {
				TraceLink traceLink = (TraceLink)theEObject;
				T result = caseTraceLink(traceLink);
				if (result == null) result = caseTraceElement(traceLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ASPTPackage.TRACE_ELEMENT: {
				TraceElement traceElement = (TraceElement)theEObject;
				T result = caseTraceElement(traceElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ASPTPackage.TRACE_NODE: {
				TraceNode traceNode = (TraceNode)theEObject;
				T result = caseTraceNode(traceNode);
				if (result == null) result = caseTraceElement(traceNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ASPTPackage.TRACE_PROP: {
				TraceProp traceProp = (TraceProp)theEObject;
				T result = caseTraceProp(traceProp);
				if (result == null) result = caseTraceElement(traceProp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ASPTPackage.TRACE_EDGE: {
				TraceEdge traceEdge = (TraceEdge)theEObject;
				T result = caseTraceEdge(traceEdge);
				if (result == null) result = caseTraceElement(traceEdge);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ASPTPackage.TRACE_NB_NODE: {
				TraceNbNode traceNbNode = (TraceNbNode)theEObject;
				T result = caseTraceNbNode(traceNbNode);
				if (result == null) result = caseTraceNode(traceNbNode);
				if (result == null) result = caseTraceElement(traceNbNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ASPTPackage.TRACE_NB_PROP: {
				TraceNbProp traceNbProp = (TraceNbProp)theEObject;
				T result = caseTraceNbProp(traceNbProp);
				if (result == null) result = caseTraceProp(traceNbProp);
				if (result == null) result = caseTraceElement(traceNbProp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ASPTPackage.TRACE_NB_EDGE: {
				TraceNbEdge traceNbEdge = (TraceNbEdge)theEObject;
				T result = caseTraceNbEdge(traceNbEdge);
				if (result == null) result = caseTraceEdge(traceNbEdge);
				if (result == null) result = caseTraceElement(traceNbEdge);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Trace Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Trace Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTraceModel(TraceModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Trace Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Trace Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTraceLink(TraceLink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Trace Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Trace Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTraceElement(TraceElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Trace Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Trace Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTraceNode(TraceNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Trace Prop</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Trace Prop</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTraceProp(TraceProp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Trace Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Trace Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTraceEdge(TraceEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Trace Nb Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Trace Nb Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTraceNbNode(TraceNbNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Trace Nb Prop</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Trace Nb Prop</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTraceNbProp(TraceNbProp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Trace Nb Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Trace Nb Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTraceNbEdge(TraceNbEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //ASPTSwitch
