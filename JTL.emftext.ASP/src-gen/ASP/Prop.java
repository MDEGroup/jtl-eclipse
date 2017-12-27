/**
 */
package ASP;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Prop</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ASP.Prop#isIsPropx <em>Is Propx</em>}</li>
 * </ul>
 *
 * @see ASP.ASPPackage#getProp()
 * @model
 * @generated
 */
public interface Prop extends Function {
	/**
	 * Returns the value of the '<em><b>Is Propx</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Propx</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Propx</em>' attribute.
	 * @see #setIsPropx(boolean)
	 * @see ASP.ASPPackage#getProp_IsPropx()
	 * @model default="false" unique="false" required="true" ordered="false"
	 * @generated
	 */
	boolean isIsPropx();

	/**
	 * Sets the value of the '{@link ASP.Prop#isIsPropx <em>Is Propx</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Propx</em>' attribute.
	 * @see #isIsPropx()
	 * @generated
	 */
	void setIsPropx(boolean value);

} // Prop
