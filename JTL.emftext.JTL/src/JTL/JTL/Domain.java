/**
 */
package JTL.JTL;

import JTL.emof.NamedElement;

import JTL.essentialocl.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Domain</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link JTL.JTL.Domain#isIsCheckable <em>Is Checkable</em>}</li>
 *   <li>{@link JTL.JTL.Domain#isIsEnforceable <em>Is Enforceable</em>}</li>
 *   <li>{@link JTL.JTL.Domain#getRelation <em>Relation</em>}</li>
 *   <li>{@link JTL.JTL.Domain#getPattern <em>Pattern</em>}</li>
 *   <li>{@link JTL.JTL.Domain#getModel <em>Model</em>}</li>
 *   <li>{@link JTL.JTL.Domain#getRootVariable <em>Root Variable</em>}</li>
 * </ul>
 *
 * @see JTL.JTL.JTLPackage#getDomain()
 * @model
 * @generated
 */
public interface Domain extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Is Checkable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Checkable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Checkable</em>' attribute.
	 * @see #setIsCheckable(boolean)
	 * @see JTL.JTL.JTLPackage#getDomain_IsCheckable()
	 * @model required="true"
	 * @generated
	 */
	boolean isIsCheckable();

	/**
	 * Sets the value of the '{@link JTL.JTL.Domain#isIsCheckable <em>Is Checkable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Checkable</em>' attribute.
	 * @see #isIsCheckable()
	 * @generated
	 */
	void setIsCheckable(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Enforceable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Enforceable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Enforceable</em>' attribute.
	 * @see #setIsEnforceable(boolean)
	 * @see JTL.JTL.JTLPackage#getDomain_IsEnforceable()
	 * @model required="true"
	 * @generated
	 */
	boolean isIsEnforceable();

	/**
	 * Sets the value of the '{@link JTL.JTL.Domain#isIsEnforceable <em>Is Enforceable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Enforceable</em>' attribute.
	 * @see #isIsEnforceable()
	 * @generated
	 */
	void setIsEnforceable(boolean value);

	/**
	 * Returns the value of the '<em><b>Relation</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link JTL.JTL.Relation#getDomain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relation</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relation</em>' container reference.
	 * @see #setRelation(Relation)
	 * @see JTL.JTL.JTLPackage#getDomain_Relation()
	 * @see JTL.JTL.Relation#getDomain
	 * @model opposite="domain" required="true" transient="false"
	 * @generated
	 */
	Relation getRelation();

	/**
	 * Sets the value of the '{@link JTL.JTL.Domain#getRelation <em>Relation</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relation</em>' container reference.
	 * @see #getRelation()
	 * @generated
	 */
	void setRelation(Relation value);

	/**
	 * Returns the value of the '<em><b>Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pattern</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pattern</em>' containment reference.
	 * @see #setPattern(Pattern)
	 * @see JTL.JTL.JTLPackage#getDomain_Pattern()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Pattern getPattern();

	/**
	 * Sets the value of the '{@link JTL.JTL.Domain#getPattern <em>Pattern</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pattern</em>' containment reference.
	 * @see #getPattern()
	 * @generated
	 */
	void setPattern(Pattern value);

	/**
	 * Returns the value of the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model</em>' reference.
	 * @see #setModel(Model)
	 * @see JTL.JTL.JTLPackage#getDomain_Model()
	 * @model required="true"
	 * @generated
	 */
	Model getModel();

	/**
	 * Sets the value of the '{@link JTL.JTL.Domain#getModel <em>Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model</em>' reference.
	 * @see #getModel()
	 * @generated
	 */
	void setModel(Model value);

	/**
	 * Returns the value of the '<em><b>Root Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root Variable</em>' reference.
	 * @see #setRootVariable(Variable)
	 * @see JTL.JTL.JTLPackage#getDomain_RootVariable()
	 * @model required="true"
	 * @generated
	 */
	Variable getRootVariable();

	/**
	 * Sets the value of the '{@link JTL.JTL.Domain#getRootVariable <em>Root Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root Variable</em>' reference.
	 * @see #getRootVariable()
	 * @generated
	 */
	void setRootVariable(Variable value);

} // Domain
