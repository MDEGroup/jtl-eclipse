/**
 */
package ASPT;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trace Prop</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ASPT.TraceProp#getIdp <em>Idp</em>}</li>
 *   <li>{@link ASPT.TraceProp#getIdpx <em>Idpx</em>}</li>
 *   <li>{@link ASPT.TraceProp#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see ASPT.ASPTPackage#getTraceProp()
 * @model
 * @generated
 */
public interface TraceProp extends TraceElement {
	/**
	 * Returns the value of the '<em><b>Idp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Idp</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Idp</em>' attribute.
	 * @see #setIdp(String)
	 * @see ASPT.ASPTPackage#getTraceProp_Idp()
	 * @model
	 * @generated
	 */
	String getIdp();

	/**
	 * Sets the value of the '{@link ASPT.TraceProp#getIdp <em>Idp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Idp</em>' attribute.
	 * @see #getIdp()
	 * @generated
	 */
	void setIdp(String value);

	/**
	 * Returns the value of the '<em><b>Idpx</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Idpx</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Idpx</em>' attribute.
	 * @see #setIdpx(String)
	 * @see ASPT.ASPTPackage#getTraceProp_Idpx()
	 * @model
	 * @generated
	 */
	String getIdpx();

	/**
	 * Sets the value of the '{@link ASPT.TraceProp#getIdpx <em>Idpx</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Idpx</em>' attribute.
	 * @see #getIdpx()
	 * @generated
	 */
	void setIdpx(String value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see ASPT.ASPTPackage#getTraceProp_Value()
	 * @model
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link ASPT.TraceProp#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

} // TraceProp
