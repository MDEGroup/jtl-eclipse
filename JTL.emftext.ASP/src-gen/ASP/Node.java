/**
 */
package ASP;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ASP.Node#isIsNodex <em>Is Nodex</em>}</li>
 * </ul>
 *
 * @see ASP.ASPPackage#getNode()
 * @model
 * @generated
 */
public interface Node extends Function {
	/**
	 * Returns the value of the '<em><b>Is Nodex</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Nodex</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Nodex</em>' attribute.
	 * @see #setIsNodex(boolean)
	 * @see ASP.ASPPackage#getNode_IsNodex()
	 * @model default="false" unique="false" required="true" ordered="false"
	 * @generated
	 */
	boolean isIsNodex();

	/**
	 * Sets the value of the '{@link ASP.Node#isIsNodex <em>Is Nodex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Nodex</em>' attribute.
	 * @see #isIsNodex()
	 * @generated
	 */
	void setIsNodex(boolean value);

} // Node
