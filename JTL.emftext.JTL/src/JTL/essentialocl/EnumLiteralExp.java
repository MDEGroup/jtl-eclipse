/**
 */
package JTL.essentialocl;

import JTL.emof.EnumerationLiteral;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enum Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link JTL.essentialocl.EnumLiteralExp#getReferredEnumLiteral <em>Referred Enum Literal</em>}</li>
 * </ul>
 *
 * @see JTL.essentialocl.EssentialoclPackage#getEnumLiteralExp()
 * @model
 * @generated
 */
public interface EnumLiteralExp extends LiteralExp {
	/**
	 * Returns the value of the '<em><b>Referred Enum Literal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Enum Literal</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Enum Literal</em>' reference.
	 * @see #setReferredEnumLiteral(EnumerationLiteral)
	 * @see JTL.essentialocl.EssentialoclPackage#getEnumLiteralExp_ReferredEnumLiteral()
	 * @model ordered="false"
	 * @generated
	 */
	EnumerationLiteral getReferredEnumLiteral();

	/**
	 * Sets the value of the '{@link JTL.essentialocl.EnumLiteralExp#getReferredEnumLiteral <em>Referred Enum Literal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Enum Literal</em>' reference.
	 * @see #getReferredEnumLiteral()
	 * @generated
	 */
	void setReferredEnumLiteral(EnumerationLiteral value);

} // EnumLiteralExp
