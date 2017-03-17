/**
 */
package JTL.essentialocl.impl;

import JTL.emof.impl.TypedElementImpl;

import JTL.essentialocl.CollectionLiteralExp;
import JTL.essentialocl.CollectionLiteralPart;
import JTL.essentialocl.EssentialoclPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Literal Part</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link JTL.essentialocl.impl.CollectionLiteralPartImpl#getCollectionLiteralExp <em>Collection Literal Exp</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class CollectionLiteralPartImpl extends TypedElementImpl implements CollectionLiteralPart {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CollectionLiteralPartImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EssentialoclPackage.Literals.COLLECTION_LITERAL_PART;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionLiteralExp getCollectionLiteralExp() {
		if (eContainerFeatureID() != EssentialoclPackage.COLLECTION_LITERAL_PART__COLLECTION_LITERAL_EXP) return null;
		return (CollectionLiteralExp)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCollectionLiteralExp(CollectionLiteralExp newCollectionLiteralExp, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newCollectionLiteralExp, EssentialoclPackage.COLLECTION_LITERAL_PART__COLLECTION_LITERAL_EXP, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCollectionLiteralExp(CollectionLiteralExp newCollectionLiteralExp) {
		if (newCollectionLiteralExp != eInternalContainer() || (eContainerFeatureID() != EssentialoclPackage.COLLECTION_LITERAL_PART__COLLECTION_LITERAL_EXP && newCollectionLiteralExp != null)) {
			if (EcoreUtil.isAncestor(this, newCollectionLiteralExp))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newCollectionLiteralExp != null)
				msgs = ((InternalEObject)newCollectionLiteralExp).eInverseAdd(this, EssentialoclPackage.COLLECTION_LITERAL_EXP__PART, CollectionLiteralExp.class, msgs);
			msgs = basicSetCollectionLiteralExp(newCollectionLiteralExp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialoclPackage.COLLECTION_LITERAL_PART__COLLECTION_LITERAL_EXP, newCollectionLiteralExp, newCollectionLiteralExp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EssentialoclPackage.COLLECTION_LITERAL_PART__COLLECTION_LITERAL_EXP:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetCollectionLiteralExp((CollectionLiteralExp)otherEnd, msgs);
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
			case EssentialoclPackage.COLLECTION_LITERAL_PART__COLLECTION_LITERAL_EXP:
				return basicSetCollectionLiteralExp(null, msgs);
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
			case EssentialoclPackage.COLLECTION_LITERAL_PART__COLLECTION_LITERAL_EXP:
				return eInternalContainer().eInverseRemove(this, EssentialoclPackage.COLLECTION_LITERAL_EXP__PART, CollectionLiteralExp.class, msgs);
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
			case EssentialoclPackage.COLLECTION_LITERAL_PART__COLLECTION_LITERAL_EXP:
				return getCollectionLiteralExp();
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
			case EssentialoclPackage.COLLECTION_LITERAL_PART__COLLECTION_LITERAL_EXP:
				setCollectionLiteralExp((CollectionLiteralExp)newValue);
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
			case EssentialoclPackage.COLLECTION_LITERAL_PART__COLLECTION_LITERAL_EXP:
				setCollectionLiteralExp((CollectionLiteralExp)null);
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
			case EssentialoclPackage.COLLECTION_LITERAL_PART__COLLECTION_LITERAL_EXP:
				return getCollectionLiteralExp() != null;
		}
		return super.eIsSet(featureID);
	}

} //CollectionLiteralPartImpl
