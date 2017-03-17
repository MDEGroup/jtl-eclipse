/**
 */
package ASPMM.impl;

import ASPMM.ASPMMPackage;
import ASPMM.Metamodel;
import ASPMM.Metanode;
import ASPMM.Metaprop;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Metaprop</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ASPMM.impl.MetapropImpl#getName <em>Name</em>}</li>
 *   <li>{@link ASPMM.impl.MetapropImpl#getMetamodel <em>Metamodel</em>}</li>
 *   <li>{@link ASPMM.impl.MetapropImpl#getMetanode <em>Metanode</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MetapropImpl extends LocatedElementImpl implements Metaprop {
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
	 * The cached value of the '{@link #getMetanode() <em>Metanode</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetanode()
	 * @generated
	 * @ordered
	 */
	protected Metanode metanode;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MetapropImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ASPMMPackage.Literals.METAPROP;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ASPMMPackage.METAPROP__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Metamodel getMetamodel() {
		if (eContainerFeatureID() != ASPMMPackage.METAPROP__METAMODEL) return null;
		return (Metamodel)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMetamodel(Metamodel newMetamodel, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newMetamodel, ASPMMPackage.METAPROP__METAMODEL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetamodel(Metamodel newMetamodel) {
		if (newMetamodel != eInternalContainer() || (eContainerFeatureID() != ASPMMPackage.METAPROP__METAMODEL && newMetamodel != null)) {
			if (EcoreUtil.isAncestor(this, newMetamodel))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newMetamodel != null)
				msgs = ((InternalEObject)newMetamodel).eInverseAdd(this, ASPMMPackage.METAMODEL__METAPROPS, Metamodel.class, msgs);
			msgs = basicSetMetamodel(newMetamodel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ASPMMPackage.METAPROP__METAMODEL, newMetamodel, newMetamodel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Metanode getMetanode() {
		if (metanode != null && metanode.eIsProxy()) {
			InternalEObject oldMetanode = (InternalEObject)metanode;
			metanode = (Metanode)eResolveProxy(oldMetanode);
			if (metanode != oldMetanode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ASPMMPackage.METAPROP__METANODE, oldMetanode, metanode));
			}
		}
		return metanode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Metanode basicGetMetanode() {
		return metanode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetanode(Metanode newMetanode) {
		Metanode oldMetanode = metanode;
		metanode = newMetanode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ASPMMPackage.METAPROP__METANODE, oldMetanode, metanode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ASPMMPackage.METAPROP__METAMODEL:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetMetamodel((Metamodel)otherEnd, msgs);
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
			case ASPMMPackage.METAPROP__METAMODEL:
				return basicSetMetamodel(null, msgs);
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
			case ASPMMPackage.METAPROP__METAMODEL:
				return eInternalContainer().eInverseRemove(this, ASPMMPackage.METAMODEL__METAPROPS, Metamodel.class, msgs);
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
			case ASPMMPackage.METAPROP__NAME:
				return getName();
			case ASPMMPackage.METAPROP__METAMODEL:
				return getMetamodel();
			case ASPMMPackage.METAPROP__METANODE:
				if (resolve) return getMetanode();
				return basicGetMetanode();
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
			case ASPMMPackage.METAPROP__NAME:
				setName((String)newValue);
				return;
			case ASPMMPackage.METAPROP__METAMODEL:
				setMetamodel((Metamodel)newValue);
				return;
			case ASPMMPackage.METAPROP__METANODE:
				setMetanode((Metanode)newValue);
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
			case ASPMMPackage.METAPROP__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ASPMMPackage.METAPROP__METAMODEL:
				setMetamodel((Metamodel)null);
				return;
			case ASPMMPackage.METAPROP__METANODE:
				setMetanode((Metanode)null);
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
			case ASPMMPackage.METAPROP__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ASPMMPackage.METAPROP__METAMODEL:
				return getMetamodel() != null;
			case ASPMMPackage.METAPROP__METANODE:
				return metanode != null;
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

} //MetapropImpl
