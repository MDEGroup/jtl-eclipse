/**
 */
package JTL.emof;

import java.lang.Object;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multiplicity Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link JTL.emof.MultiplicityElement#getIsOrdered <em>Is Ordered</em>}</li>
 *   <li>{@link JTL.emof.MultiplicityElement#getIsUnique <em>Is Unique</em>}</li>
 *   <li>{@link JTL.emof.MultiplicityElement#getLower <em>Lower</em>}</li>
 *   <li>{@link JTL.emof.MultiplicityElement#getUpper <em>Upper</em>}</li>
 * </ul>
 *
 * @see JTL.emof.EmofPackage#getMultiplicityElement()
 * @model abstract="true"
 * @generated
 */
public interface MultiplicityElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Is Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Ordered</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Ordered</em>' attribute.
	 * @see #setIsOrdered(Object)
	 * @see JTL.emof.EmofPackage#getMultiplicityElement_IsOrdered()
	 * @model unique="false" dataType="JTL.emof.Boolean" ordered="false"
	 * @generated
	 */
	Object getIsOrdered();

	/**
	 * Sets the value of the '{@link JTL.emof.MultiplicityElement#getIsOrdered <em>Is Ordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Ordered</em>' attribute.
	 * @see #getIsOrdered()
	 * @generated
	 */
	void setIsOrdered(Object value);

	/**
	 * Returns the value of the '<em><b>Is Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Unique</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Unique</em>' attribute.
	 * @see #setIsUnique(Object)
	 * @see JTL.emof.EmofPackage#getMultiplicityElement_IsUnique()
	 * @model unique="false" dataType="JTL.emof.Boolean" ordered="false"
	 * @generated
	 */
	Object getIsUnique();

	/**
	 * Sets the value of the '{@link JTL.emof.MultiplicityElement#getIsUnique <em>Is Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Unique</em>' attribute.
	 * @see #getIsUnique()
	 * @generated
	 */
	void setIsUnique(Object value);

	/**
	 * Returns the value of the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lower</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lower</em>' attribute.
	 * @see #setLower(int)
	 * @see JTL.emof.EmofPackage#getMultiplicityElement_Lower()
	 * @model unique="false" ordered="false"
	 * @generated
	 */
	int getLower();

	/**
	 * Sets the value of the '{@link JTL.emof.MultiplicityElement#getLower <em>Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower</em>' attribute.
	 * @see #getLower()
	 * @generated
	 */
	void setLower(int value);

	/**
	 * Returns the value of the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Upper</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Upper</em>' attribute.
	 * @see #setUpper(Object)
	 * @see JTL.emof.EmofPackage#getMultiplicityElement_Upper()
	 * @model unique="false" dataType="JTL.emof.UnlimitedNatural" ordered="false"
	 * @generated
	 */
	Object getUpper();

	/**
	 * Sets the value of the '{@link JTL.emof.MultiplicityElement#getUpper <em>Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper</em>' attribute.
	 * @see #getUpper()
	 * @generated
	 */
	void setUpper(Object value);

} // MultiplicityElement
