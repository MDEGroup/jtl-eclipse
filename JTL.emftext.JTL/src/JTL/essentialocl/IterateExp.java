/**
 */
package JTL.essentialocl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Iterate Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link JTL.essentialocl.IterateExp#getResult <em>Result</em>}</li>
 * </ul>
 *
 * @see JTL.essentialocl.EssentialoclPackage#getIterateExp()
 * @model
 * @generated
 */
public interface IterateExp extends LoopExp {
	/**
	 * Returns the value of the '<em><b>Result</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result</em>' containment reference.
	 * @see #setResult(Variable)
	 * @see JTL.essentialocl.EssentialoclPackage#getIterateExp_Result()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	Variable getResult();

	/**
	 * Sets the value of the '{@link JTL.essentialocl.IterateExp#getResult <em>Result</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result</em>' containment reference.
	 * @see #getResult()
	 * @generated
	 */
	void setResult(Variable value);

} // IterateExp
