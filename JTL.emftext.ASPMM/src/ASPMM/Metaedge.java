/**
 */
package ASPMM;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Metaedge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ASPMM.Metaedge#getName <em>Name</em>}</li>
 *   <li>{@link ASPMM.Metaedge#getType <em>Type</em>}</li>
 *   <li>{@link ASPMM.Metaedge#getSource <em>Source</em>}</li>
 *   <li>{@link ASPMM.Metaedge#getTarget <em>Target</em>}</li>
 *   <li>{@link ASPMM.Metaedge#getMetamodel <em>Metamodel</em>}</li>
 * </ul>
 *
 * @see ASPMM.ASPMMPackage#getMetaedge()
 * @model
 * @generated
 */
public interface Metaedge extends LocatedElement {
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
	 * @see ASPMM.ASPMMPackage#getMetaedge_Name()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link ASPMM.Metaedge#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link ASPMM.MetaedgeType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see ASPMM.MetaedgeType
	 * @see #setType(MetaedgeType)
	 * @see ASPMM.ASPMMPackage#getMetaedge_Type()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	MetaedgeType getType();

	/**
	 * Sets the value of the '{@link ASPMM.Metaedge#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see ASPMM.MetaedgeType
	 * @see #getType()
	 * @generated
	 */
	void setType(MetaedgeType value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Metanode)
	 * @see ASPMM.ASPMMPackage#getMetaedge_Source()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Metanode getSource();

	/**
	 * Sets the value of the '{@link ASPMM.Metaedge#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Metanode value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Metanode)
	 * @see ASPMM.ASPMMPackage#getMetaedge_Target()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Metanode getTarget();

	/**
	 * Sets the value of the '{@link ASPMM.Metaedge#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Metanode value);

	/**
	 * Returns the value of the '<em><b>Metamodel</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link ASPMM.Metamodel#getMetaedges <em>Metaedges</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metamodel</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metamodel</em>' container reference.
	 * @see #setMetamodel(Metamodel)
	 * @see ASPMM.ASPMMPackage#getMetaedge_Metamodel()
	 * @see ASPMM.Metamodel#getMetaedges
	 * @model opposite="metaedges" required="true" transient="false" ordered="false"
	 * @generated
	 */
	Metamodel getMetamodel();

	/**
	 * Sets the value of the '{@link ASPMM.Metaedge#getMetamodel <em>Metamodel</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metamodel</em>' container reference.
	 * @see #getMetamodel()
	 * @generated
	 */
	void setMetamodel(Metamodel value);

} // Metaedge
