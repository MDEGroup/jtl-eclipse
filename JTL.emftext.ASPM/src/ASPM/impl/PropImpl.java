/**
 */
package ASPM.impl;

import ASPM.ASPMPackage;
import ASPM.Model;
import ASPM.Node;
import ASPM.Prop;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Prop</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ASPM.impl.PropImpl#getID <em>ID</em>}</li>
 *   <li>{@link ASPM.impl.PropImpl#getIDtrace <em>IDtrace</em>}</li>
 *   <li>{@link ASPM.impl.PropImpl#getName <em>Name</em>}</li>
 *   <li>{@link ASPM.impl.PropImpl#getValue <em>Value</em>}</li>
 *   <li>{@link ASPM.impl.PropImpl#getModel <em>Model</em>}</li>
 *   <li>{@link ASPM.impl.PropImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link ASPM.impl.PropImpl#getOwnerTrace <em>Owner Trace</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PropImpl extends LocatedElementImpl implements Prop {
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
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected String value = VALUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOwner() <em>Owner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwner()
	 * @generated
	 * @ordered
	 */
	protected Node owner;

	/**
	 * The default value of the '{@link #getOwnerTrace() <em>Owner Trace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnerTrace()
	 * @generated
	 * @ordered
	 */
	protected static final String OWNER_TRACE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOwnerTrace() <em>Owner Trace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnerTrace()
	 * @generated
	 * @ordered
	 */
	protected String ownerTrace = OWNER_TRACE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ASPMPackage.Literals.PROP;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ASPMPackage.PROP__ID, oldID, id));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ASPMPackage.PROP__IDTRACE, oldIDtrace, iDtrace));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ASPMPackage.PROP__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(String newValue) {
		String oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ASPMPackage.PROP__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Model getModel() {
		if (eContainerFeatureID() != ASPMPackage.PROP__MODEL) return null;
		return (Model)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetModel(Model newModel, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newModel, ASPMPackage.PROP__MODEL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModel(Model newModel) {
		if (newModel != eInternalContainer() || (eContainerFeatureID() != ASPMPackage.PROP__MODEL && newModel != null)) {
			if (EcoreUtil.isAncestor(this, newModel))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newModel != null)
				msgs = ((InternalEObject)newModel).eInverseAdd(this, ASPMPackage.MODEL__PROPS, Model.class, msgs);
			msgs = basicSetModel(newModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ASPMPackage.PROP__MODEL, newModel, newModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node getOwner() {
		if (owner != null && owner.eIsProxy()) {
			InternalEObject oldOwner = (InternalEObject)owner;
			owner = (Node)eResolveProxy(oldOwner);
			if (owner != oldOwner) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ASPMPackage.PROP__OWNER, oldOwner, owner));
			}
		}
		return owner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node basicGetOwner() {
		return owner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(Node newOwner) {
		Node oldOwner = owner;
		owner = newOwner;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ASPMPackage.PROP__OWNER, oldOwner, owner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOwnerTrace() {
		return ownerTrace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnerTrace(String newOwnerTrace) {
		String oldOwnerTrace = ownerTrace;
		ownerTrace = newOwnerTrace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ASPMPackage.PROP__OWNER_TRACE, oldOwnerTrace, ownerTrace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ASPMPackage.PROP__MODEL:
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
			case ASPMPackage.PROP__MODEL:
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
			case ASPMPackage.PROP__MODEL:
				return eInternalContainer().eInverseRemove(this, ASPMPackage.MODEL__PROPS, Model.class, msgs);
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
			case ASPMPackage.PROP__ID:
				return getID();
			case ASPMPackage.PROP__IDTRACE:
				return getIDtrace();
			case ASPMPackage.PROP__NAME:
				return getName();
			case ASPMPackage.PROP__VALUE:
				return getValue();
			case ASPMPackage.PROP__MODEL:
				return getModel();
			case ASPMPackage.PROP__OWNER:
				if (resolve) return getOwner();
				return basicGetOwner();
			case ASPMPackage.PROP__OWNER_TRACE:
				return getOwnerTrace();
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
			case ASPMPackage.PROP__ID:
				setID((String)newValue);
				return;
			case ASPMPackage.PROP__IDTRACE:
				setIDtrace((String)newValue);
				return;
			case ASPMPackage.PROP__NAME:
				setName((String)newValue);
				return;
			case ASPMPackage.PROP__VALUE:
				setValue((String)newValue);
				return;
			case ASPMPackage.PROP__MODEL:
				setModel((Model)newValue);
				return;
			case ASPMPackage.PROP__OWNER:
				setOwner((Node)newValue);
				return;
			case ASPMPackage.PROP__OWNER_TRACE:
				setOwnerTrace((String)newValue);
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
			case ASPMPackage.PROP__ID:
				setID(ID_EDEFAULT);
				return;
			case ASPMPackage.PROP__IDTRACE:
				setIDtrace(IDTRACE_EDEFAULT);
				return;
			case ASPMPackage.PROP__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ASPMPackage.PROP__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case ASPMPackage.PROP__MODEL:
				setModel((Model)null);
				return;
			case ASPMPackage.PROP__OWNER:
				setOwner((Node)null);
				return;
			case ASPMPackage.PROP__OWNER_TRACE:
				setOwnerTrace(OWNER_TRACE_EDEFAULT);
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
			case ASPMPackage.PROP__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case ASPMPackage.PROP__IDTRACE:
				return IDTRACE_EDEFAULT == null ? iDtrace != null : !IDTRACE_EDEFAULT.equals(iDtrace);
			case ASPMPackage.PROP__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ASPMPackage.PROP__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case ASPMPackage.PROP__MODEL:
				return getModel() != null;
			case ASPMPackage.PROP__OWNER:
				return owner != null;
			case ASPMPackage.PROP__OWNER_TRACE:
				return OWNER_TRACE_EDEFAULT == null ? ownerTrace != null : !OWNER_TRACE_EDEFAULT.equals(ownerTrace);
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
		result.append(", value: ");
		result.append(value);
		result.append(", ownerTrace: ");
		result.append(ownerTrace);
		result.append(')');
		return result.toString();
	}

} //PropImpl
