/**
 */
package ASPMM.impl;

import ASPMM.ASPMMPackage;
import ASPMM.Metaedge;
import ASPMM.Metamodel;
import ASPMM.Metanode;
import ASPMM.Metaprop;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Metamodel</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ASPMM.impl.MetamodelImpl#getName <em>Name</em>}</li>
 *   <li>{@link ASPMM.impl.MetamodelImpl#getMetanodes <em>Metanodes</em>}</li>
 *   <li>{@link ASPMM.impl.MetamodelImpl#getMetaedges <em>Metaedges</em>}</li>
 *   <li>{@link ASPMM.impl.MetamodelImpl#getMetaprops <em>Metaprops</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MetamodelImpl extends LocatedElementImpl implements Metamodel {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMetanodes() <em>Metanodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetanodes()
	 * @generated
	 * @ordered
	 */
	protected EList<Metanode> metanodes;

	/**
	 * The cached value of the '{@link #getMetaedges() <em>Metaedges</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaedges()
	 * @generated
	 * @ordered
	 */
	protected EList<Metaedge> metaedges;

	/**
	 * The cached value of the '{@link #getMetaprops() <em>Metaprops</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaprops()
	 * @generated
	 * @ordered
	 */
	protected EList<Metaprop> metaprops;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MetamodelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ASPMMPackage.Literals.METAMODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ASPMMPackage.METAMODEL__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Metanode> getMetanodes() {
		if (metanodes == null) {
			metanodes = new EObjectContainmentWithInverseEList<Metanode>(Metanode.class, this, ASPMMPackage.METAMODEL__METANODES, ASPMMPackage.METANODE__METAMODEL);
		}
		return metanodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Metaedge> getMetaedges() {
		if (metaedges == null) {
			metaedges = new EObjectContainmentWithInverseEList<Metaedge>(Metaedge.class, this, ASPMMPackage.METAMODEL__METAEDGES, ASPMMPackage.METAEDGE__METAMODEL);
		}
		return metaedges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Metaprop> getMetaprops() {
		if (metaprops == null) {
			metaprops = new EObjectContainmentWithInverseEList<Metaprop>(Metaprop.class, this, ASPMMPackage.METAMODEL__METAPROPS, ASPMMPackage.METAPROP__METAMODEL);
		}
		return metaprops;
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
			case ASPMMPackage.METAMODEL__METANODES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getMetanodes()).basicAdd(otherEnd, msgs);
			case ASPMMPackage.METAMODEL__METAEDGES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getMetaedges()).basicAdd(otherEnd, msgs);
			case ASPMMPackage.METAMODEL__METAPROPS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getMetaprops()).basicAdd(otherEnd, msgs);
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
			case ASPMMPackage.METAMODEL__METANODES:
				return ((InternalEList<?>)getMetanodes()).basicRemove(otherEnd, msgs);
			case ASPMMPackage.METAMODEL__METAEDGES:
				return ((InternalEList<?>)getMetaedges()).basicRemove(otherEnd, msgs);
			case ASPMMPackage.METAMODEL__METAPROPS:
				return ((InternalEList<?>)getMetaprops()).basicRemove(otherEnd, msgs);
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
			case ASPMMPackage.METAMODEL__NAME:
				return getName();
			case ASPMMPackage.METAMODEL__METANODES:
				return getMetanodes();
			case ASPMMPackage.METAMODEL__METAEDGES:
				return getMetaedges();
			case ASPMMPackage.METAMODEL__METAPROPS:
				return getMetaprops();
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
			case ASPMMPackage.METAMODEL__NAME:
				setName((String)newValue);
				return;
			case ASPMMPackage.METAMODEL__METANODES:
				getMetanodes().clear();
				getMetanodes().addAll((Collection<? extends Metanode>)newValue);
				return;
			case ASPMMPackage.METAMODEL__METAEDGES:
				getMetaedges().clear();
				getMetaedges().addAll((Collection<? extends Metaedge>)newValue);
				return;
			case ASPMMPackage.METAMODEL__METAPROPS:
				getMetaprops().clear();
				getMetaprops().addAll((Collection<? extends Metaprop>)newValue);
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
			case ASPMMPackage.METAMODEL__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ASPMMPackage.METAMODEL__METANODES:
				getMetanodes().clear();
				return;
			case ASPMMPackage.METAMODEL__METAEDGES:
				getMetaedges().clear();
				return;
			case ASPMMPackage.METAMODEL__METAPROPS:
				getMetaprops().clear();
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
			case ASPMMPackage.METAMODEL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ASPMMPackage.METAMODEL__METANODES:
				return metanodes != null && !metanodes.isEmpty();
			case ASPMMPackage.METAMODEL__METAEDGES:
				return metaedges != null && !metaedges.isEmpty();
			case ASPMMPackage.METAMODEL__METAPROPS:
				return metaprops != null && !metaprops.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //MetamodelImpl
