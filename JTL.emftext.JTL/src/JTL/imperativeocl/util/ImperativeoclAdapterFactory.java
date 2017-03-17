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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see JTL.imperativeocl.ImperativeoclPackage
 * @generated
 */
public class ImperativeoclAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ImperativeoclPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImperativeoclAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ImperativeoclPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImperativeoclSwitch<Adapter> modelSwitch =
		new ImperativeoclSwitch<Adapter>() {
			@Override
			public Adapter caseImperativeIterateExp(ImperativeIterateExp object) {
				return createImperativeIterateExpAdapter();
			}
			@Override
			public Adapter caseAssignExp(AssignExp object) {
				return createAssignExpAdapter();
			}
			@Override
			public Adapter caseBlockExp(BlockExp object) {
				return createBlockExpAdapter();
			}
			@Override
			public Adapter caseSwitchExp(SwitchExp object) {
				return createSwitchExpAdapter();
			}
			@Override
			public Adapter caseVariableInitExp(VariableInitExp object) {
				return createVariableInitExpAdapter();
			}
			@Override
			public Adapter caseWhileExp(WhileExp object) {
				return createWhileExpAdapter();
			}
			@Override
			public Adapter caseComputeExp(ComputeExp object) {
				return createComputeExpAdapter();
			}
			@Override
			public Adapter caseAltExp(AltExp object) {
				return createAltExpAdapter();
			}
			@Override
			public Adapter caseUnlinkExp(UnlinkExp object) {
				return createUnlinkExpAdapter();
			}
			@Override
			public Adapter caseReturnExp(ReturnExp object) {
				return createReturnExpAdapter();
			}
			@Override
			public Adapter caseBreakExp(BreakExp object) {
				return createBreakExpAdapter();
			}
			@Override
			public Adapter caseTryExp(TryExp object) {
				return createTryExpAdapter();
			}
			@Override
			public Adapter caseRaiseExp(RaiseExp object) {
				return createRaiseExpAdapter();
			}
			@Override
			public Adapter caseContinueExp(ContinueExp object) {
				return createContinueExpAdapter();
			}
			@Override
			public Adapter caseForExp(ForExp object) {
				return createForExpAdapter();
			}
			@Override
			public Adapter caseTupleExp(TupleExp object) {
				return createTupleExpAdapter();
			}
			@Override
			public Adapter caseTypedef(Typedef object) {
				return createTypedefAdapter();
			}
			@Override
			public Adapter caseInstantiationExp(InstantiationExp object) {
				return createInstantiationExpAdapter();
			}
			@Override
			public Adapter caseDictionaryType(DictionaryType object) {
				return createDictionaryTypeAdapter();
			}
			@Override
			public Adapter caseDictLiteralExp(DictLiteralExp object) {
				return createDictLiteralExpAdapter();
			}
			@Override
			public Adapter caseDictLiteralPart(DictLiteralPart object) {
				return createDictLiteralPartAdapter();
			}
			@Override
			public Adapter caseTemplateParameterType(TemplateParameterType object) {
				return createTemplateParameterTypeAdapter();
			}
			@Override
			public Adapter caseLogExp(LogExp object) {
				return createLogExpAdapter();
			}
			@Override
			public Adapter caseAssertExp(AssertExp object) {
				return createAssertExpAdapter();
			}
			@Override
			public Adapter caseImperativeLoopExp(ImperativeLoopExp object) {
				return createImperativeLoopExpAdapter();
			}
			@Override
			public Adapter caseCollectorExp(CollectorExp object) {
				return createCollectorExpAdapter();
			}
			@Override
			public Adapter caseImperativeExpression(ImperativeExpression object) {
				return createImperativeExpressionAdapter();
			}
			@Override
			public Adapter caseUnpackExp(UnpackExp object) {
				return createUnpackExpAdapter();
			}
			@Override
			public Adapter caseAnonymousTupleType(AnonymousTupleType object) {
				return createAnonymousTupleTypeAdapter();
			}
			@Override
			public Adapter caseAnonymousTupleLiteralExp(AnonymousTupleLiteralExp object) {
				return createAnonymousTupleLiteralExpAdapter();
			}
			@Override
			public Adapter caseAnonymousTupleLiteralPart(AnonymousTupleLiteralPart object) {
				return createAnonymousTupleLiteralPartAdapter();
			}
			@Override
			public Adapter caseListType(ListType object) {
				return createListTypeAdapter();
			}
			@Override
			public Adapter caseObject(JTL.emof.Object object) {
				return createObjectAdapter();
			}
			@Override
			public Adapter caseElement(Element object) {
				return createElementAdapter();
			}
			@Override
			public Adapter caseNamedElement(NamedElement object) {
				return createNamedElementAdapter();
			}
			@Override
			public Adapter caseTypedElement(TypedElement object) {
				return createTypedElementAdapter();
			}
			@Override
			public Adapter caseOclExpression(OclExpression object) {
				return createOclExpressionAdapter();
			}
			@Override
			public Adapter caseCallExp(CallExp object) {
				return createCallExpAdapter();
			}
			@Override
			public Adapter caseLoopExp(LoopExp object) {
				return createLoopExpAdapter();
			}
			@Override
			public Adapter caseType(Type object) {
				return createTypeAdapter();
			}
			@Override
			public Adapter caseClass(JTL.emof.Class object) {
				return createClassAdapter();
			}
			@Override
			public Adapter caseDataType(DataType object) {
				return createDataTypeAdapter();
			}
			@Override
			public Adapter caseCollectionType(CollectionType object) {
				return createCollectionTypeAdapter();
			}
			@Override
			public Adapter caseLiteralExp(LiteralExp object) {
				return createLiteralExpAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link JTL.imperativeocl.ImperativeIterateExp <em>Imperative Iterate Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see JTL.imperativeocl.ImperativeIterateExp
	 * @generated
	 */
	public Adapter createImperativeIterateExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link JTL.imperativeocl.AssignExp <em>Assign Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see JTL.imperativeocl.AssignExp
	 * @generated
	 */
	public Adapter createAssignExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link JTL.imperativeocl.BlockExp <em>Block Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see JTL.imperativeocl.BlockExp
	 * @generated
	 */
	public Adapter createBlockExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link JTL.imperativeocl.SwitchExp <em>Switch Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see JTL.imperativeocl.SwitchExp
	 * @generated
	 */
	public Adapter createSwitchExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link JTL.imperativeocl.VariableInitExp <em>Variable Init Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see JTL.imperativeocl.VariableInitExp
	 * @generated
	 */
	public Adapter createVariableInitExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link JTL.imperativeocl.WhileExp <em>While Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see JTL.imperativeocl.WhileExp
	 * @generated
	 */
	public Adapter createWhileExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link JTL.imperativeocl.ComputeExp <em>Compute Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see JTL.imperativeocl.ComputeExp
	 * @generated
	 */
	public Adapter createComputeExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link JTL.imperativeocl.AltExp <em>Alt Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see JTL.imperativeocl.AltExp
	 * @generated
	 */
	public Adapter createAltExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link JTL.imperativeocl.UnlinkExp <em>Unlink Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see JTL.imperativeocl.UnlinkExp
	 * @generated
	 */
	public Adapter createUnlinkExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link JTL.imperativeocl.ReturnExp <em>Return Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see JTL.imperativeocl.ReturnExp
	 * @generated
	 */
	public Adapter createReturnExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link JTL.imperativeocl.BreakExp <em>Break Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see JTL.imperativeocl.BreakExp
	 * @generated
	 */
	public Adapter createBreakExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link JTL.imperativeocl.TryExp <em>Try Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see JTL.imperativeocl.TryExp
	 * @generated
	 */
	public Adapter createTryExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link JTL.imperativeocl.RaiseExp <em>Raise Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see JTL.imperativeocl.RaiseExp
	 * @generated
	 */
	public Adapter createRaiseExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link JTL.imperativeocl.ContinueExp <em>Continue Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see JTL.imperativeocl.ContinueExp
	 * @generated
	 */
	public Adapter createContinueExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link JTL.imperativeocl.ForExp <em>For Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see JTL.imperativeocl.ForExp
	 * @generated
	 */
	public Adapter createForExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link JTL.imperativeocl.TupleExp <em>Tuple Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see JTL.imperativeocl.TupleExp
	 * @generated
	 */
	public Adapter createTupleExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link JTL.imperativeocl.Typedef <em>Typedef</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see JTL.imperativeocl.Typedef
	 * @generated
	 */
	public Adapter createTypedefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link JTL.imperativeocl.InstantiationExp <em>Instantiation Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see JTL.imperativeocl.InstantiationExp
	 * @generated
	 */
	public Adapter createInstantiationExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link JTL.imperativeocl.DictionaryType <em>Dictionary Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see JTL.imperativeocl.DictionaryType
	 * @generated
	 */
	public Adapter createDictionaryTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link JTL.imperativeocl.DictLiteralExp <em>Dict Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see JTL.imperativeocl.DictLiteralExp
	 * @generated
	 */
	public Adapter createDictLiteralExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link JTL.imperativeocl.DictLiteralPart <em>Dict Literal Part</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see JTL.imperativeocl.DictLiteralPart
	 * @generated
	 */
	public Adapter createDictLiteralPartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link JTL.imperativeocl.TemplateParameterType <em>Template Parameter Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see JTL.imperativeocl.TemplateParameterType
	 * @generated
	 */
	public Adapter createTemplateParameterTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link JTL.imperativeocl.LogExp <em>Log Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see JTL.imperativeocl.LogExp
	 * @generated
	 */
	public Adapter createLogExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link JTL.imperativeocl.AssertExp <em>Assert Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see JTL.imperativeocl.AssertExp
	 * @generated
	 */
	public Adapter createAssertExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link JTL.imperativeocl.ImperativeLoopExp <em>Imperative Loop Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see JTL.imperativeocl.ImperativeLoopExp
	 * @generated
	 */
	public Adapter createImperativeLoopExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link JTL.imperativeocl.CollectorExp <em>Collector Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see JTL.imperativeocl.CollectorExp
	 * @generated
	 */
	public Adapter createCollectorExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link JTL.imperativeocl.ImperativeExpression <em>Imperative Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see JTL.imperativeocl.ImperativeExpression
	 * @generated
	 */
	public Adapter createImperativeExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link JTL.imperativeocl.UnpackExp <em>Unpack Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see JTL.imperativeocl.UnpackExp
	 * @generated
	 */
	public Adapter createUnpackExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link JTL.imperativeocl.AnonymousTupleType <em>Anonymous Tuple Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see JTL.imperativeocl.AnonymousTupleType
	 * @generated
	 */
	public Adapter createAnonymousTupleTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link JTL.imperativeocl.AnonymousTupleLiteralExp <em>Anonymous Tuple Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see JTL.imperativeocl.AnonymousTupleLiteralExp
	 * @generated
	 */
	public Adapter createAnonymousTupleLiteralExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link JTL.imperativeocl.AnonymousTupleLiteralPart <em>Anonymous Tuple Literal Part</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see JTL.imperativeocl.AnonymousTupleLiteralPart
	 * @generated
	 */
	public Adapter createAnonymousTupleLiteralPartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link JTL.imperativeocl.ListType <em>List Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see JTL.imperativeocl.ListType
	 * @generated
	 */
	public Adapter createListTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link JTL.emof.Object <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see JTL.emof.Object
	 * @generated
	 */
	public Adapter createObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link JTL.emof.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see JTL.emof.Element
	 * @generated
	 */
	public Adapter createElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link JTL.emof.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see JTL.emof.NamedElement
	 * @generated
	 */
	public Adapter createNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link JTL.emof.TypedElement <em>Typed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see JTL.emof.TypedElement
	 * @generated
	 */
	public Adapter createTypedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link JTL.essentialocl.OclExpression <em>Ocl Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see JTL.essentialocl.OclExpression
	 * @generated
	 */
	public Adapter createOclExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link JTL.essentialocl.CallExp <em>Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see JTL.essentialocl.CallExp
	 * @generated
	 */
	public Adapter createCallExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link JTL.essentialocl.LoopExp <em>Loop Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see JTL.essentialocl.LoopExp
	 * @generated
	 */
	public Adapter createLoopExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link JTL.emof.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see JTL.emof.Type
	 * @generated
	 */
	public Adapter createTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link JTL.emof.Class <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see JTL.emof.Class
	 * @generated
	 */
	public Adapter createClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link JTL.emof.DataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see JTL.emof.DataType
	 * @generated
	 */
	public Adapter createDataTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link JTL.essentialocl.CollectionType <em>Collection Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see JTL.essentialocl.CollectionType
	 * @generated
	 */
	public Adapter createCollectionTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link JTL.essentialocl.LiteralExp <em>Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see JTL.essentialocl.LiteralExp
	 * @generated
	 */
	public Adapter createLiteralExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ImperativeoclAdapterFactory
