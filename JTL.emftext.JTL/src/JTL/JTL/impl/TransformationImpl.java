/**
 */
package JTL.JTL.impl;

import JTL.JTL.JTLPackage;
import JTL.JTL.Model;
import JTL.JTL.Relation;
import JTL.JTL.Transformation;

import JTL.emof.EmofPackage;
import JTL.emof.Type;

import JTL.emof.impl.ClassImpl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transformation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link JTL.JTL.impl.TransformationImpl#getOwnedType <em>Owned Type</em>}</li>
 *   <li>{@link JTL.JTL.impl.TransformationImpl#getNestedPackage <em>Nested Package</em>}</li>
 *   <li>{@link JTL.JTL.impl.TransformationImpl#getUri <em>Uri</em>}</li>
 *   <li>{@link JTL.JTL.impl.TransformationImpl#getModelParameter <em>Model Parameter</em>}</li>
 *   <li>{@link JTL.JTL.impl.TransformationImpl#getRelation <em>Relation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TransformationImpl extends ClassImpl implements Transformation {
	/**
	 * The cached value of the '{@link #getOwnedType() <em>Owned Type</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedType()
	 * @generated
	 * @ordered
	 */
	protected EList<Type> ownedType;

	/**
	 * The cached value of the '{@link #getNestedPackage() <em>Nested Package</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNestedPackage()
	 * @generated
	 * @ordered
	 */
	protected EList<JTL.emof.Package> nestedPackage;

	/**
	 * The default value of the '{@link #getUri() <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUri()
	 * @generated
	 * @ordered
	 */
	protected static final String URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUri() <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUri()
	 * @generated
	 * @ordered
	 */
	protected String uri = URI_EDEFAULT;

	/**
	 * The cached value of the '{@link #getModelParameter() <em>Model Parameter</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelParameter()
	 * @generated
	 * @ordered
	 */
	protected EList<Model> modelParameter;

	/**
	 * The cached value of the '{@link #getRelation() <em>Relation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelation()
	 * @generated
	 * @ordered
	 */
	protected EList<Relation> relation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransformationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JTLPackage.Literals.TRANSFORMATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Type> getOwnedType() {
		if (ownedType == null) {
			ownedType = new EObjectContainmentWithInverseEList<Type>(Type.class, this, JTLPackage.TRANSFORMATION__OWNED_TYPE, EmofPackage.TYPE__PACKAGE);
		}
		return ownedType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JTL.emof.Package> getNestedPackage() {
		if (nestedPackage == null) {
			nestedPackage = new EObjectResolvingEList<JTL.emof.Package>(JTL.emof.Package.class, this, JTLPackage.TRANSFORMATION__NESTED_PACKAGE);
		}
		return nestedPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUri() {
		return uri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUri(String newUri) {
		String oldUri = uri;
		uri = newUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JTLPackage.TRANSFORMATION__URI, oldUri, uri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Model> getModelParameter() {
		if (modelParameter == null) {
			modelParameter = new EObjectContainmentWithInverseEList<Model>(Model.class, this, JTLPackage.TRANSFORMATION__MODEL_PARAMETER, JTLPackage.MODEL__TRANSFORMATION);
		}
		return modelParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Relation> getRelation() {
		if (relation == null) {
			relation = new EObjectContainmentWithInverseEList<Relation>(Relation.class, this, JTLPackage.TRANSFORMATION__RELATION, JTLPackage.RELATION__TRANSFORMATION);
		}
		return relation;
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
			case JTLPackage.TRANSFORMATION__OWNED_TYPE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedType()).basicAdd(otherEnd, msgs);
			case JTLPackage.TRANSFORMATION__MODEL_PARAMETER:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getModelParameter()).basicAdd(otherEnd, msgs);
			case JTLPackage.TRANSFORMATION__RELATION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRelation()).basicAdd(otherEnd, msgs);
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
			case JTLPackage.TRANSFORMATION__OWNED_TYPE:
				return ((InternalEList<?>)getOwnedType()).basicRemove(otherEnd, msgs);
			case JTLPackage.TRANSFORMATION__MODEL_PARAMETER:
				return ((InternalEList<?>)getModelParameter()).basicRemove(otherEnd, msgs);
			case JTLPackage.TRANSFORMATION__RELATION:
				return ((InternalEList<?>)getRelation()).basicRemove(otherEnd, msgs);
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
			case JTLPackage.TRANSFORMATION__OWNED_TYPE:
				return getOwnedType();
			case JTLPackage.TRANSFORMATION__NESTED_PACKAGE:
				return getNestedPackage();
			case JTLPackage.TRANSFORMATION__URI:
				return getUri();
			case JTLPackage.TRANSFORMATION__MODEL_PARAMETER:
				return getModelParameter();
			case JTLPackage.TRANSFORMATION__RELATION:
				return getRelation();
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
			case JTLPackage.TRANSFORMATION__OWNED_TYPE:
				getOwnedType().clear();
				getOwnedType().addAll((Collection<? extends Type>)newValue);
				return;
			case JTLPackage.TRANSFORMATION__NESTED_PACKAGE:
				getNestedPackage().clear();
				getNestedPackage().addAll((Collection<? extends JTL.emof.Package>)newValue);
				return;
			case JTLPackage.TRANSFORMATION__URI:
				setUri((String)newValue);
				return;
			case JTLPackage.TRANSFORMATION__MODEL_PARAMETER:
				getModelParameter().clear();
				getModelParameter().addAll((Collection<? extends Model>)newValue);
				return;
			case JTLPackage.TRANSFORMATION__RELATION:
				getRelation().clear();
				getRelation().addAll((Collection<? extends Relation>)newValue);
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
			case JTLPackage.TRANSFORMATION__OWNED_TYPE:
				getOwnedType().clear();
				return;
			case JTLPackage.TRANSFORMATION__NESTED_PACKAGE:
				getNestedPackage().clear();
				return;
			case JTLPackage.TRANSFORMATION__URI:
				setUri(URI_EDEFAULT);
				return;
			case JTLPackage.TRANSFORMATION__MODEL_PARAMETER:
				getModelParameter().clear();
				return;
			case JTLPackage.TRANSFORMATION__RELATION:
				getRelation().clear();
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
			case JTLPackage.TRANSFORMATION__OWNED_TYPE:
				return ownedType != null && !ownedType.isEmpty();
			case JTLPackage.TRANSFORMATION__NESTED_PACKAGE:
				return nestedPackage != null && !nestedPackage.isEmpty();
			case JTLPackage.TRANSFORMATION__URI:
				return URI_EDEFAULT == null ? uri != null : !URI_EDEFAULT.equals(uri);
			case JTLPackage.TRANSFORMATION__MODEL_PARAMETER:
				return modelParameter != null && !modelParameter.isEmpty();
			case JTLPackage.TRANSFORMATION__RELATION:
				return relation != null && !relation.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == JTL.emof.Package.class) {
			switch (derivedFeatureID) {
				case JTLPackage.TRANSFORMATION__OWNED_TYPE: return EmofPackage.PACKAGE__OWNED_TYPE;
				case JTLPackage.TRANSFORMATION__NESTED_PACKAGE: return EmofPackage.PACKAGE__NESTED_PACKAGE;
				case JTLPackage.TRANSFORMATION__URI: return EmofPackage.PACKAGE__URI;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == JTL.emof.Package.class) {
			switch (baseFeatureID) {
				case EmofPackage.PACKAGE__OWNED_TYPE: return JTLPackage.TRANSFORMATION__OWNED_TYPE;
				case EmofPackage.PACKAGE__NESTED_PACKAGE: return JTLPackage.TRANSFORMATION__NESTED_PACKAGE;
				case EmofPackage.PACKAGE__URI: return JTLPackage.TRANSFORMATION__URI;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (uri: ");
		result.append(uri);
		result.append(')');
		return result.toString();
	}

} //TransformationImpl
