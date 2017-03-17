/**
 */
package ASPM.impl;

import ASPM.ASPMPackage;
import ASPM.Edge;
import ASPM.Model;
import ASPM.Node;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Edge</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ASPM.impl.EdgeImpl#getID <em>ID</em>}</li>
 *   <li>{@link ASPM.impl.EdgeImpl#getIDtrace <em>IDtrace</em>}</li>
 *   <li>{@link ASPM.impl.EdgeImpl#getName <em>Name</em>}</li>
 *   <li>{@link ASPM.impl.EdgeImpl#getSource <em>Source</em>}</li>
 *   <li>{@link ASPM.impl.EdgeImpl#getSourceTrace <em>Source Trace</em>}</li>
 *   <li>{@link ASPM.impl.EdgeImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link ASPM.impl.EdgeImpl#getTargetTrace <em>Target Trace</em>}</li>
 *   <li>{@link ASPM.impl.EdgeImpl#getModel <em>Model</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EdgeImpl extends LocatedElementImpl implements Edge {
	/**
	 * The default value of the '{@link #getID() <em>ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getID()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getID() <em>ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getID()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getIDtrace() <em>IDtrace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIDtrace()
	 * @generated
	 * @ordered
	 */
	protected static final String IDTRACE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIDtrace() <em>IDtrace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIDtrace()
	 * @generated
	 * @ordered
	 */
	protected String iDtrace = IDTRACE_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected Node source;

	/**
	 * The default value of the '{@link #getSourceTrace() <em>Source Trace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceTrace()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_TRACE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSourceTrace() <em>Source Trace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceTrace()
	 * @generated
	 * @ordered
	 */
	protected String sourceTrace = SOURCE_TRACE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected Node target;

	/**
	 * The default value of the '{@link #getTargetTrace() <em>Target Trace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetTrace()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_TRACE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTargetTrace() <em>Target Trace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetTrace()
	 * @generated
	 * @ordered
	 */
	protected String targetTrace = TARGET_TRACE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EdgeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ASPMPackage.Literals.EDGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getID() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setID(String newID) {
		String oldID = id;
		id = newID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ASPMPackage.EDGE__ID, oldID, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIDtrace() {
		return iDtrace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIDtrace(String newIDtrace) {
		String oldIDtrace = iDtrace;
		iDtrace = newIDtrace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ASPMPackage.EDGE__IDTRACE, oldIDtrace, iDtrace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ASPMPackage.EDGE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (Node)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ASPMPackage.EDGE__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(Node newSource) {
		Node oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ASPMPackage.EDGE__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSourceTrace() {
		return sourceTrace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceTrace(String newSourceTrace) {
		String oldSourceTrace = sourceTrace;
		sourceTrace = newSourceTrace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ASPMPackage.EDGE__SOURCE_TRACE, oldSourceTrace, sourceTrace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (Node)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ASPMPackage.EDGE__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(Node newTarget) {
		Node oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ASPMPackage.EDGE__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTargetTrace() {
		return targetTrace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetTrace(String newTargetTrace) {
		String oldTargetTrace = targetTrace;
		targetTrace = newTargetTrace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ASPMPackage.EDGE__TARGET_TRACE, oldTargetTrace, targetTrace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Model getModel() {
		if (eContainerFeatureID() != ASPMPackage.EDGE__MODEL) return null;
		return (Model)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetModel(Model newModel, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newModel, ASPMPackage.EDGE__MODEL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModel(Model newModel) {
		if (newModel != eInternalContainer() || (eContainerFeatureID() != ASPMPackage.EDGE__MODEL && newModel != null)) {
			if (EcoreUtil.isAncestor(this, newModel))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newModel != null)
				msgs = ((InternalEObject)newModel).eInverseAdd(this, ASPMPackage.MODEL__EDGES, Model.class, msgs);
			msgs = basicSetModel(newModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ASPMPackage.EDGE__MODEL, newModel, newModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ASPMPackage.EDGE__MODEL:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetModel((Model)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ASPMPackage.EDGE__MODEL:
				return basicSetModel(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case ASPMPackage.EDGE__MODEL:
				return eInternalContainer().eInverseRemove(this, ASPMPackage.MODEL__EDGES, Model.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ASPMPackage.EDGE__ID:
				return getID();
			case ASPMPackage.EDGE__IDTRACE:
				return getIDtrace();
			case ASPMPackage.EDGE__NAME:
				return getName();
			case ASPMPackage.EDGE__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case ASPMPackage.EDGE__SOURCE_TRACE:
				return getSourceTrace();
			case ASPMPackage.EDGE__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case ASPMPackage.EDGE__TARGET_TRACE:
				return getTargetTrace();
			case ASPMPackage.EDGE__MODEL:
				return getModel();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ASPMPackage.EDGE__ID:
				setID((String)newValue);
				return;
			case ASPMPackage.EDGE__IDTRACE:
				setIDtrace((String)newValue);
				return;
			case ASPMPackage.EDGE__NAME:
				setName((String)newValue);
				return;
			case ASPMPackage.EDGE__SOURCE:
				setSource((Node)newValue);
				return;
			case ASPMPackage.EDGE__SOURCE_TRACE:
				setSourceTrace((String)newValue);
				return;
			case ASPMPackage.EDGE__TARGET:
				setTarget((Node)newValue);
				return;
			case ASPMPackage.EDGE__TARGET_TRACE:
				setTargetTrace((String)newValue);
				return;
			case ASPMPackage.EDGE__MODEL:
				setModel((Model)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ASPMPackage.EDGE__ID:
				setID(ID_EDEFAULT);
				return;
			case ASPMPackage.EDGE__IDTRACE:
				setIDtrace(IDTRACE_EDEFAULT);
				return;
			case ASPMPackage.EDGE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ASPMPackage.EDGE__SOURCE:
				setSource((Node)null);
				return;
			case ASPMPackage.EDGE__SOURCE_TRACE:
				setSourceTrace(SOURCE_TRACE_EDEFAULT);
				return;
			case ASPMPackage.EDGE__TARGET:
				setTarget((Node)null);
				return;
			case ASPMPackage.EDGE__TARGET_TRACE:
				setTargetTrace(TARGET_TRACE_EDEFAULT);
				return;
			case ASPMPackage.EDGE__MODEL:
				setModel((Model)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ASPMPackage.EDGE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case ASPMPackage.EDGE__IDTRACE:
				return IDTRACE_EDEFAULT == null ? iDtrace != null : !IDTRACE_EDEFAULT.equals(iDtrace);
			case ASPMPackage.EDGE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ASPMPackage.EDGE__SOURCE:
				return source != null;
			case ASPMPackage.EDGE__SOURCE_TRACE:
				return SOURCE_TRACE_EDEFAULT == null ? sourceTrace != null : !SOURCE_TRACE_EDEFAULT.equals(sourceTrace);
			case ASPMPackage.EDGE__TARGET:
				return target != null;
			case ASPMPackage.EDGE__TARGET_TRACE:
				return TARGET_TRACE_EDEFAULT == null ? targetTrace != null : !TARGET_TRACE_EDEFAULT.equals(targetTrace);
			case ASPMPackage.EDGE__MODEL:
				return getModel() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (ID: ");
		result.append(id);
		result.append(", IDtrace: ");
		result.append(iDtrace);
		result.append(", name: ");
		result.append(name);
		result.append(", sourceTrace: ");
		result.append(sourceTrace);
		result.append(", targetTrace: ");
		result.append(targetTrace);
		result.append(')');
		return result.toString();
	}

} //EdgeImpl
