/**
 */
package JTL.essentialocl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Let Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link JTL.essentialocl.LetExp#getIn <em>In</em>}</li>
 *   <li>{@link JTL.essentialocl.LetExp#getVariable <em>Variable</em>}</li>
 * </ul>
 *
 * @see JTL.essentialocl.EssentialoclPackage#getLetExp()
 * @model
 * @generated
 */
public interface LetExp extends OclExpression {
	/**
	 * Returns the value of the '<em><b>In</b></em>' containment reference list.
	 * The list contents are of type {@link JTL.essentialocl.OclExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In</em>' containment reference list.
	 * @see JTL.essentialocl.EssentialoclPackage#getLetExp_In()
	 * @model containment="true"
	 * @generated
	 */
	EList<OclExpression> getIn();

	/**
	 * Returns the value of the '<em><b>Variable</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link JTL.essentialocl.Variable#getLetExp <em>Let Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' containment reference.
	 * @see #setVariable(Variable)
	 * @see JTL.essentialocl.EssentialoclPackage#getLetExp_Variable()
	 * @see JTL.essentialocl.Variable#getLetExp
	 * @model opposite="LetExp" containment="true" required="true" ordered="false"
	 * @generated
	 */
	Variable getVariable();

	/**
	 * Sets the value of the '{@link JTL.essentialocl.LetExp#getVariable <em>Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' containment reference.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(Variable value);

} // LetExp
