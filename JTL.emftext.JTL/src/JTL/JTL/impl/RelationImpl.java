/**
 */
package JTL.JTL.impl;

import JTL.JTL.Domain;
import JTL.JTL.JTLPackage;
import JTL.JTL.Relation;
import JTL.JTL.Transformation;

import JTL.JTL.When;
import JTL.JTL.Where;
import JTL.emof.impl.NamedElementImpl;

import JTL.essentialocl.Variable;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link JTL.JTL.impl.RelationImpl#getTransformation <em>Transformation</em>}</li>
 *   <li>{@link JTL.JTL.impl.RelationImpl#getDomain <em>Domain</em>}</li>
 *   <li>{@link JTL.JTL.impl.RelationImpl#getWhere <em>Where</em>}</li>
 *   <li>{@link JTL.JTL.impl.RelationImpl#getWhen <em>When</em>}</li>
 *   <li>{@link JTL.JTL.impl.RelationImpl#isIsTopLevel <em>Is Top Level</em>}</li>
 *   <li>{@link JTL.JTL.impl.RelationImpl#getVariable <em>Variable</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RelationImpl extends NamedElementImpl implements Relation {
	/**
	 * The cached value of the '{@link #getDomain() <em>Domain</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomain()
	 * @generated
	 * @ordered
	 */
	protected EList<Domain> domain;

	/**
	 * The cached value of the '{@link #getWhere() <em>Where</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWhere()
	 * @generated
	 * @ordered
	 */
	protected Where where;

	/**
	 * The cached value of the '{@link #getWhen() <em>When</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWhen()
	 * @generated
	 * @ordered
	 */
	protected When when;

	/**
	 * The default value of the '{@link #isIsTopLevel() <em>Is Top Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsTopLevel()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_TOP_LEVEL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsTopLevel() <em>Is Top Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsTopLevel()
	 * @generated
	 * @ordered
	 */
	protected boolean isTopLevel = IS_TOP_LEVEL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getVariable() <em>Variable</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariable()
	 * @generated
	 * @ordered
	 */
	protected EList<Variable> variable;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JTLPackage.Literals.RELATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Transformation getTransformation() {
		if (eContainerFeatureID() != JTLPackage.RELATION__TRANSFORMATION) return null;
		return (Transformation)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTransformation(Transformation newTransformation, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newTransformation, JTLPackage.RELATION__TRANSFORMATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransformation(Transformation newTransformation) {
		if (newTransformation != eInternalContainer() || (eContainerFeatureID() != JTLPackage.RELATION__TRANSFORMATION && newTransformation != null)) {
			if (EcoreUtil.isAncestor(this, newTransformation))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newTransformation != null)
				msgs = ((InternalEObject)newTransformation).eInverseAdd(this, JTLPackage.TRANSFORMATION__RELATION, Transformation.class, msgs);
			msgs = basicSetTransformation(newTransformation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JTLPackage.RELATION__TRANSFORMATION, newTransformation, newTransformation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Domain> getDomain() {
		if (domain == null) {
			domain = new EObjectContainmentWithInverseEList<Domain>(Domain.class, this, JTLPackage.RELATION__DOMAIN, JTLPackage.DOMAIN__RELATION);
		}
		return domain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Where getWhere() {
		return where;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWhere(Where newWhere, NotificationChain msgs) {
		Where oldWhere = where;
		where = newWhere;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, JTLPackage.RELATION__WHERE, oldWhere, newWhere);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWhere(Where newWhere) {
		if (newWhere != where) {
			NotificationChain msgs = null;
			if (where != null)
				msgs = ((InternalEObject)where).eInverseRemove(this, JTLPackage.WHERE__WHERE_OWNER, Where.class, msgs);
			if (newWhere != null)
				msgs = ((InternalEObject)newWhere).eInverseAdd(this, JTLPackage.WHERE__WHERE_OWNER, Where.class, msgs);
			msgs = basicSetWhere(newWhere, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JTLPackage.RELATION__WHERE, newWhere, newWhere));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public When getWhen() {
		return when;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWhen(When newWhen, NotificationChain msgs) {
		When oldWhen = when;
		when = newWhen;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, JTLPackage.RELATION__WHEN, oldWhen, newWhen);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWhen(When newWhen) {
		if (newWhen != when) {
			NotificationChain msgs = null;
			if (when != null)
				msgs = ((InternalEObject)when).eInverseRemove(this, JTLPackage.WHEN__WHEN_OWNER, When.class, msgs);
			if (newWhen != null)
				msgs = ((InternalEObject)newWhen).eInverseAdd(this, JTLPackage.WHEN__WHEN_OWNER, When.class, msgs);
			msgs = basicSetWhen(newWhen, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JTLPackage.RELATION__WHEN, newWhen, newWhen));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsTopLevel() {
		return isTopLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsTopLevel(boolean newIsTopLevel) {
		boolean oldIsTopLevel = isTopLevel;
		isTopLevel = newIsTopLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JTLPackage.RELATION__IS_TOP_LEVEL, oldIsTopLevel, isTopLevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Variable> getVariable() {
		if (variable == null) {
			variable = new EObjectContainmentEList<Variable>(Variable.class, this, JTLPackage.RELATION__VARIABLE);
		}
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JTLPackage.RELATION__TRANSFORMATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetTransformation((Transformation)otherEnd, msgs);
			case JTLPackage.RELATION__DOMAIN:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDomain()).basicAdd(otherEnd, msgs);
			case JTLPackage.RELATION__WHERE:
				if (where != null)
					msgs = ((InternalEObject)where).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - JTLPackage.RELATION__WHERE, null, msgs);
				return basicSetWhere((Where)otherEnd, msgs);
			case JTLPackage.RELATION__WHEN:
				if (when != null)
					msgs = ((InternalEObject)when).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - JTLPackage.RELATION__WHEN, null, msgs);
				return basicSetWhen((When)otherEnd, msgs);
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
			case JTLPackage.RELATION__TRANSFORMATION:
				return basicSetTransformation(null, msgs);
			case JTLPackage.RELATION__DOMAIN:
				return ((InternalEList<?>)getDomain()).basicRemove(otherEnd, msgs);
			case JTLPackage.RELATION__WHERE:
				return basicSetWhere(null, msgs);
			case JTLPackage.RELATION__WHEN:
				return basicSetWhen(null, msgs);
			case JTLPackage.RELATION__VARIABLE:
				return ((InternalEList<?>)getVariable()).basicRemove(otherEnd, msgs);
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
			case JTLPackage.RELATION__TRANSFORMATION:
				return eInternalContainer().eInverseRemove(this, JTLPackage.TRANSFORMATION__RELATION, Transformation.class, msgs);
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
			case JTLPackage.RELATION__TRANSFORMATION:
				return getTransformation();
			case JTLPackage.RELATION__DOMAIN:
				return getDomain();
			case JTLPackage.RELATION__WHERE:
				return getWhere();
			case JTLPackage.RELATION__WHEN:
				return getWhen();
			case JTLPackage.RELATION__IS_TOP_LEVEL:
				return isIsTopLevel();
			case JTLPackage.RELATION__VARIABLE:
				return getVariable();
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
			case JTLPackage.RELATION__TRANSFORMATION:
				setTransformation((Transformation)newValue);
				return;
			case JTLPackage.RELATION__DOMAIN:
				getDomain().clear();
				getDomain().addAll((Collection<? extends Domain>)newValue);
				return;
			case JTLPackage.RELATION__WHERE:
				setWhere((Where)newValue);
				return;
			case JTLPackage.RELATION__WHEN:
				setWhen((When)newValue);
				return;
			case JTLPackage.RELATION__IS_TOP_LEVEL:
				setIsTopLevel((Boolean)newValue);
				return;
			case JTLPackage.RELATION__VARIABLE:
				getVariable().clear();
				getVariable().addAll((Collection<? extends Variable>)newValue);
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
			case JTLPackage.RELATION__TRANSFORMATION:
				setTransformation((Transformation)null);
				return;
			case JTLPackage.RELATION__DOMAIN:
				getDomain().clear();
				return;
			case JTLPackage.RELATION__WHERE:
				setWhere((Where)null);
				return;
			case JTLPackage.RELATION__WHEN:
				setWhen((When)null);
				return;
			case JTLPackage.RELATION__IS_TOP_LEVEL:
				setIsTopLevel(IS_TOP_LEVEL_EDEFAULT);
				return;
			case JTLPackage.RELATION__VARIABLE:
				getVariable().clear();
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
			case JTLPackage.RELATION__TRANSFORMATION:
				return getTransformation() != null;
			case JTLPackage.RELATION__DOMAIN:
				return domain != null && !domain.isEmpty();
			case JTLPackage.RELATION__WHERE:
				return where != null;
			case JTLPackage.RELATION__WHEN:
				return when != null;
			case JTLPackage.RELATION__IS_TOP_LEVEL:
				return isTopLevel != IS_TOP_LEVEL_EDEFAULT;
			case JTLPackage.RELATION__VARIABLE:
				return variable != null && !variable.isEmpty();
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
		result.append(" (isTopLevel: ");
		result.append(isTopLevel);
		result.append(')');
		return result.toString();
	}

} //RelationImpl
