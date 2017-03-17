/**
 */
package JTL.emof;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link JTL.emof.Type#getPackage <em>Package</em>}</li>
 * </ul>
 *
 * @see JTL.emof.EmofPackage#getType()
 * @model abstract="true"
 * @generated
 */
public interface Type extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Package</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link JTL.emof.Package#getOwnedType <em>Owned Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package</em>' container reference.
	 * @see #setPackage(JTL.emof.Package)
	 * @see JTL.emof.EmofPackage#getType_Package()
	 * @see JTL.emof.Package#getOwnedType
	 * @model opposite="ownedType" required="true" transient="false" ordered="false"
	 * @generated
	 */
	JTL.emof.Package getPackage();

	/**
	 * Sets the value of the '{@link JTL.emof.Type#getPackage <em>Package</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Package</em>' container reference.
	 * @see #getPackage()
	 * @generated
	 */
	void setPackage(JTL.emof.Package value);

} // Type
