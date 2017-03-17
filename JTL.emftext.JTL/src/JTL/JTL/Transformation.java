/**
 */
package JTL.JTL;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transformation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link JTL.JTL.Transformation#getModelParameter <em>Model Parameter</em>}</li>
 *   <li>{@link JTL.JTL.Transformation#getRelation <em>Relation</em>}</li>
 * </ul>
 *
 * @see JTL.JTL.JTLPackage#getTransformation()
 * @model
 * @generated
 */
public interface Transformation extends JTL.emof.Class, JTL.emof.Package {
	/**
	 * Returns the value of the '<em><b>Model Parameter</b></em>' containment reference list.
	 * The list contents are of type {@link JTL.JTL.Model}.
	 * It is bidirectional and its opposite is '{@link JTL.JTL.Model#getTransformation <em>Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Parameter</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Parameter</em>' containment reference list.
	 * @see JTL.JTL.JTLPackage#getTransformation_ModelParameter()
	 * @see JTL.JTL.Model#getTransformation
	 * @model opposite="transformation" containment="true"
	 * @generated
	 */
	EList<Model> getModelParameter();

	/**
	 * Returns the value of the '<em><b>Relation</b></em>' containment reference list.
	 * The list contents are of type {@link JTL.JTL.Relation}.
	 * It is bidirectional and its opposite is '{@link JTL.JTL.Relation#getTransformation <em>Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relation</em>' containment reference list.
	 * @see JTL.JTL.JTLPackage#getTransformation_Relation()
	 * @see JTL.JTL.Relation#getTransformation
	 * @model opposite="transformation" containment="true" required="true"
	 * @generated
	 */
	EList<Relation> getRelation();

} // Transformation
