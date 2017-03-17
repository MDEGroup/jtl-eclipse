/**
 */
package JTL.imperativeocl.impl;

import JTL.essentialocl.OclExpression;

import JTL.essentialocl.impl.CallExpImpl;

import JTL.imperativeocl.AltExp;
import JTL.imperativeocl.ImperativeoclPackage;
import JTL.imperativeocl.SwitchExp;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Switch Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link JTL.imperativeocl.impl.SwitchExpImpl#getAlternativePart <em>Alternative Part</em>}</li>
 *   <li>{@link JTL.imperativeocl.impl.SwitchExpImpl#getElsePart <em>Else Part</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SwitchExpImpl extends CallExpImpl implements SwitchExp {
	/**
	 * The cached value of the '{@link #getAlternativePart() <em>Alternative Part</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlternativePart()
	 * @generated
	 * @ordered
	 */
	protected EList<AltExp> alternativePart;

	/**
	 * The cached value of the '{@link #getElsePart() <em>Else Part</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElsePart()
	 * @generated
	 * @ordered
	 */
	protected OclExpression elsePart;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SwitchExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImperativeoclPackage.Literals.SWITCH_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AltExp> getAlternativePart() {
		if (alternativePart == null) {
			alternativePart = new EObjectContainmentEList<AltExp>(AltExp.class, this, ImperativeoclPackage.SWITCH_EXP__ALTERNATIVE_PART);
		}
		return alternativePart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression getElsePart() {
		return elsePart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetElsePart(OclExpression newElsePart, NotificationChain msgs) {
		OclExpression oldElsePart = elsePart;
		elsePart = newElsePart;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ImperativeoclPackage.SWITCH_EXP__ELSE_PART, oldElsePart, newElsePart);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElsePart(OclExpression newElsePart) {
		if (newElsePart != elsePart) {
			NotificationChain msgs = null;
			if (elsePart != null)
				msgs = ((InternalEObject)elsePart).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ImperativeoclPackage.SWITCH_EXP__ELSE_PART, null, msgs);
			if (newElsePart != null)
				msgs = ((InternalEObject)newElsePart).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ImperativeoclPackage.SWITCH_EXP__ELSE_PART, null, msgs);
			msgs = basicSetElsePart(newElsePart, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImperativeoclPackage.SWITCH_EXP__ELSE_PART, newElsePart, newElsePart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ImperativeoclPackage.SWITCH_EXP__ALTERNATIVE_PART:
				return ((InternalEList<?>)getAlternativePart()).basicRemove(otherEnd, msgs);
			case ImperativeoclPackage.SWITCH_EXP__ELSE_PART:
				return basicSetElsePart(null, msgs);
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
			case ImperativeoclPackage.SWITCH_EXP__ALTERNATIVE_PART:
				return getAlternativePart();
			case ImperativeoclPackage.SWITCH_EXP__ELSE_PART:
				return getElsePart();
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
			case ImperativeoclPackage.SWITCH_EXP__ALTERNATIVE_PART:
				getAlternativePart().clear();
				getAlternativePart().addAll((Collection<? extends AltExp>)newValue);
				return;
			case ImperativeoclPackage.SWITCH_EXP__ELSE_PART:
				setElsePart((OclExpression)newValue);
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
			case ImperativeoclPackage.SWITCH_EXP__ALTERNATIVE_PART:
				getAlternativePart().clear();
				return;
			case ImperativeoclPackage.SWITCH_EXP__ELSE_PART:
				setElsePart((OclExpression)null);
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
			case ImperativeoclPackage.SWITCH_EXP__ALTERNATIVE_PART:
				return alternativePart != null && !alternativePart.isEmpty();
			case ImperativeoclPackage.SWITCH_EXP__ELSE_PART:
				return elsePart != null;
		}
		return super.eIsSet(featureID);
	}

} //SwitchExpImpl
