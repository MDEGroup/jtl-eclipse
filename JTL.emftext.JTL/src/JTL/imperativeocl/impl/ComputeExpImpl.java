/**
 */
package JTL.imperativeocl.impl;

import JTL.essentialocl.EssentialoclPackage;
import JTL.essentialocl.OclExpression;
import JTL.essentialocl.Variable;

import JTL.imperativeocl.ComputeExp;
import JTL.imperativeocl.ImperativeoclPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Compute Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link JTL.imperativeocl.impl.ComputeExpImpl#getReturnedElement <em>Returned Element</em>}</li>
 *   <li>{@link JTL.imperativeocl.impl.ComputeExpImpl#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ComputeExpImpl extends ImperativeExpressionImpl implements ComputeExp {
	/**
	 * The cached value of the '{@link #getReturnedElement() <em>Returned Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReturnedElement()
	 * @generated
	 * @ordered
	 */
	protected Variable returnedElement;

	/**
	 * The cached value of the '{@link #getBody() <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBody()
	 * @generated
	 * @ordered
	 */
	protected OclExpression body;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComputeExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImperativeoclPackage.Literals.COMPUTE_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getReturnedElement() {
		return returnedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReturnedElement(Variable newReturnedElement, NotificationChain msgs) {
		Variable oldReturnedElement = returnedElement;
		returnedElement = newReturnedElement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ImperativeoclPackage.COMPUTE_EXP__RETURNED_ELEMENT, oldReturnedElement, newReturnedElement);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReturnedElement(Variable newReturnedElement) {
		if (newReturnedElement != returnedElement) {
			NotificationChain msgs = null;
			if (returnedElement != null)
				msgs = ((InternalEObject)returnedElement).eInverseRemove(this, EssentialoclPackage.VARIABLE__COMPUTE_OWNER, Variable.class, msgs);
			if (newReturnedElement != null)
				msgs = ((InternalEObject)newReturnedElement).eInverseAdd(this, EssentialoclPackage.VARIABLE__COMPUTE_OWNER, Variable.class, msgs);
			msgs = basicSetReturnedElement(newReturnedElement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImperativeoclPackage.COMPUTE_EXP__RETURNED_ELEMENT, newReturnedElement, newReturnedElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression getBody() {
		return body;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBody(OclExpression newBody, NotificationChain msgs) {
		OclExpression oldBody = body;
		body = newBody;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ImperativeoclPackage.COMPUTE_EXP__BODY, oldBody, newBody);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBody(OclExpression newBody) {
		if (newBody != body) {
			NotificationChain msgs = null;
			if (body != null)
				msgs = ((InternalEObject)body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ImperativeoclPackage.COMPUTE_EXP__BODY, null, msgs);
			if (newBody != null)
				msgs = ((InternalEObject)newBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ImperativeoclPackage.COMPUTE_EXP__BODY, null, msgs);
			msgs = basicSetBody(newBody, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImperativeoclPackage.COMPUTE_EXP__BODY, newBody, newBody));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ImperativeoclPackage.COMPUTE_EXP__RETURNED_ELEMENT:
				if (returnedElement != null)
					msgs = ((InternalEObject)returnedElement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ImperativeoclPackage.COMPUTE_EXP__RETURNED_ELEMENT, null, msgs);
				return basicSetReturnedElement((Variable)otherEnd, msgs);
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
			case ImperativeoclPackage.COMPUTE_EXP__RETURNED_ELEMENT:
				return basicSetReturnedElement(null, msgs);
			case ImperativeoclPackage.COMPUTE_EXP__BODY:
				return basicSetBody(null, msgs);
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
			case ImperativeoclPackage.COMPUTE_EXP__RETURNED_ELEMENT:
				return getReturnedElement();
			case ImperativeoclPackage.COMPUTE_EXP__BODY:
				return getBody();
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
			case ImperativeoclPackage.COMPUTE_EXP__RETURNED_ELEMENT:
				setReturnedElement((Variable)newValue);
				return;
			case ImperativeoclPackage.COMPUTE_EXP__BODY:
				setBody((OclExpression)newValue);
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
			case ImperativeoclPackage.COMPUTE_EXP__RETURNED_ELEMENT:
				setReturnedElement((Variable)null);
				return;
			case ImperativeoclPackage.COMPUTE_EXP__BODY:
				setBody((OclExpression)null);
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
			case ImperativeoclPackage.COMPUTE_EXP__RETURNED_ELEMENT:
				return returnedElement != null;
			case ImperativeoclPackage.COMPUTE_EXP__BODY:
				return body != null;
		}
		return super.eIsSet(featureID);
	}

} //ComputeExpImpl
