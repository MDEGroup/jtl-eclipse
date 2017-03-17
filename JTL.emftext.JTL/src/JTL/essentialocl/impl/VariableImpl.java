/**
 */
package JTL.essentialocl.impl;

import JTL.emof.Parameter;

import JTL.emof.impl.TypedElementImpl;

import JTL.essentialocl.EssentialoclPackage;
import JTL.essentialocl.LetExp;
import JTL.essentialocl.OclExpression;
import JTL.essentialocl.Variable;

import JTL.imperativeocl.ComputeExp;
import JTL.imperativeocl.ImperativeoclPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link JTL.essentialocl.impl.VariableImpl#getInitExpression <em>Init Expression</em>}</li>
 *   <li>{@link JTL.essentialocl.impl.VariableImpl#getLetExp <em>Let Exp</em>}</li>
 *   <li>{@link JTL.essentialocl.impl.VariableImpl#getBindParameter <em>Bind Parameter</em>}</li>
 *   <li>{@link JTL.essentialocl.impl.VariableImpl#getComputeOwner <em>Compute Owner</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VariableImpl extends TypedElementImpl implements Variable {
	/**
	 * The cached value of the '{@link #getInitExpression() <em>Init Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitExpression()
	 * @generated
	 * @ordered
	 */
	protected OclExpression initExpression;

	/**
	 * The cached value of the '{@link #getBindParameter() <em>Bind Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBindParameter()
	 * @generated
	 * @ordered
	 */
	protected Parameter bindParameter;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EssentialoclPackage.Literals.VARIABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression getInitExpression() {
		return initExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitExpression(OclExpression newInitExpression, NotificationChain msgs) {
		OclExpression oldInitExpression = initExpression;
		initExpression = newInitExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EssentialoclPackage.VARIABLE__INIT_EXPRESSION, oldInitExpression, newInitExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitExpression(OclExpression newInitExpression) {
		if (newInitExpression != initExpression) {
			NotificationChain msgs = null;
			if (initExpression != null)
				msgs = ((InternalEObject)initExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EssentialoclPackage.VARIABLE__INIT_EXPRESSION, null, msgs);
			if (newInitExpression != null)
				msgs = ((InternalEObject)newInitExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EssentialoclPackage.VARIABLE__INIT_EXPRESSION, null, msgs);
			msgs = basicSetInitExpression(newInitExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialoclPackage.VARIABLE__INIT_EXPRESSION, newInitExpression, newInitExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LetExp getLetExp() {
		if (eContainerFeatureID() != EssentialoclPackage.VARIABLE__LET_EXP) return null;
		return (LetExp)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLetExp(LetExp newLetExp, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newLetExp, EssentialoclPackage.VARIABLE__LET_EXP, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLetExp(LetExp newLetExp) {
		if (newLetExp != eInternalContainer() || (eContainerFeatureID() != EssentialoclPackage.VARIABLE__LET_EXP && newLetExp != null)) {
			if (EcoreUtil.isAncestor(this, newLetExp))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newLetExp != null)
				msgs = ((InternalEObject)newLetExp).eInverseAdd(this, EssentialoclPackage.LET_EXP__VARIABLE, LetExp.class, msgs);
			msgs = basicSetLetExp(newLetExp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialoclPackage.VARIABLE__LET_EXP, newLetExp, newLetExp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter getBindParameter() {
		if (bindParameter != null && bindParameter.eIsProxy()) {
			InternalEObject oldBindParameter = (InternalEObject)bindParameter;
			bindParameter = (Parameter)eResolveProxy(oldBindParameter);
			if (bindParameter != oldBindParameter) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EssentialoclPackage.VARIABLE__BIND_PARAMETER, oldBindParameter, bindParameter));
			}
		}
		return bindParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter basicGetBindParameter() {
		return bindParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBindParameter(Parameter newBindParameter) {
		Parameter oldBindParameter = bindParameter;
		bindParameter = newBindParameter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialoclPackage.VARIABLE__BIND_PARAMETER, oldBindParameter, bindParameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputeExp getComputeOwner() {
		if (eContainerFeatureID() != EssentialoclPackage.VARIABLE__COMPUTE_OWNER) return null;
		return (ComputeExp)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetComputeOwner(ComputeExp newComputeOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newComputeOwner, EssentialoclPackage.VARIABLE__COMPUTE_OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComputeOwner(ComputeExp newComputeOwner) {
		if (newComputeOwner != eInternalContainer() || (eContainerFeatureID() != EssentialoclPackage.VARIABLE__COMPUTE_OWNER && newComputeOwner != null)) {
			if (EcoreUtil.isAncestor(this, newComputeOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newComputeOwner != null)
				msgs = ((InternalEObject)newComputeOwner).eInverseAdd(this, ImperativeoclPackage.COMPUTE_EXP__RETURNED_ELEMENT, ComputeExp.class, msgs);
			msgs = basicSetComputeOwner(newComputeOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialoclPackage.VARIABLE__COMPUTE_OWNER, newComputeOwner, newComputeOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EssentialoclPackage.VARIABLE__LET_EXP:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetLetExp((LetExp)otherEnd, msgs);
			case EssentialoclPackage.VARIABLE__COMPUTE_OWNER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetComputeOwner((ComputeExp)otherEnd, msgs);
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
			case EssentialoclPackage.VARIABLE__INIT_EXPRESSION:
				return basicSetInitExpression(null, msgs);
			case EssentialoclPackage.VARIABLE__LET_EXP:
				return basicSetLetExp(null, msgs);
			case EssentialoclPackage.VARIABLE__COMPUTE_OWNER:
				return basicSetComputeOwner(null, msgs);
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
			case EssentialoclPackage.VARIABLE__LET_EXP:
				return eInternalContainer().eInverseRemove(this, EssentialoclPackage.LET_EXP__VARIABLE, LetExp.class, msgs);
			case EssentialoclPackage.VARIABLE__COMPUTE_OWNER:
				return eInternalContainer().eInverseRemove(this, ImperativeoclPackage.COMPUTE_EXP__RETURNED_ELEMENT, ComputeExp.class, msgs);
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
			case EssentialoclPackage.VARIABLE__INIT_EXPRESSION:
				return getInitExpression();
			case EssentialoclPackage.VARIABLE__LET_EXP:
				return getLetExp();
			case EssentialoclPackage.VARIABLE__BIND_PARAMETER:
				if (resolve) return getBindParameter();
				return basicGetBindParameter();
			case EssentialoclPackage.VARIABLE__COMPUTE_OWNER:
				return getComputeOwner();
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
			case EssentialoclPackage.VARIABLE__INIT_EXPRESSION:
				setInitExpression((OclExpression)newValue);
				return;
			case EssentialoclPackage.VARIABLE__LET_EXP:
				setLetExp((LetExp)newValue);
				return;
			case EssentialoclPackage.VARIABLE__BIND_PARAMETER:
				setBindParameter((Parameter)newValue);
				return;
			case EssentialoclPackage.VARIABLE__COMPUTE_OWNER:
				setComputeOwner((ComputeExp)newValue);
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
			case EssentialoclPackage.VARIABLE__INIT_EXPRESSION:
				setInitExpression((OclExpression)null);
				return;
			case EssentialoclPackage.VARIABLE__LET_EXP:
				setLetExp((LetExp)null);
				return;
			case EssentialoclPackage.VARIABLE__BIND_PARAMETER:
				setBindParameter((Parameter)null);
				return;
			case EssentialoclPackage.VARIABLE__COMPUTE_OWNER:
				setComputeOwner((ComputeExp)null);
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
			case EssentialoclPackage.VARIABLE__INIT_EXPRESSION:
				return initExpression != null;
			case EssentialoclPackage.VARIABLE__LET_EXP:
				return getLetExp() != null;
			case EssentialoclPackage.VARIABLE__BIND_PARAMETER:
				return bindParameter != null;
			case EssentialoclPackage.VARIABLE__COMPUTE_OWNER:
				return getComputeOwner() != null;
		}
		return super.eIsSet(featureID);
	}

} //VariableImpl
