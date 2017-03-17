/**
 */
package JTL.template.impl;

import JTL.essentialocl.CollectionKind;
import JTL.essentialocl.CollectionType;
import JTL.essentialocl.OclExpression;

import JTL.template.CollectionTemplateExp;
import JTL.template.TemplatePackage;

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
 * An implementation of the model object '<em><b>Collection Template Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link JTL.template.impl.CollectionTemplateExpImpl#getPart <em>Part</em>}</li>
 *   <li>{@link JTL.template.impl.CollectionTemplateExpImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link JTL.template.impl.CollectionTemplateExpImpl#getReferredCollectionType <em>Referred Collection Type</em>}</li>
 *   <li>{@link JTL.template.impl.CollectionTemplateExpImpl#getMatch <em>Match</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CollectionTemplateExpImpl extends TemplateExpImpl implements CollectionTemplateExp {
	/**
	 * The cached value of the '{@link #getPart() <em>Part</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPart()
	 * @generated
	 * @ordered
	 */
	protected EList<OclExpression> part;

	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final CollectionKind KIND_EDEFAULT = CollectionKind.ORDERED_SET;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected CollectionKind kind = KIND_EDEFAULT;

	/**
	 * The cached value of the '{@link #getReferredCollectionType() <em>Referred Collection Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredCollectionType()
	 * @generated
	 * @ordered
	 */
	protected CollectionType referredCollectionType;

	/**
	 * The cached value of the '{@link #getMatch() <em>Match</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMatch()
	 * @generated
	 * @ordered
	 */
	protected OclExpression match;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CollectionTemplateExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TemplatePackage.Literals.COLLECTION_TEMPLATE_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OclExpression> getPart() {
		if (part == null) {
			part = new EObjectContainmentEList<OclExpression>(OclExpression.class, this, TemplatePackage.COLLECTION_TEMPLATE_EXP__PART);
		}
		return part;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionKind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(CollectionKind newKind) {
		CollectionKind oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatePackage.COLLECTION_TEMPLATE_EXP__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionType getReferredCollectionType() {
		if (referredCollectionType != null && referredCollectionType.eIsProxy()) {
			InternalEObject oldReferredCollectionType = (InternalEObject)referredCollectionType;
			referredCollectionType = (CollectionType)eResolveProxy(oldReferredCollectionType);
			if (referredCollectionType != oldReferredCollectionType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TemplatePackage.COLLECTION_TEMPLATE_EXP__REFERRED_COLLECTION_TYPE, oldReferredCollectionType, referredCollectionType));
			}
		}
		return referredCollectionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionType basicGetReferredCollectionType() {
		return referredCollectionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferredCollectionType(CollectionType newReferredCollectionType) {
		CollectionType oldReferredCollectionType = referredCollectionType;
		referredCollectionType = newReferredCollectionType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatePackage.COLLECTION_TEMPLATE_EXP__REFERRED_COLLECTION_TYPE, oldReferredCollectionType, referredCollectionType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression getMatch() {
		if (match != null && match.eIsProxy()) {
			InternalEObject oldMatch = (InternalEObject)match;
			match = (OclExpression)eResolveProxy(oldMatch);
			if (match != oldMatch) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TemplatePackage.COLLECTION_TEMPLATE_EXP__MATCH, oldMatch, match));
			}
		}
		return match;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression basicGetMatch() {
		return match;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMatch(OclExpression newMatch) {
		OclExpression oldMatch = match;
		match = newMatch;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatePackage.COLLECTION_TEMPLATE_EXP__MATCH, oldMatch, match));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TemplatePackage.COLLECTION_TEMPLATE_EXP__PART:
				return ((InternalEList<?>)getPart()).basicRemove(otherEnd, msgs);
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
			case TemplatePackage.COLLECTION_TEMPLATE_EXP__PART:
				return getPart();
			case TemplatePackage.COLLECTION_TEMPLATE_EXP__KIND:
				return getKind();
			case TemplatePackage.COLLECTION_TEMPLATE_EXP__REFERRED_COLLECTION_TYPE:
				if (resolve) return getReferredCollectionType();
				return basicGetReferredCollectionType();
			case TemplatePackage.COLLECTION_TEMPLATE_EXP__MATCH:
				if (resolve) return getMatch();
				return basicGetMatch();
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
			case TemplatePackage.COLLECTION_TEMPLATE_EXP__PART:
				getPart().clear();
				getPart().addAll((Collection<? extends OclExpression>)newValue);
				return;
			case TemplatePackage.COLLECTION_TEMPLATE_EXP__KIND:
				setKind((CollectionKind)newValue);
				return;
			case TemplatePackage.COLLECTION_TEMPLATE_EXP__REFERRED_COLLECTION_TYPE:
				setReferredCollectionType((CollectionType)newValue);
				return;
			case TemplatePackage.COLLECTION_TEMPLATE_EXP__MATCH:
				setMatch((OclExpression)newValue);
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
			case TemplatePackage.COLLECTION_TEMPLATE_EXP__PART:
				getPart().clear();
				return;
			case TemplatePackage.COLLECTION_TEMPLATE_EXP__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case TemplatePackage.COLLECTION_TEMPLATE_EXP__REFERRED_COLLECTION_TYPE:
				setReferredCollectionType((CollectionType)null);
				return;
			case TemplatePackage.COLLECTION_TEMPLATE_EXP__MATCH:
				setMatch((OclExpression)null);
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
			case TemplatePackage.COLLECTION_TEMPLATE_EXP__PART:
				return part != null && !part.isEmpty();
			case TemplatePackage.COLLECTION_TEMPLATE_EXP__KIND:
				return kind != KIND_EDEFAULT;
			case TemplatePackage.COLLECTION_TEMPLATE_EXP__REFERRED_COLLECTION_TYPE:
				return referredCollectionType != null;
			case TemplatePackage.COLLECTION_TEMPLATE_EXP__MATCH:
				return match != null;
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
		result.append(" (kind: ");
		result.append(kind);
		result.append(')');
		return result.toString();
	}

} //CollectionTemplateExpImpl
