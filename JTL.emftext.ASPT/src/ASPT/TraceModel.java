/**
 */
package ASPT;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trace Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ASPT.TraceModel#getTracelinks <em>Tracelinks</em>}</li>
 *   <li>{@link ASPT.TraceModel#getTraceelements <em>Traceelements</em>}</li>
 *   <li>{@link ASPT.TraceModel#getID <em>ID</em>}</li>
 *   <li>{@link ASPT.TraceModel#getMMS <em>MMS</em>}</li>
 * </ul>
 *
 * @see ASPT.ASPTPackage#getTraceModel()
 * @model
 * @generated
 */
public interface TraceModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Tracelinks</b></em>' containment reference list.
	 * The list contents are of type {@link ASPT.TraceLink}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tracelinks</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tracelinks</em>' containment reference list.
	 * @see ASPT.ASPTPackage#getTraceModel_Tracelinks()
	 * @model containment="true"
	 * @generated
	 */
	EList<TraceLink> getTracelinks();

	/**
	 * Returns the value of the '<em><b>Traceelements</b></em>' containment reference list.
	 * The list contents are of type {@link ASPT.TraceElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Traceelements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Traceelements</em>' containment reference list.
	 * @see ASPT.ASPTPackage#getTraceModel_Traceelements()
	 * @model containment="true"
	 * @generated
	 */
	EList<TraceElement> getTraceelements();

	/**
	 * Returns the value of the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ID</em>' attribute.
	 * @see #setID(String)
	 * @see ASPT.ASPTPackage#getTraceModel_ID()
	 * @model
	 * @generated
	 */
	String getID();

	/**
	 * Sets the value of the '{@link ASPT.TraceModel#getID <em>ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ID</em>' attribute.
	 * @see #getID()
	 * @generated
	 */
	void setID(String value);

	/**
	 * Returns the value of the '<em><b>MMS</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>MMS</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>MMS</em>' attribute.
	 * @see #setMMS(String)
	 * @see ASPT.ASPTPackage#getTraceModel_MMS()
	 * @model
	 * @generated
	 */
	String getMMS();

	/**
	 * Sets the value of the '{@link ASPT.TraceModel#getMMS <em>MMS</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>MMS</em>' attribute.
	 * @see #getMMS()
	 * @generated
	 */
	void setMMS(String value);

} // TraceModel
