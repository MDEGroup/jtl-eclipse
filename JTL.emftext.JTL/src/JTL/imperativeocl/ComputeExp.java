/**
 */
package JTL.imperativeocl;

import JTL.essentialocl.OclExpression;
import JTL.essentialocl.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Compute Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link JTL.imperativeocl.ComputeExp#getReturnedElement <em>Returned Element</em>}</li>
 *   <li>{@link JTL.imperativeocl.ComputeExp#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @see JTL.imperativeocl.ImperativeoclPackage#getComputeExp()
 * @model
 * @generated
 */
public interface ComputeExp extends ImperativeExpression {
	/**
	 * Returns the value of the '<em><b>Returned Element</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link JTL.essentialocl.Variable#getComputeOwner <em>Compute Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Returned Element</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Returned Element</em>' containment reference.
	 * @see #setReturnedElement(Variable)
	 * @see JTL.imperativeocl.ImperativeoclPackage#getComputeExp_ReturnedElement()
	 * @see JTL.essentialocl.Variable#getComputeOwner
	 * @model opposite="computeOwner" containment="true" required="true" ordered="false"
	 * @generated
	 */
	Variable getReturnedElement();

	/**
	 * Sets the value of the '{@link JTL.imperativeocl.ComputeExp#getReturnedElement <em>Returned Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Returned Element</em>' containment reference.
	 * @see #getReturnedElement()
	 * @generated
	 */
	void setReturnedElement(Variable value);

	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(OclExpression)
	 * @see JTL.imperativeocl.ImperativeoclPackage#getComputeExp_Body()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	OclExpression getBody();

	/**
	 * Sets the value of the '{@link JTL.imperativeocl.ComputeExp#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(OclExpression value);

} // ComputeExp
