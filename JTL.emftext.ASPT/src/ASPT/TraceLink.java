/**
 */
package ASPT;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trace Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ASPT.TraceLink#getRelation <em>Relation</em>}</li>
 *   <li>{@link ASPT.TraceLink#getIdref <em>Idref</em>}</li>
 *   <li>{@link ASPT.TraceLink#getIdrefx <em>Idrefx</em>}</li>
 * </ul>
 *
 * @see ASPT.ASPTPackage#getTraceLink()
 * @model
 * @generated
 */
public interface TraceLink extends TraceElement {
	/**
	 * Returns the value of the '<em><b>Relation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relation</em>' attribute.
	 * @see #setRelation(String)
	 * @see ASPT.ASPTPackage#getTraceLink_Relation()
	 * @model
	 * @generated
	 */
	String getRelation();

	/**
	 * Sets the value of the '{@link ASPT.TraceLink#getRelation <em>Relation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relation</em>' attribute.
	 * @see #getRelation()
	 * @generated
	 */
	void setRelation(String value);

	/**
	 * Returns the value of the '<em><b>Idref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Idref</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Idref</em>' attribute.
	 * @see #setIdref(String)
	 * @see ASPT.ASPTPackage#getTraceLink_Idref()
	 * @model
	 * @generated
	 */
	String getIdref();

	/**
	 * Sets the value of the '{@link ASPT.TraceLink#getIdref <em>Idref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Idref</em>' attribute.
	 * @see #getIdref()
	 * @generated
	 */
	void setIdref(String value);

	/**
	 * Returns the value of the '<em><b>Idrefx</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Idrefx</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Idrefx</em>' attribute.
	 * @see #setIdrefx(String)
	 * @see ASPT.ASPTPackage#getTraceLink_Idrefx()
	 * @model
	 * @generated
	 */
	String getIdrefx();

	/**
	 * Sets the value of the '{@link ASPT.TraceLink#getIdrefx <em>Idrefx</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Idrefx</em>' attribute.
	 * @see #getIdrefx()
	 * @generated
	 */
	void setIdrefx(String value);

} // TraceLink
