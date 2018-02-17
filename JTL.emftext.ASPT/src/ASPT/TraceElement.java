/**
 */
package ASPT;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trace Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ASPT.TraceElement#getMetamodel <em>Metamodel</em>}</li>
 *   <li>{@link ASPT.TraceElement#getId <em>Id</em>}</li>
 *   <li>{@link ASPT.TraceElement#getIdx <em>Idx</em>}</li>
 *   <li>{@link ASPT.TraceElement#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see ASPT.ASPTPackage#getTraceElement()
 * @model
 * @generated
 */
public interface TraceElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Metamodel</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metamodel</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metamodel</em>' attribute.
	 * @see #setMetamodel(String)
	 * @see ASPT.ASPTPackage#getTraceElement_Metamodel()
	 * @model
	 * @generated
	 */
	String getMetamodel();

	/**
	 * Sets the value of the '{@link ASPT.TraceElement#getMetamodel <em>Metamodel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metamodel</em>' attribute.
	 * @see #getMetamodel()
	 * @generated
	 */
	void setMetamodel(String value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see ASPT.ASPTPackage#getTraceElement_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link ASPT.TraceElement#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Idx</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Idx</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Idx</em>' attribute.
	 * @see #setIdx(String)
	 * @see ASPT.ASPTPackage#getTraceElement_Idx()
	 * @model
	 * @generated
	 */
	String getIdx();

	/**
	 * Sets the value of the '{@link ASPT.TraceElement#getIdx <em>Idx</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Idx</em>' attribute.
	 * @see #getIdx()
	 * @generated
	 */
	void setIdx(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see ASPT.ASPTPackage#getTraceElement_Type()
	 * @model
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link ASPT.TraceElement#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

} // TraceElement
