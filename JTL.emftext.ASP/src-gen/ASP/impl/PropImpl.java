/**
 */
package ASP.impl;

import ASP.ASPPackage;
import ASP.Prop;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Prop</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ASP.impl.PropImpl#isIsPropx <em>Is Propx</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PropImpl extends FunctionImpl implements Prop {
	/**
	 * The default value of the '{@link #isIsPropx() <em>Is Propx</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsPropx()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_PROPX_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsPropx() <em>Is Propx</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsPropx()
	 * @generated
	 * @ordered
	 */
	protected boolean isPropx = IS_PROPX_EDEFAULT;

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
		return ASPPackage.Literals.PROP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsPropx() {
		return isPropx;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsPropx(boolean newIsPropx) {
		boolean oldIsPropx = isPropx;
		isPropx = newIsPropx;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ASPPackage.PROP__IS_PROPX, oldIsPropx, isPropx));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ASPPackage.PROP__IS_PROPX:
				return isIsPropx();
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
			case ASPPackage.PROP__IS_PROPX:
				setIsPropx((Boolean)newValue);
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
			case ASPPackage.PROP__IS_PROPX:
				setIsPropx(IS_PROPX_EDEFAULT);
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
			case ASPPackage.PROP__IS_PROPX:
				return isPropx != IS_PROPX_EDEFAULT;
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
		result.append(" (isPropx: ");
		result.append(isPropx);
		result.append(')');
		return result.toString();
	}

} //PropImpl
