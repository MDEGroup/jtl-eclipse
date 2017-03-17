/**
 */
package JTL.essentialocl.impl;

import JTL.emof.impl.TypedElementImpl;

import JTL.essentialocl.EssentialoclPackage;
import JTL.essentialocl.TupleLiteralExp;
import JTL.essentialocl.TupleLiteralPart;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tuple Literal Part</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link JTL.essentialocl.impl.TupleLiteralPartImpl#getTupleLiteralExp <em>Tuple Literal Exp</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TupleLiteralPartImpl extends TypedElementImpl implements TupleLiteralPart {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TupleLiteralPartImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EssentialoclPackage.Literals.TUPLE_LITERAL_PART;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TupleLiteralExp getTupleLiteralExp() {
		if (eContainerFeatureID() != EssentialoclPackage.TUPLE_LITERAL_PART__TUPLE_LITERAL_EXP) return null;
		return (TupleLiteralExp)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTupleLiteralExp(TupleLiteralExp newTupleLiteralExp, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newTupleLiteralExp, EssentialoclPackage.TUPLE_LITERAL_PART__TUPLE_LITERAL_EXP, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTupleLiteralExp(TupleLiteralExp newTupleLiteralExp) {
		if (newTupleLiteralExp != eInternalContainer() || (eContainerFeatureID() != EssentialoclPackage.TUPLE_LITERAL_PART__TUPLE_LITERAL_EXP && newTupleLiteralExp != null)) {
			if (EcoreUtil.isAncestor(this, newTupleLiteralExp))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newTupleLiteralExp != null)
				msgs = ((InternalEObject)newTupleLiteralExp).eInverseAdd(this, EssentialoclPackage.TUPLE_LITERAL_EXP__PART, TupleLiteralExp.class, msgs);
			msgs = basicSetTupleLiteralExp(newTupleLiteralExp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialoclPackage.TUPLE_LITERAL_PART__TUPLE_LITERAL_EXP, newTupleLiteralExp, newTupleLiteralExp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EssentialoclPackage.TUPLE_LITERAL_PART__TUPLE_LITERAL_EXP:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetTupleLiteralExp((TupleLiteralExp)otherEnd, msgs);
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
			case EssentialoclPackage.TUPLE_LITERAL_PART__TUPLE_LITERAL_EXP:
				return basicSetTupleLiteralExp(null, msgs);
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
			case EssentialoclPackage.TUPLE_LITERAL_PART__TUPLE_LITERAL_EXP:
				return eInternalContainer().eInverseRemove(this, EssentialoclPackage.TUPLE_LITERAL_EXP__PART, TupleLiteralExp.class, msgs);
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
			case EssentialoclPackage.TUPLE_LITERAL_PART__TUPLE_LITERAL_EXP:
				return getTupleLiteralExp();
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
			case EssentialoclPackage.TUPLE_LITERAL_PART__TUPLE_LITERAL_EXP:
				setTupleLiteralExp((TupleLiteralExp)newValue);
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
			case EssentialoclPackage.TUPLE_LITERAL_PART__TUPLE_LITERAL_EXP:
				setTupleLiteralExp((TupleLiteralExp)null);
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
			case EssentialoclPackage.TUPLE_LITERAL_PART__TUPLE_LITERAL_EXP:
				return getTupleLiteralExp() != null;
		}
		return super.eIsSet(featureID);
	}

} //TupleLiteralPartImpl
