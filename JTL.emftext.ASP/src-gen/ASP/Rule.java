/**
 */
package ASP;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ASP.Rule#getExpressions <em>Expressions</em>}</li>
 *   <li>{@link ASP.Rule#getName <em>Name</em>}</li>
 *   <li>{@link ASP.Rule#getTransformation <em>Transformation</em>}</li>
 *   <li>{@link ASP.Rule#getComment <em>Comment</em>}</li>
 *   <li>{@link ASP.Rule#getHead <em>Head</em>}</li>
 *   <li>{@link ASP.Rule#getDirection <em>Direction</em>}</li>
 * </ul>
 *
 * @see ASP.ASPPackage#getRule()
 * @model
 * @generated
 */
public interface Rule extends EObject {
	/**
	 * Returns the value of the '<em><b>Expressions</b></em>' containment reference list.
	 * The list contents are of type {@link ASP.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expressions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expressions</em>' containment reference list.
	 * @see ASP.ASPPackage#getRule_Expressions()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Expression> getExpressions();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see ASP.ASPPackage#getRule_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link ASP.Rule#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Transformation</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link ASP.Transformation#getRules <em>Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transformation</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transformation</em>' container reference.
	 * @see #setTransformation(Transformation)
	 * @see ASP.ASPPackage#getRule_Transformation()
	 * @see ASP.Transformation#getRules
	 * @model opposite="rules" transient="false"
	 * @generated
	 */
	Transformation getTransformation();

	/**
	 * Sets the value of the '{@link ASP.Rule#getTransformation <em>Transformation</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transformation</em>' container reference.
	 * @see #getTransformation()
	 * @generated
	 */
	void setTransformation(Transformation value);

	/**
	 * Returns the value of the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comment</em>' attribute.
	 * @see #setComment(String)
	 * @see ASP.ASPPackage#getRule_Comment()
	 * @model unique="false" ordered="false"
	 * @generated
	 */
	String getComment();

	/**
	 * Sets the value of the '{@link ASP.Rule#getComment <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comment</em>' attribute.
	 * @see #getComment()
	 * @generated
	 */
	void setComment(String value);

	/**
	 * Returns the value of the '<em><b>Head</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Head</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Head</em>' containment reference.
	 * @see #setHead(Terminal)
	 * @see ASP.ASPPackage#getRule_Head()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Terminal getHead();

	/**
	 * Sets the value of the '{@link ASP.Rule#getHead <em>Head</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Head</em>' containment reference.
	 * @see #getHead()
	 * @generated
	 */
	void setHead(Terminal value);

	/**
	 * Returns the value of the '<em><b>Direction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Direction</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Direction</em>' reference.
	 * @see #setDirection(Literal)
	 * @see ASP.ASPPackage#getRule_Direction()
	 * @model
	 * @generated
	 */
	Literal getDirection();

	/**
	 * Sets the value of the '{@link ASP.Rule#getDirection <em>Direction</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Direction</em>' reference.
	 * @see #getDirection()
	 * @generated
	 */
	void setDirection(Literal value);

} // Rule
