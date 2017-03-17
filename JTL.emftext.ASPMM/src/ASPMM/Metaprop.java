/**
 */
package ASPMM;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Metaprop</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ASPMM.Metaprop#getName <em>Name</em>}</li>
 *   <li>{@link ASPMM.Metaprop#getMetamodel <em>Metamodel</em>}</li>
 *   <li>{@link ASPMM.Metaprop#getMetanode <em>Metanode</em>}</li>
 * </ul>
 *
 * @see ASPMM.ASPMMPackage#getMetaprop()
 * @model
 * @generated
 */
public interface Metaprop extends LocatedElement {
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
	 * @see ASPMM.ASPMMPackage#getMetaprop_Name()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link ASPMM.Metaprop#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Metamodel</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link ASPMM.Metamodel#getMetaprops <em>Metaprops</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metamodel</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metamodel</em>' container reference.
	 * @see #setMetamodel(Metamodel)
	 * @see ASPMM.ASPMMPackage#getMetaprop_Metamodel()
	 * @see ASPMM.Metamodel#getMetaprops
	 * @model opposite="metaprops" required="true" transient="false" ordered="false"
	 * @generated
	 */
	Metamodel getMetamodel();

	/**
	 * Sets the value of the '{@link ASPMM.Metaprop#getMetamodel <em>Metamodel</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metamodel</em>' container reference.
	 * @see #getMetamodel()
	 * @generated
	 */
	void setMetamodel(Metamodel value);

	/**
	 * Returns the value of the '<em><b>Metanode</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metanode</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metanode</em>' reference.
	 * @see #setMetanode(Metanode)
	 * @see ASPMM.ASPMMPackage#getMetaprop_Metanode()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Metanode getMetanode();

	/**
	 * Sets the value of the '{@link ASPMM.Metaprop#getMetanode <em>Metanode</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metanode</em>' reference.
	 * @see #getMetanode()
	 * @generated
	 */
	void setMetanode(Metanode value);

} // Metaprop
