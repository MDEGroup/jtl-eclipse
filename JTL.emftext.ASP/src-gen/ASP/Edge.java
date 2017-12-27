/**
 */
package ASP;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ASP.Edge#isIsEdgex <em>Is Edgex</em>}</li>
 * </ul>
 *
 * @see ASP.ASPPackage#getEdge()
 * @model
 * @generated
 */
public interface Edge extends Function {
	/**
	 * Returns the value of the '<em><b>Is Edgex</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Edgex</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Edgex</em>' attribute.
	 * @see #setIsEdgex(boolean)
	 * @see ASP.ASPPackage#getEdge_IsEdgex()
	 * @model default="false" unique="false" required="true" ordered="false"
	 * @generated
	 */
	boolean isIsEdgex();

	/**
	 * Sets the value of the '{@link ASP.Edge#isIsEdgex <em>Is Edgex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Edgex</em>' attribute.
	 * @see #isIsEdgex()
	 * @generated
	 */
	void setIsEdgex(boolean value);

} // Edge
