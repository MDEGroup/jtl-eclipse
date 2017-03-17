/**
 */
package JTL.imperativeocl.util;

import JTL.emof.DataType;
import JTL.emof.Element;
import JTL.emof.NamedElement;
import JTL.emof.Type;
import JTL.emof.TypedElement;

import JTL.essentialocl.CallExp;
import JTL.essentialocl.CollectionType;
import JTL.essentialocl.LiteralExp;
import JTL.essentialocl.LoopExp;
import JTL.essentialocl.OclExpression;

import JTL.imperativeocl.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see JTL.imperativeocl.ImperativeoclPackage
 * @generated
 */
public class ImperativeoclSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ImperativeoclPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImperativeoclSwitch() {
		if (modelPackage == null) {
			modelPackage = ImperativeoclPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ImperativeoclPackage.IMPERATIVE_ITERATE_EXP: {
				ImperativeIterateExp imperativeIterateExp = (ImperativeIterateExp)theEObject;
				T result = caseImperativeIterateExp(imperativeIterateExp);
				if (result == null) result = caseImperativeLoopExp(imperativeIterateExp);
				if (result == null) result = caseLoopExp(imperativeIterateExp);
				if (result == null) result = caseImperativeExpression(imperativeIterateExp);
				if (result == null) result = caseCallExp(imperativeIterateExp);
				if (result == null) result = caseOclExpression(imperativeIterateExp);
				if (result == null) result = caseTypedElement(imperativeIterateExp);
				if (result == null) result = caseNamedElement(imperativeIterateExp);
				if (result == null) result = caseElement(imperativeIterateExp);
				if (result == null) result = caseObject(imperativeIterateExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeoclPackage.ASSIGN_EXP: {
				AssignExp assignExp = (AssignExp)theEObject;
				T result = caseAssignExp(assignExp);
				if (result == null) result = caseImperativeExpression(assignExp);
				if (result == null) result = caseOclExpression(assignExp);
				if (result == null) result = caseTypedElement(assignExp);
				if (result == null) result = caseNamedElement(assignExp);
				if (result == null) result = caseElement(assignExp);
				if (result == null) result = caseObject(assignExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeoclPackage.BLOCK_EXP: {
				BlockExp blockExp = (BlockExp)theEObject;
				T result = caseBlockExp(blockExp);
				if (result == null) result = caseImperativeExpression(blockExp);
				if (result == null) result = caseOclExpression(blockExp);
				if (result == null) result = caseTypedElement(blockExp);
				if (result == null) result = caseNamedElement(blockExp);
				if (result == null) result = caseElement(blockExp);
				if (result == null) result = caseObject(blockExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeoclPackage.SWITCH_EXP: {
				SwitchExp switchExp = (SwitchExp)theEObject;
				T result = caseSwitchExp(switchExp);
				if (result == null) result = caseCallExp(switchExp);
				if (result == null) result = caseImperativeExpression(switchExp);
				if (result == null) result = caseOclExpression(switchExp);
				if (result == null) result = caseTypedElement(switchExp);
				if (result == null) result = caseNamedElement(switchExp);
				if (result == null) result = caseElement(switchExp);
				if (result == null) result = caseObject(switchExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeoclPackage.VARIABLE_INIT_EXP: {
				VariableInitExp variableInitExp = (VariableInitExp)theEObject;
				T result = caseVariableInitExp(variableInitExp);
				if (result == null) result = caseImperativeExpression(variableInitExp);
				if (result == null) result = caseOclExpression(variableInitExp);
				if (result == null) result = caseTypedElement(variableInitExp);
				if (result == null) result = caseNamedElement(variableInitExp);
				if (result == null) result = caseElement(variableInitExp);
				if (result == null) result = caseObject(variableInitExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeoclPackage.WHILE_EXP: {
				WhileExp whileExp = (WhileExp)theEObject;
				T result = caseWhileExp(whileExp);
				if (result == null) result = caseImperativeExpression(whileExp);
				if (result == null) result = caseOclExpression(whileExp);
				if (result == null) result = caseTypedElement(whileExp);
				if (result == null) result = caseNamedElement(whileExp);
				if (result == null) result = caseElement(whileExp);
				if (result == null) result = caseObject(whileExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeoclPackage.COMPUTE_EXP: {
				ComputeExp computeExp = (ComputeExp)theEObject;
				T result = caseComputeExp(computeExp);
				if (result == null) result = caseImperativeExpression(computeExp);
				if (result == null) result = caseOclExpression(computeExp);
				if (result == null) result = caseTypedElement(computeExp);
				if (result == null) result = caseNamedElement(computeExp);
				if (result == null) result = caseElement(computeExp);
				if (result == null) result = caseObject(computeExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeoclPackage.ALT_EXP: {
				AltExp altExp = (AltExp)theEObject;
				T result = caseAltExp(altExp);
				if (result == null) result = caseImperativeExpression(altExp);
				if (result == null) result = caseOclExpression(altExp);
				if (result == null) result = caseTypedElement(altExp);
				if (result == null) result = caseNamedElement(altExp);
				if (result == null) result = caseElement(altExp);
				if (result == null) result = caseObject(altExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeoclPackage.UNLINK_EXP: {
				UnlinkExp unlinkExp = (UnlinkExp)theEObject;
				T result = caseUnlinkExp(unlinkExp);
				if (result == null) result = caseImperativeExpression(unlinkExp);
				if (result == null) result = caseOclExpression(unlinkExp);
				if (result == null) result = caseTypedElement(unlinkExp);
				if (result == null) result = caseNamedElement(unlinkExp);
				if (result == null) result = caseElement(unlinkExp);
				if (result == null) result = caseObject(unlinkExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeoclPackage.RETURN_EXP: {
				ReturnExp returnExp = (ReturnExp)theEObject;
				T result = caseReturnExp(returnExp);
				if (result == null) result = caseImperativeExpression(returnExp);
				if (result == null) result = caseOclExpression(returnExp);
				if (result == null) result = caseTypedElement(returnExp);
				if (result == null) result = caseNamedElement(returnExp);
				if (result == null) result = caseElement(returnExp);
				if (result == null) result = caseObject(returnExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeoclPackage.BREAK_EXP: {
				BreakExp breakExp = (BreakExp)theEObject;
				T result = caseBreakExp(breakExp);
				if (result == null) result = caseImperativeExpression(breakExp);
				if (result == null) result = caseOclExpression(breakExp);
				if (result == null) result = caseTypedElement(breakExp);
				if (result == null) result = caseNamedElement(breakExp);
				if (result == null) result = caseElement(breakExp);
				if (result == null) result = caseObject(breakExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeoclPackage.TRY_EXP: {
				TryExp tryExp = (TryExp)theEObject;
				T result = caseTryExp(tryExp);
				if (result == null) result = caseImperativeExpression(tryExp);
				if (result == null) result = caseOclExpression(tryExp);
				if (result == null) result = caseTypedElement(tryExp);
				if (result == null) result = caseNamedElement(tryExp);
				if (result == null) result = caseElement(tryExp);
				if (result == null) result = caseObject(tryExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeoclPackage.RAISE_EXP: {
				RaiseExp raiseExp = (RaiseExp)theEObject;
				T result = caseRaiseExp(raiseExp);
				if (result == null) result = caseImperativeExpression(raiseExp);
				if (result == null) result = caseOclExpression(raiseExp);
				if (result == null) result = caseTypedElement(raiseExp);
				if (result == null) result = caseNamedElement(raiseExp);
				if (result == null) result = caseElement(raiseExp);
				if (result == null) result = caseObject(raiseExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeoclPackage.CONTINUE_EXP: {
				ContinueExp continueExp = (ContinueExp)theEObject;
				T result = caseContinueExp(continueExp);
				if (result == null) result = caseImperativeExpression(continueExp);
				if (result == null) result = caseOclExpression(continueExp);
				if (result == null) result = caseTypedElement(continueExp);
				if (result == null) result = caseNamedElement(continueExp);
				if (result == null) result = caseElement(continueExp);
				if (result == null) result = caseObject(continueExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeoclPackage.FOR_EXP: {
				ForExp forExp = (ForExp)theEObject;
				T result = caseForExp(forExp);
				if (result == null) result = caseImperativeLoopExp(forExp);
				if (result == null) result = caseLoopExp(forExp);
				if (result == null) result = caseImperativeExpression(forExp);
				if (result == null) result = caseCallExp(forExp);
				if (result == null) result = caseOclExpression(forExp);
				if (result == null) result = caseTypedElement(forExp);
				if (result == null) result = caseNamedElement(forExp);
				if (result == null) result = caseElement(forExp);
				if (result == null) result = caseObject(forExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeoclPackage.TUPLE_EXP: {
				TupleExp tupleExp = (TupleExp)theEObject;
				T result = caseTupleExp(tupleExp);
				if (result == null) result = caseImperativeExpression(tupleExp);
				if (result == null) result = caseOclExpression(tupleExp);
				if (result == null) result = caseTypedElement(tupleExp);
				if (result == null) result = caseNamedElement(tupleExp);
				if (result == null) result = caseElement(tupleExp);
				if (result == null) result = caseObject(tupleExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeoclPackage.TYPEDEF: {
				Typedef typedef = (Typedef)theEObject;
				T result = caseTypedef(typedef);
				if (result == null) result = caseClass(typedef);
				if (result == null) result = caseType(typedef);
				if (result == null) result = caseNamedElement(typedef);
				if (result == null) result = caseElement(typedef);
				if (result == null) result = caseObject(typedef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeoclPackage.INSTANTIATION_EXP: {
				InstantiationExp instantiationExp = (InstantiationExp)theEObject;
				T result = caseInstantiationExp(instantiationExp);
				if (result == null) result = caseImperativeExpression(instantiationExp);
				if (result == null) result = caseOclExpression(instantiationExp);
				if (result == null) result = caseTypedElement(instantiationExp);
				if (result == null) result = caseNamedElement(instantiationExp);
				if (result == null) result = caseElement(instantiationExp);
				if (result == null) result = caseObject(instantiationExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeoclPackage.DICTIONARY_TYPE: {
				DictionaryType dictionaryType = (DictionaryType)theEObject;
				T result = caseDictionaryType(dictionaryType);
				if (result == null) result = caseCollectionType(dictionaryType);
				if (result == null) result = caseDataType(dictionaryType);
				if (result == null) result = caseType(dictionaryType);
				if (result == null) result = caseNamedElement(dictionaryType);
				if (result == null) result = caseElement(dictionaryType);
				if (result == null) result = caseObject(dictionaryType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeoclPackage.DICT_LITERAL_EXP: {
				DictLiteralExp dictLiteralExp = (DictLiteralExp)theEObject;
				T result = caseDictLiteralExp(dictLiteralExp);
				if (result == null) result = caseLiteralExp(dictLiteralExp);
				if (result == null) result = caseOclExpression(dictLiteralExp);
				if (result == null) result = caseTypedElement(dictLiteralExp);
				if (result == null) result = caseNamedElement(dictLiteralExp);
				if (result == null) result = caseElement(dictLiteralExp);
				if (result == null) result = caseObject(dictLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeoclPackage.DICT_LITERAL_PART: {
				DictLiteralPart dictLiteralPart = (DictLiteralPart)theEObject;
				T result = caseDictLiteralPart(dictLiteralPart);
				if (result == null) result = caseElement(dictLiteralPart);
				if (result == null) result = caseObject(dictLiteralPart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeoclPackage.TEMPLATE_PARAMETER_TYPE: {
				TemplateParameterType templateParameterType = (TemplateParameterType)theEObject;
				T result = caseTemplateParameterType(templateParameterType);
				if (result == null) result = caseType(templateParameterType);
				if (result == null) result = caseNamedElement(templateParameterType);
				if (result == null) result = caseElement(templateParameterType);
				if (result == null) result = caseObject(templateParameterType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeoclPackage.LOG_EXP: {
				LogExp logExp = (LogExp)theEObject;
				T result = caseLogExp(logExp);
				if (result == null) result = caseImperativeExpression(logExp);
				if (result == null) result = caseOclExpression(logExp);
				if (result == null) result = caseTypedElement(logExp);
				if (result == null) result = caseNamedElement(logExp);
				if (result == null) result = caseElement(logExp);
				if (result == null) result = caseObject(logExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeoclPackage.ASSERT_EXP: {
				AssertExp assertExp = (AssertExp)theEObject;
				T result = caseAssertExp(assertExp);
				if (result == null) result = caseImperativeExpression(assertExp);
				if (result == null) result = caseOclExpression(assertExp);
				if (result == null) result = caseTypedElement(assertExp);
				if (result == null) result = caseNamedElement(assertExp);
				if (result == null) result = caseElement(assertExp);
				if (result == null) result = caseObject(assertExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeoclPackage.IMPERATIVE_LOOP_EXP: {
				ImperativeLoopExp imperativeLoopExp = (ImperativeLoopExp)theEObject;
				T result = caseImperativeLoopExp(imperativeLoopExp);
				if (result == null) result = caseLoopExp(imperativeLoopExp);
				if (result == null) result = caseImperativeExpression(imperativeLoopExp);
				if (result == null) result = caseCallExp(imperativeLoopExp);
				if (result == null) result = caseOclExpression(imperativeLoopExp);
				if (result == null) result = caseTypedElement(imperativeLoopExp);
				if (result == null) result = caseNamedElement(imperativeLoopExp);
				if (result == null) result = caseElement(imperativeLoopExp);
				if (result == null) result = caseObject(imperativeLoopExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeoclPackage.COLLECTOR_EXP: {
				CollectorExp collectorExp = (CollectorExp)theEObject;
				T result = caseCollectorExp(collectorExp);
				if (result == null) result = caseImperativeLoopExp(collectorExp);
				if (result == null) result = caseLoopExp(collectorExp);
				if (result == null) result = caseImperativeExpression(collectorExp);
				if (result == null) result = caseCallExp(collectorExp);
				if (result == null) result = caseOclExpression(collectorExp);
				if (result == null) result = caseTypedElement(collectorExp);
				if (result == null) result = caseNamedElement(collectorExp);
				if (result == null) result = caseElement(collectorExp);
				if (result == null) result = caseObject(collectorExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeoclPackage.IMPERATIVE_EXPRESSION: {
				ImperativeExpression imperativeExpression = (ImperativeExpression)theEObject;
				T result = caseImperativeExpression(imperativeExpression);
				if (result == null) result = caseOclExpression(imperativeExpression);
				if (result == null) result = caseTypedElement(imperativeExpression);
				if (result == null) result = caseNamedElement(imperativeExpression);
				if (result == null) result = caseElement(imperativeExpression);
				if (result == null) result = caseObject(imperativeExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeoclPackage.UNPACK_EXP: {
				UnpackExp unpackExp = (UnpackExp)theEObject;
				T result = caseUnpackExp(unpackExp);
				if (result == null) result = caseImperativeExpression(unpackExp);
				if (result == null) result = caseOclExpression(unpackExp);
				if (result == null) result = caseTypedElement(unpackExp);
				if (result == null) result = caseNamedElement(unpackExp);
				if (result == null) result = caseElement(unpackExp);
				if (result == null) result = caseObject(unpackExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeoclPackage.ANONYMOUS_TUPLE_TYPE: {
				AnonymousTupleType anonymousTupleType = (AnonymousTupleType)theEObject;
				T result = caseAnonymousTupleType(anonymousTupleType);
				if (result == null) result = caseClass(anonymousTupleType);
				if (result == null) result = caseType(anonymousTupleType);
				if (result == null) result = caseNamedElement(anonymousTupleType);
				if (result == null) result = caseElement(anonymousTupleType);
				if (result == null) result = caseObject(anonymousTupleType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeoclPackage.ANONYMOUS_TUPLE_LITERAL_EXP: {
				AnonymousTupleLiteralExp anonymousTupleLiteralExp = (AnonymousTupleLiteralExp)theEObject;
				T result = caseAnonymousTupleLiteralExp(anonymousTupleLiteralExp);
				if (result == null) result = caseLiteralExp(anonymousTupleLiteralExp);
				if (result == null) result = caseOclExpression(anonymousTupleLiteralExp);
				if (result == null) result = caseTypedElement(anonymousTupleLiteralExp);
				if (result == null) result = caseNamedElement(anonymousTupleLiteralExp);
				if (result == null) result = caseElement(anonymousTupleLiteralExp);
				if (result == null) result = caseObject(anonymousTupleLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeoclPackage.ANONYMOUS_TUPLE_LITERAL_PART: {
				AnonymousTupleLiteralPart anonymousTupleLiteralPart = (AnonymousTupleLiteralPart)theEObject;
				T result = caseAnonymousTupleLiteralPart(anonymousTupleLiteralPart);
				if (result == null) result = caseElement(anonymousTupleLiteralPart);
				if (result == null) result = caseObject(anonymousTupleLiteralPart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeoclPackage.LIST_TYPE: {
				ListType listType = (ListType)theEObject;
				T result = caseListType(listType);
				if (result == null) result = caseCollectionType(listType);
				if (result == null) result = caseDataType(listType);
				if (result == null) result = caseType(listType);
				if (result == null) result = caseNamedElement(listType);
				if (result == null) result = caseElement(listType);
				if (result == null) result = caseObject(listType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Imperative Iterate Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Imperative Iterate Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImperativeIterateExp(ImperativeIterateExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assign Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assign Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssignExp(AssignExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Block Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Block Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBlockExp(BlockExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Switch Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Switch Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSwitchExp(SwitchExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Init Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Init Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableInitExp(VariableInitExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>While Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>While Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWhileExp(WhileExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compute Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compute Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComputeExp(ComputeExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Alt Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Alt Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAltExp(AltExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unlink Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unlink Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnlinkExp(UnlinkExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Return Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Return Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReturnExp(ReturnExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Break Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Break Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBreakExp(BreakExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Try Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Try Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTryExp(TryExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Raise Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Raise Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRaiseExp(RaiseExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Continue Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Continue Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContinueExp(ContinueExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>For Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>For Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseForExp(ForExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tuple Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tuple Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTupleExp(TupleExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Typedef</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typedef</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypedef(Typedef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Instantiation Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instantiation Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstantiationExp(InstantiationExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dictionary Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dictionary Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDictionaryType(DictionaryType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dict Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dict Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDictLiteralExp(DictLiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dict Literal Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dict Literal Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDictLiteralPart(DictLiteralPart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Template Parameter Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Template Parameter Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTemplateParameterType(TemplateParameterType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Log Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Log Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLogExp(LogExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assert Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assert Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssertExp(AssertExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Imperative Loop Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Imperative Loop Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImperativeLoopExp(ImperativeLoopExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collector Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collector Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCollectorExp(CollectorExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Imperative Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Imperative Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImperativeExpression(ImperativeExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unpack Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unpack Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnpackExp(UnpackExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Anonymous Tuple Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Anonymous Tuple Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnonymousTupleType(AnonymousTupleType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Anonymous Tuple Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Anonymous Tuple Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnonymousTupleLiteralExp(AnonymousTupleLiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Anonymous Tuple Literal Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Anonymous Tuple Literal Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnonymousTupleLiteralPart(AnonymousTupleLiteralPart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>List Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>List Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseListType(ListType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObject(JTL.emof.Object object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElement(Element object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Typed Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typed Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypedElement(TypedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ocl Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ocl Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOclExpression(OclExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCallExp(CallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Loop Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Loop Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLoopExp(LoopExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseType(Type object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClass(JTL.emof.Class object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataType(DataType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCollectionType(CollectionType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralExp(LiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //ImperativeoclSwitch
