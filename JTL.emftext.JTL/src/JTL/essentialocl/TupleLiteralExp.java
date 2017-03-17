/**
 */
package JTL.essentialocl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tuple Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link JTL.essentialocl.TupleLiteralExp#getPart <em>Part</em>}</li>
 * </ul>
 *
 * @see JTL.essentialocl.EssentialoclPackage#getTupleLiteralExp()
 * @model
 * @generated
 */
public interface TupleLiteralExp extends LiteralExp {
	/**
	 * Returns the value of the '<em><b>Part</b></em>' containment reference list.
	 * The list contents are of type {@link JTL.essentialocl.TupleLiteralPart}.
	 * It is bidirectional and its opposite is '{@link JTL.essentialocl.TupleLiteralPart#getTupleLiteralExp <em>Tuple Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part</em>' containment reference list.
	 * @see JTL.essentialocl.EssentialoclPackage#getTupleLiteralExp_Part()
	 * @see JTL.essentialocl.TupleLiteralPart#getTupleLiteralExp
	 * @model opposite="TupleLiteralExp" containment="true"
	 * @generated
	 */
	EList<TupleLiteralPart> getPart();

} // TupleLiteralExp
