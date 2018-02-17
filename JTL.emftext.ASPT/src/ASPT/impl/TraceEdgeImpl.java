/**
 */
package ASPT.impl;

import ASPT.ASPTPackage;
import ASPT.TraceEdge;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Trace Edge</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ASPT.impl.TraceEdgeImpl#getIds <em>Ids</em>}</li>
 *   <li>{@link ASPT.impl.TraceEdgeImpl#getIdsx <em>Idsx</em>}</li>
 *   <li>{@link ASPT.impl.TraceEdgeImpl#getIdt <em>Idt</em>}</li>
 *   <li>{@link ASPT.impl.TraceEdgeImpl#getIdtx <em>Idtx</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TraceEdgeImpl extends TraceElementImpl implements TraceEdge {
	/**
	 * The default value of the '{@link #getIds() <em>Ids</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIds()
	 * @generated
	 * @ordered
	 */
	protected static final String IDS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIds() <em>Ids</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIds()
	 * @generated
	 * @ordered
	 */
	protected String ids = IDS_EDEFAULT;

	/**
	 * The default value of the '{@link #getIdsx() <em>Idsx</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdsx()
	 * @generated
	 * @ordered
	 */
	protected static final String IDSX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIdsx() <em>Idsx</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdsx()
	 * @generated
	 * @ordered
	 */
	protected String idsx = IDSX_EDEFAULT;

	/**
	 * The default value of the '{@link #getIdt() <em>Idt</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdt()
	 * @generated
	 * @ordered
	 */
	protected static final String IDT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIdt() <em>Idt</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdt()
	 * @generated
	 * @ordered
	 */
	protected String idt = IDT_EDEFAULT;

	/**
	 * The default value of the '{@link #getIdtx() <em>Idtx</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdtx()
	 * @generated
	 * @ordered
	 */
	protected static final String IDTX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIdtx() <em>Idtx</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdtx()
	 * @generated
	 * @ordered
	 */
	protected String idtx = IDTX_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TraceEdgeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ASPTPackage.Literals.TRACE_EDGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIds() {
		return ids;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIds(String newIds) {
		String oldIds = ids;
		ids = newIds;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ASPTPackage.TRACE_EDGE__IDS, oldIds, ids));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIdsx() {
		return idsx;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdsx(String newIdsx) {
		String oldIdsx = idsx;
		idsx = newIdsx;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ASPTPackage.TRACE_EDGE__IDSX, oldIdsx, idsx));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIdt() {
		return idt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdt(String newIdt) {
		String oldIdt = idt;
		idt = newIdt;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ASPTPackage.TRACE_EDGE__IDT, oldIdt, idt));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIdtx() {
		return idtx;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdtx(String newIdtx) {
		String oldIdtx = idtx;
		idtx = newIdtx;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ASPTPackage.TRACE_EDGE__IDTX, oldIdtx, idtx));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ASPTPackage.TRACE_EDGE__IDS:
				return getIds();
			case ASPTPackage.TRACE_EDGE__IDSX:
				return getIdsx();
			case ASPTPackage.TRACE_EDGE__IDT:
				return getIdt();
			case ASPTPackage.TRACE_EDGE__IDTX:
				return getIdtx();
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
			case ASPTPackage.TRACE_EDGE__IDS:
				setIds((String)newValue);
				return;
			case ASPTPackage.TRACE_EDGE__IDSX:
				setIdsx((String)newValue);
				return;
			case ASPTPackage.TRACE_EDGE__IDT:
				setIdt((String)newValue);
				return;
			case ASPTPackage.TRACE_EDGE__IDTX:
				setIdtx((String)newValue);
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
			case ASPTPackage.TRACE_EDGE__IDS:
				setIds(IDS_EDEFAULT);
				return;
			case ASPTPackage.TRACE_EDGE__IDSX:
				setIdsx(IDSX_EDEFAULT);
				return;
			case ASPTPackage.TRACE_EDGE__IDT:
				setIdt(IDT_EDEFAULT);
				return;
			case ASPTPackage.TRACE_EDGE__IDTX:
				setIdtx(IDTX_EDEFAULT);
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
			case ASPTPackage.TRACE_EDGE__IDS:
				return IDS_EDEFAULT == null ? ids != null : !IDS_EDEFAULT.equals(ids);
			case ASPTPackage.TRACE_EDGE__IDSX:
				return IDSX_EDEFAULT == null ? idsx != null : !IDSX_EDEFAULT.equals(idsx);
			case ASPTPackage.TRACE_EDGE__IDT:
				return IDT_EDEFAULT == null ? idt != null : !IDT_EDEFAULT.equals(idt);
			case ASPTPackage.TRACE_EDGE__IDTX:
				return IDTX_EDEFAULT == null ? idtx != null : !IDTX_EDEFAULT.equals(idtx);
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
		result.append(" (ids: ");
		result.append(ids);
		result.append(", idsx: ");
		result.append(idsx);
		result.append(", idt: ");
		result.append(idt);
		result.append(", idtx: ");
		result.append(idtx);
		result.append(')');
		return result.toString();
	}

} //TraceEdgeImpl
