/**
 */
package JTL.essentialocl;

import JTL.emof.TypedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Literal Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link JTL.essentialocl.CollectionLiteralPart#getCollectionLiteralExp <em>Collection Literal Exp</em>}</li>
 * </ul>
 *
 * @see JTL.essentialocl.EssentialoclPackage#getCollectionLiteralPart()
 * @model abstract="true"
 * @generated
 */
public interface CollectionLiteralPart extends TypedElement {
	/**
	 * Returns the value of the '<em><b>Collection Literal Exp</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link JTL.essentialocl.CollectionLiteralExp#getPart <em>Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Collection Literal Exp</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Collection Literal Exp</em>' container reference.
	 * @see #setCollectionLiteralExp(CollectionLiteralExp)
	 * @see JTL.essentialocl.EssentialoclPackage#getCollectionLiteralPart_CollectionLiteralExp()
	 * @see JTL.essentialocl.CollectionLiteralExp#getPart
	 * @model opposite="part" required="true" transient="false" ordered="false"
	 * @generated
	 */
	CollectionLiteralExp getCollectionLiteralExp();

	/**
	 * Sets the value of the '{@link JTL.essentialocl.CollectionLiteralPart#getCollectionLiteralExp <em>Collection Literal Exp</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Collection Literal Exp</em>' container reference.
	 * @see #getCollectionLiteralExp()
	 * @generated
	 */
	void setCollectionLiteralExp(CollectionLiteralExp value);

} // CollectionLiteralPart
