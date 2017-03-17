/**
 */
package JTL.essentialocl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boolean Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link JTL.essentialocl.BooleanLiteralExp#isBooleanSymbol <em>Boolean Symbol</em>}</li>
 * </ul>
 *
 * @see JTL.essentialocl.EssentialoclPackage#getBooleanLiteralExp()
 * @model
 * @generated
 */
public interface BooleanLiteralExp extends PrimitiveLiteralExp {
	/**
	 * Returns the value of the '<em><b>Boolean Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Boolean Symbol</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Boolean Symbol</em>' attribute.
	 * @see #setBooleanSymbol(boolean)
	 * @see JTL.essentialocl.EssentialoclPackage#getBooleanLiteralExp_BooleanSymbol()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	boolean isBooleanSymbol();

	/**
	 * Sets the value of the '{@link JTL.essentialocl.BooleanLiteralExp#isBooleanSymbol <em>Boolean Symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Boolean Symbol</em>' attribute.
	 * @see #isBooleanSymbol()
	 * @generated
	 */
	void setBooleanSymbol(boolean value);

} // BooleanLiteralExp
