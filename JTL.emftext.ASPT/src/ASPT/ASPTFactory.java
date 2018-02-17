/**
 */
package ASPT;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see ASPT.ASPTPackage
 * @generated
 */
public interface ASPTFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ASPTFactory eINSTANCE = ASPT.impl.ASPTFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Trace Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Trace Model</em>'.
	 * @generated
	 */
	TraceModel createTraceModel();

	/**
	 * Returns a new object of class '<em>Trace Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Trace Link</em>'.
	 * @generated
	 */
	TraceLink createTraceLink();

	/**
	 * Returns a new object of class '<em>Trace Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Trace Element</em>'.
	 * @generated
	 */
	TraceElement createTraceElement();

	/**
	 * Returns a new object of class '<em>Trace Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Trace Node</em>'.
	 * @generated
	 */
	TraceNode createTraceNode();

	/**
	 * Returns a new object of class '<em>Trace Prop</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Trace Prop</em>'.
	 * @generated
	 */
	TraceProp createTraceProp();

	/**
	 * Returns a new object of class '<em>Trace Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Trace Edge</em>'.
	 * @generated
	 */
	TraceEdge createTraceEdge();

	/**
	 * Returns a new object of class '<em>Trace Nb Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Trace Nb Node</em>'.
	 * @generated
	 */
	TraceNbNode createTraceNbNode();

	/**
	 * Returns a new object of class '<em>Trace Nb Prop</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Trace Nb Prop</em>'.
	 * @generated
	 */
	TraceNbProp createTraceNbProp();

	/**
	 * Returns a new object of class '<em>Trace Nb Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Trace Nb Edge</em>'.
	 * @generated
	 */
	TraceNbEdge createTraceNbEdge();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ASPTPackage getASPTPackage();

} //ASPTFactory
