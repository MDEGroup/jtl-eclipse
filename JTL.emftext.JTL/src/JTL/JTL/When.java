/**
 */
package JTL.JTL;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>When</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link JTL.JTL.When#getWhenOwner <em>When Owner</em>}</li>
 * </ul>
 *
 * @see JTL.JTL.JTLPackage#getWhen()
 * @model
 * @generated
 */
public interface When extends Pattern {
	/**
	 * Returns the value of the '<em><b>When Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link JTL.JTL.Relation#getWhen <em>When</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>When Owner</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>When Owner</em>' container reference.
	 * @see #setWhenOwner(Relation)
	 * @see JTL.JTL.JTLPackage#getWhen_WhenOwner()
	 * @see JTL.JTL.Relation#getWhen
	 * @model opposite="when" transient="false"
	 * @generated
	 */
	Relation getWhenOwner();

	/**
	 * Sets the value of the '{@link JTL.JTL.When#getWhenOwner <em>When Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>When Owner</em>' container reference.
	 * @see #getWhenOwner()
	 * @generated
	 */
	void setWhenOwner(Relation value);

} // When
