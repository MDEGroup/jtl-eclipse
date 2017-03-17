/**
 */
package JTL.imperativeocl.impl;

import JTL.emof.Type;

import JTL.essentialocl.EssentialoclPackage;
import JTL.essentialocl.OclExpression;

import JTL.imperativeocl.ImperativeoclPackage;
import JTL.imperativeocl.TryExp;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Try Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link JTL.imperativeocl.impl.TryExpImpl#getTryBody <em>Try Body</em>}</li>
 *   <li>{@link JTL.imperativeocl.impl.TryExpImpl#getException <em>Exception</em>}</li>
 *   <li>{@link JTL.imperativeocl.impl.TryExpImpl#getExceptBody <em>Except Body</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TryExpImpl extends ImperativeExpressionImpl implements TryExp {
	/**
	 * The cached value of the '{@link #getTryBody() <em>Try Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTryBody()
	 * @generated
	 * @ordered
	 */
	protected OclExpression tryBody;

	/**
	 * The cached value of the '{@link #getException() <em>Exception</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getException()
	 * @generated
	 * @ordered
	 */
	protected EList<Type> exception;

	/**
	 * The cached value of the '{@link #getExceptBody() <em>Except Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExceptBody()
	 * @generated
	 * @ordered
	 */
	protected OclExpression exceptBody;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TryExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImperativeoclPackage.Literals.TRY_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression getTryBody() {
		return tryBody;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTryBody(OclExpression newTryBody, NotificationChain msgs) {
		OclExpression oldTryBody = tryBody;
		tryBody = newTryBody;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ImperativeoclPackage.TRY_EXP__TRY_BODY, oldTryBody, newTryBody);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTryBody(OclExpression newTryBody) {
		if (newTryBody != tryBody) {
			NotificationChain msgs = null;
			if (tryBody != null)
				msgs = ((InternalEObject)tryBody).eInverseRemove(this, EssentialoclPackage.OCL_EXPRESSION__TRY_BODY_OWNER, OclExpression.class, msgs);
			if (newTryBody != null)
				msgs = ((InternalEObject)newTryBody).eInverseAdd(this, EssentialoclPackage.OCL_EXPRESSION__TRY_BODY_OWNER, OclExpression.class, msgs);
			msgs = basicSetTryBody(newTryBody, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImperativeoclPackage.TRY_EXP__TRY_BODY, newTryBody, newTryBody));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Type> getException() {
		if (exception == null) {
			exception = new EObjectResolvingEList<Type>(Type.class, this, ImperativeoclPackage.TRY_EXP__EXCEPTION);
		}
		return exception;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression getExceptBody() {
		return exceptBody;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExceptBody(OclExpression newExceptBody, NotificationChain msgs) {
		OclExpression oldExceptBody = exceptBody;
		exceptBody = newExceptBody;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ImperativeoclPackage.TRY_EXP__EXCEPT_BODY, oldExceptBody, newExceptBody);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExceptBody(OclExpression newExceptBody) {
		if (newExceptBody != exceptBody) {
			NotificationChain msgs = null;
			if (exceptBody != null)
				msgs = ((InternalEObject)exceptBody).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ImperativeoclPackage.TRY_EXP__EXCEPT_BODY, null, msgs);
			if (newExceptBody != null)
				msgs = ((InternalEObject)newExceptBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ImperativeoclPackage.TRY_EXP__EXCEPT_BODY, null, msgs);
			msgs = basicSetExceptBody(newExceptBody, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImperativeoclPackage.TRY_EXP__EXCEPT_BODY, newExceptBody, newExceptBody));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ImperativeoclPackage.TRY_EXP__TRY_BODY:
				if (tryBody != null)
					msgs = ((InternalEObject)tryBody).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ImperativeoclPackage.TRY_EXP__TRY_BODY, null, msgs);
				return basicSetTryBody((OclExpression)otherEnd, msgs);
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
			case ImperativeoclPackage.TRY_EXP__TRY_BODY:
				return basicSetTryBody(null, msgs);
			case ImperativeoclPackage.TRY_EXP__EXCEPT_BODY:
				return basicSetExceptBody(null, msgs);
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
			case ImperativeoclPackage.TRY_EXP__TRY_BODY:
				return getTryBody();
			case ImperativeoclPackage.TRY_EXP__EXCEPTION:
				return getException();
			case ImperativeoclPackage.TRY_EXP__EXCEPT_BODY:
				return getExceptBody();
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
			case ImperativeoclPackage.TRY_EXP__TRY_BODY:
				setTryBody((OclExpression)newValue);
				return;
			case ImperativeoclPackage.TRY_EXP__EXCEPTION:
				getException().clear();
				getException().addAll((Collection<? extends Type>)newValue);
				return;
			case ImperativeoclPackage.TRY_EXP__EXCEPT_BODY:
				setExceptBody((OclExpression)newValue);
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
			case ImperativeoclPackage.TRY_EXP__TRY_BODY:
				setTryBody((OclExpression)null);
				return;
			case ImperativeoclPackage.TRY_EXP__EXCEPTION:
				getException().clear();
				return;
			case ImperativeoclPackage.TRY_EXP__EXCEPT_BODY:
				setExceptBody((OclExpression)null);
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
			case ImperativeoclPackage.TRY_EXP__TRY_BODY:
				return tryBody != null;
			case ImperativeoclPackage.TRY_EXP__EXCEPTION:
				return exception != null && !exception.isEmpty();
			case ImperativeoclPackage.TRY_EXP__EXCEPT_BODY:
				return exceptBody != null;
		}
		return super.eIsSet(featureID);
	}

} //TryExpImpl
