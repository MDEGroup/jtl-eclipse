/**
 */
package JTL.essentialocl.util;

import JTL.emof.DataType;
import JTL.emof.Element;
import JTL.emof.NamedElement;
import JTL.emof.Type;
import JTL.emof.TypedElement;

import JTL.essentialocl.*;

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
 * @see JTL.essentialocl.EssentialoclPackage
 * @generated
 */
public class EssentialoclSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EssentialoclPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EssentialoclSwitch() {
		if (modelPackage == null) {
			modelPackage = EssentialoclPackage.eINSTANCE;
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
			case EssentialoclPackage.BOOLEAN_LITERAL_EXP: {
				BooleanLiteralExp booleanLiteralExp = (BooleanLiteralExp)theEObject;
				T result = caseBooleanLiteralExp(booleanLiteralExp);
				if (result == null) result = casePrimitiveLiteralExp(booleanLiteralExp);
				if (result == null) result = caseLiteralExp(booleanLiteralExp);
				if (result == null) result = caseOclExpression(booleanLiteralExp);
				if (result == null) result = caseTypedElement(booleanLiteralExp);
				if (result == null) result = caseNamedElement(booleanLiteralExp);
				if (result == null) result = caseElement(booleanLiteralExp);
				if (result == null) result = caseObject(booleanLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialoclPackage.CALL_EXP: {
				CallExp callExp = (CallExp)theEObject;
				T result = caseCallExp(callExp);
				if (result == null) result = caseOclExpression(callExp);
				if (result == null) result = caseTypedElement(callExp);
				if (result == null) result = caseNamedElement(callExp);
				if (result == null) result = caseElement(callExp);
				if (result == null) result = caseObject(callExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialoclPackage.OCL_EXPRESSION: {
				OclExpression oclExpression = (OclExpression)theEObject;
				T result = caseOclExpression(oclExpression);
				if (result == null) result = caseTypedElement(oclExpression);
				if (result == null) result = caseNamedElement(oclExpression);
				if (result == null) result = caseElement(oclExpression);
				if (result == null) result = caseObject(oclExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialoclPackage.UNLIMITED_NATURAL_EXP: {
				UnlimitedNaturalExp unlimitedNaturalExp = (UnlimitedNaturalExp)theEObject;
				T result = caseUnlimitedNaturalExp(unlimitedNaturalExp);
				if (result == null) result = caseNumericLiteralExp(unlimitedNaturalExp);
				if (result == null) result = casePrimitiveLiteralExp(unlimitedNaturalExp);
				if (result == null) result = caseLiteralExp(unlimitedNaturalExp);
				if (result == null) result = caseOclExpression(unlimitedNaturalExp);
				if (result == null) result = caseTypedElement(unlimitedNaturalExp);
				if (result == null) result = caseNamedElement(unlimitedNaturalExp);
				if (result == null) result = caseElement(unlimitedNaturalExp);
				if (result == null) result = caseObject(unlimitedNaturalExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialoclPackage.IF_EXP: {
				IfExp ifExp = (IfExp)theEObject;
				T result = caseIfExp(ifExp);
				if (result == null) result = caseOclExpression(ifExp);
				if (result == null) result = caseTypedElement(ifExp);
				if (result == null) result = caseNamedElement(ifExp);
				if (result == null) result = caseElement(ifExp);
				if (result == null) result = caseObject(ifExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialoclPackage.LET_EXP: {
				LetExp letExp = (LetExp)theEObject;
				T result = caseLetExp(letExp);
				if (result == null) result = caseOclExpression(letExp);
				if (result == null) result = caseTypedElement(letExp);
				if (result == null) result = caseNamedElement(letExp);
				if (result == null) result = caseElement(letExp);
				if (result == null) result = caseObject(letExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialoclPackage.VARIABLE: {
				Variable variable = (Variable)theEObject;
				T result = caseVariable(variable);
				if (result == null) result = caseTypedElement(variable);
				if (result == null) result = caseNamedElement(variable);
				if (result == null) result = caseElement(variable);
				if (result == null) result = caseObject(variable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialoclPackage.PROPERTY_CALL_EXP: {
				PropertyCallExp propertyCallExp = (PropertyCallExp)theEObject;
				T result = casePropertyCallExp(propertyCallExp);
				if (result == null) result = caseFeaturePropertyCall(propertyCallExp);
				if (result == null) result = caseCallExp(propertyCallExp);
				if (result == null) result = caseOclExpression(propertyCallExp);
				if (result == null) result = caseTypedElement(propertyCallExp);
				if (result == null) result = caseNamedElement(propertyCallExp);
				if (result == null) result = caseElement(propertyCallExp);
				if (result == null) result = caseObject(propertyCallExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialoclPackage.VARIABLE_EXP: {
				VariableExp variableExp = (VariableExp)theEObject;
				T result = caseVariableExp(variableExp);
				if (result == null) result = caseOclExpression(variableExp);
				if (result == null) result = caseTypedElement(variableExp);
				if (result == null) result = caseNamedElement(variableExp);
				if (result == null) result = caseElement(variableExp);
				if (result == null) result = caseObject(variableExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialoclPackage.TYPE_EXP: {
				TypeExp typeExp = (TypeExp)theEObject;
				T result = caseTypeExp(typeExp);
				if (result == null) result = caseOclExpression(typeExp);
				if (result == null) result = caseTypedElement(typeExp);
				if (result == null) result = caseNamedElement(typeExp);
				if (result == null) result = caseElement(typeExp);
				if (result == null) result = caseObject(typeExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialoclPackage.LOOP_EXP: {
				LoopExp loopExp = (LoopExp)theEObject;
				T result = caseLoopExp(loopExp);
				if (result == null) result = caseCallExp(loopExp);
				if (result == null) result = caseOclExpression(loopExp);
				if (result == null) result = caseTypedElement(loopExp);
				if (result == null) result = caseNamedElement(loopExp);
				if (result == null) result = caseElement(loopExp);
				if (result == null) result = caseObject(loopExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialoclPackage.ITERATOR_EXP: {
				IteratorExp iteratorExp = (IteratorExp)theEObject;
				T result = caseIteratorExp(iteratorExp);
				if (result == null) result = caseLoopExp(iteratorExp);
				if (result == null) result = caseCallExp(iteratorExp);
				if (result == null) result = caseOclExpression(iteratorExp);
				if (result == null) result = caseTypedElement(iteratorExp);
				if (result == null) result = caseNamedElement(iteratorExp);
				if (result == null) result = caseElement(iteratorExp);
				if (result == null) result = caseObject(iteratorExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialoclPackage.STRING_LITERAL_EXP: {
				StringLiteralExp stringLiteralExp = (StringLiteralExp)theEObject;
				T result = caseStringLiteralExp(stringLiteralExp);
				if (result == null) result = casePrimitiveLiteralExp(stringLiteralExp);
				if (result == null) result = caseLiteralExp(stringLiteralExp);
				if (result == null) result = caseOclExpression(stringLiteralExp);
				if (result == null) result = caseTypedElement(stringLiteralExp);
				if (result == null) result = caseNamedElement(stringLiteralExp);
				if (result == null) result = caseElement(stringLiteralExp);
				if (result == null) result = caseObject(stringLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialoclPackage.INTEGER_LITERAL_EXP: {
				IntegerLiteralExp integerLiteralExp = (IntegerLiteralExp)theEObject;
				T result = caseIntegerLiteralExp(integerLiteralExp);
				if (result == null) result = caseNumericLiteralExp(integerLiteralExp);
				if (result == null) result = casePrimitiveLiteralExp(integerLiteralExp);
				if (result == null) result = caseLiteralExp(integerLiteralExp);
				if (result == null) result = caseOclExpression(integerLiteralExp);
				if (result == null) result = caseTypedElement(integerLiteralExp);
				if (result == null) result = caseNamedElement(integerLiteralExp);
				if (result == null) result = caseElement(integerLiteralExp);
				if (result == null) result = caseObject(integerLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialoclPackage.OPERATION_CALL_EXP: {
				OperationCallExp operationCallExp = (OperationCallExp)theEObject;
				T result = caseOperationCallExp(operationCallExp);
				if (result == null) result = caseFeaturePropertyCall(operationCallExp);
				if (result == null) result = caseCallExp(operationCallExp);
				if (result == null) result = caseOclExpression(operationCallExp);
				if (result == null) result = caseTypedElement(operationCallExp);
				if (result == null) result = caseNamedElement(operationCallExp);
				if (result == null) result = caseElement(operationCallExp);
				if (result == null) result = caseObject(operationCallExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialoclPackage.REAL_LITERAL_EXP: {
				RealLiteralExp realLiteralExp = (RealLiteralExp)theEObject;
				T result = caseRealLiteralExp(realLiteralExp);
				if (result == null) result = caseNumericLiteralExp(realLiteralExp);
				if (result == null) result = casePrimitiveLiteralExp(realLiteralExp);
				if (result == null) result = caseLiteralExp(realLiteralExp);
				if (result == null) result = caseOclExpression(realLiteralExp);
				if (result == null) result = caseTypedElement(realLiteralExp);
				if (result == null) result = caseNamedElement(realLiteralExp);
				if (result == null) result = caseElement(realLiteralExp);
				if (result == null) result = caseObject(realLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialoclPackage.LITERAL_EXP: {
				LiteralExp literalExp = (LiteralExp)theEObject;
				T result = caseLiteralExp(literalExp);
				if (result == null) result = caseOclExpression(literalExp);
				if (result == null) result = caseTypedElement(literalExp);
				if (result == null) result = caseNamedElement(literalExp);
				if (result == null) result = caseElement(literalExp);
				if (result == null) result = caseObject(literalExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialoclPackage.ITERATE_EXP: {
				IterateExp iterateExp = (IterateExp)theEObject;
				T result = caseIterateExp(iterateExp);
				if (result == null) result = caseLoopExp(iterateExp);
				if (result == null) result = caseCallExp(iterateExp);
				if (result == null) result = caseOclExpression(iterateExp);
				if (result == null) result = caseTypedElement(iterateExp);
				if (result == null) result = caseNamedElement(iterateExp);
				if (result == null) result = caseElement(iterateExp);
				if (result == null) result = caseObject(iterateExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialoclPackage.PRIMITIVE_LITERAL_EXP: {
				PrimitiveLiteralExp primitiveLiteralExp = (PrimitiveLiteralExp)theEObject;
				T result = casePrimitiveLiteralExp(primitiveLiteralExp);
				if (result == null) result = caseLiteralExp(primitiveLiteralExp);
				if (result == null) result = caseOclExpression(primitiveLiteralExp);
				if (result == null) result = caseTypedElement(primitiveLiteralExp);
				if (result == null) result = caseNamedElement(primitiveLiteralExp);
				if (result == null) result = caseElement(primitiveLiteralExp);
				if (result == null) result = caseObject(primitiveLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialoclPackage.NUMERIC_LITERAL_EXP: {
				NumericLiteralExp numericLiteralExp = (NumericLiteralExp)theEObject;
				T result = caseNumericLiteralExp(numericLiteralExp);
				if (result == null) result = casePrimitiveLiteralExp(numericLiteralExp);
				if (result == null) result = caseLiteralExp(numericLiteralExp);
				if (result == null) result = caseOclExpression(numericLiteralExp);
				if (result == null) result = caseTypedElement(numericLiteralExp);
				if (result == null) result = caseNamedElement(numericLiteralExp);
				if (result == null) result = caseElement(numericLiteralExp);
				if (result == null) result = caseObject(numericLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialoclPackage.COLLECTION_LITERAL_EXP: {
				CollectionLiteralExp collectionLiteralExp = (CollectionLiteralExp)theEObject;
				T result = caseCollectionLiteralExp(collectionLiteralExp);
				if (result == null) result = caseLiteralExp(collectionLiteralExp);
				if (result == null) result = caseOclExpression(collectionLiteralExp);
				if (result == null) result = caseTypedElement(collectionLiteralExp);
				if (result == null) result = caseNamedElement(collectionLiteralExp);
				if (result == null) result = caseElement(collectionLiteralExp);
				if (result == null) result = caseObject(collectionLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialoclPackage.COLLECTION_LITERAL_PART: {
				CollectionLiteralPart collectionLiteralPart = (CollectionLiteralPart)theEObject;
				T result = caseCollectionLiteralPart(collectionLiteralPart);
				if (result == null) result = caseTypedElement(collectionLiteralPart);
				if (result == null) result = caseNamedElement(collectionLiteralPart);
				if (result == null) result = caseElement(collectionLiteralPart);
				if (result == null) result = caseObject(collectionLiteralPart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialoclPackage.COLLECTION_ITEM: {
				CollectionItem collectionItem = (CollectionItem)theEObject;
				T result = caseCollectionItem(collectionItem);
				if (result == null) result = caseCollectionLiteralPart(collectionItem);
				if (result == null) result = caseTypedElement(collectionItem);
				if (result == null) result = caseNamedElement(collectionItem);
				if (result == null) result = caseElement(collectionItem);
				if (result == null) result = caseObject(collectionItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialoclPackage.COLLECTION_RANGE: {
				CollectionRange collectionRange = (CollectionRange)theEObject;
				T result = caseCollectionRange(collectionRange);
				if (result == null) result = caseCollectionLiteralPart(collectionRange);
				if (result == null) result = caseTypedElement(collectionRange);
				if (result == null) result = caseNamedElement(collectionRange);
				if (result == null) result = caseElement(collectionRange);
				if (result == null) result = caseObject(collectionRange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialoclPackage.TUPLE_LITERAL_EXP: {
				TupleLiteralExp tupleLiteralExp = (TupleLiteralExp)theEObject;
				T result = caseTupleLiteralExp(tupleLiteralExp);
				if (result == null) result = caseLiteralExp(tupleLiteralExp);
				if (result == null) result = caseOclExpression(tupleLiteralExp);
				if (result == null) result = caseTypedElement(tupleLiteralExp);
				if (result == null) result = caseNamedElement(tupleLiteralExp);
				if (result == null) result = caseElement(tupleLiteralExp);
				if (result == null) result = caseObject(tupleLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialoclPackage.NULL_LITERAL_EXP: {
				NullLiteralExp nullLiteralExp = (NullLiteralExp)theEObject;
				T result = caseNullLiteralExp(nullLiteralExp);
				if (result == null) result = caseLiteralExp(nullLiteralExp);
				if (result == null) result = caseOclExpression(nullLiteralExp);
				if (result == null) result = caseTypedElement(nullLiteralExp);
				if (result == null) result = caseNamedElement(nullLiteralExp);
				if (result == null) result = caseElement(nullLiteralExp);
				if (result == null) result = caseObject(nullLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialoclPackage.EXPRESSION_IN_OCL: {
				ExpressionInOcl expressionInOcl = (ExpressionInOcl)theEObject;
				T result = caseExpressionInOcl(expressionInOcl);
				if (result == null) result = caseOpaqueExpression(expressionInOcl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialoclPackage.OPAQUE_EXPRESSION: {
				OpaqueExpression opaqueExpression = (OpaqueExpression)theEObject;
				T result = caseOpaqueExpression(opaqueExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialoclPackage.INVALID_LITERAL_EXP: {
				InvalidLiteralExp invalidLiteralExp = (InvalidLiteralExp)theEObject;
				T result = caseInvalidLiteralExp(invalidLiteralExp);
				if (result == null) result = caseLiteralExp(invalidLiteralExp);
				if (result == null) result = caseOclExpression(invalidLiteralExp);
				if (result == null) result = caseTypedElement(invalidLiteralExp);
				if (result == null) result = caseNamedElement(invalidLiteralExp);
				if (result == null) result = caseElement(invalidLiteralExp);
				if (result == null) result = caseObject(invalidLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialoclPackage.FEATURE_PROPERTY_CALL: {
				FeaturePropertyCall featurePropertyCall = (FeaturePropertyCall)theEObject;
				T result = caseFeaturePropertyCall(featurePropertyCall);
				if (result == null) result = caseCallExp(featurePropertyCall);
				if (result == null) result = caseOclExpression(featurePropertyCall);
				if (result == null) result = caseTypedElement(featurePropertyCall);
				if (result == null) result = caseNamedElement(featurePropertyCall);
				if (result == null) result = caseElement(featurePropertyCall);
				if (result == null) result = caseObject(featurePropertyCall);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialoclPackage.TUPLE_LITERAL_PART: {
				TupleLiteralPart tupleLiteralPart = (TupleLiteralPart)theEObject;
				T result = caseTupleLiteralPart(tupleLiteralPart);
				if (result == null) result = caseTypedElement(tupleLiteralPart);
				if (result == null) result = caseNamedElement(tupleLiteralPart);
				if (result == null) result = caseElement(tupleLiteralPart);
				if (result == null) result = caseObject(tupleLiteralPart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialoclPackage.BAG_TYPE: {
				BagType bagType = (BagType)theEObject;
				T result = caseBagType(bagType);
				if (result == null) result = caseCollectionType(bagType);
				if (result == null) result = caseDataType(bagType);
				if (result == null) result = caseType(bagType);
				if (result == null) result = caseNamedElement(bagType);
				if (result == null) result = caseElement(bagType);
				if (result == null) result = caseObject(bagType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialoclPackage.COLLECTION_TYPE: {
				CollectionType collectionType = (CollectionType)theEObject;
				T result = caseCollectionType(collectionType);
				if (result == null) result = caseDataType(collectionType);
				if (result == null) result = caseType(collectionType);
				if (result == null) result = caseNamedElement(collectionType);
				if (result == null) result = caseElement(collectionType);
				if (result == null) result = caseObject(collectionType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialoclPackage.ENUM_LITERAL_EXP: {
				EnumLiteralExp enumLiteralExp = (EnumLiteralExp)theEObject;
				T result = caseEnumLiteralExp(enumLiteralExp);
				if (result == null) result = caseLiteralExp(enumLiteralExp);
				if (result == null) result = caseOclExpression(enumLiteralExp);
				if (result == null) result = caseTypedElement(enumLiteralExp);
				if (result == null) result = caseNamedElement(enumLiteralExp);
				if (result == null) result = caseElement(enumLiteralExp);
				if (result == null) result = caseObject(enumLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialoclPackage.INVALID_TYPE: {
				InvalidType invalidType = (InvalidType)theEObject;
				T result = caseInvalidType(invalidType);
				if (result == null) result = caseType(invalidType);
				if (result == null) result = caseNamedElement(invalidType);
				if (result == null) result = caseElement(invalidType);
				if (result == null) result = caseObject(invalidType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialoclPackage.ORDERED_SET_TYPE: {
				OrderedSetType orderedSetType = (OrderedSetType)theEObject;
				T result = caseOrderedSetType(orderedSetType);
				if (result == null) result = caseCollectionType(orderedSetType);
				if (result == null) result = caseDataType(orderedSetType);
				if (result == null) result = caseType(orderedSetType);
				if (result == null) result = caseNamedElement(orderedSetType);
				if (result == null) result = caseElement(orderedSetType);
				if (result == null) result = caseObject(orderedSetType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialoclPackage.SEQUENCE_TYPE: {
				SequenceType sequenceType = (SequenceType)theEObject;
				T result = caseSequenceType(sequenceType);
				if (result == null) result = caseCollectionType(sequenceType);
				if (result == null) result = caseDataType(sequenceType);
				if (result == null) result = caseType(sequenceType);
				if (result == null) result = caseNamedElement(sequenceType);
				if (result == null) result = caseElement(sequenceType);
				if (result == null) result = caseObject(sequenceType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialoclPackage.SET_TYPE: {
				SetType setType = (SetType)theEObject;
				T result = caseSetType(setType);
				if (result == null) result = caseCollectionType(setType);
				if (result == null) result = caseDataType(setType);
				if (result == null) result = caseType(setType);
				if (result == null) result = caseNamedElement(setType);
				if (result == null) result = caseElement(setType);
				if (result == null) result = caseObject(setType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialoclPackage.TUPLE_TYPE: {
				TupleType tupleType = (TupleType)theEObject;
				T result = caseTupleType(tupleType);
				if (result == null) result = caseClass(tupleType);
				if (result == null) result = caseDataType(tupleType);
				if (result == null) result = caseType(tupleType);
				if (result == null) result = caseNamedElement(tupleType);
				if (result == null) result = caseElement(tupleType);
				if (result == null) result = caseObject(tupleType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialoclPackage.VOID_TYPE: {
				VoidType voidType = (VoidType)theEObject;
				T result = caseVoidType(voidType);
				if (result == null) result = caseType(voidType);
				if (result == null) result = caseNamedElement(voidType);
				if (result == null) result = caseElement(voidType);
				if (result == null) result = caseObject(voidType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialoclPackage.ANY_TYPE: {
				AnyType anyType = (AnyType)theEObject;
				T result = caseAnyType(anyType);
				if (result == null) result = caseClass(anyType);
				if (result == null) result = caseType(anyType);
				if (result == null) result = caseNamedElement(anyType);
				if (result == null) result = caseElement(anyType);
				if (result == null) result = caseObject(anyType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanLiteralExp(BooleanLiteralExp object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Unlimited Natural Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unlimited Natural Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnlimitedNaturalExp(UnlimitedNaturalExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>If Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>If Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfExp(IfExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Let Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Let Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLetExp(LetExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariable(Variable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyCallExp(PropertyCallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableExp(VariableExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeExp(TypeExp object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Iterator Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIteratorExp(IteratorExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringLiteralExp(StringLiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integer Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integer Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntegerLiteralExp(IntegerLiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperationCallExp(OperationCallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Real Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Real Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRealLiteralExp(RealLiteralExp object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Iterate Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Iterate Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIterateExp(IterateExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimitiveLiteralExp(PrimitiveLiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Numeric Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Numeric Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNumericLiteralExp(NumericLiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCollectionLiteralExp(CollectionLiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Literal Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Literal Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCollectionLiteralPart(CollectionLiteralPart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCollectionItem(CollectionItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Range</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Range</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCollectionRange(CollectionRange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tuple Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tuple Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTupleLiteralExp(TupleLiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Null Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Null Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNullLiteralExp(NullLiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression In Ocl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression In Ocl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpressionInOcl(ExpressionInOcl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Opaque Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Opaque Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOpaqueExpression(OpaqueExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Invalid Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Invalid Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInvalidLiteralExp(InvalidLiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Property Call</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Property Call</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeaturePropertyCall(FeaturePropertyCall object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tuple Literal Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tuple Literal Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTupleLiteralPart(TupleLiteralPart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bag Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bag Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBagType(BagType object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Enum Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enum Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumLiteralExp(EnumLiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Invalid Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Invalid Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInvalidType(InvalidType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ordered Set Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ordered Set Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrderedSetType(OrderedSetType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sequence Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequence Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSequenceType(SequenceType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSetType(SetType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tuple Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tuple Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTupleType(TupleType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Void Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Void Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVoidType(VoidType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Any Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Any Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnyType(AnyType object) {
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

} //EssentialoclSwitch
