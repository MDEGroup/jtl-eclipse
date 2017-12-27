/**
 */
package ASP;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Not Eq</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ASP.NotEq#getRight <em>Right</em>}</li>
 *   <li>{@link ASP.NotEq#getLeft <em>Left</em>}</li>
 * </ul>
 *
 * @see ASP.ASPPackage#getNotEq()
 * @model
 * @generated
 */
public interface NotEq extends Expression {
	/**
	 * Returns the value of the '<em><b>Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right</em>' reference.
	 * @see #setRight(Literal)
	 * @see ASP.ASPPackage#getNotEq_Right()
	 * @model required="true"
	 * @generated
	 */
	Literal getRight();

	/**
	 * Sets the value of the '{@link ASP.NotEq#getRight <em>Right</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right</em>' reference.
	 * @see #getRight()
	 * @generated
	 */
	void setRight(Literal value);

	/**
	 * Returns the value of the '<em><b>Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left</em>' reference.
	 * @see #setLeft(Literal)
	 * @see ASP.ASPPackage#getNotEq_Left()
	 * @model required="true"
	 * @generated
	 */
	Literal getLeft();

	/**
	 * Sets the value of the '{@link ASP.NotEq#getLeft <em>Left</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left</em>' reference.
	 * @see #getLeft()
	 * @generated
	 */
	void setLeft(Literal value);

} // NotEq
