/**
 */
package JTL.imperativeocl;

import JTL.essentialocl.OclExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unlink Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link JTL.imperativeocl.UnlinkExp#getTarget <em>Target</em>}</li>
 *   <li>{@link JTL.imperativeocl.UnlinkExp#getItem <em>Item</em>}</li>
 * </ul>
 *
 * @see JTL.imperativeocl.ImperativeoclPackage#getUnlinkExp()
 * @model
 * @generated
 */
public interface UnlinkExp extends ImperativeExpression {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' containment reference.
	 * @see #setTarget(OclExpression)
	 * @see JTL.imperativeocl.ImperativeoclPackage#getUnlinkExp_Target()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	OclExpression getTarget();

	/**
	 * Sets the value of the '{@link JTL.imperativeocl.UnlinkExp#getTarget <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' containment reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(OclExpression value);

	/**
	 * Returns the value of the '<em><b>Item</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Item</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Item</em>' containment reference.
	 * @see #setItem(OclExpression)
	 * @see JTL.imperativeocl.ImperativeoclPackage#getUnlinkExp_Item()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	OclExpression getItem();

	/**
	 * Sets the value of the '{@link JTL.imperativeocl.UnlinkExp#getItem <em>Item</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Item</em>' containment reference.
	 * @see #getItem()
	 * @generated
	 */
	void setItem(OclExpression value);

} // UnlinkExp
