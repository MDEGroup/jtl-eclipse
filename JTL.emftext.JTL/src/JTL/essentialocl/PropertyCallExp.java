/**
 */
package JTL.essentialocl;

import JTL.emof.Property;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Call Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link JTL.essentialocl.PropertyCallExp#getReferredProperty <em>Referred Property</em>}</li>
 * </ul>
 *
 * @see JTL.essentialocl.EssentialoclPackage#getPropertyCallExp()
 * @model
 * @generated
 */
public interface PropertyCallExp extends FeaturePropertyCall {
	/**
	 * Returns the value of the '<em><b>Referred Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Property</em>' reference.
	 * @see #setReferredProperty(Property)
	 * @see JTL.essentialocl.EssentialoclPackage#getPropertyCallExp_ReferredProperty()
	 * @model ordered="false"
	 * @generated
	 */
	Property getReferredProperty();

	/**
	 * Sets the value of the '{@link JTL.essentialocl.PropertyCallExp#getReferredProperty <em>Referred Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Property</em>' reference.
	 * @see #getReferredProperty()
	 * @generated
	 */
	void setReferredProperty(Property value);

} // PropertyCallExp
