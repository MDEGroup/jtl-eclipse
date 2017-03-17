/**
 */
package JTL.essentialocl;

import JTL.JTL.Relation;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Call Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link JTL.essentialocl.OperationCallExp#getArgument <em>Argument</em>}</li>
 *   <li>{@link JTL.essentialocl.OperationCallExp#getReferredOperation <em>Referred Operation</em>}</li>
 * </ul>
 *
 * @see JTL.essentialocl.EssentialoclPackage#getOperationCallExp()
 * @model
 * @generated
 */
public interface OperationCallExp extends FeaturePropertyCall {
	/**
	 * Returns the value of the '<em><b>Argument</b></em>' containment reference list.
	 * The list contents are of type {@link JTL.essentialocl.OclExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Argument</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Argument</em>' containment reference list.
	 * @see JTL.essentialocl.EssentialoclPackage#getOperationCallExp_Argument()
	 * @model containment="true"
	 * @generated
	 */
	EList<OclExpression> getArgument();

	/**
	 * Returns the value of the '<em><b>Referred Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Operation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Operation</em>' reference.
	 * @see #setReferredOperation(Relation)
	 * @see JTL.essentialocl.EssentialoclPackage#getOperationCallExp_ReferredOperation()
	 * @model ordered="false"
	 * @generated
	 */
	Relation getReferredOperation();

	/**
	 * Sets the value of the '{@link JTL.essentialocl.OperationCallExp#getReferredOperation <em>Referred Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Operation</em>' reference.
	 * @see #getReferredOperation()
	 * @generated
	 */
	void setReferredOperation(Relation value);

} // OperationCallExp
