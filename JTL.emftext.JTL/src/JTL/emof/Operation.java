/**
 */
package JTL.emof;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link JTL.emof.Operation#getClass_ <em>Class</em>}</li>
 *   <li>{@link JTL.emof.Operation#getOwnedParameter <em>Owned Parameter</em>}</li>
 *   <li>{@link JTL.emof.Operation#getRaisedException <em>Raised Exception</em>}</li>
 * </ul>
 *
 * @see JTL.emof.EmofPackage#getOperation()
 * @model
 * @generated
 */
public interface Operation extends MultiplicityElement, TypedElement {
	/**
	 * Returns the value of the '<em><b>Class</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link JTL.emof.Class#getOwnedOperation <em>Owned Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class</em>' container reference.
	 * @see #setClass(JTL.emof.Class)
	 * @see JTL.emof.EmofPackage#getOperation_Class()
	 * @see JTL.emof.Class#getOwnedOperation
	 * @model opposite="ownedOperation" required="true" transient="false" ordered="false"
	 * @generated
	 */
	JTL.emof.Class getClass_();

	/**
	 * Sets the value of the '{@link JTL.emof.Operation#getClass_ <em>Class</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class</em>' container reference.
	 * @see #getClass_()
	 * @generated
	 */
	void setClass(JTL.emof.Class value);

	/**
	 * Returns the value of the '<em><b>Owned Parameter</b></em>' containment reference list.
	 * The list contents are of type {@link JTL.emof.Parameter}.
	 * It is bidirectional and its opposite is '{@link JTL.emof.Parameter#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Parameter</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Parameter</em>' containment reference list.
	 * @see JTL.emof.EmofPackage#getOperation_OwnedParameter()
	 * @see JTL.emof.Parameter#getOperation
	 * @model opposite="operation" containment="true"
	 * @generated
	 */
	EList<Parameter> getOwnedParameter();

	/**
	 * Returns the value of the '<em><b>Raised Exception</b></em>' reference list.
	 * The list contents are of type {@link JTL.emof.Type}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Raised Exception</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Raised Exception</em>' reference list.
	 * @see JTL.emof.EmofPackage#getOperation_RaisedException()
	 * @model
	 * @generated
	 */
	EList<Type> getRaisedException();

} // Operation
