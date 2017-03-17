/**
 */
package JTL.JTL;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Where</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link JTL.JTL.Where#getWhereOwner <em>Where Owner</em>}</li>
 * </ul>
 *
 * @see JTL.JTL.JTLPackage#getWhere()
 * @model
 * @generated
 */
public interface Where extends Pattern {
	/**
	 * Returns the value of the '<em><b>Where Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Where Owner</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Where Owner</em>' reference.
	 * @see #setWhereOwner(Relation)
	 * @see JTL.JTL.JTLPackage#getWhere_WhereOwner()
	 * @model
	 * @generated
	 */
	Relation getWhereOwner();

	/**
	 * Sets the value of the '{@link JTL.JTL.Where#getWhereOwner <em>Where Owner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Where Owner</em>' reference.
	 * @see #getWhereOwner()
	 * @generated
	 */
	void setWhereOwner(Relation value);

} // Where
