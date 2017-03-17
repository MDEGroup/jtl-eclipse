/**
 */
package JTL.imperativeocl;

import JTL.essentialocl.OclExpression;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tuple Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link JTL.imperativeocl.TupleExp#getElement <em>Element</em>}</li>
 * </ul>
 *
 * @see JTL.imperativeocl.ImperativeoclPackage#getTupleExp()
 * @model
 * @generated
 */
public interface TupleExp extends ImperativeExpression {
	/**
	 * Returns the value of the '<em><b>Element</b></em>' containment reference list.
	 * The list contents are of type {@link JTL.essentialocl.OclExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element</em>' containment reference list.
	 * @see JTL.imperativeocl.ImperativeoclPackage#getTupleExp_Element()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<OclExpression> getElement();

} // TupleExp
