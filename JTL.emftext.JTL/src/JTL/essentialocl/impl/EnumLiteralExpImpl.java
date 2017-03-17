/**
 */
package JTL.essentialocl.impl;

import JTL.emof.EnumerationLiteral;

import JTL.essentialocl.EnumLiteralExp;
import JTL.essentialocl.EssentialoclPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enum Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link JTL.essentialocl.impl.EnumLiteralExpImpl#getReferredEnumLiteral <em>Referred Enum Literal</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EnumLiteralExpImpl extends LiteralExpImpl implements EnumLiteralExp {
	/**
	 * The cached value of the '{@link #getReferredEnumLiteral() <em>Referred Enum Literal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredEnumLiteral()
	 * @generated
	 * @ordered
	 */
	protected EnumerationLiteral referredEnumLiteral;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnumLiteralExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EssentialoclPackage.Literals.ENUM_LITERAL_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumerationLiteral getReferredEnumLiteral() {
		if (referredEnumLiteral != null && referredEnumLiteral.eIsProxy()) {
			InternalEObject oldReferredEnumLiteral = (InternalEObject)referredEnumLiteral;
			referredEnumLiteral = (EnumerationLiteral)eResolveProxy(oldReferredEnumLiteral);
			if (referredEnumLiteral != oldReferredEnumLiteral) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EssentialoclPackage.ENUM_LITERAL_EXP__REFERRED_ENUM_LITERAL, oldReferredEnumLiteral, referredEnumLiteral));
			}
		}
		return referredEnumLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumerationLiteral basicGetReferredEnumLiteral() {
		return referredEnumLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferredEnumLiteral(EnumerationLiteral newReferredEnumLiteral) {
		EnumerationLiteral oldReferredEnumLiteral = referredEnumLiteral;
		referredEnumLiteral = newReferredEnumLiteral;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialoclPackage.ENUM_LITERAL_EXP__REFERRED_ENUM_LITERAL, oldReferredEnumLiteral, referredEnumLiteral));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EssentialoclPackage.ENUM_LITERAL_EXP__REFERRED_ENUM_LITERAL:
				if (resolve) return getReferredEnumLiteral();
				return basicGetReferredEnumLiteral();
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
			case EssentialoclPackage.ENUM_LITERAL_EXP__REFERRED_ENUM_LITERAL:
				setReferredEnumLiteral((EnumerationLiteral)newValue);
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
			case EssentialoclPackage.ENUM_LITERAL_EXP__REFERRED_ENUM_LITERAL:
				setReferredEnumLiteral((EnumerationLiteral)null);
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
			case EssentialoclPackage.ENUM_LITERAL_EXP__REFERRED_ENUM_LITERAL:
				return referredEnumLiteral != null;
		}
		return super.eIsSet(featureID);
	}

} //EnumLiteralExpImpl
