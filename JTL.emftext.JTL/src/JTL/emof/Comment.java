/**
 */
package JTL.emof;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Comment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link JTL.emof.Comment#getAnnotatedElement <em>Annotated Element</em>}</li>
 * </ul>
 *
 * @see JTL.emof.EmofPackage#getComment()
 * @model
 * @generated
 */
public interface Comment extends Element {
	/**
	 * Returns the value of the '<em><b>Annotated Element</b></em>' reference list.
	 * The list contents are of type {@link JTL.emof.NamedElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotated Element</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotated Element</em>' reference list.
	 * @see JTL.emof.EmofPackage#getComment_AnnotatedElement()
	 * @model
	 * @generated
	 */
	EList<NamedElement> getAnnotatedElement();

} // Comment
