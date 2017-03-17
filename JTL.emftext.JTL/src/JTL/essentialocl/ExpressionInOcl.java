/**
 */
package JTL.essentialocl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression In Ocl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link JTL.essentialocl.ExpressionInOcl#getBodyExpression <em>Body Expression</em>}</li>
 *   <li>{@link JTL.essentialocl.ExpressionInOcl#getContext <em>Context</em>}</li>
 *   <li>{@link JTL.essentialocl.ExpressionInOcl#getResultVariable <em>Result Variable</em>}</li>
 *   <li>{@link JTL.essentialocl.ExpressionInOcl#getParameterVariable <em>Parameter Variable</em>}</li>
 * </ul>
 *
 * @see JTL.essentialocl.EssentialoclPackage#getExpressionInOcl()
 * @model
 * @generated
 */
public interface ExpressionInOcl extends OpaqueExpression {
	/**
	 * Returns the value of the '<em><b>Body Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body Expression</em>' containment reference.
	 * @see #setBodyExpression(OclExpression)
	 * @see JTL.essentialocl.EssentialoclPackage#getExpressionInOcl_BodyExpression()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	OclExpression getBodyExpression();

	/**
	 * Sets the value of the '{@link JTL.essentialocl.ExpressionInOcl#getBodyExpression <em>Body Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body Expression</em>' containment reference.
	 * @see #getBodyExpression()
	 * @generated
	 */
	void setBodyExpression(OclExpression value);

	/**
	 * Returns the value of the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context</em>' containment reference.
	 * @see #setContext(Variable)
	 * @see JTL.essentialocl.EssentialoclPackage#getExpressionInOcl_Context()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	Variable getContext();

	/**
	 * Sets the value of the '{@link JTL.essentialocl.ExpressionInOcl#getContext <em>Context</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context</em>' containment reference.
	 * @see #getContext()
	 * @generated
	 */
	void setContext(Variable value);

	/**
	 * Returns the value of the '<em><b>Result Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result Variable</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Variable</em>' containment reference.
	 * @see #setResultVariable(Variable)
	 * @see JTL.essentialocl.EssentialoclPackage#getExpressionInOcl_ResultVariable()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	Variable getResultVariable();

	/**
	 * Sets the value of the '{@link JTL.essentialocl.ExpressionInOcl#getResultVariable <em>Result Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result Variable</em>' containment reference.
	 * @see #getResultVariable()
	 * @generated
	 */
	void setResultVariable(Variable value);

	/**
	 * Returns the value of the '<em><b>Parameter Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Variable</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Variable</em>' containment reference.
	 * @see #setParameterVariable(Variable)
	 * @see JTL.essentialocl.EssentialoclPackage#getExpressionInOcl_ParameterVariable()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	Variable getParameterVariable();

	/**
	 * Sets the value of the '{@link JTL.essentialocl.ExpressionInOcl#getParameterVariable <em>Parameter Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter Variable</em>' containment reference.
	 * @see #getParameterVariable()
	 * @generated
	 */
	void setParameterVariable(Variable value);

} // ExpressionInOcl
