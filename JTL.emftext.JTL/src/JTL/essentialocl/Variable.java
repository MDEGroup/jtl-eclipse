/**
 */
package JTL.essentialocl;

import JTL.emof.Parameter;
import JTL.emof.TypedElement;

import JTL.imperativeocl.ComputeExp;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link JTL.essentialocl.Variable#getInitExpression <em>Init Expression</em>}</li>
 *   <li>{@link JTL.essentialocl.Variable#getLetExp <em>Let Exp</em>}</li>
 *   <li>{@link JTL.essentialocl.Variable#getBindParameter <em>Bind Parameter</em>}</li>
 *   <li>{@link JTL.essentialocl.Variable#getComputeOwner <em>Compute Owner</em>}</li>
 * </ul>
 *
 * @see JTL.essentialocl.EssentialoclPackage#getVariable()
 * @model
 * @generated
 */
public interface Variable extends TypedElement {
	/**
	 * Returns the value of the '<em><b>Init Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Init Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Init Expression</em>' containment reference.
	 * @see #setInitExpression(OclExpression)
	 * @see JTL.essentialocl.EssentialoclPackage#getVariable_InitExpression()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	OclExpression getInitExpression();

	/**
	 * Sets the value of the '{@link JTL.essentialocl.Variable#getInitExpression <em>Init Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Init Expression</em>' containment reference.
	 * @see #getInitExpression()
	 * @generated
	 */
	void setInitExpression(OclExpression value);

	/**
	 * Returns the value of the '<em><b>Let Exp</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link JTL.essentialocl.LetExp#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Let Exp</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Let Exp</em>' container reference.
	 * @see #setLetExp(LetExp)
	 * @see JTL.essentialocl.EssentialoclPackage#getVariable_LetExp()
	 * @see JTL.essentialocl.LetExp#getVariable
	 * @model opposite="variable" transient="false" ordered="false"
	 * @generated
	 */
	LetExp getLetExp();

	/**
	 * Sets the value of the '{@link JTL.essentialocl.Variable#getLetExp <em>Let Exp</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Let Exp</em>' container reference.
	 * @see #getLetExp()
	 * @generated
	 */
	void setLetExp(LetExp value);

	/**
	 * Returns the value of the '<em><b>Bind Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bind Parameter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bind Parameter</em>' reference.
	 * @see #setBindParameter(Parameter)
	 * @see JTL.essentialocl.EssentialoclPackage#getVariable_BindParameter()
	 * @model ordered="false"
	 * @generated
	 */
	Parameter getBindParameter();

	/**
	 * Sets the value of the '{@link JTL.essentialocl.Variable#getBindParameter <em>Bind Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bind Parameter</em>' reference.
	 * @see #getBindParameter()
	 * @generated
	 */
	void setBindParameter(Parameter value);

	/**
	 * Returns the value of the '<em><b>Compute Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link JTL.imperativeocl.ComputeExp#getReturnedElement <em>Returned Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compute Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compute Owner</em>' container reference.
	 * @see #setComputeOwner(ComputeExp)
	 * @see JTL.essentialocl.EssentialoclPackage#getVariable_ComputeOwner()
	 * @see JTL.imperativeocl.ComputeExp#getReturnedElement
	 * @model opposite="returnedElement" transient="false" ordered="false"
	 * @generated
	 */
	ComputeExp getComputeOwner();

	/**
	 * Sets the value of the '{@link JTL.essentialocl.Variable#getComputeOwner <em>Compute Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Compute Owner</em>' container reference.
	 * @see #getComputeOwner()
	 * @generated
	 */
	void setComputeOwner(ComputeExp value);

} // Variable
