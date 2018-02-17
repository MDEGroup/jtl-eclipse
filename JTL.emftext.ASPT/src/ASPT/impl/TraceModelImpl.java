/**
 */
package ASPT.impl;

import ASPT.ASPTPackage;
import ASPT.TraceElement;
import ASPT.TraceLink;
import ASPT.TraceModel;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Trace Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ASPT.impl.TraceModelImpl#getTracelinks <em>Tracelinks</em>}</li>
 *   <li>{@link ASPT.impl.TraceModelImpl#getTraceelements <em>Traceelements</em>}</li>
 *   <li>{@link ASPT.impl.TraceModelImpl#getID <em>ID</em>}</li>
 *   <li>{@link ASPT.impl.TraceModelImpl#getMMS <em>MMS</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TraceModelImpl extends MinimalEObjectImpl.Container implements TraceModel {
	/**
	 * The cached value of the '{@link #getTracelinks() <em>Tracelinks</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTracelinks()
	 * @generated
	 * @ordered
	 */
	protected EList<TraceLink> tracelinks;

	/**
	 * The cached value of the '{@link #getTraceelements() <em>Traceelements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTraceelements()
	 * @generated
	 * @ordered
	 */
	protected EList<TraceElement> traceelements;

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
	 * The default value of the '{@link #getMMS() <em>MMS</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMMS()
	 * @generated
	 * @ordered
	 */
	protected static final String MMS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMMS() <em>MMS</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMMS()
	 * @generated
	 * @ordered
	 */
	protected String mms = MMS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TraceModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ASPTPackage.Literals.TRACE_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TraceLink> getTracelinks() {
		if (tracelinks == null) {
			tracelinks = new EObjectContainmentEList<TraceLink>(TraceLink.class, this, ASPTPackage.TRACE_MODEL__TRACELINKS);
		}
		return tracelinks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TraceElement> getTraceelements() {
		if (traceelements == null) {
			traceelements = new EObjectContainmentEList<TraceElement>(TraceElement.class, this, ASPTPackage.TRACE_MODEL__TRACEELEMENTS);
		}
		return traceelements;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ASPTPackage.TRACE_MODEL__ID, oldID, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMMS() {
		return mms;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMMS(String newMMS) {
		String oldMMS = mms;
		mms = newMMS;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ASPTPackage.TRACE_MODEL__MMS, oldMMS, mms));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ASPTPackage.TRACE_MODEL__TRACELINKS:
				return ((InternalEList<?>)getTracelinks()).basicRemove(otherEnd, msgs);
			case ASPTPackage.TRACE_MODEL__TRACEELEMENTS:
				return ((InternalEList<?>)getTraceelements()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ASPTPackage.TRACE_MODEL__TRACELINKS:
				return getTracelinks();
			case ASPTPackage.TRACE_MODEL__TRACEELEMENTS:
				return getTraceelements();
			case ASPTPackage.TRACE_MODEL__ID:
				return getID();
			case ASPTPackage.TRACE_MODEL__MMS:
				return getMMS();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ASPTPackage.TRACE_MODEL__TRACELINKS:
				getTracelinks().clear();
				getTracelinks().addAll((Collection<? extends TraceLink>)newValue);
				return;
			case ASPTPackage.TRACE_MODEL__TRACEELEMENTS:
				getTraceelements().clear();
				getTraceelements().addAll((Collection<? extends TraceElement>)newValue);
				return;
			case ASPTPackage.TRACE_MODEL__ID:
				setID((String)newValue);
				return;
			case ASPTPackage.TRACE_MODEL__MMS:
				setMMS((String)newValue);
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
			case ASPTPackage.TRACE_MODEL__TRACELINKS:
				getTracelinks().clear();
				return;
			case ASPTPackage.TRACE_MODEL__TRACEELEMENTS:
				getTraceelements().clear();
				return;
			case ASPTPackage.TRACE_MODEL__ID:
				setID(ID_EDEFAULT);
				return;
			case ASPTPackage.TRACE_MODEL__MMS:
				setMMS(MMS_EDEFAULT);
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
			case ASPTPackage.TRACE_MODEL__TRACELINKS:
				return tracelinks != null && !tracelinks.isEmpty();
			case ASPTPackage.TRACE_MODEL__TRACEELEMENTS:
				return traceelements != null && !traceelements.isEmpty();
			case ASPTPackage.TRACE_MODEL__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case ASPTPackage.TRACE_MODEL__MMS:
				return MMS_EDEFAULT == null ? mms != null : !MMS_EDEFAULT.equals(mms);
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
		result.append(", MMS: ");
		result.append(mms);
		result.append(')');
		return result.toString();
	}

} //TraceModelImpl
