/**
 */
package JTL.template.impl;

import JTL.imperativeocl.AssignExp;

import JTL.template.ObjectTemplateExp;
import JTL.template.PropertyTemplateItem;
import JTL.template.TemplatePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Object Template Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link JTL.template.impl.ObjectTemplateExpImpl#getPart <em>Part</em>}</li>
 *   <li>{@link JTL.template.impl.ObjectTemplateExpImpl#getReferredClass <em>Referred Class</em>}</li>
 *   <li>{@link JTL.template.impl.ObjectTemplateExpImpl#getInside <em>Inside</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ObjectTemplateExpImpl extends TemplateExpImpl implements ObjectTemplateExp {
	/**
	 * The cached value of the '{@link #getPart() <em>Part</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPart()
	 * @generated
	 * @ordered
	 */
	protected EList<PropertyTemplateItem> part;

	/**
	 * The default value of the '{@link #getReferredClass() <em>Referred Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredClass()
	 * @generated
	 * @ordered
	 */
	protected static final String REFERRED_CLASS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReferredClass() <em>Referred Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredClass()
	 * @generated
	 * @ordered
	 */
	protected String referredClass = REFERRED_CLASS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInside() <em>Inside</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInside()
	 * @generated
	 * @ordered
	 */
	protected EList<AssignExp> inside;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ObjectTemplateExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TemplatePackage.Literals.OBJECT_TEMPLATE_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PropertyTemplateItem> getPart() {
		if (part == null) {
			part = new EObjectContainmentWithInverseEList<PropertyTemplateItem>(PropertyTemplateItem.class, this, TemplatePackage.OBJECT_TEMPLATE_EXP__PART, TemplatePackage.PROPERTY_TEMPLATE_ITEM__OBJ_CONTAINER);
		}
		return part;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getReferredClass() {
		return referredClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferredClass(String newReferredClass) {
		String oldReferredClass = referredClass;
		referredClass = newReferredClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatePackage.OBJECT_TEMPLATE_EXP__REFERRED_CLASS, oldReferredClass, referredClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AssignExp> getInside() {
		if (inside == null) {
			inside = new EObjectContainmentEList<AssignExp>(AssignExp.class, this, TemplatePackage.OBJECT_TEMPLATE_EXP__INSIDE);
		}
		return inside;
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
			case TemplatePackage.OBJECT_TEMPLATE_EXP__PART:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getPart()).basicAdd(otherEnd, msgs);
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
			case TemplatePackage.OBJECT_TEMPLATE_EXP__PART:
				return ((InternalEList<?>)getPart()).basicRemove(otherEnd, msgs);
			case TemplatePackage.OBJECT_TEMPLATE_EXP__INSIDE:
				return ((InternalEList<?>)getInside()).basicRemove(otherEnd, msgs);
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
			case TemplatePackage.OBJECT_TEMPLATE_EXP__PART:
				return getPart();
			case TemplatePackage.OBJECT_TEMPLATE_EXP__REFERRED_CLASS:
				return getReferredClass();
			case TemplatePackage.OBJECT_TEMPLATE_EXP__INSIDE:
				return getInside();
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
			case TemplatePackage.OBJECT_TEMPLATE_EXP__PART:
				getPart().clear();
				getPart().addAll((Collection<? extends PropertyTemplateItem>)newValue);
				return;
			case TemplatePackage.OBJECT_TEMPLATE_EXP__REFERRED_CLASS:
				setReferredClass((String)newValue);
				return;
			case TemplatePackage.OBJECT_TEMPLATE_EXP__INSIDE:
				getInside().clear();
				getInside().addAll((Collection<? extends AssignExp>)newValue);
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
			case TemplatePackage.OBJECT_TEMPLATE_EXP__PART:
				getPart().clear();
				return;
			case TemplatePackage.OBJECT_TEMPLATE_EXP__REFERRED_CLASS:
				setReferredClass(REFERRED_CLASS_EDEFAULT);
				return;
			case TemplatePackage.OBJECT_TEMPLATE_EXP__INSIDE:
				getInside().clear();
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
			case TemplatePackage.OBJECT_TEMPLATE_EXP__PART:
				return part != null && !part.isEmpty();
			case TemplatePackage.OBJECT_TEMPLATE_EXP__REFERRED_CLASS:
				return REFERRED_CLASS_EDEFAULT == null ? referredClass != null : !REFERRED_CLASS_EDEFAULT.equals(referredClass);
			case TemplatePackage.OBJECT_TEMPLATE_EXP__INSIDE:
				return inside != null && !inside.isEmpty();
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
		result.append(" (referredClass: ");
		result.append(referredClass);
		result.append(')');
		return result.toString();
	}

} //ObjectTemplateExpImpl
