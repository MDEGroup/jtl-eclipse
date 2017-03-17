/**
 */
package JTL.JTL;

import JTL.emof.NamedElement;

import JTL.essentialocl.Variable;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link JTL.JTL.Relation#getTransformation <em>Transformation</em>}</li>
 *   <li>{@link JTL.JTL.Relation#getDomain <em>Domain</em>}</li>
 *   <li>{@link JTL.JTL.Relation#getWhere <em>Where</em>}</li>
 *   <li>{@link JTL.JTL.Relation#getWhen <em>When</em>}</li>
 *   <li>{@link JTL.JTL.Relation#isIsTopLevel <em>Is Top Level</em>}</li>
 *   <li>{@link JTL.JTL.Relation#getVariable <em>Variable</em>}</li>
 * </ul>
 *
 * @see JTL.JTL.JTLPackage#getRelation()
 * @model
 * @generated
 */
public interface Relation extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Transformation</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link JTL.JTL.Transformation#getRelation <em>Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transformation</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transformation</em>' container reference.
	 * @see #setTransformation(Transformation)
	 * @see JTL.JTL.JTLPackage#getRelation_Transformation()
	 * @see JTL.JTL.Transformation#getRelation
	 * @model opposite="relation" required="true" transient="false"
	 * @generated
	 */
	Transformation getTransformation();

	/**
	 * Sets the value of the '{@link JTL.JTL.Relation#getTransformation <em>Transformation</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transformation</em>' container reference.
	 * @see #getTransformation()
	 * @generated
	 */
	void setTransformation(Transformation value);

	/**
	 * Returns the value of the '<em><b>Domain</b></em>' containment reference list.
	 * The list contents are of type {@link JTL.JTL.Domain}.
	 * It is bidirectional and its opposite is '{@link JTL.JTL.Domain#getRelation <em>Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain</em>' containment reference list.
	 * @see JTL.JTL.JTLPackage#getRelation_Domain()
	 * @see JTL.JTL.Domain#getRelation
	 * @model opposite="relation" containment="true"
	 * @generated
	 */
	EList<Domain> getDomain();

	/**
	 * Returns the value of the '<em><b>Where</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Where</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Where</em>' containment reference.
	 * @see #setWhere(Where)
	 * @see JTL.JTL.JTLPackage#getRelation_Where()
	 * @model containment="true"
	 * @generated
	 */
	Where getWhere();

	/**
	 * Sets the value of the '{@link JTL.JTL.Relation#getWhere <em>Where</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Where</em>' containment reference.
	 * @see #getWhere()
	 * @generated
	 */
	void setWhere(Where value);

	/**
	 * Returns the value of the '<em><b>When</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>When</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>When</em>' containment reference.
	 * @see #setWhen(When)
	 * @see JTL.JTL.JTLPackage#getRelation_When()
	 * @model containment="true"
	 * @generated
	 */
	When getWhen();

	/**
	 * Sets the value of the '{@link JTL.JTL.Relation#getWhen <em>When</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>When</em>' containment reference.
	 * @see #getWhen()
	 * @generated
	 */
	void setWhen(When value);

	/**
	 * Returns the value of the '<em><b>Is Top Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Top Level</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Top Level</em>' attribute.
	 * @see #setIsTopLevel(boolean)
	 * @see JTL.JTL.JTLPackage#getRelation_IsTopLevel()
	 * @model required="true"
	 * @generated
	 */
	boolean isIsTopLevel();

	/**
	 * Sets the value of the '{@link JTL.JTL.Relation#isIsTopLevel <em>Is Top Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Top Level</em>' attribute.
	 * @see #isIsTopLevel()
	 * @generated
	 */
	void setIsTopLevel(boolean value);

	/**
	 * Returns the value of the '<em><b>Variable</b></em>' containment reference list.
	 * The list contents are of type {@link JTL.essentialocl.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' containment reference list.
	 * @see JTL.JTL.JTLPackage#getRelation_Variable()
	 * @model containment="true"
	 * @generated
	 */
	EList<Variable> getVariable();

} // Relation
