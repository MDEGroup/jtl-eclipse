/**
 */
package JTL.imperativeocl;

import JTL.essentialocl.LiteralExp;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dict Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link JTL.imperativeocl.DictLiteralExp#getPart <em>Part</em>}</li>
 * </ul>
 *
 * @see JTL.imperativeocl.ImperativeoclPackage#getDictLiteralExp()
 * @model
 * @generated
 */
public interface DictLiteralExp extends LiteralExp {
	/**
	 * Returns the value of the '<em><b>Part</b></em>' containment reference list.
	 * The list contents are of type {@link JTL.imperativeocl.DictLiteralPart}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part</em>' containment reference list.
	 * @see JTL.imperativeocl.ImperativeoclPackage#getDictLiteralExp_Part()
	 * @model containment="true"
	 * @generated
	 */
	EList<DictLiteralPart> getPart();

} // DictLiteralExp
