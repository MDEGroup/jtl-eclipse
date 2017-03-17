/**
 */
package ASP;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ASP.Function#getLiterals <em>Literals</em>}</li>
 * </ul>
 *
 * @see ASP.ASPPackage#getFunction()
 * @model abstract="true"
 * @generated
 */
public interface Function extends Element {
	/**
	 * Returns the value of the '<em><b>Literals</b></em>' reference list.
	 * The list contents are of type {@link ASP.Literal}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Literals</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Literals</em>' reference list.
	 * @see ASP.ASPPackage#getFunction_Literals()
	 * @model required="true"
	 * @generated
	 */
	EList<Literal> getLiterals();

} // Function
