/**
 */
package JTL.imperativeocl;

import JTL.essentialocl.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collector Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link JTL.imperativeocl.CollectorExp#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see JTL.imperativeocl.ImperativeoclPackage#getCollectorExp()
 * @model
 * @generated
 */
public interface CollectorExp extends ImperativeLoopExp {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' containment reference.
	 * @see #setTarget(Variable)
	 * @see JTL.imperativeocl.ImperativeoclPackage#getCollectorExp_Target()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Variable getTarget();

	/**
	 * Sets the value of the '{@link JTL.imperativeocl.CollectorExp#getTarget <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' containment reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Variable value);

} // CollectorExp
