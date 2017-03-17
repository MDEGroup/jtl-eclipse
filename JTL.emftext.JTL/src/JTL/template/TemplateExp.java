/**
 */
package JTL.template;

import JTL.essentialocl.LiteralExp;
import JTL.essentialocl.OclExpression;
import JTL.essentialocl.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link JTL.template.TemplateExp#getBindsTo <em>Binds To</em>}</li>
 *   <li>{@link JTL.template.TemplateExp#getWhere <em>Where</em>}</li>
 * </ul>
 *
 * @see JTL.template.TemplatePackage#getTemplateExp()
 * @model abstract="true"
 * @generated
 */
public interface TemplateExp extends LiteralExp {
	/**
	 * Returns the value of the '<em><b>Binds To</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Binds To</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Binds To</em>' containment reference.
	 * @see #setBindsTo(Variable)
	 * @see JTL.template.TemplatePackage#getTemplateExp_BindsTo()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	Variable getBindsTo();

	/**
	 * Sets the value of the '{@link JTL.template.TemplateExp#getBindsTo <em>Binds To</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Binds To</em>' containment reference.
	 * @see #getBindsTo()
	 * @generated
	 */
	void setBindsTo(Variable value);

	/**
	 * Returns the value of the '<em><b>Where</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Where</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Where</em>' containment reference.
	 * @see #setWhere(OclExpression)
	 * @see JTL.template.TemplatePackage#getTemplateExp_Where()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	OclExpression getWhere();

	/**
	 * Sets the value of the '{@link JTL.template.TemplateExp#getWhere <em>Where</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Where</em>' containment reference.
	 * @see #getWhere()
	 * @generated
	 */
	void setWhere(OclExpression value);

} // TemplateExp
