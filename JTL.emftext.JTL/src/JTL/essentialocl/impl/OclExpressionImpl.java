/**
 */
package JTL.essentialocl.impl;

import JTL.emof.impl.TypedElementImpl;

import JTL.essentialocl.EssentialoclPackage;
import JTL.essentialocl.OclExpression;

import JTL.imperativeocl.ImperativeoclPackage;
import JTL.imperativeocl.TryExp;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ocl Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link JTL.essentialocl.impl.OclExpressionImpl#getTryBodyOwner <em>Try Body Owner</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class OclExpressionImpl extends TypedElementImpl implements OclExpression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OclExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EssentialoclPackage.Literals.OCL_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TryExp getTryBodyOwner() {
		if (eContainerFeatureID() != EssentialoclPackage.OCL_EXPRESSION__TRY_BODY_OWNER) return null;
		return (TryExp)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTryBodyOwner(TryExp newTryBodyOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newTryBodyOwner, EssentialoclPackage.OCL_EXPRESSION__TRY_BODY_OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTryBodyOwner(TryExp newTryBodyOwner) {
		if (newTryBodyOwner != eInternalContainer() || (eContainerFeatureID() != EssentialoclPackage.OCL_EXPRESSION__TRY_BODY_OWNER && newTryBodyOwner != null)) {
			if (EcoreUtil.isAncestor(this, newTryBodyOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newTryBodyOwner != null)
				msgs = ((InternalEObject)newTryBodyOwner).eInverseAdd(this, ImperativeoclPackage.TRY_EXP__TRY_BODY, TryExp.class, msgs);
			msgs = basicSetTryBodyOwner(newTryBodyOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialoclPackage.OCL_EXPRESSION__TRY_BODY_OWNER, newTryBodyOwner, newTryBodyOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EssentialoclPackage.OCL_EXPRESSION__TRY_BODY_OWNER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetTryBodyOwner((TryExp)otherEnd, msgs);
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
			case EssentialoclPackage.OCL_EXPRESSION__TRY_BODY_OWNER:
				return basicSetTryBodyOwner(null, msgs);
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
			case EssentialoclPackage.OCL_EXPRESSION__TRY_BODY_OWNER:
				return eInternalContainer().eInverseRemove(this, ImperativeoclPackage.TRY_EXP__TRY_BODY, TryExp.class, msgs);
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
			case EssentialoclPackage.OCL_EXPRESSION__TRY_BODY_OWNER:
				return getTryBodyOwner();
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
			case EssentialoclPackage.OCL_EXPRESSION__TRY_BODY_OWNER:
				setTryBodyOwner((TryExp)newValue);
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
			case EssentialoclPackage.OCL_EXPRESSION__TRY_BODY_OWNER:
				setTryBodyOwner((TryExp)null);
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
			case EssentialoclPackage.OCL_EXPRESSION__TRY_BODY_OWNER:
				return getTryBodyOwner() != null;
		}
		return super.eIsSet(featureID);
	}

} //OclExpressionImpl
