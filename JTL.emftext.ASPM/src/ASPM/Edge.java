/**
 */
package ASPM;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ASPM.Edge#getID <em>ID</em>}</li>
 *   <li>{@link ASPM.Edge#getIDtrace <em>IDtrace</em>}</li>
 *   <li>{@link ASPM.Edge#getName <em>Name</em>}</li>
 *   <li>{@link ASPM.Edge#getSource <em>Source</em>}</li>
 *   <li>{@link ASPM.Edge#getSourceTrace <em>Source Trace</em>}</li>
 *   <li>{@link ASPM.Edge#getTarget <em>Target</em>}</li>
 *   <li>{@link ASPM.Edge#getTargetTrace <em>Target Trace</em>}</li>
 *   <li>{@link ASPM.Edge#getModel <em>Model</em>}</li>
 * </ul>
 *
 * @see ASPM.ASPMPackage#getEdge()
 * @model
 * @generated
 */
public interface Edge extends LocatedElement {
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
	 * @see ASPM.ASPMPackage#getEdge_ID()
	 * @model unique="false" id="true" required="true" ordered="false"
	 * @generated
	 */
	String getID();

	/**
	 * Sets the value of the '{@link ASPM.Edge#getID <em>ID</em>}' attribute.
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
	 * @see ASPM.ASPMPackage#getEdge_IDtrace()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getIDtrace();

	/**
	 * Sets the value of the '{@link ASPM.Edge#getIDtrace <em>IDtrace</em>}' attribute.
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
	 * @see ASPM.ASPMPackage#getEdge_Name()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link ASPM.Edge#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Node)
	 * @see ASPM.ASPMPackage#getEdge_Source()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Node getSource();

	/**
	 * Sets the value of the '{@link ASPM.Edge#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Node value);

	/**
	 * Returns the value of the '<em><b>Source Trace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Trace</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Trace</em>' attribute.
	 * @see #setSourceTrace(String)
	 * @see ASPM.ASPMPackage#getEdge_SourceTrace()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getSourceTrace();

	/**
	 * Sets the value of the '{@link ASPM.Edge#getSourceTrace <em>Source Trace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Trace</em>' attribute.
	 * @see #getSourceTrace()
	 * @generated
	 */
	void setSourceTrace(String value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Node)
	 * @see ASPM.ASPMPackage#getEdge_Target()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Node getTarget();

	/**
	 * Sets the value of the '{@link ASPM.Edge#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Node value);

	/**
	 * Returns the value of the '<em><b>Target Trace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Trace</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Trace</em>' attribute.
	 * @see #setTargetTrace(String)
	 * @see ASPM.ASPMPackage#getEdge_TargetTrace()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getTargetTrace();

	/**
	 * Sets the value of the '{@link ASPM.Edge#getTargetTrace <em>Target Trace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Trace</em>' attribute.
	 * @see #getTargetTrace()
	 * @generated
	 */
	void setTargetTrace(String value);

	/**
	 * Returns the value of the '<em><b>Model</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link ASPM.Model#getEdges <em>Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model</em>' container reference.
	 * @see #setModel(Model)
	 * @see ASPM.ASPMPackage#getEdge_Model()
	 * @see ASPM.Model#getEdges
	 * @model opposite="edges" required="true" transient="false" ordered="false"
	 * @generated
	 */
	Model getModel();

	/**
	 * Sets the value of the '{@link ASPM.Edge#getModel <em>Model</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model</em>' container reference.
	 * @see #getModel()
	 * @generated
	 */
	void setModel(Model value);

} // Edge
