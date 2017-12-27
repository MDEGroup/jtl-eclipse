/**
 */
package ASP;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Not</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ASP.Not#getElement <em>Element</em>}</li>
 * </ul>
 *
 * @see ASP.ASPPackage#getNot()
 * @model
 * @generated
 */
public interface Not extends Expression {
	/**
	 * Returns the value of the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element</em>' reference.
	 * @see #setElement(Element)
	 * @see ASP.ASPPackage#getNot_Element()
	 * @model required="true"
	 * @generated
	 */
	Element getElement();

	/**
	 * Sets the value of the '{@link ASP.Not#getElement <em>Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element</em>' reference.
	 * @see #getElement()
	 * @generated
	 */
	void setElement(Element value);

} // Not
