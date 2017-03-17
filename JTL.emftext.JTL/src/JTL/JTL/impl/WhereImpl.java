/**
 */
package JTL.JTL.impl;

import JTL.JTL.JTLPackage;
import JTL.JTL.Relation;
import JTL.JTL.Where;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Where</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link JTL.JTL.impl.WhereImpl#getWhereOwner <em>Where Owner</em>}</li>
 * </ul>
 *
 * @generated
 */
public class WhereImpl extends PatternImpl implements Where {
	/**
	 * The cached value of the '{@link #getWhereOwner() <em>Where Owner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWhereOwner()
	 * @generated
	 * @ordered
	 */
	protected Relation whereOwner;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WhereImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JTLPackage.Literals.WHERE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relation getWhereOwner() {
		if (whereOwner != null && whereOwner.eIsProxy()) {
			InternalEObject oldWhereOwner = (InternalEObject)whereOwner;
			whereOwner = (Relation)eResolveProxy(oldWhereOwner);
			if (whereOwner != oldWhereOwner) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, JTLPackage.WHERE__WHERE_OWNER, oldWhereOwner, whereOwner));
			}
		}
		return whereOwner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relation basicGetWhereOwner() {
		return whereOwner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWhereOwner(Relation newWhereOwner) {
		Relation oldWhereOwner = whereOwner;
		whereOwner = newWhereOwner;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JTLPackage.WHERE__WHERE_OWNER, oldWhereOwner, whereOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JTLPackage.WHERE__WHERE_OWNER:
				if (resolve) return getWhereOwner();
				return basicGetWhereOwner();
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
			case JTLPackage.WHERE__WHERE_OWNER:
				setWhereOwner((Relation)newValue);
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
			case JTLPackage.WHERE__WHERE_OWNER:
				setWhereOwner((Relation)null);
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
			case JTLPackage.WHERE__WHERE_OWNER:
				return whereOwner != null;
		}
		return super.eIsSet(featureID);
	}

} //WhereImpl
