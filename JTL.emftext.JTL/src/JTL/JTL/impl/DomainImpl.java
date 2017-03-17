/**
 */
package JTL.JTL.impl;

import JTL.JTL.Domain;
import JTL.JTL.JTLPackage;
import JTL.JTL.Model;
import JTL.JTL.Pattern;
import JTL.JTL.Relation;

import JTL.emof.impl.NamedElementImpl;

import JTL.essentialocl.Variable;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Domain</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link JTL.JTL.impl.DomainImpl#isIsCheckable <em>Is Checkable</em>}</li>
 *   <li>{@link JTL.JTL.impl.DomainImpl#isIsEnforceable <em>Is Enforceable</em>}</li>
 *   <li>{@link JTL.JTL.impl.DomainImpl#getRelation <em>Relation</em>}</li>
 *   <li>{@link JTL.JTL.impl.DomainImpl#getPattern <em>Pattern</em>}</li>
 *   <li>{@link JTL.JTL.impl.DomainImpl#getModel <em>Model</em>}</li>
 *   <li>{@link JTL.JTL.impl.DomainImpl#getRootVariable <em>Root Variable</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DomainImpl extends NamedElementImpl implements Domain {
	/**
	 * The default value of the '{@link #isIsCheckable() <em>Is Checkable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsCheckable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_CHECKABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsCheckable() <em>Is Checkable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsCheckable()
	 * @generated
	 * @ordered
	 */
	protected boolean isCheckable = IS_CHECKABLE_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsEnforceable() <em>Is Enforceable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsEnforceable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ENFORCEABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsEnforceable() <em>Is Enforceable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsEnforceable()
	 * @generated
	 * @ordered
	 */
	protected boolean isEnforceable = IS_ENFORCEABLE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPattern() <em>Pattern</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPattern()
	 * @generated
	 * @ordered
	 */
	protected Pattern pattern;

	/**
	 * The cached value of the '{@link #getModel() <em>Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModel()
	 * @generated
	 * @ordered
	 */
	protected Model model;

	/**
	 * The cached value of the '{@link #getRootVariable() <em>Root Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootVariable()
	 * @generated
	 * @ordered
	 */
	protected Variable rootVariable;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DomainImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JTLPackage.Literals.DOMAIN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsCheckable() {
		return isCheckable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsCheckable(boolean newIsCheckable) {
		boolean oldIsCheckable = isCheckable;
		isCheckable = newIsCheckable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JTLPackage.DOMAIN__IS_CHECKABLE, oldIsCheckable, isCheckable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsEnforceable() {
		return isEnforceable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsEnforceable(boolean newIsEnforceable) {
		boolean oldIsEnforceable = isEnforceable;
		isEnforceable = newIsEnforceable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JTLPackage.DOMAIN__IS_ENFORCEABLE, oldIsEnforceable, isEnforceable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relation getRelation() {
		if (eContainerFeatureID() != JTLPackage.DOMAIN__RELATION) return null;
		return (Relation)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRelation(Relation newRelation, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newRelation, JTLPackage.DOMAIN__RELATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelation(Relation newRelation) {
		if (newRelation != eInternalContainer() || (eContainerFeatureID() != JTLPackage.DOMAIN__RELATION && newRelation != null)) {
			if (EcoreUtil.isAncestor(this, newRelation))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRelation != null)
				msgs = ((InternalEObject)newRelation).eInverseAdd(this, JTLPackage.RELATION__DOMAIN, Relation.class, msgs);
			msgs = basicSetRelation(newRelation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JTLPackage.DOMAIN__RELATION, newRelation, newRelation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pattern getPattern() {
		return pattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPattern(Pattern newPattern, NotificationChain msgs) {
		Pattern oldPattern = pattern;
		pattern = newPattern;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, JTLPackage.DOMAIN__PATTERN, oldPattern, newPattern);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPattern(Pattern newPattern) {
		if (newPattern != pattern) {
			NotificationChain msgs = null;
			if (pattern != null)
				msgs = ((InternalEObject)pattern).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - JTLPackage.DOMAIN__PATTERN, null, msgs);
			if (newPattern != null)
				msgs = ((InternalEObject)newPattern).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - JTLPackage.DOMAIN__PATTERN, null, msgs);
			msgs = basicSetPattern(newPattern, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JTLPackage.DOMAIN__PATTERN, newPattern, newPattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Model getModel() {
		if (model != null && model.eIsProxy()) {
			InternalEObject oldModel = (InternalEObject)model;
			model = (Model)eResolveProxy(oldModel);
			if (model != oldModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, JTLPackage.DOMAIN__MODEL, oldModel, model));
			}
		}
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Model basicGetModel() {
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModel(Model newModel) {
		Model oldModel = model;
		model = newModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JTLPackage.DOMAIN__MODEL, oldModel, model));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getRootVariable() {
		if (rootVariable != null && rootVariable.eIsProxy()) {
			InternalEObject oldRootVariable = (InternalEObject)rootVariable;
			rootVariable = (Variable)eResolveProxy(oldRootVariable);
			if (rootVariable != oldRootVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, JTLPackage.DOMAIN__ROOT_VARIABLE, oldRootVariable, rootVariable));
			}
		}
		return rootVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable basicGetRootVariable() {
		return rootVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRootVariable(Variable newRootVariable) {
		Variable oldRootVariable = rootVariable;
		rootVariable = newRootVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JTLPackage.DOMAIN__ROOT_VARIABLE, oldRootVariable, rootVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JTLPackage.DOMAIN__RELATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetRelation((Relation)otherEnd, msgs);
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
			case JTLPackage.DOMAIN__RELATION:
				return basicSetRelation(null, msgs);
			case JTLPackage.DOMAIN__PATTERN:
				return basicSetPattern(null, msgs);
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
			case JTLPackage.DOMAIN__RELATION:
				return eInternalContainer().eInverseRemove(this, JTLPackage.RELATION__DOMAIN, Relation.class, msgs);
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
			case JTLPackage.DOMAIN__IS_CHECKABLE:
				return isIsCheckable();
			case JTLPackage.DOMAIN__IS_ENFORCEABLE:
				return isIsEnforceable();
			case JTLPackage.DOMAIN__RELATION:
				return getRelation();
			case JTLPackage.DOMAIN__PATTERN:
				return getPattern();
			case JTLPackage.DOMAIN__MODEL:
				if (resolve) return getModel();
				return basicGetModel();
			case JTLPackage.DOMAIN__ROOT_VARIABLE:
				if (resolve) return getRootVariable();
				return basicGetRootVariable();
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
			case JTLPackage.DOMAIN__IS_CHECKABLE:
				setIsCheckable((Boolean)newValue);
				return;
			case JTLPackage.DOMAIN__IS_ENFORCEABLE:
				setIsEnforceable((Boolean)newValue);
				return;
			case JTLPackage.DOMAIN__RELATION:
				setRelation((Relation)newValue);
				return;
			case JTLPackage.DOMAIN__PATTERN:
				setPattern((Pattern)newValue);
				return;
			case JTLPackage.DOMAIN__MODEL:
				setModel((Model)newValue);
				return;
			case JTLPackage.DOMAIN__ROOT_VARIABLE:
				setRootVariable((Variable)newValue);
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
			case JTLPackage.DOMAIN__IS_CHECKABLE:
				setIsCheckable(IS_CHECKABLE_EDEFAULT);
				return;
			case JTLPackage.DOMAIN__IS_ENFORCEABLE:
				setIsEnforceable(IS_ENFORCEABLE_EDEFAULT);
				return;
			case JTLPackage.DOMAIN__RELATION:
				setRelation((Relation)null);
				return;
			case JTLPackage.DOMAIN__PATTERN:
				setPattern((Pattern)null);
				return;
			case JTLPackage.DOMAIN__MODEL:
				setModel((Model)null);
				return;
			case JTLPackage.DOMAIN__ROOT_VARIABLE:
				setRootVariable((Variable)null);
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
			case JTLPackage.DOMAIN__IS_CHECKABLE:
				return isCheckable != IS_CHECKABLE_EDEFAULT;
			case JTLPackage.DOMAIN__IS_ENFORCEABLE:
				return isEnforceable != IS_ENFORCEABLE_EDEFAULT;
			case JTLPackage.DOMAIN__RELATION:
				return getRelation() != null;
			case JTLPackage.DOMAIN__PATTERN:
				return pattern != null;
			case JTLPackage.DOMAIN__MODEL:
				return model != null;
			case JTLPackage.DOMAIN__ROOT_VARIABLE:
				return rootVariable != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (isCheckable: ");
		result.append(isCheckable);
		result.append(", isEnforceable: ");
		result.append(isEnforceable);
		result.append(')');
		return result.toString();
	}

} //DomainImpl
