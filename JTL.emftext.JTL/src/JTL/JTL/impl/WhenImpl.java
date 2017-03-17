/**
 */
package JTL.JTL.impl;

import JTL.JTL.JTLPackage;
import JTL.JTL.Relation;
import JTL.JTL.When;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>When</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link JTL.JTL.impl.WhenImpl#getWhenOwner <em>When Owner</em>}</li>
 * </ul>
 *
 * @generated
 */
public class WhenImpl extends PatternImpl implements When {
	/**
	 * The cached value of the '{@link #getWhenOwner() <em>When Owner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWhenOwner()
	 * @generated
	 * @ordered
	 */
	protected Relation whenOwner;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WhenImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JTLPackage.Literals.WHEN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relation getWhenOwner() {
		if (whenOwner != null && whenOwner.eIsProxy()) {
			InternalEObject oldWhenOwner = (InternalEObject)whenOwner;
			whenOwner = (Relation)eResolveProxy(oldWhenOwner);
			if (whenOwner != oldWhenOwner) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, JTLPackage.WHEN__WHEN_OWNER, oldWhenOwner, whenOwner));
			}
		}
		return whenOwner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relation basicGetWhenOwner() {
		return whenOwner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWhenOwner(Relation newWhenOwner) {
		Relation oldWhenOwner = whenOwner;
		whenOwner = newWhenOwner;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JTLPackage.WHEN__WHEN_OWNER, oldWhenOwner, whenOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JTLPackage.WHEN__WHEN_OWNER:
				if (resolve) return getWhenOwner();
				return basicGetWhenOwner();
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
			case JTLPackage.WHEN__WHEN_OWNER:
				setWhenOwner((Relation)newValue);
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
			case JTLPackage.WHEN__WHEN_OWNER:
				setWhenOwner((Relation)null);
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
			case JTLPackage.WHEN__WHEN_OWNER:
				return whenOwner != null;
		}
		return super.eIsSet(featureID);
	}

} //WhenImpl
