/**
 */
package ASPT.impl;

import ASPT.ASPTPackage;
import ASPT.TraceProp;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Trace Prop</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ASPT.impl.TracePropImpl#getIdp <em>Idp</em>}</li>
 *   <li>{@link ASPT.impl.TracePropImpl#getIdpx <em>Idpx</em>}</li>
 *   <li>{@link ASPT.impl.TracePropImpl#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TracePropImpl extends TraceElementImpl implements TraceProp {
	/**
	 * The default value of the '{@link #getIdp() <em>Idp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdp()
	 * @generated
	 * @ordered
	 */
	protected static final String IDP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIdp() <em>Idp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdp()
	 * @generated
	 * @ordered
	 */
	protected String idp = IDP_EDEFAULT;

	/**
	 * The default value of the '{@link #getIdpx() <em>Idpx</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdpx()
	 * @generated
	 * @ordered
	 */
	protected static final String IDPX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIdpx() <em>Idpx</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdpx()
	 * @generated
	 * @ordered
	 */
	protected String idpx = IDPX_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TracePropImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ASPTPackage.Literals.TRACE_PROP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIdp() {
		return idp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdp(String newIdp) {
		String oldIdp = idp;
		idp = newIdp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ASPTPackage.TRACE_PROP__IDP, oldIdp, idp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIdpx() {
		return idpx;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdpx(String newIdpx) {
		String oldIdpx = idpx;
		idpx = newIdpx;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ASPTPackage.TRACE_PROP__IDPX, oldIdpx, idpx));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ASPTPackage.TRACE_PROP__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ASPTPackage.TRACE_PROP__IDP:
				return getIdp();
			case ASPTPackage.TRACE_PROP__IDPX:
				return getIdpx();
			case ASPTPackage.TRACE_PROP__VALUE:
				return getValue();
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
			case ASPTPackage.TRACE_PROP__IDP:
				setIdp((String)newValue);
				return;
			case ASPTPackage.TRACE_PROP__IDPX:
				setIdpx((String)newValue);
				return;
			case ASPTPackage.TRACE_PROP__VALUE:
				setValue((String)newValue);
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
			case ASPTPackage.TRACE_PROP__IDP:
				setIdp(IDP_EDEFAULT);
				return;
			case ASPTPackage.TRACE_PROP__IDPX:
				setIdpx(IDPX_EDEFAULT);
				return;
			case ASPTPackage.TRACE_PROP__VALUE:
				setValue(VALUE_EDEFAULT);
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
			case ASPTPackage.TRACE_PROP__IDP:
				return IDP_EDEFAULT == null ? idp != null : !IDP_EDEFAULT.equals(idp);
			case ASPTPackage.TRACE_PROP__IDPX:
				return IDPX_EDEFAULT == null ? idpx != null : !IDPX_EDEFAULT.equals(idpx);
			case ASPTPackage.TRACE_PROP__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
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
		result.append(" (idp: ");
		result.append(idp);
		result.append(", idpx: ");
		result.append(idpx);
		result.append(", value: ");
		result.append(value);
		result.append(')');
		return result.toString();
	}

} //TracePropImpl
