/**
 */
package JTL.imperativeocl;

import JTL.emof.Type;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Anonymous Tuple Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link JTL.imperativeocl.AnonymousTupleType#getElementType <em>Element Type</em>}</li>
 * </ul>
 *
 * @see JTL.imperativeocl.ImperativeoclPackage#getAnonymousTupleType()
 * @model
 * @generated
 */
public interface AnonymousTupleType extends JTL.emof.Class {
	/**
	 * Returns the value of the '<em><b>Element Type</b></em>' reference list.
	 * The list contents are of type {@link JTL.emof.Type}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Type</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Type</em>' reference list.
	 * @see JTL.imperativeocl.ImperativeoclPackage#getAnonymousTupleType_ElementType()
	 * @model
	 * @generated
	 */
	EList<Type> getElementType();

} // AnonymousTupleType
