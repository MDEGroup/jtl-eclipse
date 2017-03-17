/**
 */
package ASPM;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Prop</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ASPM.Prop#getID <em>ID</em>}</li>
 *   <li>{@link ASPM.Prop#getIDtrace <em>IDtrace</em>}</li>
 *   <li>{@link ASPM.Prop#getName <em>Name</em>}</li>
 *   <li>{@link ASPM.Prop#getValue <em>Value</em>}</li>
 *   <li>{@link ASPM.Prop#getModel <em>Model</em>}</li>
 *   <li>{@link ASPM.Prop#getOwner <em>Owner</em>}</li>
 *   <li>{@link ASPM.Prop#getOwnerTrace <em>Owner Trace</em>}</li>
 * </ul>
 *
 * @see ASPM.ASPMPackage#getProp()
 * @model
 * @generated
 */
public interface Prop extends LocatedElement {
	/**
	 * Returns the value of the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ID</em>' attribute.
	 * @see #setID(String)
	 * @see ASPM.ASPMPackage#getProp_ID()
	 * @model unique="false" id="true" required="true" ordered="false"
	 * @generated
	 */
	String getID();

	/**
	 * Sets the value of the '{@link ASPM.Prop#getID <em>ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ID</em>' attribute.
	 * @see #getID()
	 * @generated
	 */
	void setID(String value);

	/**
	 * Returns the value of the '<em><b>IDtrace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>IDtrace</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>IDtrace</em>' attribute.
	 * @see #setIDtrace(String)
	 * @see ASPM.ASPMPackage#getProp_IDtrace()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getIDtrace();

	/**
	 * Sets the value of the '{@link ASPM.Prop#getIDtrace <em>IDtrace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>IDtrace</em>' attribute.
	 * @see #getIDtrace()
	 * @generated
	 */
	void setIDtrace(String value);

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
	 * @see ASPM.ASPMPackage#getProp_Name()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link ASPM.Prop#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see ASPM.ASPMPackage#getProp_Value()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link ASPM.Prop#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Model</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link ASPM.Model#getProps <em>Props</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model</em>' container reference.
	 * @see #setModel(Model)
	 * @see ASPM.ASPMPackage#getProp_Model()
	 * @see ASPM.Model#getProps
	 * @model opposite="props" required="true" transient="false" ordered="false"
	 * @generated
	 */
	Model getModel();

	/**
	 * Sets the value of the '{@link ASPM.Prop#getModel <em>Model</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model</em>' container reference.
	 * @see #getModel()
	 * @generated
	 */
	void setModel(Model value);

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' reference.
	 * @see #setOwner(Node)
	 * @see ASPM.ASPMPackage#getProp_Owner()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Node getOwner();

	/**
	 * Sets the value of the '{@link ASPM.Prop#getOwner <em>Owner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(Node value);

	/**
	 * Returns the value of the '<em><b>Owner Trace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner Trace</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner Trace</em>' attribute.
	 * @see #setOwnerTrace(String)
	 * @see ASPM.ASPMPackage#getProp_OwnerTrace()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getOwnerTrace();

	/**
	 * Sets the value of the '{@link ASPM.Prop#getOwnerTrace <em>Owner Trace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner Trace</em>' attribute.
	 * @see #getOwnerTrace()
	 * @generated
	 */
	void setOwnerTrace(String value);

} // Prop
