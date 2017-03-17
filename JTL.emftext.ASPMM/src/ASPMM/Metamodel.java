/**
 */
package ASPMM;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Metamodel</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ASPMM.Metamodel#getName <em>Name</em>}</li>
 *   <li>{@link ASPMM.Metamodel#getMetanodes <em>Metanodes</em>}</li>
 *   <li>{@link ASPMM.Metamodel#getMetaedges <em>Metaedges</em>}</li>
 *   <li>{@link ASPMM.Metamodel#getMetaprops <em>Metaprops</em>}</li>
 * </ul>
 *
 * @see ASPMM.ASPMMPackage#getMetamodel()
 * @model
 * @generated
 */
public interface Metamodel extends LocatedElement {
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
	 * @see ASPMM.ASPMMPackage#getMetamodel_Name()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link ASPMM.Metamodel#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Metanodes</b></em>' containment reference list.
	 * The list contents are of type {@link ASPMM.Metanode}.
	 * It is bidirectional and its opposite is '{@link ASPMM.Metanode#getMetamodel <em>Metamodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metanodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metanodes</em>' containment reference list.
	 * @see ASPMM.ASPMMPackage#getMetamodel_Metanodes()
	 * @see ASPMM.Metanode#getMetamodel
	 * @model opposite="metamodel" containment="true" ordered="false"
	 * @generated
	 */
	EList<Metanode> getMetanodes();

	/**
	 * Returns the value of the '<em><b>Metaedges</b></em>' containment reference list.
	 * The list contents are of type {@link ASPMM.Metaedge}.
	 * It is bidirectional and its opposite is '{@link ASPMM.Metaedge#getMetamodel <em>Metamodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metaedges</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metaedges</em>' containment reference list.
	 * @see ASPMM.ASPMMPackage#getMetamodel_Metaedges()
	 * @see ASPMM.Metaedge#getMetamodel
	 * @model opposite="metamodel" containment="true" ordered="false"
	 * @generated
	 */
	EList<Metaedge> getMetaedges();

	/**
	 * Returns the value of the '<em><b>Metaprops</b></em>' containment reference list.
	 * The list contents are of type {@link ASPMM.Metaprop}.
	 * It is bidirectional and its opposite is '{@link ASPMM.Metaprop#getMetamodel <em>Metamodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metaprops</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metaprops</em>' containment reference list.
	 * @see ASPMM.ASPMMPackage#getMetamodel_Metaprops()
	 * @see ASPMM.Metaprop#getMetamodel
	 * @model opposite="metamodel" containment="true" ordered="false"
	 * @generated
	 */
	EList<Metaprop> getMetaprops();

} // Metamodel
