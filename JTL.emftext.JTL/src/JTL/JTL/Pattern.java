/**
 */
package JTL.JTL;

import JTL.emof.Element;

import JTL.essentialocl.Variable;

import JTL.template.TemplateExp;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link JTL.JTL.Pattern#getPredicate <em>Predicate</em>}</li>
 *   <li>{@link JTL.JTL.Pattern#getBindsTo <em>Binds To</em>}</li>
 *   <li>{@link JTL.JTL.Pattern#getTemplateExpression <em>Template Expression</em>}</li>
 *   <li>{@link JTL.JTL.Pattern#getDomain <em>Domain</em>}</li>
 * </ul>
 *
 * @see JTL.JTL.JTLPackage#getPattern()
 * @model
 * @generated
 */
public interface Pattern extends Element {
	/**
	 * Returns the value of the '<em><b>Predicate</b></em>' containment reference list.
	 * The list contents are of type {@link JTL.JTL.Predicate}.
	 * It is bidirectional and its opposite is '{@link JTL.JTL.Predicate#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predicate</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predicate</em>' containment reference list.
	 * @see JTL.JTL.JTLPackage#getPattern_Predicate()
	 * @see JTL.JTL.Predicate#getPattern
	 * @model opposite="pattern" containment="true"
	 * @generated
	 */
	EList<Predicate> getPredicate();

	/**
	 * Returns the value of the '<em><b>Binds To</b></em>' containment reference list.
	 * The list contents are of type {@link JTL.essentialocl.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Binds To</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Binds To</em>' containment reference list.
	 * @see JTL.JTL.JTLPackage#getPattern_BindsTo()
	 * @model containment="true"
	 * @generated
	 */
	EList<Variable> getBindsTo();

	/**
	 * Returns the value of the '<em><b>Template Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Template Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Template Expression</em>' containment reference.
	 * @see #setTemplateExpression(TemplateExp)
	 * @see JTL.JTL.JTLPackage#getPattern_TemplateExpression()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	TemplateExp getTemplateExpression();

	/**
	 * Sets the value of the '{@link JTL.JTL.Pattern#getTemplateExpression <em>Template Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Template Expression</em>' containment reference.
	 * @see #getTemplateExpression()
	 * @generated
	 */
	void setTemplateExpression(TemplateExp value);

	/**
	 * Returns the value of the '<em><b>Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain</em>' reference.
	 * @see #setDomain(Domain)
	 * @see JTL.JTL.JTLPackage#getPattern_Domain()
	 * @model required="true"
	 * @generated
	 */
	Domain getDomain();

	/**
	 * Sets the value of the '{@link JTL.JTL.Pattern#getDomain <em>Domain</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain</em>' reference.
	 * @see #getDomain()
	 * @generated
	 */
	void setDomain(Domain value);

} // Pattern
