/**
 */
package JTL.imperativeocl.impl;

import JTL.essentialocl.OclExpression;

import JTL.imperativeocl.AssertExp;
import JTL.imperativeocl.ImperativeoclPackage;
import JTL.imperativeocl.LogExp;
import JTL.imperativeocl.SeverityKind;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assert Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link JTL.imperativeocl.impl.AssertExpImpl#getSeverity <em>Severity</em>}</li>
 *   <li>{@link JTL.imperativeocl.impl.AssertExpImpl#getLog <em>Log</em>}</li>
 *   <li>{@link JTL.imperativeocl.impl.AssertExpImpl#getAssertion <em>Assertion</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AssertExpImpl extends ImperativeExpressionImpl implements AssertExp {
	/**
	 * The default value of the '{@link #getSeverity() <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeverity()
	 * @generated
	 * @ordered
	 */
	protected static final SeverityKind SEVERITY_EDEFAULT = SeverityKind.ERROR;

	/**
	 * The cached value of the '{@link #getSeverity() <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeverity()
	 * @generated
	 * @ordered
	 */
	protected SeverityKind severity = SEVERITY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLog() <em>Log</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLog()
	 * @generated
	 * @ordered
	 */
	protected LogExp log;

	/**
	 * The cached value of the '{@link #getAssertion() <em>Assertion</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssertion()
	 * @generated
	 * @ordered
	 */
	protected OclExpression assertion;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssertExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImperativeoclPackage.Literals.ASSERT_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SeverityKind getSeverity() {
		return severity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSeverity(SeverityKind newSeverity) {
		SeverityKind oldSeverity = severity;
		severity = newSeverity == null ? SEVERITY_EDEFAULT : newSeverity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImperativeoclPackage.ASSERT_EXP__SEVERITY, oldSeverity, severity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogExp getLog() {
		return log;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLog(LogExp newLog, NotificationChain msgs) {
		LogExp oldLog = log;
		log = newLog;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ImperativeoclPackage.ASSERT_EXP__LOG, oldLog, newLog);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLog(LogExp newLog) {
		if (newLog != log) {
			NotificationChain msgs = null;
			if (log != null)
				msgs = ((InternalEObject)log).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ImperativeoclPackage.ASSERT_EXP__LOG, null, msgs);
			if (newLog != null)
				msgs = ((InternalEObject)newLog).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ImperativeoclPackage.ASSERT_EXP__LOG, null, msgs);
			msgs = basicSetLog(newLog, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImperativeoclPackage.ASSERT_EXP__LOG, newLog, newLog));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression getAssertion() {
		return assertion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAssertion(OclExpression newAssertion, NotificationChain msgs) {
		OclExpression oldAssertion = assertion;
		assertion = newAssertion;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ImperativeoclPackage.ASSERT_EXP__ASSERTION, oldAssertion, newAssertion);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssertion(OclExpression newAssertion) {
		if (newAssertion != assertion) {
			NotificationChain msgs = null;
			if (assertion != null)
				msgs = ((InternalEObject)assertion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ImperativeoclPackage.ASSERT_EXP__ASSERTION, null, msgs);
			if (newAssertion != null)
				msgs = ((InternalEObject)newAssertion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ImperativeoclPackage.ASSERT_EXP__ASSERTION, null, msgs);
			msgs = basicSetAssertion(newAssertion, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImperativeoclPackage.ASSERT_EXP__ASSERTION, newAssertion, newAssertion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ImperativeoclPackage.ASSERT_EXP__LOG:
				return basicSetLog(null, msgs);
			case ImperativeoclPackage.ASSERT_EXP__ASSERTION:
				return basicSetAssertion(null, msgs);
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
			case ImperativeoclPackage.ASSERT_EXP__SEVERITY:
				return getSeverity();
			case ImperativeoclPackage.ASSERT_EXP__LOG:
				return getLog();
			case ImperativeoclPackage.ASSERT_EXP__ASSERTION:
				return getAssertion();
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
			case ImperativeoclPackage.ASSERT_EXP__SEVERITY:
				setSeverity((SeverityKind)newValue);
				return;
			case ImperativeoclPackage.ASSERT_EXP__LOG:
				setLog((LogExp)newValue);
				return;
			case ImperativeoclPackage.ASSERT_EXP__ASSERTION:
				setAssertion((OclExpression)newValue);
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
			case ImperativeoclPackage.ASSERT_EXP__SEVERITY:
				setSeverity(SEVERITY_EDEFAULT);
				return;
			case ImperativeoclPackage.ASSERT_EXP__LOG:
				setLog((LogExp)null);
				return;
			case ImperativeoclPackage.ASSERT_EXP__ASSERTION:
				setAssertion((OclExpression)null);
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
			case ImperativeoclPackage.ASSERT_EXP__SEVERITY:
				return severity != SEVERITY_EDEFAULT;
			case ImperativeoclPackage.ASSERT_EXP__LOG:
				return log != null;
			case ImperativeoclPackage.ASSERT_EXP__ASSERTION:
				return assertion != null;
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
		result.append(" (severity: ");
		result.append(severity);
		result.append(')');
		return result.toString();
	}

} //AssertExpImpl
