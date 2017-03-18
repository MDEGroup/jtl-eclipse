/**
 */
package JTL.JTL.impl;

import JTL.JTL.JTLPackage;
import JTL.JTL.Relation;
import JTL.JTL.Where;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

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
		if (eContainerFeatureID() != JTLPackage.WHERE__WHERE_OWNER) return null;
		return (Relation)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWhereOwner(Relation newWhereOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newWhereOwner, JTLPackage.WHERE__WHERE_OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWhereOwner(Relation newWhereOwner) {
		if (newWhereOwner != eInternalContainer() || (eContainerFeatureID() != JTLPackage.WHERE__WHERE_OWNER && newWhereOwner != null)) {
			if (EcoreUtil.isAncestor(this, newWhereOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newWhereOwner != null)
				msgs = ((InternalEObject)newWhereOwner).eInverseAdd(this, JTLPackage.RELATION__WHERE, Relation.class, msgs);
			msgs = basicSetWhereOwner(newWhereOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JTLPackage.WHERE__WHERE_OWNER, newWhereOwner, newWhereOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JTLPackage.WHERE__WHERE_OWNER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetWhereOwner((Relation)otherEnd, msgs);
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
			case JTLPackage.WHERE__WHERE_OWNER:
				return basicSetWhereOwner(null, msgs);
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
			case JTLPackage.WHERE__WHERE_OWNER:
				return eInternalContainer().eInverseRemove(this, JTLPackage.RELATION__WHERE, Relation.class, msgs);
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
			case JTLPackage.WHERE__WHERE_OWNER:
				return getWhereOwner();
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
				return getWhereOwner() != null;
		}
		return super.eIsSet(featureID);
	}

} //WhereImpl
