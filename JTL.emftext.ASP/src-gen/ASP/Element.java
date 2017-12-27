/**
 */
package ASP;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ASP.Element#getName <em>Name</em>}</li>
 *   <li>{@link ASP.Element#getTransformation <em>Transformation</em>}</li>
 * </ul>
 *
 * @see ASP.ASPPackage#getElement()
 * @model abstract="true"
 * @generated
 */
public interface Element extends EObject {
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
	 * @see ASP.ASPPackage#getElement_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link ASP.Element#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Transformation</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link ASP.Transformation#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transformation</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transformation</em>' container reference.
	 * @see #setTransformation(Transformation)
	 * @see ASP.ASPPackage#getElement_Transformation()
	 * @see ASP.Transformation#getElements
	 * @model opposite="elements" transient="false"
	 * @generated
	 */
	Transformation getTransformation();

	/**
	 * Sets the value of the '{@link ASP.Element#getTransformation <em>Transformation</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transformation</em>' container reference.
	 * @see #getTransformation()
	 * @generated
	 */
	void setTransformation(Transformation value);

} // Element
