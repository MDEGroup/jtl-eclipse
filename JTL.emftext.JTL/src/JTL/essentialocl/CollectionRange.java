/**
 */
package JTL.essentialocl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Range</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link JTL.essentialocl.CollectionRange#getFirst <em>First</em>}</li>
 *   <li>{@link JTL.essentialocl.CollectionRange#getLast <em>Last</em>}</li>
 * </ul>
 *
 * @see JTL.essentialocl.EssentialoclPackage#getCollectionRange()
 * @model
 * @generated
 */
public interface CollectionRange extends CollectionLiteralPart {
	/**
	 * Returns the value of the '<em><b>First</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First</em>' containment reference.
	 * @see #setFirst(OclExpression)
	 * @see JTL.essentialocl.EssentialoclPackage#getCollectionRange_First()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	OclExpression getFirst();

	/**
	 * Sets the value of the '{@link JTL.essentialocl.CollectionRange#getFirst <em>First</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First</em>' containment reference.
	 * @see #getFirst()
	 * @generated
	 */
	void setFirst(OclExpression value);

	/**
	 * Returns the value of the '<em><b>Last</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last</em>' containment reference.
	 * @see #setLast(OclExpression)
	 * @see JTL.essentialocl.EssentialoclPackage#getCollectionRange_Last()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	OclExpression getLast();

	/**
	 * Sets the value of the '{@link JTL.essentialocl.CollectionRange#getLast <em>Last</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last</em>' containment reference.
	 * @see #getLast()
	 * @generated
	 */
	void setLast(OclExpression value);

} // CollectionRange
