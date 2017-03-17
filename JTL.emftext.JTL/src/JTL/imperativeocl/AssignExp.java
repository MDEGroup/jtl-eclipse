/**
 */
package JTL.imperativeocl;

import JTL.essentialocl.OclExpression;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assign Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link JTL.imperativeocl.AssignExp#getValue <em>Value</em>}</li>
 *   <li>{@link JTL.imperativeocl.AssignExp#getLeft <em>Left</em>}</li>
 *   <li>{@link JTL.imperativeocl.AssignExp#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link JTL.imperativeocl.AssignExp#isIsReset <em>Is Reset</em>}</li>
 * </ul>
 *
 * @see JTL.imperativeocl.ImperativeoclPackage#getAssignExp()
 * @model
 * @generated
 */
public interface AssignExp extends ImperativeExpression {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference list.
	 * The list contents are of type {@link JTL.essentialocl.OclExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference list.
	 * @see JTL.imperativeocl.ImperativeoclPackage#getAssignExp_Value()
	 * @model containment="true"
	 * @generated
	 */
	EList<OclExpression> getValue();

	/**
	 * Returns the value of the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left</em>' containment reference.
	 * @see #setLeft(OclExpression)
	 * @see JTL.imperativeocl.ImperativeoclPackage#getAssignExp_Left()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	OclExpression getLeft();

	/**
	 * Sets the value of the '{@link JTL.imperativeocl.AssignExp#getLeft <em>Left</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left</em>' containment reference.
	 * @see #getLeft()
	 * @generated
	 */
	void setLeft(OclExpression value);

	/**
	 * Returns the value of the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Value</em>' containment reference.
	 * @see #setDefaultValue(OclExpression)
	 * @see JTL.imperativeocl.ImperativeoclPackage#getAssignExp_DefaultValue()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	OclExpression getDefaultValue();

	/**
	 * Sets the value of the '{@link JTL.imperativeocl.AssignExp#getDefaultValue <em>Default Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Value</em>' containment reference.
	 * @see #getDefaultValue()
	 * @generated
	 */
	void setDefaultValue(OclExpression value);

	/**
	 * Returns the value of the '<em><b>Is Reset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Reset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Reset</em>' attribute.
	 * @see #setIsReset(boolean)
	 * @see JTL.imperativeocl.ImperativeoclPackage#getAssignExp_IsReset()
	 * @model unique="false" ordered="false"
	 * @generated
	 */
	boolean isIsReset();

	/**
	 * Sets the value of the '{@link JTL.imperativeocl.AssignExp#isIsReset <em>Is Reset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Reset</em>' attribute.
	 * @see #isIsReset()
	 * @generated
	 */
	void setIsReset(boolean value);

} // AssignExp
