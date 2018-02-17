/**
 */
package ASPT.impl;

import ASPT.ASPTPackage;
import ASPT.TraceElement;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Trace Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ASPT.impl.TraceElementImpl#getMetamodel <em>Metamodel</em>}</li>
 *   <li>{@link ASPT.impl.TraceElementImpl#getId <em>Id</em>}</li>
 *   <li>{@link ASPT.impl.TraceElementImpl#getIdx <em>Idx</em>}</li>
 *   <li>{@link ASPT.impl.TraceElementImpl#getType <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TraceElementImpl extends MinimalEObjectImpl.Container implements TraceElement {
	/**
	 * The default value of the '{@link #getMetamodel() <em>Metamodel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetamodel()
	 * @generated
	 * @ordered
	 */
	protected static final String METAMODEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMetamodel() <em>Metamodel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetamodel()
	 * @generated
	 * @ordered
	 */
	protected String metamodel = METAMODEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getIdx() <em>Idx</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdx()
	 * @generated
	 * @ordered
	 */
	protected static final String IDX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIdx() <em>Idx</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdx()
	 * @generated
	 * @ordered
	 */
	protected String idx = IDX_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TraceElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ASPTPackage.Literals.TRACE_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMetamodel() {
		return metamodel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetamodel(String newMetamodel) {
		String oldMetamodel = metamodel;
		metamodel = newMetamodel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ASPTPackage.TRACE_ELEMENT__METAMODEL, oldMetamodel, metamodel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ASPTPackage.TRACE_ELEMENT__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIdx() {
		return idx;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdx(String newIdx) {
		String oldIdx = idx;
		idx = newIdx;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ASPTPackage.TRACE_ELEMENT__IDX, oldIdx, idx));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ASPTPackage.TRACE_ELEMENT__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ASPTPackage.TRACE_ELEMENT__METAMODEL:
				return getMetamodel();
			case ASPTPackage.TRACE_ELEMENT__ID:
				return getId();
			case ASPTPackage.TRACE_ELEMENT__IDX:
				return getIdx();
			case ASPTPackage.TRACE_ELEMENT__TYPE:
				return getType();
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
			case ASPTPackage.TRACE_ELEMENT__METAMODEL:
				setMetamodel((String)newValue);
				return;
			case ASPTPackage.TRACE_ELEMENT__ID:
				setId((String)newValue);
				return;
			case ASPTPackage.TRACE_ELEMENT__IDX:
				setIdx((String)newValue);
				return;
			case ASPTPackage.TRACE_ELEMENT__TYPE:
				setType((String)newValue);
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
			case ASPTPackage.TRACE_ELEMENT__METAMODEL:
				setMetamodel(METAMODEL_EDEFAULT);
				return;
			case ASPTPackage.TRACE_ELEMENT__ID:
				setId(ID_EDEFAULT);
				return;
			case ASPTPackage.TRACE_ELEMENT__IDX:
				setIdx(IDX_EDEFAULT);
				return;
			case ASPTPackage.TRACE_ELEMENT__TYPE:
				setType(TYPE_EDEFAULT);
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
			case ASPTPackage.TRACE_ELEMENT__METAMODEL:
				return METAMODEL_EDEFAULT == null ? metamodel != null : !METAMODEL_EDEFAULT.equals(metamodel);
			case ASPTPackage.TRACE_ELEMENT__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case ASPTPackage.TRACE_ELEMENT__IDX:
				return IDX_EDEFAULT == null ? idx != null : !IDX_EDEFAULT.equals(idx);
			case ASPTPackage.TRACE_ELEMENT__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
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
		result.append(" (metamodel: ");
		result.append(metamodel);
		result.append(", id: ");
		result.append(id);
		result.append(", idx: ");
		result.append(idx);
		result.append(", type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //TraceElementImpl
